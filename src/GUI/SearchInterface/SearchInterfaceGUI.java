package GUI.SearchInterface;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import db.*;

public class SearchInterfaceGUI {
	JFrame searchFrame;
	JTextField zipCodeInput;
	JButton loginButton;
	JButton searchButton;
	JList<String> categoryList;
	DefaultListModel<String> categoryModel;

	public SearchInterfaceGUI() {
		DBConnector connector = new DBConnector();
		connector.openConnection();
		Categories category = new Categories(connector.getConnection());

		searchFrame = new JFrame();
		searchFrame.setTitle("Shop Finder");
		searchFrame.setResizable(false);
		searchFrame.setBounds(100, 100, 595, 461);
		searchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		searchFrame.getContentPane().setLayout(null);

		JLabel zipCodeLabel = new JLabel("Input ZIP code:");
		zipCodeLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zipCodeLabel.setBounds(10, 282, 108, 50);
		searchFrame.getContentPane().add(zipCodeLabel);

		zipCodeInput = new JTextField();
		zipCodeInput.setBounds(117, 292, 200, 27);
		searchFrame.getContentPane().add(zipCodeInput);
		zipCodeInput.setColumns(10);

		JLabel categoryLabel = new JLabel("Categories:");
		categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		categoryLabel.setBounds(10, 332, 91, 19);
		searchFrame.getContentPane().add(categoryLabel);

		loginButton = new JButton("Login");
		loginButton.setBounds(426, 292, 89, 23);

		searchFrame.getContentPane().add(loginButton);

		JInternalFrame backgroundFrame = new JInternalFrame("New JInternalFrame");
		backgroundFrame.setBorder(null);
		backgroundFrame.setEnabled(false);
		backgroundFrame.setBounds(94, 11, 421, 229);
		searchFrame.getContentPane().add(backgroundFrame);
		backgroundFrame.setVisible(true);
		backgroundFrame.setClosable(false);
		backgroundFrame.setContentPane(new JLabel(new ImageIcon("png/ShopFinderLogo.png")));
		((javax.swing.plaf.basic.BasicInternalFrameUI) backgroundFrame.getUI()).setNorthPane(null);

		searchButton = new JButton("Search");
		searchButton.setBounds(327, 292, 89, 23);

		searchFrame.getContentPane().add(searchButton);

		JScrollPane categoryPane = new JScrollPane();
		categoryPane.setBounds(10, 362, 307, 60);
		searchFrame.getContentPane().add(categoryPane);		

		categoryModel = new DefaultListModel<String>();

		categoryList = new JList<String>(categoryModel);
		categoryPane.setViewportView(categoryList);

		for(String[] cat : category.getCategories()){
			categoryModel.addElement(cat[1]);
		}

		connector.closeConnection();
	}
        
        public JFrame getFrame()
        {
            return searchFrame;
        }

}
