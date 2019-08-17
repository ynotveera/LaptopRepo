package week5.day1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week5.day2.LearnExcelRead;

public class Annotations {

	public String fileName;
	public static String userName ="DemoCSR";
	public static String password ="crmsfa";
	public static ChromeDriver driver = null;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void loginLeafTaps(String pageURL, String usrName ,String pass)
	{	
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		/*Actions builder = new Actions(driver);
		builder.*/
		
		driver.get(pageURL);

		//Enter username
		driver.findElementById("username").sendKeys(usrName);

		//Enter password
		driver.findElementById("password").sendKeys(pass);

		driver.findElementByXPath("//input[@type='submit']").sendKeys(Keys.ENTER);

	}

	@AfterMethod
	public void closeWebBrowser()
	{
		System.out.println("Finished");
		driver.close();
	}
	
	@DataProvider(name="dataSource")
	public String[][] dataSource() throws InvalidFormatException, IOException
	{
		/*String[][] data = new String[1][3];
		data[0][0] = "test";
		data[0][1] = "Vignesh";
		data[0][2] = "Ram";*/
		
		return LearnExcelRead.readExcelData(fileName);
	}

}
