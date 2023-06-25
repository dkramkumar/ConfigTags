package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo extends BasePage {
	
	static WebDriver driver;
		
	public static void brokenImages() {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-cybertekschool.herokuapp.com/");
		driver.findElement(By.xpath("//a[contains(text(), 'Broken Images')]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> images = driver.findElements(By.xpath("//*[@id='content']/div/img"));
		for(WebElement img : images) {
			if(img.getAttribute("naturalWidth").equals("0")) {
				System.out.println(img.getAttribute("outerHTML") + "Image is broken");
			}else {
				System.out.println(img.getAttribute("outerHTML") + "Image is Valid");
			}
		}
	}
	
	public static void getBrokenLinks() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		List<WebElement> tag = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = tag.iterator();
		while(itr.hasNext()) {
			String links = itr.next().getAttribute("href");
			
			URL url = new URL(links);
			HttpURLConnection httpUrlConnection = (HttpURLConnection)url.openConnection();
			httpUrlConnection.setConnectTimeout(5000);
			httpUrlConnection.connect();
			
			if(httpUrlConnection.getResponseCode()==200) {
				System.out.println(links+ "---> "+httpUrlConnection.getResponseMessage());
			}
			if(httpUrlConnection.getResponseCode()>=400) {
				System.out.println(links+ "---> BROKEN" );
			}
		}
	}
	
	public static void getMutipleTabs() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement footer = driver.findElement(By.xpath("//*[@id='navFooter']/div[1]/div/div[3]"));
		int totalLinks = footer.findElements(By.tagName("a")).size();
		for(int i=0; i<totalLinks; i++) {
			String tabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
			 footer.findElements(By.tagName("a")).get(i).sendKeys(tabs);
		}
		ArrayList<String> lw = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(lw.get(1));
	    System.out.println("Page title of new tab: " + driver.getTitle());
	    
	    driver.switchTo().window(lw.get(2));
	    System.out.println("Page title of new tab: " + driver.getTitle());
	    
	    driver.switchTo().window(lw.get(3));
	    System.out.println("Page title of new tab: " + driver.getTitle());
	}
	
	public static void openNewTab() throws AWTException {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(tab.get(1));
		
		driver.get("https://www.facebook.com/AmazonIN");
		
	}
	public static void main (String[] args) throws Exception  {
		Demo.getBrokenLinks();
	}

}
