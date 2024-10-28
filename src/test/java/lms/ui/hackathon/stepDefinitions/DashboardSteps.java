package lms.ui.hackathon.stepDefinitions;

import io.cucumber.java.en.Then;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class DashboardSteps {
	public DashboardPage dashboardPage;
	public TestContextSetUp testContextSetUp;

	public DashboardSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.dashboardPage = testContextSetUp.pageObjManager.getDashboardPage();
   }
	

@Then("Admin should see {string} as header")
public void admin_should_see_as_header(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Maximum navigation time in milliseconds, defaults to {int} seconds in dashboard page")
public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_in_dashboard_page(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("HTTP response >={int}.The link boken in dashboard page")
public void http_response_the_link_boken_in_dashboard_page(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see {string} Learning management system  as title in dashboard page")
public void admin_should_see_learning_management_system_as_title_in_dashboard_page(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("LMS title should be on the top left corner of page in dashboard page")
public void lms_title_should_be_on_the_top_left_corner_of_page_in_dashboard_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see correct spelling in navigation bar text in dashboard page")
public void admin_should_see_correct_spelling_in_navigation_bar_text_in_dashboard_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see correct spelling and space in LMS title in dashboard page")
public void admin_should_see_correct_spelling_and_space_in_lms_title_in_dashboard_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see the navigation bar text on the top right side in dashboard page")
public void admin_should_see_the_navigation_bar_text_on_the_top_right_side_in_dashboard_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Admin should see 1st Program,2nd Batch ,3rd User and 4th Logout")
public void admin_should_see_1st_program_2nd_batch_3rd_user_and_4th_logout() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}
}





