@aemcore @visual @animals @visual-animal1
Feature: Animals Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the animals pages


  Scenario: VCT-ANIMALS-001: Animals Profile full document capture
    Given a user navigates to the AnimalProfile page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
