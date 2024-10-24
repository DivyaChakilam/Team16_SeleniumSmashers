package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassPage extends CommonAndPaginationFeatures{
	private WebDriver driver;
	private ElementUtil util;

	private By addNewClassBtn = By.xpath("//button[text()='Add New Class']");
	private By manageClassHeader = By.xpath("//div[normalize-space()='Manage Class']");
	
	//Column Headers
	
	
	
	public ClassPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	/**
	 * This method checks of Manage Class Header exists and returns a boolean value
	 * @return
	 */
	public Boolean LMSHeaderExists() {
		return util.isElementDisplayed(manageClassHeader);
	}
	
	/**
	 * This method navigates user to Class Details page
	 * @return
	 */
	public ClassDetailsPage goToAddNewClassPage() {
		
		util.doClick(addNewClassBtn);
		return new ClassDetailsPage(driver);
	}

}
