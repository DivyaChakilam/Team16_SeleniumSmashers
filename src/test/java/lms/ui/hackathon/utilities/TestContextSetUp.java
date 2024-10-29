package lms.ui.hackathon.utilities;

import lms.ui.hackathon.pageobjects.PageObjectManager;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class TestContextSetUp {
	
	public PageObjectManager pageObjManager;
	//public Base base;
	
	public  TestContextSetUp() throws Throwable {
		
		pageObjManager = new PageObjectManager(DriverFactory.getDriver());

		
	}
}
