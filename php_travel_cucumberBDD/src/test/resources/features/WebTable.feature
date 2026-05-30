Feature: Booking Table Validations

  @Regression @WebTable
  Scenario: Extract and Validate Booking Data
    Given user launches browser
    When user enters valid login credentials 
    And clicks on login button
    Then user validates booking table data for duplicates and prices