@aemcore @visual @visual-magazine1
Feature: Magazine Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Magazine pages


  Scenario: VCT-MAGAZINE-001: Magazine article image lead full document capture
    Given a user navigates to the MagazineArticleImageLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
                                                              