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
@tag
Feature: Checkout

  @tag1
  Scenario: Successful checkout
    Given that a User has an Item in their Cart and is viewing their Cart
    When the User clicks the Proceed to Checkout button, then the Place Order button
    Then the User will have successfully bought the games

  @tag2
  Scenario: Trying to checkout with an empty cart
  	Given that a User has an empty Cart and is viewing their Cart
    When the User tries to Checkout
    Then the Cart Page will display that the Cart is empty and the Proceed to Checkout will not be displayed