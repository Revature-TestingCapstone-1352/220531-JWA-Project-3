Feature: Click to see more games

  Scenario: Click arrow to go to next game page
    Given that a user is on the HomePage viewing games
    When the User clicks the nextPageButton
    Then the page will display more games

