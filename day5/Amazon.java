package week3.day5;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

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
		
		String price = driver.findElement(By.xpath("(//span[@class='a-price']//span[text()='69,999'])[1]")).getText();
		System.out.println(price+".rs");
		
		String text2 = driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style']//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println(text2+":ratings");
		driver.findElement(By.xpath("(//a[@role='button']/i[@class='a-icon a-icon-popover'])[1]")).click();
		
		//String text3 = driver.findElement(By.xpath("(//div[@class='a-meter']/div[@class='a-meter-bar'])[1]")).getText();
		//System.out.println(text3);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//img[@class='s-image']/parent::div)[1]")).click();
		String text3 = driver.findElement(By.xpath("(//td[@class='a-text-right a-nowrap'])[1]")).getText();
		System.out.println(text3+":percentage");
		Thread.sleep(2000);
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File f = new File("./screenshot/amazon.png");
		FileUtils.copyFile(screenshotAs, f);
		
	
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>  newWindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		String subTotal = driver.findElement(By.xpath("(//div[@class='a-column a-span11 a-text-left a-spacing-top-large']//span)[3]")).getText();
		String replaceAll = subTotal.replaceAll(".00","");
		System.out.println("SUBTOTAL :"+replaceAll);
		
		//Verify with price and subTotal 
		if(price.equals(replaceAll)){
			System.out.println("Both Total Are Correct");
		}else {
			System.out.println("Both Total Are InCorrect");
		}
		Thread.sleep(1500);
	    driver.quit();
			
			}
}
		
	

	


