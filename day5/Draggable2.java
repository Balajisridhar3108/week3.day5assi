package week3.day5;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/draggable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='draggable']/.."));
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(findElement, 100,50).build().perform();
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
	
		

	}
		

	}


