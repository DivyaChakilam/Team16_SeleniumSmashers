Feature: Login  Page Verification

@test
Scenario: Verify Admin is able to land on login page
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should land on the login page.

Scenario: Verify Admin is able to land on home page with invalid URL
Given Admin launch the browser.
When Admin gives the incorrect LMS portal URL.
Then Admin should recieve page not found error.

Scenario: Verify for broken link
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should recieve the link is broken error.

Scenario: Verify the text spelling in the page 
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see correct spellings in all fields.

Scenario: Admin should see logo on the left  side
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see logo on the left  side.

Scenario: Verify company name
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see company name below the app name

Scenario: Validate sign in content
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see "Please login to LMS application"

Scenario: Verify text field is present
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see two text field

Scenario: Verify text on the first text field
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see "User" and "(*)" symbol in the first text field

Scenario: Verify text on the second text field
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see"Password" and "(*)" symbol in the first text field

Scenario: Verify the alignment input field for the login
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see input field on the centre of the page

Scenario: verify Login button is present
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see login button

Scenario: Verify the alignment of the login button
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see login button on the centre of the page.

Scenario: Verify the alignment of the login button
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see login button on the centre of the page.

Scenario: Verify input descriptive test in user and password field
Given Admin launch the browser.
When Admin gives the correct LMS portal URL.
Then Admin should see user and password text in gray color

Scenario: Validate login with valid credentials
Given Admin is in login Page.
When Admin enter valid credentials and clicks login button 
Then Admin should land on dashboard page(centre of the page will be empty , menu bar is present).  

Scenario: Validate login with invalid credentials 
Given Admin is in login Page.
When Admin enter invalid credentials and clicks login button
Then Admin gets Error message "Invalid username and password Please try again".

Scenario: Validate login credentials with null Adminname
Given Admin is in login Page.
When Admin enter value only in password and clicks login button 
Then Admin gets Error message "Please enter your user name".

Scenario: Validate login credentials with null Adminname
Given Admin is in login Page.
When Admin enter value only in Adminname and clicks login button 
Then Admin gets Error message 

Scenario: verify login button action through keyboard
Given Admin is on login Page.
When Admin enter value only in Adminname and clicks login button 
Then Admin should land on dashboard page

Scenario: verify login button action through mouse
Given Admin is on login Page.
When Admin enter valid credentials and clicks login button through mouse
Then Admin should land on dashboard page