@US01 @banking
Feature: Banking_Demo_US01 SignUp
  Background: Banking Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "BANKING_DEMO"
#    Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for Banking App

  @banking-signup-email-valid @banking
  Scenario Outline: US01-01 Banking Sign-up via Email with valid and invalid data
    And User lands on Welcome page of Bank application
    Then User clicks on signup button on Welcome page of Bank app
    And User tries for sign-up with email
    Given User provides "<Email>" on Sign-up Email page of Bank app and check if the message has been sent
    And Open Mailinator and provide "<Email>" then complete signup through magic link
    And User provides sign-up details like "<Username>", "<FirstName>", "<LastName>", password and "<T&C>"
    And User Should able to login with "<TypeOfTesting>" approach and should land on Banking home page and pass firstname "<FirstName>", "<LastName>"
    Then User feeds the test data of Banking "<Email>", "<Username>", "<FirstName>", "<LastName>","<T&C>" to csv file "<TypeOfTesting>"
    And Verify the registered details should be populated in Account details section "<TypeOfTesting>", "<Email>", "<FirstName>", "<LastName>"
    Then User logs out from Banking app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | Email |Username| FirstName | LastName | T&C | TypeOfTesting |
      |bankingautomation027@mailinator.com|bankingautomation027|James|Smith|True|positive|
      |bankingautomation003@mailinator.com|bankingautomation003|naveen|kumar|True|negative|