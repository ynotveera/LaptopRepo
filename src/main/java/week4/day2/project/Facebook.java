package week4.day2.project;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Facebook {

	static void GetLikedCount(ChromeDriver driver)
	{
		//Check for the liked count
		String LikeCount = driver.findElementByXPath("(//div[@class='_4bl9'])[3]/div").getText();

		LikeCount = LikeCount.substring(0, LikeCount.length()-17);

		System.out.println(LikeCount); 
	}

	static void LoginFacebook(ChromeDriver driver,String userName, String password)
	{
		//Login the Page
		driver.findElementById("email").sendKeys(userName);
		driver.findElementById("pass").sendKeys(password);
		driver.findElementByXPath("//input[@value='Log In']").click();
	}

	static void SearchFacebook (ChromeDriver driver,String giveString)
	{
		//Search For TestLeaf
		driver.findElementByXPath("//input[@placeholder='Search']").sendKeys(giveString+Keys.TAB);
		driver.findElementByXPath("//button[@aria-label='Search']").submit();

		//Click the Link
		driver.findElementByXPath("//a[text()='"+giveString+"']").click();

	}
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//Initialize Chrome
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(ops);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		LoginFacebook(driver, "7200322380", "iliveforeveralone");

		SearchFacebook(driver, "TestLeaf");

		//Wait for the page to get loaded
		Thread.sleep(3000);

		try
		{

			WebElement findElementByXPath = driver.findElementByXPath("(//span[@class='_55pe'])[4]");

			if(findElementByXPath!=null)
			{
				System.out.println("Page is already Liked..attempting to get the liked count");

				GetLikedCount(driver);

			}
		}
		catch(org.openqa.selenium.NoSuchElementException NS )
		{
			System.out.println("Page is Not Liked..Attempting to Like");


			String likedOrNot = driver.findElementByXPath("(//button[@type='submit'])[3]").getText();

			if(likedOrNot.equals("Like"))
			{
				//Click Like
				driver.findElementByXPath("(//button[@type='submit'])[3]").click();
				System.out.println("Page is Liked");
			}
			GetLikedCount(driver);

		}

	}

}
