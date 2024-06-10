@ReferenceSite @visual @HubPage
Feature: Hub Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the hub page


  Scenario: VCT-HUBPAGE-001: User enters the Hub page
    Given a user navigates to the Hub page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
