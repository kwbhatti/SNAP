@ReferenceSite @visual @SeriesPage
Feature: Series Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Series page


  Scenario: VCT-SERIES-001: User visits Series Page 
    Given a user navigates to the Series page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
