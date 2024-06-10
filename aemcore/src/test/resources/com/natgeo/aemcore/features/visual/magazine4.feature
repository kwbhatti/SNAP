@aemcore @visual @visual-magazine4
Feature: Magazine4 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Magazine pages


Scenario: VCT-MAGAZINE-004: Magazine interactive component full document capture
    Given a user navigates to the MagazineInteractiveComponent page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
