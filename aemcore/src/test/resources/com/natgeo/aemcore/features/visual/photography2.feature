@aemcore @visual @visual-photography2
Feature: Photography2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Photography pages
  
  
  Scenario: VCT-PHOTOGRAPHY-002: Photography infinite gallery item full document capture
    Given a user navigates to the PhotographyInfiniteGalleryItem page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
