@aemcore @visual @animals @visual-animal5
Feature: Animals5 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the animals pages
  
  
  Scenario: VCT-ANIMALS-005: Animals Profile African Elephant full document capture
    Given a user navigates to the AfricanElephantAnimalProfile page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
