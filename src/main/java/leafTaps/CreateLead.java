package leafTaps;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateLead {

	public static ChromeDriver driver = null;
	public static Select dropDown =null; 
	public static String userName ="DemoCSR";
	public static String password ="crmsfa";
	public static String companyName ="MSC TECHNOLOGY";
	public static String firstName = "VIGNESHRAM";
	public static String lastName = "SUNDHARAMOORTHY";
	public static String sourceDropDownText = "Employee";	
	public static String marketingDropDownText = "Car and Driver";
	public static String salutation = "Engineer";
	public static String dateOfBirth ="06/28/93";
	public static String personalTitle ="Test Lead";

	public static void initializeDriver()
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static void loginLeafTaps() throws InterruptedException, AWTException
	{
		driver.get("http://leaftaps.com/opentaps");
		
		WebElement findElementById = driver.findElementById("username");
		
	 
		Robot robot = new Robot();

		// Enter to confirm it is uploaded
		robot.keyPress(KeyEvent.VK_CONTROL);			
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments 
        //Here i pass values based on css style. Yellow background color with solid red color border. 
 driver.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", findElementById);
		//Enter username
		driver.findElementById("username").sendKeys(userName+Keys.TAB);

		//Enter password
		driver.findElementById("password").sendKeys(password);

		driver.findElementByXPath("//input[@type='submit']").sendKeys(Keys.ENTER);

	}

	public static void navigateToCreateLead()
	{
		driver.findElementByXPath("//div[@id='button'][@class='crmsfa']").click();

		driver.findElementByXPath("//div[@class='frameSectionHeader']/following::a[text()='Leads']").click();

		driver.findElementByLinkText("Create Lead").click();


	}

	public static void createLead()
	{
		driver.findElementById("createLeadForm_companyName").sendKeys(companyName);

		driver.findElementById("createLeadForm_firstName").sendKeys(firstName);

		driver.findElementById("createLeadForm_lastName").sendKeys(lastName);

		WebElement sourceDropDown = driver.findElementById("createLeadForm_dataSourceId");
		dropDown = new Select(sourceDropDown);
		dropDown.selectByVisibleText(sourceDropDownText);

		WebElement marketingCampaignId = driver.findElementById("createLeadForm_marketingCampaignId");
		dropDown = new Select(marketingCampaignId);
		dropDown.selectByVisibleText(marketingDropDownText);

		driver.findElementById("createLeadForm_firstNameLocal").sendKeys(firstName);

		driver.findElementById("createLeadForm_lastNameLocal").sendKeys(lastName);

		driver.findElementById("createLeadForm_personalTitle").sendKeys(salutation);

		driver.findElementById("createLeadForm_birthDate").sendKeys(dateOfBirth);

		driver.findElementById("createLeadForm_generalProfTitle").sendKeys(personalTitle);

		driver.findElementById("createLeadForm_departmentName").sendKeys("Testing");

		driver.findElementById("createLeadForm_annualRevenue").sendKeys("10000");

		WebElement preferredCurrency = driver.findElementById("createLeadForm_currencyUomId");
		dropDown = new Select(preferredCurrency);
		dropDown.selectByVisibleText("INR - Indian Rupee");

		WebElement industryDropDown = driver.findElementById("createLeadForm_industryEnumId");
		dropDown = new Select(industryDropDown);
		dropDown.selectByVisibleText("Computer Software");

		driver.findElementById("createLeadForm_numberEmployees").sendKeys("35");

		WebElement ownershipDropDown = driver.findElementById("createLeadForm_ownershipEnumId");
		dropDown = new Select(ownershipDropDown);
		dropDown.selectByVisibleText("Corporation");

		driver.findElementById("createLeadForm_sicCode").sendKeys("100");

		driver.findElementById("createLeadForm_tickerSymbol").sendKeys("100");

		driver.findElementById("createLeadForm_description").sendKeys("This is for Testing");

		driver.findElementById("createLeadForm_importantNote").sendKeys("This is for Testing");

		driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("91");

		driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("0");

		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("7200322380");

		driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("720");

		driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("RAM");

		driver.findElementById("createLeadForm_primaryEmail").sendKeys("VIGNESHRAM001@GMAIL.COM");

		driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("FACEBOOK.COM/vigneshramunnanban");

		driver.findElementById("createLeadForm_generalToName").sendKeys("VIGNESHRAM");

		driver.findElementById("createLeadForm_generalAttnName").sendKeys("VIGNESHRAM");

		driver.findElementById("createLeadForm_generalAddress1").sendKeys("4/54-A,AVAYAMBALPURAM");

		driver.findElementById("createLeadForm_generalAddress2").sendKeys("MAPPADUGAI");

		driver.findElementById("createLeadForm_generalCity").sendKeys("CHENNAI");

		WebElement countryDropDown = driver.findElementById("createLeadForm_generalCountryGeoId");
		dropDown = new Select(countryDropDown);
		List<WebElement> countryOptions = dropDown.getOptions();

		int optionCount = 0;

		for(int i=0;i<countryOptions.size();i++)
		{
			if(countryOptions.get(i).getText().startsWith("I"))
			{
				System.out.println(countryOptions.get(i).getText());
				optionCount++;
				if(optionCount>1)
				{
					dropDown = new Select(countryDropDown);
					dropDown.selectByIndex(i);
					break;
				}
			}
		}


		WebElement stateDropDown = driver.findElementById("createLeadForm_generalStateProvinceGeoId");
		dropDown = new Select(stateDropDown);
		dropDown.selectByVisibleText("TAMILNADU");

		driver.findElementById("createLeadForm_generalPostalCode").sendKeys("609003");

		driver.findElementById("createLeadForm_generalPostalCodeExt").sendKeys("---");

		driver.findElementByName("submitButton").submit();

	}

	public static void verifyLead()
	{
		WebElement firstNameResult = driver.findElementById("viewLead_firstName_sp");
		String firstName=firstNameResult.getText();
		if(firstName.equals("VIGNESHRAM"))
		{
			System.out.println("FirstName matches");
		}
		else
		{
			System.out.println("FirstName not matches");
		}
	}
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

		initializeDriver();

		loginLeafTaps();

		navigateToCreateLead();

		createLead();

		verifyLead();

		Thread.sleep(5000);
		System.out.println("Finished");

	}

}
