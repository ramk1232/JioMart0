package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AutoSuggFlipkart {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // Deletes all the cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		Thread.sleep(3000);

		try {
			WebElement popup = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			Thread.sleep(1000);
			popup.click();
		} catch (Exception e) {
			e.getStackTrace();
		}

		//// To Serch product in sech box

		WebElement serch = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		serch.sendKeys("Redmi note 12 pro 5g");

		Thread.sleep(2000);
		Actions A = new Actions(driver);

		// To print serch box autoSuggession
		System.out.println("-----------------------------------");
		List<WebElement> suggBox = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']//li"));
		for (WebElement sug : suggBox) {
			A.moveToElement(sug).build().perform();
			System.out.println(sug.getText());
		}
	}
}
