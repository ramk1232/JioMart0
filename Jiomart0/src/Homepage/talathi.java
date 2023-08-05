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

public class talathi {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://cdn3.digialm.com/EForms/configuredHtml/32664/83978/Registration.html");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Not inspectable code to chk diff
		WebElement adClose = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[5]")));

		adClose.click();
		
		Thread.sleep(2000);


		List<WebElement> noofrows = driver.findElements(By.xpath("(//div[@class='modal-content efrmgen-modal-content'])[2]//table//tr"));
		// Total no of rows present in table


		try {

			System.out.println("no of rows=" + noofrows.size());

			for (int i = 1; i < noofrows.size(); i++) {
				List<WebElement> noofcells = driver.findElements(By.xpath("((//table)[4])//tr[" + (i + 1) + "]//td"));
				System.out.println(noofcells.size());

				for (int cell = 0; cell < noofcells.size(); cell++) {
					System.out.println(noofcells.get(cell).getText() + ",");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		driver.findElement(By.xpath("(//button[@type='button'])[6]")).click();
		
		WebElement t = driver.findElement(By.xpath("//div[@class='efrmgen-main-container container']"));
		System.out.println(t.getText());
		
		driver.findElement(By.id("appDob")).click();
		
		int a=0;
		while(a==0) {
			String mmyy = driver.findElement(By.id("ui-datepicker-div")).getText();
			if (!(mmyy.equals("May 1996"))) {
				driver.findElement(By.xpath("//th[@class='Prev']")).click();
			}
			else
				break;
		}
		driver.findElement(By.xpath("//td[@class='disabled day']")).click();
		
		
	}
}
