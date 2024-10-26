#Author: Divya

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
  
      
    
    
    

    