@tag 
Feature: Update Email and Password
@tag1
  Scenario: A user can update his/here Email address 
    Given the user is on the UserInformation Page
    When the user clicks on Edit User Details 
    And the user enter the "<newemail"> and clicks the Update E-mail button
    Then the user seccussfully update the Email

    Examples: 
      | email |
      | 1234@gmail.com        |