@aemcore @visual @news @visual-news3
Feature: News3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the News pages
  
  
  Scenario: VCT-NEWS-003: News legacy article full document capture
    Given a user navigates to the NewsLegacyArticle page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
