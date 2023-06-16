@US01 @retail-demo
Feature: Retail_Demo_US01 Login Test Scenario
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

 @retail-email-login @retail-demo
  Scenario Outline: US01-01 Retail Email login Test with Username and Password
   Given User verifies the accessibility to Retail App
   And User clicks on login button of Retail welcome screen
   And User provides username as "<Username>" and password to Retail App - static
   And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
   And User should logout from Retail app "<TypeOfTesting>"
   Then User terminates all windows of the browser
   Examples:
     | Username |TypeOfTesting|Firstname|
     |automationciamsgo1@mailinator.com|positive|automation|


  @retail-email-login-invalid @retail-demo
  Scenario Outline: US01-02 Retail Email login Test with Invalid Username(different domain) and Valid Password
    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and password to Retail App - static
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
    And User should logout from Retail app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | Username |TypeOfTesting|Firstname|
      |testdata1@gmail.com|negative|automation|









