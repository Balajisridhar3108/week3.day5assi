package week3.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQERYULSELECTABLE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/selectable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
	     WebElement findElement = driver.findElement(By.xpath("//li[text()='Item 3']"));
	     findElement.click();
	    
		Actions builder = new Actions(driver);
		builder.clickAndHold().moveToElement(findElement).release().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.close();
		
		

	}

}
