@aemcore @visual @news @visual-news5
Feature: News5 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the News pages
  
  
  Scenario: VCT-NEWS-005: News gallery full document capture
    Given a user navigates to the NewsGallery page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
