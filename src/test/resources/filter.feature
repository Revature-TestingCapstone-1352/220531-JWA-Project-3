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
Feature: Filter
  I want to use this template for my feature file

@tag1
  Scenario: Filter By Rating
    Given User is on the HomePage
    When User clicks each rating
    Then User should be able to view games that have no rating

@tag2
  Scenario: Mostly Negative
    Given User is on the HomePage
    When User selects Mostly Negative filter
    Then User should be able to view games that are Mostly Negative
    
@tag3
  Scenario: Mixed
    Given User is on the HomePage
    When User selects Mixed filter
    Then User should be able to view games that are Mixed
    
    
@tag4
  Scenario: Positive
    Given User is on the HomePage
    When User selects Positive filter
    Then User should be able to view games that are Positive
    
    
    
@tag5
  Scenario: Mostly Positive
    Given User is on the HomePage
    When User selects Mostly Positive filter
    Then User should be able to view games that are Mostly Positive
    
    
    
 @tag6
  Scenario: Very Positive
    Given User is on the HomePage
    When User selects Very Positive filter
    Then User should be able to view games that are Very Positive
    
 @tag7
  Scenario: Overwhelmingly Positive
    Given User is on the HomePage
    When User selects Overwhelmingly Positive filter
    Then User should be able to view games that are Overwhelmingly Positive
    

