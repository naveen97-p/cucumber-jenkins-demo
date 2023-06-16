@US01 @health
Feature: Health_Demo_US01 Login Test

  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness

  @health-login-partner-user @health @demo
  Scenario Outline: US01-01 Health_Partner User login test with username and password
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<Username>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
    Then User terminates all windows of the browser
    Examples:
      |Role        | Username | TypeOfTesting | Verify Email Address  |
      |Partner User| kepuser  | positive      | kepuser@mailinator.com|


  @health-login-partner-admin @health @demo
  Scenario Outline: US01-02 Health_Partner Admin login test with username and password
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    And User provides username as "<Username>" and password to Wellness App
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
    Then User terminates all windows of the browser
    Examples:
      |Role         | Username| TypeOfTesting | Verify Email Address   |
      |Partner Admin|kepadmin | positive      | kepadmin@mailinator.com|


#
#  @health-login-patient @health
#  Scenario Outline: US01-03 Health_Patient login test with username and password
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    And User provides username as "<Username>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   | Username         | TypeOfTesting | Verify Email Address  |
#      |Patient| patientstrange5  | positive      |  appa@mailinator.com  |
#
#
#  @health-login-doctor @health
#  Scenario Outline: US01-04 Health_Doctor login test with username and password
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    And User provides username as "<Username>" and password to Wellness App
##    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role  | Username        | TypeOfTesting | Verify Email Address  |
#      |Doctor| doctorstrange5  | positive      |  doctorstrange5@mailinator.com  |


#  @health-login-app-admin @health
#  Scenario Outline: US01-03 Health_Application Admin login test with username and password
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    And User provides username as "<Username>" and password to Wellness App
##    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>" and "<Role>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role     | Username  | TypeOfTesting | Verify Email Address  |
#      |App Admin| majormovie7  | positive      |  appa@mailinator.com  |









