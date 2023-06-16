@banking @US04
Feature: Banking_Demo_US04 Preferences
  Background: Banking Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "BANKING_DEMO"
#    Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for Banking App

  @banking-preferences @banking @US04
  Scenario Outline: US04-01 Banking_Verify Preferences Details form should pull the details from OneTrust accurately
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Profile link of bank app
    And User clicks on Preferences tab in account details of Bank app
    Then User verifies preferences i-frame for Banking app
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | Email |Username| FirstName | LastName | TypeOfTesting |
      |bankingautomation014@mailinator.com|bankingautomation014|James|Smith|positive|




