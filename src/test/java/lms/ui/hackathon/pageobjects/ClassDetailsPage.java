package lms.ui.hackathon.pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import lms.ui.hackathon.utilities.ElementUtil;

public class ClassDetailsPage {

	private WebDriver driver;
	private ElementUtil util;
	
	private By title = By.xpath("//span[contains(@class,'p-dialog-title')]");
	
	private By batchNameField = By.id("batchName"); 
	private By batchNameDropDownBtn = By.xpath("(//span[contains(@class,'p-dropdown-trigger-icon')]/..)[1]");
	private By drodownMenuBody = By.xpath("//ul[@role='listbox']");
	private By drodownMenus = By.xpath("//ul[@role='listbox']//li");
	
	private By classTopicEditField = By.id("classTopic"); 
	private By classDescriptionField = By.id("classDescription"); 
	
	private By calendarTextField = By.id("icon");
	private By selectDateCalenderBtn = By.xpath("//button[@ng-reflect-icon='pi pi-calendar']"); //have to do getText
	private By allDisabledDatesForCurrentMonth = By.cssSelector("span.p-disabled");
	private By elementStoringEnteredDate = By.tagName("p-calendar");
	
	private By noOfClassesLabel = By.xpath("//label[text()='No of Classes']");
	private By noOfClassField = By.id("classNo"); //attribute name holding value is ng-reflect-model
	
	private By staffNameField = By.xpath("//input[@placeholder='Select a Staff Name']"); 
	private By staffNameDropDownBtn = By.xpath("(//span[contains(@class,'p-dropdown-trigger-icon')]/..)[2]");
	private By radioBtnActive = By.xpath("//div[normalize-space()='Active']/p-radiobutton");
	private By radioBtnInactive = By.xpath("//div[normalize-space()='Inactive']/p-radiobutton");
	
	private By commentsEditField = By.xpath("//label[text()='Comments']/following-sibling::input");  //attribute name holding value is ng-reflect-model
	private By notesEditField = By.xpath("//label[text()='Notes']/following-sibling::input");  //attribute name holding value is ng-reflect-model
	private By recordingEditField = By.xpath("//label[text()='Recording']/following-sibling::input"); //attribute name holding value is ng-reflect-model
	
	private By cancelBtn = By.xpath("//span[text()='Cancel']/..");
	private By saveBtn = By.xpath("//span[text()='Save']/..");
	private By crossBtn = By.xpath("//button[contains(@class,'p-dialog-header-close')]");

	private By errMsgs = By.xpath("//*[contains(@class,'p-invalid')]");
	
	
	public ClassDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	//***************** Element Validation Method ***************************
	
	/**
	 * Checks if Class Details popuup has title
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
			  if(util.getAttributeVal(calendarTextField,"ng-reflect-model") == null) {return true;} else return false;
			  
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

	
	/**
	 * This method returns total number of err Msgs displayed
	 * @return
	 */
	public int getErrMsgsCount() {
		return util.getElementSize(errMsgs);
	}
	
	/**
	 * This method takes expected count of error msgs and verifies if all these error texts contain "red" in "style" attribute
	 * @param errCount
	 * @return
	 */
	public boolean checkRedTextForAllErrMsgTexts(int errCount, String color) {
		
		int counter =0;
		List<WebElement> ele = util.getElements(errMsgs);
		
		/*
		 * for(WebElement e: ele) { ) if(e.getAttribute("style").contains(color)){
		 * //Syntax error on token ")", delete this token counter++; } }
		 */
		
		if(counter==errCount) {
			return true;}
		else return false;
	}
	
	/**
	 * This method return List of Err Msg Texts in the form of List<String>
	 * @return
	 */
	public List<String> getErrTextList() {
		
		List<String> errTextList = new ArrayList<String>();
		
		for(WebElement e: util.getElements(errMsgs)) {
			errTextList.add(util.getElementText(e));
		}
		return errTextList;
	}
	
	//***************** Form Element Action Method ***************************
	
	/**
	 * This method enters text in text field
	 * @param fieldName
	 * @param text
	 * @throws InterruptedException 
	 */
	public void enterTextInField(String fieldName, String text) throws InterruptedException {
		
		Thread.sleep(1000);
		
		switch (fieldName.toLowerCase().trim()) {
		case "class topic": 
			util.doClick(classTopicEditField);
			util.doSendKeys(classTopicEditField, text);
			break;
		case "class description": 
			util.doClick(classDescriptionField);
			util.doSendKeys(classDescriptionField, text);
			break;
		case "comments": 	
			util.doClick(commentsEditField);
			util.doSendKeys(commentsEditField, text);
			break;
		case "notes": 	
			util.doClick(notesEditField);
			util.doSendKeys(notesEditField, text);
			break;
		case "recording": 
			util.doClick(recordingEditField);
			util.doSendKeys(recordingEditField, text);
			break;
		default:
			throw new IllegalArgumentException("Incorrect field name: " + fieldName);
		}
	}
	
