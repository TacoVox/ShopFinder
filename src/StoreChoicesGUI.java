import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;


public class StoreChoicesGUI {

	// Initialise components outside of constructor so that they are in the correct scope
	JFrame frame;
	JButton deleteStoreBut;
	JButton addStoreBut;

	public StoreChoicesGUI() {
		// Set frame properties
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 156);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// Labels, fields and buttons
		deleteStoreBut = new JButton("Delete stores");
		deleteStoreBut.setBounds(10, 56, 200, 50);
		frame.getContentPane().add(deleteStoreBut);
		
		addStoreBut = new JButton("Add stores");
		addStoreBut.setBounds(220, 56, 200, 50);
		frame.getContentPane().add(addStoreBut);
		
		JLabel label = new JLabel("Administrative functions:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label.setBounds(10, 11, 208, 48);
		frame.getContentPane().add(label);
	}
}
