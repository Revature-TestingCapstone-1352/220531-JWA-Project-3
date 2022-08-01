Feature: Add To Cart From Home Page

	Scenario: Add To Cart Without Logging In
    Given the User is on the home page
    When the User clicks on Add To Cart on a game
    And the User clicks on the Cart button
    Then the User should see the game they added in their cart

	Scenario: Add To Cart After Loggin In
   	Given the User logged in and on the home page
   	When the User clicks on Add To Cart on a game
   	And the User clicks on the Cart button
   	Then the User should see the game they added in their cart