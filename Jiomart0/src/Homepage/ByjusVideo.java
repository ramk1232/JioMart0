package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ByjusVideo {
	WebElement vidscroll;

	public static void main(String[] args) throws InterruptedException {
		List<WebElement> videos = null;
		String videoName;
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get(
				"https://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw30p2qYMoe8xOHblLDi_uHpY-rPiZwNcjD2aSjj0kksaMtQvK4RH9EaAthoEALw_wcBhttps://byjus.com/byjus-classes-book-free-60-mins-class/?utm_source=google&utm_mode=CPA&utm_campaign=K10-IN-Brand-BYJU%27S-USD-Exact&utm_term=byjus&gclid=Cj0KCQjwy5maBhDdARIsAMxrkw30p2qYMoe8xOHblLDi_uHpY-rPiZwNcjD2aSjj0kksaMtQvK4RH9EaAthoEALw_wcB");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement vidscroll = driver.findElement(By.xpath("//a[@class='video-thumbnail']"));
		js.executeScript("arguments[0].scrollIntoView(true)", vidscroll);

		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control video-selection']"));
		Select se = new Select(dropdown);
		for (int i = 0; i < 7; i++) {
			se.selectByIndex(i);
			System.out.println("Available Videos for class " + (i + 4));

			videos = driver.findElements(By.xpath("//div[@class='row row-inline']//a"));
			if (videos.size() == 2) {
				System.out.println("passed");
			}
			Thread.sleep(2000);
			videos.get(0).click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			videoName = driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']")).getText();
			System.out.println(videoName);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[14])")).click();

			Thread.sleep(2000);
			videos.get(1).click();
			Thread.sleep(2000);
			driver.switchTo().frame(0);
			videoName = driver.findElement(By.xpath("//a[@class='ytp-title-link yt-uix-sessionlink']")).getText();
			System.out.println(videoName);
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//button[@type='button'])[14])")).click();
		}
	}
}
