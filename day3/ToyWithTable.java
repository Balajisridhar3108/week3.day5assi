package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToyWithTable {
	public static void main(String[] args) {
		
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
	driver.get("http://www.Leafground.com/pages/table.html");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	List<WebElement> elements = driver.findElements(By.tagName("th"));
	int size = elements.size();
	System.out.println("coloumnCount:"+size);
	
	List<WebElement> elements2 = driver.findElements(By.tagName("tr"));
	int size2 = elements2.size();
	System.out.println("rowsize2:"+size2);
	
	String text = driver.findElement(By.xpath("//td[text()='Learn to interact with Elements']/following-sibling::td[1]")).getText();
	System.out.println(text);
	
	List<Integer> value= new ArrayList <Integer>();
	
	for(int i=2;i<=size2;i++) {
		
		  String text2 = driver.findElement(By.xpath("//table[@id='table_id']//tr["+i+"]//td[2]")).getText();
		   
		  String replaceAll = text2.replaceAll("%", "");
		  System.out.println(replaceAll);
		  
		  int parseInt = Integer.parseInt(replaceAll);
		  value.add(parseInt);
	}
	


}}
