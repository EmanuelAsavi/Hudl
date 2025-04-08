@login
Feature: User should be able to login the Hudl application

  Background:
    Given User is on the login page
    When User click login button
    When User click on Hudl logo


#  Positive scenario
  Scenario: Verify if user can login in the application with valid credentials
    Then User must be on login window on Login Page
    When User enter valid email and click Continue on Login Page
    When User enter valid password and click Continue on Login Page
    Then User must be on the Home Page o the application

  Scenario: Verify if user can edit email
    When User enter "invalid1@gmail.com" invalid email and click Continue on Login Page
    Then User should see Edit button displayed
    When User enter valid password and click Continue on Login Page
    Then User should receive "Incorrect username or password." warning message
    Then User should see Edit button displayed
    And User click on Edit button
    When User enter valid email and click Continue on Login Page
    When User enter valid password and click Continue on Login Page
    Then User must be on the Home Page o the application

  Scenario: Verify if user can use forgot password functionality
    When User enter valid email and click Continue on Login Page
    When User click on Forgot Password button
    Then User should be on reset password page
    When User click on continue button
    Then User should see "Check Your Email" confirmation message
    And User should see Resend Email button

  Scenario: Verify if user can use password visibility button
    When User enter valid email and click Continue on Login Page
    When User enter "password123" random password
    And User click on Show password button
    Then User should be able to see the password
    When User click on Hide password button
    Then User should not be able to see the password

  Scenario: Verify if user can login with Google account
    When User click on Continue with Google button
    Then User should be redirected to the "google" page

  Scenario: Verify if user can login with Facebook account
    When User click on Continue with Facebook button
    Then User should be redirected to the "facebook" page

  Scenario: Verify if user can login with Apple account
    When User click on Continue with Apple button
    Then User should be redirected to the "apple" page


#  Negative scenarios
  Scenario: Verify if user can not login in the application with invalid email and valid password
    When User enter invalid "invalid1@gmail.com" and click Continue on Login Page
    When User enter valid password and click Continue on Login Page
    Then User should receive "Incorrect username or password." warning message
    Then User must be on login window on Login Page

  Scenario: Verify if user can not login in the application with valid email and invalid password
    When User enter valid email and click Continue on Login Page
    When User enter "invalidPassword" invalid password and click Continue on Login Page
    Then User should receive "Your email or password is incorrect. Try again." warning message
    Then User must be on login window on Login Page

  Scenario: Verify if user can not login in the application with invalid email, by using digits only
    When User enter only digits "352436356" in email field and click Continue on Login Page
    Then User should see the "Enter a valid email." warning message

  Scenario: Verify if user can not login in the application with invalid email, by using special characters only
    When User enter only digits "!£$%^&*@" in email field and click Continue on Login Page
    Then User should see the "Enter a valid email." warning message

  Scenario Outline: Verify if user can not login in the application with invalid credentials
    When User use invalid "<email>" email and click Continue on Login Page
    When User use invalid "<password>" password and click Continue on Login Page

    Examples:
      | email                | password        |
      | invalid1@gmail.com   | password123     |
      | invalid2@yahoo.com   | passwordABC123  |
      | invalid3@outlook.com | password123ABC  |
      | invalid@invalid.com  | passwordInvalid |

