package lms.ui.hackathon.pageobjects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import lms.ui.hackathon.utilities.ElementUtil;
import lms.ui.hackathon.utilities.LoggerLoad;

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

	
	public ClassDetailsPage(WebDriver driver) {
		this.driver = driver;
		util = new ElementUtil(this.driver);
	}
	
	//***************** Element Validation Method ***************************
	
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

	//***************** Element Action Method ***************************
	
	/**
	 * This method enters text in text field
	 * @param fieldName
	 * @param text
	 */
	public void enterTextInField(String fieldName, String text) {
		switch (fieldName.toLowerCase().trim()) {
		case "class topic": 
			util.doSendKeys(classTopicEditField, text);
		case "class description": 
			util.doSendKeys(classDescriptionField, text);
		case "comments": 			
			util.doSendKeys(commentsEditField, text);
		case "notes": 			
			util.doSendKeys(notesEditField, text);
		case "recording": 			
			util.doSendKeys(recordingEditField, text);
		default:
			throw new IllegalArgumentException("Incorrect field name: " + fieldName);
		}
	}
	
	/**
	 * This method selects option from dropdown menu
	 * @param fieldName
	 * @param text
	 */
	public void selectDropDownMenu(String fieldName, String text) {
		
		if(fieldName.toLowerCase().trim().equalsIgnoreCase("batch name")) {
			util.doClick(batchNameDropDownBtn);
		}else 
			util.scrollIntoView(staffNameDropDownBtn);
			util.doClick(staffNameDropDownBtn);
		
		
		if(util.isElementPresent(drodownMenuBody)) {
			List<WebElement> menus = util.getElements(drodownMenus);
			
			for(WebElement e: menus) {
				if(util.getAttributeVal(e,"aria-label").equalsIgnoreCase(text)) {
					e.click();
				}
			}
		}
		
	}

	/**
	 * This method selects radio button
	 * @param radioBtnName
	 */
	public void selectRadioButton(String radioBtnName) {
		switch (radioBtnName.toLowerCase().trim()) {
		case "active":
			util.doClick(radioBtnActive);
		case "inactive":
			util.doClick(radioBtnInactive);
		default:
			throw new IllegalArgumentException("Incorrect radio button name: " + radioBtnName);
		}
	}
	
	
	//************** Calendar related methods --- You can type date directly as well *****************
	
	/*Once date is selected, it is shown in the attribute "ng-reflect-model='Mon Oct 28 2024 00:00:00 GMT-0'"*/

	public void openCalendar() {
		util.scrollIntoView(selectDateCalenderBtn);
		util.doClick(selectDateCalenderBtn);
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
		
		if(Integer.parseInt(weekendDates.get(0))>1) {
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
		  LoggerLoad.info("Cannot select a past date for class start date");
		  return;}
		  
		  //1) Current or future date: Check if it the input date falls on weekend:
		  if(getAllWeekendDates().contains(formattedDate)) {
		  LoggerLoad.info("Cannot select a weekend date for class"); return; }
		 
		
		
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
	}
	
	public String getEnteredDateValueInEditBox() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return util.getAttributeVal(elementStoringEnteredDate, "ng-reflect-model");
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
		
		// List of dates in string format
        List<String> dates = Arrays.asList("11/30/2024", "12/30/2024", "01/30/2025", "10/30/2024");

		
        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        // Sort the dates
        List<String> sortedDates = dates.stream()
            .map(date -> LocalDate.parse(date, formatter))  // Convert to LocalDate
            .sorted()                                         // Sort the dates
            .map(date -> date.format(formatter))            // Convert back to string
            .collect(Collectors.toList());                   // Collect as a list

        // Print the sorted dates
		/*
		 * LoggerLoad.info("Sorted Dates:"); for (String date : sortedDates) {
		 * LoggerLoad.info(date); }
		 */
        
       // LoggerLoad.info(sortedDates);

		/*
		 * LoggerLoad.info("========================================");
		 * 
		 * random("21/30/2024", "22/30/2024", "23/30/2025");
		 */
	}
}

