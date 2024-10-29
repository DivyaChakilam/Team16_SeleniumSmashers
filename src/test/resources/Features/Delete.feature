@tag
Feature: Delete Features of Program/Batch?class Modules


 ###################### Delte Batch Created ######################



 ###################### Delte Program Created ######################
	@DeleteProgram2
  Scenario: Verify Admin is able to click 'Yes'
  	Given Admin gives the correct LMS portal URL
    Given Admin enters valid credentials and clicks login button
    Given Admin clicks Program "Program" on the navigation bar
    
    Given Admin is on Confirm deletion form
    When Admin clicks on "Yes" button
    Then Admin can see 'Successful Program Deleted' message
    
  @DeleteProgram3
  Scenario: Verify Admin is able to delete program
  	Given Admin gives the correct LMS portal URL
   	Given Admin enters valid credentials and clicks login button
   	Given Admin clicks Program "Program" on the navigation bar
   	
    When Admin Searches for Deleted Program name
    Then There should be zero results
    
    
