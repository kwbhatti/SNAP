@aemcore @visual @visual-science_and_space2
Feature: Science and Space2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Science and Pages pages
  
  
  Scenario: VCT-SCIENCE_AND_SPACE-002: Science and Space presentation mode full document capture
    Given a user navigates to the ScienceAndSpacePresentationMode page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
