package presenter;
import model.PasswordManager;
import model.databaseCommunication.DatabaseLoginManager;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class LoginPresenter extends Presenter {
	private PasswordManager passwordManager = new PasswordManager();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DatabaseLoginManager loginManager = new DatabaseLoginManager();
		if (loginManager.testDatabaseConnection()) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginPresenter window = new LoginPresenter();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			// TODO: Show SetupPresenter
		}
	}

	/**
	 * Create the application.
	 */
	public LoginPresenter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
