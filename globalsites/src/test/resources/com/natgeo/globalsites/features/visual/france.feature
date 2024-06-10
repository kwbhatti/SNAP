@globalsites @france @visual @visual-france
Feature: France Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the France article page
  
  
  Scenario: VCT-FRANCE-001: France article page full document capture
    Given a globalsites user navigates to the FranceArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    