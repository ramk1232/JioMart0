package Homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Baner2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);

		driver.get("https://www.jiomart.com");

		driver.manage().window().maximize();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("window.scrollBy(0,10000)"); // scroll down pixels

		Thread.sleep(2000);

		List<WebElement> slides = driver.findElements(By.xpath(
				"//div[@class='swiper-button-next swiper-ver-btn-next home-verti-right-0 swiper-button-disabled']"));

		for (WebElement s : slides) {
			Thread.sleep(200);
			s.click();
		}
	}
}
