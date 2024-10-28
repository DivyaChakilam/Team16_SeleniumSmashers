package lms.ui.hackathon.stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.configs.CommonConfigs;
import lms.ui.hackathon.pageobjects.ClassPage;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.ProgramDetailsPage;
import lms.ui.hackathon.pageobjects.ProgramPage;
import lms.ui.hackathon.utilities.TestContextSetUp;
import numpy.seleniumsmasher.lms.factory.DriverFactory;

public class ProgramSteps {
	TestContextSetUp testContextSetUp;
	public DashboardPage dashboardPage;
	public ProgramPage programPage;
	public ProgramDetailsPage programDetailsPage;
	String programNameDeleted = "";
	String invalidProgramName = "ljf5@1";
	String programName = "piechart";
	String programDescription = "SDET";
	String ProgramPartialName = "pie";
	List<String> originalList = new ArrayList<String>();
	List<String> sortedList = new ArrayList<String>();
	String editedName="";


	public ProgramSteps(TestContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
		this.programPage = testContextSetUp.pageObjManager.getProgramPage();
		this.dashboardPage = testContextSetUp.pageObjManager.getDashboardPage();
		this.programDetailsPage = testContextSetUp.pageObjManager.getProgramDetailsPage();
	}

	@Given("Admin is on the dashboard page after login")
	public void admin_login() {

		programPage.login(); // --> should be coming from Madhuvi's Login Page

	}

	@When("Admin clicks Program on the navigation bar")
	public void admin_clicks_on_program() throws Exception {
		programPage.clickProgram();
		// programPage.goToMenu("Program");

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
			// programPage.clickYes();
			break;
		case "no":
			programPage.clickNo();
			break;
		case "x":
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
		// org.testng.Assert.assertEquals(programPage.verifyPopupIsAppeared(), true);

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
		case "PartialProgName":
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
		// String option = programColumns.toLowerCase();
		switch (columnName) {
		case "Program Name":
			originalList = programPage.clickSortIcon(2, columnName);
			;
			break;
		case "Program Description":
			originalList = programPage.clickSortIcon(3, columnName);
			break;
		case "Program Status":
			originalList = programPage.clickSortIcon(4, columnName);
			break;
		}
		for (String str : originalList) {
			System.out.println("originalList for " + columnName + " : " + str);
		}

	}

	@Then("Admin See the {string} is sorted in Ascending order\\/Descending order")
	public void admin_see_the_is_sorted_in_ascending_order_descending_order(String columnName) {
		sortedList = programPage.getSortedList();
		for (String str : sortedList) {
			System.out.println("sortedList" + str);
		}
		Assert.assertTrue(originalList.equals(sortedList));
	}

