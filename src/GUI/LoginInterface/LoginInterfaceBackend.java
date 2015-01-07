package GUI.LoginInterface;

import GUI.AdminChoices.AdminChoicesBackend;
import GUI.LoginInterface.LoginInterfaceGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.Border;

import db.*;

public class LoginInterfaceBackend extends LoginInterfaceGUI
{

    public LoginInterfaceBackend()
    {

        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                DBConnector connector = new DBConnector();
                connector.openConnection();

                Admin admin = new Admin(connector.getConnection());

                String username = usernameField.getText();
                String password = passField.getText();

                if (admin.loginAdmin(username, password))
                {
                    AdminChoicesBackend adminChoices = new AdminChoicesBackend();
                    adminChoices.getFrame().setVisible(true);
                } else
                {
                    Border oldBorder = usernameField.getBorder();
                    usernameField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
                    passField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

                    usernameField.addKeyListener(new java.awt.event.KeyAdapter()
                    {
                        public void keyTyped(java.awt.event.KeyEvent evt)
                        {
                            ((JTextField) evt.getSource()).setBorder(oldBorder);
                        }
                    });

                    passField.addKeyListener(new java.awt.event.KeyAdapter()
                    {
                        public void keyTyped(java.awt.event.KeyEvent evt)
                        {
                            ((JTextField) evt.getSource()).setBorder(oldBorder);
                        }
                    });
                }
            }
        });

    }
}
