package lms.ui.hackathon.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import lms.ui.hackathon.utilities.ElementUtil;

public class BatchDetailsPage {

	private WebDriver driver;
	private ElementUtil util;

	public BatchDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	private By addNewBatchBtn = By.xpath("//button[text()='Add New Batch']");
	private By addBatchTitle=By.xpath("//span[contains(text(),'Batch Details')]");
	private By batchNameTextField= By.xpath("//input[@placeholder='Select a Program name']");
	private By batchNameCode=By.xpath("//input[@id='batchName']");

	private By batchDescTextBox=By.xpath ("//input[@id='batchDescription']");
	//private By batchName = By.xpath("//input[@*='batchDescription']");
	private By batchProgramNameTextBox=By.xpath("//p-dropdown[@id='programName']");
	private By batchNameTextBox=By.xpath("//input[@id='batchProg']");
	//p-dropdown[@id='programName']
	private By batchprogramNameFieldDropDownBtn= By.xpath("//div[@*='button']/span");
	private By batchCodeErrMsg= By.xpath("//small[@id='text-danger']");	
	private By statusField=By.xpath("//div[contains(@class, 'radio')]");
	private By batchActiveRadiobtn=By.xpath("//p-radiobutton[@ng-reflect-input-id='ACTIVE']");
	private By batchInActiveRadiobtn=By.xpath("//p-radiobutton[@ng-reflect-input-id='INACTIVE']");
	private By batchNoOfClassesField=By.xpath("//input[@id='batchNoOfClasses']");
	private By saveBatchBtn=By.xpath("//button[@label='Save']");
	private By cancelBatchBtn=By.xpath("//button[@label='Cancel']");
	private By closeBatchIconWindow=By.xpath("//span[contains(@class, 'p-dialog-header-close-icon')]");
	private By batchSuccessMsg = By.xpath("//div[text()='Batch Created Successfully']");
	private By batchNameMissing = By.xpath("//small[normalize-space()='Program Name is required.']");
	private By batchCodeMissing = By.xpath("//small[normalize-space()='Batch Name is required.']");
	private By batchDescMissing = By.xpath("//small[normalize-space()='Batch Description is required.']");
	private By batchStatusMissing = By.xpath("//small[text()='Status is required.']");
	private By batchNoOfClassMissing = By.xpath("//small[text()='Number of classes is required.']");
    private By firstOptionInDropdown = By.xpath("//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[1]/li");
  

	//Edit icon Validation

	
	
	public Boolean isProgramDetailsTitleExists() {
		return util.isElementPresent(addBatchTitle);
	}

	public String AddBatchTitleDisplayed() {

		return util.getElementText(addBatchTitle);	

	}

	public String getBatchNameText()
	{
		//String batchName= util.getAttributeVal(batchNameTextField, "ng-reflect-model");
		//String batchName=  util.getElement(batchProgramNameTextBox).getText();
		System.out.println("Batch Name ->"+util.getElement(batchNameTextBox).getAttribute("value"));
		return util.getElement(batchNameTextBox).getAttribute("value");
	}
	public String getProgramNameText()
	{
	    WebElement selectedTextElement = driver.findElement(batchNameTextField);
	    //Select select = new Select(selectedTextElement);
	    //System.out.println("batchNameTextField1-->"+select.getFirstSelectedOption().getText());
		//String batchName=  util.getElement(batchProgramNameTextBox).getText();
		System.out.println("ProgramNameText ->"+selectedTextElement.getAttribute("value"));
		return selectedTextElement.getAttribute("value");
	}
	public boolean isBatchNamePrefixEditable() {
		return util.isEditablefield(batchNameTextField);
	}

	//  New batch created Successfully
	public void enterBatchName(String batchName) {

		util.doSendKeys(batchNameTextField, batchName);
		util.doSendKeys(batchNameTextField,Keys.ENTER);
	}

	public void enterBatchCode(String batchCode) {
		util.doSendKeys(batchNameCode, batchCode);
	}

	public void enterBatchDescription(String description) {
		util.doSendKeys(batchDescTextBox, description);
	}

	public void selectStatus(String status) {
		util.doSendKeys(batchActiveRadiobtn, status);  
		util.doSendKeys(batchInActiveRadiobtn, status);  

	}

	public void enterNoOfClasses(String noOfClasses) {
		util.doSendKeys(batchNoOfClassesField, noOfClasses);
	}

	public boolean ValidateAddBtachFields() {
		if (batchNameCode != null && batchNameTextField != null && batchDescTextBox != null) {
			System.out.println("All required text box fields are present in the pop-up dialog.");
			return true;
		} else {
			System.out.println("Some fields are missing in the pop-up dialog.");
			return false;
		}
	}

