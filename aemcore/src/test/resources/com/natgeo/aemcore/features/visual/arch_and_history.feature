@aemcore @visual @visual-arch_and_history
Feature: Archaeology and History Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Archaeology and History pages


  Scenario: VCT-ARCH_AND_HISTORY-001: Archaeology and History article image lead full document capture
    Given a user navigates to the ArchAndHistoryArticleImageLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image
    