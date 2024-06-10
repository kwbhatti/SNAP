@aemcore @visual @travel @visual-travel4
Feature: Travel4 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the travel pages
  
  
  Scenario: VCT-TRAVEL-004: Travel destination hub document capture
    Given a user navigates to the TravelDestinationHub page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image  
