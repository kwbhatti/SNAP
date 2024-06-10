@aemcore @visual @visual-books
Feature: Books Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the Books pages


  Scenario: VCT-BOOKS-001: Books article image lead full document capture
    Given a user navigates to the BooksArticleImageLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image

