Feature: Config Sites API - The config API sites endpoint should return a valid / 
			and only return a valid reponse if a valid domaoin is passed in the url

@chipApiRegression @config
Scenario Outline: Verify that the Config API responds as expected when passing an invalid or no apikey
	Given the url is set to call the "natgeo BaseURL"
	And the endpoint is set to "configs"
	And the value of header "apikey" is set using a "<apikey_request>" value
	When the endpoint is called using the "GET" operation
	Then the response status code should return "<responseCode>" responseCode
Examples:
|apikey_request		|responseCode		|
|invalid				|401					|
|					|401					|

@chipApiRegression @config
Scenario: Verify that the Config API responds as expected when passing no or invalid resource
	Given the url is set to call the "configs" endpoint
	And an invalid resource is passed to the configSites endpoint
	When the endpoint is called using the "GET" operation
	Then the response status code should return "400" responseCode
	
@chipApiRegression @config
Scenario: Verify that the Config API responds as expected when getting all configs
	Given the url is set to call the "configs" endpoint
	When the endpoint is called using the "GET" operation
	Then the response status code should return "200" responseCode
		
@chipApiRegression @config
Scenario Outline: Verify that any random site config from get all configs could be called using domain parameter and the body matches
	Given execution "<noOfExecution>"
	Given the url is set to call the "natgeo BaseURL" 
	And I get all the configs from configs API 
	And I randomly pick a config object from the respone and get the domain for a site
	And I call the configs site endpoint passing the domain as the parameter
	Then the response status code should return "200" responseCode
	And the response should equal the data property when calling all configs
	And the id should also match the id originally retrieved from get all configs
Examples:
|noOfExecution	|
|1				|
|2				|
|3				|

#	what is a valid domain name for sites and custom pages
@chipApiRegression @config
Scenario Outline: Verify that any random custom page config from get all configs could be called using domain parameter and the body matches
	Given execution "<noOfExecution>"
	Given the url is set to call the "natgeo BaseURL" 
	And I get all the configs from configs API 
	And I randomly pick a config object from the respone and get the domain and page for a custom page
	And I call the configs site endpoint passing the domain and page as the parameters
	Then the response status code should return "200" responseCode
	And the response should equal the data property when calling all configs
	And the id should also match the id originally retrieved from get all configs
Examples:
|noOfExecution	|
|1				|
|2				|
|3				|


