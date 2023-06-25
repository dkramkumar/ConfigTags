package stepDefination1;

import static org.junit.Assert.assertTrue;

import java.awt.AWTException;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.WidgetsPage;

public class WidgetsDef extends BasePage{
	
	//*************** Accordian ************************//
	
	@When("User scroll down to progress bar tab")
	public void user_scroll_down_to_progress_bar_tab() throws InterruptedException {
	    WidgetsPage.scrollDownToProgrssBarTab();
	    Thread.sleep(1000);
	}
	@When("User clicks on {string} Accordian heading")
	public void user_clicks_on_accordian_heading(String string) throws InterruptedException {
		WidgetsPage.ClickOnSectionHeading(string);
		Thread.sleep(1000);
	}
	@When("User verify the {string} text")
	public void user_verify_the_text(String string) throws InterruptedException {
		WidgetsPage.getSectionContent(string);
		Thread.sleep(1000);
	}
	@When("User scroll down to section Last Heading")
	public void user_scroll_down_to_section_last_heading() throws InterruptedException {
		WidgetsPage.scrollDownToSectionLastHeading();
		Thread.sleep(1000);
	}
	
	//***************** Auto Complete *************************************//

	@When("User enters {string} and {string} colour names")
	public void user_enters_and_colour_names(String string, String string2) throws AWTException, InterruptedException {
	    WidgetsPage.setMultipleColours(string, string2);
	    Thread.sleep(1000);
	}
	@When("User enters {string} colour name")
	public void user_enters_colour_name(String string) throws AWTException, InterruptedException {
		assertTrue(WidgetsPage.setSingleColour(string).equals("Yellow"));
		Thread.sleep(1000);
	}
	
	//****************** Date picker ***********************************//

	@When("user selects the month {string} and year {string} and {string} as date")
	public void user_selects_the_month_and_year_and_as_date(String string, String string2, String string3) throws InterruptedException {
		WidgetsPage.clickOnSelectDate(string, string2, string3);
	}
	@When("user selects the month year date and {string} time")
	public void user_selects_the_month_year_date_and_time(String string) throws InterruptedException {
		assertTrue(WidgetsPage.selectDateAndTime(string).equals("July 23, 2020 9:00 PM"));
	}
	
	//****************** Slider *************************************//
	
	@When("User drags the slider")
	public void user_drags_the_slider() throws InterruptedException {
		WidgetsPage.moveToSlider();
		Thread.sleep(1000);
		WidgetsPage.dragTheSlider();
		Thread.sleep(1000);
	}
	@Then("User verify the slider value")
	public void user_verify_the_slider_value() {
		assertTrue(WidgetsPage.getSliderValue().equals("89"));
	}
	
	//****************** Progress Bar *************************************//
	
	@When("User clicks on progress bar (START|STOP) button")
	public void user_clicks_on_progress_bar_start_button() throws InterruptedException {
		WidgetsPage.clickOnProgressBarStartButton();
	}
	@When("User waits for few seconds before click on stop button")
	public void user_waits_for_few_seconds_before_click_on_stop_button() throws InterruptedException {
	    Thread.sleep(6000);
	}
	@Then("User verify the progress bar value")
	public void user_verify_the_progress_bar_value() {
		assertTrue(WidgetsPage.getProgressBarValue().equals("61"));
	}
	
	//****************** Tool Tips *************************************//
	
	@When("User move to Hover me to see button and get the tool tip")
	public void user_move_to_hover_me_to_see_button_and_get_the_tool_tip() throws InterruptedException {
		WidgetsPage.moveToHoverMeToSeeToolTip();
	}
}
