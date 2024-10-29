package lms.ui.hackathon.stepDefinitions;

import java.util.Arrays;
import java.util.List;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.pageobjects.ClassDetailsPage;
import lms.ui.hackathon.pageobjects.ClassPage;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.ProgramPage;
import lms.ui.hackathon.utilities.TestContextSetUp;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class ClassSteps {
	
	ProgramPage programPage;
	TestContextSetUp testContextSetup;
	DashboardPage dashboardPage;
	ClassPage classPage;
	ClassDetailsPage classDetailsPage;
	
	SoftAssert softAssert;
	
	String batchName = "postman662";

	
	public ClassSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		programPage=testContextSetup.pageObjManager.getProgramPage();
		softAssert = new SoftAssert();
	}
	
	
	@Given("Admin is on the Manage class page")
	public void admin_is_on_the_manage_class_page() throws Exception {
	   DriverFactory.getDriver().get(CommonConfigs.getUrl());
	   programPage.login();
	   dashboardPage = new DashboardPage(DriverFactory.getDriver());
	   classPage = (ClassPage) dashboardPage.goToMenu("Class");
	   
	   Assert.assertTrue(classPage.manageClassHeaderExists());
	   
	}
	@When("Admin clicks add new class under the class menu bar")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() {
	  
		classDetailsPage = classPage.goToAddNewClassPage();	
		Assert.assertTrue(classDetailsPage.isClassDetailsTitleExists());
	}
	
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
	
	@Given("Admin enters mandatory fields only")
	public void admin_enters_mandatory_fields_only() {
		//classDetailsPage.selectDropDownMenu("staff name","Getha Takur");
		//System.out.println(classDetailsPage.selectCalendarDate("31"));;
		//classDetailsPage.selectCalendarDate("27");
        
		classDetailsPage.openCalendar();
		List<String> dates = Arrays.asList("10/30/2024", "10/29/2024", "10/31/2025", "10/28/2024");

		classDetailsPage.enterMultipleDates(dates);
		System.out.println(classDetailsPage.getEnteredDateValueInEditBox());;

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

}
