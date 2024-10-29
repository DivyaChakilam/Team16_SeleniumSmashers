@DashBoardPage
Feature: Dashboard Page Validation

  Background: Admin gives the correct LMS portal URL   
    Given Admin is in Home Page
    When Admin enter valid credentials and clicks login button
    
  @DashBoardtag2
  Scenario: Verify after login  admin lands on manage program as dashboard page
    Then Admin should see "LMS - Learning Management System" as header
    
  @DashBoardtag3
  Scenario: Verify the response time
    Then Maximum navigation time in milliseconds, defaults to 30 seconds in dashboard page
    
  @DashBoardtag4
  Scenario: Verify broken link
    Then HTTP response >=400.The link boken in dashboard page
    
  @DashBoardtag5
  Scenario: Verify LMS title
    Then Admin should see "LMS - Learning Management System"  as title in dashboard page
    
  @DashBoardtag6
  Scenario: Verify LMS title allignment in Dashboard page
    Then LMS title should be on the top left corner of page in dashboard page
    
  @DashBoardtag7
  Scenario: Validate navigation bar text
    Then Admin should see correct spelling in navigation bar text in dashboard page
    
  @DashBoardtag8
  Scenario: Validate LMS title has correct spelling and space
    Then Admin should see correct spelling and space in LMS title in dashboard page
    
  @DashBoardtag9
  Scenario: Validate alignment for navigation bar
    Then Admin should see the navigation bar text on the top right side in dashboard page
    
  @DashBoardtag10
  Scenario: Validate navigation bar order
    Then Admin should see 1st Program,2nd Batch ,3rd User and 4th Logout