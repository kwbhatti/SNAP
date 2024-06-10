@ReferenceSite @visual @ExploreTheOceanPage
Feature: Explore The Ocean Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Explore The Ocean page


  Scenario: VCT-EXPLORETHEOCEAN-001: User visits ExploreTheOcean Page 
    Given a user navigates to the ExploreTheOcean page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image


