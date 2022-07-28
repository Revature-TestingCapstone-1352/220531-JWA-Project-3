#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Remove Ticket Feature
 
 	Background: 
 		Given A customer logs in through the Login Page
  
  
  Scenario Outline: A user should be able to login and be able to add a item to their wishlist and be able to view it on the wishlist page
  	When the user types in a valid "<username>" and "<password>"
  	And a customer should be able to go to the Home Page and be able to click add to wishlist on an item
  	And a customer should be able to remove the wishlist item by pressing the remove from wishlist button
    Then be unable to see the wishlist item on the wishlist page

    Examples: 
      | password  | username   |
      |StephenPass|StephenTest |