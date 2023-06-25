package stepDefination1;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePage;

public class Helper extends BasePage{	
	
	@Before
	public static void initialSetup() {
		System.out.println("************* STARTING NEW TEST **************");
		System.out.println("INFO: Initial setup for new Test");
		System.out.println("INFO: Initial setup Done");		
	}
	
	@After(order = 2)
	public static void takeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Files/ScreenShot_"+ scenario.getName() +".png"));
		}
	}

	@After(order = 1)
	public static void endSetUp() {
		driver.quit();
		System.out.println("*************** End Test **************");
		System.out.println("***************************************");
	}

}
