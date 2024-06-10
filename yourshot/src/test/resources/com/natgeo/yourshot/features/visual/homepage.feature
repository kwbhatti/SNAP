@openexplorer @visual @visual-homepage
Feature: Open Explorer Visual Regression
  This feature contains all scenarios to perform a visual regression of the Open Explorer pages


  Scenario: OEVCT-HOMEPAGE-001: Homepage full document capture
    Given a yourshot user navigates to the Homepage page
    When a yourshot screen capture is taken of the website
    Then the yourshot capture is compared to the baseline image
