package lms.ui.hackathon.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.ui.hackathon.utilities.ElementUtil;

public class ProgramPage extends CommonAndPaginationFeatures {
	private WebDriver driver;
	private ElementUtil util;
	//public String deltedProgram;
	WebDriverWait wait =  null;
	List<String> originalList = new ArrayList<String>();

	/*******************************By Locators****************************************/
	private By userLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By loginButton = By.cssSelector("#login");

	private By checkbox =By.xpath("//div[@role='checkbox']");

	private By programLoc = By.xpath("//button/span[text()='Program']"); 
	private By confirmPopUp = By.xpath("//span[contains(text(),'Confirm')]");
	private By addNewProgramLoc = By.xpath("//button[contains(text(),'Add New Program')]");
	private By deleteLoc = By.xpath("//span/button[contains(@class,'p-button-danger')]");
	//span/button[contains(@class,'p-button-danger')]/../../../../td[2]
	private By deletedTextLoc = By.xpath("//span/button[contains(@class,'p-button-danger')]/../../../../td[2]");
	private By deleteMultipleLoc = By.xpath("//div/button[contains(@class,'p-button-danger')]"); 
	private By yesButtonLoc = By.xpath("//span[contains(text(),'Yes')]"); 
	private By noButtonLoc = By.xpath("//span[contains(text(),'No')]"); 
	private By XButtonLoc = By.xpath("//*[contains(@class,'p-dialog-header-close')]");
	private By checkboxesLoc = By.className("p-checkbox-icon");
	//this gives List of all checkboxes private By searchBoxLoc = By.id("filterGlobal");
	private By manageProgramLoc = By.xpath("//div[@class='box'][1]");
	private By footerLoc = By.xpath("//span[contains(@class,'p-paginator-current')]");
	/***********sortloc by programname, description, status. option should be passed dynamically***********/
	//private By sortOptionsLoc = By.xpath("//th[contains(text(),'"+sortOption+"')]/p-sorticon/i")
	private By firstPage = By.xpath("//span[contains(@class,'double-left')]/..");
	private By previosPage = By.xpath("//span[contains(@class,'angle-left')]/..");
	private By NextPage = By.xpath("//span[contains(@class,'angle-right')]/..");
	private By LastPage = By.xpath("//span[contains(@class,'double-right')]/..");


	public ProgramPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		util = new ElementUtil(this.driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	}

	/**
	 * This method clicks on delete button for a given program name
	 * @param programName
	 */
	public void clickDeleteBtnForProgram(String programName) {
		By deleteIcon = By.xpath("//tbody/tr/td[text()='"+programName+"']/following-sibling::td//button[@id='deleteProgram']");
		util.doClick(deleteIcon);	
	}


	public void login() {
		util.doSendKeys(userLoc, "Sdet@gmail.com");
		//driver.findElement(userLoc).sendKeys("Sdet@gmail.com");
		//driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");
		util.doSendKeys(passwordLoc, "LmsHackathon@2024");

		util.doClick(loginButton);
		//driver.findElement(loginButton).click();


	}
	public void clickProgram() throws InterruptedException {

		Actions action = new Actions(driver);
		waitForElementToBeVisible(programLoc);
		WebElement programButton = driver.findElement(programLoc);
		//performing double click on program as there is an overlay "Add New Program" after single click which is intercepting me to perform other operations
		action.doubleClick(programButton).perform();
	}
/*********** deleting the record by index*******************/
	//	public String deleteSingleRecord(int rowNum) {
	//		//int totalRecordToDelete = count;
	//		Actions action = new Actions(driver);
	//		waitForElementToBeVisible(By.xpath("//tr["+rowNum+"]/td[5]//div[@class='action']//button[@id='deleteProgram']"));
	//		String deletedProgram = driver.findElement(By.xpath("//tr["+rowNum+"]/td[2]")).getText();
	//		//System.out.println("Program Deleted:" + deletedProgram);
	//		WebElement deleteButtonOfRowToDelete = driver.findElement(By.xpath("//tr["+rowNum+"]/td[5]//button[@id='deleteProgram']"));//div[@class='action']//button[@id='deleteProgram']
	//		action.moveToElement(deleteButtonOfRowToDelete).click().build().perform();
	//		driver.switchTo().activeElement();	
	//		return deletedProgram;
	//	}

	public String click_on_checkBox(int fromRowNum , int toRowNum) {
		List<WebElement> checkboxEnable = new ArrayList<WebElement>();
		checkboxEnable=driver.findElements(checkbox);
		for(int i=fromRowNum; i<=toRowNum; i++) {
			if ( checkboxEnable.get(i).isEnabled()) {
				checkboxEnable.get(i).click();
				checkboxEnable.get(i).click();
			}
		}

		String prgmName = driver.findElement(By.xpath("//tr["+fromRowNum+"]/td[2]")).getText();
		return prgmName;
	}
	public boolean verifyPopupIsAppeared() {
		return driver.findElement(confirmPopUp).isDisplayed();
	}
	public void clickYes() {
		driver.findElement(yesButtonLoc).click();
	}
	public void clickNo() {
		driver.findElement(noButtonLoc).click();
	}
	public void clickCancel() {
		driver.findElement(XButtonLoc).click();
	}

	public boolean checkZeroResults() {
		String footerText = driver.findElement(footerLoc).getText();
		if(footerText.contains("0"))
		{
			System.out.println("Contains zero records");
			return true;
		}
		return false;
	}

	public boolean isNextPageActive() {
		return driver.findElement(NextPage).isEnabled();

	}
	public Boolean ispreviousPageActive() {
		return driver.findElement(previosPage).isEnabled();
	}

	public List<String> clickSortIcon(int headerNum ,String headerName)
	{
		By sortIcon = By.xpath("//th[contains(text(),'"+headerName+"')]/p-sorticon/i");
		driver.findElement(sortIcon).click();
		By elements = By.xpath("//tbody/tr/td["+headerNum+"]");
		List<WebElement> elementsList = driver.findElements(elements);
		// capture text of all webelements into new(original) list
		originalList = elementsList.stream().map(e -> e.getText()).collect(Collectors.toList());
		return originalList;
	}
	public List<String> getSortedList()
	{
		// Sort the original list in case-insensitive order
		List<String> sortedList = originalList.stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		return sortedList;

	}
	
	/*STEP1) GET ALL THE PROGRAM NAMES FROM THE COLUMN --> STORE IT IN A LIST --> ORIGINAL LIST
	 * STEP2) CLICK ON SORT ICON
	 * STEP3) SAVE THE SORTED PROGRAM NAMES FROM STEP2 IN A LIST --> SORTEDLIST
	 * 
	 * ASSERTION
	 * LIST FROM STEP3 EQUALS LIST(FROM STEP1)..stream().sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList()
				
		LIST SORTED BY LMS SORT ICON VS LIST SORTED BY JAVA.SORT() METHOD;
	 * */
	
	


	/**********************Common methods : wait helpers **********************************************/
	public void waitForElementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


}
