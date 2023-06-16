@US04 @retail-demo
Feature: Retail_Demo_US04 SignUp
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-signup-email-valid @retail-demo
  Scenario Outline: US04-01 Retail Sign-up via Email with Valid data
    Given User verifies the accessibility to Retail App
    And User clicks on signup button of welcome screen
    Given User must signup with Email
    And User provides valid email signup details like "<Username/Email>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>"
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
    Then User feeds the test data of Retail "<Username/Email>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>" to csv file
    And User should logout from Retail app
    And User opens the given URL "RETAIL_DEMO"
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username/Email>" and password to Retail App
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<FirstName>"
     Then User terminates the browser
    Examples:
      | Username/Email | FirstName | LastName | T&C | ReceiveEmails | TypeOfTesting |
      |automationdemociamsgo@mailinator.com|automation|automation|True|False|positive|


  @retail-signup-email-invalid @retail-demo
    #UPDATE_DATA
  Scenario Outline: US04-02 Retail Sign-up via Email with Invalid data(Passing registered email ID)
    Given User verifies the accessibility to Retail App
    And User clicks on signup button of welcome screen
    Given User must signup with Email
    And User provides invalid email signup details like "<Username/Email>", "<FirstName>", "<LastName>","<T&C>","<ReceiveEmails>"
    Then User terminates the browser
    Examples:
      | Username/Email | FirstName | LastName | T&C | ReceiveEmails |
      |testdata8@mailinator.com|automation|automation|True|False|


  @facebook-signup-login @retail-demo
  Scenario Outline: US04-03 Retail Facebook Sign-Up Test
    Given User verifies the accessibility to Retail App
    And User clicks on signup button of welcome screen
    Given User must signup with Facebook
    Then User provides facebook username "<FacebookUsername>" and password and logs in
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
    And User should logout from Retail app
    Then User should sign out from Facebook account
    And User opens the given URL "RETAIL_DEMO"
    And User clicks on login button of Retail welcome screen
    Given User continues login with Facebook
    Then User facebook account should not be active
    Then User terminates the browser

    Examples:
      |  FacebookUsername     |TypeOfTesting | Firstname |
      |ciamsgo001@gmail.com|positive      | John|




