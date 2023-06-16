@US10 @new-bank
Feature: New_Bank_US10 09 Delegate Access Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @delegate-access @new-bank
  Scenario Outline: US10-01 New_Bank: User can able to add an authorized user in the delegate access section
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    And User clicks on Delegate Access tab in account details of new Bank app
    And User waits until the Delegate access section to be opened
    Then User adds a new member in delegate access section to transfer an amount
    Given User provides authorized user details like "<AuthorizedFirstName>", "<AuthorizedLastName>", "<AuthorizedEmail>", "<AuthorizedTransferLimit>" and clicks on add button
    Then User verifies the success message on Delegate access screen
    Then User clicks on back button of Delegate Access page
    Then User verifies the availability of the Delegate user details like "<AuthorizedFirstName>", "<AuthorizedLastName>", "<AuthorizedEmail>", "<AuthorizedTransferLimit>"
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email                                       | TypeOfTesting |UserName|FirstName|LastName|AuthorizedFirstName|AuthorizedLastName|AuthorizedEmail|AuthorizedTransferLimit|
      | EMAIL            | newbankregistrationviaemail@mailinator.com | positive      |newbankregistrationviaemail|automation|automation|John|Mayer         |johnmayer234@yahoo.com|500             |


  @delegate-access-delete-user @new-bank
  Scenario Outline: US10-02 New_Bank: User can able to add and delete an authorized user in the delegate access section
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    And User clicks on Delegate Access tab in account details of new Bank app
    And User waits until the Delegate access section to be opened
    Then User adds a new member in delegate access section to transfer an amount
    Given User provides authorized user details like "<AuthorizedFirstName>", "<AuthorizedLastName>", "<AuthorizedEmail>", "<AuthorizedTransferLimit>" and clicks on add button
    Then User verifies the success message on Delegate access screen
    Then User clicks on back button of Delegate Access page
    Then User verifies the availability of the Delegate user details like "<AuthorizedFirstName>", "<AuthorizedLastName>", "<AuthorizedEmail>", "<AuthorizedTransferLimit>"
#    Deletion should be happened here
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email                                       | TypeOfTesting |UserName|FirstName|LastName|AuthorizedFirstName|AuthorizedLastName|AuthorizedEmail|AuthorizedTransferLimit|
      | EMAIL            | newbankregistrationviaemail@mailinator.com | positive      |newbankregistrationviaemail|automation|automation|John|Mayer         |johnmayer234@yahoo.com|500             |

