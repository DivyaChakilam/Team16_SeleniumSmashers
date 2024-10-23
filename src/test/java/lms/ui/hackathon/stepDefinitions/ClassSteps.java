package lms.ui.hackathon.stepDefinitions;

import lms.ui.hackathon.pageobjects.ClassPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class ClassSteps {
	public ClassPage classPage;
	TestContextSetUp testContextSetup;
	public ClassSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.classPage=testContextSetup.pageObjManager.getClassPage();
	}

}
