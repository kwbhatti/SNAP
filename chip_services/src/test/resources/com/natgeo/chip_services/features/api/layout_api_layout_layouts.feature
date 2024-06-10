@chipApiRegression @layouts
Feature: Layout Layouts API - The layout API layouts endpoint should return a valid / 
			and only return a valid reponse if a valid layout_id or uri and domain_name are passed in the url 


Background: Configuring the request to call natgeo Layout Endpoint
	Given the url is set to call the "natgeo BaseURL"
	And the endpoint is set to "layoutLayouts"


Scenario: Verify that the Layout Health API responses as expected provided an invalid apikey
	And the value of header "apikey" is set using a "invalid" value
	When the endpoint is called using the "GET" operation
	And the response status code should return "401" responseCode
	
Scenario: Verify that the Layout Health API responses as expected provided no apikey
	And the value of header "apikey" is set using a "" value
	When the endpoint is called using the "GET" operation
	And the response status code should return "401" responseCode
		
Scenario: Verify that the Layout API returns all layouts when called the layouts endpoint without any parameters
	And the value of header "apikey" is set using a "valid" value
	When the endpoint is called using the "GET" operation
	Then the response status code should return "200" responseCode

Scenario: Verify that the Layout API responds as expected when using a valid layout_id parameter in the url
	And the value of header "apikey" is set using a "valid" value
	When the endpoint is called using the "GET" operation
	And I get a random "id" from the array of "layouts" from the reponse and saved as "layout.random.id"
	And the random "layout.random.id" is passed to the url
	When the endpoint is called using the "GET" operation
	Then the response status code should return "200" responseCode
	And the response body should have the valid random "layout.random.id" in the "id"

Scenario Outline: Verify that the Layout API responds as expected when using an invalid layout_id parameter in the url
	And the value of header "apikey" is set using a "valid" value
	And a "<layout_id_request>" is passed to the url 
	When the endpoint is called using the "GET" operation
	And the response status code should return "404" responseCode

Examples:

|layout_id_request 	|
|0000/				|

Scenario Outline: Verify that the Layout API responds as expected when passing valid parameters, uri and domain_name
	Given execution "<noOfExecution>"
	And the value of header "apikey" is set using a "valid" value
	When the endpoint is called using the "GET" operation
	And I get a random "uri,domainName" from the array of "layouts" from the reponse and saved as "layout.random.uri,layout.random.domain_name"
	And the "uri" is "passed" to the url using the random "layout.random.uri"
	And the "domain_name" is "added" to the url using the random "layout.random.domain_name"
	When the endpoint is called using the "GET" operation
	And the response status code should return "200" responseCode
	And the response body should have the valid random "layout.random.uri" in the "uri"
	And the response body should have the valid random "layout.random.domain_name" in the "domainName"

Examples:

|noOfExecution	|
|1				|
|2				|
|3				|

Scenario Outline: Verify that the Layout API responds as expected when passing invalid parameters, uri and/or domain_name
	And the value of header "apikey" is set using a "valid" value
	And a "uri" is "passed" with a value of "<uri_value>" to the url
	And a "domain_name" is "added" with a value of "<domain_name_value>" to the url
	When the endpoint is called using the "GET" operation
	And the response status code should return "404" responseCode

Examples:

|uri_value			|domain_name_value				|
|/invalid/			|www.invalid.com					|
|/invalid/			|www.nationalgeographic.co.uk	|
|/about/				|www.invalid.com					|
	