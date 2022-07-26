Feature: View Previous Purchases

  Scenario: View Purchase Made Earlier
    Given a User is logged in and has made a previous purchase
    When they click on the User Information button
    And then they click on the View Previous Orders button
    Then they can see a previous purchase they have made

  Scenario: View Multiple Purchases Made Earlier
  	Given a User is logged in and has made previous purchases
  	When they click on the User Information button
  	And then they click on the View Previous Orders button
  	Then they can see the previous purchases they have made