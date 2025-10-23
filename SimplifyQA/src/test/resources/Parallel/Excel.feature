

Feature: User Authentication with Excel Data

@regression
  Scenario Outline: Successful Login using data from an Excel Sheet
   Given the user is on the SimplifyQA login page
    Given the user enters a valid "<SheetName>" and <Rownumber>
    Then I should see an error message indicated "Invalid credentials!"
   

    Examples:
    |SheetName|Rownumber|
    |logindata|0|
    |logindata|1|
    |logindata|2|          