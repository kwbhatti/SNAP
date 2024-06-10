@ReferenceSite @visual @TermsOfServicePage
Feature: Terms Of Service Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Terms Of Service page


  Scenario: VCT-TERMSOFSERVICE-001: User visits TermsOfService Page 
    Given a user navigates to the TermsOfService page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image

