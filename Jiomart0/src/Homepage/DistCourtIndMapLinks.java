package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DistCourtIndMapLinks {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://districts.ecourts.gov.in/maharashtra");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		Thread.sleep(2000);
		int count = 0;
		List<WebElement> mapMaharashtra = driver.findElements(By.xpath("(//div[@class='item-list'])//ul//li"));
		System.out.println(mapMaharashtra.size());
		Actions A = new Actions(driver);
		try {
			for (WebElement m : mapMaharashtra) {
				Thread.sleep(300);
				A.moveToElement(m).build().perform();
				count++;
				System.out.println(count + " " + m.getText());
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}
	}

}
