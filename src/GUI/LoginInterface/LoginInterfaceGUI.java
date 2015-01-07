package GUI.LoginInterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;


public class LoginInterfaceGUI {

	JFrame frame;
	JTextField usernameField;
	JPasswordField passField;
	JButton loginButton;

	public LoginInterfaceGUI() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 443, 179);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel userLabel = new JLabel("Username:");
		userLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		userLabel.setBounds(10, 50, 78, 34);
		frame.getContentPane().add(userLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(93, 59, 217, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passLabel = new JLabel("Password:");
		passLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passLabel.setBounds(10, 97, 78, 34);
		frame.getContentPane().add(passLabel);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(93, 106, 217, 20);
		frame.getContentPane().add(passField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(329, 82, 89, 23);
		frame.getContentPane().add(loginButton);
		
		JLabel adminLabel = new JLabel("Admistrator Login");
		adminLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adminLabel.setBounds(126, 9, 145, 40);
		frame.getContentPane().add(adminLabel);
	}
        
        public JFrame getFrame()
        {
            return frame;
        }
}
