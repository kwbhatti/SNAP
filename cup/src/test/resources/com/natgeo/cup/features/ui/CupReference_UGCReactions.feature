@RUgc
Feature: React to a UGC
	As a community Member I want to be able to add a Comment and Like any content 
	
Background:
	Given a user is at Natgeo Reference Site, user: "alberto.copado+2@wizeline.com", password: "Manager@1995"
	
@RUgcReactions @CupReferenceRegression @RLikeContent
Scenario: Like a Content
    Then The user enters to a content details and click on Like

@RUgcReactions @CupReferenceRegression @RCommentContent
Scenario Outline: Make a Comment into a Story
    When The user makes a Comment <comment> into a Story
    Then The comment <comment> is successfully posted
    
    Examples:
    | comment            |
    | Automation Comment |