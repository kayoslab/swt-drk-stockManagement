/*
 * Copyright (c) - All Rights Reserved
 *
 * Unauthorized copying of these files, via any medium is
 * strictly prohibited Proprietary and confidential
 *
 * NOTICE:
 * All information contained in this project is, and remains the property of the owner and its suppliers, if any.
 * The intellectual and technical concepts contained herein are proprietary to the owner and its suppliers and
 * are protected by trade secret or copyright law. Dissemination of this information or reproduction of this
 * material is strictly forbidden unless prior written permission is obtained by the owner.
 *
 * @author Amina
 * @author Sabine
 *
 */

package presenter.data;
import model.DatabaseReadManager;
import model.Session;
import model.databaseObjects.DatabaseObject;
import model.databaseObjects.stockObjects.*;
import presenter.Presenter;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.PatternSyntaxException;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class DataPresenter extends Presenter implements MouseListener {
	private JTextField searchText;
	private JTable table;
	private StockObject[][] tableData = new StockObject[DatabaseObject.StockObjectType.values().length][];
	private StockObject[] stockObjects;


	/**
	 * Create the application.
	 */
	public DataPresenter(Presenter previousPresenter) {
		this.previousPresenter = previousPresenter;
		this.initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@Override
	public void initialize() {
		super.initialize();
		super.setupTopLayout();

		this.presenterHelpId = 4;
		JLabel MaterialUndGeraeteDaten = new JLabel("Material- und Ger\u00e4te Daten");
		MaterialUndGeraeteDaten.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		MaterialUndGeraeteDaten.setBounds(leftPadding, headlineY, displayAreaWidth, lineHeight);
		frame.getContentPane().add(MaterialUndGeraeteDaten);


		this.searchText = new JTextField();
		this.searchText.setBackground(Color.WHITE);
		this.searchText.setHorizontalAlignment(SwingConstants.CENTER);
		this.searchText.setText("Suchen");
		this.searchText.setToolTipText("Suchen");
		int searchTextX = leftPadding+noSpacing+(characterButtonWidth)*26 + smallSpacing;
		int searchTextWidth = width-searchTextX-rightPadding;
		this.searchText.setBounds(searchTextX, contentY, searchTextWidth, characterButtonHeight);
		this.frame.getContentPane().add(this.searchText);
		this.searchText.setColumns(10);

		this.searchText.addFocusListener(new FocusListener() {
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				searchText.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				// searchText.setText("Suchen");
			}
		});


		JScrollPane scrollPane = new JScrollPane();
		int scrollPaneHeight = height - (contentY + characterButtonHeight + smallSpacing + bottomPadding);
		scrollPane.setBounds(leftPadding, contentY + characterButtonHeight + smallSpacing, displayAreaWidth, scrollPaneHeight);
		this.frame.getContentPane().add(scrollPane);
		this.table = new JTable() {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		this.table.addMouseListener(this);
		scrollPane.setViewportView(this.table);
	}

	@Override
	public void presentData() {
		super.presentData();
		this.loadTableData();
	}

	private void loadTableData() {
		/** Get unsorted Data **/
		if (this.session.currentUserCanHandleGroupRight(Session.PossibleGroupRight.viewDevices)) {
			this.tableData[DatabaseObject.StockObjectType.device.ordinal()] = DatabaseReadManager.generateDataTable(DatabaseObject.StockObjectType.device);
		}
		if (this.session.currentUserCanHandleGroupRight(Session.PossibleGroupRight.viewMedicalMaterials)) {
			this.tableData[DatabaseObject.StockObjectType.medicalMaterial.ordinal()] = DatabaseReadManager.generateDataTable(DatabaseObject.StockObjectType.medicalMaterial);
		}
		if (this.session.currentUserCanHandleGroupRight(Session.PossibleGroupRight.viewConsumableMaterials)) {
			this.tableData[DatabaseObject.StockObjectType.consumableMaterial.ordinal()] = DatabaseReadManager.generateDataTable(DatabaseObject.StockObjectType.consumableMaterial);
		}

		StockObject[] unsortedDevices = this.tableData[DatabaseObject.StockObjectType.device.ordinal()];
		StockObject[] unsortedmedicalMaterials = this.tableData[DatabaseObject.StockObjectType.medicalMaterial.ordinal()];
		StockObject[] unsortedconsumableMaterials = this.tableData[DatabaseObject.StockObjectType.consumableMaterial.ordinal()];
		/** Sort the Data **/
		ArrayList<StockObject> sortedData = new ArrayList<StockObject>();

		if (unsortedDevices != null) {
			sortedData.addAll(Arrays.asList(unsortedDevices));
		}
		if (unsortedmedicalMaterials != null) {
			sortedData.addAll(Arrays.asList(unsortedmedicalMaterials));
		}
		if (unsortedconsumableMaterials != null) {
			sortedData.addAll(Arrays.asList(unsortedconsumableMaterials));
		}

		stockObjects = sortedData.toArray(new StockObject[sortedData.size()]);
		Arrays.sort(stockObjects, (a, b) -> a.title.compareToIgnoreCase(b.title));
		/** New TableModel **/
		this.fillTableWithData();
		/** Sorting Rows **/
		final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.table.getModel());
		this.searchText.getDocument().addDocumentListener(new DocumentListener() {
			private void searchFieldChangedUpdate(DocumentEvent evt) {
				String text = searchText.getText();
				if (!text.equals("Suchen") && !text.equals("")) {
					try {
						sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
					} catch (PatternSyntaxException pse) {
						JOptionPane.showMessageDialog(null, "Ihr Suchbegriff enth\u00e4lt ein ausgeschlossenes Symbol.",
								"Bad regex pattern", JOptionPane.ERROR_MESSAGE);
						sorter.setRowFilter(null);
					}
				} else {
					sorter.setRowFilter(null);
				}
			}

			@Override
			public void insertUpdate(DocumentEvent evt) {
				searchFieldChangedUpdate(evt);
			}

			@Override
			public void removeUpdate(DocumentEvent evt) {
				searchFieldChangedUpdate(evt);
			}

			@Override
			public void changedUpdate(DocumentEvent evt) {
				searchFieldChangedUpdate(evt);
			}

		});
		this.table.setRowSorter(sorter);
	}

	private void fillTableWithData() {
		Object columnNames[] = { "Titel", "Menge", "Typ"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		if (stockObjects != null) {
			// iterate over existing objects in sortedData
			for (StockObject stockObject : stockObjects) {
				// Switch between instanceTypes
				if (stockObject instanceof Device) {
					Device device = (Device) stockObject;
					Object row[] = { device.title, device.totalVolume, "Ger\u00e4t"};
					model.addRow(row);
				} else if (stockObject instanceof Material) {
					if (stockObject instanceof MedicalMaterial) {
						MedicalMaterial medicalMaterial = (MedicalMaterial) stockObject;
						Object row[] = { medicalMaterial.title, medicalMaterial.totalVolume, "Medizinisches Material"};
						model.addRow(row);
					} else if (stockObject instanceof ConsumableMaterial) {
						ConsumableMaterial consumableMaterial = (ConsumableMaterial) stockObject;
						Object row[] = { consumableMaterial.title, consumableMaterial.totalVolume, "Betreuungsmaterial"};
						model.addRow(row);
					} else {
						// Do nothing with this object, its not a usable material
					}
				} else {
					// Do nothing, maybe its a vehicle
				}
			}
		}

		table.setModel(model);
	}

	@Override
	public void showedAsPreviousPresenter() {
		super.showedAsPreviousPresenter();
		this.searchText.setText("Suchen");
		this.loadTableData();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Left mouse click
		if (SwingUtilities.isLeftMouseButton(e)) {
			// get the coordinates of the mouse click
			Point p = e.getPoint();
			// get the row index that contains that coordinate
			int rowNumber = table.rowAtPoint(p);
			// Show Details
			String selectedTitle = (String)this.table.getValueAt(rowNumber, 0);
			StockObject selectedStockObject = null;
			for (StockObject stockObject : this.stockObjects) {
				if (stockObject.title == selectedTitle) {
					selectedStockObject = stockObject;
					break;
				}
			}
			if (selectedStockObject != null) {
				DetailPresenter detailPresenter = new DetailPresenter(this, selectedStockObject);
				detailPresenter.newScreen();
			}

		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}
}