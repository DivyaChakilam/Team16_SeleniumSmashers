package lms.ui.hackathon.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.LoginPage;
import lms.ui.hackathon.pageobjects.LogoutPage;
import lms.ui.hackathon.utilities.TestContextSetUp;


public class LgoutSteps {
	
	 public DashboardPage dashboardPage; 
	 public LoginPage loginpage;
	 public LogoutPage logoutPage; 
	 TestContextSetUp testContextSetup;
	  
	 public LgoutSteps(TestContextSetUp testContextSetup) { 
	 this.testContextSetup = testContextSetup; 
     this.dashboardPage=testContextSetup.pageObjManager.getDashboardPage();
     }
	 	
	@Given("Admin is on Dashboard page after logging")
	public void admin_is_on_Dashboard_page_after_logging(){
		 
		//title validation method
		Assert.assertTrue(dashboardPage.LMSHeaderExists());

	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		logoutPage.clickLogoutBtn();
		loginpage = dashboardPage.clickLogoutBtn();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
	
		//String actualTitle = loginpage.getPageTitle();
		Assert.assertEquals("LMS", loginpage.getPageTitle());

	}
	
	
}
