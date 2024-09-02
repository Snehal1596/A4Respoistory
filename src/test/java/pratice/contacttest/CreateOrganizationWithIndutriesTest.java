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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndutriesTest {
		public	 static WebDriver driver=null;

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
						Row row = sh.getRow(4);
						String orgName = row.getCell(2).toString();
						String industries = row.getCell(3).toString();
						String type = row.getCell(4).toString();
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
					    WebElement wbsele1 = driver.findElement(By.name("industry"));
					    Select sell = new Select(wbsele1);
					    sell.selectByIndex(11);
					    
					    WebElement wbsele2 = driver.findElement(By.name("industry"));
					    Select sell1 = new Select(wbsele2);
					    sell1.selectByIndex(2);

					    
					    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']" )).click();
					    
					    //Verify the industries and info
					    String actIndustries = driver.findElement(By.id("dtlview_Industry")).getAttribute("name");
					    if(actIndustries.equals(industries)) {
					    	System.out.println(industries + "info is verified==pass");
					    }else {
					    	System.out.println(orgName + "info is not verified==fail");
					    }
					    
					    String actType = driver.findElement(By.id("dtlview_Type")).getText();
					    if(actIndustries.equals(type)) {
					    	System.out.println(type + "info is verified==pass");
					    }else {
					    	System.out.println(type + "info is not verified==fail");
					    }


					   
					    
					    //Step 5 - logout
					    Actions act=new Actions(driver);
					    Thread.sleep(10000);
					    act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).build().perform();
					    driver.findElement(By.xpath("//a[text()='Sign Out']")).click();		    
					   driver.quit();
				}

	}


