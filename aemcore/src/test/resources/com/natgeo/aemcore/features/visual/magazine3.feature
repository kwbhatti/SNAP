@aemcore @visual @visual-magazine3
Feature: Magazine3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Magazine pages
  
  
  Scenario: VCT-MAGAZINE-003: Magazine immersive lead full document capture
    Given a user navigates to the MagazineImmersiveLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
