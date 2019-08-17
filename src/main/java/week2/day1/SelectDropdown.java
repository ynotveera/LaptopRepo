package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/");

		driver.manage().window().maximize();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();

		driver.findElementByLinkText("CRM/SFA").click();
		System.out.println(driver.getTitle());

		driver.findElementByLinkText("Create Lead").click();
		driver.findElementById("createLeadForm_companyName").sendKeys("MSC TECHNOLOGY");
		
		driver.findElementById("createLeadForm_firstName").sendKeys("VIGNESHRAM");
		driver.findElementById("createLeadForm_lastName").sendKeys("SUDHARAMOORTHY");
		driver.findElementByName("submitButton").click();
		System.out.println(driver.getTitle());


	}

}
