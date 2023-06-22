@simple-test
Feature: Retail_Demo_US03 Google Login Test US-0

  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given direct URL "https://google.com"
  @simple-test
  Scenario: US03-00 Retail Google login Test
    And get the title of the Page as "Google"
    And get the title of the Page as "Google"
    Then User terminates all windows of the browser