package Homepage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaneelSlide {
	
public static void main(String[] args) throws InterruptedException  {
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
		
		driver.get("https://www.jiomart.com");
		
		driver.manage().window().maximize();
		
		List<WebElement> slides = driver.findElements(By.xpath("//span[@class='swiper-pagination-bullet']"));
		
		for(WebElement s : slides) {
			Thread.sleep(200);
			s.click();
			String slide = s.getAttribute("class");
			String label = s.getAttribute("aria-label");
			if(slide.contains("swiper-pagination-bullet-active")) {
				System.out.println("Clicked on= " + label);
			}
		}

	}
}
