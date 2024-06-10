@ReferenceSite @visual @HummingbirdPage
Feature: Hummingbird Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Hummingbird page


  Scenario: VCT-HUMMINGBIRD-001: User visits Hummingbird Page 
    Given a user navigates to the Hummingbird page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image


