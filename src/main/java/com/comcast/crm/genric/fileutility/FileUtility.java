package com.comcast.crm.genric.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
  public String getDataFromPropertiesFile(String key) throws Throwable {
	  
	  FileInputStream fis = new FileInputStream ("./configAppData/commondata.properties");
	  Properties pObj = new Properties();
	  pObj.load(fis);
	  String data = pObj.getProperty(key);
	  
	  return data;
  }
}
