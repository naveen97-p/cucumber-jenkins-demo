@US06 @retail-dev
Feature: Retail_Dev_US06 Don't Sell Data Test
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEV"
#    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-dont-sell-my-data-dev  @retail-dev
  Scenario Outline: US06-01 Retail User should have an ability to not to sell the data
    Given User verifies the accessibility to Retail App
    And User clicks on login button of Retail welcome screen
    And User provides username as "<Username>" and password to Retail App - static
    And User Should able to login with "<TypeOfTesting>" approach and should land on Retail home page and pass firstname "<Firstname>"
    Then User clicks on profile icon on welcome screen
    And User clicks on privacy and consent
    Then User clicks on Do Not Sell My Data option
    And User should provide "<Username>" to Octa Page, get the OTP from Mailinator and then authorize the sign-in for Retail-Dev
    And User should fill the Privacy Web Form with the details like "<Country>", "<IAmA(An)>", "<State>","<SelectRequestType>","<WebFirstName>","<WebLastName>","<WebEmail>","<LoyaltyID>","<RequestDetails>" then submit for Dev
   Then User terminates all windows of the browser

    Examples:
      | Username | TypeOfTesting | Firstname | Country | IAmA(An) | State | SelectRequestType | WebFirstName | WebLastName | WebEmail | LoyaltyID | RequestDetails |
      | automationciamsgodevprogressive21@mailinator.com | positive      | automation |United States|Customer|Alabama|Do Not Sell My Information|automation|automation|automationdevprivacyandconsent@mailinator.com|123123123|Hi there, I'm requesting you to not to sell my data. Regards, A Tester|
