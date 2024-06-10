Feature: Layout SiteId endpoint - Create/Update/Delete functionality for layout as well as its integration with layouts endpoint

@chipApiRegression @layoutSiteId
Scenario: Verify that the Layout Sites returns a 200 response code
	When I call layout sites endpoint using natgeo base URL
	Then the response status code should return "200" responseCode
	
@chipApiRegression @layoutSiteId
Scenario: Verify that the Layout sites get all endpoint returns valid response with valid layout site
	When I get one layout sites from the responses and call layout types endpoint using id parameter
	Then the response status code should return "200" responseCode
	And the id in get layout site by id response should match the id in the request parameter
	
@chipApiRegression @layoutSiteId 
Scenario: Verify that I am able to create a layout site using the POST operation
	When I call layout sites endpoint using POST operation with a valid payload
	Then the response status code should return "201" responseCode
	And I get the id from the response and call layout sites endpoint using the same id parameter
	Then the response status code should return "200" responseCode
	And the get layout site by id response name property should match the name while creating the layout site

@chipApiRegression @layoutSiteId
 Scenario: Verify that I am able to create a layout using the newly created layout site
  	When I call the layouts endpoint using the POST operation using the a valid payload with the layout site created in the previous scenario
	Then the response status code should return "201" responseCode
	And I retrieve the layout id from the response and call layouts endpoint using the layout id property
	Then the response should have the correct layout site in the response body

@chipApiRegression @layoutSiteId
 Scenario: Verify that I am able to update the newly created layout site 
	When I call the layout sites endpoint using the PUT operation with an updated payload
	Then the response status code should return "200" responseCode
	And I call the layout sites endpoint using the GET operation using the id for the layout site created earlier
	Then the layout site response should have the updated layout site in the response body

@chipApiRegression @layoutSiteId
 Scenario: Verify that the update to the layout site is reflected in the layout created
	When I call the layout created earlier using the GET operation
	Then the layout response should have the updated layout site domain name in the response body

@chipApiRegression @layoutSiteId
Scenario: NGPAPI-5418 Verify that I am not able to delete the layout region created earlier as long as it has an association with the layout
	When I call the layout sites endpoint using the DELETE operation using the id for the layout site created earlier
	Then the response status code should return "400" responseCode
	And I get the id from the response and call layout sites endpoint using the same id parameter
	Then the response status code should return "200" responseCode
	
@chipApiRegression @layoutSiteId
Scenario: NGPAPI-5418 Verify that I am able to delete the layout region created earlier after disassociating the layout
	When I call the layout endpoint using the DELETE operation using the id for layout created earlier
	And I call the layout created earlier using the GET operation
	Then the response status code should return "404" responseCode
	When I call the layout sites endpoint using the DELETE operation using the id for the layout site created earlier
	Then the response status code should return "200" responseCode
	And I get the id from the response and call layout sites endpoint using the same id parameter
	Then the response status code should return "404" responseCode
		
