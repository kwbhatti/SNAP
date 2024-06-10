@aemcore @visual @news @visual-news2
Feature: News2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the News pages
  
  
  Scenario: VCT-NEWS-002: News home full document capture
    Given a user navigates to the NewsHome page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
  