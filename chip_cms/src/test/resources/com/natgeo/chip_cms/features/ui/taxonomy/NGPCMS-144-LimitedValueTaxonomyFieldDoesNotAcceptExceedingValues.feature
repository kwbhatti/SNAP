@NGPCMS144 @Taxonomy @AllSuite
Feature: NGPCMS144 Limited Value Taxonomy API reference field does not accept exceeding values 

As an administrator, I should be able to add a Taxonomy API reference field that can only accept a single value

@NGPCMS144-A
Scenario Outline: NGPCMS-144-A Create Taxonomy API reference field that accepts a single value
	Given "<user>" is at the edit page of a story node that has a taxonomy API field
	When exceeds the number of values in a limited value taxonomy field
	Then exceeding value limit error message is displayed
	
	Examples:
	|user		|
	|Admin user	|