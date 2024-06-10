@aemcore @visual @visual-photography1
Feature: Photography Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Photography pages


  Scenario: VCT-PHOTOGRAPHY-001: Photography article image lead full document capture
    Given a user navigates to the PhotographyArticleImageLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
