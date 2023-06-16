@US09 @new-bank
Feature: New_Bank_US09 09 MyDevices Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @add-and-delete-email-mfa @new-bank
  Scenario Outline: US09-01 New_Bank: Create an account then add email as MFA device and delete it
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    And User clicks on MyDevices tab in account details of new Bank app

    Then User verifies the myDevices page and clicks on add new email as a MFA source
    And User should check inbox of "<Email>", get the OTP from Mailinator and provide the OTP to add MFA device and click on finish
    Then User verifies the availability of email MFA device
    And User deletes the added MFA device
    Then User verifies there should not be any MFA device listed
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email                                       | TypeOfTesting |UserName|FirstName|LastName|
      | EMAIL            | newbankregistrationviaemail@mailinator.com | positive      |newbankregistrationviaemail|automation|automation|

  @set-nickname-mfa-device @new-bank
  Scenario Outline: US09-02 New_Bank: User can set up nick name for a registered MFA device
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    And User clicks on MyDevices tab in account details of new Bank app
    Then User verifies the Email MFA device should be available
    Then User setup a random nick name and verifies the updated nick name
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |UserName                     |TypeOfTesting|FirstName |
      |newbankregistrationviaemail20|positive     |automation|
