Feature: SimplifyQA Tool Login and Profile Validation


Background:
 Given the user is on the SimplifyQA login page
 Then  page title should be "SimplifyQA"


  Scenario: Successful login with valid credentials
   
    Given the user enters a valid username and password and companyname
    When clicks on the login button
    Then I should be loggged in successfully and validate profile name "geetha.t@simplify3x.com"
    Then Logout from the Application

    
  Scenario Outline: UnSuccessful login with Invalid credentials
   
    Given the user enters a valid "<username>" and "<companyname>" and "<password>"
    Then I should see an error message indicated "<errormessage>"
    
    Examples:
    |username                |companyname  |password     |errormessage        |
    |geetha@simplify3x.com   |SQATest      |GEEtha!@#12  |Invalid credentials!|
    |geetha.t@simplify3x.com |SQATest      |geetha!@#12  |Invalid credentials!|
    |geetha@simplify3x.com   |SQATest      |geetha123    |Invalid credentials!|
  
    
    