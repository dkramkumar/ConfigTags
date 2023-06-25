package stepDefination1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.AWTException;
import java.io.IOException;
import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.ElementsPage;

public class ElementsDef1 extends BasePage{
	
	@Given("User is on demo QA site")
	public void user_is_on_demo_qa_site() throws InterruptedException {
	 openUrl();
	}	
	@When("User clicks on {string} st category card")
	public void user_clicks_on_st_category_card(String name) throws InterruptedException {
		ElementsPage.clickOnElementsMainMenu(name);
		Thread.sleep(2000);
	}
	@When("User navigates to back page")
	public void user_navigates_to_back_page() throws InterruptedException {
		ElementsPage.navigateBack();
		Thread.sleep(2000);
	}
	@When("User click on {string} tab")
	public void user_click_on_tab(String string) throws InterruptedException {
		ElementsPage.clickOnTextBoxTab(string);
		Thread.sleep(1000);
	}
	@When("User valiadtes the header")
	public void user_valiadtes_the_header() throws InterruptedException {
		ElementsPage.getHeaderText();
		Thread.sleep(1000);
	}
	@When("User enters {string} as {string} in text field")
	public void user_enters_as_in_text_field(String data, String text) throws InterruptedException {
		ElementsPage.setFullNameAndEmail(data, text);
		Thread.sleep(1000);
	}
	@When("User enters {string} as {string} in textarea")
	public void user_enters_as_in_textarea(String data, String text) throws InterruptedException {
		ElementsPage.setCurrentAndPermanentAddress(data, text);
		Thread.sleep(1000);
	}
	@When("User clicks on submit button")
	public void user_clicks_on_submit_button() throws InterruptedException {
		ElementsPage.clickOnSubmitButton();
		Thread.sleep(2000);
	}
	@Then("User validate the output message")
	public void user_validate_the_output_message() throws InterruptedException {
		ElementsPage.getOutPutMsg();
		Thread.sleep(1000);
	}
	
	//********************* Check Box ********************************//
	
	@When("User expands the Home toggle")
	public void user_expands_the_home_toggle() throws InterruptedException {
		ElementsPage.clickOnHomeToExpand();
		Thread.sleep(1000);
	}
	@When("User expands the desktop toggle")
	public void user_expands_the_desktop_toggle() throws InterruptedException {
		ElementsPage.clickOnDesktopToExpand();
		Thread.sleep(1000);
	}
	@When("User clicks on Commands check box")
	public void user_clicks_on_commands_check_box() throws InterruptedException {
		ElementsPage.clickOnCommandsCheckBox();
		Thread.sleep(1000);
	}
	@When("User expands Documents and Office")
	public void user_expands_documents_and_office() throws InterruptedException {
		ElementsPage.clickOnDocumentsToExpand();
		Thread.sleep(1000);
		ElementsPage.clickOnOfficeToExpand();
		Thread.sleep(1000);
	}
	@When("User clicks on General toggle")
	public void user_clicks_on_general_toggle() throws InterruptedException {
		ElementsPage.clickOnGeneralCheckBox();
		Thread.sleep(1000);
	}
	@Then("User validates the seleted {string} message")
	public void user_validates_the_seleted_message(String string) {
		String text = ElementsPage.getSelectedText();
		assertEquals(text, string);
	}
	@When("User expands the Downloads toggle")
	public void user_expands_the_downloads_toggle() throws InterruptedException {
		ElementsPage.clickOnDownloadExpand();
		Thread.sleep(1000);
	}
	@When("User clicks on Excelfile.doc")
	public void user_clicks_on_excelfile_doc() throws InterruptedException {
		ElementsPage.clickOnExcelFile();
		Thread.sleep(1000);
	}
	
	//**************** Radio Button ******************************//

	@When("User clicks on {string} button")
	public void user_clicks_on_button(String string) throws InterruptedException {
		ElementsPage.clickRadioButton(string);
		Thread.sleep(1000);
	}
	@Then("User validates the noRadio button")
	public void user_validates_the_no_radio_button() {
		boolean val = ElementsPage.isNoRadioButtonEnabled();
		assertFalse(val);
		System.out.println("INFO: No Radio button is disabled");
	}
	//**************** Web Tables ******************************//
	
	@When("User clicks on Add button in registration form")
	public void user_clicks_on_add_button_in_registration_form() throws InterruptedException {
		ElementsPage.clickOnAddButton();
		Thread.sleep(2000);
	}
	@Then("User is successfully {string} added in the Web table")
	public void user_is_successfully_added_in_the_web_table(String string) throws InterruptedException {
		ElementsPage.getAddedUserName(string);
		Thread.sleep(1000);
	}
	
	//******************** Buttons ******************************//
	
