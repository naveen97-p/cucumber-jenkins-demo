@US11 @new-bank
Feature: New_Bank_US11 11 Utilities/Pay a Bill Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App


  @pay-a-bill-utilities @new-bank
  Scenario Outline: US11-01 New_Bank: User can able to pay a bill via payment link on utilities option
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on utilities option on dashboard page of new Bank app
    And User provides the details of payments like "<ChooseAProvider>", "<SelectYourAccount>", "<AmountToTransfer>" and click on confirm payment
    Then User gets the verification code and verify the QR code page UI text
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
    |UserName                     |TypeOfTesting|FirstName |ChooseAProvider|SelectYourAccount|AmountToTransfer|
    |newbankregistrationviaemail16|positive     |automation|Verizon        |My Credit Card   |500.98          |

  @pay-a-bill-dashboard @new-bank
  Scenario Outline: US011-02 New_Bank: User can able to pay a bill via payment link on dashboard
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on pay a bill option on dashboard page of new Bank app
    And User provides the details of payments like "<ChooseAProvider>", "<SelectYourAccount>", "<AmountToTransfer>" and click on confirm payment
    Then User gets the verification code and verify the QR code page UI text
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |UserName                     |TypeOfTesting|FirstName |ChooseAProvider|SelectYourAccount|AmountToTransfer|
      |newbankregistrationviaemail16|positive     |automation|Alliant Gas        |My Savings Account  |100         |

