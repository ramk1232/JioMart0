package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class flexFlipkart {

	public WebDriver driver;
	static Actions A;
	static JavascriptExecutor js;

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

		driver.navigate().refresh();

		js = (JavascriptExecutor) driver;

		Thread.sleep(3000);
		A = new Actions(driver);
		try {
			List<WebElement> arr = driver
					.findElements(By.xpath("//div[@class='_331-kn _2tvxW']//div//div//div"));
			System.out.println(arr.size());
			for (WebElement ar : arr) {
				Thread.sleep(100);
				A.moveToElement(ar).build().perform();
				//ar.click();
				//driver.navigate().back();
				//js.executeScript("window.scrollBy(0,100)"); // scroll down pixels
				System.out.println(ar.getText());
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
