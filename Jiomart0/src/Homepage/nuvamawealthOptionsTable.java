package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class nuvamawealthOptionsTable {

	public WebDriver driver;

	public nuvamawealthOptionsTable(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Options LTP Printing
	public void optionChain() {

		List<WebElement> noofrows = driver
				.findElements(By.xpath("((//div[@class='container'])[3]//table[@class='table ed'])[2]//tr"));
		try {

			System.out.println("no of rows=" + noofrows.size());

			for (int i = 1; i < noofrows.size(); i++) {
				List<WebElement> noofcells = driver.findElements(By.xpath(
						"((//div[@class='container'])[3]//table[@class='table ed'])[2]//tr[" + (i + 1) + "]//td"));
				System.out.println(noofcells.size());

				for (int cell = 0; cell < noofcells.size(); cell++) {
					System.out.println(noofcells.get(6).getText() + ",");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.nuvamawealth.com/market/nse-option-chain/optidx/nifty/2023-07-27");

		driver.manage().window().maximize();

		String url = driver.getCurrentUrl(); // Actual
		System.out.println(url);

		Thread.sleep(2000);

		WebElement frame = driver.findElement(By.id("wiz-iframe-intent"));

		driver.switchTo().frame(frame);

		driver.findElement(By.xpath("//span[@class='CT_InterstitialClose']")).click();

		driver.switchTo().defaultContent();

		// Total no of rows present in table
		for (int i = 0; i < 2; i++) {
			System.out.println("------------------------------------------------");
			Thread.sleep(40000);
			nuvamawealthOptionsTable numarketOptionsTable = new nuvamawealthOptionsTable(driver);
			numarketOptionsTable.optionChain();
		}
	}
}