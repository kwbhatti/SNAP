@aemcore @visual @visual-photography4
Feature: Photography4 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Photography pages
  
  
  Scenario: VCT-PHOTOGRAPHY-004: Photography article image group full document capture
    Given a user navigates to the PhotographyImageGroup page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
