package section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions6 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();                                                  
		driver.get("https://www.flipkart.com/");
		WebElement element = driver.findElement(By.xpath("//span[text()='Login']"));
		act.moveToElement(element).contextClick().perform();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.xpath("//input[@name='q']"));
		Thread.sleep(4000);
		
	}

}
