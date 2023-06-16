@US01 @new-bank
Feature: New_Bank_US01 01 Open An Account Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @open-an-account-govt-id @new-bank
  Scenario Outline: US01-01 New_Bank: Customer should open a new account by providing Gov.t ID and then verify the QR Code should be generated
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides the "<Email>" to complete the verification "<TypeOfTesting>" and continue
    Then User completes Identity Verification for "<Email>" and clicks on continue "<TypeOfTesting>"
    Then User clicks waits for QR code to appear along with the secret code "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
    |ModeOfRegistration|Email                                           |TypeOfTesting            |
    |     GOVT_ID      |  newbankregistrationviagovtid@mailinator.com   |      positive           |
    |     GOVT_ID      |  pleasedude@mailinator.com                     |      negative           |

  @open-an-account-email-mfa @new-bank
  Scenario Outline: US01-02 New_Bank: Customer should open a new account by providing email for MFA verification and then verify the user should be logged-in to the platform
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    Then Verify the "<Email>", "<FirstName>", "<LastName>" and "<TypeOfTesting>" of logged-in user details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email                                       | TypeOfTesting |UserName|FirstName|LastName|
      | EMAIL            | newbankregistrationviaemail@mailinator.com | positive      |newbankregistrationviaemail|automation|automation|
      | EMAIL            | pleasedude@mailinator.com                   | negative      |newbankregistrationviaemail|automation|automation|


