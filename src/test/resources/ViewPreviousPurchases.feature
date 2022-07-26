Feature: View Previous Purchases

  Scenario Outline: View Purchase Made Earlier
    Given a User enters their "<username>" and "<password>" in the login form and click the login button
    When they click on the User Information button
    And then they click on the View Previous Orders button
    Then "<username>" can see a previous purchase they have made

	Examples:
		| username   | password    |
		|	Testing123 | Orders      |
		| Multiple   | Past Orders |
		