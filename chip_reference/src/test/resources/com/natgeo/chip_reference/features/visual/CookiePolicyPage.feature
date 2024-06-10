@ReferenceSite @visual @CookiesPolicyPage
Feature: Cookies Policy Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Cookies Policy page


  Scenario: VCT-COOKIESPOLICY-001: User visits CookiesPolicy Page 
    Given a user navigates to the CookiesPolicy page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
