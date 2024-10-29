package lms.ui.hackathon.stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.pageobjects.ClassDetailsPage;
import lms.ui.hackathon.pageobjects.ClassDialoguePage;
import lms.ui.hackathon.pageobjects.ClassPage;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.ProgramPage;
import lms.ui.hackathon.utilities.TestContextSetUp;
import lms.ui.hackathon.utilities.Utils;

public class ClassSteps {
	
	ProgramPage programPage;
	TestContextSetUp testContextSetup;
	DashboardPage dashboardPage;
	ClassPage classPage;
	ClassDetailsPage classDetailsPage;
	ClassDialoguePage classDialoguePage;
	
	SoftAssert softAssert;
	
	String batchName = "postman662";
	String search_batchNameValue;
	String search_classTopicValue;
	String search_staffNameValue;
	
	String addClass_batchName;
	String addClass_classTopic;
	String addClass_classDescription;
	String addClass_classDate;
	List<String> addClass_classDateList;
	String addClass_noOfClass;
	String addClass_staffName;
	String addClass_status;
	String addClass_comments;
	String addClass_notes;
	String addClass_recording;
	
	
	public ClassSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		dashboardPage=testContextSetup.pageObjManager.getDashboardPage();
		softAssert = new SoftAssert();
	}
	
	/*
	 * @Given("Admin is on the Manage class page") public void
	 * admin_is_on_the_manage_class_page() throws Exception {
	 * DriverFactory.getDriver().get(CommonConfigs.getUrl()); programPage.login();
	 * Thread.sleep(3000); dashboardPage = new
	 * DashboardPage(DriverFactory.getDriver()); classPage = (ClassPage)
	 * dashboardPage.goToMenu("Class");
	 * 
	 * Assert.assertTrue(classPage.manageClassHeaderExists()); }
	 */
	@When("Admin clicks Class on the navigation bar")
	public void admin_clicks_class_on_the_navigation_bar() throws Exception {
		if(dashboardPage!=null) {
			System.out.println("dashboardPage is not null");
			classPage = (ClassPage)dashboardPage.goToMenu("Class");
		}
	}
	
	
	@When("Admin clicks add new class under the class menu bar")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() throws Exception {
	  
		//classPage = (ClassPage)dashboardPage.goToMenu("Class");
		classDetailsPage = classPage.goToAddNewClassPage();	
		Assert.assertTrue(classDetailsPage.isClassDetailsTitleExists());
	}
	
	//********************** Add New Class scenario step defs ******************

	@Then("Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	    
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Batch Name"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Class Topic"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Class Description"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Select Class Dates"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("No of Classes"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Staff Name"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Comments"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Notes"));
		softAssert.assertTrue(classDetailsPage.isFieldEmpty("Recording"));
		
		softAssert.assertFalse(classDetailsPage.isRadioBtnSelected("Active"));
		softAssert.assertFalse(classDetailsPage.isRadioBtnSelected("Inactive"));

		softAssert.assertTrue(classDetailsPage.isButtonPresent("Cancel"));
		softAssert.assertTrue(classDetailsPage.isButtonPresent("Save"));
		softAssert.assertTrue(classDetailsPage.isButtonPresent("Close"));
		
		softAssert.assertAll();

	}
	
	@Then("Admin should see a mix of input fields and text boxes totalling to {int} in the class details window")
	public void admin_should_see_a_mix_of_input_fields_and_text_boxes_totalling_to_in_the_class_details_window(Integer fieldCount) {
		Assert.assertEquals(classDetailsPage.fieldCount(), fieldCount);
	}
	
	//********************** Add New Class popup scenario step defs ******************

	@When("Admin enters mandatory fields only")
	public void admin_enters_mandatory_fields_only() {
	    
	}
	
	
	@When("Admin enters all fields only")
	public void admin_enters_all_fields_only() throws Exception {  //WIP
		
		
		  addClass_batchName = "Micro service-01"; 
		  addClass_classTopic = "Java OOPS Concept"; 
		  addClass_classDescription = "Encapsulation, Inheritance, Abstraction";
		  addClass_classDateList = Arrays.asList("10/29/2024");
		  addClass_staffName = "arunasel S"; 
		  addClass_status = "Active";
		  addClass_comments = "some comments"; 
		  addClass_notes = "some notes";
		  addClass_recording = "October_2024/recording_01";
		  
			
		  classDetailsPage.enterAllFields(addClass_batchName, addClass_classTopic,
		  addClass_classDescription, addClass_classDateList, addClass_staffName,
		  addClass_status, addClass_comments, addClass_notes, addClass_recording);
			
		  classPage = (ClassPage)classDetailsPage.clickOnSaveButton();
			 
	}
	
	@Then("Admin gets message {string} in Manage Class Page")
	public void admin_gets_message_in_manage_class_page(String expectedSuccessMsg) throws Exception {
	    
		Assert.assertEquals(classPage.getClassCreationSuccessMsg(), expectedSuccessMsg);		
	}
	
	@Then("Admin sees created class details in Class Dialog Page")
	public void admin_sees_created_class_details_in_class_dialog_page() throws InterruptedException {
	    
		classPage.searchText(addClass_classTopic);
		Thread.sleep(5000);

		  if(classPage.doesTableRowsExists()) {
		  
			  classDialoguePage = classPage.clickOnColumnValueInTableRow(addClass_classTopic);
			  
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Class Topic"),addClass_classTopic); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("No of Classes"),addClass_classDateList.size()); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Class Start Date"),addClass_classDateList.get(0)); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Class Description"),addClass_classDescription); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Status"),addClass_status); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Class Comments"),addClass_comments); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Class Notes"),addClass_notes); 
			  softAssert.assertEquals(classDialoguePage.getValueOfField("Class Recording Path"),addClass_recording); 

			  classDialoguePage.closeClassDialoguePage();
		}
		else {softAssert.assertFalse(true);}
		  
		  softAssert.assertAll();
		  
	}
	
	@When("Admin selects class date in date picker")
	public void admin_selects_class_date_in_date_picker() throws Exception {
	    
		addClass_classDateList = Arrays.asList("10/31/2024","10/29/2024","10/30/2024");
		classDetailsPage.openCalendar();
		classDetailsPage.enterMultipleDates(addClass_classDateList);
	}
	
	@Then("Admin should see no of class value is added automatically")
	public void admin_should_see_no_of_class_value_is_added_automatically() {
	    
		Assert.assertEquals(classDetailsPage.getUpdatedNoOfClasses(), addClass_classDateList.size());
	}
	
	@When("Admin selects class weekend date in date picker")
	public void admin_selects_class_weekend_date_in_date_picker() throws Exception {
	
		classDetailsPage.openCalendar();
		List<String> weekendDates = classDetailsPage.getAllWeekendDates();
		String randomWeekendDate = weekendDates.get(Utils.getRandomNumberWithin(weekendDates.size()));
		System.out.println("Wekend date to be selected = " + randomWeekendDate);
		classDetailsPage.selectCalendarDate(randomWeekendDate);
	}
	
	
	@Then("Admin should see weekends dates are disabled to select")
	public void admin_should_see_weekends_dates_are_disabled_to_select() {	
		Assert.assertEquals(classDetailsPage.getUpdatedNoOfClasses(), null);	    
	}
	
	@When("Admin skips to add value in mandatory field and enter only the optional field")
	public void admin_skips_to_add_value_in_mandatory_field_and_enter_only_the_optional_field() throws Exception {
	    
		classDetailsPage.enterTextInField("Class Description","only optional fields test");
		classDetailsPage.enterTextInField("Comments","only optional fields test - Comments");
		classDetailsPage.enterTextInField("Notes","only optional fields test - Notes");
		classDetailsPage.enterTextInField("Recording","only optional fields test - Recording");
		classDetailsPage.clickOnSaveButton();

	}
	
	@Then("Admin should see error message below the {int} mandatory test field and the field will be highlighed in {string} color:")
	public void admin_should_see_error_message_below_the_mandatory_test_field_and_the_field_will_be_highlighed_in_color(Integer errCount, String expectedErrTextColor, DataTable errMsgdataTable) {
		
		softAssert.assertEquals(classDetailsPage.getErrMsgsCount(), errCount);
		softAssert.assertTrue(classDetailsPage.checkRedTextForAllErrMsgTexts(errCount,expectedErrTextColor));
		softAssert.assertEquals(classDetailsPage.getErrTextList(), errMsgdataTable.asList());
		
		softAssert.assertAll();

	}
		
	
	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() throws Exception {
	    
		classDetailsPage.clickOnSaveButton();
	}
	
	@Then("Class will not be created and Admin gets {int} error messages for mandatory fields")
	public void class_will_not_be_created_and_admin_gets_error_messages_for_mandatory_fields(Integer errMsgsCount) {
	    
		Assert.assertEquals(classDetailsPage.getErrMsgsCount(), errMsgsCount);
		
	}
	
	//********************** Search scenario step defs ******************
	@When("Admin enter the {string} in search textbox in Manage Class page")
	public void admin_enter_the_in_search_textbox_in_manage_class_page(String columnName) {
		
		search_batchNameValue ="Micro service-01";
		search_classTopicValue= "";
		search_staffNameValue= "Getha Thakur";
		
		if(columnName.trim().equalsIgnoreCase("Batch Name")) {
			classPage.searchText(search_batchNameValue);
		}else if(columnName.trim().equalsIgnoreCase("Class Topic")) {
			classPage.searchText(search_classTopicValue);
		}else classPage.searchText(search_staffNameValue);
	}
	
	@Then("Admin should see Class details are searched by {string}")
	public void admin_should_see_class_details_are_searched_by(String columnName) {
		
		if(columnName.trim().equalsIgnoreCase("Batch Name")) {
			Assert.assertTrue(classPage.isAllValuesInAColumnSame("Batch Name",search_batchNameValue));
		}else if(columnName.trim().equalsIgnoreCase("Class Topic")) {
			Assert.assertTrue(classPage.isAllValuesInAColumnSame("Class Topic",search_classTopicValue));
		}else 
			Assert.assertTrue(classPage.isAllValuesInAColumnSame("Staff Name",search_staffNameValue));

	}
	
	@When("Admin clicks {string} link on the class table")
	public void admin_clicks_link_on_the_class_table(String page) {
		switch (page) {
		case "Next page":
			classPage.goToNextPage();
			break;
		case "Last page":
			classPage.goToLastPage();
			break;
		case "Previous page":
			classPage.goToPreviousPage();
			break;
		case "First page":
			classPage.goToFirstPage();
			break;
		}	}

	@Given("Admin is on last page of class module table")
	public void admin_is_on_last_page_of_class_module_table() {
		classPage.goToLastPage();
	}
	@When("Admin clicks on delete button for a class")
	public void admin_clicks_on_delete_button_for_a_class() {
		classPage.searchText(batchName);//replace it with class name
		programPage.clickDeleteBtnForProgram(batchName); //replace it with class name
	}

	@When("Admin Searches for Deleted Class name")
	public void admin_searches_for_deleted_class_name() {
		classPage.searchText(batchName); //replace it with class name
	}
	//********************** Sort scenario step defs ******************
	
	//Ascending Order
	@When("Admin clicks on the {string} sort icon in Manage Class")
	public void admin_clicks_on_the_sort_icon_in_manage_class(String columnName) {
		
		classPage.clickOnSortIconFor(columnName);

	}

	@Then("Admin See the {string} is sorted in Ascending order in Manage Class")
	public void admin_see_the_is_sorted_in_ascending_order_in_manage_class(String columnName) {
		
		List<String> columnValues = classPage.getColumnValues(columnName);
		Assert.assertEquals(columnValues, classPage.getSortedList(columnValues));
	}
	
	//Descending Order
	@When("Admin clicks on the {string} sort icon twice in Manage Class")
	public void admin_clicks_on_the_sort_icon_twice_in_manage_class(String columnName) {
		classPage.clickOnSortIconFor(columnName);
		classPage.clickOnSortIconFor(columnName);
	}
	
	@Then("Admin See the {string} is sorted in Descending order in Manage Class")
	public void admin_see_the_is_sorted_in_descending_order_in_Manage_Class(String columnName) {
		List<String> columnValues = classPage.getColumnValues(columnName);
		Assert.assertEquals(columnValues, classPage.getSortedList(columnValues));
	}
	
	
}
