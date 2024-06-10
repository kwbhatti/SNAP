@aemcore @visual @visual-dotcom4
Feature: Dot.com4 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Dot.com page
  
  
  Scenario: VCT-DOTCOM-004: Travel Page full document capture
    Given a user navigates to the DotComTravel page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
