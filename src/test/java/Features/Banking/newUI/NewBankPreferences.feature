@US07 @new-bank
Feature: New_Bank_US07 07 Preferences Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK" with CORS Unblock Plugin "BANK_PREF"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @preferences @new-bank
  Scenario Outline: US07-01 New_Bank: User completes the Preferences check
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    Then User clicks on profile option on dashboard page of new Bank app
    Then User clicks on Preferences tab in account details of new Bank app
    And User waits until the Preferences i-frame appears and validate the details for new Bank app
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |UserName                     |TypeOfTesting|FirstName |
      |newbankregistrationviaemail17|positive     |automation|



