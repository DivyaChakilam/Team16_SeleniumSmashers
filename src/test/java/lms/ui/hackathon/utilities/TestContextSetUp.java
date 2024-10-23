package lms.ui.hackathon.utilities;

import lms.ui.hackathon.pageobjects.PageObjectManager;

public class TestContextSetUp {
	
	public PageObjectManager pageObjManager;
	public Base base;
	
	public  TestContextSetUp() throws Throwable {
		base = new Base();
		pageObjManager = new PageObjectManager(base.WebDriverManager(), base.getConfigs());
	}
}
