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
Feature: Title of your feature
  I want to use this template for my feature file

@tag1
	Scenario: User should be able to remove a game from their cart
		Given User has navigated to the LandingPage
		And User navigates to LoginPage
		And User enters correct credentials and logs in
		And User Navigates to the storePage
		And User selects a game to be put in cart
		And User navigates to the cartPage
		When User clicks on the removeGameButton
		Then User should see the empty cart message
		


    
    

