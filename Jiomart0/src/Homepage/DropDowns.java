package Homepage;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DropDowns {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));		

		driver.get("https://www.jiomart.com");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		WebElement Groceries = driver.findElement(By.id("nav_link_2"));
		System.out.println("===========" + Groceries.getText() + "========");
		Actions act = new Actions(driver);
		act.moveToElement(Groceries).build().perform();

		List<WebElement> list = driver.findElements(By.xpath("//li[@id='nav_cat_2']/div/ul/li/a"));
		List<WebElement> Hidlist = driver.findElements(By.xpath("//li[@class='header-nav-l3-item']"));

		for (WebElement e : list) {
			System.out.println(e.getText());
			Thread.sleep(1000);
			for (WebElement ee : Hidlist) {
				act.moveToElement(e).build().perform();
				Thread.sleep(1000);
				act.moveToElement(ee).build().perform();
				System.out.println(ee.getText());

			}
			Thread.sleep(300);
			act.moveToElement(e).build().perform();
			System.out.println(e.getText());
		}

		Thread.sleep(2000);

//		WebElement premiumfruits = driver.findElement(By.id("nav_link_6047"));
//		System.out.println("===========" + premiumfruits.getText() + "========");
//		Actions act1 = new Actions(driver);
//		act1.moveToElement(premiumfruits).build().perform();
//
//		List<WebElement> list1 = driver.findElements(By.xpath("//li[@id='nav_cat_6047']/div/ul/li/a"));
//
//		for (WebElement f : list1) {
//			Thread.sleep(300);
//			act.moveToElement(f).build().perform();
//			System.out.println(f.getText());
//		}

		driver.close();

	}

}