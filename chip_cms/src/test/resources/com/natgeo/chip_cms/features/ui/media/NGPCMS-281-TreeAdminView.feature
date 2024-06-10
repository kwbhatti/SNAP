@NGPCMS248
Feature: NGPCMS248 Tree Admin View

As an administrator, I want to be able to navigate my content in a tree format because this is a remnant of AEM and I am comfortable with it.

@NGPCMS248-A
Scenario Outline: NGPCMS-248-A Admin content tree is displayed
	Given "<user>" logs into application
	When navigates to admin content tree page
	Then admin content tree is displayed
	
	Examples:
	|user		|
	|Admin user	|

@NGPCMS248-B
Scenario Outline: NGPCMS-248-B Content tree toggle expands the children items
	Given "<user>" is at admin content tree page
	When clicks expand button of a category
	Then tree displays children elements from a category
	
	Examples:
	|user		|
	|Admin user	|

@NGPCMS248-C
Scenario Outline: NGPCMS-248-C Content tree toggle collapse the children items
	Given "<user>" has expanded a category at admin content tree
	When clicks collapse button of a category
	Then tree hides children elements 
	
	Examples:
	|user		|
	|Admin user	|
	
@NGPCMS248-D
Scenario Outline: NGPCMS-248-D Admin content tree is hidden for non admin users
Given "<user>" is at admin content tree page
When navigates to admin content tree page
Then access denied message is displayed

	Examples:
	|user				|
	|Authenticated user	|