package pratice.datadriventesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
        FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		Scanner s=new Scanner(System.in);
		System.out.println("Browser");
		String Browser=s.next();
		
		WebDriver driver=null;
		if(Browser.equals("chrome")) {
		driver=new ChromeDriver();
	    }else if(Browser.equals("firefox")) {
				driver=new FirefoxDriver();
	    }else if(Browser.equals("edge")) {
			driver=new EdgeDriver();
				
	    }	
		}
		
	    // WebDriver driver=new FirefoxDriver();
		//WebDriver driver=new ChromeDriver();
		/*
		 * driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		 * 
		 *driver.findElement(By.name("user_name")).sendKeys("admin");
		 * driver.findElement(By.name("user_password")).sendKeys("admin");
		 * driver.findElement(By.id("submitButton")).click();
		 * 
		 * driver.findElement(By.linkText("Organizations")).click(); driver.quit();
		 * 
		 * }
		 */

}
