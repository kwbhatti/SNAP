Feature: Components API - The components API works as expected when creating or calling a component or a component instance
			
@chipApiRegression @components
Scenario: Verify that a component can be created and it can be called using the Get method
	Given the url is set to call the "components" endpoint
	And the body is set to "componentBody"
	When the endpoint is called using the "POST" operation
	Then the response status code should return "201" responseCode
	And when I call the components endpoint passing the name parameter to the endpoint
	Then the response status code should return "200" responseCode
	And the "component" reponse should match with the payload while creating "component"	

@chipApiRegression @components
Scenario: Verify that get all components endpoint is working and any random component can be called using the component name
	And the url is set to call the "components" endpoint
	When the endpoint is called using the "GET" operation
	And the response status code should return "200" responseCode
	And I get a random component name from the response and pass it to the url
	When the endpoint is called using the "GET" operation
	And the response status code should return "200" responseCode
	And the response body should have the valid random "component.random.name" in the "name"	

@chipApiRegression @components
Scenario: Verify that the component is created with a null schema property provided no schema property in the payload3
	Given the url is set to call the "components" endpoint
	And the body is set to "componentBodyWithoutSchemaProperty"
	When the endpoint is called using the "POST" operation
	Then the response status code should return "400" responseCode
	
@chipApiRegression @components
	Scenario Outline: Verify that the component api only accepts a json as the value for schema property4
	Given the url is set to call the "components" endpoint
	And the body is set to "<componentBody>"
	When the endpoint is called using the "POST" operation
	Then the response status code should return "400" responseCode
	
Examples:
|componentBody						|
|componentBodyStringSchemaProperty	|
|componentBodyIntSchemaProperty		|

@now1 
Scenario: comp99856-Verify a single or multiple component instances can be created provided a valid component 
	Given I call Components API to create a component to use its id later to create component instances
	And I call component instances enpoint to create "comp99856.componentInstance1.key" component instances using the component id
	Then the response status code should return "201" responseCode
	And I call component instances enpoint to create "comp99856.componentInstance2.key" component instances using the component id
	Then the response status code should return "201" responseCode
	
@now1  
Scenario: comp99856-Verify that I can get component instances for more than one component instance calling the component that they were created for 
			as well as by calling get component instances by using multiple keys in the parameter
	When I call Components API and pass the component name from the above scenario and pass the instances parameter
	Then the response status code should return "200" responseCode
	And I should get the correct number (2), for the component instance in the response
	Then I call Components API get instances and pass the 2 keys for the instances created in the scenario above
	Then the response status code should return "200" responseCode
	And I should get the correct number (2), for the component instance in the response
		
@chipApiRegression @components
Scenario: Verify Component Instance has content_mapper associated with it corresponding to component
	Given I create a component with a content_mapper property in the payload
	Then the response status code should return "201" responseCode
	And I get the id property from the response to create a component instance 
	And I create a component instance using the component id in the payload
	Then the response status code should return "201" responseCode
	And I get the key property from the response for validation
	And I call the component instance endpoint using the key
	Then the response status code should return "200" responseCode   	
	And the response should have the corresponding content_mapper property 
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that a default value of 1.0.0 is assigned to a Component Version created without any assigned
	When I call Components API using POST operation with a valid payload with no version property to create component 1
	Then the response status code should return "201" responseCode
	And the response should have the version property of "1.0.0"

# should version default to 1.0.0
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that I can get a component without using component version in the query as long as the version is 1.0.0
	When I call Components API using GET operation and pass the component 1 name 
	Then the response status code should return "200" responseCode
	And the comonent name should match as well as the version should be "1.0.0"
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that I can create a component instance using the component id from previous scenario and validate the component id, name, version,
			and status associated to the instance
	When I call Components API instance using POST operation using the component-one with version-one.one.one from the previous scenario
	Then the response status code should return "201" responseCode
	And I call Components API instance using GET operation using the component instance key in the request
	Then the response status code should return "200" responseCode
	And the correct component name, id, verion, and status should be in associated to the component instance
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that I am able to create a second version for the same component created earlier by passing the component version in the payload
	When I call Components API using POST operation with a valid payload with version "2.0.0" property to create component 1
	Then the response status code should return "201" responseCode
	And the response should have the version property of "2.0.0"

