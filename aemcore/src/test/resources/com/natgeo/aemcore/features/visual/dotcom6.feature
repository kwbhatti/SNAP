@aemcore @visual @visual-dotcom6
Feature: Dot.com6 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Dot.com page
  
  
  Scenario: VCT-DOTCOM-006: Culture Page full document capture
    Given a user navigates to the DotComCulture page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
