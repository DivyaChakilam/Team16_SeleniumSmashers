package lms.ui.hackathon.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.*;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.LoginPage;
import lms.ui.hackathon.pageobjects.LogoutPage;
import lms.ui.hackathon.utilities.TestContextSetUp;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class LgoutSteps {
	
	 public LoginPage loginpage;
	 public LogoutPage logoutPage; 
	 TestContextSetUp testContextSetup;
	  
	 public LgoutSteps(TestContextSetUp testContextSetup) { 
	 this.testContextSetup = testContextSetup; 
     this.logoutPage=testContextSetup.pageObjManager.getLogoutPage();
     }
	 	
	@Given("Admin is on home page")
	public void admin_is_on_home_page(){
		

	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		logoutPage.clickLogoutBtn();
		
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	
		String actualTitle = loginpage.getPageTitle();
		Assert.assertEquals("LMS", actualTitle.trim());

	}
	
	
}
