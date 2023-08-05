package Homepage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mahaSarkar {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://mahasarkar.co.in/talathi-bharti/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,9300)");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@class='align-right secondary slidedown-button']"));
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@title='Talathi Bharti 2023 | तलाठी भरतीची जाहिरात आली | Talathi Bharti 2023 Online Form Date Latest Update']"));
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//button[@aria-label='Play']"));
	}
}