	@When("User clicks on Double click me button")
	public void user_clicks_on_double_click_me_button() throws InterruptedException {
		ElementsPage.clickOnDoubleClickMeButton();
		Thread.sleep(1000);
	}
	@Then("User clicks on Right Click Me button")
	public void user_clicks_on_right_click_me_button() throws InterruptedException {
		ElementsPage.clickOnRightClickMeButton();
		Thread.sleep(1000);
	}
	@Then("User clicks on Click Me button")
	public void user_clicks_on_click_me_button() throws InterruptedException {
		ElementsPage.clickOnClickMeButton();
		Thread.sleep(1000);
	}
	@Then("User validate {string} message")
	public void user_validate_message(String string) throws InterruptedException {
		ElementsPage.getButtonsClickedMessage(string);
		Thread.sleep(1000);
	}
	
	//******************** Links ***********************************//

	@When("User clicks on Links Tab")
	public void user_clicks_on_links_tab() throws InterruptedException {
		ElementsPage.clickOnLinksTab();
		Thread.sleep(1000);
	}
	@When("User clicks on {string} link")
	public void user_clicks_on_link(String string) throws InterruptedException {
		ElementsPage.clickOnLinks(string);
		Thread.sleep(2000);
	}
	@Then("User validate home window is opened successfully")
	public void user_validate_home_window_is_opened_successfully() throws InterruptedException {
		ElementsPage.isNewHomeLinkWindowOpened();
		Thread.sleep(1000);
	}
	@Then("User validate the responsce status code {string} and Status {string} text")
	public void user_validate_the_responsce_status_code_and_status_text(String string, String string2) throws InterruptedException {
		assertEquals("Status Code", ElementsPage.getStatusCode(), string); 
		Thread.sleep(1000);
		assertEquals("Status Text", ElementsPage.getStatusText(), string2);
		Thread.sleep(1000);
	}
	@When("User scroll down to links tab")
	public void user_scroll_down_to_links_tab() throws InterruptedException {
		ElementsPage.scrollToLinkTab();
		Thread.sleep(1000);
	}
	
	//******************** Links ***********************************//

	@Then("User validate valid image")
	public void user_validate_valid_image() throws InterruptedException {
		ElementsPage.isValidImagePresent();
		Thread.sleep(1000);
	}

	//******************** Broken Links ***********************************//
	
	@Then("User validate the broken image")
	public void user_validate_the_broken_image() throws IOException, InterruptedException {
		ElementsPage.isImageBroken();
		Thread.sleep(1000);
	}
	@Then("User clicks on Valid Link")
	public void user_clicks_on_valid_link() throws InterruptedException {
		ElementsPage.clickOnValidLink();
		Thread.sleep(2000);
	}
	@Then("User validate the Valid link is succssfully opened")
	public void user_validate_the_valid_link_is_succssfully_opened() throws InterruptedException {
		assertFalse(ElementsPage.isValidLinkOpened().equals(ElementsPage.currentUrl)); 
		System.out.println("INFO: Valid Link is successfully opened");
		driver.navigate().back();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='close-fixedban']")).click();
		Thread.sleep(1000);	
	}
	@Then("User clicks on Broken Link")
	public void user_clicks_on_broken_link() throws InterruptedException {
		ElementsPage.clickOnBrokenLink();
		Thread.sleep(2000);
	}
	@Then("User validate the Broken link")
	public void user_validate_the_broken_link() {
		ElementsPage.getBrokenLinkStausCode();
	}
	
	//******************** Upload and Download ***********************************//
	
	@When("User clicks on choose file")
	public void user_clicks_on_choose_file() throws InterruptedException {
		ElementsPage.clickOnChooseFile();
		Thread.sleep(1000);
	}
	@When("User selects the selenium image file")
	public void user_selects_the_selenium_image_file() throws AWTException, InterruptedException {
		ElementsPage.setPathForImageToUpload();
		Thread.sleep(1000);
	}
	@Then("User validate the image got succssfully uploaded")
	public void user_validate_the_image_got_succssfully_uploaded() throws InterruptedException {
		String uploadPath = "C:\\fakepath\\Selenium1.png";
		assertEquals(ElementsPage.getUploadedFilePath(), uploadPath);
		Thread.sleep(1000);
	}
	@Then("User clicks on download button")
	public void user_clicks_on_download_button() throws InterruptedException {
		ElementsPage.clickOnDownloadButton();
		Thread.sleep(1000);
	}
	@Then("User set the path to download the image")
	public void user_set_the_path_to_download_the_image() throws AWTException {
		ElementsPage.setPathForImageToDownload();
	}
	@Then("User verify the image got successfully downloaded")
	public void user_verify_the_image_got_successfully_downloaded() {
	    
	}
	
	//******************** Dynamic Properties ***********************************//
	
	@When("User validate the Will enable five seconds button enabled or not")
	public void user_validate_the_will_enable_five_seconds_button_enabled_or_not() throws InterruptedException {
		ElementsPage.isWillEnableFiveSecondsButton();
	}
	
	@When("User validate color changed or not")
	public void user_validate_color_changed_or_not() throws InterruptedException {
		ElementsPage.isColorChanged();
	}
	
	@When("User valiadte visible after five seconds button is present")
	public void user_valiadte_visible_after_five_seconds_button_is_present() {
		ElementsPage.isVisibleAfterFiveSecButtonIsPresent();
	}



}
