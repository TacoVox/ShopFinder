import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.Border;

import db.DBConnector;
import db.Admin;


public class AdminManagementBackend extends AdminManagementGUI{
	public AdminManagementBackend(){
		DBConnector connector = new DBConnector();
		connector.openConnection();
		Admin admin= new Admin(connector.getConnection());

		addAdminButt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				String aname = addAdminNameField.getText();
				String apass= addAdminPassField.getText();
				if(!admin.insertAdmin(aname, apass) || aname.length() == 0 || apass.length() == 0){
					Border oldBorder = addAdminNameField.getBorder();
					if (aname.length() == 0) addAdminNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					if (apass.length() == 0) addAdminPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					else {
						addAdminNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
						addAdminPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					}

					addAdminNameField.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent evt) {
							((JTextField) evt.getSource()).setBorder(oldBorder);
						}
					});

					addAdminPassField.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent evt) {
							((JTextField) evt.getSource()).setBorder(oldBorder);
						}
					});
				}
			}
		});

		updateAdminButt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				String aname = upAdminNameField.getText();
				String aopass= upAdminOldPassField.getText();
				String anpass = upAdminNewPassField.getText();

				if(!admin.updateAdmin(aname, aopass, anpass) || aname.length() == 0 || aopass.length() == 0 || anpass.length() == 0){
					Border oldBorder = upAdminNameField.getBorder();
					if(aname.length() == 0) upAdminNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					if(aopass.length() == 0) upAdminOldPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					if(anpass.length() == 0) upAdminNewPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

					else{
						upAdminNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
						upAdminOldPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
						upAdminNewPassField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					}

					upAdminNameField.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent evt) {
							((JTextField) evt.getSource()).setBorder(oldBorder);
						}
					});

					upAdminOldPassField.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent evt) {
							((JTextField) evt.getSource()).setBorder(oldBorder);
						}
					});

					upAdminNewPassField.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent evt) {
							((JTextField) evt.getSource()).setBorder(oldBorder);
						}
					});
				}
			}
		});

		deleteAdminButt.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				String aname = deleteAdminNameField.getText();

				if(!admin.deleteAdmin(aname) || aname.length() == 0){
					Border oldBorder = deleteAdminNameField.getBorder();
					deleteAdminNameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
					deleteAdminNameField.addKeyListener(new java.awt.event.KeyAdapter() {
						public void keyTyped(java.awt.event.KeyEvent evt) {
							((JTextField) evt.getSource()).setBorder(oldBorder);
						}
					});


				}

			}
		});


	}

}
