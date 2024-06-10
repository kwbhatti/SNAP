@ReferenceSite @visual @SearchPage
Feature: Search Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Search page


  Scenario: VCT-SEARCH-001: User visits Search Page 
    Given a user navigates to the Search page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image

