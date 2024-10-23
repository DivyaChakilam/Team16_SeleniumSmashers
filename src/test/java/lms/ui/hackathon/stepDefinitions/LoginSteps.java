package lms.ui.hackathon.stepDefinitions;

import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.pageobjects.LoginPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class LoginSteps {
	public LoginPage loginpage;
	private CommonConfigs commonConfigs;
	TestContextSetUp testContSetup;
	
	public LoginSteps(TestContextSetUp testContSetup) {
		this.testContSetup = testContSetup;
		this.loginpage = testContSetup.pageObjManager.getLoginPage();

	}
}
