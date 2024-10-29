#Author: Tohfatul

@Class
Feature: Manage Class

Background:
Given Admin is on the Manage class page

Scenario: Validate Class Details Popup window
When Admin clicks add new class under the class menu bar
Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

@Feature_AddNewClass
Scenario: Validate input fields and their text boxes in Class details form 
When Admin clicks add new class under the class menu bar
Then Admin should see a mix of input fields and text boxes totalling to 9 in the class details window

@mandatoryFields
Scenario: Check if class is created when only mandatory fields are entered with valid data
Given Admin clicks add new class under the class menu bar
When Admin enters mandatory fields only

  @NextPagePagination
 	Scenario: Verify Admin is able to click 'Next page' link
    When Admin clicks "Next page" link on the class table
    Then Admin should see the Pagination has Next active link
   
  @LastPagePagination
 	Scenario: Verify Admin is able to click 'Last page' link
    When Admin clicks "Last page" link on the class table
    Then Admin should see the last page record on the table with Next page link are disabled
   
  @PreviousPagePagination
 	Scenario: Verify Admin is able to click 'Previous page' link
    Given Admin is on last page of class module table
    When Admin clicks "Previous page" link on the class table
    Then Admin should see the previous page record on the table with pagination has previous page link
    
  @FirstPagePagination
 	Scenario Outline: Verify Admin is able to click First page link
    Given Admin is on last page of Program module table
    When Admin clicks "First page" link on the class table
    Then Admin should see the very first page record on the table with Previous page link are disabled
    
  @DeleteClass1
  Scenario: Verify row level Delete feature in class 
    When Admin clicks on delete button for a class
    Then Admin will get confirm deletion popup

	@DeleteClass2
  Scenario: Verify Admin is able to click 'Yes'
    Given Admin is on Confirm deletion form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Class Deleted' message
    
  @DeleteClass3
  Scenario: Verify Admin is able to delete Class
    When Admin Searches for Deleted Class name
    Then There should be zero results
    
  @DeleteClass4
 	Scenario Outline: Verify Admin is able to click options 'No' and 'X'
    Given Admin is on Confirm deletion form
    When Admin clicks on "<option>" button
    Then Admin can see Confirmation form disappears and lands on program page
    Examples:
    | option |
    |  No    |
    |   X    |


#new
Scenario: Check if class is created with both mandatory and optional fields are entered with valid data


