import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class View implements Runnable{

	private JFrame frame;
	private JTextField textField;
	private JTextPane textPane;
	private Controller controller;

	private ActionListener sendMessage = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textPane.setText(textPane.getText() + "\nYou: " + textField.getText());
			controller.sendMessage(textField.getText());
			textField.setText("");
			textField.requestFocus();
			//System.out.println("Button clicked");
		}
	};
	/**
	 * Launch the application.
	 */
	public void run(){
		frame.setVisible(true);
		textField.requestFocus();
		
		while(true){
			controller.listen();
		}
	}

	/**
	 * Create the application.
	 */
	public View(Controller c) {
		controller = c;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("DESMessenger");
		frame.setResizable(false);
		frame.setBounds(100, 100, 617, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(10, 11, 591, 357);
		textPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		frame.getContentPane().add(textPane);
		
		textField = new JTextField();
		textField.setBounds(10, 379, 493, 54);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		textField.addActionListener(sendMessage);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(sendMessage);
		btnNewButton.setBounds(513, 379, 88, 54);
		frame.getContentPane().add(btnNewButton);
	}
	
	public void displayMessage(String message){
		textPane.setText(textPane.getText() + "\nThem: " + message);
	}
}
