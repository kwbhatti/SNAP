@ReferenceSite @visual @404Page
Feature: 404 Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the 404 page


  Scenario: VCT-404-001: User visits 404 Page 
    Given a user navigates to the 404 page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
