@aemcore @visual @animals @visual-animal2
Feature: Animals2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the animals pages
  
  
  Scenario: VCT-ANIMALS-002: Animals Hub full document capture
    Given a user navigates to the AnimalHub page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
