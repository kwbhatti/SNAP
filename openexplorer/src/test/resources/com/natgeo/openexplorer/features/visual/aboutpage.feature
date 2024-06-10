@openexplorer @visual @visual-about
Feature: Open Explorer Visual Regression
  This feature contains all scenarios to perform a visual regression of the Open Explorer pages


  Scenario: OEVCT-ABOUTPAGE-001: Aboutpage full document capture
    Given an openexplorer user navigates to the Aboutpage page
    When an openexplorer screen capture is taken of the website
    Then the openexplorer capture is compared to the baseline image
