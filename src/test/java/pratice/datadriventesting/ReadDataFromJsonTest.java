package pratice.datadriventesting;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
public class ReadDataFromJsonTest {

	public static void main(String[] args) throws Throwable, ParseException {
		// TODO Auto-generated method stub
		
		//step1- parse json physical file into java object using JSonperse class
		
		JSONParser parser=new JSONParser();
		Object ob=parser.parse(new FileReader("C:\\Automation Program\\SeleniumCRUGUIDFramework\\src\\test\\resources\\appCommonData.json"));
		
		//Step2- covert java object in to JSonObject using down casting
		JSONObject map= (JSONObject)ob;
		
		//step3- get the value from json file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeOut"));

	}

}
