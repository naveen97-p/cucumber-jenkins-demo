@US05 @retail-demo
Feature: Retail_Demo_US05 Update User Password Scenario

  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-update-password @retail-demo
  Scenario Outline: US05-01 Verify Retail user is able to update password, then login with updated password and verify user shouldn't able to login with old password

    #SignUp via Email to create a new data for Update Password
    Given User verifies the accessibility to Retail App
    And User clicks on signup button of welcome screen
    Given User must signup with Email
    And User provides valid email signup details like "<Username>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>" update password Demo
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
    Then User feeds the test data of Retail "<Username>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>" to csv file demo update password
    And User should logout from Retail app
    And User opens the given URL "RETAIL_DEMO"

    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and password to Retail Demo App update password - previous
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
    Then User clicks on profile icon on welcome screen
    And User clicks on password settings
    Given User provides old password, new password and update it
    Then User verifies the password update status as updated
    And User should logout from Retail app

   #Test--User tries to login with Updated password
    And User opens the given URL "RETAIL_DEMO"
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and new password to Retail Demo App update password
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
    And User should logout from Retail app
   #Test--User tries to login with old password and site should not allow
    And User opens the given URL "RETAIL_DEMO"
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and old password to Retail Demo App update password
    And User Should able to login with "negative" approach and should not land on Retail home page
    Then User terminates the browser

    Examples:
      | Username                 | TypeOfTesting | FirstName  | LastName | T&C | ReceiveEmails |
     | retaildemoupdatepassword@mailinator.com | positive      | automation |automation|True|False  |

