@aemcore @visual @travel @visual-travel6
Feature: Travel6 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the travel pages
  
  
  Scenario: VCT-TRAVEL-006: Travel image, title and dek, byline, and smartbody components document capture
    Given a user navigates to the TravelMultipleComponents page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
