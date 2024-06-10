@aemcore @visual @visual-contributors
Feature: Contributors Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Contributors pages


  Scenario: VCT-CONTRIBUTORS-001: Contributor detail page full document capture
    Given a user navigates to the ContributorDetailPage page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
