@US06 @new-bank
Feature: New_Bank_US06 06 Profile Items Test
  Background: New Bank Application URL
    Given Setup the Test Environment as "CHROME" and User opens the given URL "NEW_BANK"
#   Given User Accepts Cookies for Banking App
    Given User provides access token to Deloitte security page for New Banking App

  @update-personal-information @new-bank @update-email-firstname-lastname-mobile
  Scenario Outline: US06-01 New_Bank: User can able to update FirstName, Lastname, Email and Mobile details
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    Then Verify the "<Email>", "<FirstName>", "<LastName>" and "<TypeOfTesting>" of logged-in user details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"

    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - previous
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app

#    Update Details
    Then User updates "<UpdateEmail>", "<UpdateFirstName>", "<UpdateLastName>", "<MobileNumber>" in personal details of new Bank app
    And User clicks on update details and confirm as NO
    And User clicks on update details and confirm as YES and verifies the confirmation message
    Then Verify the "<UpdateEmail>", "<UpdateFirstName>", "<UpdateLastName>", "<MobileNumber>" and "<TypeOfTesting>" of logged-in user details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"

    #check the updated details by logging again
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - previous
    Then User should able to login with "<UpdateFirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    Then Verify the "<UpdateEmail>", "<UpdateFirstName>", "<UpdateLastName>", "<MobileNumber>" and "<TypeOfTesting>" of logged-in user details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email                                       | TypeOfTesting |UserName|FirstName|LastName|UpdateEmail|UpdateFirstName|UpdateLastName|MobileNumber|
      | EMAIL            | newbankregistrationviaemail@mailinator.com | positive      |newbankregistrationviaemail|automation|automation|updatedemail123@mailinator.com|updatedfirstname|updatedlastname|9090909090|

  @update-personal-information @new-bank @update-firstname-lastname-mobile
  Scenario Outline: US06-02 New_Bank: User can able to update FirstName, Lastname and Mobile details (Except Email)
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    Then Verify the "<Email>", "<FirstName>", "<LastName>" and "<TypeOfTesting>" of logged-in user details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"

    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - previous
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app

#    Update Details
    Then User updates "<UpdateFirstName>", "<UpdateLastName>", "<MobileNumber>" in personal details of new Bank app
    And User clicks on update details and confirm as NO
    And User clicks on update details and confirm as YES and verifies the confirmation message
    Then Verify the "<UpdateFirstName>", "<UpdateLastName>", "<MobileNumber>" and "<TypeOfTesting>" of logged-in user details except email on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"

    #check the updated details by logging again
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - previous
    Then User should able to login with "<UpdateFirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    Then Verify the "<UpdateFirstName>", "<UpdateLastName>", "<MobileNumber>" and "<TypeOfTesting>" of logged-in user details except email on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email                                       | TypeOfTesting |UserName|FirstName|LastName|UpdateFirstName|UpdateLastName|MobileNumber|
      | EMAIL            | newbankregistrationviaemail@mailinator.com | positive      |newbankregistrationviaemail|automation|automation|updatedfirstname|updatedlastname|9090909090|




  @update-address-details @new-bank @update-all-location-details
  Scenario Outline: US06-03 New_Bank: User can able to update StreetAddress, Country, State, City and ZipCode details
    And User verifies the new bank site is accessible
    And User clicks on OpenAnAccount on new Bank app
    Given User provides the account creation using "<ModeOfRegistration>" and submit
    Given User provides "<Email>", "<FirstName>", "<LastName>", "<UserName>", "<TypeOfTesting>" and password for Signup page of new Bank app
    Then User feeds the test data of new Bank "<Email>", "<FirstName>", "<LastName>", "<TypeOfTesting>" to csv file
    Then User should able to login with "<FirstName>" on new Bank app "<TypeOfTesting>"
    Then Verify the "<Email>", "<FirstName>", "<LastName>" and "<TypeOfTesting>" of logged-in user details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"

    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - previous
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app

#    Update Details
    Then User updates "<StreetAddress>", "<Country>", "<State>", "<City>" and "<ZipCode>" address details in location section of new Bank app
    And User clicks on update details and confirm as NO
    And User clicks on update details and confirm as YES and verifies the confirmation message
    Then Verify the "<StreetAddress>", "<Country>", "<State>", "<City>", "<ZipCode>" and "<TypeOfTesting>" of address details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"

    #check the updated details by logging again
    And User verifies the new bank site is accessible
    And User waits until the login section appears for new Bank app
    Given User provides "<UserName>" and  password for new bank app - previous
    Then User should able to login with "<FirstName>" and land on dashboard of new Bank app "<TypeOfTesting>"
    And User clicks on profile option on dashboard page of new Bank app
    Then Verify the "<StreetAddress>", "<Country>", "<State>", "<City>", "<ZipCode>" and "<TypeOfTesting>" of address details on new bank app
    And User logs out from new Bank app "<TypeOfTesting>"
    Then User terminates all windows of the browser
    Examples:
      | ModeOfRegistration | Email     | TypeOfTesting |UserName|FirstName|LastName|StreetAddress|Country|State|City|ZipCode|
      | EMAIL     | newbankregistrationviaemail@mailinator.com | positive |newbankregistrationviaemail|automation|automation|Mapple Street|United States|California|San Jose|94088|


