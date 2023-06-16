@US08 @banking
Feature: Banking_Demo_US08 Brokerage Account
  Background: Banking Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "BANKING_DEMO"
#    Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for Banking App

@banking-brokerage-account @banking
    Scenario Outline: US08-01 Banking: Verify the Brokerage Account Journey
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    #Apply for Brokerage Account
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    Then Verify Premium Customer tag should not be appeared for Normal Users of Banking app
    And User clicks on Brokerage Account link of bank app
    And User agrees for T&C, and check the account subscription details
    Then Verify the Brokerage Account should be created
    And Verify all sections, services of Brokerage account of Banking App
    And User clicks on Profile link of bank app
    Then Verify Premium Customer tag should be appeared for Premium Users of Banking app
    And User clicks on Brokerage Account link of bank app
    Then Verify the Brokerage Account should be created
    And Verify all sections, services of Brokerage account of Banking App
    Then User logs out from Banking app "<TypeOfTesting>"
    And User lands on login page of Bank Application
    # Check Brokerage Account should be available
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    Then Verify Premium Customer tag should be appeared for Premium Users of Banking app
    And User clicks on Brokerage Account link of bank app
    Then Verify the Brokerage Account should be created
    And Verify all sections, services of Brokerage account of Banking App
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Then User check the stepdefinition creation

    Examples:
    |Username| FirstName | LastName | TypeOfTesting |

    |bankingautomation022|James|Smith|positive|
#    |bankingautomation023|James|Smith|positive|

