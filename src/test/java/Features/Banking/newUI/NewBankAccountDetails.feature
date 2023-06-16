@US05 @new-bank
Feature: New_Bank_US05 05 Account Details Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @account-details @new-bank
  Scenario Outline: US05-01 New_Bank: Account details should be appeared as expected
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    Then User verifies the account details page in all sections
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | UserName                     | TypeOfTesting |FirstName|
      | newbankregistrationviaemail7 | positive      |automation|


