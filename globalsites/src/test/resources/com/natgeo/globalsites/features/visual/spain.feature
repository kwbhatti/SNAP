@globalsites @spain @visual @visual-spain
Feature: Spain Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Spain article page
  
  
  Scenario: VCT-SPAIN-001: SPAIN article page full document capture
    Given a globalsites user navigates to the SpainArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    