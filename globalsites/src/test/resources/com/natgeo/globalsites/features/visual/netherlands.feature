@globalsites @netherlands @visual @visual-netherlands
Feature: Netherlands Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Netherlands article page
  
  
  Scenario: VCT-NETHERLANDS-001: Netherlands article page full document capture
    Given a globalsites user navigates to the FranceArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    