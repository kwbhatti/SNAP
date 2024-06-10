@ReferenceSite @visual @BigCatMonthPage
Feature: Big Cat Month Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Big Cat Month page


  Scenario: VCT-BIGCATMONTH-001: User visits BigCatMonth Page 
    Given a user navigates to the BigCatMonth page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image


