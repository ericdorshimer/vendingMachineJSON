package vendingMachineJSON.vendingMachineJSON;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

import java.util.ArrayList;
public class readJSONfile {
	
	public static jsonObj readJSON(int x) throws IOException, ParseException {
		
		JSONParser parser = new JSONParser();// json parser object
		
		FileReader input =new FileReader(".\\jsonfiles\\input.json");// giving file directory
				
		Object obj = parser.parse(input); // creating object once parsed
		
		JSONObject jsonObj = (JSONObject)obj;// json object from parsed items
		
	
		JSONArray[] array = (JSONArray[])jsonObj.get("Items");// creating an array from given Items data
		
		if(x < 10) { // retrieving individual object given its list in the ITEMS list
			
		
			String itemName = (String) array[x].get("name"); // getting each object of an array
			int amt = (Integer) array[x].get("amount");
			String price = (String) array[x].get("price");
			
			System.out.println(itemName);
			System.out.println(amt);
			System.out.println(price);

		}	
		return array[x]; 
		
		
	}

}
