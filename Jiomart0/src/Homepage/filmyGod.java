package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class filmyGod {

	WebDriver driver;

	public filmyGod(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void start() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement vidscroll = driver.findElement(By.xpath("//div[@class='bw_title']"));
		js.executeScript("arguments[0].scrollIntoView(true)", vidscroll);

		Actions A = new Actions(driver);
		try {
			List<WebElement> arr = driver
					.findElements(By.xpath("//div[@class='row']//div//div//div[@class='bw_title']"));
			System.out.println(arr.size());
			for (WebElement ar : arr) {
				Thread.sleep(100);
				A.moveToElement(ar).build().perform();
				// ar.click();
				// driver.navigate().back();
				// js.executeScript("window.scrollBy(0,100)"); // scroll down pixels
				System.out.println(ar.getText());
			}
			WebElement nxtBttn = driver.findElement(By.xpath("//a[@class='nextpostslink']"));
			nxtBttn.click();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://w.filmygod.io/hollywood/");

		driver.manage().window().maximize();

		Thread.sleep(2000);

		try {
			filmyGod filmyGod = new filmyGod(driver);
			for (int i = 1; i <= 10; i++) {
				filmyGod.start();
				Thread.sleep(5000);
			}
		} catch (Exception exx) {
			exx.getStackTrace();
		}
	}
}
