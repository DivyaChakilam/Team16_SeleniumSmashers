#Author: Tohfatul

@Class
Feature: Manage Class

Background:
		Given Admin gives the correct LMS portal URL
    Given Admin enters valid credentials and clicks login button
    Given Admin clicks Class on the navigation bar   

    
 
######################## Add New Class Scenarios #########################
@classTest
Scenario: Validate Class Details Popup window
When Admin clicks add new class under the class menu bar
Then Admin should see a popup open for class details with empty form along with <SAVE> and <CANCEL> button and Close(X) Icon on the top right corner of the window

@Feature_AddNewClass
Scenario: Validate input fields and their text boxes in Class details form 
When Admin clicks add new class under the class menu bar
Then Admin should see a mix of input fields and text boxes totalling to 9 in the class details window

######################## Add New Class Popup Scenarios #########################

@mandatory 
Scenario: Check if class is created when only mandatory fields are entered with valid data
Given Admin clicks add new class under the class menu bar
When Admin enters mandatory fields only
Then Admin gets message "Class Created" in Manage Class Page 
And Admin sees created class details in Class Dialog Page

#new
#Additional
@allFields @won't_work
Scenario: Check if class is created with both mandatory and optional fields are entered with valid data
Given Admin clicks add new class under the class menu bar
When Admin enters all fields only
Then Admin gets message "Class Created" 
And Admin sees created class details in Class Dialog Page


@classNoAutomaticUpdate
Scenario: Check number of classes value added when selecting class dates
Given Admin clicks add new class under the class menu bar
When Admin selects class date in date picker
Then Admin should see no of class value is added automatically

@DisabledWeekendDates
Scenario: Check weekend dates are disabled in calender
Given Admin clicks add new class under the class menu bar
When Admin selects class weekend date in date picker
Then Admin should see weekends dates are disabled to select

@OnlyOptionalFields
Scenario: Check if class is created when only optional fields are entered with valid data
Given Admin clicks add new class under the class menu bar
When Admin skips to add value in mandatory field and enter only the optional field
Then Admin should see error message below the 6 mandatory test field and the field will be highlighed in "red" color:
|Batch Name is required.|
|Class Topic is required.|
|Class Date is required.|
|No. of Classes is required.|
|Staff Name is required.|
|Status is required.|

#Scenario: check if class is created when invalid data is entered in all of the fields



@emptyForm
Scenario: Empty form submission
Given Admin clicks add new class under the class menu bar
When Admin clicks on save button without entering data 
Then Class will not be created and Admin gets 6 error messages for mandatory fields

#Scenario: Validate Cancel/Close(X) icon on class Details form

#Scenario: Validate Save button on class Details form


######################## Search box Scenarios #########################

@search_Class @needsTesting
Scenario Outline: Search class by Batch Name/Class Topic/Staff Name
When Admin enter the "<columnName>" in search textbox in Manage Class page
Then Admin should see Class details are searched by "<columnName>"
Examples:
|columnName|
|Batch Name|
|Class Topic|
| Staff Name|

######################## Sort Class details Scenarios #########################

@sort_ascending_Class @needsTesting
Scenario Outline: Verify sorting of "<column Name>" in Ascending order
When Admin clicks on the "<column Name>" sort icon in Manage Class
Then Admin See the "<column Name>" is sorted in Ascending order in Manage Class
Examples:
|column Name|
|Batch Name|
|Class Topic|
|Class Descreption|
|Status|
|Class Date|
|Staff Name|


@sort_descending_Class @needsTesting
Scenario Outline: Verify sorting of "<column Name>" in Descending order
When Admin clicks on the "<column Name>" sort icon twice in Manage Class
Then Admin See the "<column Name>" is sorted in Descending order in Manage Class
Examples:
|column Name|
|Batch Name|
|Class Topic|
|Class Descreption|
|Status|
|Class Date|
|Staff Name|


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


