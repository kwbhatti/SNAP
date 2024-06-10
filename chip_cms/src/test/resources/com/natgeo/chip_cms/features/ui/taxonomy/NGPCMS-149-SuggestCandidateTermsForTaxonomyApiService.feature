@NGPCMS149 @Taxonomy @AllSuite
Feature: NGPCMS-149 Suggest candidate terms for Taxonomy API service

As a content producter, I should be able to make suggest terms to the Taxonomy Candidate API

@NGPCMS149-A
Scenario Outline: NGPCMS-149-A Suggest a candidate term for Taxonomy
	Given "<user>" is at the edit page of a story node that has a taxonomy API field
	When types a term that doesnt exist in taxonomy api that accepts suggestions
	Then suggest term button is displayed
	
	Examples:
	|user		|
	|Admin user	|
	
@NGPCMS149-B
Scenario Outline: NGPCMS-149-B Remove suggested term from taxonomy field
	Given "<user>" has suggested a candidate term in a taxonomy field
	When clicks remove button on the suggested term
	Then suggested term is removed
	
	Examples:
	|user		|
	|Admin user	|
	
@NGPCMS149-C
Scenario Outline: NGPCMS-149-C Candidate term is differentiated from the taxonomy terms
	Given "<user>" enters a text that is not found in a taxonomy field that accepts suggestions
	When clicks in suggest term button
	Then suggested term has a different background color
	
	Examples:
	|user		|
	|Admin user	|