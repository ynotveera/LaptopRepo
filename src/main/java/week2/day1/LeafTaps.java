package week2.day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class LeafTaps {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.softwaretestingmaterial.com/sample-webpage-to-automate/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		WebElement multiselect = driver.findElementByName("multipleselect[]");
		
		Select d1 = new Select(multiselect);
		
		//d1.selectByIndex(0);
		//d1.selectByIndex(7);
		//d1.deselectAll();
		
//		driver.findElement(by)
//		
//		NoSuchElementException
		
		System.out.println(d1.getFirstSelectedOption().getText()); 
		
		List<WebElement> allSelectedOptions = d1.getOptions();
		
		for (WebElement webElement : allSelectedOptions) {
			
			System.out.println(webElement.getText());
			
		}
		
		
		
		
		
		
/*		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").sendKeys(Keys.SPACE);
		
		Rectangle attribute1 = driver.findElementByXPath("//img[contains(@src,'crm.png')]").getRect();
		//Point point = attribute1.getPoint();
		//attribute1.setHeight(459);
		System.out.println(attribute1.);
		System.out.println(attribute1.getHeight());
		//String attribute1 = driver.findElementByXPath("//img[contains(@src,'crm.png')]").getCssValue("color");
		//String attribute1Color[] = attribute1.replace("rgba(", "").replace(")", "").split(",");
		
		//int hex1 = Integer.parseInt(attribute1Color[0].trim());
		//int hex2 = Integer.parseInt(attribute1Color[1].trim());
		//int hex3 = Integer.parseInt(attribute1Color[2].trim());
		
		//String actualColor = String.format("#%02x%02x%02x", hex1,hex2,hex3);
		//System.out.println(actualColor);
		System.out.println(attribute1);
		String attribute = driver.findElementByLinkText("CRM/SFA").getCssValue("color");
		System.out.println(attribute);
		System.out.println(driver.getTitle());

		driver.findElementByLinkText("Create Lead").click();
		
		WebElement DropDown =null;
		DropDown = driver.findElementById("createLeadForm_dataSourceId");
		Select selectDropDown = new Select(DropDown);
		
		for(int i=0;i<selectDropDown.getOptions().size();i++)
		{
			
			selectDropDown.selectByIndex(i);
		}
		//selectSourceDropDown.selectByVisibleText("Existing Customer");
		
		DropDown = driver.findElementById("createLeadForm_marketingCampaignId");
		selectDropDown = new Select(DropDown);
		selectDropDown.selectByIndex(selectDropDown.getOptions().size()-1);
		
		DropDown = driver.findElementById("createLeadForm_industryEnumId");
		selectDropDown.selectByValue("CATRQ_AUTOMOBILE");
		
		
		
		
*/		
		
		


	}

}
