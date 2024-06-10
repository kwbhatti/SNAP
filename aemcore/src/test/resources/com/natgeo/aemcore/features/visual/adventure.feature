@aemcore @visual @visual-adventure1
Feature: Adventure Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the adventure pages


  Scenario: VCT-ADVENTURE-001: Adventure article image lead full document capture
    Given a user navigates to the AdventureArticleImageLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
