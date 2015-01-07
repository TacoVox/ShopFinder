package GUI.StoreChoices;

import GUI.DeleteStores.DeleteStoresBackend;
import GUI.AddStores.AddStoresBackend;
import GUI.StoreChoices.StoreChoicesGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StoreChoicesBackend extends StoreChoicesGUI
{

    public StoreChoicesBackend()
    {
        deleteStoreBut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                DeleteStoresBackend delGUI = new DeleteStoresBackend();
                delGUI.getFrame().setVisible(true);
            }
        });

        addStoreBut.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent arg0)
            {
                AddStoresBackend addGUI = new AddStoresBackend();
                addGUI.getFrame().setVisible(true);
            }
        });

    }

}
