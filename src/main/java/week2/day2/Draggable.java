package week2.day2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://jqueryui.com/draggable/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		
		WebElement sourceObj = driver.findElementById("draggable");
		Actions builder = new Actions(driver);
		builder.clickAndHold(sourceObj).moveByOffset(100, 150).perform();
		
		builder.dragAndDropBy(sourceObj, 100, 10).perform();
		
		
		
		
		
		

	}

}
