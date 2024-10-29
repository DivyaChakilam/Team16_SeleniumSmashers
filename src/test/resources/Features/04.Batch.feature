
  Feature: Delete batch feature

  Background: Logged on the LMS portal
   Given Admin is on Dashboard Page

Scenario: Validate delete Icon on any row
  Given Admin clicks "Batch" from navigation bar
  And Admin is on Batch Page
  When Admin clicks the delete Icon on any row
Then Admin should see the confirm alert box with yes and no button


Scenario:Validate yes button on the confirm alert box
Given User is on the batch page for the confirm alert box
When User clicks on the delete icon and click yes buttton
Then User should see the successfull message and the batch should be deleted


Scenario:validate no button on the confirm alert box
Given User is on the batch confirm popup page
When User clicks on the delete icon and click no buttton
Then User should see the alert box closed and the batch is not deleted


Scenario:validate close Icon on the alert box
  Given User is on the batch confirm popup page
  When User clicks on the close icon
  Then User should be able to see the alert box closed




    Scenario: Check for single row delete
      Given One of the checkbox row is selected for batch
      When Click delete icon below "Manage Batch" header for batch
      Then The respective row in the data table is deleted for batch



    Scenario: Check for multi row delete
      Given Two or more checkboxes/row is selected for batch
      When Click delete icon below "Manage Batch" header for multiple rows for batch
      Then The respective rows in the data table are deleted for batch


    Scenario:Validate next page link
Given User is landed on the batch page
When User landed on the next page link on the data table
Then User should see the Next enabled link


Scenario:validate last page link
Given User clicks last page link on the data table
When you clicks last page link on the data table
Then User should see the last page link with next page link disabled on the table


Scenario:user should see the last page link with next page link disabled on the table
Given user is on the batch page
When user clicks backward page link on the data table
Then user should see the previous page on the table


Scenario:validate the first page link
Given user landed on the batch page
When user clicks first page link on the data table
Then user should see the very first page on the data table




Scenario:validate search box functionality
Given User is on the batch page
When User enters the batch name in the serach text box
Then User should see the filtered batches in the data table


Scenario:Validate logout option in the header is visible and enabled from the batch page
Given User is on the batch page
When User clicks on the logout button
Then User should see the Login screen Page




