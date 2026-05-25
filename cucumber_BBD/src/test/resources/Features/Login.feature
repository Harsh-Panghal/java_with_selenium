Feature: Verify login functionality on Demo Web Shop

  Scenario Outline: verify user is able to login with valid credentials
    Given login page should be open in default browser
    When click on email field and enter valid email "<email>"
    And then click on password field and enter valid password "<password>"
    And now click on login button
    Then user login successfully and redirect to home page

    Examples:
      | email                      | password  |
      | harsh.automation@gmail.com | Harsh@123 |
      | samhey654@gmail.com        | sam@123   |