package stepDefination1;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlertsFrameWindowsPage;
import pages.BasePage;

public class AlertsFrameWindowsDef extends BasePage{
	
	@Then("User click on new {string}")
	public void user_click_on_new(String string) throws InterruptedException {
		AlertsFrameWindowsPage.clickOnNewButtons(string);
		Thread.sleep(2000);
	}
	
	@Then("User validate new tab is opened")
	public void user_validate_new_tab_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.getTitleOfNewTab();
	}
	
	@Then("User validate new window is opened")
	public void user_validate_new_window_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.getNewWidow();
	}
	
	@Then("User validate new window message is opened")
	public void user_validate_new_window_message_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.getNewWidowMessage();
	}
	@When("User clicks on {string} to see alert")
	public void user_clicks_on_to_see_alert(String string) throws InterruptedException {
		AlertsFrameWindowsPage.clickOnAlertsButton(string);
		Thread.sleep(1000);
	}
	@Then("User clicks on Timer Alert button to see alert")
	public void user_clicks_on_timer_alert_button_to_see_alert() {
		AlertsFrameWindowsPage.clickOnTimerAlertsButton();
	}
	@Then("User verify alert window is opened")
	public void user_verify_alert_window_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.isAlertWindowPresent();
	}
	@Then("User verify timer alert window is opened")
	public void user_verify_timer_alert_window_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.istimerAlertPresent();
	}
	@Then("User verify confirm alert window is opened")
	public void user_verify_confirm_alert_window_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.isConfirmAlertPresent();
		Thread.sleep(1000);
		AlertsFrameWindowsPage.getConfirmResult();
	}
	@Then("User verify promt alert window is opened")
	public void user_verify_promt_alert_window_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.isPromtAlertPresent();
		AlertsFrameWindowsPage.getPromtResult();
	}
	
	//************** Frames *****************************//

	@When("User scroll down to frames tab")
	public void user_scroll_down_to_frames_tab() throws InterruptedException {
	   scrollDown(AlertsFrameWindowsPage.byFramesTab, "Frames");
	   Thread.sleep(1000);
	}
	@When("User click on Frames tab")
	public void user_click_on_frames_tab() throws InterruptedException {
		AlertsFrameWindowsPage.clickONFramesTab();
		Thread.sleep(1000);
	}
	@When("User switch to psrent frame")
	public void user_switch_to_psrent_frame() throws InterruptedException {
		AlertsFrameWindowsPage.switchToParentFrame();
		Thread.sleep(1000);
	}
	@When("User switch to child frame")
	public void user_switch_to_child_frame() throws InterruptedException {
		AlertsFrameWindowsPage.switchToChildFrame();
		Thread.sleep(1000);
	}
	
	//******************* Nested Frames **********************************//
	
	@When("User moves from parent to child frame")
	public void user_moves_from_parent_to_child_frame() throws InterruptedException {
		AlertsFrameWindowsPage.switchParentToChildFrame();
	}
	
	//******************* Modal dialogs **********************************//
	
	@When("User clicks on {string} modal button")
	public void user_clicks_on_modal_button(String string) throws InterruptedException {
		AlertsFrameWindowsPage.clickOnModalButtons(string);
		Thread.sleep(1000);
	}
	@When("User verify small modal pop up is opened")
	public void user_verify_small_modal_pop_up_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.isSmallModalHeaderIsPresent();
		Thread.sleep(1000);
		AlertsFrameWindowsPage.clickOnCloseSmallModalButton();
	}
	@When("User verify large modal pop up is opened")
	public void user_verify_large_modal_pop_up_is_opened() throws InterruptedException {
		AlertsFrameWindowsPage.isLargeModalHeaderIsPresent();
		Thread.sleep(1000);
		AlertsFrameWindowsPage.clickOnCloseLargeModalButton();
	}
}
