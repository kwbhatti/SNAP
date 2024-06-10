@globalsites @mexico @visual @visual-mexico
Feature: Mexico Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Mexico article page
  
  
  Scenario: VCT-MEXICO-001: Mexico article page full document capture
    Given a globalsites user navigates to the MexicoArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    