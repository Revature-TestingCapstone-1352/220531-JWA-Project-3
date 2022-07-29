Feature: Update Email and Password

  Scenario: A user can update his/here Email address 
    Given the user is on the home Page
    When the user clicks on User Information Button
    And the user clicks on Edit User Details 
    And the user enter the <"newemail"> and clicks the Update E-mail button
    Then the user seccussfully update the Email
