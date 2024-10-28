@login
Feature: Login Page Verification
	
	Background:
    When Admin gives the correct LMS portal URL
    Then Admin should land on the home page

	
  Scenario: Validate logo is displayed in loginPage
    Then Admin should see expected logo image in login page

  Scenario: Validate field allignments in loginPage
    Then Admin should see input and loginbutton are in center of login page

  Scenario: Validate Page Not found
    When Admin gives the invalid LMS portal URL
    Then Admin should recieve 404 page not found error


  Scenario Outline: Validate login with valid credentials
    When Admin enters valid credentials '<Uname>' and '<Pwd>' and clicks login button
    Then Admin should land on dashboard page

    Examples: 
      | Uname                    | Pwd            |
      | sdet@gmail.com | LmsHackathon@2024  |

#@login_negative
  Scenario Outline: Validate login page elements and invalid credentials
    When Admin enters invalid credentials '<Uname>' and '<Pwd>' and clicks login button
    Then Admin should see the Error message please check expected '<msg>' displays

    Examples: 
      | Uname                    | Pwd          | msg                                            |
      | sdetorgani@gmail.co  | LmsHackathon@2024   | Invalid username and password Please try again |
      | sdet@gmail.com | Hackathon@   | Invalid username and password Please try again |
     #|              | LmsHackathon@2024 | Please enter your user name  |
     #| sdet@gmail.com |            | Please enter your password    |
     #|            |             | Please enter username and password Please try again |

	#@login_positive
  Scenario Outline: Validate login with valid credentials by clicking Login button through Keypad
    When Admin enters valid credentials '<Uname>' and '<Pwd>' and clicks login button through keypad
    Then Admin should land on dashboard page

    Examples: 
      | Uname                    | Pwd            |
      | sdet@gmail.com | LmsHackathon@2024 |


  Scenario Outline: Validate Fields are displayed in LoginPage
    When Admin should see '<expectedField>'

    Examples: 
      | expectedField                   |
      | Please login to LMS application |
      | username                        |
      | password                        |
      | userfieldlabel                  |
      | passwordfieldlabel              |
      | login                           |
      | logBtnlabel                     |


  Scenario Outline: Validate loginpage color
    When Admin should see user in '<expectedField>' color

    Examples: 
      | expectedField |
      | usercolor     |
      | passwordcolor |
