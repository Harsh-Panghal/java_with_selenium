Feature: Complete End-to-End Hotel Booking Workflow

  @E2E @Regression
  Scenario: Validate Complete Booking Workflow
    # 1. Login (Reusing Q1 Steps)
    Given user launches browser
    When user enters "user@phptravels.com" and "demouser"
    And clicks on login button
    
    # 2. Search Hotel (Reusing Q3 Steps)
    And user is on the PHPTravels home page
    And user enters destination "Dubai"
    And selects check-in and check-out dates
    And selects travellers count
    And selects nationality "India" 
    And clicks on the hotel search button
    
    # 3. New E2E Steps
    And user selects a hotel from the search results
    And books the hotel room
    And enters traveller details and confirms booking
    Then validate booking confirmation message
    And user logs out