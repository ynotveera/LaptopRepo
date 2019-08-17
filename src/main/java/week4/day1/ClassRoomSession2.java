package week4.day1;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ClassRoomSession2 {

	public static void main(String[] args) throws InterruptedException,IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/nget/train-search");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		File latestSS = new File("./snapshot/IMG01.jpg");
		FileUtils.copyFile(screenShot, latestSS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.findElementByXPath("//span[text()='AGENT LOGIN']").click();
		System.out.println(driver.getTitle());
		screenShot = driver.getScreenshotAs(OutputType.FILE);
		latestSS = new File("./snapshot/IMG02.jpg");
		FileUtils.copyFile(screenShot, latestSS);
		driver.findElementByLinkText("Contact Us").click();
		screenShot = driver.getScreenshotAs(OutputType.FILE);
		latestSS = new File("./snapshot/IMG03.jpg");
		FileUtils.copyFile(screenShot, latestSS);
		Set<String> windowsOpened = driver.getWindowHandles();
		List<String> WindowsList = new ArrayList<String>(windowsOpened);
		driver.switchTo().window(WindowsList.get(1));
		driver.manage().window().maximize();
		screenShot = driver.getScreenshotAs(OutputType.FILE);
		latestSS = new File("./snapshot/IMG04.jpg");
		FileUtils.copyFile(screenShot, latestSS);
		System.out.println(driver.getTitle());
		//driver.switchTo().window(WindowsList.get(0)).close();
		driver.quit();
		//driver.switchTo().window(WindowsList.get(1)).close();
		
	}

}
