package lms.ui.hackathon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
	//private By deleteMultipleLoc = By.xpath("//div/button[contains(@class,'p-button-danger')]");
	private By yesButtonLoc = By.xpath("//span[contains(text(),'Yes')]");
	private By noButtonLoc = By.xpath("//span[contains(text(),'No')]");
	private By XButtonLoc = By.xpath("//*[contains(@class,'p-dialog-header-close')]");
	private By checkboxesLoc = By.className("p-checkbox-icon");//this gives List of all checkboxes
	//private By searchBoxLoc = By.id("filterGlobal");
	/***********sortloc by programname, description, status. option should be passed dynamically***********/
	//private By sortOptionsLoc = By.xpath("//th[contains(text(),'"+sortOption+"')]/p-sorticon/i")
	
	//Feature Navigation,Menu Bar ,Manage Program Validation ,Add new Program ,Edit Program
	
	private By manageProgram = By.xpath("//div[contains(text(),'Manage Program')]");
	
	private By headerprogramName = By.xpath("//th[@psortablecolumn='programName']");
	private By headerProgramDescription = By.xpath("//th[@psortablecolumn='programDescription']");
	private By headerProgramStatus = By.xpath("//th[@psortablecolumn='programStatus']");
	private By headerEditDelete = By.xpath("//th[normalize-space()='Edit / Delete']");
	private By searchBox = By.id("filterGlobal");
	private By headercheckbox = By.xpath("//thead//div[@role='checkbox']");
	private By programCheckboxes = By.xpath("//div[contains(@class,'p-checkbox-box') and contains(@class,'p-component')]");
    private By ProgramNameSortIcon = By.xpath("//th[@psortablecolumn='programName']/p-sorticon");
    private By ProgramDescriptionSortIcon = By.xpath("//th[@psortablecolumn='programDescription']/p-sorticon");
    private By ProgramStatusSortIcon = By.xpath("//th[@psortablecolumn='programStatus']/p-sorticon");
    
	

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
	
	/*
	 * public boolean isLMSHeader() { return util.getElement(LMSHeader) != null ?
	 * true:false; }
	 * 
	 
	 */
	public boolean isAddnewprogram()
	{
		return util.getElement(addNewProgramLoc) != null ? true:false;
	}
	public boolean verifyProgramHeader()
	{
		System.out.println("In verifyProgramHeader");
		return (util.getElement(headerprogramName) != null ? true:false) && (util.getElement(headerProgramDescription) != null ? true:false)
				&&(util.getElement(headerProgramStatus) != null ? true:false) && (util.getElement(headerEditDelete) != null ? true:false);
	}
	public boolean verifySearchbar()
	{
		System.out.println("In verifySearchbar");
		return util.getElement(searchBox) != null ? true:false;
	}
	//checking checkbox is selected or not
	public boolean verifyCheckbox()
	{
		System.out.println("In verifyCheckbox");
		return util.getElement(headercheckbox).isSelected() ;
	}
	//loop through each checkbox webelement to see if the checkboxes are selected or not
	
	public boolean verifyProgramCheckboxes()
	{
		System.out.println("In verifyProgramCheckboxes");
		List<WebElement> elements=util.getElements(programCheckboxes);
		for(WebElement e : elements ) {
			
			if(e.isSelected())
			{
				return true;
			}
						
		}
		return false;
		
	}
	public boolean verifyProgramSortIcon()
	{
		System.out.println("In verifyProgramSortIcon");
		return (util.getElement(ProgramNameSortIcon) != null ? true:false) && (util.getElement(ProgramDescriptionSortIcon) != null ? true:false)
				&&(util.getElement(ProgramStatusSortIcon) != null ? true:false);
	}
	
}
