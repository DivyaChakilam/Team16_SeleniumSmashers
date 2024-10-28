package lms.ui.hackathon.pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.List;

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
	List<String> ascendingOrderList = new ArrayList<String>();
	List<String> descendingOrderList = new ArrayList<String>();
	public String successMessage;
	List<String> selectedProgramNames = new ArrayList<>();

	/*******************************By Locators****************************************/
	private By userLoc = By.id("username");
	private By passwordLoc = By.id("password");
	private By loginButton = By.cssSelector("#login");

	private By checkbox =By.xpath("//div[@role='checkbox']");

	private By programLoc = By.xpath("//button/span[text()='Program']"); 
	private By confirmPopUp = By.xpath("//span[contains(text(),'Confirm')]");
	private By addNewProgramLoc = By.xpath("//button[contains(text(),'Add New Program')]");
	private By deleteLoc = By.xpath("//span/button[contains(@class,'p-button-danger')]");
	private By deletedTextLoc = By.xpath("//span/button[contains(@class,'p-button-danger')]/../../../../td[2]");

	//this gives List of all checkboxes 
	private By searchBoxLoc = By.id("filterGlobal");
	private By manageProgramLoc = By.xpath("//div[@class='box'][1]");
	private By footerLoc = By.xpath("//span[contains(@class,'p-paginator-current')]");
	/***********sortloc by programname, description, status. option should be passed dynamically***********/
	//private By sortOptionsLoc = By.xpath("//th[contains(text(),'"+sortOption+"')]/p-sorticon/i")
	private By firstPage = By.xpath("//span[contains(@class,'double-left')]/..");
	private By previosPage = By.xpath("//span[contains(@class,'angle-left')]/..");
	private By NextPage = By.xpath("//span[contains(@class,'angle-right')]/..");
	private By LastPage = By.xpath("//span[contains(@class,'double-right')]/..");

	//private By deleteMultipleLoc = By.xpath("//div/button[contains(@class,'p-button-danger')]");
	private By yesButtonLoc = By.xpath("//span[contains(text(),'Yes')]");
	private By noButtonLoc = By.xpath("//span[contains(text(),'No')]");
	private By XButtonLoc = By.xpath("//*[contains(@class,'p-dialog-header-close')]");
	private By successMessageLoc = By.xpath("//div[contains(@class,'p-toast-message-text')]");
	//private By checkboxesLoc = By.xpath("//div[@role='checkbox']");//this gives List of all checkboxes
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
    
    private By addNewProgramBtn = By.xpath("//button[text()='Add New Program']");
    
    private By firstProgramEditButton = By.xpath("//table/tbody/tr//button[contains(@icon, 'pi-pencil')][1]");
    private By programPageSearchResult = By.xpath("//*[contains(text(), 'Showing 1')]");
    private By LMSHeadermodulesProgram = By.xpath("//div[@class='ng-star-inserted']/button[1]");
    private By LMSHeadermodulesBatch = By.xpath("//div[@class='ng-star-inserted']/button[2]");
    private By LMSHeadermodulesClass = By.xpath("//div[@class='ng-star-inserted']/button[3]");
    private By LMSHeadermodulesLogout = By.xpath("//div[@class='ng-star-inserted']/button[4]");
    
    private By totalRecords = By.xpath("//app-root/app-program[@class='ng-star-inserted']//mat-card/mat-card-content[@class='mat-card-content']/p-table/div/div[2]/div[.=' In total there are 27 programs. ']");
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



	public void login() { util.doSendKeys(userLoc, "Sdet@gmail.com");
	//driver.findElement(userLoc).sendKeys("Sdet@gmail.com");
	//driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");
	util.doSendKeys(passwordLoc, "LmsHackathon@2024");
	util.doClick(loginButton); //driver.findElement(loginButton).click();
	}

	
