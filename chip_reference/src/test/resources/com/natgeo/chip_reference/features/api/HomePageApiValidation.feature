@HomePageApiValidation
Feature: Home Page aggregation API response 
Aggregation API is returning all expected data when called from Home Page

Scenario: Aggregation API is returning all expected data when called from Home Page
Given aggregation API is called from Home Page
Then Ad Manager information is received as expected
And Content Package information is received as expected
And Photo Of The Day information is received as expected
And Dynamic Package information is received as expected
And TV Guide Preview information is received as expected
And Video Playlist information is received as expected
And Left And Right Package information is received as expected
And Broadsheet information is received as expected
