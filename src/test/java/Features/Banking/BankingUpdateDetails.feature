@US03 @banking
Feature: Banking_Demo_US03 Update Details
  Background: Banking Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "BANKING_DEMO"
#    Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for Banking App

  @banking-update-address @banking
  Scenario Outline: US03-01 Banking: Verify the Change of Address feature in Account Details
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Profile link of bank app
    Given add or update the address details like "<Mobile No>", "<Address>", "<OptAddress>" "<City>", "<State>", "<Zip Code>","<Country>" in account details page of bank app
    Then Verify the address details are updated as expected "<Mobile No>", "<Address>", "<OptAddress>", "<City>", "<State>", "<Zip Code>","<Country>" of bank app
    Then User logs out from Banking app "<TypeOfTesting>"
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Profile link of bank app
    Then Verify the address details are updated as expected "<Mobile No>", "<Address>", "<OptAddress>", "<City>", "<State>", "<Zip Code>","<Country>" of bank app
    Then User logs out from Banking app "<TypeOfTesting>"
    And User lands on login page of Bank Application
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |Mobile No|Address|OptAddress|City|State|Zip Code|Country|
      |bankingautomation003|naveen|kumar|positive|+19999999999|One Lane|Baker Street|Montgomery|Alabama|95009|United States|
#      |bankingautomation001|naveen|kumar|positive||Fourth Lane||Montgomery|Alabama|35004|United States|


  @banking-update-password @banking
  Scenario Outline: US03-02 Banking: Verify the Change of Password feature in Account Details
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
     # Login with Old Password
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And User clicks on Profile link of bank app
    Given add or update the password for bank app
    Then User logs out from Banking app "<TypeOfTesting>"
    And User lands on login page of Bank Application
    # Login with New Password
    Given provides "<Username>", new password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    Then User logs out from Banking app "<TypeOfTesting>"
    And User lands on login page of Bank Application
    Then User terminates all windows of the browser
    Examples:
      |Username| FirstName | LastName | TypeOfTesting |
      |bankingautomation001|naveen|kumar|positive|






