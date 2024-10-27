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


#new
Scenario: Check if class is created with both mandatory and optional fields are entered with valid data


