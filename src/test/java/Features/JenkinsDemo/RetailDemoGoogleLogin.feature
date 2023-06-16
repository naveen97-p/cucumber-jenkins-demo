@simple-test
Feature: Retail_Demo_US03 Google Login Test

  Background: Retail Application Demo URL
    Given Setup the Test Environment as "CHROME" and User opens the given direct URL "https://google.com"
  @simple-test
  Scenario: US03-01 Retail Google login Test
    Then User terminates all windows of the browser