	/**
	 * This method selects option from dropdown menu
	 * @param fieldName
	 * @param text
	 * @throws Exception 
	 */
	public void selectDropDownMenu(String fieldName, String text) throws Exception {
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		Actions action = new Actions(driver);
		
		Thread.sleep(3000);
		
		if(fieldName.toLowerCase().trim().equalsIgnoreCase("batch name")) {
			/*
			 * while(util.getElementSize(drodownMenuBody)>0) {
			 * util.mouseclickUsingAction(batchNameDropDownBtn);
			 * //util.doClick(batchNameDropDownBtn); }
			 */
			util.doClick(batchNameField);
			js.executeScript("arguments[0].click();",util.getElement(batchNameDropDownBtn));
			
		}else {
			util.scrollIntoView(staffNameDropDownBtn);
			util.doClick(staffNameField);
			/*
			 * while(util.getElementSize(drodownMenuBody)>0) {
			 * util.doClick(staffNameDropDownBtn); }
			 */
			js.executeScript("arguments[0].click();",util.getElement(staffNameDropDownBtn));
			
			action.keyDown(Keys.DOWN).keyUp(Keys.DOWN)
			  .keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			
			js.executeScript("arguments[0].click();",util.getElement(staffNameDropDownBtn));
			js.executeScript("arguments[0].click();",util.getElement(staffNameDropDownBtn));

		}	
		
		  //Actions action = new Actions(driver);
			/*
			 * action.keyDown(Keys.DOWN).keyUp(Keys.DOWN)
			 * .keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
			 */
		 
		/*
		 * if(util.isElementPresent(drodownMenuBody)) { List<WebElement> menus =
		 * util.getElements(drodownMenus);
		 * 
		 * for(WebElement e: menus) {
		 * if(util.getAttributeVal(e,"aria-label").equalsIgnoreCase(text)) { e.click();
		 * } } }
		 */
		 		
	}

	/**
	 * This method selects radio button
	 * @param radioBtnName
	 * @throws InterruptedException 
	 */
	public void selectRadioButton(String radioBtnName) throws InterruptedException {
		
		Thread.sleep(2000);
		
		switch (radioBtnName.toLowerCase().trim()) {
		case "active":
			util.doClick(radioBtnActive);
			break;
		case "inactive":
			util.doClick(radioBtnInactive);
			break;
		default:
			throw new IllegalArgumentException("Incorrect radio button name: " + radioBtnName);
		}
	}
	
