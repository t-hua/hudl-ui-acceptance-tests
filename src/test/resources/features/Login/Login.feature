@login
Feature: Login

  @test2
  Scenario: Login to Hudl as a player of a team
    Given User navigates to the Login page
    When User logs in with their credentials
    Then User is on the Profile Home page

  Scenario: Login to Hudl using login footer link
    Given User clicks on the Login footer link
    When User logs in with their credentials
    Then User is on the Profile Home page

  @logout
  Scenario: Logout of the user profile
    Given User navigates to the Login page
    And User logs in with their credentials
    When User is on the Profile Home page
    And User clicks on Logout
    Then User is on Home page

  @reset-password
  Scenario: Reset forgotten password
    Given User navigates to the Login page
    When User clicks Need Help button
    And User enters their valid email to send password reset link
    Then Send password reset link has been sent successfully


