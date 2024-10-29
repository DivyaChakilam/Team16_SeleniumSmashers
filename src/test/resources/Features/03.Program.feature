#Author: Divya
#Author: Dilina

@programDelete
Feature: Manage Program
Background: Admin Login

   Given Admin gives the correct LMS portal URL
   Given Admin enters valid credentials and clicks login button
   Given Admin clicks Program "Program" on the navigation bar
   
   ################ Navigation and Menu Bar Validation ###########################
   
  @tag17 @Navigation
  Scenario: Verify that Admin is able to navigate to Program module
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should be navigated to Program module
   
   @tag19 @MenuBar
  Scenario: Verify heading in menu bar
   Then Admin should see the heading "LMS - Learning Management System"

  @tag20 @MenuBar
  Scenario: Verify other module's name displayed in menu bar
   Then Admin should see the module names as in order "Program Batch Class Logout"

  @tag21 @MenuBar
  Scenario: Verify Logout displayed in menu bar
   Then Admin should see Logout in menu bar
   
  @tag22 @MenuBar
  Scenario: Verify sub menu displayed in program menu bar
   Given Admin is on program page
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see sub menu in menu bar as "Add New Program"
   
   ################ Manage Program Page Validation ###########################
   
   @tag23 @ManageProgramPagevalidation
  Scenario: Verify heading in manage program
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see the heading "Manage Program"
   
   @tag24 @ManageProgramPagevalidation
   Scenario: Verify view details of programs
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should able to see Program name, description, and status for each program
   
   
   @tag25 @ManageProgramPagevalidation
   Scenario: Verify the Multiple Delete button state 
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see a Delete button in left top is disabled
   
   @tag26 @ManageProgramPagevalidation
   Scenario: Verify the Search button 
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see Search bar with text as "Search..."
   
    @tag27 @ManageProgramPagevalidation
   Scenario: Verify column header name of data table
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete

   @tag28 @ManageProgramPagevalidation
   Scenario: Verify checkbox default state beside Program Name column header
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see checkbox default state as unchecked beside Program Name column header as 
   
   @tag29 @ManageProgramPagevalidation
   Scenario: Verify checkboxes default state beside each Program names in the data table 
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see check box default state as unchecked on the left side in all rows against program name 
   
   @tag30 @ManageProgramPagevalidation
   Scenario: Verify Sort icon in manage program
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
   
   @tag31 @ManageProgramPagevalidation
   Scenario: Verify edit and delete icon in manage program
   When Admin clicks Program "Program" on the navigation bar
   Then Admin should see the Edit and Delete buttons on each row of the data table
   
   ################ Add New Program Page Validation ###########################   
   
   @tag35 @AddNewProgram
   Scenario: Verify add New Program
   When Admin clicks on "New Program" under the "Program" menu bar
   Then Admin should see pop up window for program details
   
    @tag36 @AddNewProgram
   Scenario: Verify title of the pop up window
   When Admin clicks on "New Program" under the "Program" menu bar
   Then Admin should see window title as "Program Details"


   @tag37 @AddNewProgram
   Scenario: Verify mandatory fields with red "*" mark 
   When Admin clicks on "New Program" under the "Program" menu bar
   Then Admin should see red "*" mark beside mandatory field "Name"
   
   @tag38 @AddNewProgram
   Scenario: Verify empty form submission 
   Given Admin is on Program details form 
   When Admin clicks save button without entering mandatory 
   Then Admin gets message '<field> is required'
   
   @tag39 @AddNewProgram
   Scenario: Verify cancel button 
   Given Admin is on Program details form 
   When Admin clicks Cancel button 
   Then Admin can see Program Details form disappears 
   
   @tag40 @AddNewProgram
   Scenario Outline:  Verify enter program name 
   Given Admin is on Program details form 
   When Admin enters the Name "<Name>" in the text box
   Then Admin can see the text entered
   Examples:
    | Name |
    |  Selenium Smashers    |

   
   @tag41 @AddNewProgram
   Scenario Outline:  Verify enter description 
   Given Admin is on Program details form 
   When Admin enters the Description "<Description>" in text box
   Then Admin can see the text entered in description box
   Examples:
    | Description |
    |  Selenium Learning    |
   
    @tag42 @AddNewProgram
   Scenario Outline:  Verify select Status 
   Given Admin is on Program details form 
   When Admin selects the status of the program by clicking on the radio "<option>" button "(Active/InActive)"
   Then Admin can see "<option>" status selected
   Examples:
    | option |
    |  Active    |
    |  InActive    |

	@tag43 @AddNewProgram
   Scenario Outline:  Verify Admin is able to save the program details
   Given Admin is on Program details form 
   When Admin enter valid details for mandatory fields "<Name>" "<Description>" "<Option>" and Click on save button
   Then Admin gets message Successful Program created
   Examples:
   | Name            | Description                  | Option |
   |SeleniumSmashers | Selenium Description         | Active |
   
    @tag44 @AddNewProgram
   Scenario: Verify added Program is created
   When Admin searches with newly created program
   Then Records of the newly created program is displayed and match the data entered
   
   @tag45 @AddNewProgram
   Scenario: Verify close window with "X" 
   Given Admin is on Program details form
   When Admin Click on "X" button
   Then Admin can see program details form disappear 
 
   ################ Search Program Validation ###########################   
    
    @SearchProgram1
 		Scenario Outline: Verify Admin is able to search results found for program name/Description
    When Admin enter the program to search By "<option>"
    Then Admin should able to see Program name, description, and status for searched "program name"
    Examples:
    |       option      |
    |    ProgramName   |
    |ProgramDescription|
    |PartialProgName  |
    
 	@SearchProgram2
 	Scenario: Verify Admin is able to search results not found
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results
   
   ################ Edit Program Validation ###########################   
   
   @tag46 @EditProgram
   Scenario: Verify Edit option 
   When Admin clicks on Edit option for particular program
   Then Admin lands on Program details form
   
   @tag47 @EditProgram
   Scenario: Verify title of the pop up window 
   When Admin clicks on Edit option for particular program
   Then Admin should see window title as "Program Details"
   
   @tag48 @EditProgram
   Scenario: Verify mandatory fields with red "*" mark 
   When Admin clicks on Edit option for particular program
   Then Admin should see red "*" mark beside mandatory field "Name"
   
    @tag49 @EditProgram
   Scenario: Verify edit Program Name 
   When Admin edits the program name and click on save button
   Then Updated program name is seen by the Admin
   
   @tag50 @EditProgram
   Scenario: Verify edit Description 
   When Admin edits the description text and click on save button
   Then Admin can see the description is updated
   
   @tag51 @EditProgram
   Scenario: Verify edit Status 
   When Admin can change the status of the program and click on save button
   Then Status updated can be viewed by the Admin
   
   @tag52 @EditProgram
   Scenario: Verify Admin is able to click Save 
   When Admin click on save button
   Then Admin can see the updated program details
   
   @tag53 @EditProgram
   Scenario: Verify Admin is able to click Cancel 
   When Admin clicks Cancel button on a Program
   Then Admin can see Program Details form disappears
   
   @tag54 @EditProgram
   Scenario: Verify edited Program details 
   When Admin searches with newly updated "Program Name"
   Then Admin verifies that the details are correctly updated.
   
   @tag55 @EditProgram
   Scenario: Verify close the window with "X" 
   When Admin Click on "X" button
   Then Admin can see program details form disappear
    
   ################ Sort Program Validation ###########################   
    
    @SortProgram1
 	Scenario Outline: Verify sorting of "<column Name>" in Ascending order
    When Admin clicks on Arrow next to "<column Name>" to sort in asc
    Then Admin See the "<column Name>" is sorted in Ascending order
     Examples:
    |column Name|
    |Program Name|
    |Program Description|
    |Program Status|
    
  @SortProgram2
 	Scenario Outline: Verify sorting of "<column Name>" in Descending order
    When Admin clicks on Arrow next to "<column Name>" to sort in desc
    Then Admin See the "<column Name>" is sorted in Descending order
     Examples:
    |column Name|
    |Program Name|
    |Program Description|
    |Program Status|
    
  ################ Manage Program Pagination Validation ###########################   
    
  @Pagination1
 	Scenario: Verify Admin is able to click 'Next page' link
    When Admin clicks "Next page" link on the program table
    Then Admin should see the Pagination has Next active link
   
    
  @Pagination2
 	Scenario: Verify Admin is able to click 'Last page' link
    When Admin clicks "Last page" link on the program table
    Then Admin should see the last page record on the table with Next page link are disabled
   
  @Pagination3
 	Scenario: Verify Admin is able to click 'Previous page' link
    Given Admin is on last page of Program module table
    When Admin clicks "Previous page" link on the program table
    Then Admin should see the previous page record on the table with pagination has previous page link
    
  @Pagination4
 	Scenario Outline: Verify Admin is able to click First page link
    Given Admin is on last page of Program module table
    When Admin clicks "First page" link on the program table
    Then Admin should see the very first page record on the table with Previous page link are disabled
    

   
 # @tag18 @MenuBar
 # Scenario: Verify any broken links on program page
  # When Admin clicks Program "Program" on the navigation bar
   #Then Admin should not have any broken links for Program module
   
  
   
      
  # @tag32 @ManageProgramPagevalidation
   #Scenario: Verify edit and delete icon in manage program
  # When Admin clicks Program "Program" on the navigation bar
   #Then "Admin should see the text as ""Showing x to y of z entries"" along with Pagination icon below the table. 
  #x- starting record number on that page
  #y-ending record number on that page
 # z-Total number of records"
 
 #@tag33 @ManageProgramPagevalidation
   #Scenario: Verify footer message in manage program
   #When Admin clicks Program "Program" on the navigation bar
   #Then Admin should see the footer as "In total there are z programs"".z- Total number of records"


   
   
   
   #-----------
  #@tag35 @AddNewProgram
   #Scenario: Verify add New Program
   #Given Admin is on Program module  
   #When Admin clicks on "New Program" under the "Program" menu bar
   #Then Admin should see pop up window for program details

  ################ Single/Multiple Program Deletion Validation ###########################   

   @DeleteProgram1
  Scenario: Verify Delete feature in program 
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup


  @DeleteProgram4
 	Scenario Outline: Verify Admin is able to click options 'No' and 'X'
    Given Admin is on Confirm deletion form
    When Admin clicks on "<option>" button
    Then Admin can see Confirmation form disappears and lands on program page
    Examples:
    | option |
    |  No    |
    |   X    |
    
  @DeleteProgram5
 	Scenario: Verify Admin is able to select multiple programs
    When Admin selects more than one program by clicking on the checkbox
    Then Programs get selected
    
  @DeleteProgram6
 	Scenario: Verify Admin is able to delete Multiple programs
    When Admin clicks on the delete button on the left top of the program page
    Then Admin will get confirm deletion popup
    
  @DeleteProgram7
 	Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirmation form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Programs Deleted' message
    
  @DeleteProgram8
 	Scenario: Verify Admin is able to deleted programs
    When Admin Searches for Deleted Program names
    Then There should be zero results
    
  @DeleteProgram9
 	Scenario Outline: Verify Admin is able to click 'NO'/'X' with multiple delete
    Given Admin is on Confirmation form
    When Admin clicks on "<option>" button
    Then Admin can see Programs are still selected and not deleted
    Examples:
    | option |
    |  No    |
    |   X    |
