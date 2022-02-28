package week3.day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("one plus 9 pro");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		String text = driver.findElement(By.xpath("(//span[@class='a-price']//span[text()='69,999'])[1]")).getText();
		System.out.println(text);
		
		String text2 = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(text2);
		driver.findElement(By.xpath("(//a[@role='button']/i[@class='a-icon a-icon-popover'])[1]")).click();
		
		//String text3 = driver.findElement(By.xpath("(//div[@class='a-meter']/div[@class='a-meter-bar'])[1]")).getText();
		//System.out.println(text3);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//img[@class='s-image']/parent::div)[1]")).click();
		Thread.sleep(2000);
		/*File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File f = new File("./screenshot/amazon.png");
		FileUtils.copyFile(screenshotAs, f);*/
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		
	

	}

}
