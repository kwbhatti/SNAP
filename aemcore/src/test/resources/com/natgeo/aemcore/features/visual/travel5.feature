@aemcore @visual @travel @visual-travel5
Feature: Travel5 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the travel pages
  
  
  Scenario: VCT-TRAVEL-005: Travel add this and listicle components document capture
    Given a user navigates to the TravelAddThisListicle page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image    
