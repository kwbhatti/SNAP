@aemcore @visual @travel @visual-travel3
Feature: Travel3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the travel pages
  
  
  Scenario: VCT-TRAVEL-003: Travel article-image lead 2 full document capture
    Given a user navigates to the TravelArticleImageLead2 page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