@BatchPage
Feature: Batch Page Functionality Verification

  Background: Admin logs into the application and navigates to the Batch page
    Given Admin is on Dashboard page
    And Admin Clicks on the Batch menu from the header
    
  @batchtag1
  Scenario: Verify Admin navigates to the Batch page successfully 
    Then Admin should see the Batch page title as "Batch"
    
  @batchtag2
  Scenario: Validate "Title" in the Batch Page
    Then the page title should be "Batch"
    
  @batchtag3
  Scenario: Validate "Heading" in the Batch Page
    Then the page heading should be "Manage Batches"
    
  @batchtag4
  Scenario: Validate disabled "Delete Icon" under the header in the Batch Page
    Then the Delete Icon under the header should be disabled
    
  @batchtag5
  Scenario: Validate pagination in the Batch Page
    Then pagination should be visible and functional
    
  @batchtag6
  Scenario: Validate edit icon in each data row
    Then each data row should have an edit icon
    
  @batchtag7
  Scenario: Validate delete icon in each data row
    Then each data row should have a delete icon
    
  @batchtag8
  Scenario: Validate checkbox in each data row
    Then each data row should have a checkbox
    
  @batchtag9
  Scenario: Validate Datatable head 
    Given User on the Batch page to validate Datatable head 
    Then the Datatable should have the correct headers:
      | Batch Name     |
      | Program Name   |
      | Description    |
      | No. of Classes |
      | Actions        |
      
  @batchtag10
  Scenario: Validate "Checkbox" in the Datatable header row
    Then the Datatable header row should have a checkbox
    
  @batchtag11
  Scenario: Validate "Sort Icon" next to all the Datatable headers
    Then each Datatable header should have a sort icon
    
  @batchtag12
  Scenario: Verify sub-menu displayed in Batch menu bar
    When Admin clicks "Batch" on the navigation bar of batch menu
    Then the Batch page should display the sub-menu options
    
  @batchtag14
  Scenario: Validate Admin able to click on the Add new Batch option
    When User click on the Add New Batch option
    Then User should see the Batch details pop-up
    
  @batchtag15
  Scenario: Validate all the fields exist in the pop-up
    Given User on the Add New Batch pop-up to validate all the fields exist
    Then all fields should be visible in batch details pop message
      
  @batchtag16
  Scenario Outline: Validate batch name prefix selects the program name
     Given User is on the Add New Batch pop-up to validate batch name prefix
     When User selects program name
     Then the batch name prefix should match the selected program name 
      

  @batchtag17 
  Scenario Outline: Validate batch name suffix box should accept only numbers
    Given User is on the Batch Details pop-up window
    When User enters "<BatchName>" and "<BatchCode>" 
    Then User should get error message after entering alphabets in suffix box
    Examples:
    | BatchName    | BatchCode |
    | Java Basics  | JB001     |
    
  @batchtag18
  Scenario: Validate batch name prefix box is not editable
    Given User on the Add New Batch pop-up to validate not editable
    Then the batch name prefix field should be non-editable
    
  @batchtag19
  Scenario Outline: Validate input data only for mandatory fields
    Given User is on the Add New Batch pop-up to Validate mandatory fields
    When  User inputs "<Batchname>", "<BatchCode>", "<BatchDescription>", "<Status>", and "<NoOfClasses>" 
    Then User should be able to save successfully
    Examples:
    | Batchname            | BatchCode | BatchDescription             | Status   | NoOfClasses |
    | Selenium Smashers    | 001       | Introduction to Java         | Active   | 10          |
  
  @batchtag20
  Scenario Outline: Validate input data missing for mandatory fields
    Given User is on the Add New Batch pop-up to check missing mandatory fields
    When User leaves "<MissingField>" empty for "<Batchname>", "<BatchCode>", "<BatchDescription>", "<Status>", and "<NoOfClasses>"
    Then User should see a validation error message for "<MissingField>" as "<ErrorMsg>"

    Examples:
      | MissingField       | Batchname      | BatchCode | BatchDescription             | Status   | NoOfClasses | ErrorMsg                      |
      | Batchname          |                | BC001     | Introduction to Batch        | Active   | 10          | Program Name is required.     |
      | BatchCode          | Java Basics    |           | Introduction to Java         | Active   | 10          | Batch Name is required.       |
      | BatchDescription   | Java Basics    | JB001     |                              | Active   | 10          | Batch Description is required.|
      | Status             | Java Basics    | JB001     | Introduction to Java         |          | 10          | Status is required.           |
      | NoOfClasses        | Java Basics    | JB001     | Introduction to Java         | Active   |             | Number of classes is required.|
  
  @batchtag21
  Scenario Outline: Validate Save button in Batch details pop-up
    Given User on the Add New Batch pop-up to Validate Save button 
    When  User inputs "<Batchname>", "<BatchCode>", "<BatchDescription>", "<Status>", and "<NoOfClasses>" 
    Then User should be able to save successfully
  
    Examples:
    | Batchname            | BatchCode | BatchDescription             | Status   | NoOfClasses |
    | CoreJava				     | 002       | Introduction to Java         | Active   | 10          |
    
  @batchtag22
  Scenario: Validate Cancel button in Batch details pop-up
    Given User on the Add New Batch pop-up to Validate Cancel button
    When User click on the Cancel button
    Then the pop-up should close without saving cancel button
  
  @batchtag23
  Scenario: Validate close icon on the Batch details pop-up
    Given User on the Add New Batch pop-up to Validate close icon
    When User click on the close icon
    Then the pop-up should close without saving close icon
  
  @batchtag24
  Scenario: Validate Edit icon feature in any row
    Given User on the Batch page to Validate Edit icon feature
    When User click on the Edit icon for a row
    Then User should be able to edit the batch details
  
  @batchtag25
  Scenario: Validate Program Name value is disabled to edit
    Given User editing a batch to Validate Program Name value
    Then the Program Name field should be disabled 
 
  @batchtag26
  Scenario: Validate Batch Name value is disabled to edit
    Given User editing a batch to Validate Batch Name value
    Then the Batch Name field should be disabled
  
  @batchtag27
  Scenario: Validate editing description and No. of classes fields with invalid data in the pop-up
    Given User editing a batch to Validate editing description
    When User input invalid data in the description and No. of classes fields
    Then User should see validation error messages
  
  @batchtag28
  Scenario: Validate Save button in Batch details pop-up after editing
    Given User editing a batch to Validate Save button
    When User fill in valid data
    Then the Save button should be enabled
 
  @batchtag29
  Scenario: Validate Cancel button in Batch details pop-up after editing
    Given User editing a batch to Validate Cancel button
    When User click on the Cancel button after editing
    Then the changes should not be saved

