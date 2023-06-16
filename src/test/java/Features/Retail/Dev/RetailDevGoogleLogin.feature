Feature: Retail_Dev_US03 Google Login Test


  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEV"
#    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  Scenario Outline: US03-01 Retail Google login Test
    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    Given User continues login with Google
    Then User provides google username "<GoogleUsername>" and password and logs in
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
    And User should logout from Retail app
    Then User should sign out from Gmail account
    And User opens the given URL "RETAIL_DEV"
    Then User terminates all windows of the browser


    Examples:
      |  GoogleUsername     |TypeOfTesting | Firstname |
      |testmail89@gmail.com|positive  | Social    |
