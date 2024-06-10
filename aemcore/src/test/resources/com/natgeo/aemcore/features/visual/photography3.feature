@aemcore @visual @visual-photography3
Feature: Photography3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Photography pages
  
  
  Scenario: VCT-PHOTOGRAPHY-003: Photography Homepage hub full document capture
    Given a user navigates to the PhotographyHomepageHub page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
