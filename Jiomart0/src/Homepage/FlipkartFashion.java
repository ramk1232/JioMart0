package Homepage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FlipkartFashion {

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

		WebElement Fashion = driver.findElement(By.xpath("//div[@class='_1psGvi SLyWEo']"));
		System.out.println("===========" + Fashion.getText() + "========");
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(Fashion).build().perform();

		Thread.sleep(2000);

		List<WebElement> list = driver.findElements(By.xpath("//a[contains(@class,'_6WOcW9')]"));
		List<WebElement> Hidlist = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
		try {
			for (WebElement e : list) {
				Thread.sleep(500);
				for (WebElement ee : Hidlist) {
					Thread.sleep(500);
					act.moveToElement(ee).build().perform();
					System.out.println(ee.getText());
				}
				act.moveToElement(e).build().perform();
				System.out.println(e.getText());
			}
		} catch (Exception e2) {
			System.out.println(e2.getStackTrace());
		}

//
//		
//		
//		
//		JavascriptExecutor j  = (JavascriptExecutor) driver;
//		j.executeScript("window.scrollBy(0,-500)");		
//		WebElement Electronics = driver.findElement(By.linkText("Electronics"));
//		System.out.println("===========" + Electronics.getText() + "========");
//		Thread.sleep(3000);
//		Actions actEle = new Actions(driver);
//		actEle.moveToElement(Electronics).build().perform();
//
//		List<WebElement> listEle = driver.findElements(By.xpath("//a[@class='_6WOcW9']"));
//		List<WebElement> HidlistEle = driver.findElements(By.xpath("//a[@class='_6WOcW9 _3YpNQe']"));
//	
//		for (WebElement el : listEle) {
//			Thread.sleep(300);
//			for (WebElement HiEle : HidlistEle) {
//			Thread.sleep(300);
//			act.moveToElement(HiEle).build().perform();
//			System.out.println(HiEle.getText());
//			
//			try {
//				Thread.sleep(3000);
//				act.moveToElement(el).build().perform();
//				System.out.println(el.getText());
//				System.out.println("h");
//			}
//			catch (StaleElementReferenceException f){
//				System.out.println("hi");
//
//				f.getStackTrace();
//				
//			}
//			}
//			
//		}
		Thread.sleep(3000);
		driver.close();
	}
}
