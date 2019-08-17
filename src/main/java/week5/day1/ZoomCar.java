package week5.day1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ZoomCar {

	@Test
	public void runZoomCar() throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.zoomcar.com/chennai/search");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		
		Thread.sleep(3000);

		driver.findElementByXPath("//div[@class='component-popular-locations']//following::div").click();

		driver.findElementByXPath("//button[text()='Next']").click();

		String SelectedMonth = driver.findElementByXPath("//div[@class='months']/div[@class='month picked']").getText();

		SelectedMonth = SelectedMonth.replaceAll("\\s", "");

		System.out.println(SelectedMonth);
		
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMM");
		
		for(int i=1;i<=12;i++)
		{
			
			if(sdf.format(currentDate.getTime()).equalsIgnoreCase(SelectedMonth))
			{
				currentDate.add(Calendar.MONTH, 1);
				break;
			}
			currentDate.add(Calendar.MONTH, 1);
		}

		String format = sdf.format(currentDate.getTime());
		
		System.out.println(format);
		
		driver.findElementByXPath("//div[@class='months']/div[contains(text(),'"+format+"')]").click();
		
		driver.findElementByXPath("//button[text()='Next']").click();
		
		driver.findElementByXPath("//button[text()='Done']").click();
		driver.close();
		
		
	}

}
