package pratice.datadriventesting;

import org.apache.poi.util.SystemOutLogger;
import org.testng.annotations.Test;

public class ReadRntimeMavenParameterTest {

	@Test
	public void runtimeParameterTest() {
       //System.out.println("test ng test");
		
		String URL = System.getProperty("url");
		String BROWSER = System.getProperty("browser");
		String USERNAME = System.getProperty("username");
		String PASSWORD = System.getProperty("password");
		
	     System.out.println("Env Data==>URL ====>"+URL);
		 System.out.println("Browser Data==>URL ====>"+BROWSER);
		 System.out.println("Username Data==>URL ====>"+USERNAME);
		 System.out.println("Password Data==>URL ====>"+PASSWORD);
		
	}

}
