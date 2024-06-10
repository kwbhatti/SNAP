@globalsites @uk @visual @visual-uk
Feature: UK Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the UK article page
  
  
  Scenario: VCT-UK-001: United Kingdom article page full document capture
    Given a globalsites user navigates to the UKArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    