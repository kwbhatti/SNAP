@cupCreateCommunity
Feature: Create a New Community
	I want to be able to go to the Natgeo Manager Site and Create a New Community
	
Background:
	Given a user is at Natgeo Manager Site, user: "alberto.copado+2@wizeline.com", password: "Manager@1995"
	
@CreateCommunity @CupManagerRegression
Scenario Outline: Create a Community with Name and Description
	When the user creates a Community with Name: <communityName> and Description: <communityDescription>
    Then <communityName> is present in the Home Page
    
    Examples:
    	| communityName             | communityDescription   |
    	| Automation Community Name | Automation Description |

@CreateCommunity @CupManagerRegression
Scenario: Click on Cancel when you try to create a new Community
	When the user goes to create a new Community and clicks on Cancel
	Then the user should be redirected to the Manager site Home Page