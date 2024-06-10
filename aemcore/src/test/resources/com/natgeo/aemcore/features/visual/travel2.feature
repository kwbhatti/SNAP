@aemcore @visual @travel @visual-travel2
Feature: Travel2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the travel pages
  
  
  Scenario: VCT-TRAVEL-002: Travel article-image lead 1 full document capture
    Given a user navigates to the TravelArticleImageLead1 page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
