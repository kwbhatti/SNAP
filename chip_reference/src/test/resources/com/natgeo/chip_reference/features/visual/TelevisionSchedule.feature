@ReferenceSite @visual @TelevisionSchedulePage
Feature: Television Schedule Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Television Schedule page


  Scenario: VCT-TELEVISIONSCHEDULE-001: User visits TelevisionSchedule Page 
    Given a user navigates to the TelevisionSchedule page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image


