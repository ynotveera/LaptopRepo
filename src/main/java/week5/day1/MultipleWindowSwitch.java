package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class MultipleWindowSwitch extends Annotations {

		@Test
	public void runMergeLead() throws InterruptedException {
		// TODO Auto-generated method stub

	
		driver.findElementByLinkText("CRM/SFA").click();
		System.out.println(driver.getTitle());
		driver.findElementByLinkText("Leads").click();
		driver.findElementByLinkText("Merge Leads").click();
		driver.findElementByXPath("//img[contains(@src,'fieldlookup.gif')]").click();
		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList = new ArrayList<String>(windows);
		driver.switchTo().window(windowsList.get(1)).manage().window().maximize();
		Thread.sleep(450);
		WebDriverWait wait = new WebDriverWait(driver,15);
		WebElement webElement;
		wait.until(ExpectedConditions.elementToBeClickable(webElement =driver.findElementByXPath("(//table[@class='x-grid3-row-table']//a)[1]")));
		String FirstID = webElement.getText();
		webElement.click();
		driver.switchTo().window(windowsList.get(0)).manage().window().maximize();
		driver.findElementByXPath("(//img[contains(@src,'fieldlookup.gif')])[2]").click();
		windows = driver.getWindowHandles();
		windowsList = new ArrayList<String>(windows);
		driver.switchTo().window(windowsList.get(1)).manage().window().maximize();
		wait.until(ExpectedConditions.elementToBeClickable(webElement =driver.findElementByXPath("(//table[@class='x-grid3-row-table'])[2]//a")));
		webElement.click();
		driver.switchTo().window(windowsList.get(0)).manage().window().maximize();
		driver.findElementByXPath("//a[text()='Merge']").click();
		driver.switchTo().alert().accept();
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys(FirstID);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		webElement =null;
		wait.until(ExpectedConditions.elementToBeClickable(webElement =driver.findElementByClassName("x-paging-info")));
		System.out.println(webElement.getText());
		driver.quit();

		/*		driver.findElementByXPath("//button[text()='Find Leads']").click();

		Thread.sleep(250);
		org.openqa.selenium.support.ui.WebDriverWait wait = new org.openqa.selenium.support.ui.WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath("(//table[@class='x-grid3-row-table']//a)[1]"))).click();*/

	}

}
