package lms.ui.hackathon.stepDefinitions;

import lms.ui.hackathon.pageobjects.LogoutPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class LgoutSteps {
	public LogoutPage logoutPage;
	TestContextSetUp testContextSetup;
	
	public LgoutSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.logoutPage=testContextSetup.pageObjManager.getLogoutPage();
	}

}