	/**
	 * This method enters only values in mandatory fields 
	 * @param batchName
	 * @param classTopic
	 * @param date
	 * @param staffName
	 * @param status
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public void enterMandatoryFields(String batchName, String classTopic,
			Object date, String staffName, String status) throws Exception {
		
		selectDropDownMenu("Batch Name", batchName);
		enterTextInField("class topic",classTopic);
		
		Thread.sleep(3000);
		openCalendar();
		if(date instanceof String) {
			selectCalendarDate((String)date); 
		}else if(date instanceof List){
			enterMultipleDates((List<String>) date);
		}else {
            throw new IllegalArgumentException("Invalid date type. Must be String or List<String>.");
        }
		
		selectDropDownMenu("Staff Name", staffName);
		selectRadioButton(status);
	}
	
	/**
	 * This method enters both mandatory and optional fields
	 * @param batchName
	 * @param classTopic
	 * @param date
	 * @param staffName
	 * @param status
	 * @param optClassDes
	 * @param optComments
	 * @param optNotes
	 * @param optRecording
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public void enterAllFields(String batchName, String classTopic,String optClassDes,
			Object date, String staffName, String status, 
			 String optComments, String optNotes, String optRecording) throws Exception {
		
		selectDropDownMenu("Batch Name", batchName);
		enterTextInField("class topic",classTopic);
		enterTextInField("class description",optClassDes);
		
		openCalendar();
		if(date instanceof String) {
			selectCalendarDate((String)date); 
		}else if(date instanceof List){
			enterMultipleDates((List<String>) date);
		}else {
            throw new IllegalArgumentException("Invalid date type. Must be String or List<String>.");
        }
		
		Thread.sleep(3000);
		
		selectDropDownMenu("Staff Name", staffName);
		selectRadioButton(status);
		enterTextInField("Comments",optComments);
		enterTextInField("Notes",optNotes);
		enterTextInField("Recording",optRecording);
		
	}
	
	//Incomplete!!!
	public void sendEmptyForm() {
		
	}
	
	
	public Object clickOnSaveButton() throws Exception {
		System.out.println("Inside login button function");
		util.doClick(saveBtn);
		Thread.sleep(1000);
		if(getErrMsgsCount()>0) {
			return null;
		}else return new ClassPage(driver);
	}
	
	//
	 public void clickOnNoOfClassesLabel() {
			util.doClick(noOfClassesLabel);
	 }
	
	
	//************** Calendar related methods --- You can type date directly as well *****************
	

	public void openCalendar() throws Exception {
		//util.scrollIntoView(selectDateCalenderBtn);
		util.doClick(selectDateCalenderBtn);
		Thread.sleep(2000);
	}
	
	private byte dynamicallyGetAnyDaysColumnNumber(String day) {
		
		By days = By.xpath("//table[contains(@class,'p-datepicker-calendar')]//th/span");
		byte colNumber = 1;
		List<WebElement> x =  util.getElements(days);
		
		for (WebElement e:x) {
			String dayValue = e.getText();
			if(dayValue.equalsIgnoreCase(day)) {
				break;
			}
			else colNumber++;
		}
		return colNumber;
	}
	
	public List<String> getAllWeekendDates() {
				
		List<String> weekendDates = new ArrayList<String>();
		
		By sundayDates = By.xpath("//table[contains(@class,'datepicker-calendar')]//tbody/tr/td["+dynamicallyGetAnyDaysColumnNumber("Su")+"]/span");
		By saturdayDates = By.xpath("//table[contains(@class,'datepicker-calendar')]//tbody/tr/td["+dynamicallyGetAnyDaysColumnNumber("Sa")+"]/span");
		
		List<WebElement> sundayDatesList = util.getElements(sundayDates);
		List<WebElement> saturdayDatesList = util.getElements(saturdayDates);
		sundayDatesList.addAll(saturdayDatesList);
		
		for (WebElement e: sundayDatesList) {
			weekendDates.add(e.getText());
		}
				
		if((Integer.parseInt(weekendDates.get(0))) > 1) {
			weekendDates.remove(0);
		}
				
		return weekendDates;
	}
	
	public List<String> getAllDisabledDates() {
		
	
		List<String> dates = new ArrayList<String>();
		List<WebElement> unavailableDates = util.getElements(allDisabledDatesForCurrentMonth);
		for (WebElement e: unavailableDates) {
				dates.add(e.getText());
		}
		return dates;
	}

	
	public void selectCalendarDate(String date) {
		
		String formattedDate = null;
		
		if(date.startsWith("0")) {
			formattedDate=String.valueOf(date.charAt(1));
		}else formattedDate = date;
			
		  //0) check if the date entered is a past date 
		if(Integer.parseInt(formattedDate) < Integer.parseInt(getTodaysDateOnly())) {
		  System.out.println("Cannot select a past date for class start date");
		  return;}
		  
		  //1) Current or future date: Check if it the input date falls on weekend:
		  if(getAllWeekendDates().contains(formattedDate)) {
		  System.out.println("Cannot select a weekend date for class"); return; }
		 
		
		
		By day = By.xpath("//span[text()='"+formattedDate+"']"); 
		List<WebElement> days= util.getElements(day);
		
		//2) If there are two element for Date 03, click on the one that is not disabled
		if(days.size()==2) {
			if(Integer.parseInt(formattedDate)<15) {
				util.doClick(days.get(0));
			}else {util.doClick(days.get(1));}
			
		}
		
		//3) Finally, if one element exists, click it
		if(days.size()==1) { 
			util.doClick(day);
		}
				
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	public void enterMultipleDates(List<String> multipleDates) {
		
		//sort the dates
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Sort the dates
        List<String> sortedDates = multipleDates.stream()
            .map(date -> LocalDate.parse(date, formatter))  // Convert to LocalDate
            .sorted()                                         // Sort the dates
            .map(date -> date.format(formatter))            // Convert back to string
            .collect(Collectors.toList());  
        
        for(String dates: sortedDates) {
        	selectCalendarDate((dates.split("/"))[1]);
        }
        
        util.doClick(noOfClassesLabel);
        
	}
	
	
	
	public String getEnteredDateValueInEditBox() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return util.getAttributeVal(elementStoringEnteredDate, "ng-reflect-model");
	}
	
	public String getUpdatedNoOfClasses() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return util.getAttributeVal(noOfClassField, "ng-reflect-model");
	}
	
	
	
	private static String getTodaysDate_MMDDYYY() {
		  LocalDate today = LocalDate.now();

	        // Define a date format
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	        // Format today's date
	        String formattedDate = today.format(formatter);
	        return formattedDate;
	}
	
	
	
	private static  String getTodaysDateOnly() {
		return getTodaysDate_MMDDYYY().split("/")[1];
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}
}

