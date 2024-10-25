package lms.ui.hackathon.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassDetailsPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By title = By.xpath("//span[contains(@class,'p-dialog-title')]");
	
	private By batchNameField = By.id("batchName"); 
	private By batchNameDropDownBtn = By.xpath("(//span[contains(@class,'p-dropdown-trigger-icon')]/..)[1]");
	private By batchNameDrodownMenuBody = By.xpath("//ul[@role='listbox']");
	private By batchNameDrodownMenus = By.xpath("//ul[@role='listbox']//li");
	
	private By classTopicEditField = By.id("classTopic"); 
	private By classDescriptionField = By.id("classDescription"); 
	
	private By calendarTextField = By.id("icon");
	private By selectDateCalenderBtn = By.xpath("//button[@ng-reflect-icon='pi pi-calendar']"); //have to do getText
	//pick calendar date ==> will do it later --> WIP
	
	private By noOfClassField = By.id("classNo"); //attribute name holding value is ng-reflect-model
	
	private By staffNameField = By.xpath("//input[@placeholder='Select a Staff Name']"); 
	private By staffNameDropDownBtn = By.xpath("(//span[contains(@class,'p-dropdown-trigger-icon')]/..)[2]");
	private By staffNameDrodownMenuBody = By.xpath("//ul[@role='listbox']"); //have to do getText
	private By staffNameDrodownMenus = By.xpath("//ul[@role='listbox']//li");
	private By radioBtnActive = By.xpath("//div[normalize-space()='Active']/p-radiobutton");
	private By radioBtnInactive = By.xpath("//div[normalize-space()='Inactive']/p-radiobutton");
	
	private By commentsEditField = By.xpath("//label[text()='Comments']/following-sibling::input");  //attribute name holding value is ng-reflect-model
	private By notesEditField = By.xpath("//label[text()='Notes']/following-sibling::input");  //attribute name holding value is ng-reflect-model
	private By recordingEditField = By.xpath("//label[text()='Recording']/following-sibling::input"); //attribute name holding value is ng-reflect-model
	
	private By cancelBtn = By.xpath("//span[text()='Cancel']/..");
	private By saveBtn = By.xpath("//span[text()='Save']/..");
	private By crossBtn = By.xpath("//button[contains(@class,'p-dialog-header-close')]");

	
	public ClassDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}

	/**
	 * Checks if Class Details popu up has title
	 * @return
	 */
	public Boolean isClassDetailsTitleExists() {
		return util.isElementPresent(title);
	}

	
	/**
	 * This method checks if edit fields or dropdown fields are empty
	 * @param fieldName
	 * @return
	 */
	public Boolean isFieldEmpty(String fieldName) {
				
		switch (fieldName.toLowerCase().trim()) { 
		case "batch name": 
			if(util.getAttributeVal(batchNameField, "ng-reflect-model") == null) {return true;} else return false;
		
		case "class topic": 
			if(util.getAttributeVal(classTopicEditField, "ng-reflect-model") == null) {return true;} else return false;
		
		case "class description": 
			if(util.getAttributeVal(classDescriptionField, "ng-reflect-model") == null) {return true;} else return false;
		
		case "select class dates": 			
			  if(util.getElementText(calendarTextField).isEmpty()) { return true; } else return false;
			  
		case "no of classes": 			
			if(util.getAttributeVal(noOfClassField, "ng-reflect-model") == null) {return true;} else return false;
			
		case "staff name": 
			if(util.getElementText(staffNameField).isEmpty()) { return true; } else return false;

		case "comments": 			
			if(util.getAttributeVal(commentsEditField, "ng-reflect-model") == null) {return true;} else return false;

		case "notes": 			
			if(util.getAttributeVal(notesEditField, "ng-reflect-model") == null) {return true;} else return false;

		case "recording": 			
			if(util.getAttributeVal(recordingEditField, "ng-reflect-model") == null) {return true;} else return false;
	 
		default:
			throw new IllegalArgumentException("Incorrect field name: " + fieldName);
		}
		
	}
	
	/**
	 * Checks if a radio button is selected in Class Details Page
	 * @param buttonName
	 * @return
	 */
	public Boolean isRadioBtnSelected(String radioBtnName) {
		
		switch (radioBtnName.toLowerCase().trim()) {
		case "active":
			if(util.getElement(radioBtnActive).isSelected() == false) {return false;} else return true;
		
		case "inactive":
			if(util.getElement(radioBtnInactive).isSelected() == false) {return false;} else return true;
		default:
			throw new IllegalArgumentException("Incorrect radio button name: " + radioBtnName);
		}	
	}
	
	/**
	 * Checks if a button is present in Class Details Page
	 * @param buttonName
	 * @return
	 */
	public Boolean isButtonPresent(String buttonName) {
		
		switch (buttonName.toLowerCase().trim()) {
		case "cancel":
			if(util.isElementPresent(cancelBtn)) {return true;} else return false;
		case "save":
			if(util.isElementPresent(saveBtn)) {return true;} else return false;
		case "close":
			if(util.isElementPresent(crossBtn)) {return true;} else return false;
			
		default:
			throw new IllegalArgumentException("Incorrect button name: " + buttonName);
		}
	}

	/**
	 * Checks total number of fields present in the form
	 * @return
	 */
	public int fieldCount() {	
		return util.getElementSize(By.cssSelector("#batchName, #classTopic, #classDescription, #icon, #classNo, #staffId, #classComments, #classNotes, #classRecordingPath"));
	}

	
	
}

