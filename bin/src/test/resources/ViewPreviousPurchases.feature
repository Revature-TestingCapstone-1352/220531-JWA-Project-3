Feature: View Previous Purchases

  Scenario: View Purchases Made Earlier
    Given a User is logged in and has made a previous purchase
    When they click on the User Information button
    And then they click on the View Previous Orders button
    Then they can see previous purchases they have made
