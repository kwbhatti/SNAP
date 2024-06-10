@ReferenceSite @visual @PrivacyPolicyage
Feature: Privacy Policy Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Privacy Policy page


  Scenario: VCT-PRIVACYPOLICY-001: User visits PrivacyPolicy Page 
    Given a user navigates to the PrivacyPolicy page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