@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that I can create another Component Instance with component-one with version 2.0.0 and when I get all Component Instances using the 
			Component name parameter, I get both the component intances in the response
	When I call Components API instance using POST operation using the component-one with version-two from the previous scenario
	And I call Components API instance using GET operation using the component name in the query
	Then the response status code should return "200" responseCode
	And I should get the correct number (2), for the component instance in the response
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that if no update is done to the component intance, the current component instance is in the response with the value of version_number set to 1
			if the component instance is called using the versions equal true parameter
	When I call Component API instance GET operation using the key for the "component1.componentInstance1.key" in the url and passing versions parameter set to true
	Then the response status code should return "200" responseCode
	And I should get the correct number (1), for the component instance in the response
	And the version number in the component instance response should be set to 1
	When I call Component API instance GET operation using the key for the "component1.componentInstance2.key" in the url and passing versions parameter set to true
	Then the response status code should return "200" responseCode
	And I should get the correct number (1), for the component instance in the response
	And the version number in the component instance response should be set to 1
	  
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that I am able to get component 1 created in previous scenarios by using component name and component version combinations
			and validate the correct response is associted with the version requested
	When I call Components API using GET operation and pass the component 1 name 
	Then the response status code should return "200" responseCode
	And the comonent name should match as well as the version should be "1.0.0" 
	And the the property value for automation-version is set to the payload property "payloadComponentVersion1"
	When I call Components API using GET operation and pass the component 1 name and component version "1.0.0"
	Then the response status code should return "200" responseCode
	And the comonent name should match as well as the version should be "1.0.0"
	And the the property value for automation-version is set to the payload property "payloadComponentVersion1"
	When I call Components API using GET operation and pass the component 1 name and component version "2.0.0"
	Then the response status code should return "200" responseCode 
	And the comonent name should match as well as the version should be "2.0.0"
	And the the property value for automation-version is set to the payload property "payloadComponentVersion2"
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that the version_number is set to CURRENT for any given component if version = true parameter is not passed
			either by passing component version parameter or without
	When I call the the Component API using the GET operation and pass any random Component name in the parameter
	Then the value of version_number in the response should be set to CURRENT
	When I call the the Component API using the GET operation and pass the above Component name and respective valid component version in the parameter
	Then the value of version_number in the response should be set to CURRENT 
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that the components endpoint returns atleast one component history version even without making any updates
	When I call Components API using GET operation and pass the component 1 name, component version "2.0.0" and the versions set to true
	Then the response status code should return "200" responseCode
	And the value for verison_number should be set to 1
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that I can update an existing component by using the PUT operation and the id, name, and component version stays unchanged
	When I call Components API using a PUT operation for an existing component, component-1, with version "2.0.0" with an updated payload
	Then the response status code should return "200" responseCode
	And the name and component version, "2.0.0" and the id in the response should stay unchanged

@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that the updated version is called if the above component is called using the GET operation
	When I call Components API using GET operation and pass the component 1 name and component version "2.0.0"
	Then the response should have the updated changes in the response
	Then the value of version_number in the response should be set to CURRENT
	
@chipApiRegression @components @now
Scenario: NGPAPI-5551 Verify that all the component versions from the history table are returned when the versions parameter is set to true and highest 
			version is the most up to date
	When I call Components API using GET operation and pass the component 1 name, component version "2.0.0" and the versions set to true
	Then the response should have an array of 2 objects, one for each create/update operation of the component2
	And the component with version_number 2 is the most up to date component
	
@chipApiRegression @components @now #only applies to content mapper property
Scenario: NGPAPI-5551 comp32112-Verify that if I create a component instance from a component and then update the component, the changes to the compoent is 
			reflected in the component instance
	When I call the Components API using the POST operation to create a component
	And I call the Comoonents API instances using the POST operation to create a component instance for the Component created in the previous step
	And I call the Components API using the PUT operation to update the component in the first step
	Then I the update to the Component should also update the Component if the Component instance is called using the GET operation

@chipApiRegression @components @now
Scenario: NGPAPI-5551 comp32112-Verify that I am able to update a component instance multiple times and it would give me the correct number of instances when the
			component instances history table is called using versions equals to true parameter
	When I call the Components API instances using the PUT operation to update the component instance created in the previous scenario with an updated property
	Then the response status code should return "200" responseCode
	Then the Component Instance should return the updated component instance when the component instance GET method is called using the key
	And I call the Component API instanes using the GET method using the Component instane key in the parameter and versions equals true
	Then the response from Component Instances should have the respective (2) numbers of instances
	
	
	
	
	
	
	
	
	
	