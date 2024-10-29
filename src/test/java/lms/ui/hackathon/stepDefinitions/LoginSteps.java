package lms.ui.hackathon.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.LoginPage;
import lms.ui.hackathon.utilities.LoggerLoad;
import lms.ui.hackathon.utilities.TestContextSetUp;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class LoginSteps{
	
	public LoginPage loginpage;
	TestContextSetUp testContSetup;
	DashboardPage dashboardPage;
	String errorMsg;
	
	
	public LoginSteps(TestContextSetUp testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();
	}
	
	@When("Admin gives the correct LMS portal URL")
	public void launch_LMSPortal() {
		DriverFactory.getDriver().get(CommonConfigs.getUrl());
	}
	

	@When("Admin gives the invalid LMS portal URL")
	public void launch_invalidLMSPortal() {
		loginpage.getinvalidloginUrl();
	}

	@Then("Admin should land on the home page")
	public void get_lms_title() {
		String actualTitle = loginpage.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());
	}
	
	//this is good. Keeping it
	@When("Admin enters valid credentials {string} and {string} and clicks login button")
	public void admin_enters_valid_credentials_and_and_clicks_login_button(String username, String password) throws Exception {
		LoggerLoad.info("Enter Valid Credentials");
		loginpage.EnterUserName(username);
		loginpage.EnterPassword(password);
		LoggerLoad.info("Click Login Button");
		dashboardPage = (DashboardPage)loginpage.clickOnloginButton();

	}
	
	@When("Admin enters valid credentials {string} and {string} and clicks login button through keypad")
	public void admin_enters_valid_credentials_and_and_clicks_login_button_through_keypad(String username, String password) throws Exception {
		LoggerLoad.info("Enter Valid Credentials");
		loginpage.EnterUserName(username);
		loginpage.EnterPassword(password);
		LoggerLoad.info("Click Login Button Through Keypad");
		dashboardPage = (DashboardPage)loginpage.clickOnloginButtonThroughKeypad();
	}
	
	
	@When("Admin enters invalid credentials {string} and {string} and clicks login button")
	public void admin_enters_invalid_credentials_and_and_clicks_login_button(String invalidUsername, String invalidPwd) throws Exception {
		LoggerLoad.info("Enter InValid Credentials");
		loginpage.EnterUserName(invalidUsername);
		loginpage.EnterPassword(invalidPwd);
		LoggerLoad.info("Click Login Button");
		errorMsg = (String)loginpage.clickOnloginButton();
	}

	
	@When("Admin enters valid credentials and clicks login button")
	public void user_enters_valid_credentials() throws Exception {
		
		//
		String Uname = "sdet@gmail.com";
		String Pwd = "LmsHackathon@2024";
		LoggerLoad.info("Enter Valid Credentials");
		loginpage.EnterUserName(Uname);
		loginpage.EnterPassword(Pwd);
		LoggerLoad.info("Click Login Button");
		dashboardPage = (DashboardPage)loginpage.clickOnloginButton();
	}

	@When("Admin enters credentials {string} and {string} and clicks login button")
	public void user_enters_valid_credentials(String Uname, String Pwd) throws Exception {
		LoggerLoad.info("Enter Valid Credentials");
		loginpage.EnterUserName(Uname);
		loginpage.EnterPassword(Pwd);
		LoggerLoad.info("Click Login Button");
		dashboardPage = (DashboardPage)loginpage.clickOnloginButton();
	}

	@When("Admin enters credentials {string} and {string} and clicks login button through keypad")
	public void user_enters_valid_credentials_clicksLoginThroughKeypad(String Uname, String Pwd)
			throws InterruptedException {
		
		  LoggerLoad.info("Enter Valid Credentials");
		  loginpage.EnterUserName(Uname); loginpage.EnterPassword(Pwd);
		  LoggerLoad.info("Click Login Button");
		  dashboardPage = loginpage.clickOnloginButtonThroughKeypad();
		 
	}

	@Then("Admin should land on dashboard page")
	public void Admin_should_land_on_dashboard_page() throws InterruptedException {
		
		Assert.assertTrue(dashboardPage.logoutBtnExists());
		//Assert.assertEquals(true, loginpage.returnlogoutbutton().isDisplayed());

	}

	@Then("Admin should see the Error message please check expected {string} displays")
	public void Error_Msg_Validation(String expMsg) {

		//String actualMsg = loginpage.getLoginErrorMgs().trim();
		String actualMsg = errorMsg;
		Assert.assertEquals(true, actualMsg.contains(expMsg.trim()),
				expMsg + " is not displayed and it is displaying the following wrong message " + actualMsg);

	}

	@When("Admin should see {string}")
	public void LoginPageValidation(String expField) {
		if (expField.contains("Please login to LMS application")) {
			Assert.assertTrue(loginpage.getLoginHeadingText().contains("Please login to LMS application"),
					"'Please login to LMS application' field is not displayed");
			LoggerLoad.info("'Please login to LMS application' field is  displayed");
		} else if (expField.contains("username")) {
			Assert.assertTrue(loginpage.userNameFieldExist(), "'username' field is not displayed");
			LoggerLoad.info("'username' field is  displayed");
		} else if (expField.contains("password")) {
			Assert.assertTrue(loginpage.passwordFieldExist(), "'password' field is not displayed");
			LoggerLoad.info("'password' field is  displayed");
		} else if (expField.contains("userfieldlabel")) {
			Assert.assertTrue(loginpage.getusernameLabelText().contains("User *"),
					"'usernameLabel' field is not displayed");
			LoggerLoad.info("'User *' label field is  displayed");
		} else if (expField.contains("passwordfieldlabel")) {
			Assert.assertTrue(loginpage.getpasswordLabelText().contains("Password *"),
					"'usernameLabel' field is not displayed");
			LoggerLoad.info("'Password *' label field is  displayed");
		} else if (expField.contains("login")) {
			Assert.assertTrue(loginpage.loginButtonExists(), "'login' button is not displayed");
			LoggerLoad.info("'Login' button is  displayed");
		} else if (expField.contains("logBtnlabel")) {
			Assert.assertTrue(loginpage.getloginBtnLabelText().contains("Login"),
					"'login' button label is not displayed");
			LoggerLoad.info("'Login' button label is  displayed");
		}

	}
	
	@Then ("Admin should recieve 404 page not found error")
	public void ValidatePageNotFoundMessage() {
		Assert.assertTrue(loginpage.getPageTitle().contains("Application Error"),
				"'page not found page' is not displayed");
		LoggerLoad.info("'page not found page'  is displayed");
	}
	
	
	@Then ("Admin should see user in {string} color")
	public void colorvalidation(String expcolor)
	{
		if (expcolor.contains("usercolor")) {
			Assert.assertTrue(loginpage.getusercolorText().trim().contains("rgba(0, 0, 0, 0.54)"),
					"'Gray color' is not displayed for 'User'");
			LoggerLoad.info("'Gray color' is displayed for 'User'");
		} 
		else if (expcolor.contains("passwordcolor")) {
			Assert.assertTrue(loginpage.getpasswordcolorText().trim().contains("rgba(0, 0, 0, 0.54)"),
					"'Gray color' is not displayed for 'Password'");
			LoggerLoad.info("'Gray color' is displayed for 'Password'");
		} 
	}
	

	
	@Then ("Admin should see input and loginbutton are in center of login page")
	public void alignmentloginFieldsValidation()
	{
			Assert.assertTrue(loginpage.getloginfieldsposition().trim().contains("center"),
					"Input and login button are not center alligned");
			LoggerLoad.info("Input and login button are center alligned");
		
	}
	
	@Then ("Admin should see expected logo image in login page")
	public void loginFieldsImageValidation()
	{
			Assert.assertTrue(loginpage.getloginimage().trim().contains("assets/img/LMS-logo.jpg"),
					"Expected image source is not displayed in loginpage");
			LoggerLoad.info("Expected image source is displayed in loginpage");
		
	}
	
	
}