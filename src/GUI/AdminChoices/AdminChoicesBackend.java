package GUI.AdminChoices;

import GUI.AdminManagement.AdminManagementBackend;
import GUI.StoreChoices.StoreChoicesBackend;
import GUI.AdminChoices.AdminChoicesGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminChoicesBackend extends AdminChoicesGUI{
	public AdminChoicesBackend(){
		storeBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
        		StoreChoicesBackend addGUI = new StoreChoicesBackend();
                        addGUI.getFrame().setVisible(true);
            }
	});
		
		adminBut.addActionListener(new ActionListener()
		{
            public void actionPerformed(ActionEvent arg0) {
        		AdminManagementBackend manageGUI = new AdminManagementBackend();
        		manageGUI.getFrame().setVisible(true);
            }
	});
	}

}
