Feature: OrangeHRM Login Functionality

  Scenario: Successful login with valid credentials
    Given user is on login page
    When user enters username "Admin" and password "admin123"
    And user clicks on login button
    Then login should be successful
    And user should be redirected to dashboard

  Scenario: Failed login with invalid credentials
    Given user is on login page
    When user enters username "invalid" and password "invalid"
    And user clicks on login button
    Then login should fail
    And error message should be "Invalid credentials"

  Scenario: Failed login with empty username
    Given user is on login page
    When user enters username "" and password "admin123"
    And user clicks on login button
    Then login should fail
    And error message should be "Required"

  Scenario: Failed login with empty password
    Given user is on login page
    When user enters username "Admin" and password ""
    And user clicks on login button
    Then login should fail
    And error message should be "Required"

  Scenario: Verify forgot password link
    Given user is on login page
    Then forgot password link should be displayed