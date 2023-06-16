@US04 @health
Feature: Health_Demo_US04 Update Details Test

  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness

  @health-update-details @health
  Scenario Outline: US04-01 Health_Verify the profile details like Firstname, Lastname and Email address of any user
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<UserName>" and password to Wellness App
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User clicks on Wellness Profile icon
    And User should land on the Profile details page by default
    Then User verifies "<FirstName>", "<LastName>" and "<Verify Email Address>" in profile details page
    And User should logout from Wellness app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Role        | UserName | TypeOfTesting | Verify Email Address  |FirstName|LastName|
#      |Partner User| kepuser  | positive      | kepuser@mailinator.com|    Kep     |  User      |
      |Patient| patientstrange5  | positive      |  patientstrange5@mailinator.com  |naveen   |kumar       |

  @health-update-address-details @health
  Scenario Outline: US04-02 Health_Update the profile address details and verify the changes should be reflected
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"

    And User should land on the Profile details page by default
    And User clicks on Wellness Details button
    Then User verifies "<FirstName>", "<LastName>" and "<Verify Email Address>" in profile details page
    Given User provides address details like "<Mobile No>", "<Address>", "<City>", "<State>", "<Zip Code>","<Country>" then submit it
    Then User verifies "<Mobile No>", "<Address>", "<City>", "<State>", "<Zip Code>","<Country>" in profile details page
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"

    And User logins as "<Role>" on Wellness App
    And User provides username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should land on the Profile details page by default
    And User clicks on Wellness Details button
    Then User verifies "<Mobile No>", "<Address>", "<City>", "<State>", "<Zip Code>","<Country>" in profile details page
    Then User terminates all windows of the browser
    Examples:
      |Role        | UserName | TypeOfTesting | Verify Email Address  |FirstName|LastName|Mobile No|Address|City|State|Zip Code|Country|
      |Partner User| kepuser  | positive      | kepuser@mailinator.com|  Kep    |  User  | +12342342343  |Maple Street One |Springfield |Illinois | 60001       |   United States    |


#Change of Password isn't working

  @health-update-password-details @health
  Scenario Outline: US04-03 Health_Update the New Password and verify the changes should be reflected
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<UserName>" and password to Wellness App
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should land on the Profile details page by default
    And User clicks on Wellness Details button
    Then User verifies "<FirstName>", "<LastName>" and "<Verify Email Address>" in profile details page
    Given User provides new password then submit it
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"

    And User logins as "<Role>" on Wellness App
    And User provides username as "<UserName>" and new password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should land on the Profile details page by default
    And User clicks on Wellness Details button
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
    Then User terminates all windows of the browser
    Examples:
      |Role        | UserName | TypeOfTesting | Verify Email Address  |FirstName|LastName|
      |Partner User| kepuser  | positive      | kepuser@mailinator.com|  Kep    |  User  |



