Feature: SimplifyQA Tool Login and Profile Validation


Background:
 Given the user is on the SimplifyQA login page
 Then  page title should be "SimplifyQA"


  Scenario: Successful login with valid credentials
   
    Given the user enters a valid username and password and companyname
    When clicks on the login button
    Then I should be loggged in successfully and validate profile name "geetha.t@simplify3x.com"
    Then Logout from the Application