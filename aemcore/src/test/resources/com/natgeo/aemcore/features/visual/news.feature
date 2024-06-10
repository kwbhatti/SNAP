@aemcore @visual @news @visual-news1
Feature: News Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the News pages
  
  
  Scenario: VCT-NEWS-001: News article full document capture
    Given a user navigates to the NewsArticle page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
