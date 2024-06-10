@aemcore @visual @visual-magazine2
Feature: Magazine2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Magazine pages
  
  
  Scenario: VCT-MAGAZINE-002: Magazine image, add this, background video, kicker, byline, pullquote, related content list, title and dek, and smartbody components full document capture
    Given a user navigates to the MagazineMultipleComponents page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
