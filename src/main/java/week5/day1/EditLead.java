package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditLead extends Annotations{
	
	public static void navigateToFindLeads()
	{
		driver.findElementByXPath("//div[@id='button'][@class='crmsfa']").click();

		driver.findElementByXPath("//div[@class='frameSectionHeader']/following::a[text()='Leads']").click();

		driver.findElementByLinkText("Find Leads").click();

	}

	public static void FindLeads(String firstName)
	{
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(firstName);
		driver.findElementByXPath("//button[text()='Find Leads']").click();
	}
	
	public static void EditLead() throws InterruptedException
	{
		Thread.sleep(450);
		WebDriverWait wait = new WebDriverWait(CreateLead.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"))).click();
		driver.findElementByLinkText("Edit").click();
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("Test"+" Private LTD.");
		driver.findElementByName("submitButton").click();
	}
	@Test(dataProvider = "dataSource")
	public void runEditLead(String a) throws InterruptedException {
		// TODO Auto-generated method stub67
		navigateToFindLeads();
		FindLeads(a);
		EditLead();
		//CreateLead.driver.close();
	
		
	}
	
	@BeforeTest
	public void runBeforeTest()
	{
		fileName = "EditLead";
	}
	

}
