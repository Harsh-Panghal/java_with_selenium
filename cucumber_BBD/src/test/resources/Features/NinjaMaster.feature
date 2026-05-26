@E2E
Feature: Tutorials Ninja Modular End-to-End Tests

  # 1. REGISTRATION (
  @Regression
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
    And close the browser
    
    Examples: 
      | first_name | last_name | email                  | telephone  | password  |
      | Harsh      | Ninja     | harsh.test32@gmail.com | 9876543210 | Harsh@123 |


  # 2. LOGIN 
  @Smoke @Regression
  Scenario Outline: Verify User Login functionality
    Given user navigates to Tutorials Ninja login page
    When user enters valid email address "<email>"
    And user enters valid password "<password>"
    And clicks on the Login button
    And user is on the My Account dashboard
    When user clicks on the My Account drop-down menu
    And clicks on the Logout option
    Then user should be securely logged out and see the logout confirmation message
    And close the browser

    Examples: 
      | email                  | password  |
      | harsh.test31@gmail.com | Harsh@123 |


  # 3. WISHLIST

  @Regression
  Scenario Outline: Verify Wishlist addition and removal
    Given user navigates to Tutorials Ninja login page
    When user enters valid email address "<email>"
    And user enters valid password "<password>"
    And clicks on the Login button
    And user is on the My Account dashboard
    When user enters product name "<wishlist_item>" in the search bar
    And clicks on the search icon
    And user clicks on the Add to Wish List button
    Then user should see a success message for adding product to wishlist
    And user navigates to the Wish List page
    Then the searched product "<wishlist_item>" should be visible in the wishlist table
    And user clicks on the remove button in the wishlist
    Then user should see the wishlist modified success message
    And close the browser

    Examples: 
      | email                  | password  | wishlist_item |
      | harsh.test31@gmail.com | Harsh@123 | iPhone        |


  # 4. CART & CHECKOUT
  @Smoke @Regression
  Scenario Outline: Verify Cart and Checkout flow
    Given user navigates to Tutorials Ninja login page
    When user enters valid email address "<email>"
    And user enters valid password "<password>"
    And clicks on the Login button
    And user is on the My Account dashboard
    When user enters product name "<cart_item>" in the search bar
    And clicks on the search icon
    And user clicks on the Add to Cart button for the searched product
    Then user should see a success message for adding product to cart
    And user navigates to the shopping cart
    And clicks on the Checkout button
    Then user should reach checkout page or successfully bypass the stock error
    And user navigates to the shopping cart
    And clicks on the remove button
    Then user should see the cart modified success message
    And close the browser

    Examples: 
      | email                  | password  | cart_item |
      | harsh.test31@gmail.com | Harsh@123 | MacBook   |
      
      