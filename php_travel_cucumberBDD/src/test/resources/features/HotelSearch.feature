Feature: PHPTravels Hotel Search Module

  @Regression
  Scenario Outline: Validate Hotel Booking Search
    Given user is on the PHPTravels home page
    When user enters destination "<destination>"
    And selects check-in and check-out dates
    And selects travellers count
    And selects nationality "<nationality>"
    And clicks on the hotel search button
    Then validate hotel search results are displayed
    And fetch and validate dynamic hotel prices

    Examples:
      | destination | nationality |
      | Dubai       | India       |