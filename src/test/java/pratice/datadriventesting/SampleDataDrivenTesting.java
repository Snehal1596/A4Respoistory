package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SampleDataDrivenTesting {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		System.out.println(pObj.get("browser"));
		System.out.println(pObj.get("url"));
		System.out.println(pObj.get("username"));
		System.out.println(pObj.get("password"));
		
		

	}

}
