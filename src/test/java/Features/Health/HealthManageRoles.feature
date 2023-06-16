@US09 @health
Feature: Health_Demo_US09 Manage Roles Test

  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness

  @health-manage-roles @health
Scenario Outline: US09-01 Health_Verify the Manage roles section for Partner User and Admin
  And User clicks on login button of Health welcome screen and login as "<Role>"
  Then User verifies the login page role as "<Role>"
  And User provides username as "<UserName>" and password to Wellness App
  Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
  And User should land on the Profile details page by default
  And User clicks on Wellness Details button
  Then User verifies "<FirstName>", "<LastName>" and "<Verify Email Address>" in profile details page
  Then User clicks on Manage Roles button of Wellness
  And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
#  And User clicks on Wellness Profile icon
#  And User should land on the Profile details page by default
#  Then User clicks on Manage Roles button of Wellness
  Then User terminates all windows of the browser
Examples:
|Role        | UserName | TypeOfTesting | Verify Email Address  |FirstName|LastName|Option|Request Description|
|Partner User| kepuser  | positive      | kepuser@mailinator.com|  Kep    |  User  |kep-support-role-2    |Hi Admin, Kindly provide the kep-agent-role to me. Regards, Partner User|