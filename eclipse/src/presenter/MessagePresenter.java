package presenter;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;

public class MessagePresenter extends Presenter {
	private JTable table;
	private JButton logo = new JButton("");
	private JButton btnLogout = new JButton("Logout");
	private JButton back = new JButton("");
	private JButton help = new JButton("");

	/**
	 * Create the application.
	 */
	public MessagePresenter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		super.initialize();

		Image img = new ImageIcon (this.getClass().getResource("/img/DRK-LogoMini.jpg")).getImage();
		logo.setIcon (new ImageIcon (img));
		logo.setBounds(595, 6, 199, 65);
		frame.getContentPane().add(logo);

		btnLogout.setBackground(Color.LIGHT_GRAY);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(455, 27, 98, 22);
		frame.getContentPane().add(btnLogout);

		Image imgback = new ImageIcon (this.getClass().getResource("/img/back-button.jpg")).getImage();
		back.addActionListener(this);
		back.setIcon (new ImageIcon (imgback));
		back.setBounds(36, 18, 33, 36);
		frame.getContentPane().add(back);

		Image imgbook = new ImageIcon (this.getClass().getResource("/img/book-button.jpg")).getImage();
		help.addActionListener(this);
		help.setIcon (new ImageIcon (imgbook));
		help.setBounds(381, 18, 33, 36);
		frame.getContentPane().add(help);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 66, 788, 12);
		frame.getContentPane().add(separator);

		JLabel Meldungen = new JLabel("Meldungen");
		Meldungen.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		Meldungen.setBounds(16, 98, 210, 36);
		frame.getContentPane().add(Meldungen);


		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(157, 219, 503, 192);
		frame.getContentPane().add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btnLogout) {
			LoginPresenter loginPresenter = new LoginPresenter();
			this.frame.dispose();
			loginPresenter.newScreen();
		} else if (e.getSource() == this.back){
			this.showPreviousPresenter();
		} else if (e.getSource() == this.help) {

		}
	}
}
