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

Feature: Login

  @SuccessfulLogin
  Scenario: User can log in
	 Given the user is already logged out
	 And the user is on the login page
	 When the user enters valid credentials to log in
	 Then the user is redirected to the store page
	 And the user is logged in
  
  @UnsuccessfulLogin
  Scenario: User cannot log in without creds
	 Given the user is already logged out
	 And the user is on the login page
	 When the user enters invalid credentials to log in
	 Then the user is redirected to the registration page
	 And the user is not logged in
	
	#Khellil Feature goes here
	 
	@LogoutEmptyCart
  Scenario: Logging out empties cart
		Given a user is logged in
		And a user has added a game to their cart
		And a user is on the cart page
		When a user clicks the logout button
		And a user goes to the cart page
		Then the cart should be empty
		
	@LogoutEmptyWishlist
  Scenario: Logging out empties wishlist
		Given a user is logged in
		And a user has added a game to their wishlist
		And a user is on the wishlist page
		When a user clicks the logout button
		And a user goes to the wishlist page
		Then the wishlist should be empty
		
	@LogoutNoUserInfo
  Scenario: Logging out clears user page
		Given a user is logged in
		And a user is on the user information page
		When a user clicks the logout button
		And a user goes to the user information page
		Then the user information page should be empty