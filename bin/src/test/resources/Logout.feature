@tag
Feature: User Log out

  @tag1
  Scenario: Loging Out
    Given LoggedIn User is on the Home Page
    When The User clicks on LogoutButton
    Then Logout seccussful


