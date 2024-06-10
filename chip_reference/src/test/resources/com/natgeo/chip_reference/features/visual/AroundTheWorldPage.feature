@ReferenceSite @visual @AroundTheWorldPage
Feature: Around The World Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Around The World page


  Scenario: VCT-AROUNDTHEWORLD-001: User visits AroundTheWorld Page 
    Given a user navigates to the AroundTheWorld page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image


