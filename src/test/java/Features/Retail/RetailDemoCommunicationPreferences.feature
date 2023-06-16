@US10 @retail-demo
Feature: Retail_Demo_US10 Communication Preferences Test
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-communication-preferences  @retail-demo
  Scenario Outline: US06-01 Retail User should have an flexibility to change the communication preferences
    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and password to Retail App - static
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
    Then User clicks on profile icon on welcome screen
    And User clicks on Communication Preferences
    And User verifies the One Trust I-frame for Communication Preferences for Email, Mobile and enable all preferences
#    And User clicks on password settings
#    And User clicks on Communication Preferences
#    Then User reverts all preferences back to normal and save
    And User should logout from Retail app
    Then User terminates all windows of the browser

    Examples:
      | Username | TypeOfTesting | Firstname |
      | automationdemociamsgo164@mailinator.com | positive      | automation |
