package GUI.DeleteStores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteStoresGUI
{

    // Initialise components outside of constructor so that they are in the correct scope
    JFrame deleteFrame;
    JTextField storeDeleteField;
    JButton deleteBut;

    public DeleteStoresGUI()
    {
        // Set frame properties
        deleteFrame = new JFrame();
        deleteFrame.setResizable(false);
        deleteFrame.setBounds(100, 100, 416, 157);
        deleteFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        deleteFrame.getContentPane().setLayout(null);

        // Labels, text fields and buttons
        JLabel deletLabel = new JLabel("Delete store:");
        deletLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        deletLabel.setBounds(10, 11, 133, 46);
        deleteFrame.getContentPane().add(deletLabel);

        JLabel lblStoreId = new JLabel("Store ID:");
        lblStoreId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblStoreId.setBounds(9, 63, 71, 29);
        deleteFrame.getContentPane().add(lblStoreId);

        storeDeleteField = new JTextField();
        storeDeleteField.setBounds(77, 67, 177, 25);
        deleteFrame.getContentPane().add(storeDeleteField);
        storeDeleteField.setColumns(10);

        deleteBut = new JButton("Delete");
        deleteBut.setBounds(285, 68, 89, 23);
        deleteFrame.getContentPane().add(deleteBut);
    }

    public JFrame getFrame()
    {
        return deleteFrame;
    }
}
