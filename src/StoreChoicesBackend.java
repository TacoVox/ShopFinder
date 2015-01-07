import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StoreChoicesBackend extends StoreChoicesGUI{
	public StoreChoicesBackend(){
		deleteStoreBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
            	DeleteStoresBackend delGUI = new DeleteStoresBackend();
				delGUI.deleteFrame.setVisible(true);
            }
		});
	
		addStoreBut.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				AddStoresBackend addGUI = new AddStoresBackend();
        		addGUI.frame.setVisible(true);
			}
		});
	
	}
	
}
