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

Feature: Register User Feature

	Background:
		Given A guest is on the home page

  Scenario Outline: the guest should be able to click the register page
    When a guest enters a "<username>" and "<password>" and "<email>"
    Then a guest can register by pressing the register button and be on the Homepage

    Examples: 
      |username| password | email       |
      | Jac  |stephen | stephen@mail.com|
