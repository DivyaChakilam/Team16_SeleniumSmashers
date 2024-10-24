Feature:  Validation on Logout button

Background: Admin is logged into the appilcation
   
Scenario: Verify logout function
Given Admin is on home page
When Admin clicks on the logout in the menu bar
Then Admin should be redirected to login page

Scenario: Verify browser back button function 
Given Admin is on login page
When Admin clicks browser back button 
Then Admin should receive error message

