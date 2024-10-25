#Author: Divya
#Author: Dilina

@programDelete
Feature: Manage Program
Background: Admin Login
   Given Admin is on the dashboard page after login
   When Admin clicks Program on the navigation bar
   
   
   
   
   
   
  @deltebutton #@DeleteProgram
  Scenario: Verify Delete feature in program 
    When Admin clicks on delete button for a program
    Then Admin will get confirm deletion popup

	@tag2 @DeleteProgram
  Scenario: Verify Admin is able to click 'Yes'
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message
    
  @tag3 @DeleteProgram
  Scenario: Verify Admin is able to delete program
    When Admin Searches for "Deleted Program name"
    Then There should be zero results
    
  @tag4 @DeleteProgram
 	Scenario Outline: Verify Admin is able to click options 'No' and 'X'
    Given Admin is on Confirm deletion form
    When Admin clicks on "<option>" button
    Then Admin can see Confirmation form disappears and lands on program page
    Examples:
    | option |
    |  No    |
    |   X    |
    
  @tag5 @DeleteProgram
 	Scenario: Verify Admin is able to select multiple programs
    When Admin selects more than one program by clicking on the checkbox
    Then Programs get selected
    
  @tag6 @DeleteProgram
 	Scenario: Verify Admin is able to delete Multiple programs
    When Admin clicks on the delete button on the left top of the program page
    Then Admin lands on Confirmation form
    
  @tag7 @DeleteProgram
 	Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirmation form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message
    
  @tag8 @DeleteProgram
 	Scenario: Verify Admin is able to delete program(Multiple deleted)
    When Admin Searches for "Deleted Program names"
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
    
  @tag10  @SearchProgram
 	Scenario Outline: Verify Admin is able to search results found for program name/Description
    When Admin enter the program to search By "<option>"
    Then Admin should able to see Program name, description, and status for searched program name
    Examples:
    |       option      |
    |    Program Name   |
    |Program Description|
    |Partial Prog Name  |
    
  @tag11 @SearchProgram
 	Scenario: Verify Admin is able to search results not found
    When Admin enter the program to search By program name that does not exist
    Then There should be zero results
    
  @tag12 @SortProgram
 	Scenario: Verify sorting of Program name in Ascending order/Descending order
    When Admin clicks on Arrow next to column Name
    |Program Name|
    |Program Description|
    |Program Status |
    Then Admin See the Column Name is sorted in Ascending order/Descending order
    |Program Name|
    |Program Description|
    |Program Status |
    
  @tag13 @Pagination
 	Scenario: Verify Admin is able to click 'Next page' link
    When Admin clicks "Next page" link on the program table
    Then Admin should see the Pagination has Next active link
   
    
  @tag14 @Pagination
 	Scenario: Verify Admin is able to click 'Last page' link
    When Admin clicks "Last page" link on the program table
    Then Admin should see the last page record on the table with Next page link are disabled
    
  @tag15 @Pagination
 	Scenario: Verify Admin is able to click 'Previous page' link
    Given Admin is on last page of Program module table
    When Admin clicks "Previous page" link on the program table
    Then Admin should see the previous page record on the table with pagination has previous page link
    
  @tag16 @Pagination
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
      
    
    
    

    