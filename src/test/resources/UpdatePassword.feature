@tag 
Feature: Update Password
@tag1
  Scenario: A user can update his/here Password
    Given the user is on the home_Page
    When the user clicks on User Information_Button
    And the user clicks on Edit_User_Details 
    And the user type in a valid <"password"> and confirm same password and clicks on Update password button
    Then the user seccussfully update the Password
    
    
@tag2
   Scenario: A user can not type the confirm password different than the new password
   Given the user is on the homePage again
   When the user clicks on User Information_Button
   And the user clicks on Edit_User_Details
   And the user type in a <"password"> and confirm diff <"password"> and clicks on Update password button
   Then the user get a Popup message