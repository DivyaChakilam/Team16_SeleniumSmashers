package lms.ui.hackathon.utilities;

import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.pageobjects.PageObjectManager;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class TestContextSetUp {
	
	public PageObjectManager pageObjManager;
	//public Base base;
	
	public  TestContextSetUp() throws Throwable {
		//base = new Base();
		//pageObjManager = new PageObjectManager(base.WebDriverManager(), base.getConfigs());
		pageObjManager = new PageObjectManager(DriverFactory.getDriver());

		
	}
}
