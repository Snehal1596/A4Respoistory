package pratice.contacttest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

class CreateOrgWithPhoneNumberTest {
	public static	WebDriver driver=null;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fis=new FileInputStream("./configAppData/commondata.properties");
		
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String Browser=pObj.getProperty("browser");
		String url=pObj.getProperty("url");
		String password=pObj.getProperty("password");
		String username=pObj.getProperty("username");

		System.out.println(Browser);
					
					//generate the random number
					Random random = new Random();
					int randomInt = random.nextInt(1000);
					
					//read scriptdata from excel file
					FileInputStream fos = new FileInputStream("./testdata/testScriptData2.xlsx");
					Workbook wb = WorkbookFactory.create(fos);
					Sheet sh = wb.getSheet("Sheet1");
					Row row = sh.getRow(7);
					String orgName = row.getCell(2).toString() + randomInt;
					String phoneNumber = row.getCell(3).toString();
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
				    driver.findElement(By.name("accountname")).sendKeys(orgName);
				    driver.findElement(By.id("phone")).sendKeys(phoneNumber);
				    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']" )).click();
				    
				    //VErify header msg expected result
				    String info=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				    //String headerInfo = driver.findElement(By.xpath("//span[Text()='[ ACC19 ] bgvgbh -  Organization Information']")).getText();
				    if(info.contains(orgName)) {
				    	System.out.println(orgName + "is created==pass");
				    }else {
				    	System.out.println(orgName + "is not created==fail");
				    }
				    //Verify header phone nmber info Expected result 
				    String actPhoneNumber = driver.findElement(By.id("dtlview_Phone")).getText();
				    if(actPhoneNumber.equals(actPhoneNumber)) {
				    	System.out.println(actPhoneNumber + "information is created==pass");
				    }else {
				    	System.out.println(actPhoneNumber + "information is not created==fail");
				    }
				    
				    //Step 5 - logout
				    //Actions act=new Actions(driver);
				    //Thread.sleep(10000);
				    //act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
				    //driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		    
				   driver.quit();
			}



	}


