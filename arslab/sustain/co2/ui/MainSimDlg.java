package arslab.sustain.co2.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainSimDlg extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtRoomWidth;
	JTextField txtRoomHeight;
	JTextField txtRoomLength;
	
	final private int firstCol = 10;
	final private int secondCol = 160;
	final private int thirdCol = 210;
	final private int fourthCol = 310;
	
	
	final private int firstRow = 11;
	final private int secondRow = 41;
	final private int thirdRow = 71;
	final private int fourthRow = 100;
	final private int fifthRow = 130;
	
	final private int btnWidth = 140;
	final private int btnHeight = 23;
	
	TextValidatorFocusListener textValidatorFocusListener = new TextValidatorFocusListener();

	/**
	 * Main App window. User inputs room dimensions and can add other features (e.g.
	 * doors, windows, vents, etc.)
	 * 
	 * @author Hoda
	 */
	public MainSimDlg() {
		setResizable(false);
		setTitle("CO2 Modeler"); // TBD: use localization
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 200);
		getContentPane().setLayout(null);

		/**
		 * Room Dimensions
		 */
		// Room Width
		JLabel lblRoomWidth = new JLabel("Room Width:");
		lblRoomWidth.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomWidth.setBounds(firstCol, firstRow, btnWidth, 14);
		getContentPane().add(lblRoomWidth);
		txtRoomWidth = new JTextField();
		txtRoomWidth.setBounds(secondCol, firstRow, 40, 20);
		txtRoomWidth.setColumns(10);
		getContentPane().add(txtRoomWidth);
		JLabel lblRoomWidthUnit = new JLabel("m2");
		lblRoomWidthUnit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRoomWidthUnit.setBounds(thirdCol, firstRow, 20, 14);
		getContentPane().add(lblRoomWidthUnit);


		// Room Length
		JLabel lblRoomLength = new JLabel("Room Length:");
		lblRoomLength.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomLength.setBounds(firstCol, secondRow, btnWidth, 14);
		getContentPane().add(lblRoomLength);
		txtRoomLength = new JTextField();
		txtRoomLength.setBounds(secondCol, secondRow, 40, 20);
		txtRoomLength.setColumns(10);
		getContentPane().add(txtRoomLength);
		JLabel lblRoomLengthUnit = new JLabel("m2");
		lblRoomLengthUnit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRoomLengthUnit.setBounds(thirdCol, secondRow, 20, 14);
		getContentPane().add(lblRoomLengthUnit);

		// Room Height
		JLabel lblRoomHeight = new JLabel("Room Height:");
		lblRoomHeight.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomHeight.setBounds(firstCol, thirdRow, btnWidth, 14);
		getContentPane().add(lblRoomHeight);
		txtRoomHeight = new JTextField();
		txtRoomHeight.setBounds(secondCol, thirdRow, 40, 20);
		txtRoomHeight.setColumns(10);
		getContentPane().add(txtRoomHeight);
		JLabel lblRoomHeightUnit = new JLabel("m2");
		lblRoomHeightUnit.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblRoomHeightUnit.setBounds(thirdCol, thirdRow, 20, 14);
		getContentPane().add(lblRoomHeightUnit);
		
		txtRoomHeight.addFocusListener(textValidatorFocusListener);
		txtRoomWidth.addFocusListener(textValidatorFocusListener);
		txtRoomLength.addFocusListener(textValidatorFocusListener);
		
		/**
		 * Adding features to the room
		 */
		JButton btnAddWindow = new JButton("Add Windows");
		btnAddWindow.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddWindow.setBounds(firstCol, fourthRow, btnWidth, btnHeight);
		getContentPane().add(btnAddWindow);
		
		
		JButton btnAddVents = new JButton("Add Vents");
		btnAddVents.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddVents.setBounds(secondCol, fourthRow, btnWidth, btnHeight);
		getContentPane().add(btnAddVents);
		
		
		JButton btnAddDoor = new JButton("Add Door");
		btnAddDoor.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddDoor.setBounds(fourthCol, fourthRow, btnWidth, btnHeight);
		getContentPane().add(btnAddDoor);
		
		JButton btnAddSensors = new JButton("Add Sensors");
		btnAddSensors.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnAddSensors.setBounds(firstCol, fifthRow, btnWidth, btnHeight);
		getContentPane().add(btnAddSensors);
		
		
		JButton btnGenModel = new JButton("Generate Room");
		btnGenModel.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGenModel.setBounds(secondCol, fifthRow, btnWidth, btnHeight);
		getContentPane().add(btnGenModel);
		
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
					int id = e.getID();
				
			}
		});
		btnClear.setBounds(fourthCol, fifthRow, btnWidth, btnHeight);
		getContentPane().add(btnClear);
	}
}
