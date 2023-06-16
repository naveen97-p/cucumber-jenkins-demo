@US02 @banking
Feature: Banking_Demo_US02 Login
  Background: Banking Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "BANKING_DEMO"
#    Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for Banking App

  @banking-login-email-valid @banking
  Scenario Outline: US02-01 Banking Login with Username and Password test
    And User lands on Welcome page of Bank application
    Then User clicks on login button on Welcome page of Bank app
    And User lands on login page of Bank Application
    Given provides "<Username>", password then login
    And User should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>" for Login
    And Verify the registered details should be populated in Account details section "<TypeOfTesting>", "<Email>", "<FirstName>", "<LastName>"
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | Email |Username| FirstName | LastName | TypeOfTesting |
      |bankingautomation003@mailinator.com|bankingautomation003|naveen|kumar|positive|























    #      |bankingautomation0078@mailinator.com|bankingautomation086|naveen|kumar|negative|





