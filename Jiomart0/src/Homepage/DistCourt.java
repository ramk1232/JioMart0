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

public class DistCourt {

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

		WebElement SelDropDwn = driver.findElement(By.xpath("//select[@name='sateist']"));

		Select ele = new Select(SelDropDwn);

		List<WebElement> options2 = ele.getOptions();

		int size = options2.size(); // It will give only size like no. of elements present
		System.out.println("size of Disrict is=" + size);

		System.out.println();

		try {
			for (int i = 0; i < options2.size(); i++) {
				Thread.sleep(2000);
				System.out.println(options2.get(i).getText());
				ele.selectByIndex(i);
			}
		} catch (StaleElementReferenceException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();

		System.out.println("--------------Latest Announcements--------------");
		List<WebElement> latAnnouce = driver.findElements(
				By.xpath("(//div[@class='region region-right-sidebar'])//div[1]//div[1]//div[1]//div//ul//li"));
		System.out.println(latAnnouce.size());
		Actions A = new Actions(driver);
		int count = 0;
		for (WebElement ann : latAnnouce) {
			Thread.sleep(300);
			A.moveToElement(ann).build().perform();
			count++;
			System.out.println(count + " " + ann.getText());
		}

	}
}
