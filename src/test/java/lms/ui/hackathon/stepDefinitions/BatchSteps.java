package lms.ui.hackathon.stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.pageobjects.BatchPage;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class BatchSteps {
	public BatchPage batchPage;
	public DashboardPage dashboardPage;
	TestContextSetUp testContextSetup;
	
	
	public BatchSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.batchPage=testContextSetup.pageObjManager.getBatchPage();
		dashboardPage = testContextSetup.pageObjManager.getDashboardPage();

	}
	
	@Given("Admin is on Dashboard page")
	public void admin_is_on_dashboard_page() {
		
		batchPage.login();

	}

	@Given("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		
		try {
			batchPage.goToMenu("batch");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Then("Admin should see the Batch page title as {string}")
	public void admin_should_see_the_batch_page_title_as(String string) {
		
		Assert.assertTrue(batchPage.LMSHeaderExists());

	}

	@Then("the page title should be {string}")
	public void the_page_title_should_be(String string) {
		
		Assert.assertTrue(batchPage.LMSHeaderExists());

	}

	@Then("the page heading should be {string}")
	public void the_page_heading_should_be(String string) {
		
		Assert.assertTrue(batchPage.BatchHeaderExists());

	}

	@Then("the Delete Icon under the header should be disabled")
	public void the_delete_icon_under_the_header_should_be_disabled() {
		
		Assert.assertTrue(batchPage.IsDisabledDeleteIcon());

	}

	@Then("pagination should be visible and functional")
	public void pagination_should_be_visible_and_functional() {
		
		   String actualText = batchPage.pagination();  // Get actual pagination text
		    System.out.println("Actual Pagination Text: " + actualText); 

		    String expectedPattern = "^Showing \\d+ to \\d+ of \\d+ entries$";
		    //boolean isMatch = actualText.matches(expectedPattern);

		    Assert.assertTrue(actualText.matches(expectedPattern),
		            "Pagination text format mismatch: " + actualText);

		    //Assert.assertEquals("Pagination text format mismatch: " +actualText, "true", String.valueOf(isMatch));

		}
	

	@Then("each data row should have an edit icon")
	public void each_data_row_should_have_an_edit_icon() {
		
		Assert.assertTrue(batchPage.IsEditIconsDisplayed());

	}

	@Then("each data row should have a delete icon")
	public void each_data_row_should_have_a_delete_icon() {
		
		Assert.assertTrue(batchPage.IsDeleteIconDisplayed());

	}

	@Then("each data row should have a checkbox")
	public void each_data_row_should_have_a_checkbox() {

		Assert.assertTrue(batchPage.ischeckBoxDisplayedForEachRow());
		Assert.assertTrue(batchPage.IscheckBoxRowsDisplayed());
		
	}

	@Given("User on the Batch page to validate Datatable head")
	public void user_on_the_batch_page_to_validate_datatable_head() {


	}

	@Then("the Datatable should have the correct headers:")
	public void the_datatable_should_have_the_correct_headers(io.cucumber.datatable.DataTable dataTable) {

		Assert.assertTrue(batchPage.IsdataTableHeaderDisplayed());

	}

	@Then("the Datatable header row should have a checkbox")
	public void the_datatable_header_row_should_have_a_checkbox() {
		
		Assert.assertTrue(batchPage.IsdataTableCheckBoxDisplayed());

	}

	@Then("each Datatable header should have a sort icon")
	public void each_datatable_header_should_have_a_sort_icon() {
		
		Assert.assertTrue(batchPage.isSortIconForEachRow());
	}

//	@When("Admin clicks {string} on the navigation bar")
//	public void admin_clicks_on_the_navigation_bar(String string) {
//	    
//	}

	@Then("the Batch page should display the sub-menu options")
	public void the_batch_page_should_display_the_sub_menu_options() {


	}

	@When("User click on the {string} option")
	public void user_click_on_the_option(String string) {


	}

	@Then("User should see the Batch details pop-up")
	public void user_should_see_the_batch_details_pop_up() {


	}

	@Given("User on the {string} pop-up to validate all the fields exist")
	public void user_on_the_pop_up_to_validate_all_the_fields_exist(String string) {


	}

	@Then("all fields should be visible:")
	public void all_fields_should_be_visible(io.cucumber.datatable.DataTable dataTable) {

	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.

	}

	@Given("User on the {string} pop-up to Validate batch name prefix")
	public void user_on_the_pop_up_to_validate_batch_name_prefix(String string) {


	}

	@Then("the batch name prefix should match the selected program name")
	public void the_batch_name_prefix_should_match_the_selected_program_name() {


	}

	@Given("User on the {string} pop-up to Validate batch name suffix")
	public void user_on_the_pop_up_to_validate_batch_name_suffix(String string) {


	}

	@Then("the batch name suffix field should accept only numeric input")
	public void the_batch_name_suffix_field_should_accept_only_numeric_input() {


	}

	@Given("User on the {string} pop-up to validate not editable")
	public void user_on_the_pop_up_to_validate_not_editable(String string) {


	}

	@Then("the batch name prefix field should be non-editable")
	public void the_batch_name_prefix_field_should_be_non_editable() {


	}

	@Given("User on the {string} pop-up to Validate mandatory fields")
	public void user_on_the_pop_up_to_validate_mandatory_fields(String string) {


	}

	@When("User input data for mandatory fields")
	public void user_input_data_for_mandatory_fields() {


	}

	@Then("User should be able to save successfully")
	public void user_should_be_able_to_save_successfully() {


	}

	@Given("User on the {string} pop-up")
	public void user_on_the_pop_up(String string) {


	}

	@When("User leave mandatory fields empty")
	public void user_leave_mandatory_fields_empty() {


	}

	@Then("User should see a validation error message")
	public void user_should_see_a_validation_error_message() {


	}

	@Given("User on the {string} pop-up to Validate Save button")
	public void user_on_the_pop_up_to_validate_save_button(String string) {


	}

	@Then("the Save button should be enabled when all mandatory fields are filled")
	public void the_save_button_should_be_enabled_when_all_mandatory_fields_are_filled() {


	}

	@Given("User on the {string} pop-up to Validate Cancel button")
	public void user_on_the_pop_up_to_validate_cancel_button(String string) {


	}

	@When("User click on the Cancel button")
	public void user_click_on_the_cancel_button() {


	}

	@Then("the pop-up should close without saving cancel button")
	public void the_pop_up_should_close_without_saving_cancel_button() {


	}

	@Given("User on the {string} pop-up to Validate close icon")
	public void user_on_the_pop_up_to_validate_close_icon(String string) {


	}

	@When("User click on the close icon")
	public void user_click_on_the_close_icon() {


	}

	@Then("the pop-up should close without saving close icon")
	public void the_pop_up_should_close_without_saving_close_icon() {


	}

	@Given("User on the Batch page to Validate Edit icon feature")
	public void user_on_the_batch_page_to_validate_edit_icon_feature() {


	}

	@When("User click on the Edit icon for a row")
	public void user_click_on_the_edit_icon_for_a_row() {


	}

	@Then("User should be able to edit the batch details")
	public void user_should_be_able_to_edit_the_batch_details() {


	}

	@Given("User editing a batch to Validate Program Name value")
	public void user_editing_a_batch_to_validate_program_name_value() {


	}

	@Then("the Program Name field should be disabled")
	public void the_program_name_field_should_be_disabled() {


	}

	@Given("User editing a batch to Validate Batch Name value")
	public void user_editing_a_batch_to_validate_batch_name_value() {


	}

	@Then("the Batch Name field should be disabled")
	public void the_batch_name_field_should_be_disabled() {


	}

	@Given("User editing a batch to Validate editing description")
	public void user_editing_a_batch_to_validate_editing_description() {


	}

	@When("User input invalid data in the description and No. of classes fields")
	public void user_input_invalid_data_in_the_description_and_no_of_classes_fields() {


	}

	@Then("User should see validation error messages")
	public void user_should_see_validation_error_messages() {


	}

	@Given("User editing a batch to Validate Save button")
	public void user_editing_a_batch_to_validate_save_button() {


	}

	@When("User fill in valid data")
	public void user_fill_in_valid_data() {


	}

	@Then("the Save button should be enabled")
	public void the_save_button_should_be_enabled() {


	}

	@Given("User editing a batch to Validate Cancel button")
	public void user_editing_a_batch_to_validate_cancel_button() {


	}

	@When("User click on the Cancel button after editing")
	public void user_click_on_the_cancel_button_after_editing() {


	}

	@Then("the changes should not be saved")
	public void the_changes_should_not_be_saved() {


	}



}

