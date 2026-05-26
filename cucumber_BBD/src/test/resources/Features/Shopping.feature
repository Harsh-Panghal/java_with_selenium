Feature: Tutorials Ninja Shopping and Core Actions

  Background: 
    Given user navigates to Tutorials Ninja login page
    When user enters valid email address "harsh.test32@gmail.com"
    And user enters valid password "Harsh@123"
    And clicks on the Login button
    And user is on the My Account dashboard

  @Smoke @Regression
  Scenario: Verify User Login functionality
    When user clicks on the My Account drop-down menu
    And clicks on the Logout option
    Then user should be securely logged out and see the logout confirmation message

  @Regression
  Scenario Outline: Verify Wishlist addition and removal
    When user enters product name "<wishlist_item>" in the search bar
    And clicks on the search icon
    And user clicks on the Add to Wish List button
    Then user should see a success message for adding product to wishlist
    And user navigates to the Wish List page
    Then the searched product "<wishlist_item>" should be visible in the wishlist table
    And user clicks on the remove button in the wishlist
    Then user should see the wishlist modified success message

    Examples: 
      | wishlist_item |
      | iPhone        |

  @Smoke @Regression
  Scenario Outline: Verify Cart and Checkout flow
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

    Examples: 
      | cart_item |
      | MacBook   |