@RUgc
Feature: Create Story, Tips and Photos in the Reference site
	As a community Member, Editor or Community Manager, I want to be able to create UGC in the Reference Site
	
Background:
	Given a user is at Natgeo Reference Site, user: "alberto.copado+2@wizeline.com", password: "Manager@1995"
	
@RcreateUGC @CupReferenceRegression @RCreateTip
Scenario Outline: Create a Tip
    When The user creates a tip with the following information: Title = <title>, Category = <category> and Description = <description>
	Then The new Tip with Title = <title>, Category = <category> and Description = <description> is created
	
	Examples:
	
		| title                    | category | description                     |
		| Automation Tip for Dogs  | Dogs     | Automation Description for Dogs |

@RcreateUGC	@CupReferenceRegression @RCreateStory
Scenario Outline: Create a Story
    When The user creates a Story with the following information: Title = <title>, Subtitle = <subTitle>, Category = <category> and Description = <description> 
	Then The new Story with Title = <title>, Category = <category> and Description = <description> is created
	
	Examples:
	
		| title                      | subTitle                      | category | description                     |
		| Automation Story for Dogs  | Automation Subtitle for Dogs  | Dogs     | Automation Description for Dogs |

@RcreateUGC	@CupReferenceRegression @RCreatePhoto
Scenario Outline: Create a Photo
    When The user creates a Photo with the following information: Title = <title>, Category = <category> and Caption = <caption>
	Then The new Photo with Title = <title>, Category = <category> and Caption = <caption> is created
	
	Examples:
	
		| title                      | category | caption                     |
		| Automation Photo for Dogs  | Dogs     | Automation Caption for Dogs |
		
@RcreateUGC @CupReferenceRegression @RPreviewTip
Scenario Outline: Preview a Tip
	When The user previews a content with details: Title = <title>, Category = <category> and Description = <description> before creating it
	Then The content with the details: Title = <title>, of Category = <category and Description = <description> is showed
	
	Examples:
	
		| title                    | category | description                     |
		| Automation Tip for Dogs  | Dogs     | Automation Description for Dogs |

@CupReferenceRegression @RDeleteContent
Scenario Outline: Delete My Content
	When The user Deletes one of his own Contents
	Then The content is deleted and Home page is displayed
	
	Examples:
	| userName                      | password         |
	| alberto.copado+1@wizeline.com | Testaccount@1995 |
	
@CupReferenceRegression @RUpdateContent
Scenario Outline: Update My Content
	When The user Updates one of his own Contents with Title = <title>, Subtitle = <subtitle>, Category = <category>, Description = <description>
	Then The Updates are displayed: Title = <title>, Category = <category>, Description = <description>
	
	Examples:
	| title         | subtitle         | category | description                 |
	| Title_Updated | Subtitle Updated | Dogs     | Description/Caption Updated |