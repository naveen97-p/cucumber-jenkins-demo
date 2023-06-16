@health @US06
Feature: Health_Demo_US06 Privacy And Consent Test
  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness


  @health-privacy-consent-details
  Scenario Outline: US06-01 Health_Verify the Privacy & Consent Details, form should pull the details from OneTrust accurately
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<UserName>" and password to Wellness App
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User clicks on Wellness Profile icon
    And User should land on the Profile details page by default
    Then User verifies "<FirstName>", "<LastName>" and "<Verify Email Address>" in profile details page
    Then User clicks on privacy and consent button of Wellness
    Then Verify that details should appear from OneTrust in Privacy and Consent section
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
    Then User terminates the browser

    Examples:
      |Role        | UserName | TypeOfTesting | Verify Email Address  |FirstName|LastName|
#      |App Admin| appadmin  | positive      | appa@mailinator.com|  app    |  admin  |
#      |Doctor| doctorstrange5  | positive      |  doctorstrange5@mailinator.com  |naveen|  kumar |
#      |Patient| patientstrange5  | positive      |  patientstrange5@mailinator.com  |naveen |  kumar |
      |Doctor|doctorcheck47 | positive      | doctorcheck47@mailinator.com|doctor   |  registration   |


