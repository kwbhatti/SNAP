@aemcore @visual @visual-dotcom2
Feature: Dot.com2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Dot.com page
  
  Scenario: VCT-DOTCOM-002: promo feed full document capture
    Given a user navigates to the DotComPromoFeed page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
