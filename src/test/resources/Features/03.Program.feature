#Author: Divya
#Author: Dilina

@programDelete
Feature: Manage Program
Background: Admin Login
   Given Admin is on the dashboard page after login
   When Admin clicks Program on the navigation bar
   
  @DeleteProgram1
  Scenario: Verify Delete feature in program 
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup

	 @DeleteProgram2
  Scenario: Verify Admin is able to click 'Yes'
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message
    
   @DeleteProgram3
  Scenario: Verify Admin is able to delete program
    When Admin Searches for Deleted Program name
    Then There should be zero results
    
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
    
  @tag6 @DeleteProgram
 	Scenario: Verify Admin is able to delete Multiple programs
    When Admin clicks on the delete button on the left top of the program page
    Then Admin will get confirm deletion popup
    
  @tag7 @DeleteProgram
 	Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirmation form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message
    
  @tag8 @DeleteProgram
 	Scenario: Verify Admin is able to deleted programs
    When Admin Searches for Deleted Program names
    Then There should be zero results
    
  @tag9 @DeleteProgram
 	Scenario Outline: Verify Admin is able to click 'NO'/'X' with multiple delete
    Given Admin is on Confirmation form
    When Admin clicks on "<option>" button
    Then Admin can see Programs are still selected and not deleted
    Examples:
    | option |
    |  No    |
    |   X    |
    
    @SearchProgram1
 		Scenario Outline: Verify Admin is able to search results found for program name/Description
    When Admin enter the program to search By "<option>"
    Then Admin should able to see Program name, description, and status for searched program name
    Examples:
    |       option      |
    |    ProgramName   |
    |ProgramDescription|
    |PartialProgName  |
    
 	@SearchProgram2
 	Scenario: Verify Admin is able to search results not found
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results
    
  @SortProgram
 	Scenario Outline: Verify sorting of Program name in Ascending order/Descending order
    When Admin clicks on Arrow next to "<column Name>"
    Then Admin See the "<column Name>" is sorted in Ascending order/Descending order
     Examples:
    |column Name|
    |Program Name|
    |Program Description|
    |Program Status|
    
    #@SortProgram1
 #	Scenario Outline: Verify sorting of Program name in Ascending order
    #When Admin clicks on Arrow next to "<column Name>" to sort in asc
    #Then Admin See the "<column Name>" is sorted in Ascending order
     #Examples:
    #|column Name|
    #|Program Name|
    #|Program Description|
    #|Program Status|
    #
     #@SortProgram2
 #	Scenario Outline: Verify sorting of Program name in Descending order
    #When Admin clicks on Arrow next to "<column Name>" to sort in desc
    #Then Admin See the "<column Name>" is sorted in Descending order
     #Examples:
    #|column Name|
    #|Program Name|
    #|Program Description|
    #|Program Status|
    
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
    
  @tag17 @Navigation
  Scenario: Verify that Admin is able to navigate to Program module
   When Admin clicks "Program" on the navigation bar
   Then Admin should be navigated to Program module
   
  @tag18 @MenuBar
  Scenario: Verify any broken links on program page
   When Admin clicks "Program" on the navigation bar
   Then Admin should not have any broken links for Program module
   
  @tag19 @MenuBar
  Scenario: Verify heading in menu bar
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the heading "LMS - Learning Management System"

  @tag20 @MenuBar
  Scenario: Verify other module's name displayed in menu bar
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the module names as in order "Home Program Batch Class Admin Assignment Attendance"
   
  @tag21 @MenuBar
  Scenario: Verify Logout displayed in menu bar
   When Admin clicks "Program" on the navigation bar
   Then Admin should see Logout in menu bar
   
  @tag22 @MenuBar
  Scenario: Verify sub menu displayed in program menu bar
   Given Admin is on program page
   When Admin clicks "Program" on the navigation bar
   Then Admin should see sub menu in menu bar as "Add New Program"
   
    @tag23 @ManageProgramPagevalidation
  Scenario: Verify heading in manage program
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the heading "Manage Program"
   
   @tag24 @ManageProgramPagevalidation
   Scenario: Verify view details of programs
   When Admin clicks "Program" on the navigation bar
   Then Admin should able to see Program name, description, and status for each program
   
   
   @tag25 @ManageProgramPagevalidation
   Scenario: Verify the Multiple Delete button state 
   When Admin clicks "Program" on the navigation bar
   Then Admin should see a Delete button in left top is disabled
   
   @tag26 @ManageProgramPagevalidation
   Scenario: Verify the Search button 
   When Admin clicks "Program" on the navigation bar
   Then Admin should see Search bar with text as "Search..."
   
    @tag27 @ManageProgramPagevalidation
   Scenario: Verify column header name of data table
   When Admin clicks "Program" on the navigation bar
   Then Admin should see data table with column header on the Manage Program Page as  Program Name, Program Description, Program Status, Edit/Delete

   @tag28 @ManageProgramPagevalidation
   Scenario: Verify checkbox default state beside Program Name column header
   When Admin clicks "Program" on the navigation bar
   Then Admin should see checkbox default state as unchecked beside Program Name column header as 
   
   @tag29 @ManageProgramPagevalidation
   Scenario: Verify checkboxes default state beside each Program names in the data table 
   When Admin clicks "Program" on the navigation bar
   Then Admin should see check box default state as unchecked on the left side in all rows against program name 
   
   @tag30 @ManageProgramPagevalidation
   Scenario: Verify Sort icon in manage program
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the sort arrow icon beside to each column header except Edit and Delete 
   
   @tag31 @ManageProgramPagevalidation
   Scenario: Verify edit and delete icon in manage program
   When Admin clicks "Program" on the navigation bar
   Then Admin should see the Edit and Delete buttons on each row of the data table
   
  # @tag32 @ManageProgramPagevalidation
   #Scenario: Verify edit and delete icon in manage program
  # When Admin clicks "Program" on the navigation bar
   #Then "Admin should see the text as ""Showing x to y of z entries"" along with Pagination icon below the table. 
  #x- starting record number on that page
  #y-ending record number on that page
 # z-Total number of records"
 
 #@tag33 @ManageProgramPagevalidation
 #  Scenario: Verify footer message in manage program
 #  When Admin clicks "Program" on the navigation bar
 #  Then "Admin should see the footer as ""In total there are z programs"".
 #  z- Total number of records"


   
   
   
   
   @tag36 @AddNewProgram
   Scenario: Verify add New Program
   Given Admin is on Program module  
   When Admin clicks on "New Program" under the "Program" menu bar
   Then Admin should see pop up window for program details
   
   @tag36 @AddNewProgram
   Scenario: Verify title of the pop up window
   Given Admin is on Program module  
   When Admin clicks on "New Program" under the "Program" menu bar
   Then Admin should see window title as "Program Details"


   @tag37 @AddNewProgram
   Scenario: Verify mandatory fields with red "*" mark 
   Given Admin is on Program module  
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
   Scenario: Verify enter program name 
   Given Admin is on Program details form 
   When Admin enters the Name in the text box
   Then Admin can see the text entered
   
   @tag41 @AddNewProgram
   Scenario: Verify enter description 
   Given Admin is on Program details form 
   When Admin enters the Description in text box
   Then Admin can see the text entered in description box
   
    @tag42 @AddNewProgram
   Scenario: Verify select Status 
   Given Admin is on Program details form 
   When Admin selects the status of the program by clicking on the radio button "(Active/InActive)"
   Then Admin can see 'Active/Inactive' status selected

   @tag43 @AddNewProgram
   Scenario: Verify Admin is able to save the program details
   Given Admin is on Program details form 
   When Admin enter valid details for mandatory fields and Click on save button
   Then Admin gets message 'Successful Program created'
   
   @tag44 @AddNewProgram
   Scenario: Verify cancel program details
   Given Admin is on Program details form 
   When Admin Click on cancel button
   Then Admin can see program details form disappear
   
    @tag45 @AddNewProgram
   Scenario: Verify added Program is created
   Given Admin is on Program module
   When Admin searches with newly created "Program Name"
   Then Records of the newly created  "Program Name" is displayed and match the data entered
   
   @tag46 @AddNewProgram
   Scenario: Verify close window with "X" 
   Given Admin is on program details form
   When Admin Click on "X" button
   Then Admin can see program details form disappear





 




   
   
   
   
   

   






   


      
    
    
    

    