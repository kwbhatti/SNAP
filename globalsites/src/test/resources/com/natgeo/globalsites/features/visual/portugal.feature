@globalsites @portugal @visual @visual-portugal
Feature: Portugal Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Portugal article page
  
  
  Scenario: VCT-PORTUGAL-001: Portugal article page full document capture
    Given a globalsites user navigates to the PortugalArticle page
    When a globalsites screen capture is taken of the website
    Then the globalsites captured page is compared to a baseline
    