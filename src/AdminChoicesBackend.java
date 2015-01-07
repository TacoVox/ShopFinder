import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import db.DBConnector;
import db.Store;


public class AdminChoicesBackend extends AdminChoicesGUI{
	public AdminChoicesBackend(){
		storeBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
        		StoreChoicesBackend addGUI = new StoreChoicesBackend();
        		addGUI.frame.setVisible(true);
            }
	});
		
		adminBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
        		AdminManagementBackend manageGUI = new AdminManagementBackend();
        		manageGUI.frame.setVisible(true);
            }
	});
	}

}
