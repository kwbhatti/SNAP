@createUGC
Feature: WebMaster Create New UGC
	As a WebMaste I want to be able to create New Templates of UGC from the Manager Site when i am creating a new Community

Background:
	Given a user is at Natgeo Manager Site, user: "alberto.copado+2@wizeline.com", password: "Manager@1995"
	
@cupCreateCommunity @cupAddUgc @CupManagerRegression
Scenario Outline: Select basic elements from ADD UGC CONTAINER when you are creating a new Community
	When The user selects the existing elements from ADD UGC CONTAINER filling the required content with: <textName>, <imageName> and <richTextName>
    Then All the elements are added in the container before creating the UGC
    
    Examples:
    	| textName        | imageName        | richTextName         |
    	| Automation Text | Automation Image | Automation Rich Text |
    	

@cupCreateCommunity @cupAddUgc @CupManagerRegression
Scenario Outline: Select basic elements from DEFINE UGC when you are creating a new Community
    When The user selects the existing elements from DEFINE UGC filling the required content with: <textName>, <imageName> and <richTextName>
    Then All the elements are added in the container before creating the UGC
    
    Examples:
    	| textName        | imageName        | richTextName         |
    	| Automation Text | Automation Image | Automation Rich Text |
    	
    	
@cupCreateCommunity @cupCreateCompoundContent @CupManagerRegression
Scenario Outline: Create a UGC with Text, Image and Rich Text
	When The user selects the existing elements from DEFINE UGC filling the required content with: <textName>, <imageName> and <richTextName>
    And The user saves the UGC
    Then The UGC is created in the Define Community section
    
    Examples:
    	| textName        | imageName        | richTextName         |
    	| Automation Text | Automation Image | Automation Rich Text |
    	
    	
@cupCreateCommunity @cupCreateCompoundContent @CupManagerRegression
Scenario Outline: Create several UGCs with Text, Image and Rich Text
    When The user creates <counter> UGCs with a Text, Image and Rich Text elements called: <textName>, <imageName> and <richTextName>
    Then <counter> UGCs are created in the Create Community section
    
    Examples:
    	| counter         | textName        | imageName        | richTextName         |
    	| 10              | Automation Text | Automation Image | Automation Rich Text |