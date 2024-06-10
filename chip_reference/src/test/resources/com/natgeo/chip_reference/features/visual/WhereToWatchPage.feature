@ReferenceSite @visual @WhereToWatch
Feature: Where to Watch Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the where to watch page


  Scenario: VCT-WHERETOWATCH-001: User visits Where to Watch Page 
    Given a user navigates to the WhereToWatch page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
