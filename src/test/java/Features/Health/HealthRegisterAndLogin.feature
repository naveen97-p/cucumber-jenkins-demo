@US03 @health
Feature: Health_Demo_US03 Register & Login Test

  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness

  @health-register-login-patient @health
  Scenario Outline: US03-01 Health_Patient Register & Login test
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    Given User clicks on Register button of Health Application
    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
    And User would like to configure as Skip For Now button and submit
    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>"
    And User provides previous username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
      |Patient|healthdemoregister@mailinator.com           |health   |registration   |healthdemoregister          |true |false          |positive      |



  @health-register-login-doctor @health
  Scenario Outline: US03-02 Health_Doctor Register & Login test
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    Given User clicks on Register button of Health Application
    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
    And User would like to configure as Skip For Now button and submit
    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>"
    And User provides previous username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
      |Doctor|healthdemoregister@mailinator.com           |health   |registration   |healthdemoregister          |true |false          |positive      |




#  @health-register-login-partner-user @health
#  Scenario Outline: US03-03 Health_Partner User Register & Login test
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    Given User clicks on Register button of Health Application
#    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#   And User would like to configure as Skip For Now button and submit
#    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    And User provides previous username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
#      |Partner User|majormovie32@mailinator.com   |majormovie   |test   |majormovie32 |true|false          |positive     |
#
#
#
#
#  @health-register-login-partner-admin @health
#  Scenario Outline: US03-04 Health_Partner Admin Register & Login test
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    Given User clicks on Register button of Health Application
#    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#    And User would like to configure as Skip For Now button and submit
#    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    And User provides previous username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
#      |Partner Admin|majormovie33@mailinator.com  |majormovie   |test   |majormovie33   |true|false          |positive     |
#
#
#
#  @health-register-login-app-admin @health
#  Scenario Outline: US03-05 Health_Application Admin Register & Login test
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    Given User clicks on Register button of Health Application
#    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#    And User would like to configure as Skip For Now button and submit
#    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    And User provides previous username as "<UserName>" and password to Wellness App
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
#      |App Admin|majormovie34@mailinator.com|majormovie   |test   |majormovie34          |true|false          |positive     |
#
