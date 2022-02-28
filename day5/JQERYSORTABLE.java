package week3.day5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JQERYSORTABLE {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.xpath("//li[text()='Item 4']"));
		findElement.click();
		WebElement element = driver.findElement(By.xpath("//li[text()='Item 7']"));
		element.click();
		Actions builder = new Actions(driver);
		builder.clickAndHold(element).moveToElement(findElement).click().perform();
		Thread.sleep(2000);
		driver.close();
		

	}

}
