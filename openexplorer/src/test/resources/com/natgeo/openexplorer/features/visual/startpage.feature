@openexplorer @visual @visual-startpage
Feature: Open Explorer Visual Regression
  This feature contains all scenarios to perform a visual regression of the Open Explorer page


  Scenario: OEVCT-STARTPAGE-001: Startpage full document capture
    Given an openexplorer user navigates to the Startpage page
    When an openexplorer screen capture is taken of the website
    Then the openexplorer capture is compared to the baseline image
