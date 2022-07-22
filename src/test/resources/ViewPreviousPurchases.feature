Feature: View Previous Purchases

  Scenario: View Purchases Made Previously
    Given a User logs in and has already made a purchase
    When a User clicks the User Information button
    And clicks on the View Previous Orders button
    Then the User should see past purchases they made
    