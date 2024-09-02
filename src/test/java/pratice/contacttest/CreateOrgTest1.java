package pratice.contacttest;

import java.io.FileInputStream;
import java.io.*;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest1 {
public static	WebDriver driver=null;

		public static void main(String[] args) throws Throwable {
			// TODO Auto-generated method stub
			//read data from JSON file
			JSONParser parser = new JSONParser();
			Object obj =parser.parse(new FileReader("./src/test/resources/appCommonData.json"));
			JSONObject map= (JSONObject)obj;
			
String Browser=(String)map.get("browser");
String url=(String)map.get("url");
String password=(String)map.get("password");
String username=(String)map.get("username");

System.out.println(Browser);
			
			//generate the random number
			Random random = new Random();
			int randomInt = random.nextInt(1000);
			
			//read scriptdata from excel file
			FileInputStream fos = new FileInputStream("./src/test/resources/testScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fos);
			Sheet sh = wb.getSheet("org");
			Row row = sh.getRow(1);
			String orgName = row.getCell(2).toString() + randomInt;
			wb.close();
			
			
			if(Browser.equals("chrome")) {
				driver=new ChromeDriver();
			    }
			else if(Browser.equals("firefox")) {
						driver=new FirefoxDriver();
			    }
			else if(Browser.equals("edge")) {
					driver=new EdgeDriver();
						
			    }	
				
			

			
			//STEP 1-login to APP
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
		    driver.findElement(By.id("submitButton")).click();
		    
		    //STEP 2 - navigate to organization module
		    driver.findElement(By.linkText("Organizations")).click(); 
		    
		    //STEP 3- click on "create oraganization" button
		    driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		    
		    //STEP 4 - Enter all the details & crate new organization
		    driver.findElement(By.name("accountname")).sendKeys("orgName");
		    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']" )).click();
		    
		    
		    //Step 5 - logout
		    Actions act=new Actions(driver);
		    Thread.sleep(10000);
		    act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
		    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		    
		   driver.quit();
	}

}


