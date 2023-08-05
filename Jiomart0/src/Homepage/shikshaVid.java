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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class shikshaVid {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.shiksha.com/");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		Thread.sleep(2000);
		
		WebDriverWait ref = new WebDriverWait(driver, Duration.ofSeconds(30)); //Not inspectable code to chk diff
		WebElement fr = ref.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//main[@id='main-wrapper']//iframe[@id='mainVideoFrame']")));
		driver.switchTo().frame(fr);
		
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement vidscroll = driver.findElement(By.xpath("//iframe[@id='mainVideoFrame']"));
		js.executeScript("arguments[0].scrollIntoView(true)", vidscroll);

		WebElement dropDowns = driver.findElement(By.xpath("//ul[@class='nav']"));
		System.out.println( dropDowns.getText());
		System.out.println();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(dropDowns).build().perform();

		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='nav']//li"));
		try {
			for (WebElement e : list) {
				Thread.sleep(500);
				act.moveToElement(e).build().perform();
				System.out.println(e.getText());
			}
		} catch (Exception e2) {
			System.out.println(e2.getStackTrace());
		}
	}

}
