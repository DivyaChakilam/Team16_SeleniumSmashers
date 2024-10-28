package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class CommonAndPaginationFeatures {

	private WebDriver driver;
	private ElementUtil util;

	// Top Banner features

	protected By LMSHeader = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	protected By programMenu = By.xpath("//button/span[text()='Program']"); 
	protected By batchMenu = By.xpath("//span[text()='Batch']/..");
	protected By classMenu = By.xpath("//span[text()='Class']/..");
	protected By logOutMenu = By.id("Logout");

	
	//Multiple Delete Btn and Search Box
	protected By multipleDeleteBtn = By.className("p-button-icon");
	protected By searchBox = By.id("filterGlobal");


	// Pagination Features
	protected By doubleLeftArrowBtn = By.xpath("//span[contains(@class,'double-left')]/..");
	protected By singleLeftArrowBtn = By.xpath("//span[contains(@class,'angle-left')]/..");
	protected By singleRightArrowBtn = By.xpath("//span[contains(@class,'angle-right')]/..");
	protected By doubleRightArrowBtn = By.xpath("//span[contains(@class,'double-right')]/..");
	// Later: Write dynamic locator for total number of programs/batches/classes --> WIP

	
	public CommonAndPaginationFeatures(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	//******************** Top Banner Methods ******************************
	
	/**
	 * This method intakes banner menu name and navigates to that menu page
	 * @param menuName
	 * @return
	 * @throws Exception
	 */
	public Object goToMenu(String menuName) throws Exception {

		switch (menuName.toLowerCase().trim()) {
		case "program":
			util.doClick(programMenu);
			return new ProgramPage(driver);
			//break;
		case "batch":
			util.doClick(batchMenu);
			return new BatchPage(driver);

			//break;
		case "class":
			util.doClick(classMenu);
			return new ClassPage(driver);

			//break;
		case "logout":
			util.doClick(logOutMenu);
			return new LogoutPage(driver);
			//break;
		/*
		 * Note:The "Unreachable code" error is occurring because the return statements
		 * inside each case block make the break statements unnecessary. Since the
		 * return statements exit the method immediately, the code following them (like
		 * break) is never reached.
		 */

		default:
			throw new Exception("Something went wrong!");
		}

	}
	
	/**
	 * This method checks of LMS Header exists and returns a boolean value
	 * @return
	 */
	public Boolean LMSHeaderExists() {
		return util.isElementDisplayed(LMSHeader);
	}
	

	/**
	 * This method checks if LogOut menu is present in the banner
	 * @return
	 */
	public boolean isLogout() { 
		return util.getElement(logOutMenu) != null ? true:false; }

	public boolean logoutBtnExists() {
		return util.isElementPresent(logOutMenu);
	}

	
	//******************** Multiple Delete Btn and Search Box Methods ******************************

	/**
	 * This method clicks on multiple Delete button
	 */
	public void multipleDeleteBtn() {
		util.doClick(multipleDeleteBtn);
	}
	
	/**
	 * This method enters text in search box
	 * @param text
	 */
	public void searchText(String text) {
		try {
			util.doSendKeys(searchBox, text);
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	//******************** Pagination Features Methods ******************************
	
	/**
	 * This method navigates user to First Page
	 */
	public void goToFirstPage() {
		util.doClick(doubleLeftArrowBtn);
	}
	
	/**
	 * This method navigates user to Previous Page
	 */
	public void goToPreviousPage() {
		util.doClick(singleLeftArrowBtn);
	}
	
	/**
	 * This method navigates user to Next Page
	 */
	public void goToNextPage() {
		util.doClick(singleRightArrowBtn);
	}
	
	/**
	 * This method navigates user to Last Page
	 */
	public void goToLastPage() {
		util.doClick(doubleRightArrowBtn);
	}
	
	
	/**
	 * This method checks if a given navigation button is disabled or not
	 * @param navigationArrowName
	 * @return
	 */
	public String navigationBtnDisableStatus(String navigationArrowName) {
		
		switch (navigationArrowName.toLowerCase().trim()) {
		case "first":
			return util.getAttributeVal(batchMenu, "class");
		case "previous":
			return util.getAttributeVal(batchMenu, "class");
		case "next":
			return util.getAttributeVal(batchMenu, "class");
		case "last":
			return util.getAttributeVal(batchMenu, "class");
		default:
			return "Button not disabled";
		}
	}
	

}
