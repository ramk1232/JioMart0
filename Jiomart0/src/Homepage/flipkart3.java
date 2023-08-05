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

public class flipkart3 {

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
		WebElement Mobiles = driver.findElement(By.linkText("Mobiles"));
		Mobiles.click();
		Actions act = new Actions(driver);
		Thread.sleep(2000);

		WebElement Electronics = driver.findElement(By.xpath("//span[@class='_2I9KP_']"));
		System.out.println("===========" + Electronics.getText() + "========");
		Thread.sleep(3000);
		Actions actEle = new Actions(driver);
		Thread.sleep(1000);
		actEle.moveToElement(Electronics).build().perform();

		List<WebElement> ElectronicsEle = driver.findElements(By.xpath("//a[@class='_3QN6WI']"));

		for (WebElement ElecEle : ElectronicsEle) {
			Thread.sleep(1000);
			act.moveToElement(ElecEle).build().perform();
			System.out.println(ElecEle.getText());
		}
		Thread.sleep(3000);
		driver.close();
	}
}
