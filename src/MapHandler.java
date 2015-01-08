import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.json.*;
/**
 * Class that handles map and directions requests.
 * @author Petronela Tanase
 *
 */
public class MapHandler {
	static final String API_KEY = "AIzaSyBByaoqrcWI3mr24GHmSCBZ_dRiIuezwiI";
	static final String GEO_URL = "https://maps.googleapis.com/maps/api/geocode/json?region=SE&address=";
	static final String MAPS_URL = "https://maps.googleapis.com/maps/api/staticmap?";
	static final String DIRECTIONS_URL = "https://maps.googleapis.com/maps/api/directions/json?";
	static final String IMG_FORMAT = "png";
	static final boolean DEBUG = false;
	//static final String ZOOM_LEVEL = "15";
	
	/*
	 * Requires a user address and a list of String arrays(each representing a store) as parameters.
	 * Returns an ImageIcon retrieved using Google static maps API.
	 */
	public static ImageIcon getMap(String user,List<String[]> stores) throws MalformedURLException, IOException{
		//Get user coordinates
		String user_coords = MapHandler.getCoordinates(user);
		//Create static maps request url
		String imageUrl = MAPS_URL +"&size=640x640&maptype=roadmap&format="+IMG_FORMAT;
		//Add user marker to url
		imageUrl+="&markers=color:blue%7Clabel:H%7C"+user_coords;
		//Add store markers to url
		for (int i = 0;i<stores.size();i++){
			String store_coords = getCoordinates(stores.get(i)[3]+" "+stores.get(i)[5]);
			imageUrl+="&markers=color:red%7Clabel:"+(i+1)+"%7C"+store_coords;
		}
		if(DEBUG) System.out.println("[Debug][GlobalMapUrl]:"+imageUrl);
		//Retrieve and return image from generated url
        URL url = new URL(imageUrl);
        BufferedImage img = ImageIO.read(url);
        File outputfile = new File("temp/map.png");
        ImageIO.write(img, "png", outputfile); 
        //System.out.println(ImageIO.getCacheDirectory().toString());
		return new ImageIcon(img);
	}
	/*
	 * Returns a map with a polyline drawn between the user address and the supplied store. Type can be driving,bicycling and walking.
	 * Using Google static maps API.
	 */
	public static ImageIcon getMap(String user , String[] store, int index, String type) throws MalformedURLException, IOException{
		//If map type requested is not one of the three possible throw exception - This should not happen
		if(!type.equals("driving")&&!type.equals("bicycling")&&!type.equals("walking")) throw new MalformedURLException();
		//Get user and store coordinates
		String user_coords = MapHandler.getCoordinates(user);
		String store_coords = MapHandler.getCoordinates(store[3] + " " + store[5]);
		//Create static maps request url
		String fileName = "temp/"+type+user_coords+store_coords+".png";
		String imageUrl = MAPS_URL
				+ "size=640x640&path=weight:4%7Ccolor:red%7Cenc:"
				+ URLEncoder.encode(getPolyline(user_coords, store_coords,type), "UTF-8")+"&format="+IMG_FORMAT;
		imageUrl += "&markers=color:red%7Clabel:"+(index+1)+"%7C"+store_coords;
		imageUrl += "&markers=color:blue%7Clabel:H%7C"+user_coords;
		
		if(DEBUG) System.out.println("[Debug][PathMapUrl]:"+imageUrl);
		//Retrieve and return image from generated url
		URL url = new URL(imageUrl);
        BufferedImage img = ImageIO.read(url);
        File outputfile = new File(fileName);
        ImageIO.write(img, "png", outputfile);
		return new ImageIcon(fileName);
	}
	/*
	 * Returns coordinates for an address using Google Geocoding API
	 */
	private static String getCoordinates(String address) throws MalformedURLException, IOException{
		//Create Geocoding request url with supplied address
		String addr = GEO_URL+URLEncoder.encode(address,"UTF-8");
		if(DEBUG) System.out.println("[Debug][GeoReq]:"+addr);
		double[] coords = new double[2];
		//Read string from Url and create JSON object from string
		InputStream is = new URL(addr).openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is,
				Charset.forName("UTF-8")));
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		is.close();
		rd.close();
		JSONObject jsonObj = new JSONObject(sb.toString());
		//Read coordinates from JSON Object
		coords[0] = jsonObj.getJSONArray("results").getJSONObject(0)
				.getJSONObject("geometry").getJSONObject("location")
				.getDouble("lat");
		coords[1] = jsonObj.getJSONArray("results").getJSONObject(0)
				.getJSONObject("geometry").getJSONObject("location")
				.getDouble("lng");
		if(DEBUG) System.out.println("[Debug][GeoReply]:"+jsonObj);
		//Return coordinates as string for maps and directions request usage
		return Double.toString(coords[0])+","+Double.toString(coords[1]);
	}
	/*
	 * Returns an encoded polyline from Google Directions API. 
	 */
	private static String getPolyline(String origin, String destination, String mode) throws MalformedURLException, IOException{
		//create directions request url
		String addr = DIRECTIONS_URL + "origin="+origin+"&destination="+destination+"&key="+API_KEY+"&mode="+mode;
		if(DEBUG) System.out.println("[Debug][PolyReq]:"+addr);
		//Read string from Url and create JSON object from string
		InputStream is = new URL(addr).openStream();
		BufferedReader rd = new BufferedReader(new InputStreamReader(is,
				Charset.forName("UTF-8")));
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		is.close();
		rd.close();
		JSONObject jsonObj = new JSONObject(sb.toString());
		//Read and return polyline from JSON object
		String polyLine = jsonObj.getJSONArray("routes").getJSONObject(0).getJSONObject("overview_polyline").getString("points");
		if(DEBUG) System.out.println("[Debug][PolyReply]:"+jsonObj);
		return polyLine;
	}
}
