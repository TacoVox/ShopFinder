import db.*;
import java.io.File;


public class throwawayMain {

	public static void main(String[] args) {
            try {
                File folder = new File("temp/");
            
                if(folder.exists() == false)
                {
                    folder.mkdir();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
		SearchInterfaceBackend search = new SearchInterfaceBackend();
		search.searchFrame.setVisible(true);
		
//		ResultFrame result = new ResultFrame();
		



//		LoginInterfaceBackend login = new LoginInterfaceBackend();
//		login.frame.setVisible(true);
//		DBConnector connector = new DBConnector();
//		connector.openConnection();
//		Admin admin = new Admin(connector.getConnection());
//		admin.insertAdmin("Rhaz", "123123");
//		StoreInterfaceBackend store = new StoreInterfaceBackend();
//		store.storeInterfaceFrame.setVisible(true);
//		addStoresBackend addGUI = new addStoresBackend();
//		addGUI.frame.setVisible(true);
	}
}
