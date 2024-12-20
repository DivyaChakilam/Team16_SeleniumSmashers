package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import lms.ui.hackathon.utilities.ElementUtil;

public class CommonAndPaginationFeatures {

	private WebDriver driver;
	private ElementUtil util;

	// Top Banner features

	protected By LMSHeader = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	protected By programMenu = By.xpath("//button/span[text()='Program']"); 
	protected By batchMenu = By.xpath("//span[text()='Batch']/..");
	protected By classMenu = By.xpath("//span[text()='Class']/..");
	protected By logOutMenu = By.xpath("//span[normalize-space()='Logout']");

	
	//Multiple Delete Btn and Search Box
	protected By multipleDeleteBtn = By.className("p-button-icon");
	protected By searchBox = By.id("filterGlobal");


	// Pagination Features
	protected By doubleLeftArrowBtn = By.xpath("//span[contains(@class,'double-left')]/..");
	protected By singleLeftArrowBtn = By.xpath("//span[contains(@class,'angle-left')]/..");
	protected By singleRightArrowBtn = By.xpath("//span[contains(@class,'angle-right')]/..");
	protected By doubleRightArrowBtn = By.xpath("//span[contains(@class,'double-right')]/..");

	protected By popUp_SuccessMsg = By.id("to be completed");

	// Table related xpath
	private By tableRows = By.xpath("//tbody[@class='p-datatable-tbody']/tr");

	
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
			
		case "batch":
			util.doClick(batchMenu);
			return new BatchPage(driver);

		case "class":
			gotoClassMenuThroughTABBING();
			return new ClassPage(driver);

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
	 * Check if Success Msg exixts or not
	 * @return
	 */
	public Boolean validateSuccessPopUpMsg() {
		return util.isElementDisplayed(popUp_SuccessMsg);
	}
	
	/**
	 * Use Actions class to go to Class Menu
	 */
	public void gotoClassMenuThroughTABBING() {
		
		util.doClick(programMenu);
		
		Actions action = new Actions(driver);
		action.keyDown(Keys.TAB).keyUp(Keys.TAB) 
				.keyDown(Keys.TAB).keyUp(Keys.TAB)
				.keyDown(Keys.ENTER).keyUp(Keys.ENTER)
				.keyDown(Keys.TAB).keyUp(Keys.TAB) 
				.keyDown(Keys.TAB).keyUp(Keys.TAB)
				.build().perform();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public LoginPage clickLogoutBtn() 
	{
		driver.findElement(logOutMenu).click();
		return new LoginPage(driver);
	}
	
	//********************** Table Related Methods ************************
	/**
	 * This method checks if table rows exists
	 * 
	 * @return
	 */
	public boolean doesTableRowsExists() {
		if (util.getElementSize(tableRows) > 0) {
			return true;
		} else
			return false;
	}
	
	

}
