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
Feature: Search Games

  
  #Scenario Outline: Search for Good Game
    #Given The user is on the homepage
    #And the games are displayed
    #When I search for "Dawn of"
    #Then The first game should be "Warhammer 40,000: Dawn of War II: Retribution"

#	Scenario: Search while logged in
#		Given A user logs in through the Login Page
#		And The user is on the homepage
#		And the games are displayed
#		When I search for "age o"
    #Then The first game should be "Age of Empires III: Complete Collection"
    
      Scenario Outline: Search for Good Game
    Given The user is on the homepage
    And the games are displayed
    When I search for "<entry>"
    Then The first game should be "<result>"
	
    Examples: 
      | entry  | result | 
      | Dawn of |     Warhammer 40,000: Dawn of War II: Retribution | 
      | age o |     Age of Empires III: Complete Collection | 
