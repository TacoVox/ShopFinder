import db.*;


public class getStoresTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DBConnector connector = new DBConnector();
		connector.openConnection();
		Store dbStores = new db.Store(connector.getConnection());
		
		System.out.println(dbStores.getStores("The Halal Guys"));
	}

}
