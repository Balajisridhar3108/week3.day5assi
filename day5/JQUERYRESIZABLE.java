package week3.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQUERYRESIZABLE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resizable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='resizable']/parent::body"));
		WebElement findElement2 = driver.findElement(By.id("resizable"));
		WebElement findElement3 = driver.findElement(By.xpath("(//div[@id='resizable']/div[@style='z-index: 90;'])[3]"));
		Actions resize = new Actions(driver);
		resize.dragAndDropBy(findElement3, 150, 100).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		driver.close();
		
		

	}

}
