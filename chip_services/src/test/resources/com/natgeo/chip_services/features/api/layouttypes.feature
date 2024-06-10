Feature: LayoutTypes endpoint - Create/Update/Delete functionality for layout as well as its integration with layouts endpoint

@chipApiRegression @layoutRegions
Scenario: NGPAPI-5356 Verify that the Layout Types returns a 200 response code
	When I call layouttypes endpoint using natgeo base URL
	Then the response status code should return "200" responseCode
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5356 Verify that the Layout Types get all endpoint returns valid response with valid layout Types
	When I get one layouttype from the responses and call layout types endpoint using id parameter
	Then the response status code should return "200" responseCode
	And the id in the response should match the id in the request parameter
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5356 Verify that I am able to create a layout type using the POST operation
	When I call layouttypes endpoint using POST operation with a valid payload
	Then the response status code should return "201" responseCode
	And I get the id from the response and call layouttypes endpoint using the same id parameter
	Then the response status code should return "200" responseCode
	And the response name property should match the name while creating the layouttype

@chipApiRegression @layoutRegions
 Scenario: NGPAPI-5356 Verify that I am able to create a layout using the newly created layouttype
  	When I call the layouts endpoint using the POST operation using the a valid payload with the layouttype created in the previous scenario
	Then the response status code should return "201" responseCode
	And I retrieve the layout id from the response and call layouts endpoint using the layout id property
	Then the response should have the correct layout type in the response body

@chipApiRegression @layoutRegions  
 Scenario: NGPAPI-5356 Verify that I am able to update the newly created layouttype
	When I call the layouttypes endpoint using the PUT operation with an updated payload
	Then the response status code should return "200" responseCode
	And I call the layouttypes endpoint using the GET operation using the id for the layouttype created earlier
	Then the layouttype response should have the updated layouttype in the response body

@chipApiRegression @layoutRegions
 Scenario: NGPAPI-5356 Verify that the update to the layouttype is reflected in the layout created
	When I call the layout created earlier using the GET operation
	Then the layout response should have the updated layouttype in the response body
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5418 Verify that I am not able to delete the layout region created earlier as long as it has an association with the layout
	When I call the layouttype endpoint using the DELETE operation using the id for the layouttype created earlier
	Then the response status code should return "400" responseCode
	And I get the id from the response and call layouttypes endpoint using the same id parameter
	Then the response status code should return "200" responseCode
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5418 Verify that I am able to delete the layout region created earlier after disassociating the layout
	When I call the layout endpoint using the DELETE operation using the id for layout created earlier
	And I call the layout created earlier using the GET operation
	Then the response status code should return "404" responseCode
	When I call the layouttype endpoint using the DELETE operation using the id for the layouttype created earlier
	Then the response status code should return "200" responseCode
	And I get the id from the response and call layouttypes endpoint using the same id parameter
	Then the response status code should return "404" responseCode
	