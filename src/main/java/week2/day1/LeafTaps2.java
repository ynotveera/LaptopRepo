package week2.day1;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LeafTaps2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.testdiary.com/training/selenium/selenium-test-page");
		driver.get("http://facebook.com");
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		File abc = driver.getScreenshotAs(OutputType.FILE);
		File bd = new File("dfb.jpg");
		FileUtils.copyFile(abc, bd);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("java1")).click();
		
		boolean a = driver.findElementById("demo").isEnabled();
		
		System.out.println(a);
	

	}

}
