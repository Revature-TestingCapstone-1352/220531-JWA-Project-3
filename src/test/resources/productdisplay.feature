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
Feature: Product Display

  @tag1
  Scenario: Games per page
    Given a User is on the Store Page
    When the games are displayed
    Then there should be a maximum of twenty-four games displayed per page
    
  @tag2
  Scenario: View Metacritic review
    Given a User is on the Store Page
    When when the User clicks on the Metacritic link of a game
    Then there is a valid Metacritic review displayed
