Feature: Click to see more games

  Scenario: Click arrow to go to next game page
    Given that a user is on the HomePage viewing games
    When the User clicks the nextPageButton
    Then the page will display next game page

  Scenario: Click arrow to go to previous game page
    Given that a user is on the HomePage and not on first game page
    When the User clicks the previousPageButton
    Then the page will display previous game page

  Scenario: Click page number to go to particular page
    Given that a user is on the HomePage viewing first game page
    When the User clicks numberedPageButton
    Then the page will display specified game page
