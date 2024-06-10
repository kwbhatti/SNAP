@aemcore @visual @animals @visual-animal3
Feature: Animals3 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the animals pages
  
  
  Scenario: VCT-ANIMALS-003: Animals Profile Artic Fox full document capture
    Given a user navigates to the ArticFoxAnimalProfile page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
