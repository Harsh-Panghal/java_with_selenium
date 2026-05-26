@Regression
Feature: Tutorials Ninja Registration Flow

  Scenario Outline: Verify User Registration and Logout
    Given user navigates to Tutorials Ninja registration page
    When user enters personal details with first name "<first_name>" and last name "<last_name>"
    And enters contact email "<email>" and telephone "<telephone>"
    And enters registration password "<password>" and confirm password "<password>"
    And user selects the Privacy Policy checkbox
    And clicks on Continue button
    Then user should see the account created success message
    When user clicks on the My Account drop-down menu
    And clicks on the Logout option
    Then user should be securely logged out and see the logout confirmation message
    
    Examples: 
      | first_name | last_name | email                  | telephone  | password  |
      | Harsh      | Ninja     | harsh.test42@gmail.com | 9876543210 | Harsh@123 |