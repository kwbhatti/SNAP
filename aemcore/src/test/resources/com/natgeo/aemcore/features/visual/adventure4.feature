@aemcore @visual @visual-adventure4
Feature: Adventure4 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the adventure pages
  
  
  Scenario: VCT-ADVENTURE-004: Adventure title and deck full document capture
    Given a user navigates to the AdventureTitleDeck page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image       