	@When("Admin clicks {string} link on the program table")
	public void admin_clicks_link_on_the_program_table(String page) {
		switch (page) {
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
		// Assert.assertEquals(programPage.ispreviousPageActive(), true);
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
		Assert.assertEquals(!programPage.ispreviousPageActive(), true);
	}

	@When("Admin clicks Program {string} on the navigation bar")
	public void admin_clicks_Program_on_the_navigation_bar(String menuName) throws Exception {
		System.out.println("Admins Clicks " + menuName);
		programPage = (ProgramPage) dashboardPage.goToMenu(menuName);
	}

	@Then("Admin should be navigated to Program module")
	public void admin_should_be_navigated_to_program_module() {
		boolean inPorgramPage = programPage.isInProgramPage();
		Assert.assertEquals(inPorgramPage, true);

	}

	@Then("Admin should not have any broken links for Program module")
	public void admin_should_not_have_any_broken_links_for_program_module() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see the heading {string}")
	public void admin_should_see_the_heading(String string) {
		// boolean isLMSHeader= programPage.isLMSHeader();
		boolean isLMSHeader = programPage.LMSHeaderExists();

		Assert.assertEquals(isLMSHeader, true);
	}

	@Then("Admin should see the module names as in order {string}")
	public void admin_should_see_the_module_names_as_in_order(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see Logout in menu bar")
	public void admin_should_see_logout_in_menu_bar() {
		boolean isLogout = programPage.isLogout();
		Assert.assertEquals(isLogout, true);
	}

	@Given("Admin is on program page")
	public void admin_is_on_program_page() throws Exception {
		programPage.goToMenu("Program");
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String string) {
		boolean isAddnewprogram = programPage.isAddnewprogram();
		Assert.assertEquals(isAddnewprogram, true);
	}

	@Then("Admin should able to see Program name, description, and status for each program")
	public void admin_should_able_to_see_program_name_description_and_status_for_each_program() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see a Delete button in left top is disabled")
	public void admin_should_see_a_delete_button_in_left_top_is_disabled() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
		boolean searchbar = programPage.verifySearchbar();
		Assert.assertEquals(searchbar, true);
	}

	@Then("Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit\\/Delete")
	public void admin_should_see_data_table_with_column_header_on_the_manage_program_page_as_program_name_program_description_program_status_edit_delete() {
		boolean verifyheader = programPage.verifyProgramHeader();
		Assert.assertEquals(verifyheader, true);
	}

	@Then("Admin should see checkbox default state as unchecked beside Program Name column header as")
	public void admin_should_see_checkbox_default_state_as_unchecked_beside_program_name_column_header_as() {
		boolean checkbox = programPage.verifyCheckbox();
		Assert.assertEquals(checkbox, false);
	}

	@Then("Admin should see check box default state as unchecked on the left side in all rows against program name")
	public void admin_should_see_check_box_default_state_as_unchecked_on_the_left_side_in_all_rows_against_program_name() {
		boolean vpcb = programPage.verifyProgramCheckboxes();
		Assert.assertEquals(vpcb, false);

	}

	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
		boolean sorticon = programPage.verifyProgramSortIcon();
		Assert.assertEquals(sorticon, true);
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {

	}

	@Given("Admin is on Program module")
	public void admin_is_on_program_module() throws Exception {
		// DriverFactory.getDriver().get(CommonConfigs.getUrl());
		programPage.login();
		// dashboardPage = new DashboardPage(DriverFactory.getDriver());
		programPage = (ProgramPage) dashboardPage.goToMenu("Program");

		// Assert.assertTrue(programPage.isInProgramPage());
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String string, String string2) {

		programDetailsPage = programPage.goToAddNewProgramPage();
	}

	@Then("Admin should see pop up window for program details")
	public void admin_should_see_pop_up_window_for_program_details() {

		Assert.assertTrue(programDetailsPage.isProgramDetailsTitleExists());
	}

	@Then("Admin should see window title as {string}")
	public void admin_should_see_window_title_as(String string) {
		String title = programDetailsPage.getProgramDetailsTitle();
		System.out.println("title is " + title);
		Assert.assertEquals(string, title);
	}

	@Then("Admin should see red {string} mark beside mandatory field {string}")
	public void admin_should_see_red_mark_beside_mandatory_field(String string, String string2) {
		String nameMandatoryText = programDetailsPage.ProgramDetailsNameMandatoryText();
		System.out.println("nameMandatoryText is " + nameMandatoryText);
		Assert.assertEquals(string, nameMandatoryText);
	}

	@Given("Admin is on Program details form")
	public void admin_is_on_program_details_form() throws Exception {
		/*programPage.login();*/
		programPage = (ProgramPage) dashboardPage.goToMenu("Program");
		programDetailsPage = programPage.goToAddNewProgramPage();
	}

	@When("Admin clicks save button without entering mandatory")
	public void admin_clicks_save_button_without_entering_mandatory() {

		programDetailsPage.clickProgramDetailsSave();
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {

		boolean isRequried = programDetailsPage.verifyRequiredFields();
		Assert.assertEquals(isRequried, true);
	}

	@When("Admin clicks Cancel button")
	public void admin_clicks_cancel_button() {

		programDetailsPage.clickProgramDetailsCancel();
	}

	@Then("Admin can see Program Details form disappears")
	public void admin_can_see_program_details_form_disappears() {

		boolean inPorgramPage = programPage.isInProgramPage();
		Assert.assertEquals(inPorgramPage, true);
	}

	@When("Admin enters the Name {string} in the text box")
	public void admin_enters_the_in_the_text_box(String value) {
		System.out.println("string is " + value);
		programDetailsPage.SendKeys("Name", value);
	}

	@Then("Admin can see the text entered")
	public void admin_can_see_the_text_entered() {
		String name = programDetailsPage.getProgramNameText();
		System.out.println("admin_can_see_the_text_entered " + name);

		Assert.assertEquals(name != null, true);
	}

	@When("Admin enters the Description {string} in text box")
	public void admin_enters_the_description_in_text_box(String value) {
		programDetailsPage.SendKeys("Description", value);
	}

	@Then("Admin can see the text entered in description box")
	public void admin_can_see_the_text_entered_in_description_box() {

		String description = programDetailsPage.getProgramDescriptionText();
		Assert.assertEquals(description != null, true);
	}

	@When("Admin selects the status of the program by clicking on the radio {string} button {string}")
	public void admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button(String option, String string2) {
		System.out.println("admin_selects_the_status_of_the_program_by_clicking_on_the_radio_button " + option);
		programDetailsPage.SendKeys(option, "");
	}

	@Then("Admin can see {string} status selected")
	public void admin_can_see_status_selected(String option) {
		System.out.println("admin_can_see_the_text_entered-option " + option);
		if (option.equals("Active")) {
			String name = programDetailsPage.getProgramActiveText();
			System.out.println("admin_can_see_the_text_entered " + name);

			Assert.assertEquals(name != null, true);
		} else {
			String name = programDetailsPage.getProgramInActiveText();
			System.out.println("admin_can_see_the_text_entered1 " + name);

			Assert.assertEquals(name != null, true);

		}
	}

	@When("Admin enter valid details for mandatory fields {string} {string} {string} and Click on save button")
	public void admin_enter_valid_details_for_mandatory_fields_and_click_on_save_button(String name, String description, String option) {
		System.out.println("name " + name +",description "+description +",option "+option);
		programDetailsPage.ProgramSave(name,description,option);
	}
	@Then("Admin gets message Successful Program created")
	public void admin_gets_message_successful_program_created() {
		boolean isSuccess = programDetailsPage.isProgramCreatedSuccessfully();
		Assert.assertEquals(isSuccess, true);
	}

	@When("Admin Clicks on cancel button")
	public void admin_clicks_on_cancel_button() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Admin can see program details form disappear")
	public void admin_can_see_program_details_form_disappear() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Admin searches with newly created {string}")
	public void admin_searches_with_newly_created(String text) {
		programPage.searchText(text);
	}

	@Then("Records of the newly created  {string} is displayed and match the data entered")
	public void records_of_the_newly_created_is_displayed_and_match_the_data_entered(String string) {
		
	}

	@When("Admin Click on {string} button")
	public void admin_click_on_button(String string) {
		
	}
	@When("Admin clicks on Edit option for particular program")
	public void admin_clicks_on_edit_option_for_particular_program() {
		programPage.editFirstProgram();
	}

	@Then("Admin lands on Program details form")
	public void admin_lands_on_program_details_form() {
		
		String title = programDetailsPage.getProgramDetailsTitle();
		System.out.println("title is " + title);
		Assert.assertEquals(title, "Program Details");
	}

	@When("Admin edits the program name and click on save button")
	public void admin_edits_the_program_name_and_click_on_save_button() {
		programPage.editFirstProgram();
		editedName= programDetailsPage.editName();
		programDetailsPage.clickProgramDetailsSave();
		
	}

	@Then("Updated program name is seen by the Admin")
	public void updated_program_name_is_seen_by_the_admin() {
		boolean isSuccess = programDetailsPage.isProgramEditedSuccessfully();
		Assert.assertEquals(isSuccess, true);
	}

	@When("Admin edits the description text and click on save button")
	public void admin_edits_the_description_text_and_click_on_save_button() {
		programPage.editFirstProgram();
		programDetailsPage.editDescription();
		programDetailsPage.clickProgramDetailsSave();
	}

	@Then("Admin can see the description is updated")
	public void admin_can_see_the_description_is_updated() {
		boolean isSuccess = programDetailsPage.isProgramEditedSuccessfully();
		Assert.assertEquals(isSuccess, true);
	}

	@When("Admin can change the status of the program and click on save button")
	public void admin_can_change_the_status_of_the_program_and_click_on_save_button() {
		programPage.editFirstProgram();
		programDetailsPage.ToggleStatus();
		programDetailsPage.clickProgramDetailsSave();
	}

	@Then("Status updated can be viewed by the Admin")
	public void status_updated_can_be_viewed_by_the_admin() {
		boolean isSuccess = programDetailsPage.isProgramEditedSuccessfully();
		Assert.assertEquals(isSuccess, true);
	}

	@When("Admin click on save button")
	public void admin_click_on_save_button() {
		programPage.editFirstProgram();
		programDetailsPage.clickProgramDetailsSave();
	}

	@Then("Admin can see the updated program details")
	public void admin_can_see_the_updated_program_details() {
		boolean isSuccess = programDetailsPage.isProgramEditedSuccessfully();
		Assert.assertEquals(isSuccess, true);
	}
	@When("Admin clicks Cancel button on a Program")
	public void admin_clicks_cancel_button_on_a_program() {
		programPage.editFirstProgram();
		programDetailsPage.clickProgramDetailsCancel();
	}
	

	@When("Admin searches with newly updated {string}")
	public void admin_searches_with_newly_updated(String string) {
		programPage.editFirstProgram();
		editedName= programDetailsPage.editName();
		programDetailsPage.clickProgramDetailsSave();
	    System.out.println("editedName ->"+editedName);
	    programPage.searchText(editedName);
	}

	@Then("Admin verifies that the details are correctly updated.")
	public void admin_verifies_that_the_details_are_correctly_updated() {
		boolean result = programPage.verifySearchResult();
		Assert.assertEquals(result, true);
	    
	}


}
