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

Feature: View Added Ticket Feature
 
 	Background: 
 		Given: A user logs in through the Login Page
  
  
  Scenario Outline: A user should be able to login and be able to add a item to their wishlist and be able to view it on the wishlist page
  	When they type in a valid "<username>" and "<password>"
  	And they go to the Home Page they should be able to click add to wishlist on an item
    Then view that item on the wishlist page

    Examples: 
      | password  | username   |
      |StephenPass|StephenTest |      
