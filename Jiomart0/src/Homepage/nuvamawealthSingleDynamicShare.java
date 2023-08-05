package Homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class nuvamawealthSingleDynamicShare {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.nuvamawealth.com/quotes/options/nifty~2023-07-27~19950~pe");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		Thread.sleep(2000);

		WebElement flexOnTop = driver.findElement(By.xpath("(//div[@class='container-fluid']//div[@class='row'])[2]"));
		// Total no of rows present in table
		System.out.println();
		for (int i = 0; i < 4; i++) {
			Thread.sleep(5000);
			System.out.println(flexOnTop.getText());
			System.out.println("");
		}
	}
}
