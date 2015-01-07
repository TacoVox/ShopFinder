package GUI.DeleteStores;

import GUI.DeleteStores.DeleteStoresGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import db.DBConnector;
import db.Store;
import db.Store.*;


public class DeleteStoresBackend extends DeleteStoresGUI{
	public DeleteStoresBackend(){
		// Actionlistener for the button
		deleteBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
            	// Try-catch to ensure user does not input invalid data type
            	try{
            	// Initialise the connector
        		DBConnector connector = new DBConnector();
        		connector.openConnection();
        		Store dbStores = new db.Store(connector.getConnection());
        		// Fetch text from text field, save as variable
        		int storeID = Integer.parseInt(storeDeleteField.getText());
        		// Run method from translator with fetched text as argument
            	dbStores.deleteStore(storeID);
            	} catch (NumberFormatException exception) {
            		// Error message in case of invalid input from user
            		JFrame popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "Please input a number.", "Error", JOptionPane.PLAIN_MESSAGE);
            	}
            }
		});
	}
}
