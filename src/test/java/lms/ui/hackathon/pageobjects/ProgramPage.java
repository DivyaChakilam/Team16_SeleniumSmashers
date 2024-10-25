package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ProgramPage extends CommonAndPaginationFeatures {
	private WebDriver driver;
	private ElementUtil util;
	public String deltedProgram;
	
	/*******************************By Locators****************************************/
	private By userLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By loginButton = By.cssSelector("#login");
	private By programLoc = By.xpath("//button[@id='program']");
	private By addNewProgramLoc = By.xpath("//button[contains(text(),'Add New Program')]");
	private By deleteLoc = By.xpath("//span/button[contains(@class,'p-button-danger')]");
	//span/button[contains(@class,'p-button-danger')]/../../../../td[2]
	private By deletedTextLoc = By.xpath("//span/button[contains(@class,'p-button-danger')]/../../../../td[2]");
	private By deleteMultipleLoc = By.xpath("//div/button[contains(@class,'p-button-danger')]");
	private By yesButtonLoc = By.xpath("//span[contains(text(),'Yes')]");
	private By noButtonLoc = By.xpath("//span[contains(text(),'No')]");
	private By XButtonLoc = By.xpath("//*[contains(@class,'p-dialog-header-close')]");
	private By checkboxesLoc = By.className("p-checkbox-icon");//this gives List of all checkboxes
	private By searchBoxLoc = By.id("filterGlobal");
	/***********sortloc by programname, description, status. option should be passed dynamically***********/
	//private By sortOptionsLoc = By.xpath("//th[contains(text(),'"+sortOption+"')]/p-sorticon/i")
	private By manageProgram = By.xpath("//div[contains(text(),'Manage Program')]");
	private By LMSHeader = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	private By logOutMenu = By.id("Logout");
	private By Logout = By.xpath("//span[normalize-space()='Logout']");
	

	public ProgramPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);

	}
	
	
	
	public void login() {
		util.doSendKeys(userLoc, "Sdet@gmail.com");
		//driver.findElement(userLoc).sendKeys();
		//driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");
		util.doSendKeys(passwordLoc, "LmsHackathon@2024");
		util.doClick(loginButton);
		//driver.findElement(loginButton).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void programTabClick() {
		driver.findElement(programLoc).click();		
	}
	public void clickAnyDelete() {
	    deltedProgram = driver.findElement(deletedTextLoc).getText();
		driver.findElement(deleteLoc).click();
	}
	public void validatePopup() {
		
	}
	
	public boolean isInProgramPage()
	{
		return util.getElement(manageProgram) != null ? true:false;
	}
	
	public boolean isLMSHeader()
	{
		return util.getElement(LMSHeader) != null ? true:false;
	}
	
	public boolean isLogout()
	{
		return util.getElement(Logout) != null ? true:false;
	}
	public boolean isAddnewprogram()
	{
		return util.getElement(addNewProgramLoc) != null ? true:false;
	}
}
