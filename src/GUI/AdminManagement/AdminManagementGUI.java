package GUI.AdminManagement;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;


public class AdminManagementGUI {

	JFrame frame;
	JTextField addAdminNameField;
	JTextField addAdminPassField;
	JTextField upAdminOldPassField;
	JTextField upAdminNameField;
	JTextField upAdminNewPassField;
	JTextField deleteAdminNameField;
	JButton addAdminButt;
	JButton updateAdminButt;
	JButton deleteAdminButt;

	public AdminManagementGUI() {
		frame = new JFrame();
		frame.setTitle("Admin Management");
		frame.setResizable(false);
		frame.setBounds(100, 100, 709, 351);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel adminLabel = new JLabel("Admin Management:");
		adminLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adminLabel.setBounds(10, 11, 177, 28);
		frame.getContentPane().add(adminLabel);
		
		JLabel addAdminLabel = new JLabel("Add Admin:");
		addAdminLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addAdminLabel.setBounds(10, 50, 105, 28);
		frame.getContentPane().add(addAdminLabel);
		
		JLabel addAdminNameLabel = new JLabel("Admin name:");
		addAdminNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addAdminNameLabel.setBounds(10, 77, 105, 28);
		frame.getContentPane().add(addAdminNameLabel);
		
		addAdminNameField = new JTextField();
		addAdminNameField.setColumns(10);
		addAdminNameField.setBounds(125, 81, 200, 24);
		frame.getContentPane().add(addAdminNameField);
		
		addAdminPassField = new JTextField();
		addAdminPassField.setColumns(10);
		addAdminPassField.setBounds(125, 120, 200, 24);
		frame.getContentPane().add(addAdminPassField);
		
		JLabel addAdminPassword = new JLabel("Admin password:");
		addAdminPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addAdminPassword.setBounds(10, 116, 105, 28);
		frame.getContentPane().add(addAdminPassword);
		
		JLabel upAdminLabel = new JLabel("Update Admin:");
		upAdminLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		upAdminLabel.setBounds(10, 155, 105, 28);
		frame.getContentPane().add(upAdminLabel);
		
		JLabel upAdminNameLabel = new JLabel("Admin name:");
		upAdminNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		upAdminNameLabel.setBounds(10, 182, 105, 28);
		frame.getContentPane().add(upAdminNameLabel);
		
		JLabel upAdminOldPassLabel = new JLabel("Admin old password:");
		upAdminOldPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		upAdminOldPassLabel.setBounds(10, 221, 130, 28);
		frame.getContentPane().add(upAdminOldPassLabel);
		
		upAdminOldPassField = new JTextField();
		upAdminOldPassField.setColumns(10);
		upAdminOldPassField.setBounds(150, 225, 200, 24);
		frame.getContentPane().add(upAdminOldPassField);
		
		upAdminNameField = new JTextField();
		upAdminNameField.setColumns(10);
		upAdminNameField.setBounds(125, 186, 200, 24);
		frame.getContentPane().add(upAdminNameField);
		
		JLabel upAdminNewPassword = new JLabel("Admin new password:");
		upAdminNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		upAdminNewPassword.setBounds(10, 260, 140, 28);
		frame.getContentPane().add(upAdminNewPassword);
		
		upAdminNewPassField = new JTextField();
		upAdminNewPassField.setColumns(10);
		upAdminNewPassField.setBounds(160, 264, 200, 24);
		frame.getContentPane().add(upAdminNewPassField);
		
		deleteAdminNameField = new JTextField();
		deleteAdminNameField.setColumns(10);
		deleteAdminNameField.setBounds(499, 81, 200, 24);
		frame.getContentPane().add(deleteAdminNameField);
		
		JLabel deleteAdminNameLabel = new JLabel("Admin name:");
		deleteAdminNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteAdminNameLabel.setBounds(384, 77, 105, 28);
		frame.getContentPane().add(deleteAdminNameLabel);
		
		JLabel deleteAdminLabel = new JLabel("Delete Admin:");
		deleteAdminLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteAdminLabel.setBounds(384, 50, 105, 28);
		frame.getContentPane().add(deleteAdminLabel);
		
		addAdminButt = new JButton("Add Admin");
		addAdminButt.setBounds(471, 120, 136, 26);
		frame.getContentPane().add(addAdminButt);
		
		updateAdminButt = new JButton("Update Admin");
		updateAdminButt.setBounds(471, 158, 136, 26);
		frame.getContentPane().add(updateAdminButt);
		
		deleteAdminButt = new JButton("Delete Admin");
		deleteAdminButt.setBounds(471, 195, 136, 26);
		frame.getContentPane().add(deleteAdminButt);
	}
        
        public JFrame getFrame()
        {
            return frame;
        }
}
