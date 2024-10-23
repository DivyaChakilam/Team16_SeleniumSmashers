package lms.ui.hackathon.stepDefinitions;

import lms.ui.hackathon.pageobjects.ProgramPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class ProgramSteps {
	TestContextSetUp testContextSetUp ;
	public ProgramPage programPage;
	
	public ProgramSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.programPage = testContextSetUp.pageObjManager.getProgramPage();
	}

}
