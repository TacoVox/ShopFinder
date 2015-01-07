package ShopFinder;

import GUI.SearchInterface.SearchInterfaceBackend;

import java.io.File;

public class ShopFinder
{

    public static void main(String[] args)
    {
        try
        {
            File folder = new File("temp/");

            if (folder.exists() == false)
            {
                folder.mkdir();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        SearchInterfaceBackend search = new SearchInterfaceBackend();
        search.getFrame().setVisible(true);
    }
}
