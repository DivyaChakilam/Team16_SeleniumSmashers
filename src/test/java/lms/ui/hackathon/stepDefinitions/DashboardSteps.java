package lms.ui.hackathon.stepDefinitions;

import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class DashboardSteps {
	public DashboardPage dashboardPage;
	public TestContextSetUp testContextSetUp;

	public DashboardSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.dashboardPage = testContextSetUp.pageObjManager.getDashboardPage();
	}
}
