package lms.ui.hackathon.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.ProgramPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class ProgramSteps {
	TestContextSetUp testContextSetUp ;
	public DashboardPage dashboardPage;
	public ProgramPage programPage;
	String programNameDeleted = "";
	String invalidProgramName = "ljf5@1";
	String programName = "piechart";
	String programDescription = "SDET";
	String ProgramPartialName = "pie";
	List<String> originalList = new ArrayList<String>();
	List<String> sortedList = new ArrayList<String>();


	public ProgramSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.programPage = testContextSetUp.pageObjManager.getProgramPage();
		dashboardPage = testContextSetUp.pageObjManager.getDashboardPage();
	}

	@Given("Admin is on the dashboard page after login")
	public void admin_login() {
		programPage.login(); //--> should be coming from Madhuvi's Login Page

	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_on_program() throws Exception {
		programPage.clickProgram();
		//programPage.goToMenu("Program");

	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
		
		programPage.searchText(programName);
		programPage.clickDeleteBtnForProgram(programName);
	}

	@Then("Admin will get confirm deletion popup")
	public void validate_confirm_deletion_popup() {
		org.testng.Assert.assertEquals(programPage.verifyPopupIsAppeared(), true);
	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String popUpOption) {
		String option = popUpOption.toLowerCase();
		switch (option) {
		case "yes":
			//programPage.clickYes();
			break;
		case "no":
			programPage.clickNo();
			break;
		case "x" :
			programPage.clickCancel();
			break;
		}
	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String confirmMess) {


	}

	@When("Admin Searches for Deleted Program name")
	public void admin_searches_for_deleted_program_name() {
		programPage.searchText(programNameDeleted);
	}

	@Then("There should be zero results")
	public void there_should_be_zero_results() {
		programPage.checkZeroResults();
		Assert.assertEquals(programPage.checkZeroResults(), true);
	}

	@Given("Admin is on Confirm deletion form")
	public void admin_is_on_confirm_deletion_form() {
		programPage.searchText(programName);
		programPage.clickDeleteBtnForProgram(programName);
	}

	@Then("Admin can see Confirmation form disappears and lands on program page")
	public void admin_can_see_confirmation_form_disappears_and_lands_on_program_page() {
		//org.testng.Assert.assertEquals(programPage.verifyPopupIsAppeared(), true);

	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
		programPage.click_on_checkBox(1, 4);
	}

	@Then("Programs get selected")
	public void programs_get_selected() {

	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
		programPage.multipleDeleteBtn();
	}

	@Given("Admin is on Confirmation form")
	public void admin_is_on_confirmation_form() {

	}

	@When("Admin Searches for Deleted Program names")
	public void admin_searches_for_deleted_program_names() {

	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {

	}

	@When("Admin enter the program to search By {string}")
	public void admin_enter_the_program_to_search_by(String programColumns) {
		String option = programColumns.toLowerCase();
		switch (option) {
		case "programname":
			programPage.searchText(programName);
			break;
		case "ProgramDescription":
			programPage.searchText(programDescription);
			break;
		case "PartialProgName" :
			programPage.searchText(ProgramPartialName);
			break;
		}

	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {

	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
		programPage.searchText(invalidProgramName);
	}

	@When("Admin clicks on Arrow next to {string}")
	public void admin_clicks_on_arrow_next_to(String columnName) {
		//String option = programColumns.toLowerCase();
		switch (columnName) {
		case "Program Name":
			originalList= programPage.clickSortIcon(2,columnName);;
			break;
		case "Program Description":
			originalList= programPage.clickSortIcon(3,columnName);
			break;
		case "Program Status" :
			originalList= programPage.clickSortIcon(4,columnName);
			break;
		}
		for(String str:originalList)
		{
			System.out.println("originalList for " +columnName+ " : " +str);
		}

	}

	@Then("Admin See the {string} is sorted in Ascending order\\/Descending order")
	public void admin_see_the_is_sorted_in_ascending_order_descending_order(String columnName) {
		sortedList = programPage.getSortedList();
		for(String str:sortedList)
		{
			System.out.println("sortedList" +str);
		}
		Assert.assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks {string} link on the program table")
	public void admin_clicks_link_on_the_program_table(String page) {
		switch(page) {
		case "Next page":
			programPage.goToNextPage();
			break;
		case "Last page":
			programPage.goToLastPage();
			break;
		case "Previous page":
			programPage.goToPreviousPage();
			break;
		case "First page":
			programPage.goToFirstPage();
			break;
		}
	}

	@Then("Admin should see the Pagination has Next active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
		Assert.assertEquals(programPage.isNextPageActive(), true);
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
		Assert.assertEquals(programPage.isNextPageActive(), false);
	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() {
		programPage.goToLastPage();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
		//Assert.assertEquals(programPage.ispreviousPageActive(), true);
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		Assert.assertEquals(!programPage.ispreviousPageActive(), true);
	}

}
