@US02 @retail-demo
Feature: Retail_Demo_US02 Facebook Login Test
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @facebook-login @retail-demo
  Scenario Outline: US02-01 Retail Facebook login Test
    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    Given User continues login with Facebook
    Then User provides facebook username "<FacebookUsername>" and password and logs in
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
    And User should logout from Retail app
    Then User should sign out from Facebook account
    And User opens the given URL "RETAIL_DEMO"
    And User clicks on login button of Retail welcome screen
    Given User continues login with Facebook
    Then User facebook account should not be active
    Then User terminates all windows of the browser

    Examples:
      |  FacebookUsername     |TypeOfTesting | Firstname |
      |ciamsgo001@gmail.com|positive      | John|
