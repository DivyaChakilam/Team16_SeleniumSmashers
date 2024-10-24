package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassDetailsPage {

	private WebDriver driver;
	private ElementUtil util;
	



	
	public ClassDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
}

//div[@role="checkbox"]