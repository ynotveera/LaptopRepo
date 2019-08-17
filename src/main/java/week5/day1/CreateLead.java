package week5.day1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.LearnExcelRead;

public class CreateLead extends Annotations{

	public static Select dropDown =null; 
	//public static String companyName ="MSC TECHNOLOGY";
	//public static String firstName = "VIGNESHRAM";
	//public static String lastName = "SUNDHARAMOORTHY";
	public static String sourceDropDownText = "Employee";	
	public static String marketingDropDownText = "Car and Driver";
	public static String salutation = "Engineer";
	public static String dateOfBirth ="06/28/93";
	public static String personalTitle ="Test Lead";
	

	public static void navigateToCreateLead()
	{
		driver.findElementByXPath("//div[@id='button'][@class='crmsfa']").click();

		driver.findElementByXPath("//div[@class='frameSectionHeader']/following::a[text()='Leads']").click();

		driver.findElementByLinkText("Create Lead").click();


	}

	public static void createLead(String a,String b,String c) throws InterruptedException
	{
		driver.findElementById("createLeadForm_companyName").sendKeys(a);

		driver.findElementById("createLeadForm_firstName").sendKeys(b);

		driver.findElementById("createLeadForm_lastName").sendKeys(c+Keys.TAB);
		Thread.sleep(2000);
		WebElement sourceDropDown = driver.findElementById("createLeadForm_dataSourceId");
		dropDown = new Select(sourceDropDown);
		Thread.sleep(2000);
		dropDown.selectByVisibleText(sourceDropDownText);

		WebElement marketingCampaignId = driver.findElementById("createLeadForm_marketingCampaignId");
		dropDown = new Select(marketingCampaignId);
		dropDown.selectByVisibleText(marketingDropDownText);

		driver.findElementById("createLeadForm_firstNameLocal").sendKeys(b);

		driver.findElementById("createLeadForm_lastNameLocal").sendKeys(c);

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
		driver.findElement(By.className(""));

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
	
	@Test(dataProvider = "dataSource")
	public void runCreateLead(String a , String b, String c) throws InterruptedException {
		// TODO Auto-generated method stub

		//
		navigateToCreateLead();

		createLead(a,b,c);

		verifyLead();

		Thread.sleep(2000);
		//System.out.println("Finished");
		//driver.close();

	}
	
	@BeforeTest
	public void runBeforeTest()
	{
		fileName = "workbook1";
	}
	

}
