package pages;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public static WebDriver driver;
	public static String downloadpath;
	
	public static void openUrl() throws InterruptedException {
		ChromeOptions cap= new ChromeOptions();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(cap);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("INFO: The title of the page is : " +driver.getTitle());	
		driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();
		Thread.sleep(1000);
	}
	
	public static By findBy(String sLocator) {
		By byElement = null;
		if(sLocator.contains("/")) {
			byElement = By.xpath(sLocator);
		}else {
			byElement = By.id(sLocator);
		}
		return byElement;
	}
	
	public static WebElement findObject(By ele, String selector) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		return wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}
	
	public static void setText(By ele, String selector, String text) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.sendKeys(wEle, text).build().perform();
			System.out.println("INFO: Entering " +selector+ " is : " +text);
		} catch (Exception e) {
			System.out.println("ERROR: Entering " +selector+ " is failed");
		}
	}
	
	public static String getText(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
			String text = wEle.getText();
			System.out.println("INFO: Getting text from " +selector+ " is : " +text);
			return text;		
	}
	
	public static String getAttribute(By ele, String selector) {
		WebElement wEle =  findObject(ele, selector);
		String text = wEle.getAttribute("value");
		System.out.println("INFO: Getting text from "+selector+ " is : " +text);
		return text;
	}
	
	public static void clickElement(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.click(wEle).build().perform();
			System.out.println("INFO: Clicked on " +selector);
		} catch (Exception e) {
			System.out.println("ERROR: Clicking on " +selector+ " is failed");
		}
	}
	
	public static boolean isElementSelected(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		boolean val = wEle.isSelected();
		System.out.println("INFO: Element " +selector+ " is selected");
		return val;
	}
	
	public static boolean isElementPresent(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		boolean val = wEle.isDisplayed();
		System.out.println("INFO: Element " +selector+ " is displayed");
		return val;
	}
	
	public static boolean isElementEnabled(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		boolean val = wEle.isEnabled();
		System.out.println("INFO: Element " +selector+ " is enabled");
		return val;
	}
	public static void rightClick(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.contextClick(wEle).build().perform();
			System.out.println("INFO: Right click on " +selector);
		} catch (Exception e) {
			System.out.println("ERROR: Right click on " +selector+ " is failed");
		}
	}
	
	public static void selectByVisibleText(By ele, String selector, String text) {
		WebElement  wEle = findObject(ele, selector);
		try {
			Select sel = new Select(wEle);
			sel.selectByVisibleText(text);
			System.out.println("INFO: " +selector+ " as "+text+" is selected");
		} catch (Exception e) {
			System.out.println("ERROR: " +selector+ " as "+text+"  is not selected");
		}
	}
	
	public static void scrollDown(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", wEle);
	}
	
	public static void doubleClick(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.doubleClick(wEle).build().perform();
			System.out.println("INFO: Double clicked on " +selector);
		} catch (Exception e) {
			System.out.println("ERROR: Double click on " +selector+ " is failed");
		}
	}
	
	public static void curcurMovedToElement(By ele, String selector) {
		WebElement wEle = findObject(ele, selector);
		try {
			Actions act = new Actions(driver);
			act.moveToElement(wEle).build().perform();
			System.out.println("INFO: Cursur moved to " +selector);
		} catch (Exception e) {
			System.out.println("ERROR: Cursur not moved to " +selector);
		}
	}
	
	public static String getRandomString(int length) {
		String ab = "abcdefghijklmnopqrstuvwxyz";
		
		SecureRandom sr = new SecureRandom();
		StringBuffer sb = new StringBuffer(length);
		
		for(int i=0; i<length; i++) {
			sb.append(ab.charAt(sr.nextInt(ab.length())));
		}
		return sb.toString();
	}
}
