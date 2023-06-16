@US07 @banking
Feature: Banking_Demo_US07 Transfers
  Background: Banking Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "BANKING_DEMO"
#    Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for Banking App


  @banking-in-house-transfers-start-transfer @banking
  Scenario Outline: US07-01 Banking_Verify In-House Transfers(Enter details to start transfer)
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Transfers link of bank app
    Then User clicks on In-House Transfer category
    Given User provides the details like "<TransferTo>", "<SelectAccount>", "<Amount>" to start transfer and confirm
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |TransferTo|SelectAccount|Amount|
      |bankingautomation020|James|Smith|positive|Personal Account|Robinson's Account|500|

  @banking-in-house-transfers-add-new-account @banking
  Scenario Outline: US07-02 Banking_Verify In-House Transfers(Add new account to transfer money)
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Transfers link of bank app
    Then User clicks on In-House Transfer category
    Given User provides the details like "<AddNewAccount>", "<AccountNickname>", "<OneTimeCode>" to add new account to transfer money and confirm
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |AddNewAccount|AccountNickname|OneTimeCode|
      |bankingautomation020|James|Smith|positive|Automation Account|Test Account   |909090     |


  @banking-in-house-transfers-at-other-banks-in-us @banking
  Scenario Outline: US07-03 Banking_Verify To/From Accounts at other banks(IN the U.S.)
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Transfers link of bank app
    Then User clicks on To or From-accounts-at-other-banks Transfer category
    Then User selects IN THE US options
    And User verifies all types of transfer modes for IN THE US category
    Given User provides the details like "<SelectAccount>", "<TransferTo>", "<Amount>" to all types of transfer and confirm for all
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |TransferTo|SelectAccount|Amount|
      |bankingautomation020|James|Smith|positive|Personal Account|Robinson's Account|500|


  @banking-in-house-transfers-at-other-banks-outside-us @banking
  Scenario Outline: US07-04 Banking_Verify To/From Accounts at other banks(OUTSIDE the U.S.)
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Transfers link of bank app
    Then User clicks on To or From-accounts-at-other-banks Transfer category
    Then User selects OUTSIDE THE US options
    Given User provides the details like "<AccountHolderName>", "<RoutingNo>", "<WireNo>", "<Country>", "<Amount>" to wiring instructions and confirm
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |AccountHolderName|RoutingNo|WireNo|Country|Amount|
      |bankingautomation020|James|Smith|positive|Peter Parker          |1000000091|7898789898|United States|590|


  @banking-in-house-transfers-to-business-or-organization @banking
  Scenario Outline: US07-05 Banking_Verify To Someone Else Transfer(To Business or Organization Transfer)
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Transfers link of bank app
    Then User clicks on To-Someone-else Transfer category
    Given User provides the details like "<AccountHolderName>", "<RoutingNo>", "<WireNo>", "<Country>", "<Amount>" to transfer to Business or Organization and confirm
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |AccountHolderName|RoutingNo|WireNo|Country|Amount|
      |bankingautomation020|James|Smith|positive|Peter Parker |1000000091|7898789898|United States|590|

