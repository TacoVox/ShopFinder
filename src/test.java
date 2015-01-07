import java.util.ArrayList;
import java.util.List;

import db.DBConnector;
import db.Store;


public class test {

	public static void main(String[] args) {
		DBConnector connector = new DBConnector();
		connector.openConnection();
		Store dbStores = new db.Store(connector.getConnection());
		List<String[]> returnStores = new ArrayList<String[]>();
		int[] selectedCategories = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
		for(int i = 0; i < selectedCategories.length; i++){
			for(String[] s : dbStores.getStores(selectedCategories[i] + 1, 41876)){
				returnStores.add(s);
			}
		}
		for(String[] s : returnStores){
			System.out.println(s[3]);
		}


	}

}
