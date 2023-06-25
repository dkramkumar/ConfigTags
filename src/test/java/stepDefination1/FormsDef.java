package stepDefination1;

import static org.junit.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormsPage;

public class FormsDef {
	
	@When("User selects the month {string} and year {string}")
	public void user_selects_the_month_and_year(String string, String string2) throws InterruptedException {
	   FormsPage.selectMonthAndYear(string, string2);
	}

	@When("User clicks on the date")
	public void user_clicks_on_the_date() throws InterruptedException {
		FormsPage.clickOnDate();
		Thread.sleep(1000);
	}
	
	@When("User enters the {string} and {string} subjects")
	public void user_enters_the_and_subjects(String string, String string2) throws AWTException, InterruptedException {
		FormsPage.setSubjects(string, string2);
		Thread.sleep(1000);
	}
	
	@When("User clicks on hobbies check box")
	public void user_clicks_on_hobbies_check_box() throws InterruptedException {
		FormsPage.clickONHobbies();
		Thread.sleep(1000);
	}

	@When("User scroll down to submit button")
	public void user_scroll_down_to_submit_button() throws InterruptedException {
		FormsPage.scrollToSubmitButton();
		Thread.sleep(1000);
	}

	@When("User selects the picture")
	public void user_selects_the_picture() throws AWTException, InterruptedException {
		FormsPage.selectPicture();
	}

	@When("User clicks on state and selects {string}")
	public void user_clicks_on_state_and_selects(String string) throws InterruptedException {
		FormsPage.selectState(string);
	}
	
	@When("User clicks on city and selects {string}")
	public void user_clicks_on_city_and_selects(String string) throws InterruptedException {
		FormsPage.selectCity(string);
	}
	
	@Then("User validates the registration succssfull message")
	public void user_validates_the_registration_succssfull_message() {
		assertEquals( FormsPage.getRegSuccessMsg(), "Thanks for submitting the form");
	}
	
	@When("User clicks on interactions")
	public void user_clicks_on_interactions() throws InterruptedException {
		FormsPage.clickOnIteractions();
		Thread.sleep(1000);
	}

	@When("User gets the form data from excel")
	public void user_gets_the_form_data_from_excel() throws IOException, InterruptedException {
		
	}
}
