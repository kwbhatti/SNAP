@ReferenceSite @visual @HomePage
Feature: Home Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Home page


  Scenario: VCT-HOMEPAGE-001: User enters the Home page
    Given a user navigates to the Home page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
