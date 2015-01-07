import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;


public class AdminChoicesGUI {

	JFrame adminChoicesFrame;
	JButton adminBut;
	JButton storeBut;

	public AdminChoicesGUI() {
		adminChoicesFrame = new JFrame();
		adminChoicesFrame.setTitle("Admin functions");
		adminChoicesFrame.setResizable(false);
		adminChoicesFrame.setBounds(100, 100, 438, 154);
		adminChoicesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		adminChoicesFrame.getContentPane().setLayout(null);
		
		JLabel adminFunctionsLabel = new JLabel("Administrative functions:");
		adminFunctionsLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		adminFunctionsLabel.setBounds(10, 11, 208, 48);
		adminChoicesFrame.getContentPane().add(adminFunctionsLabel);
		
		adminBut = new JButton("Admin Management");
		adminBut.setBounds(10, 56, 200, 50);
		adminChoicesFrame.getContentPane().add(adminBut);
		
		storeBut = new JButton("Store management");
		storeBut.setBounds(222, 56, 200, 50);
		adminChoicesFrame.getContentPane().add(storeBut);
	}
}
