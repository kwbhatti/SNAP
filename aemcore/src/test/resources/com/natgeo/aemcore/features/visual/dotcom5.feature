@aemcore @visual @visual-dotcom5
Feature: Dot.com5 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Dot.com page
  
  
Scenario: VCT-DOTCOM-005: Environment Page full document capture
    Given a user navigates to the DotComEnvironment page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
