@ReferenceSite @visual @ArticlePage
Feature: Article Page Visual Regression
  This feature contains all scenarios to perform a visual regression of the Article page


  Scenario: VCT-ARTICLE-001: User visits Article Page 
    Given a user navigates to the Article page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
