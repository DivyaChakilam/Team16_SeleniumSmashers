package lms.ui.hackathon.stepDefinitions;

//import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.configs.ConfigurationManager;
import lms.ui.hackathon.pageobjects.LoginPage;
import lms.ui.hackathon.utilities.TestContextSetUp;
//import numpy.seleniumsmasher.lms.factory.DriverFactory;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class LoginSteps{
	
	public LoginPage loginpage;
	private CommonConfigs commonConfigs;
	TestContextSetUp testContSetup;
	//WebDriver driver;
	
	
	public LoginSteps(TestContextSetUp testContSetup) {
		//driver = DriverFactory.getDriver();
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
	}
	
	@Given("Admin launch the browser.")
	public void admin_launch_the_browser() {
	    
		
	}

	@When("Admin gives the correct LMS portal URL.")
	public void admin_gives_the_correct_lms_portal_url() {
		DriverFactory.getDriver().get(commonConfigs.getUrl());

	}

	@Then("Admin should land on the login page.")
	public void admin_should_land_on_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin gives the incorrect LMS portal URL.")
	public void admin_gives_the_incorrect_lms_portal_url() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should recieve page not found error.")
	public void admin_should_recieve_page_not_found_error() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should recieve the link is broken error.")
	public void admin_should_recieve_the_link_is_broken_error() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see correct spellings in all fields.")
	public void admin_should_see_correct_spellings_in_all_fields() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see logo on the left  side.")
	public void admin_should_see_logo_on_the_left_side() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see company name below the app name")
	public void admin_should_see_company_name_below_the_app_name() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see {string}")
	public void admin_should_see(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see two text field")
	public void admin_should_see_two_text_field() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see {string} and {string} symbol in the first text field")
	public void admin_should_see_and_symbol_in_the_first_text_field(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see\"Password\" and {string} symbol in the first text field")
	public void admin_should_see_password_and_symbol_in_the_first_text_field(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see input field on the centre of the pages")
	public void admin_should_see_input_field_on_the_centre_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see login button")
	public void admin_should_see_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see login button on the centre of the page.")
	public void admin_should_see_login_button_on_the_centre_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see user and password text in gray color")
	public void admin_should_see_user_and_password_text_in_gray_color() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is in login Page.")
	public void admin_is_in_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on dashboard page\\(centre of the page will be empty , menu bar is present).")
	public void admin_should_land_on_dashboard_page_centre_of_the_page_will_be_empty_menu_bar_is_present() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter invalid credentials and clicks login button")
	public void admin_enter_invalid_credentials_and_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin gets Error message {string}.")
	public void admin_gets_error_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter value only in password and clicks login button")
	public void admin_enter_value_only_in_password_and_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter value only in Adminname and clicks login button")
	public void admin_enter_value_only_in_adminname_and_clicks_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin gets Error message")
	public void admin_gets_error_message() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Admin is on login Page.")
	public void admin_is_on_login_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin enter valid credentials and clicks login button through mouse")
	public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
}
