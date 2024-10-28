package lms.ui.hackathon.stepDefinitions;

import java.util.Random;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lms.ui.hackathon.pageobjects.BatchDetailsPage;
import lms.ui.hackathon.pageobjects.BatchPage;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.utilities.TestContextSetUp;

public class BatchSteps {
	public BatchPage batchPage;
	public DashboardPage dashboardPage;
	TestContextSetUp testContextSetup;
	BatchDetailsPage batchDetailsPage;

	
	
	public BatchSteps(TestContextSetUp testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.batchPage=testContextSetup.pageObjManager.getBatchPage();
		dashboardPage = testContextSetup.pageObjManager.getDashboardPage();
		//batchDetailsPage=testContextSetup.pageObjManager.getBatchDetailsPage();

	}
	
	@Given("Admin is on Dashboard page")
	public void admin_is_on_dashboard_page() {
		
		try {
			batchPage.login();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Given("Admin Clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		
		try {
			batchPage.goToMenu("batch");

			Thread.sleep(2000);
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
		
		Assert.assertTrue(batchPage.IspaginationActive());  
		  
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
		
		Assert.assertTrue(batchPage.verifyBatchSortIcon());
	}

	@When("Admin clicks {string} on the navigation bar of batch menu")
	public void admin_clicks_on_the_navigation_bar_of_batch_menu(String batch) {
		try {
			batchPage.goToMenu(batch);
			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}



	@Then("the Batch page should display the sub-menu options")
	public void the_batch_page_should_display_the_sub_menu_options() {
 
		try {
		    Assert.assertEquals(batchPage.getBatchSubMenu(), "Sub-menu options are not displayed on the Batch page.");
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("User click on the Add New Batch option")
	public void user_click_on_the_add_new_batch_option() {
	
		try {
			batchPage.AddNewBatch();
			Thread.sleep(2000);


		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("User should see the Batch details pop-up")
	public void user_should_see_the_batch_details_pop_up() {

		try {
			Assert.assertTrue(batchPage.IsBatchDetailsPopupPageDisplayed());

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Given("User on the Add New Batch pop-up to validate all the fields exist")
	public void user_on_the_add_new_batch_pop_up_to_validate_all_the_fields_exist() {
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    @Then("all fields should be visible in batch details pop message")
    public void all_fields_should_be_visible_in_batch_details_pop_message() {


    	Assert.assertTrue(batchDetailsPage.ValidateAddBtachFields());
	}

    @Given("User is on the Add New Batch pop-up to validate batch name prefix")
    public void user_is_on_the_add_new_batch_pop_up_to_validate_batch_name_prefix() {
    	try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User selects program name as {string}")
	public void user_selects_program_name_as(String programName) {
		
		batchDetailsPage.selectProgramName(programName.trim());
		
	}

	@Then("the batch name prefix should match the selected program name {string}")
	public void the_batch_name_prefix_should_match_the_selected_program_name(String programName) {
	 	

		 Assert.assertEquals(batchDetailsPage.getBatchProgramNameText(), programName);
	    
	}


	@Given("User is on the Batch Details pop-up window")
	public void user_is_on_the_batch_details_pop_up_window() {
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String batchName, String batchCode) {
	   

		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		
	}

	@Then("User should get error message after entering alphabets in suffix box")
	public void user_should_get_error_message_after_entering_alphabets_in_suffix_box() {
		
		String actualError = batchDetailsPage.getbatchCodeErrorMessage();
        String expectedError = "This field accept only numbers and max 5 count."; 
        Assert.assertEquals("Error message did not match",expectedError, actualError); 
	  
	}
	
	@Given("User on the Add New Batch pop-up to validate not editable")
	public void user_on_the_add_new_batch_pop_up_to_validate_not_editable(){

		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("the batch name prefix field should be non-editable")
	public void the_batch_name_prefix_field_should_be_non_editable() {

	    Assert.assertFalse(batchDetailsPage.isBatchNamePrefixEditable(), "Batch name prefix field is editable, but it should be non-editable.");

	}


	@Given("User is on the Add New Batch pop-up to Validate mandatory fields")
	public void user_is_on_the_add_new_batch_pop_up_to_validate_mandatory_fields()  {
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(batchDetailsPage.AddBatchTitleDisplayed());
	    
	}

	@When("User inputs {string}, {string}, {string}, {string}, and {string}")
	public void user_inputs_and(String batchName, String batchCode, String description, String status, String noOfClasses) {
		
		Random random = new Random();
		
		//String batchNameTestData = batchName + // Generate a random character between 'a' and 'z'
		       // char randomChar = (char) (random.nextInt(26) + 'a'); 

		        //System.out.println("Random character: " + randomChar());
		
		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		batchDetailsPage.enterBatchDescription(description);
		batchDetailsPage.selectStatus(status);
		batchDetailsPage.enterNoOfClasses(noOfClasses);
	}
	
	@Then("User should be able to save successfully")
	public void user_should_be_able_to_save_successfully() throws InterruptedException {
		
		String batchName = batchDetailsPage.getBatchProgramNameText();
		System.out.println("admin_can_see_the_text_entered " + batchName);

		Assert.assertEquals(batchName != null, true);

        
	}
 
	@Given("User is on the Add New Batch pop-up to check missing mandatory fields")
	public void user_is_on_the_add_new_batch_pop_up_to_check_missing_mandatory_fields() {
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//(String batchName, String batchCode, String batchDesc, String status, String noOfClasses)

	@When("User leaves \"Batchname\"empty for {string}, {string}, {string}, {string},{string}")
	public void user_leaves_batchname_empty_for(String batchName, String batchCode, String batchDesc, String status, String noOfClasses) {
		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		batchDetailsPage.enterBatchDescription(batchDesc);
		batchDetailsPage.selectStatus(status);
		batchDetailsPage.enterNoOfClasses(noOfClasses);
	}


	@When("User leaves \"BatchCode\"empty for {string}, {string}, {string}, {string},{string}")
	public void user_leaves_batch_code_empty_for(String batchName, String batchCode, String batchDesc, String status, String noOfClasses) {
		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		batchDetailsPage.enterBatchDescription(batchDesc);
		batchDetailsPage.selectStatus(status);
		batchDetailsPage.enterNoOfClasses(noOfClasses);
	}

	@When("User leaves \"BatchDescription\"empty for {string}, {string}, {string}, {string},{string}")
	public void user_leaves_batch_description_empty_for(String batchName, String batchCode, String batchDesc, String status, String noOfClasses) {
		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		batchDetailsPage.enterBatchDescription(batchDesc);
		batchDetailsPage.selectStatus(status);
		batchDetailsPage.enterNoOfClasses(noOfClasses);
	}

	@When("User leaves \"Status\"empty for {string}, {string}, {string}, {string},{string}")
	public void user_leaves_status_empty_for(String batchName, String batchCode, String batchDesc, String status, String noOfClasses) {
		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		batchDetailsPage.enterBatchDescription(batchDesc);
		batchDetailsPage.selectStatus(status);
		batchDetailsPage.enterNoOfClasses(noOfClasses);
	}

	@When("User leaves \"NoOfClasses\"empty for {string}, {string}, {string}, {string},{string}")
	public void user_leaves_no_of_classes_empty_for(String batchName, String batchCode, String batchDesc, String status, String noOfClasses) {
		batchDetailsPage.enterBatchName(batchName);
		batchDetailsPage.enterBatchCode(batchCode);
		batchDetailsPage.enterBatchDescription(batchDesc);
		batchDetailsPage.selectStatus(status);
		batchDetailsPage.enterNoOfClasses(noOfClasses);
	}


	@Then("User should see a validation error message for {string} as {string}")
	public void user_should_see_a_validation_error_message_for_as(String missingFields, String errMsg) {
		
		Assert.assertEquals(batchDetailsPage.VerifyEmptyBatchfields(missingFields),errMsg);
	}

	@Given("User on the Add New Batch pop-up to Validate Save button")
	public void user_on_the_add_new_batch_pop_up_to_validate_save_button() {

		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("the Save button should be enabled when all mandatory fields are filled")
	public void the_save_button_should_be_enabled_when_all_mandatory_fields_are_filled() {
		
	    batchDetailsPage.clickSaveButton();
	    Assert.assertTrue(batchDetailsPage.isBatchCreatedSuccessfully());
	    
	}

	@Given("User on the Add New Batch pop-up to Validate Cancel button")
	public void user_on_the_add_new_batch_pop_up_to_validate_cancel_button() {

		batchPage.AddNewBatch();

	}

	@When("User click on the Cancel button")
	public void user_click_on_the_cancel_button() {

		batchDetailsPage.clickCancelButton();
	}

	@Then("the pop-up should close without saving cancel button")
	public void the_pop_up_should_close_without_saving_cancel_button() {

	    Assert.assertFalse(batchDetailsPage.isPopupClosedCancel(), "The pop-up did not close as expected.");
	}

	@Given("User on the Add New Batch pop-up to Validate close icon")
	public void user_on_the_add_new_batch_pop_up_to_validate_close_icon() {
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("User click on the close icon")
	public void user_click_on_the_close_icon() {
		try {
			batchDetailsPage.clickClosebatchButton();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("the pop-up should close without saving close icon")
	public void the_pop_up_should_close_without_saving_close_icon() {

	    Assert.assertFalse(batchDetailsPage.isPopupClosedClose(), "The pop-up did not close as expected.");

	}

	@Given("User on the Batch page to Validate Edit icon feature")
	public void user_on_the_batch_page_to_validate_edit_icon_feature() {

		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("User click on the Edit icon for a row")
	public void user_click_on_the_edit_icon_for_a_row() {

		batchDetailsPage.clickEditIconButton();
	}

	@Then("User should be able to edit the batch details")
	public void user_should_be_able_to_edit_the_batch_details() {

	    Assert.assertTrue(batchDetailsPage.isPopupEditDisplayed());

	}

	@Given("User editing a batch to Validate Program Name value")
	public void user_editing_a_batch_to_validate_program_name_value() {


	}

	@Then("the Program Name field should be disabled")
	public void the_program_name_field_should_be_disabled() {

        Assert.assertEquals("Program Name field is editable, but it should be disabled", batchDetailsPage.isProgramNameFieldDisabled());

	}

	@Given("User editing a batch to Validate Batch Name value")
	public void user_editing_a_batch_to_validate_batch_name_value() {
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Then("the Batch Name field should be disabled")
	public void the_batch_name_field_should_be_disabled() {

	    Assert.assertEquals("Batch Name field is editable, but it should be disabled", batchDetailsPage.isBatchNameFieldDisabled());

	}

	@Given("User editing a batch to Validate editing description")
	public void user_editing_a_batch_to_validate_editing_description() {
		
		try {
			batchPage.AddNewBatch();

			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	@When("User input invalid data in the description and No. of classes fields")
	public void user_input_invalid_data_in_the_description_and_no_of_classes_fields() {

	    batchDetailsPage.enterBatchDescription("1234");  
	    batchDetailsPage.enterNoOfClasses("-10");        
	    
	    batchDetailsPage.clickSaveButton();
	    
	}
	

	@Then("User should see validation error messages")
	public void user_should_see_validation_error_messages() {

		   String descriptionError = batchDetailsPage.getBatchEditDescriptionError();
		    String noOfClassesError = batchDetailsPage.getEditNoOfClassesError();
		    
		    Assert.assertEquals("Invalid description input", descriptionError);
		    Assert.assertEquals("Number of classes must be a positive number", noOfClassesError);
	}

	@Given("User editing a batch to Validate Save button")
	public void user_editing_a_batch_to_validate_save_button() {

		batchPage.AddNewBatch();

	}

	@When("User fill in valid data")
	public void user_fill_in_valid_data() {

		try {
		    batchDetailsPage.clickSaveButton();

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Then("the Save button should be enabled")
	public void the_save_button_should_be_enabled() {


	    batchDetailsPage.clickSaveButton();
	    Assert.assertTrue(batchDetailsPage.isBatchEditSuccessfully());
	}

	@Given("User editing a batch to Validate Cancel button")
	public void user_editing_a_batch_to_validate_cancel_button() {

		batchPage.AddNewBatch();

	}

	@When("User click on the Cancel button after editing")
	public void user_click_on_the_cancel_button_after_editing() {

		batchDetailsPage.clickCancelButton();

	}

	@Then("the changes should not be saved")
	public void the_changes_should_not_be_saved() {

	    Assert.assertFalse(batchDetailsPage.isPopupClosedCancel(), " batch details popup closes without editing the batch");

	}



}

