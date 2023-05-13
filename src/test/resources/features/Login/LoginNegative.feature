@login-negative
Feature: Login Negative Scenario

  Scenario Outline: Attempt to login with invalid credentials
    Given User navigates to the Login page
    When User enters <email> and <password> to login
    Then User will be unable to login

    Examples:
      | email          | password    |
      | bad@_email.com | @@@@@@      |
      | test@email.com | Password123 |
      |                |             |