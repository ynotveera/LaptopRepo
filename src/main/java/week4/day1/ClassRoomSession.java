package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.*;

public class ClassRoomSession {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.switchTo().frame(1);
		// driver.switchTo().frame(driver.findElementByXPath("//iframe[@id='iframeResult']"));

		WebElement TryIt = driver.findElementByXPath("//button[text()='Try it']");

		TryIt.click();

		Alert alert = driver.switchTo().alert();

//		String string = alert.toString();
//		System.out.println(string);
		String givenText = "Hi Praveen & Kokila";
		alert.sendKeys(givenText);
		
		alert.accept();

		Set<String> Sets = new HashSet<String>();
		// alert.dismiss();

		String text = driver.findElementById("demo").getText();

		System.out.println(text);

		text = text.substring(6, 6 + givenText.length());

		System.out.println(text);

		TryIt.click();

		driver.switchTo().alert();

		String text2 = alert.getText();
		System.out.println(text2);

	}

}
