Feature: PHPTravels Registration Module

  @Manual
  Scenario: Validate User Registration with Random Email
    Given user is on the registration page
    When user enters personal details "Harsh" "Choudhary"
    And enters a randomly generated email and password "Harsh@12345"
    And clicks on the signup button
    Then validate successful registration