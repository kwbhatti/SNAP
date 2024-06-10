Feature: Layout Regions endpoint - Create/Update/Delete functionality for layout as well as its integration with layouts endpoint

@chipApiRegression @layoutRegions
Scenario: NGPAPI-5358 Verify that the Layout Regions returns a 200 response code
	When I call layout regions endpoint using natgeo base URL
	Then the response status code should return "200" responseCode
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5358 Verify that the Layout Region get all endpoint returns valid response with valid layout Region
	When I get one layout region from the responses and call layout regions endpoint using id parameter
	Then the response status code should return "200" responseCode
	And the id in get layout region by id response should match the id in the request parameter
	
@chipApiRegression @layoutRegions 
Scenario: NGPAPI-5358 Verify that I am able to create a layout region using the POST operation
	When I call layout region endpoint using POST operation with a valid payload
	Then the response status code should return "201" responseCode
	And I get the id from the response and call layout regions endpoint using the same id parameter
	Then the response status code should return "200" responseCode
	And the get layout region by id response name property should match the name while creating the layout region
 
@chipApiRegression @layoutRegions
 Scenario: NGPAPI-5358 Verify that I am able to create a layout using the newly created layout region
  	When I call the layouts endpoint using the POST operation using the a valid payload with the layout region created in the previous scenario
	Then the response status code should return "201" responseCode
	And I retrieve the layout id from the response and call layouts endpoint using the layout id property
	Then the response should have the correct layout region in the response body

@chipApiRegression @layoutRegions
 Scenario: NGPAPI-5358 Verify that I am able to update the newly created layout region
	When I call the layout regions endpoint using the PUT operation with an updated payload
	Then the response status code should return "200" responseCode
	And I call the layout regions endpoint using the GET operation using the id for the layout region created earlier
	Then the layout regions response should have the updated layout region in the response body

@chipApiRegression @layoutRegions
 Scenario: NGPAPI-5358 Verify that the update to the layout region is reflected in the layout created
	When I call the layout created earlier using the GET operation
	Then the layout response should have the updated layout region name in the response body
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5418 Verify that I am not able to delete the layout region created earlier as long as it has an association with the layout
	When I call the layout regions endpoint using the DELETE operation using the id for the layout region created earlier
	Then the response status code should return "400" responseCode
	And I get the id from the response and call layout regions endpoint using the same id parameter
	Then the response status code should return "200" responseCode
	
@chipApiRegression @layoutRegions
Scenario: NGPAPI-5418 Verify that I am able to delete the layout region created earlier after disassociating the layout
	When I call the layout endpoint using the DELETE operation using the id for layout created earlier
	And I call the layout created earlier using the GET operation
	Then the response status code should return "404" responseCode
	And I call the layout regions endpoint using the DELETE operation using the id for the layout region created earlier
	Then the response status code should return "200" responseCode
	And I get the id from the response and call layout regions endpoint using the same id parameter
	Then the response status code should return "404" responseCode
	
	
	
	
