package lms.ui.hackathon.stepDefinitions;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lms.ui.hackathon.pageobjects.BatchPage;
import lms.ui.hackathon.pageobjects.DashboardPage;
import lms.ui.hackathon.pageobjects.ProgramDetailsPage;
import lms.ui.hackathon.pageobjects.ProgramPage;
import lms.ui.hackathon.utilities.TestContextSetUp;


public class DeleteBatchSteps {
	
    public TestContextSetUp testContextSetUp;
    public DashboardPage dashboardPage;
    public ProgramPage programPage;
    public ProgramDetailsPage programDetailsPage;
    public BatchPage batchPage;
    String programNameDeleted = "";
    String invalidProgramName = "ljf5@1";
    String programName = "piechart";
    String programDescription = "SDET";
    String ProgramPartialName = "pie";
    List<String> originalList = new ArrayList<String>();
    List<String> sortedList = new ArrayList<String>();
    List<String> selectedProgramList = new ArrayList<String>();
    String editedName="";

    public DeleteBatchSteps(TestContextSetUp testContextSetup) {
    	this.testContextSetUp = testContextSetup;
		dashboardPage = testContextSetup.pageObjManager.getDashboardPage();

    }


        @Given("The delete icon on row level in data table is enabled")
        public void the_delete_icon_on_row_level_in_data_table_is_enabled() {
        	batchPage.deleteenable();

        }


        @Then("Admin should see the confirm alert box with yes and no button")
        public void admin_should_see_the_confirm_alert_box_with_yes_and_no_button() {
            batchPage.alertwindow();

        }


        @Then("The admin should see the successfull message confirming that the batch has been deleted")
        public void the_admin_should_see_the_successfull_message_confirming_that_the_batch_has_been_deleted() {
            batchPage.clickdelete();


        }

        @Then("The admin needs to see that the alert box is closed and that batch is still present")
        public void the_admin_needs_to_see_that_the_alert_box_is_closed_and_that_batch_is_still_present() {
            batchPage.alertwindow();

        }

        @Then("User should be able to see the alert box closed")
        public void user_should_be_able_to_see_the_alert_box_closed() {
            batchPage.alertwindow();

        }


        @Then("The respective row in the table should be delete")
        public void the_respective_row_in_the_table_should_be_delete() {
//        batchPage.
        }

        @Then("The specific row in the table must be deleted")
        public void the_specific_row_in_the_table_must_be_deleted() {
			/*
			 * selectedProgramList = batchPage.click_on_checkBox(1, 4);
			 * batchPage.multipleDeleteBtn();
			 */

        }
        
        @Then("The respective row in the table should be erased")
        public void the_respective_row_in_the_table_should_be_erased() {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java.PendingException();
        }



        @Then("The Next link must be visible to the Admin")
        public void the_next_link_must_be_visible_to_the_admin() {
            batchPage.goToNextPage();

        }


        @Then("The last page link must be visible to the admin with next page link disabled in the table")
        public void the_last_page_link_must_be_visible_to_the_admin_with_next_page_link_disabled_in_the_table() {
            batchPage.goToLastPage();

        }


        @Then("The previous page should be visible to the admin on the table")
        public void the_previous_page_should_be_visible_to_the_admin_on_the_table() {
            batchPage.goToPreviousPage();
        }


        @Then("The data table should show the very first page for the admin")
        public void the_data_table_should_show_the_very_first_page_for_the_admin() {
            batchPage.goToFirstPage();
        }


        @Then("The data table should display the filtered batches for the admin")
        public void the_data_table_should_display_the_filtered_batches_for_the_admin() {
//        batchPage.
//
        }

        @Then("The login screen page should be visible to the admin")
        public void the_login_screen_page_should_be_visible_to_the_admin() {
            batchPage.deleteenable();


        }
    
}
