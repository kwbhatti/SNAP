@NGPCMS792 @LayoutManager @AllSuite @Regression
Feature: Reach layout page after creating story

As a user when I click on cotnent tab should get to /content page

@NGPCMS792-A
Scenario Outline: Creating of story navigates Layout Manager page
	Given "<user>" is at text view of a new created story
	When clicks text view page save button
	Then should see layout manager page displayed

	Examples:
	|user		|
	|Admin user	|

@NGPCMS792-B
Scenario Outline: Display of Plus button and divider on layout manager page
	Given "<user>" is at text view of a new created story
	When clicks text view page save button
	Then should see layout manager page displayed
	When clicks on layout paragraph
	Then add button is displayed

	Examples:
	|user		|
	|Admin user	|

@NGPCMS792-C
Scenario Outline: Display of Image component on Dialog Box
	Given "<user>" is at text view of a new created story
	When clicks text view page save button
	Then should see layout manager page displayed
	When clicks on layout paragraph
	Then add button is displayed
	When clicks on add button
	Then dialog box is displayed

	Examples:
	|user		|
	|Admin user	|

#@NGPCMS792-D
#Scenario Outline: User closes Dialog Box
#	Given "<user>" is at text view of a new created story
#	When clicks text view page save button
#	Then should see layout manager page displayed
#	When clicks on layout paragraph
#	Then add button is displayed
#	When clicks on add button
#	Then dialog box is displayed
#
#
#	Examples:
#	|user		|
#	|Admin user	|

@NGPCMS792-E
Scenario Outline: Adding Image between paragraph
	Given "<user>" is at text view of a new created story
	When clicks text view page save button
	Then should see layout manager page displayed
	When clicks on layout paragraph
	Then add button is displayed
	When clicks on add button
	Then dialog box is displayed
	When clicks on image box
	Then image is added

	Examples:
	|user		|
	|Admin user	|

#@NGPCMS792-F - Bug Existing and will be implemented in Sprint 14
#Scenario Outline: Save button displayed on the layout manager page
#	Given "<user>" is at text view of a new created story
#	When clicks text view page save button
#	Then should see layout manager page displayed
#	When clicks on layout paragraph
#	Then add button is displayed
#	When clicks on add button
#	Then dialog box is displayed
#	When clicks on image box
#	Then image is added
#	When user clicks on chiptoolbar
#	Then display save button on layoutmanager page
#
#
#	Examples:
#	|user		|
#	|Admin user	|
