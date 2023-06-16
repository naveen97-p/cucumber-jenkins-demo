@US03 @new-bank
Feature: New_Bank_US03 03 Forget Password Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @forgot-password-valid @new-bank
  Scenario Outline: US03-01 New_Bank: User can able to get a link to setup a new password in case user forgets password
    And User verifies the new bank site is accessible
    And User clicks on ForgetPassword link on new Bank app
    Given User provides "<Email>" to forget password page and verifies the UI text information
    Then User lands on setup new password page
    Given User should check inbox of "<Email>", get the OTP from Mailinator and provide the OTP to Setup Password page
    Then User provides new password, confirm password and submit the form
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | Email |FirstName|TypeOfTesting|
      |newbankregistrationviaemail5|automation|positive|

  @forgot-password-invalid @new-bank
  Scenario Outline: US03-02 New_Bank: User shouldn't able to setup a new forget password if user doesn't meet the password policy requirement
    And User verifies the new bank site is accessible
    And User clicks on ForgetPassword link on new Bank app
    Given User provides "<Email>" to forget password page and verifies the UI text information
    Then User lands on setup new password page
    Given User should check inbox of "<Email>", get the OTP from Mailinator and provide the OTP to Setup Password page
    Then User provides invalid new password, confirm password and submit the form
    Then User terminates all windows of the browser
    Examples:
      | Email |
      |newbankregistrationviaemail6|

  @forgot-password-valid @new-bank
  Scenario Outline: US03-03 New_Bank: User shouldn't able to setup a new forget password if user provides invalid recovery token
    And User verifies the new bank site is accessible
    And User clicks on ForgetPassword link on new Bank app
    Given User provides "<Email>" to forget password page and verifies the UI text information
    Then User lands on setup new password page
    Then User provides invalid recovery token for setup new password form
    Then User terminates all windows of the browser
    Examples:
      | Email |
      |newbankregistrationviaemail7|