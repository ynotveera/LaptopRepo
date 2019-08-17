package leafTaps;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditLead {
	
	public static void navigateToFindLeads()
	{
		CreateLead.driver.findElementByXPath("//div[@id='button'][@class='crmsfa']").click();

		CreateLead.driver.findElementByXPath("//div[@class='frameSectionHeader']/following::a[text()='Leads']").click();

		CreateLead.driver.findElementByLinkText("Find Leads").click();

	}

	public static void FindLeads()
	{
		CreateLead.driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys(CreateLead.firstName);
		CreateLead.driver.findElementByXPath("//button[text()='Find Leads']").click();
	}
	
	public static void EditLead() throws InterruptedException
	{
		Thread.sleep(450);
		WebDriverWait wait = new WebDriverWait(CreateLead.driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//table[@class='x-grid3-row-table']//a)[1]"))).click();
		CreateLead.driver.findElementByLinkText("Edit").click();
		CreateLead.driver.findElementById("updateLeadForm_companyName").clear();
		CreateLead.driver.findElementById("updateLeadForm_companyName").sendKeys(CreateLead.companyName+" Private LTD.");
		CreateLead.driver.findElementByName("submitButton").click();
	}
	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub67
		CreateLead.initializeDriver();
		CreateLead.loginLeafTaps();
		navigateToFindLeads();
		FindLeads();
		EditLead();
		
	}

}
