@NGPCMS398 @AllSuite
Feature: NGPCMS-398 Story settings screens flow

@NGPCMS398-A
Scenario Outline: NGPCMS-398-A New content button added to content page
	Given "<user>" logs into application
	When lands on content page
	Then New content button is displayed at content page
	
	Examples:
	|user		|
	|Admin user	|

@NGPCMS398-B
Scenario Outline: NGPCMS-398-B New content button redirects to create story page
	Given "<user>" is at content page
	When clicks on new content button at content page
	Then redirects to create story page

	Examples:
		|user		|
		|Admin user	|

@NGPCMS398-C
Scenario Outline: NGPCMS-398-C Primary settings page is reachable
	Given "<user>" is at content settings page of a created story
	When clicks on primary tab
	Then redirects to primary settings page
	
	Examples:
		|user		|
		|Admin user	|

@NGPCMS398-D
Scenario Outline: NGPCMS-398-D Secondary settings page is reachable
	Given "<user>" is at content settings page of a created story
	When clicks on secondary tab
	Then redirects to secondary settings page
	
	Examples:
		|user		|
		|Admin user	|
		
@NGPCMS398-E
Scenario Outline: NGPCMS-398-E Advertising settings page is reachable
	Given "<user>" is at content settings page of a created story
	When clicks on advertising tab
	Then redirects to advertising settings page
	
	Examples:
		|user		|
		|Admin user	|

@NGPCMS398-F
Scenario Outline: NGPCMS-398-F Technical settings page is reachable
	Given "<user>" is at content settings page of a created story
	When clicks on technical tab
	Then redirects to technical settings page
	
	Examples:
		|user		|
		|Admin user	|

@NGPCMS398-G
Scenario Outline: NGPCMS-398-G Continue button is displayed on create story page when creating a new story
	Given "<user>" logs into application
	When clicks on new content button at content page
	Then displays Continue button at create story page
	
	Examples:
	|user		|
	|Admin user	|

@NGPCMS398-H
Scenario Outline: NGPCMS-398-H Continue button on create story page leads to layout manager
	Given "<user>" is at create story page of a new story
	When selects layout type image, enters story title and clicks on continue button
	Then redirects to text view page of new story
	
	Examples:
	|user		|
	|Admin user	|

@NGPCMS398-I
Scenario Outline: NGPCMS-398-I Save button is displayed on primary page of an existing story
	Given "<user>" is at content settings page of a created story
	When clicks on primary tab
	Then displays a save button at content primary settings page
	
	Examples:
	|user		|
	|Admin user	|

@NGPCMS398-J
Scenario Outline: NGPCMS-398-J Save button on primary page leads to secondary settings page
	Given "<user>" is at primary settings page of a created story
	When clicks on save button
	Then redirects to secondary settings page

	Examples:
	|user		|
	|Admin user	|