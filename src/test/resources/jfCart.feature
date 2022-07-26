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
Feature: Cart
 

  @tag1
  Scenario: User can navigate to the cart while not logged in
    Given User is on the HomePage
    When User clicks the Cart button
    Then User should be on the Cart page
    
    
  @tag2
  Scenario: User can remove an item from the cart
  	Given User has navigated to the HomePage
  	And The User has navigated to the loginPage
  	And The User has inserted credentials and logged in
  	And The User is on the general landing page
  	When User clicks on Cart page
  	Then User should be on the Cart page
  	
    
    
    
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
      #
      #
      #
       #@tag1
  #Scenario: User can navigate to the cart while not logged in
    #Given User is on the HomePage
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes