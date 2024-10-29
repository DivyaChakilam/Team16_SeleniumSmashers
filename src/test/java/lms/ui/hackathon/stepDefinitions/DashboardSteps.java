package lms.ui.hackathon.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.LoginPage;
import lms.ui.hackathon.utilities.TestContextSetUp;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class DashboardSteps {
	public DashboardPage dashboardPage;
	public TestContextSetUp testContextSetUp;
	public LoginPage loginpage;

	public DashboardSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.dashboardPage = testContextSetUp.pageObjManager.getDashboardPage();
		this.loginpage = testContextSetUp.pageObjManager.getLoginPage();

	}
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		

		
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		
		try {
			dashboardPage.login();
			Thread.sleep(2000);
	   } catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Admin should see {string} as header")
	public void admin_should_see_as_header(String header) {
		Assert.assertEquals(header, dashboardPage.getLMSTitleText());

	}

	@Then("Maximum navigation time in milliseconds, defaults to {int} seconds in dashboard page")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds_in_dashboard_page(Integer maxTime) {
	    Assert.assertTrue(dashboardPage.navigationResponseTime() < maxTime,"Navigation time exceeded 450 seconds");
		
	}

	@Then("HTTP response >={int}.The link boken in dashboard page")
	public void http_response_the_link_boken_in_dashboard_page(Integer brokencode) {
		Assert.assertFalse(dashboardPage.CheckBrokenLink(brokencode));
	}

	@Then("Admin should see {string}  as title in dashboard page")
	public void admin_should_see_as_title_in_dashboard_page(String string) {
		Assert.assertTrue(dashboardPage.LMSHeaderExists());
	}
	

	@Then("LMS title should be on the top left corner of page in dashboard page")
	public void lms_title_should_be_on_the_top_left_corner_of_page_in_dashboard_page() {
		Assert.assertTrue(dashboardPage.isTitleAtTopLeftCorner());

	}

	@Then("Admin should see correct spelling in navigation bar text in dashboard page")
	public void admin_should_see_correct_spelling_in_navigation_bar_text_in_dashboard_page() {
		
	       
	        Assert.assertTrue(dashboardPage.validateNavigationBarText());
	}

	@Then("Admin should see correct spelling and space in LMS title in dashboard page")
	public void admin_should_see_correct_spelling_and_space_in_lms_title_in_dashboard_page() {
		Assert.assertTrue(dashboardPage.SpaceCheck());

		
	}

	@Then("Admin should see the navigation bar text on the top right side in dashboard page")
	public void admin_should_see_the_navigation_bar_text_on_the_top_right_side_in_dashboard_page() {
		Assert.assertTrue(dashboardPage.isNavigationBarRightTopAligned());

	}

	@Then("Admin should see 1st Program,2nd Batch ,3rd User and 4th Logout")
	public void admin_should_see_1st_program_2nd_batch_3rd_user_and_4th_logout() {
		Assert.assertTrue(dashboardPage.validateNavBarOrder());

		
	}
}





