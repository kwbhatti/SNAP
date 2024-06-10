@ReferenceSite @visual @SearchNoResultsPage
Feature: Search with No Results Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Search with No Results page


  Scenario: VCT-SEARCHNORESULTS-001: User visits SearchNoResults Page 
    Given a user navigates to the SearchNoResults page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image

