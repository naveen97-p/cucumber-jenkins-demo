@US02 @new-bank
Feature: New_Bank_US02 02 Login Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App


  @login @new-bank
  Scenario Outline: US02-01 New_Bank: Valid user should able to login the new bank application
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    Then User checks the invalid login message on login screen "<TypeOfTesting>"
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
    |UserName                     |TypeOfTesting|FirstName |
    |newbankregistrationviaemail16|positive     |automation|
    |invaliduserid                |negative     |automation|


