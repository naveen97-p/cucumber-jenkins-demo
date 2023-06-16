@US08 @retail-demo
Feature: Retail_Demo_US08 Unauthenticated DSAR Test
  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "RETAIL_DEMO"
    Then User Accepts Cookies for Retail App
    Given User provides access token to Deloitte security page

  @retail-dsar  @retail-demo
  Scenario Outline: US08-01 Retail User complete the Unauthenticated DSAR
    Given User verifies the accessibility to Retail App
    And User closes the pop-up screen
    Then User click on Do Not Sell My Data on Home page
#   And User should provide "<WebEmail>" to Octa Page, get the OTP from Mailinator and then authorize the sign-in
    And User verifies the Privacy Web Form with the email "<WebEmail>"
    Then User terminates all windows of the browser

    Examples:
    |WebEmail|
    | privacyform@mailinator.com |
