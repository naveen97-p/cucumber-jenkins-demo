@US12 @new-bank
Feature: New_Bank_US12 12 Transfer/Send Money Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App


  @pay-a-bill-make-a-payment-valid @new-bank
  Scenario Outline: US12-01 New_Bank: User can able to Transfer or send money
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on transfer option on dashboard page of new Bank app
    Then User clicks on make a new payment button
    Given User provides the transfer details like "<PayeeName>", "<PayeeAccountNumber>", "<ConfirmPayeeAccountNumber>", "<AmountToTransfer>", "<TypeOfTesting>" and click on continue
    Then User confirms the transaction risk
#    Given User should check inbox of "<Email>", get the OTP from Mailinator and provide the OTP to Transfer an amount
    Then User gets the Success message for the transaction
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |UserName                     |TypeOfTesting|FirstName |PayeeName|PayeeAccountNumber|ConfirmPayeeAccountNumber|AmountToTransfer|Email|
      |newbankregistrationviaemail23|positive     |automation|Automation User|123    |123                   |500             |newbankregistrationviaemail16@mailinator.com|

  @pay-a-bill-make-another-payment-valid @new-bank
  Scenario Outline: US12-02 New_Bank: User can able to make another payment again
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on transfer option on dashboard page of new Bank app
    Then User clicks on make a new payment button
    Given User provides the transfer details like "<PayeeName>", "<PayeeAccountNumber>", "<ConfirmPayeeAccountNumber>", "<AmountToTransfer>", "<TypeOfTesting>" and click on continue
    Then User confirms the transaction risk
#    Given User should check inbox of "<Email>", get the OTP from Mailinator and provide the OTP to Transfer an amount
    Then User gets the Success message for the transaction
    And User clicks on make another payment
    Then User clicks on make a new payment button
    Given User provides the transfer details like "<PayeeName>", "<PayeeAccountNumber>", "<ConfirmPayeeAccountNumber>", "<AmountToTransfer>", "<TypeOfTesting>" and click on continue
    Then User confirms the transaction risk
#    Given User should check inbox of "<Email>", get the OTP from Mailinator and provide the OTP to Transfer an amount
    Then User gets the Success message for the transaction
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |UserName                     |TypeOfTesting|FirstName |PayeeName|PayeeAccountNumber|ConfirmPayeeAccountNumber|AmountToTransfer|Email|
      |newbankregistrationviaemail23|positive     |automation|Automation User|123123      |123123                  |500             |newbankregistrationviaemail16@mailinator.com|

  @pay-a-bill-invalid @new-bank
  Scenario Outline: US12-03 New_Bank: User cannot able to Transfer or send money if User doesn't provide the same PayeeAccount Number and ConfirmPayeeAccount Number
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - static
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on transfer option on dashboard page of new Bank app
    Then User clicks on make a new payment button
    Given User provides the transfer details like "<PayeeName>", "<PayeeAccountNumber>", "<ConfirmPayeeAccountNumber>", "<AmountToTransfer>", "<TypeOfTesting>" and click on continue
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |UserName                     |TypeOfTesting|FirstName |PayeeName|PayeeAccountNumber|ConfirmPayeeAccountNumber|AmountToTransfer|
      |newbankregistrationviaemail23|negative     |automation|Automation User|123123      |123125                   |500             |
