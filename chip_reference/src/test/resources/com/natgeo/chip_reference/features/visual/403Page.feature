@ReferenceSite @visual @403Page
Feature: 403 Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the 403 page


  Scenario: VCT-403-001: User visits 403 Page 
    Given a user navigates to the 403 page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
