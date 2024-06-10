@aemcore @visual @visual-adventure3
Feature: Adventure3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the adventure pages
  
  
  Scenario: VCT-ADVENTURE-003: Adventure global footer full document capture
    Given a user navigates to the AdventureGlobalFooter page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
