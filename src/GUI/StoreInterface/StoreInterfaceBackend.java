package GUI.StoreInterface;

import GUI.DeleteStores.DeleteStoresBackend;
import GUI.AddStores.AddStoresBackend;
import GUI.StoreInterface.StoreInterfaceGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StoreInterfaceBackend extends StoreInterfaceGUI{
	public StoreInterfaceBackend(){
		
		// Action listener for both buttons which opens the relevant window
		deleteStoresBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
            	DeleteStoresBackend deleteStores = new DeleteStoresBackend();
            	deleteStores.getFrame().setVisible(true);
            }
		});
		
		
		addStoresBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
            	AddStoresBackend addStores = new AddStoresBackend();
            	addStores.getFrame().setVisible(true);
            }
		});
	}

}
