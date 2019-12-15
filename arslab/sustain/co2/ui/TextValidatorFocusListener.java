package arslab.sustain.co2.ui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import arslab.sustain.co2.room.Room;

public class TextValidatorFocusListener implements FocusListener {


	private boolean validateInput(int value) {
		if (value <= Room.MAXSIDE && value >= Room.MINSIDE)
			return true;
		else return false;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		
	}

	@Override
	public void focusLost(FocusEvent evnt) {
		Object obj = evnt.getSource();
		if(obj instanceof JTextField) {
			JTextField field = (JTextField)obj;
			if(!field.getText().isEmpty()) {
				try {
					int value = Integer.parseInt(field.getText());
					if(validateInput(value)) {
						
					}else {
						throw new Exception();
					}
				}
				catch (Exception ex) {
					field.setText("");
					field.grabFocus();
					JOptionPane.showMessageDialog(field.getParent(), "Only numbers are allowed.");
				}
			}
		}
		
	}
}
