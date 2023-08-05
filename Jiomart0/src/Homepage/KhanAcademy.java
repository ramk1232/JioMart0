package Homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KhanAcademy {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.khanacademy.org/login");

		driver.manage().window().maximize();

		Thread.sleep(1000);

		WebElement login = driver.findElement(By.xpath("//a[@id='login-or-signup']"));
		login.click();
		
		Thread.sleep(500);
		
//		driver.findElement(By.xpath("input[@id='uid-login-form-0-wb-id-identifier-field'][1])")).click();

		
		WebElement usrnme = driver.findElement(By.xpath("(//input[@id='uid-login-form-0-wb-id-identifier-field'][1])"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(usrnme));
		usrnme.sendKeys("yesrk786@gmail.com");

//		WebElement usrnme = driver.findElement(By.xpath("input[@id='uid-login-form-0-wb-id-identifier-field'][1])"));
//		usrnme.sendKeys("yesrk786@gmail.com");
		
		Thread.sleep(500);

		WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys("Learn@1234");
		
		Thread.sleep(500);

		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		
		
		
		
		
	}
}