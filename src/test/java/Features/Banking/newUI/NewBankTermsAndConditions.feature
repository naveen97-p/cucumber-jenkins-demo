@US04 @new-bank
Feature: New_Bank_US04 04 Terms And Conditions Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App


  @terms-and-condition-govt @new-bank
  Scenario Outline: US04-01 New_Bank: T&C link should be worked and information should be appeared as expected
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    And User clicks on Terms and Condition link on Welcome On Board Page
    Then User opens Terms and Conditions page in new window, Page URL and Information should be appeared as expected
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration |
      | GOVT_ID            |

  @terms-and-condition-email-mfa @new-bank
  Scenario Outline: US04-02 New_Bank: T&C link should be worked and information should be appeared as expected
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    And User clicks on Terms and Condition link on Registration Welcome On Board Page
    Then User opens Terms and Conditions page in new window, Page URL and Information should be appeared as expected
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration |
      | EMAIL            |
