@NGPCMS145 @Taxonomy @AllSuite
Feature: NGPCMS145 Entering values in Taxonomy field

As an administrator, I should be able to see a widget for taxonomy fields that allow me to do specific actions on them

@NGPCMS145-A
Scenario Outline: NGPCMS-145-A Taxonomy field should autocomplete the words when enter 3 letters
	Given "<user>" is at the edit page of a story node that has a taxonomy API field
	When types 3 letters in taxonomy field
	Then taxonomy field displays a list of matching terms
	
	Examples:
	| user			|
	| Admin user		|
	
@NGPCMS145-B
Scenario Outline: NGPCMS-145-B Taxonomy autocomplete finds a value that matches with multiple options, should be able to display all and differentiate with extra context each term
	Given "<user>" is at the edit page of a story node that has a taxonomy API field
	When types a term in taxonomy field that matches multiple results
	Then taxonomy field displays a list with of the matched terms with additional context data
	
	Examples:
	| user			|
	| Admin user		|