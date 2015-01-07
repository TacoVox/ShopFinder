import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class StoreInterfaceGUI {

	JFrame storeInterfaceFrame;
	JButton deleteStoresBut;
	JButton addStoresBut;

	public StoreInterfaceGUI() {
		storeInterfaceFrame = new JFrame();
		storeInterfaceFrame.setResizable(false);
		storeInterfaceFrame.setBounds(100, 100, 354, 151);
		storeInterfaceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		storeInterfaceFrame.getContentPane().setLayout(null);
		
		JLabel lblStoreManagement = new JLabel("Store Management");
		lblStoreManagement.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblStoreManagement.setBounds(10, 11, 148, 33);
		storeInterfaceFrame.getContentPane().add(lblStoreManagement);
		
		deleteStoresBut = new JButton("Delete Stores");
		deleteStoresBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deleteStoresBut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteStoresBut.setBounds(10, 55, 123, 50);
		storeInterfaceFrame.getContentPane().add(deleteStoresBut);
		
		addStoresBut = new JButton("Add/Update stores");
		addStoresBut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addStoresBut.setBounds(143, 55, 178, 50);
		storeInterfaceFrame.getContentPane().add(addStoresBut);
	}
}
