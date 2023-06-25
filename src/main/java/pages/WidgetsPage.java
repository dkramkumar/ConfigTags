package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WidgetsPage extends BasePage{

	public static final By byProgrssBarTab = findBy("//span[contains(text(), 'Progress Bar')]");
	public static final By bySelectDate = findBy("//input[@id='datePickerMonthYearInput']");
	public static final By bySelectMonth = findBy("//select[@class='react-datepicker__month-select']");
	public static final By bySelectYear = findBy("//select[@class='react-datepicker__year-select']");
	public static final By byDateAndTime = findBy("//input[@id='dateAndTimePickerInput']");
	public static final By byDateAndTimeMonth = findBy("//span[@class='react-datepicker__month-read-view--selected-month']");
	public static final By byDateAndTimeYear = findBy("//span[@class='react-datepicker__year-read-view--selected-year']");
	public static final By byMonth = findBy("//div[@class='react-datepicker__month-dropdown']/div[7]");
	public static final By byYear = findBy("//div[@class='react-datepicker__year-dropdown']/div[9]");
	public static final By byDate = findBy("//div[@role='listbox']/div[4]/div[5]");
	public static final By bySection3Header = findBy("//div[@id='section3Heading']");
	public static final By bySlider = findBy("//input[@type='range']");
	public static final By bySliderValue = findBy("//input[@id='sliderValue']");
	public static final By byProgressBarStartButton = findBy("//button[@id='startStopButton']");
	public static final By byHoverMeToSeeButton = findBy("//button[@id='toolTipButton']");
	
	//***************** Accordian **************************//

	public static void scrollDownToProgrssBarTab() {
		scrollDown(byProgrssBarTab, "Progrss Bar");
	}
	public static void scrollDownToSectionLastHeading() {
		scrollDown(bySection3Header, "Section 3 Header");
	}
	public static void ClickOnSectionHeading(String data) {
		By bySectionHeading = findBy("//div[@id='"+data+"']");
		clickElement(bySectionHeading, data);
	}
	public static void getSectionContent(String data) {
		By bySectionContent = findBy("//div[@id='"+data+"']");
		getText(bySectionContent, data);
	}

	//**************** Auto Complete *****************************//

	public static void setMultipleColours(String str1, String str2) throws AWTException, InterruptedException {
		By byMultipleColours = findBy("//div[@id='autoCompleteMultipleContainer']");
		setText(byMultipleColours, "Multiple Colours", str1);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		
		setText(byMultipleColours, "Multiple Colours", str2);
		Thread.sleep(1000);
		Robot robot1 = new Robot();
		robot1.keyPress(KeyEvent.VK_TAB);
		robot1.keyPress(KeyEvent.VK_TAB);
	}

	public static String setSingleColour(String str1) throws AWTException, InterruptedException {
		By bySingleColour = findBy("//div[@id='autoCompleteSingleContainer']");
		setText(bySingleColour, "Single Colours", str1);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		String col = driver.findElement(By.xpath("//div[@class='auto-complete__single-value css-1uccc91-singleValue']")).getText();
		return col;
	}
	
	//**************** Date Picker *****************************//
	
	public static void clickOnSelectDate(String month, String year, String date) throws InterruptedException {
		clickElement(bySelectDate, "Select Date");
		Thread.sleep(1000);
		selectByVisibleText(bySelectMonth, "Select Month", month);
		Thread.sleep(1000);
		selectByVisibleText(bySelectYear, "Select Year", year);
		By byDate = findBy("//div[@class='react-datepicker__day react-datepicker__day--"+date+"']");
		clickElement(byDate, date);
		Thread.sleep(1000);
		String sDate = driver.findElement(By.xpath("//input[@id='datePickerMonthYearInput']")).getAttribute("value");
		System.out.println("INFO: Selected Date is : " +sDate);
	}
	
	public static String selectDateAndTime(String time) throws InterruptedException {
		clickElement(byDateAndTime, "Date and time");
		Thread.sleep(1000);
		clickElement(byDateAndTimeMonth, "Date And Time Month");
		Thread.sleep(1000);
		String sMonth = getText(byMonth, "Month");
		clickElement(byMonth, sMonth);
		Thread.sleep(1000);
		
		clickElement(byDateAndTimeYear, "Date And Time Year");
		Thread.sleep(1000);
		String sYear = getText(byYear, "Year");
		clickElement(byYear, sYear);
		Thread.sleep(1000);
		
		String sdate = getText(byDate, "Date");
		clickElement(byDate, sdate);
		Thread.sleep(1000);
			
		driver.findElement(By.xpath("//ul[@class='react-datepicker__time-list']/li[contains(text(), '"+time+"')]")).click();
		System.out.println("INFO: Selected time is : " +time);
		Thread.sleep(1000);
		
		String selectedDateAndTime = driver.findElement(By.xpath("//input[@id='dateAndTimePickerInput']")).getAttribute("value");
		System.out.println("INFO: Selected Date and Time is : " +selectedDateAndTime);
		return selectedDateAndTime;
	}
	
	//*********************** Slider *****************************//
	
	public static void moveToSlider() {
		WebElement wEle = findObject(bySlider, "Slider");
		Actions act = new Actions(driver);
		act.moveToElement(wEle).build().perform();
		System.out.println("INFO: Curser move to slider");
	}
	
	public static void dragTheSlider() {
		WebElement wEle = findObject(bySlider, "Slider");
		Actions act = new Actions(driver);
		act.dragAndDropBy(wEle, 200, 50).build().perform();
		System.out.println("INFO: Slider is dragged");
	}
	
	public static String getSliderValue() {
		return getAttribute(bySliderValue, "Slider Value");
	}
	
	//*********************** Progress Bar *****************************//
	
	public static void clickOnProgressBarStartButton() {
		clickElement(byProgressBarStartButton, "Progress Bar Button");
	}
	
	public static String getProgressBarValue() {
		String val = driver.findElement(By.xpath("//div[@role='progressbar']")).getAttribute("aria-valuenow");
		System.out.println("INFO: Progress Bar value is : " +val);
		return val;
	}
	
	//****************** Tool Tips *************************************//
	
	public static void moveToHoverMeToSeeToolTip() throws InterruptedException {
		By byHoverMeToSeeButton = findBy("//button[@id='toolTipButton']");
		WebElement tField = driver.findElement(By.xpath("//input[@id='toolTipTextField']"));
		WebElement wEle = findObject(byHoverMeToSeeButton, "Hover Me To See Button");
		Actions act = new Actions(driver);
		act.moveToElement(wEle).pause(Duration.ofMillis(100)).moveToElement(wEle, 519, 295).sendKeys(Keys.chord(Keys.CONTROL, "c"));
		System.out.println(act.sendKeys(Keys.CONTROL, "v"));
		
	}
}
