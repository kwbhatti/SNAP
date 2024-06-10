@aemcore @visual @visual-people_and_culture2
Feature: People and Culture2 Pages Visual Regression
  This feature contains all scenarios to perform a visual regression of the People and Culture pages
  
  
  Scenario: VCT-PEOPLE_AND_CULTURE-002: People and Culture contributor card full document capture
    Given a user navigates to the PeopleAndCultureContributorCard page
    When a screen capture is taken of the website
    Then the capture is compared to the baseline image 
