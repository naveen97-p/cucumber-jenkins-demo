@US07 @retail-dev
Feature: Retail_Dev_US07 Progressive Profiling Behaviour Test
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEV"
#    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-progressive-profiling-dev @retail-dev
  Scenario Outline: US07-01 Retail application should complete the progressive profile behaviour of any valid customer
    Given User verifies the accessibility to Retail App
    Then User provides "<Email>" to join for the loyalty program of the Retail Dev App for Progressive Profiling
    And User should open Mailinator site and provide "<Email>", and then authorize the subscription for Progressive Profiling for Dev
    Given User provides access token to Deloitte security page
    And User provides valid email signup details like "<Email>", "<T&C>", "<ReceiveEmails>" for Progressive Profiling for Dev
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<NoUserName>" for Progressive Profiling
    Then User feeds the test data of Retail demo "<Email>", "<T&C>", "<ReceiveEmails>" to csv file for Dev
    Then User clicks on profile icon on welcome screen
    Given Go to Account Details and Update the "<FirstName>", "<LastName>", "<Mobile>", "<Address>", "<Country>", "<State>", "<City>", "<ZipCode>", "<Month>", "<Day>" details and submit the changes for Dev
    And User should provide "<Email>" to Mailinator, get the OTP from Mailinator and then authorize Change Address for Retail-Dev


    Then User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>" for Progressive test
    Then User should logout from Retail app "<TypeOfTesting>"
#    And Update the user data in Retail data
    And User opens the given URL "RETAIL_DEV"
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Email>" and password to Retail Dev App - previous
    #User fills details of Email and Password to DSAR Octa form
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>" for Progressive test
    Then User should logout from Retail app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | Email  | T&C | ReceiveEmails | TypeOfTesting |NoUserName|FirstName|LastName|Mobile|Address|Country|State|City|ZipCode|Month|Day|
      | automationciamsgodevprogressivepro@mailinator.com |True|False|positive| null|   Robinson |Padilla|919090909092|Eastern Palace Phase 1|United States|California|Los Angeles|90016|09|09|
#      | devautomationciamsgoprogressive@mailinator.com |True|False|positive| null|   Robinson |Padilla|9090909090|Eastern Palace Phase 1|United States|California|Los Angeles|90016|09|09|
