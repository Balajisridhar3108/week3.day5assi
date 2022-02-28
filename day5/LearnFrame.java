package week3.day5;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.switchTo().frame(0);
		WebElement findElement = driver.findElement(By.id("Click"));
		findElement.click();
		String text = findElement.getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame2");
		WebElement findElement2 = driver.findElement(By.id("Click1"));
		findElement2.click();
		String text2 = findElement2.getText();
		System.out.println(text2);
		driver.switchTo().defaultContent();
		
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File fl= new File("./screenshot/LeafFrame.png");
		FileUtils.copyFile(screenshotAs, fl);
		
		
		
	

	}

}
