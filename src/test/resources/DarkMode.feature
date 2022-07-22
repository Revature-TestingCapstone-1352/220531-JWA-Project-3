Feature: Dark Mode

  Scenario: Dark mode turns page background dark
    Given that a user is on the HomePage
    When the User clicks the darkLightButton
    Then the HomePage background color will change to dark

  Scenario: Light mode turns background light
    Given that a user is on the HomePage and background is dark
    When the User clicks the darkLightButton
    Then the HomePage background color will change to light

