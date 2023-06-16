@US07 @health
Feature: Health_Demo_US07 B2B Test
  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness

  @health-enroll-partner-admin @health @demo
  Scenario Outline: US07-01 Health_B2B Enrolling Organization and Admin test
    And User clicks on Enroll Partner Admin
    Then User provides Registration Code to Wellness app
    Given User provides the details of Organization like "<Org Name>", "<Org Address>", Admin information like "<Admin UserName>", "<Admin FirstName>", "<Admin LastName>", "<Admin Email>", "<Admin Mobile No>" and select portal as "<Portal Option>" then submit
    And User should verify the submit request of Onboard Partner Admin request on Wellness app "<TypeOfTesting>"
    Then User terminates the browser
    Examples:
      | Org Name | Org Address | Admin UserName | Admin FirstName | Admin LastName | Admin Email | Admin Mobile No | Portal Option | TypeOfTesting |
    |Auto Health Pvt Ltd New|Mac OS Venue One|autoadmin|naveen          |kumar           |autotest1@mailinator.com|9098909880|Health Care    |positive       |


  @health-enroll-partner-user @health @demo
  Scenario Outline: US07-02 Health_B2B Enrolling Organization User Test
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<Username>" and password to Wellness App
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User clicks on Onboard A Partner User
    Given User provides onboard user details of Organization like "<Org Name>", Admin information like "<Admin UserName>", "<Admin FirstName>", "<Admin LastName>", "<Admin Email>", "<Admin Mobile No>" and select portal as "<Portal Option>" then submit
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
    Then User terminates the browser
    Examples:
      | Role       | Username | TypeOfTesting | Org Name        | Admin UserName | Admin FirstName| Admin LastName | Admin Email            | Admin Mobile No | Portal Option |
#     |Partner Admin|kepadmin   |positive       |KEP Healthcare|autoadmin       |naveen          |kumar           |autotest1@mailinator.com|9897969594       |kep-support-role-2|
      |Partner Admin|kepadmin   |positive       |KEP Healthcare|autoadmin       |naveen          |kumar           |autotest1@mailinator.com|9897969594       |kep-staff-role   |
#      |Partner Admin|kepadmin   |positive       |KEP Healthcare|autoadmin       |naveen          |kumar           |autotest1@mailinator.com|9897969594       |kep-support-role |
#      |Partner Admin|kepadmin   |positive       |KEP Healthcare|autoadmin       |naveen          |kumar           |autotest1@mailinator.com|9897969594       |kep-agent-role|
