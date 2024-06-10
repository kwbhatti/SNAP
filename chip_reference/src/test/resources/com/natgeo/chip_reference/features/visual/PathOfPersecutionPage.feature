@ReferenceSite @visual @PathOfPersecutionPage
Feature: Path Of Persecution Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Path Of Persecution page


  Scenario: VCT-PATHOFPERSECUTION-001: User visits PathOfPersecution Page 
    Given a user navigates to the PathOfPersecution page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image


