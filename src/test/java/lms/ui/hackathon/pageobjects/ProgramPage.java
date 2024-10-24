package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProgramPage {
	private WebDriver driver;
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
	

	public ProgramPage(WebDriver driver) {
		this.driver = driver;
	}
	public void login() {
		driver.findElement(userLoc).sendKeys("Sdet@gmail.com");
		driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");
		driver.findElement(loginButton).click();
		
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
	
	
}
