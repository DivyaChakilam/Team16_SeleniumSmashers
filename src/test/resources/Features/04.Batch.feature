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
    When Admin clicks "Batch" on the navigation bar
    Then the Batch page should display the sub-menu options
  @batchtag14
  Scenario: Validate Admin able to click on the Add new Batch option
    When User click on the "Add New Batch" option
    Then User should see the Batch details pop-up
  @batchtag15
  Scenario: Validate all the fields exist in the pop-up
    Given User on the "Add New Batch" pop-up to validate all the fields exist
    Then all fields should be visible:
      | Batch Name Prefix |
      | Batch Name Suffix |
      | Program Name      |
      | Description       |
      | No. of Classes    |
  @batchtag16
  Scenario: Validate batch name prefix selects the program name
    Given User on the "Add New Batch" pop-up to Validate batch name prefix
    Then the batch name prefix should match the selected program name
  @batchtag17
  Scenario: Validate batch name suffix box accepts only numbers
    Given User on the "Add New Batch" pop-up to Validate batch name suffix
    Then the batch name suffix field should accept only numeric input
  @batchtag18
  Scenario: Validate batch name prefix box is not editable
    Given User on the "Add New Batch" pop-up to validate not editable
    Then the batch name prefix field should be non-editable
  @batchtag19
  Scenario: Validate input data only for mandatory fields
    Given User on the "Add New Batch" pop-up to Validate mandatory fields
    When User input data for mandatory fields
    Then User should be able to save successfully
  @batchtag20
  Scenario: Validate input data missing for mandatory fields
    Given User on the "Add New Batch" pop-up
    When User leave mandatory fields empty
    Then User should see a validation error message
  @batchtag21
  Scenario: Validate Save button in Batch details pop-up
    Given User on the "Add New Batch" pop-up to Validate Save button
    Then the Save button should be enabled when all mandatory fields are filled
  @batchtag22
  Scenario: Validate Cancel button in Batch details pop-up
    Given User on the "Add New Batch" pop-up to Validate Cancel button
    When User click on the Cancel button
    Then the pop-up should close without saving cancel button
  @batchtag23
  Scenario: Validate close icon on the Batch details pop-up
    Given User on the "Add New Batch" pop-up to Validate close icon
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
