package lms.ui.hackathon.stepDefinitions;

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
		//programPage.programTabClick();
		programPage.goToMenu("Program");
	   
	}

	@When("Admin clicks on delete button for a program")
	public void admin_clicks_on_delete_button_for_a_program() {
	    programPage.clickAnyDelete();
	}

	@Then("Admin will get confirm deletion popup")
	public void validate_confirm_deletion_popup() {
	    programPage.validatePopup();
	}

	@When("Admin clicks on {string} button")
	public void admin_clicks_on_button(String string) {
	    
	}

	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
	   
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String string) {
	   
	}

	@Then("There should be zero results")
	public void there_should_be_zero_results() {
	   
	}

	@Given("Admin is on Confirm deletion form")
	public void admin_is_on_confirm_deletion_form() {
	    
	}

	@Then("Admin can see Confirmation form disappears and lands on program page")
	public void admin_can_see_confirmation_form_disappears_and_lands_on_program_page() {
	    
	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() {
	  
	}

	@Then("Programs get selected")
	public void programs_get_selected() {
	   
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
	   
	}

	@Then("Admin lands on Confirmation form")
	public void admin_lands_on_confirmation_form() {
	   
	}

	@Given("Admin is on Confirmation form")
	public void admin_is_on_confirmation_form() {
	    
	}

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
	    
	}

	@When("Admin enter the program to search By {string}")
	public void admin_enter_the_program_to_search_by(String string) {
	   
	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	   
	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
	    
	}

	@When("Admin clicks on Arrow next to column Name")
	public void admin_clicks_on_arrow_next_to_column_name(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Admin See the Column Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_column_name_is_sorted_in_ascending_order_descending_order(io.cucumber.datatable.DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	    throw new io.cucumber.java.PendingException();
	}

	@When("Admin clicks {string} link on the program table")
	public void admin_clicks_link_on_the_program_table(String string) {
	   
	}

	@Then("Admin should see the Pagination has Next active link")
	public void admin_should_see_the_pagination_has_next_active_link() {
	    
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	   
	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() {
	   
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
	   
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
	   
	}


}
