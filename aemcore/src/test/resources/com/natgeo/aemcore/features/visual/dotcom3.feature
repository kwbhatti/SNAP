@aemcore @visual @visual-dotcom3
Feature: Dot.com3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Dot.com page
  
  
  Scenario: VCT-DOTCOM-003: Science Page full document capture
    Given a user navigates to the DotComScience page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
