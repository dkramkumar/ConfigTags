package pages;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadJSONFile extends BasePage{
	@Test(dataProvider = "dp")
	public void formSubmit(String data) throws InterruptedException {
		openUrl();
		String[] arr = data.split(",");
		driver.findElement(By.xpath("//div[@class = 'card mt-4 top-card'][2]")).click();
		System.out.println("INFO: User clicks on FORMS card" );
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(), 'Practice Form')]")).click();
		System.out.println("INFO: User clicks on Practice Form tab" );
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(arr[0]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(arr[1]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys(arr[1]);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys(arr[1]);
		Thread.sleep(1000);
	}
	
	@DataProvider(name = "dp")
	public String[] readJSON() throws IOException, ParseException {
		
		JSONParser jsonParser = new JSONParser();
		FileReader fileReader = new FileReader(".\\Files\\TestData.json");
		
		Object obj = jsonParser.parse(fileReader);
		JSONObject formsJsonObject = (JSONObject) obj;
		JSONArray formDetails = (JSONArray)formsJsonObject.get("forms");
		
		String[] arr = new String[formDetails.size()];
		for(int i=0; i<formDetails.size(); i++) {
			JSONObject details = (JSONObject)formsJsonObject.get(i);
			String fName = (String) details.get("firstname");
			String lName = (String) details.get("lastname");
			String emailId = (String) details.get("email");
			String mNumber = (String) details.get("mobilenumber");
			
			arr[i] = fName+","+lName+","+emailId+","+mNumber;
		}
		
		return arr;
	}

}
