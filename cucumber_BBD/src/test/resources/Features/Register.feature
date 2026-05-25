Feature: User Registration on Demo Web Shop

  Scenario Outline: Verify successful user registration with valid details
    Given user is on the Demo Web Shop registration page
    When user selects gender as male
    And enters first name "<first_name>"
    And enters last name "<last_name>"
    And enters email "<email>"
    And enters password "<password>"
    And enters confirm password "<confirm_password>"
    And clicks on the register button
    Then user should see the registration completed message

    Examples:
      | first_name | last_name | email               | password  | confirm_password |
      | Sam        | Choudhary | samhey906@gmail.com | sam@123   | sam@123          |
      | Harsh      | Choudhary | harsh.auto12@gmail.com| Harsh@123 | Harsh@123        |