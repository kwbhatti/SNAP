Feature: Aggregation API - The Aggregation API sites endpoint should return a valid / 
			and only return a valid reponse if a valid uri is passed in the url
      
@chipApiRegression @aggregation
Scenario Outline: Verify that I can not call Aggregation Api without using a valid API key
	Given the url is set to call the "natgeo BaseURL"
	And the endpoint is set to "webAggregationPages"
	And a valid url parameter is passed to the endpoint 
	And I call the Aggregation Api passing an "<apikeyValue>" Apikey in the "apikey"
	Then the response status code should return "401" responseCode

Examples:
|apikeyValue		|
|invalid			|
|				|

@aggreationStaging # fails currently because of junk data in the layout and  will be fixed after data import to envs is in place
Scenario: Verify that aggregation api returns a 200 response for all the layouts available in layouts
	When that I have all the layouts uris and correponding domain names
	And I set the url to call aggregation pages using valid headers
	Then I should get a 200 if I iterate through all the url extracted from layouts
	
	 
@chipApiRegression @aggregation
Scenario: Verify that Aggregation api retains the config information from layout API response
	Given the url is set to call the "natgeo BaseURL"
	When I create a layout with a config property in the payload
	And I call aggregation using the same uri and domain for the layout
	Then aggregation should return me a 200 reponse and it should retain the conig value
	And I clean up and delete the newly created layout
	And I call aggregation using the same uri and domain for the layout
	Then aggregation should return a 404 not found error
	
@chipApiRegression @aggregation
Scenario Outline: Verify that Aggregation api does not return the content_mapper property in the respone 
	Given execution "<noOfExecution>"
	Given that I call layouts and get a random uri and domain name from the response
	And I call aggregation using the same uri and domain name
	Then aggregation should not have content mappers in the response body under any regions.main
Examples:
|noOfExecution|
|1|

@chipApiRegression @aggregation
Scenario: NGPAPI-5419 Verify that aggregation api responds with a proper response and response code for invalid url
	When I call aggregation endpoint using natgeo base URL using an invalid url as the parameter value
	Then the response status code should return "404" responseCode
	And the response should be, CustomError: fetch error