@ReferenceSite @visual @SubscribePage
Feature: Subscribe Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Subscribe page


  Scenario: VCT-SUBSCRIBE-001: User visits Subscribe Page 
    Given a user navigates to the Subscribe page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image

