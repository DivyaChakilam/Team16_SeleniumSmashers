@logout
Feature:  Validation on Logout button

Background: Verify admin is able to land on home page
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page
    Then Admin enters valid credentials and clicks login button
   
Scenario: Verify logout function
   Given Admin is on home page
   When Admin clicks on the logout in the menu bar
   Then Admin should be redirected to login page


