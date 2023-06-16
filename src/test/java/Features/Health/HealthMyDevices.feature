@US05 @health
Feature: Health_Demo_US05 My Devices Test

  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness



  @health-my-devices @health
  Scenario Outline: US05-01 Health_Verify the My Devices section for Partner Admin
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<UserName>" and password to Wellness App
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User clicks on Wellness Profile icon
    And User clicks on Wellness Details button
#    And User should land on the Profile details page by default
    Then User verifies "<FirstName>", "<LastName>" and "<Verify Email Address>" in profile details page
    Then User clicks on My Devices button of Wellness
    And Verify the push notification device name as "<Push Device Name>"
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
    Then User terminates all windows of the browser
    Examples:
      |Role        | UserName | TypeOfTesting | Verify Email Address  |FirstName|LastName|Push Device Name|
      |Partner Admin| kepadmin  | positive      | kep@mailinator.com|  Kep    |  Admin  |Push Device    |
#      |Partner User| kepuser  | positive      | kepuser@mailinator.com|  Kep    |  User  |Push Device    |
#      |App Admin| appadmin  | positive      | appa@mailinator.com|  App    |  Admin  |Push Device    |