@aemcore @visual @news @visual-news4
Feature: News4 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the News pages
  
  
  Scenario: VCT-NEWS-004: News legacy gallery full document capture
    Given a user navigates to the NewsLegacyGallery page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
