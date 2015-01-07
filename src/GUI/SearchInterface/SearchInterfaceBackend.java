package GUI.SearchInterface;

import GUI.ResultFrame.ResultFrame;
import GUI.LoginInterface.LoginInterfaceBackend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import db.*;

public class SearchInterfaceBackend extends SearchInterfaceGUI
{

    public SearchInterfaceBackend()
    {
        DBConnector connector = new DBConnector();
        connector.openConnection();
        Store dbStores = new db.Store(connector.getConnection());
        List<String[]> returnStores = new ArrayList<String[]>();

        loginButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                LoginInterfaceBackend loginWindow = new LoginInterfaceBackend();
                loginWindow.getFrame().setVisible(true);
            }
        });

        searchButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                int[] selectedCategories = categoryList.getSelectedIndices();
                //List<String[]> returnedStores = null;
                try
                {
                    int userZip = Integer.parseInt(zipCodeInput.getText());
                    System.out.println(userZip);

                    for (int i = 0; i < selectedCategories.length; i++)
                    {
                        for (String[] s : dbStores.getStores(selectedCategories[i] + 1, userZip))
                        {
                            returnStores.add(s);
                        }
                    }

                    for (String[] s : returnStores)
                    {
                        System.out.println(s[1]);
                    }

                    ResultFrame rf = new ResultFrame();
                    rf.setVisible(true);
                    rf.loadData(Integer.toString(userZip), returnStores);

                } catch (NumberFormatException exception)
                {
                    JFrame popup = new JFrame();
                    JOptionPane.showMessageDialog(popup, "Please input a number.", "Error", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });

    }
}
