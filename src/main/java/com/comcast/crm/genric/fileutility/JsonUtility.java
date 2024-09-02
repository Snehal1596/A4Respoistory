package com.comcast.crm.genric.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
   public String getDataFromJsonFile(String key) throws Throwable {
	 FileReader fileR = new FileReader("./configAppData/appCommonData.json");
	 
	 JSONParser parser=new JSONParser();
		Object ob=parser.parse(fileR);
		
		JSONObject map= (JSONObject)ob;
		
		String data = (String) map.get(key);
		return data;

   }
}
