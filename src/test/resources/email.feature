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
Feature: User needs Email information
 

  @tag1
  Scenario Outline: User displays email information
    Given User logs in with their "<username>" and "<password>"
    When User clicks User Information
    Then "<username>" will be able to see the email address displayed in E-mail address field

    Examples: 
      | username | password |
      | revaturenoob | javastruggle |
      
