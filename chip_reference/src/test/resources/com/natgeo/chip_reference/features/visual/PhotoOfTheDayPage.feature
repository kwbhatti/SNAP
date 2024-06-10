@ReferenceSite @visual @PhotoOfTheDay
Feature: Photo of the Day Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the photo of the day page


  Scenario: VCT-PHOTOOFTHEDAY-001: User visits Photo Of The Day page
    Given a user navigates to the PhotoOfTheDay page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
