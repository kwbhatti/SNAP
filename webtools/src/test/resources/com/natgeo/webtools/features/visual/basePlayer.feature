@webtools @visual 
Feature: Adventure Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the adventure pages


  Scenario: VCT-ADVENTURE-001: Adventure article image lead full document capture
    Given a webtools user navigates to the basePlayer page
    When a webtools screen capture is taken of the video player at 15 seconds
    Then the webtools capture is compared to the baseline image