@aemcore @visual @visual-people_and_culture1
Feature: People and Culture Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the People and Culture pages


  Scenario: VCT-PEOPLE_AND_CULTURE-001: People and Culture article video lead full document capture
    Given a user navigates to the PeopleAndCultureArticleVideoLead page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
