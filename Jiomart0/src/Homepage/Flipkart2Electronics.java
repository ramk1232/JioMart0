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

public class Flipkart2Electronics {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		Thread.sleep(1000);

		WebElement popup = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		Thread.sleep(1000);
		popup.click();

		Thread.sleep(1000);
		Actions act = new Actions(driver);

		WebElement Electronics = driver.findElement(By.linkText("Electronics"));
		System.out.println("===========" + Electronics.getText() + "========");
		Thread.sleep(3000);
		Actions actEle = new Actions(driver);
		actEle.moveToElement(Electronics).build().perform();

		List<WebElement> listEle = driver.findElements(By.xpath("//a[@class='_6WOcW9']"));
		List<WebElement> HidlistEle = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));

		for (WebElement el : listEle) {
			Thread.sleep(2000);
			for (WebElement HiEle : HidlistEle) {
				act.moveToElement(el).build().perform();
				Thread.sleep(2000);
				act.moveToElement(HiEle).build().perform();
				System.out.println(HiEle.getText());

				try {
					Thread.sleep(3000);
					act.moveToElement(HiEle).build().perform();
					System.out.println(HiEle.getText());
					System.out.println("TRY");
				} catch (StaleElementReferenceException f) {
					System.out.println("Catch");
					act.moveToElement(HiEle).build().perform();
					System.out.println(HiEle.getText());
					f.getStackTrace();

				} finally {
					System.out.println("Finally");

					act.moveToElement(HiEle).build().perform();
					System.out.println(HiEle.getText());
				}
			}
			
			Thread.sleep(3000);
			driver.close();
		}
	}
}
	
