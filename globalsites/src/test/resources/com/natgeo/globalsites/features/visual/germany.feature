@globalsites @germany @visual @visual-germany
Feature: Germany Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Germany article page
  
  
  Scenario: VCT-GERMANY-001: Germany article page full document capture
    Given a globalsites user navigates to the GermanyArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
