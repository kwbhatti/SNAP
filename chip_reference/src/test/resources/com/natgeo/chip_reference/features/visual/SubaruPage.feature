@ReferenceSite @visual @SubaruPage
Feature: Subaru Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Subaru page


  Scenario: VCT-SUBARU-001: User visits Subaru Page 
    Given a user navigates to the Subaru page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image

