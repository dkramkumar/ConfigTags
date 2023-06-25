package pages;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1 {
	
	static WebDriver driver;
	
	public static void brokenImages() {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practice-cybertekschool.herokuapp.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//li//a[contains(text(), 'Broken Images')]")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='example']/img"));
		for(WebElement img : list)
		{
			if(img.getAttribute("naturalWidth").equals("0")) 
			System.out.println(img.getAttribute("outerHTML") +" Image is broken");
			else 
			System.out.println(img.getAttribute("outerHTML")+ " Image is Valid");
		}
	}
	
	public static void multipleTabs() {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		System.out.println(driver.getTitle());
		
		WebElement footer = driver.findElement(By.xpath("//*[@id='navFooter']/div[1]/div/div[3]"));
		int totalLinks = footer.findElements(By.tagName("a")).size();
		
			for(int i=0; i<totalLinks; i++) {
				String tabs = Keys.chord(Keys.CONTROL, Keys.ENTER);
				footer.findElements(By.tagName("a")).get(i).sendKeys(tabs);
			}
			ArrayList<String> al = new ArrayList<>(driver.getWindowHandles());
			driver.switchTo().window(al.get(1));
			System.out.println(driver.getTitle());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
			
			driver.switchTo().window(al.get(2));
			System.out.println(driver.getTitle());
			
			driver.switchTo().window(al.get(3));
			System.out.println(driver.getTitle());
	}
	
	public static void brokenLinks() throws Exception  {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String demoQa = "https://demoqa.com/";
		driver.get(demoQa);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		System.out.println(driver.getTitle());
		
		List<WebElement> tag = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = tag.iterator();
		while(itr.hasNext()) {
			String links = itr.next().getAttribute("href");
			System.out.println(links);
			
			URL url = new URL(links);
			HttpURLConnection httpConn = (HttpURLConnection)url.openConnection();
			httpConn.setConnectTimeout(5000);
			httpConn.connect();
			
			if(httpConn.getResponseCode()==200) {
				System.out.println(links+ "---> VALID LINKS ");
			}
			if(httpConn.getResponseCode()>=400) {
				System.out.println(links + " ---> BROKEN LINKS");
			}	
		}		
	}
	
	public static void selectDateSpicejet() {
		System.setProperty("webdriver.chrome.driver", "D:\\WS Auto Testing\\DemoQAApp\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://book.spicejet.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//div[@id='marketDate_1']/input[1]")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		LocalDateTime now = LocalDateTime.now();  
		System.out.println(dtf.format(now));  
		driver.findElement(By.xpath("")).click();
	}
	
	public static void openFileusingDesktop() throws IOException {
		String path = "D:\\Files\\inter.txt";
		File file = new File(path);
		Desktop desktop = Desktop.getDesktop();
		desktop.open(file);
	}
	
	public static void readFileInputSream() throws IOException {
		String path = "D:\\Files\\inter.txt";
		FileInputStream fis = null;
		File file = new File(path);
		try {
			fis = new FileInputStream(file);
			int c = 0;
			while((c = fis.read())!=-1) {
				System.out.print((char) c);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			fis.close();
		}
	}
	
	public static void readFileBufferReader() throws IOException {
		String path = "D:\\Files\\inter.txt";
		BufferedReader br = null;
		File file = new File(path);
		try {
			br = new BufferedReader(new FileReader(file));
			int c= 0;
			while((c=br.read())!=-1) {
				System.out.print((char) c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			br.close();
		}
	}
	
	public static void readFileReader() throws IOException {
		String path = "D:\\Files\\inter.txt";
		FileReader fr = null;
		File file = new File(path);
		try {
			fr = new FileReader(file);
			int c= 0;
			while((c=fr.read())!=-1) {
				System.out.print((char) c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			fr.close();
		}
	}
	
	public static void readFileUsingNIO() {
		String path = "D:\\Files\\inter.txt";
		try {
			List<String> lines = Files.readAllLines(Paths.get(path));
			Iterator<String> itr = lines.iterator();
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readFileUsingScanner() {
		String path = "D:\\Files\\inter.txt";
		Scanner scan = null;
		File file = new File(path);
		try {
			scan = new Scanner(file);
			while(scan.hasNextLine()) {
				System.out.println(scan.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			scan.close();
		}
	}
	
	public static void main(String[] args) throws Exception  {
		Demo1.readFileUsingScanner();
		
	}
}
