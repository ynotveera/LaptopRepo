package ImplementationClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLeadSteps {
	public static ChromeDriver driver = null;
	
	@Given("Login the LeafTaps")
	public void loginTheLeafTaps() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps");

		//Enter username
		driver.findElementById("username").sendKeys("DemoCSR"+Keys.TAB);

		//Enter password
		driver.findElementById("password").sendKeys("crmsfa");

		driver.findElementByXPath("//input[@type='submit']").sendKeys(Keys.ENTER);

	}

	@And("Navigate to CreateLeadPage")
	public void navigateToCreateLeadPage() {
		driver.findElementByXPath("//div[@id='button'][@class='crmsfa']").click();

		driver.findElementByXPath("//div[@class='frameSectionHeader']/following::a[text()='Leads']").click();

		driver.findElementByLinkText("Create Lead").click();
		
		driver.findElementById("createLeadForm_companyName").sendKeys("MSC PVT LTD");

	}

	@And("Provide FirstName as (.*)")
	public void provideFirstName(String fName) {		

		driver.findElementById("createLeadForm_firstName").sendKeys(fName);

		
	}

	@And("Provide LastName as (.*)")
	public void provideLastName(String lName) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lName);
	}

	@When("Save")
	public void save() {
		driver.findElementByName("submitButton").submit();
	}

	@Then("Verify the Lead Created")
	public void verifyTheLeadCreated() {
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

}
