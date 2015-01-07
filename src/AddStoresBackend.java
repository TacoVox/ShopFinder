import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.Categories;
import db.DBConnector;
import db.Store;


public class AddStoresBackend extends AddStoresGUI{
	public AddStoresBackend(){
		// Actionlistener from the button
		addUpdateBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {

				// Try-catch to ensure user does not input invalid data type
				try {
					// Initialise the connector
					DBConnector connector = new DBConnector();
					connector.openConnection();
					Store store = new Store(connector.getConnection());
					
					// Fetch text from text fields, store them as variables
					String storeName = storeNameField.getText();
					String phone = phoneField.getText();
					String street = streetField.getText();
					String description = descriptionField.getText();
					int zip = Integer.parseInt(zipField.getText());
					int selectedCategory = categoryList.getSelectedIndex() + 1;
					
					// Execute method from the translator to add/update stores with the fetched text as arguments
					store.addUpdateStore(storeName, phone, street, description, zip, selectedCategory);
				} catch (NumberFormatException exception) {
					// If the user inputs an invalid data type, produce an error window
					JFrame popup = new JFrame();
					JOptionPane.showMessageDialog(popup, "Please input a number.", "Error", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
	}

}
