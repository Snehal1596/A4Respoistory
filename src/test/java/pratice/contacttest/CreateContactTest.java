package pratice.contacttest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genric.webdriverutility.JavaUtility;

public class CreateContactTest {
	public static WebDriver driver=null;
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
        FileUtility flib = new FileUtility();
        ExcelUtility elib = new ExcelUtility();
        JavaUtility jlib = new JavaUtility();
		
		String Browser=flib.getDataFromPropertiesFile("browser");
		String url=flib.getDataFromPropertiesFile("url");
		String password=flib.getDataFromPropertiesFile("password");
		String username=flib.getDataFromPropertiesFile("username");

		System.out.println(Browser);
							
		//read scriptdata from excel file
		String lastName = elib.getDataFromExcel("Contact", 1, 2)+jlib.getRandomNumber();		
					
					
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
					//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
					driver.get(url);
					driver.findElement(By.name("user_name")).sendKeys(username);
					driver.findElement(By.name("user_password")).sendKeys(password);
				    driver.findElement(By.id("submitButton")).click();
				    
				    //STEP 2 - navigate to organization module
				    driver.findElement(By.linkText("Contacts")).click(); 
				    
				    //STEP 3- click on "create oraganization" button
				    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				    
				    //STEP 4 - Enter all the details & crate new organization
				    driver.findElement(By.name("lastname")).sendKeys(lastName);
				    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']" )).click();
				    
				    //VErify header msg expected result
				    String info=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				    //String headerInfo = driver.findElement(By.xpath("//span[Text()='[ ACC19 ] bgvgbh -  Organization Information']")).getText();
				    if(info.contains(lastName)) {
				    	System.out.println(lastName + "is created==pass");
				    }else {
				    	System.out.println(lastName + "is not created==fail");
				    }
				    //Verify header orgname info Expected result 
				    String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
				    if(actLastName.equals(lastName)) {
				    	System.out.println(lastName + "information is created==pass");
				    }else {
				    	System.out.println(lastName + "information is not created==fail");
				    }
				    		    
				   driver.quit();
		}

}
