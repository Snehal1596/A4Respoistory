package section2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions4 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Actions act = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();                                                  
		driver.get("https://demoapps.qspiders.com/");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//p[text()='UI Testing Concepts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//section[text()='Mouse Actions']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//section[text()='Click & Hold']")).click();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.xpath("//div[@id='circle']"));
		Thread.sleep(3000);
		act.clickAndHold(element).perform();
		Thread.sleep(3000);
		act.release().perform();
	}

}
