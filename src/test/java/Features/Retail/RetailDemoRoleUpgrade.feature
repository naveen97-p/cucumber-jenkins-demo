@US09 @retail-demo
Feature: Retail_Demo_US09 Role Upgrade Test

  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-role-upgrade @retail-demo
  Scenario Outline: US09-01 Verify Retail User Role Upgrade Journey
    #SignUp via Email to create a new data for Role Upgrade
    Given User verifies the accessibility to Retail App
    And User clicks on signup button of welcome screen
    Given User must signup with Email
    And User provides valid email signup details like "<Username>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>"
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
    Then User feeds the test data of Retail "<Username>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>" to csv file
    And User should logout from Retail app
    And User opens the given URL "RETAIL_DEMO"

    #Role Upgrade Test
    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and password to Retail App - previous
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
    Then User clicks on profile icon on welcome screen
    And User verifies Premium Customer Tag should not be appeared for normal user
    Then User clicks on Climb Credit Card
    Given User agrees for T&C and provides SSN "<SSN Number>" for credit card
    Then Verify the card details parameters
    And User clicks on profile icon on welcome screen
    And User verifies Premium Customer Tag should be appeared for premium user as the user has opted for Credit card
    Then User clicks on Climb Credit Card
    Then Verify the card details parameters
    And User should logout from Retail app
   #Test--User verifies Premium User Tag and Credit card should be available
    And User opens the given URL "RETAIL_DEMO"
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and password to Retail App - previous

    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"

    Then User clicks on profile icon on welcome screen
    And User verifies Premium Customer Tag should be appeared for premium user as the user has opted for Credit card
    Then User clicks on Climb Credit Card
    Then Verify the card details parameters
    And User should logout from Retail app

    Then User terminates all windows of the browser
    Examples:
      | Username                 | TypeOfTesting   |SSN Number| FirstName | LastName | T&C | ReceiveEmails |
      | automationdemociamsgoroleupgrade@mailinator.com | positive |9090909090|automation|automation|True|False|
