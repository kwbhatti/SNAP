@NGPCMS504 @AllSuite
Feature: NGPCMS-504 User lands on content page

As a user when I click on content tab should get to /content page

@NGPCMS504-A
Scenario Outline: NGPCMS-504-A Check the path for the content frontpage.
	Given "<user>" logs into application
	When clicks on content tab from toolbar
	Then content page is displayed
	
	Examples:
	|user		|
	|Admin user	|