//	  public void login() { util.doSendKeys(userLoc, "Sdet@gmail.com");
//	  //driver.findElement(userLoc).sendKeys("Sdet@gmail.com");
//	  //driver.findElement(passwordLoc).sendKeys("LmsHackathon@2024");
//	  util.doSendKeys(passwordLoc, "LmsHackathon@2024");
//	  
//	  util.doClick(loginButton); //driver.findElement(loginButton).click();
//	  try {
//		Thread.sleep(2000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	  
//	  
//	  }
	 
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

	public List<String> click_on_checkBox(int fromRowNum , int toRowNum) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> checkboxEnable = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkbox));
		for (int i = fromRowNum; i <= toRowNum; i++) {
			WebElement checkboxElement = checkboxEnable.get(i);
			wait.until(ExpectedConditions.elementToBeClickable(checkboxElement));
			if (checkboxElement.isEnabled()) {
				checkboxElement.click();
				// Capture the program name in this row for later validation
				String programName = driver.findElement(By.xpath("//tr[" + (i + 1) + "]/td[2]")).getText();
				selectedProgramNames.add(programName);
			}
		}

		return selectedProgramNames;
	}
	public boolean validateCheckBoxSelection(int fromRowNum, int toRowNum) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> checkboxEnable = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(checkbox));
		boolean allSelected = true; // Flag to ensure all checkboxes are selected
		for (int i = fromRowNum; i <= toRowNum; i++) {
			WebElement checkboxElement = checkboxEnable.get(i);
			// Validate if the checkbox is selected
			if (!checkboxElement.isSelected()) {
				System.out.println("Checkbox in row " + (i + 1) + " is not selected as expected.");
				allSelected = false;
			}
		}

		return allSelected;
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

	public String succesMessageValidation()
	{

		successMessage = driver.findElement(successMessageLoc).getText();
		return successMessage;
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

	public void click_On_SortIcon(String headerName)
	{
		By sortIcon = By.xpath("//th[contains(text(),'"+headerName+"')]/p-sorticon/i");
		driver.findElement(sortIcon).click();

	}
	public List<String> getOriginalList(int headerNum)
	{
		By elements = By.xpath("//tbody/tr/td["+headerNum+"]");
		List<WebElement> elementsList = driver.findElements(elements);
		// capture text of all webelements into new(original) list
		originalList = elementsList.stream().map(e -> e.getText()).collect(Collectors.toList());
		return originalList;

	}
	public List<String> get_Ascending_Order_List()
	{
		// Sort the original list in case-insensitive order
		ascendingOrderList = originalList.stream()
				.sorted(String.CASE_INSENSITIVE_ORDER)
				.collect(Collectors.toList());
		return ascendingOrderList;

	}
	public List<String> get_Descending_Order_List()
	{
		// Sort the original list in case-insensitive order
		descendingOrderList = originalList.stream()
				.sorted(Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER))
				.collect(Collectors.toList());
		return descendingOrderList;

	}

	/**********************Common methods : wait helpers **********************************************/
	public void waitForElementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}


	public void programTabClick() {
		driver.findElement(programLoc).click();		
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
	
public ProgramDetailsPage goToAddNewProgramPage() {
	System.out.println("In goToAddNewProgramPage");
		util.doClick(addNewProgramBtn);
		return new ProgramDetailsPage(driver);
	}
public void searchText(String text)
{
	util.getElement(searchBox).sendKeys(text);
}
public void editFirstProgram()
{
	Actions action = new Actions(driver);
	waitForElementToBeVisible(firstProgramEditButton);
	WebElement editButton = driver.findElement(firstProgramEditButton);
	
	action.doubleClick(editButton).perform();
	
}
public boolean verifySearchResult()
{
	return util.getElement(programPageSearchResult) != null ? true:false;
}
public Boolean verifyLMSHeadermodulesProgram(){
	return util.getElement(LMSHeadermodulesProgram).getText().equals("Program")&&
			util.getElement(LMSHeadermodulesBatch).getText().equals("Batch")&&
			util.getElement(LMSHeadermodulesClass).getText().equals("Class")&&
			util.getElement(LMSHeadermodulesLogout).getText().equals("Logout");
			
			
}
public void 


}
