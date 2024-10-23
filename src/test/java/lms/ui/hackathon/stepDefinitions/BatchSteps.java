package lms.ui.hackathon.stepDefinitions;

import lms.ui.hackathon.pageobjects.BatchPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class BatchSteps {
	public BatchPage batchPage;
	TestContextSetUp testContextSetup;
	public BatchSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.batchPage=testContextSetup.pageObjManager.getBatchPage();
	}
}
