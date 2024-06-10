@globalsites @brazil @visual @visual-brazil
Feature: Brazil Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Brazil article page
  
  
  Scenario: VCT-BRAZIL-001: Brazil article page full document capture
    Given a globalsites user navigates to the BrazilArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    