@US02  @health
Feature: Health_Demo_US02 Register Test

  Background: Wellness Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "HEALTH_DEMO"
    Given User provides access token to Deloitte security page for Wellness


  @health-register-patient  @health
  Scenario Outline: US02-01 Health_Patient Register & Login test
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    Given User clicks on Register button of Health Application
    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
    And User would like to configure as Skip For Now button and submit
    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
      |Patient|healthdemopatientregister@mailinator.com           |health   |registration   |healthdemopatientregister          |true |false          |positive      |
#      |Doctor|healthdoctorregister@mailinator.com           |nopain   |nogain   |healthdoctorregister          |true |false          |positive      |
#      |Partner User|healthpartneruserregister@mailinator.com        |useful   |user   |healthpartneruserregister         |true |false          |positive      |
#      |Partner Admin|healthpartneradminregister@mailinator.com         |msdhoni   |cricketer   |   healthpartneradminregister        |true |false          |positive      |
#      |App Admin|healthappadminregister@mailinator.com         |google   |test   |healthappadminregister           |true |false          |positive      |
#


  @health-register-doctor @health
  Scenario Outline: US02-02 Health_Doctor Register & Login test
    And User clicks on login button of Health welcome screen and login as "<Role>"
    Then User verifies the login page role as "<Role>"
    Given User clicks on Register button of Health Application
    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
    And User would like to configure as Skip For Now button and submit
    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
    And User should logout from Wellness app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
      |Doctor|healthdemodoctorregister@mailinator.com           |health   |registration   |healthdemodoctorregister           |true |false          |positive      |






#
#  @health-register-partner-user
#  Scenario Outline: US02-03 Health_Partner User Register & Login test
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    Given User clicks on Register button of Health Application
#    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
#    And User would like to configure as Skip For Now button and submit
#    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
#      |Partner User|partnerusercheck1@mailinator.com           |naveen   |kumar   |partnerusercheck1           |true |false          |positive      |
#
#
#  @health-register-partner-admin @health
#  Scenario Outline: US02-04 Health_Partner Admin Register & Login test
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    Given User clicks on Register button of Health Application
#    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
#    And User would like to configure as Skip For Now button and submit
#    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   |Email              |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
#      |Partner Admin|partneradmincheck1@mailinator.com |naveen   |kumar   |partneradmincheck1           |true |false          |positive      |
#
#  @health-register-app-admin @health
#  Scenario Outline: US02-05 Health_Application Admin Register & Login test
#    And User clicks on login button of Health welcome screen and login as "<Role>"
#    Then User verifies the login page role as "<Role>"
#    Given User clicks on Register button of Health Application
#    And User provides valid registration details like "<Email>", "<FirstName>", "<LastName>","<UserName>","<T&C>","<ReceiveEmails>"
#    #Then Email verification if it is required "<Verify Email Address>" "<TypeOfTesting>"
#    And User would like to configure as Skip For Now button and submit
#    Then User feeds the test data of Wellness "<Role>", "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<T&C>","<ReceiveEmails>", "<TypeOfTesting>" to csv file
#    Then User should land on the Home page with role accessibility as "<Role>" with testing type as "<TypeOfTesting>"
#    And User should logout from Wellness app "<TypeOfTesting>"
#    Then User terminates all windows of the browser
#    Examples:
#      |Role   |Email                         |FirstName|LastName|UserName       |T&C  | ReceiveEmails |TypeOfTesting |
#      |App Admin|appadmin1@mailinator.com           |naveen   |kumar   |appadmin1           |true |false          |positive      |




