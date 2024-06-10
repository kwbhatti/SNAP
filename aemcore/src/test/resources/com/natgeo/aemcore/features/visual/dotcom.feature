@aemcore @visual @visual-dotcom1
Feature: Dot.com Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Dot.com page


  Scenario: VCT-DOTCOM-001: Dot.com full document capture
    Given a user navigates to the DotComBasePage page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
