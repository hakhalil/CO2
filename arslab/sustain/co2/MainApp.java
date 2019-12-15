package arslab.sustain.co2;

import java.awt.EventQueue;

import arslab.sustain.co2.ui.MainSimDlg;

public class MainApp {

	/**
	 * Initiates the main application window
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainSimDlg frame = new MainSimDlg();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}
