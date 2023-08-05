package Homepage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicEle {

	public WebDriver driver;
	static Actions A;
	static JavascriptExecutor js;
	
	public DynamicEle(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void logo() {
		WebElement logo = driver.findElement(By.xpath("//div[@class='_3qX0zy']"));
		if (logo.isDisplayed()) {
			System.out.println("Logo is displayed");
		} else {
			System.out.println("Logo is not displayed");
		}
	}
	
	public void plusLink() {
		WebElement logo = driver.findElement(By.xpath("//a[@class='_21ljIi']"));
		if (logo.isDisplayed()) {
			System.out.println("link is displayed");
		} else {
			System.out.println("link is not displayed");
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies(); // Deletes all the cookies
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();
		
		Thread.sleep(3000);

		try {
			WebElement popup = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			Thread.sleep(1000);
			popup.click();
		} catch (Exception e) {
			e.getStackTrace();
		}
		
		driver.navigate().refresh();
		
		js = (JavascriptExecutor) driver;
		
		Thread.sleep(3000);
		A = new Actions(driver);
		List<WebElement>  arr = driver.findElements(By.xpath("//div[@class='_1oHPGm']//div[@class='_35l9rN _31Mq1b']//div"));
		for(WebElement ar : arr) {
			Thread.sleep(3000);
			A.moveToElement(ar).build().perform();
			ar.click();
			js.executeScript("window.scrollBy(0,100)"); // scroll down pixels		
			System.out.println(ar.getText());
		}

		DynamicEle dynamicEle = new DynamicEle(driver);
		dynamicEle.logo();
		dynamicEle.plusLink();
		
		Thread.sleep(3000);
		A = new Actions(driver);
		WebElement  login = driver.findElement(By.xpath("//div[@class='_1psGvi _3BvnxG']"));
		A.moveToElement(login).build().perform();

		List<WebElement>  loginSub = driver.findElements(By.xpath("//div[@class='ZEl_b_ _1J9ow0 _2ogGYG _23xUYh _3pAV4E']//ul//li//a"));
		System.out.println("-----------------------------------");
		for (WebElement log : loginSub) {
			Thread.sleep(300);
			A.moveToElement(log).build().perform();
			System.out.println(log.getText());
		}

		//// To Serch product in sech box

		WebElement serch = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		serch.sendKeys("Redmi note 12 pro 5g");

		Thread.sleep(2000);

		// To print serch box autoSuggession
		System.out.println("-----------------------------------");
		List<WebElement> suggBox = driver.findElements(By.xpath("//ul[@class='col-12-12 _1MRYA1 _38UFBk']//li"));
		for (WebElement sug : suggBox) {
			A.moveToElement(sug).build().perform();
			System.out.println(sug.getText());
		}

		Thread.sleep(2000);

		// To click on Serch
		WebElement se = driver.findElement(By.xpath("//button[@type='submit']"));
		se.click();
		Thread.sleep(2000);
		
		System.out.println("-----------------------------------");

		// To click on revies and get get Count
		WebElement review = driver.findElement(By.xpath("(//div[@class='_3pLy-c row'][1]//span)[2]"));
		System.out.println(review.getText());

		Thread.sleep(2000);

		List<WebElement> eles = driver.findElements(By.xpath("//div[@class='_1YokD2 _3Mn1Gg']/div"));
		for (WebElement w : eles) {
			A.moveToElement(w).build().perform();
			System.out.println();
			System.out.println(w.getText());
		}

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='bra6U8 HL5oOQ']")).click();

		Thread.sleep(2000);

		try {
			WebElement chkBox = driver.findElement(By.xpath("(//div[@class='_24_Dny'])[1]"));
			chkBox.click();
			Thread.sleep(2000);

		} catch (Exception ex) {
			ex.getStackTrace();
		}

//		try {
//			WebElement chkBox2 = driver.findElement(By.xpath("(//div[@class='_24_Dny'])[2]"));
//			chkBox2.click();
//			Thread.sleep(2000);
//
//		}
//		catch(Exception ex1) {
//			ex1.getStackTrace();
//		}

//		WebElement chkBox = driver.findElement(By.xpath("(//div[@class='_24_Dny'])[1]"));
//		chkBox.click();
//		
//		Thread.sleep(2000);
//
//		WebElement chkBox2 = driver.findElement(By.xpath("(//div[@class='_24_Dny'])[2]"));
//		chkBox2.click();

		Thread.sleep(2000);

		review.click();

		Thread.sleep(1000);

		Set<String> ids = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList<String>(ids);

		// switch selenium focus from main page to child window

		driver.switchTo().window(al.get(1));

		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,1000)"); // scroll down pixels

		Thread.sleep(2000);

		// Add to cart

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement addToCrt = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='_1p3MFP dTTu2M']//button)[1]")));
		addToCrt.click();

		Thread.sleep(2000);

		// To click on Enter pin code

		driver.findElement(By.xpath("//button[@class='_2MMH-I']")).click();

		Thread.sleep(2000);

		// Entering pin code

		driver.findElement(By.xpath("//input[@placeholder='Enter pincode']")).sendKeys("431517");

		Thread.sleep(2000);

		// Submitting Pin Code

		driver.findElement(By.xpath("//div[@class='_3uzwpU']")).click();

		Thread.sleep(1000);

		// Clicking on Place order
		try {
			WebElement fr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1AtVbE col-12-12 _78xt5Y']//button")));
			fr.click();
		} catch (Exception exp) {
			exp.getStackTrace();
		}

		Thread.sleep(1000);

		driver.switchTo().window(al.get(0));
		
		System.out.println("-----------------------------------");

		// Selecting min price from dropdown
		WebElement price = driver.findElement(By.xpath("//select[@class='_2YxCDZ']"));

		Select ele = new Select(price);

		ele.selectByValue("10000");

		// To get the all options in dropdown

		List<WebElement> options = ele.getOptions();

		int size = options.size(); // It will give only size like no. of elements present
		System.out.println("size of price is=" + size);

		System.out.println();
		System.out.println("min price is");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(options.get(i).getText());
		}

		// driver.close();
		// driver.quit();
	}
}
