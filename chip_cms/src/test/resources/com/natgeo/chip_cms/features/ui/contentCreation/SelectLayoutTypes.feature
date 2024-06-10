@NGPCMS793    @SelectLayoutTypes    @Regression
Feature: Create Story with Layout Types Image, Video and Gallery

As a user when I click on cotnent tab should get to /content page

@NGPCMS793-A
Scenario Outline: Create Story with Layout Type Image, Enters Story Title, SEO Title, Social Title, Promo Title, Dek, Social Dek, Promo Dek
	Given "<user>" is at create story page of a new story
	When selects layout type image, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button
	Then redirects to text view page of new story
	When clicks text view page save button
	Then should see layout manager page displayed

	Examples:
	|user		|
	|Admin user	|

@NGPCMS793-B
Scenario Outline: Create Story with Layout Type Video
	Given "<user>" is at create story page of a new story
	When selects layout type video, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button
	Then redirects to text view page of new story
	When clicks text view page save button
	Then should see layout manager page displayed
#	When clicks on layout paragraph
#	Then add button is displayed
#	When clicks on add button
#	Then dialog box is displayed
#	When clicks on image box
#	Then image is added

	Examples:
	|user		|
	|Admin user	|

@NGPCMS793-C
Scenario Outline: Create Story with Layout Type Gallery
	Given "<user>" is at create story page of a new story
	When selects layout type gallery, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button
	Then redirects to text view page of new story
    When clicks text view page save button
	Then should see layout manager page displayed

	Examples:
	|user		|
	|Admin user	|

@NGPCMS793-D
Scenario Outline: Create Story with Layout Type Hub
	Given "<user>" is at create story page of a new story
	When selects layout type hub, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button
	Then redirects to text view page of new story
    When clicks text view page save button
	Then should see layout manager page displayed

	Examples:
	|user		|
	|Admin user	|
	

