import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import db.Categories;
import db.DBConnector;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;


public class AddStoresGUI {
	
	// Initialise components outside of constructor so that they are in the correct scope
	JFrame frame;
	JTextField storeNameField;
	JTextField phoneField;
	JTextField streetField;
	JTextField descriptionField;
	JTextField zipField;
	JList<String> categoryList;
	DefaultListModel<String> categoryModel;
	JButton addUpdateBut;

	public AddStoresGUI() {
		// Initialise database connector
		DBConnector connector = new DBConnector();
		connector.openConnection();
		Categories category = new Categories(connector.getConnection());
		
		// Set frame properties
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 410);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Assign category model and assign list to model, append them to the frame
		categoryModel = new DefaultListModel<String>();
		categoryList = new JList<String>(categoryModel);
		frame.getContentPane().add(categoryList);
		
		// Create category pane, assign list model and list to the pane, append the pane to the frame
		JScrollPane categoryPane = new JScrollPane();
		categoryPane.setBounds(10, 89, 305, 58);
		categoryList = new JList<String>(categoryModel);
		categoryPane.setViewportView(categoryList);
		categoryModel = new DefaultListModel<String>();
		frame.getContentPane().add(categoryPane);
		
		// Set selection method of the category list
		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryPane.setViewportView(categoryList);
		
		// Fetch the list of categories from the database, add them to the category list
		for(String[] cat : category.getCategories()){
			categoryModel.addElement(cat[1]);
		}
		
		// Creating and adding labels, text fields and button to the frame
		JLabel addStoreLabel = new JLabel("Add/Update Stores:");
		addStoreLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		addStoreLabel.setBounds(10, 11, 153, 28);
		frame.getContentPane().add(addStoreLabel);
		
		JLabel categoryLabel = new JLabel("Select Category:");
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		categoryLabel.setBounds(10, 50, 105, 28);
		frame.getContentPane().add(categoryLabel);
		
		JLabel storeNameLabel = new JLabel("Store name:");
		storeNameLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		storeNameLabel.setBounds(10, 158, 105, 28);
		frame.getContentPane().add(storeNameLabel);
		
		storeNameField = new JTextField();
		storeNameField.setBounds(10, 197, 200, 24);
		frame.getContentPane().add(storeNameField);
		storeNameField.setColumns(10);
		
		JLabel phoneLabel = new JLabel("Phone number:");
		phoneLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		phoneLabel.setBounds(220, 158, 105, 28);
		frame.getContentPane().add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(220, 197, 200, 24);
		frame.getContentPane().add(phoneField);
		
		streetField = new JTextField();
		streetField.setColumns(10);
		streetField.setBounds(10, 266, 200, 24);
		frame.getContentPane().add(streetField);
		
		JLabel streetLabel = new JLabel("Street:");
		streetLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		streetLabel.setBounds(10, 227, 105, 28);
		frame.getContentPane().add(streetLabel);
		
		descriptionField = new JTextField();
		descriptionField.setColumns(10);
		descriptionField.setBounds(220, 266, 200, 24);
		frame.getContentPane().add(descriptionField);
		
		JLabel descriptionLabel = new JLabel("Description:");
		descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descriptionLabel.setBounds(220, 227, 105, 28);
		frame.getContentPane().add(descriptionLabel);
		
		zipField = new JTextField();
		zipField.setColumns(10);
		zipField.setBounds(10, 335, 200, 24);
		frame.getContentPane().add(zipField);
		
		JLabel zipcodeLabel = new JLabel("Zipcode:");
		zipcodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		zipcodeLabel.setBounds(10, 296, 105, 28);
		frame.getContentPane().add(zipcodeLabel);
		
		addUpdateBut = new JButton("Add/Update");
		addUpdateBut.setBounds(265, 336, 118, 23);
		frame.getContentPane().add(addUpdateBut);
	}
}
