@aemcore @visual @visual-adventure2
Feature: Adventure2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the adventure pages
  
  
  Scenario: VCT-ADVENTURE-002: Adventure article background image and hero component full document capture
    Given a user navigates to the AdventureBackgroundImage page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image  