	public boolean isProgramNameDropdownDisplayed() {
		WebElement dropdownElement = driver.findElement(batchProgramNameTextBox);
		boolean isDisplayed = dropdownElement.isDisplayed();
		boolean isDropdown = dropdownElement.getTagName().equals("p-dropdown");
		return isDisplayed && isDropdown;
	}


	public boolean isRadioButtonStatusDisplayed() {
		WebElement statusElement = driver.findElement(statusField);
		boolean statusIsDisplayed = statusElement.isDisplayed();

		List<WebElement> radioButtons = statusElement.findElements(By.xpath(".//p-radiobutton"));
		

		return statusIsDisplayed && radioButtons.size() > 0;
	}

	// 	Validate batch name prefix selected program name
	public void openAddNewBatchPopup(String popupName) {
		util.doClick(addNewBatchBtn); 
	}

	public void selectProgramName() {
		// Open the drop down
		try {
			

			driver.findElement(batchprogramNameFieldDropDownBtn).click();

	        // Wait until the first option is visible
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement firstOption = wait.until(ExpectedConditions.visibilityOfElementLocated(firstOptionInDropdown));

	        // Click the first option
	        firstOption.click();
	        // Click the first option


//		util.doClick(batchprogramNameFieldDropDownBtn);
//		Thread.sleep(2000);
//		
//		Actions action = new Actions(driver);
//		
//		while(driver.findElements(By.xpath("//ul[contains(@class,'p-dropdown-items')]/p-dropdownitem//span[text()='"+programName+"']")).size()>0) {
//			
//			action.keyDown(Keys.DOWN).keyUp(Keys.DOWN).build().perform();
//			Thread.sleep(2000);
//		}
		
		//  program name to the drop down input field
		
		//Thread.sleep(8000);
		/*
		//dropdownInput.sendKeys(programName);
		util.doClick(batchprogramNameFieldDropDownBtn);
		//util.mouseclickUsingAction(batchprogramNameFieldDropDownBtn);
		//util.pressdownButtonUsingAction(batchprogramNameFieldDropDownBtn);
		util.doSendKeys(batchprogramNameFieldDropDownBtn,programName);

		// press ENTER to select the option 
		util.doSendKeys(batchprogramNameFieldDropDownBtn,Keys.ENTER);*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*public void enterbatchCodeSuffix(String suffix) {
        driver.findElement(batchNameCode).sendKeys(suffix);
    }*/

	public String getbatchCodeErrorMessage() {
		return util.getElementText(batchCodeErrMsg);    
	}

	public String getErrorMessageEmptyFields() {
		return util.getElementText(batchNameMissing);

	}

	public boolean validateBatchNamePrefixIsNotEditable() {
		util.doSendKeys(batchNameCode, "Java"); 
		String batchNamePrefixText = util.getElementText(batchNameCode);
		return batchNamePrefixText.isEmpty(); 
	}

	public String VerifyEmptyBatchfields(String Errormsg) 
	{

		util.getElement(saveBatchBtn).click();
		switch (Errormsg.toLowerCase().trim()) { 
		case "batchname":
			return util.getElementText(batchNameMissing);
		case "batchcode":
			return util.getElementText(batchCodeMissing);
		case "batchdescription":
			return util.getElementText(batchDescMissing);
		case "status":
			return util.getElementText(batchStatusMissing);
		case "noofclasses":
			return util.getElementText(batchNoOfClassMissing);
		default:
			return util.getElementText(batchSuccessMsg);
		}			

	}

	public void clickSaveButton() {
		try {
			util.doClick(saveBatchBtn);
		} catch (Exception e) {
			System.out.println("Failed to click on the Save button: " + e.getMessage());
		}
	}
	
	
	
	public boolean isBatchCreatedSuccessfully() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Batch Created Successfully')]")));

		System.out.println(successMessage);
		if(successMessage.toString().toLowerCase().contains("batch created successfully"))
			return true;
		else
			return false;
		//return util.isElementPresent(batchSuccessMsg);
	}

	public void clickCancelButton() {
		System.out.println(isPopupClosedClose());
		util.doClick(cancelBatchBtn);
		System.out.println(isPopupClosedClose());

	}

	public boolean isPopupClosedClose() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !util.isElementAvailable(addBatchTitle); 
		
	}

	public void clickClosebatchButton() throws InterruptedException {
		util.doClick(closeBatchIconWindow);
		Thread.sleep(1000);
	}
	
	public String getrandomalpha(int length) {
		return(util.getRandomNumbers(length));
	}
// Edit icon Validation
	
	


	
}

	





