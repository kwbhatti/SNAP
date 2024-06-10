package com.natgeo.chip_services.steps;

import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.javascript.host.URL;
import com.natgeo.chip_services.scenarioSteps.ChipApiScenarioSteps;
import com.natgeo.utilities.LoaderUtil;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ChipApiStepDefinitions{
	
	@Steps
	ChipApiScenarioSteps chipSteps;
	String jobName;
    
	
	@Before
	public void setUp(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().intilizeValues();
		jobName=scenario.getName();
	}
	
	@Given("^execution \"([^\"]*)\"$")
    public void execution(String iteration) throws Exception {
		System.out.println("Executing Scenario iteration: "+iteration);
    }
	
	@Given("^the url is set to call the \"([^\"]*)\"$")
	public void the_url_is_set_to_call_the(String baseUrl) {
		chipSteps.restGiven(jobName, baseUrl);
	}
	
	@Given("^the value of header \"([^\"]*)\" is set using a \"([^\"]*)\" value$")
	public void the_value_of_header_is_set_using_a_value(String headerName, String headerValue) throws Exception {
		chipSteps.setHTTPHeader(headerName, headerValue);
	}

	@Given("^the endpoint is set to \"([^\"]*)\"$")
	public void the_endpoint_is_set_to(String endPointReference) throws Exception {
		chipSteps.setEndPoint(endPointReference);
	}

	//pass parameter to the url a parameterVAl is passed to the url
	@Given("^a \"([^\"]*)\" is passed to the url$")
	public void a_is_passed_to_the_url(String parameterVal) throws Exception {
		chipSteps.addParameterValToUrl(parameterVal);
	}
	
	//pass parameter to the url using ? or &
    @When("^a \"([^\"]*)\" is \"([^\"]*)\" with a value of \"([^\"]*)\" to the url$")
    public void a_is_with_a_value_of_to_the_url(String parameter, String action, String parameterVal) throws Exception {
		chipSteps.addParameterToUrl(parameter, action, parameterVal);
    }
    
    //pass random parameter to the url
    @When("^the random \"([^\"]*)\" is passed to the url$")
    public void the_random_is_passed_to_the_url(String contextKey) throws Exception {
    		chipSteps.addParameterValToUrlFromScenarioContext(contextKey);
    }
    
    //pass random parameter to the url using ? or &
    @When("^the \"([^\"]*)\" is \"([^\"]*)\" to the url using the random \"([^\"]*)\"$")
    public void the_is_to_the_url_using_the_random(String parameter, String action, String contextKey) throws Exception {
		chipSteps.addRandomParameterToUrl(parameter, action, contextKey);
    }
	
    @Given("^the body is set to \"([^\"]*)\"$")
    public void the_body_is_set_to(String body) throws Exception {
    		chipSteps.setPayload(body);
    }
    
	@When("^the endpoint is called using the \"([^\"]*)\" operation$")
	public void the_endpoint_is_called_using_the_operation(String crudOperation) throws Exception {
		chipSteps.crudOperation(crudOperation);
	}

	@When("^the response status code should return \"([^\"]*)\" responseCode$")
	public void the_response_status_code_should_return_responseCode(int responseCode) throws Exception {
		chipSteps.validateReturnCode(responseCode);
	}
	
	@Then("^the response body should pass the \"([^\"]*)\" schema validation$")
	public void the_response_body_should_pass_the_schema_validation(String schemaName)  {
		chipSteps.validateSchema(schemaName);
	}	
	   
	@When("^the response body should have the valid \"([^\"]*)\" in the \"([^\"]*)\"$")
	public void the_response_body_should_have_the_valid_in_the(String value, String jsonPath) throws Exception {
		chipSteps.validateJsonPathValue(value, jsonPath);
	}
	
	@When("^the response body should have the valid \"([^\"]*)\" in the \"([^\"]*)\" $")
    public void the_response_body_should_have_the_valid_in_the_int(String value, String jsonPath) throws Exception {
		chipSteps.validateJsonPathValue(value, jsonPath);
    }
	
    @Then("^the response body should have the valid random \"([^\"]*)\" in the \"([^\"]*)\"$")
    public void the_response_body_should_have_the_valid_random_in_the(String contextKey, String jsonPath) throws Exception {
		chipSteps.validateRandomJsonPathValue(contextKey, jsonPath);
    }
	    
    @When("^I get a random \"([^\"]*)\" from the array of \"([^\"]*)\" from the reponse and saved as \"([^\"]*)\"$")
    public void i_get_a_random_from_the_array_of_from_the_reponse_and_saved_as(ArrayList<String> property, String api, ArrayList<String> contextKey) throws Exception {
    		chipSteps.getRandomPropsValuesFromResponseArray(property, contextKey);
    }
    
    @Then("^the \"([^\"]*)\" reponse should match with the payload while creating \"([^\"]*)\"$")
    public void the_reponse_should_match_with_the_payload_while_creating(String responseApi, String requestPayload) throws Exception {
		chipSteps.validateResponseWithRequestPayload(responseApi, requestPayload);
    }
    
    @When("^the responseBody \"([^\"]*)\" returns an array of \"([^\"]*)\" objects$")
    public void the_responseBody_returns_an_array_of_objects(String parent, int arraySize) throws Exception {
    		chipSteps.validateResponseArraySize(parent, arraySize);
    }
    
    @Then("^I get the \"([^\"]*)\" from the response and save it as \"([^\"]*)\"$")
    public void i_get_the_from_the_response_and_save_it_as(String jsonPath, String contextKey) throws Exception {
    		chipSteps.getJsonPathValue(jsonPath, contextKey); 
    }

    @Given("^I create a component$")
    public void i_create_a_component() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setPayload("componentBody");
		chipSteps.crudOperation("POST");
		chipSteps.validateReturnCode(201);
		chipSteps.getJsonPathValue("id", "component.random.id"); 
		chipSteps.getJsonPathValue("name", "component.random.name"); 
    }
    
    @Given("^I create \"([^\"]*)\" component instances for the component$")
    public void i_create_component_instances_for_the_component(int numberOfComponents) throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.setHTTPHeader("apikey", "valid");
    		for (int i = 0; i < numberOfComponents; i++) {
        		chipSteps.setPayload("componentInstanceBody");
        		chipSteps.crudOperation("POST");
        		chipSteps.validateReturnCode(201);
    		}
    }
    
    @When("^the components endpoint is called using GET to get all instances for a given component$")
    public void the_components_endpoint_is_called_using_GET_to_get_all_instances_for_a_given_component() throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.addParameterValToUrlFromScenarioContext("component.random.name");
		chipSteps.addParameterValToUrl("/instances");
		chipSteps.crudOperation("GET");
    }
    
    @Given("^I get the key property from the response and call the component instance endpoint using the key as a parameter$")
    public void i_get_the_key_property_from_the_response_and_call_the_component_instance_endpoint_using_the_key_as_a_parameter() throws Exception {
		chipSteps.getJsonPathValue("key", "componentInstance.create.key"); 
		chipSteps.addRandomParameterToUrl("key", "passed", "componentInstance.create.key");
		chipSteps.crudOperation("GET");
    }
    
    @Given("^I call \"([^\"]*)\" endpoint$")
    public void i_call_endpoint(String endPointReference) throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint(endPointReference);
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.crudOperation("GET");
		chipSteps.validateReturnCode(200);
    }
    
    @Given("^I get \"([^\"]*)\" random keys from the componentInstances response and are passed to the component Instance endpoint$")
    public void i_get_random_keys_from_the_componentInstances_response_and_are_passed_to_the_component_Instance_endpoint(int numberOfKeys) throws Exception {  	
    	for (int i = 1; i <= numberOfKeys; i++) {
			ArrayList<String> key = new ArrayList<>();
	    		key.add("key");
	    		ArrayList<String> keyValue = new ArrayList<>();
	    		String thisKeyValue = "componentInstances.random.key"+i;
	    		System.out.println("the key valid is " + thisKeyValue);
	    		keyValue.add(thisKeyValue);
	    		chipSteps.getRandomPropsValuesFromResponseArray(key, keyValue);
		}
		chipSteps.addRandomParameterToUrl("key", "passed", "componentInstances.random.key1");
		for (int i = 2; i <= numberOfKeys; i++) {
	    		String thisKeyValue = "componentInstances.random.key"+i;
	    		chipSteps.addRandomParameterToUrl("key", "commaSeperated", thisKeyValue);
		}
    }
    
    @Given("^I get a random component key from the response body and pass it to the component endpoint as a parameter$")
    public void i_get_a_random_component_key_from_the_response_body_and_pass_it_to_the_component_endpoint_as_a_parameter() throws Exception {
    		ArrayList<String> key = new ArrayList<>();
		key.add("key");
		ArrayList<String> keyValue = new ArrayList<>();
		keyValue.add("component.random.key");
		chipSteps.getRandomPropsValuesFromResponseArray(key, keyValue);
		chipSteps.addRandomParameterToUrl("key", "passed", "component.random.key");
    }
    
    @Given("^the url is set to call the \"([^\"]*)\" endpoint$")
    public void the_url_is_set_to_call_the_endpoint(String endPointReference) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint(endPointReference);
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
    }
    
    @When("^I get a random component name from the response and pass it to the url$")
    public void i_get_a_random_component_name_from_the_response_and_pass_it_to_the_url() throws Exception {
    		ArrayList<String> key = new ArrayList<>();
		key.add("name");
		ArrayList<String> keyValue = new ArrayList<>();
		keyValue.add("component.random.name");
		chipSteps.getRandomPropsValuesFromResponseArray(key, keyValue);
		chipSteps.addParameterValToUrlFromScenarioContext("component.random.name");
    }
    
    @Given("^when I call the components endpoint passing the name parameter to the endpoint$")
    public void when_I_call_the_components_endpoint_passing_the_name_parameter_to_the_endpoint() throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.addParameterValToUrlFromScenarioContext("payload.component.name");
		chipSteps.crudOperation("GET");
    }
    
	@When("^the parameters \"([^\"]*)\" are passed with the values \"([^\"]*)\"$")
	public void the_parameters_are_passed_with_the_values(ArrayList<String> parameters, ArrayList<String> values)  {
//		chipSteps.passParameters(parameters, values);
	}
	
    @Given("^a valid url parameter is passed to the endpoint$")
    public void a_valid_url_parameter_is_passed_to_the_endpoint() throws Exception {
    }
    
    @Given("^I call the Aggregation Api passing an \"([^\"]*)\" Apikey in the \"([^\"]*)\"$")
    public void i_call_the_Aggregation_Api_passing_an_Apikey_in_the(String headerValue, String headerName) throws Exception {
    		chipSteps.setHTTPHeader(headerName, headerValue);
    		chipSteps.addParameterToUrl("url", "passed", "https://www.nationalgeographic.co.uk/content-package");
    		chipSteps.crudOperation("GET");
    }
    
    @Given("^that I have all the layouts uris and correponding domain names$")
    public void that_I_have_all_the_layouts_uris_and_correponding_domain_names() throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.crudOperation("GET");
		chipSteps.validateReturnCode(200);
		chipSteps.getConvertAllLayoutUriAndDomainToUrls();
    }
    
    @Given("^I set the url to call aggregation pages using valid headers$")
    public void i_set_the_url_to_call_aggregation_pages_using_valid_headers() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("webAggregationPages");
		chipSteps.setHTTPHeader("apikey", "valid");
    }

    @Then("^I should get a (\\d+) if I iterate through all the url extracted from layouts$")
    public void i_should_get_a_if_I_iterate_through_all_the_url_extracted_from_layouts(int arg1) throws Exception {
    		ArrayList<String> urls = chipSteps.urls;
    		ArrayList<String> failUrls400 = new ArrayList<>();
    		ArrayList<String> failUrls500 = new ArrayList<>();
    		ArrayList<String> failUrlsother = new ArrayList<>();
    		ArrayList<String> failUrls404 = new ArrayList<>();
    		ArrayList<String> passed200 = new ArrayList<>();
    		int faliures = 0;
		for (int i = 0; i < urls.size(); i++) {
    			chipSteps.restGiven(jobName, "natgeo BaseURL");
    			chipSteps.setEndPoint("webAggregationPages");
    			chipSteps.setHTTPHeader("apikey", "valid");
			chipSteps.addParameterToUrl("url", "passed", urls.get(i));
			chipSteps.crudOperation("GET");
//			chipSteps.validateReturnCode(200);
			chipSteps.findSubStringFromResponse("DynamicPackage");
			if (chipSteps.responseCode() != 200) {
				faliures++;
				if (chipSteps.responseCode() == 400) {
					failUrls400.add(urls.get(i).toString());
				} else if (chipSteps.responseCode() == 404) {
					failUrls404.add(urls.get(i).toString());
				} else if (chipSteps.responseCode() == 500) {
					failUrls500.add(urls.get(i).toString());
				} else {
					failUrlsother.add(urls.get(i).toString());
				}
				System.out.println("The following url did not return a 200 "+urls.get(i)+" instead it was "+chipSteps.responseCode());
			} else {
				passed200.add(urls.get(i).toString());
			}
		}
		System.out.println("************************* START 400 *************************");
		for (int i = 0; i< failUrls400.size(); i++) {
			String failUrlString = failUrls400.get(i);
			System.out.println(failUrlString);
		}
		System.out.println("************************* END 400 *************************");
		System.out.println("************************* START 404 *************************");
		for (int i = 0; i< failUrls404.size(); i++) {
			String failUrlString = failUrls404.get(i);
			System.out.println(failUrlString);
		}
		System.out.println("************************* END 404 *************************");
		System.out.println("************************* START 500 *************************");
		for (int i = 0; i< failUrls500.size(); i++) {
			String failUrlString = failUrls500.get(i);
			System.out.println(failUrlString);
		}
		System.out.println("************************* END 500 *************************");
		System.out.println("************************* START OTHER *************************");
		for (int i = 0; i< failUrlsother.size(); i++) {
			String failUrlString = failUrlsother.get(i);
			System.out.println(failUrlString);
		}
		System.out.println("************************* END OTHER *************************");
		System.out.println("************************* START 200 *************************");
		for (int i = 0; i< passed200.size(); i++) {
			String passUrlString = passed200.get(i);
			System.out.println(passUrlString);
		}
		System.out.println("************************* END 200 *************************");
		System.out.println("the total number of faliures is "+faliures+" out of "+urls.size());
		chipSteps.faliureAssertion(faliures);
    }
    
    @Given("^an invalid resource is passed to the configSites endpoint$")
    public void an_invalid_resource_is_passed_to_the_configSites_endpoint() throws Exception {
    		chipSteps.addParameterValToUrl("invalidResource");
    }
    
    @Given("^the endpoint is set to call configSites using a valid apikey$")
    public void the_endpoint_is_set_to_call_configSites_using_a_valid_apikey() throws Exception {
		chipSteps.setEndPoint("configs");
		chipSteps.setHTTPHeader("apikey", "valid");
    }
    
    @Given("^I get all the configs from configs API$")
    public void i_get_all_the_configs_from_configs_API() throws Exception {
		chipSteps.setEndPoint("configs");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.crudOperation("GET");
		chipSteps.validateReturnCode(200);
    }
    
    @Given("^I randomly pick a config object from the respone and get the domain for a site$")
    public void i_randomly_pick_a_config_object_from_the_respone_and_get_the_domain_for_a_site() throws Exception {
		chipSteps.getRandomSitesDomainFromConfigs();
    }

    @Given("^I call the configs site endpoint passing the domain as the parameter$")
    public void i_call_the_configs_site_endpoint_passing_the_domain_as_the_parameter() throws Exception {
		chipSteps.setEndPoint("configs");
		chipSteps.addParameterValToUrl("sites");
		chipSteps.addSiteParametersToConfig("useContext");
		chipSteps.crudOperation("GET");
    }
    
    @Then("^the response should equal the data property when calling all configs$")
    public void the_response_should_equal_the_data_property_when_calling_all_configs() throws Exception {
    		chipSteps.validateConfigDataProperty();
    }
    
    @Then("^the id should also match the id originally retrieved from get all configs$")
    public void the_id_should_also_match_the_id_originally_retrieved_from_get_all_configs() throws Exception {
    		chipSteps.validateConfigId();
    }
    
    @Given("^I randomly pick a config object from the respone and get the domain and page for a custom page$")
    public void i_randomly_pick_a_config_object_from_the_respone_and_get_the_domain_and_page_for_a_custom_page() throws Exception {
		chipSteps.getRandomCustomPagesPageAndDomainFromConfigs();
    }

    @Given("^I call the configs site endpoint passing the domain and page as the parameters$")
    public void i_call_the_configs_site_endpoint_passing_the_domain_and_page_as_the_parameters() throws Exception {
    		chipSteps.setEndPoint("configs");
		chipSteps.addParameterValToUrl("custom_pages");
		chipSteps.addCustomPageParametersToConfig("useContext", "useContext");
		chipSteps.crudOperation("GET");
    }
    
    @Given("^add the queryparameters$")
    public void add_the_queryparameters() throws Exception {
		chipSteps.addParameterValToUrl("sites");
		chipSteps.addParameterToUrl("domain", "passed", "practiceAutomation");
		chipSteps.crudOperation("POST");
    }
    
    @When("^I create a layout with a config property in the payload$")
    public void i_create_a_layout_with_a_config_property_in_the_payload() throws Exception {
    		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
    		chipSteps.setLayoutPayloadWithConfigs("layoutRequestWithConfig");
    		chipSteps.crudOperation("POST");
    		chipSteps.validateReturnCode(201);
    		chipSteps.getJsonPathValue("id", "layoutId");
    }
    
    @When("^I call aggregation using the same uri and domain for the layout$")
    public void i_call_aggregation_using_the_same_uri_and_domain_for_the_layout() throws Exception {
		chipSteps.setEndPoint("webAggregationPages");
		chipSteps.setAggregationParametersUsingContext();
		chipSteps.crudOperation("GET");
    }
    
    @Then("^aggregation should return me a (\\d+) reponse and it should retain the conig value$")
    public void aggregation_should_return_me_a_reponse_and_it_should_retain_the_conig_value(int responseCode) throws Exception {
		chipSteps.validateReturnCode(responseCode);
		chipSteps.validateJsonPathValue("config-static-value", "config.configStaticProperty");
		chipSteps.validateRandomJsonPathValue("configDynamicProperty", "config.configDynamicProperty");
    }

    @Then("^I clean up and delete the newly created layout$")
    public void i_clean_up_and_delete_the_newly_created_layout() throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.addParameterValToUrlFromScenarioContext("layoutId");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.crudOperation("DELETE");
		chipSteps.validateReturnCode(200);
    }
    
    @Then("^aggregation should return a (\\d+) not found error$")
    public void aggregation_should_return_a_not_found_error(int arg1) throws Exception {
		chipSteps.setEndPoint("webAggregationPages");
		chipSteps.setAggregationParametersUsingContext();
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.crudOperation("GET");
		chipSteps.validateReturnCode(400);
    }

    @Given("^that I call layouts and get a random uri and domain name from the response$")
    public void that_I_call_layouts_and_get_a_random_uri_and_domain_name_from_the_response() throws Exception {
    	chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.crudOperation("GET");
		chipSteps.validateReturnCode(200);
		chipSteps.convertLayoutUriAndDomainToAggregationUrl();
    }

    @Given("^I call aggregation using the same uri and domain name$")
    public void i_call_aggregation_using_the_same_uri_and_domain_name() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("webAggregationPages");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.addRandomParameterToUrl("url", "passed", "aggregationUrl");
		chipSteps.crudOperation("GET");
		chipSteps.validateReturnCode(200);
    }

    @Then("^aggregation should not have content mappers in the response body under any regions\\.main$")
    public void aggregation_should_not_have_content_mappers_in_the_response_body_under_any_regions_main() throws Exception {
		chipSteps.aggregationDoesNotContainsContentMappers();
    }

    @Given("^I create a component with a content_mapper property in the payload$")
    public void i_create_a_component_with_a_content_mapper_property_in_the_payload() throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
    		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setComponentPayloadWithStringContentMapper("componentRequestWithStringContentMapper");
		chipSteps.crudOperation("POST");
    }

    @Given("^I get the id property from the response to create a component instance$")
    public void i_get_the_id_property_from_the_response_to_create_a_component_instance() throws Exception {
    		chipSteps.getJsonPathValue("id", "component.id"); 
    }

    @Given("^I create a component instance using the component id in the payload$")
    public void i_create_a_component_instance_using_the_component_id_in_the_payload() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
    		chipSteps.setEndPoint("componentInstances");
    		chipSteps.setHTTPHeader("apikey", "valid");
    		chipSteps.setHTTPHeader("bypass-cache", "true");
    		chipSteps.setHTTPHeader("Content-Type", "application/json");
    		chipSteps.setComponentInstancePayloadBasic("componentInstanceRequestBasic", "component.id", "original instance associated with component 1, version 1.0.0");
    		chipSteps.crudOperation("POST");
    }

    @Given("^I get the key property from the response for validation$")
    public void i_get_the_key_property_from_the_response_for_validation() throws Exception {
		chipSteps.getJsonPathValue("key", "componentInstance.key"); 
    }

    @Given("^I call the component instance endpoint using the key$")
    public void i_call_the_component_instance_endpoint_using_the_key() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addRandomParameterToUrl("key", "passed", "componentInstance.key");
		chipSteps.crudOperation("GET");
    }

    @Given("^the response should have the corresponding content_mapper property$")
    public void the_response_should_have_the_corresponding_content_mapper_property() throws Exception {
		chipSteps.validateRandomJsonPathValue("payloadContentMapper", "[0].content_mapper");
    }

    @When("^I call layouttypes endpoint using natgeo base URL$")
    public void i_call_layouttypes_endpoint_using_natgeo_base_URL() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
    		chipSteps.setEndPoint("layoutTypes");
    		chipSteps.setHTTPHeader("apikey2", "valid");
    		chipSteps.setHTTPHeader("bypass-cache", "true");
    		chipSteps.setHTTPHeader("Content-Type", "application/json");
    		chipSteps.crudOperation("GET");
    }
    
    @Given("^I get one layouttype from the responses and call layout types endpoint using id parameter$")
    public void i_get_one_layouttype_from_the_responses_and_call_layout_types_endpoint_using_id_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
		chipSteps.getRandomPropValueFromResponseArray("id", "layouttype.id");
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("layouttype.id");
		chipSteps.crudOperation("GET");
    }

    @Given("^the id in the response should match the id in the request parameter$")
    public void the_id_in_the_response_should_match_the_id_in_the_request_parameter() throws Exception {
		chipSteps.validateRandomJsonPathValue("layouttype.id", "id");
    }
    
    @When("^I call layouttypes endpoint using POST operation with a valid payload$")
    public void i_call_layouttypes_endpoint_using_POST_operation_with_a_valid_payload() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
    		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setLayoutTypePayload();
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST");	
		chipSteps.getJsonPathValue("id", "createlayouttype.id");
    }

    @When("^I get the id from the response and call layouttypes endpoint using the same id parameter$")
    public void i_get_the_id_from_the_response_and_call_layouttypes_endpoint_using_the_same_id_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayouttype.id");
		chipSteps.crudOperation("GET");
    }
    
    @Given("^the response name property should match the name while creating the layouttype$")
    public void the_response_name_property_should_match_the_name_while_creating_the_layouttype() throws Exception {
    		chipSteps.validateRandomJsonPathValue("createlayouttype.name", "name");
    }
    
    @When("^I call the layouts endpoint using the POST operation using the a valid payload with the layouttype created in the previous scenario$")
    public void i_call_the_layouts_endpoint_using_the_POST_operation_using_the_a_valid_payload_with_the_layouttype_created_in_the_previous_scenario() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setLayoutPayloadUsingLayoutType();
		chipSteps.crudOperation("POST");	
    }

    @When("^I retrieve the layout id from the response and call layouts endpoint using the layout id property$")
    public void i_retrieve_the_layout_id_from_the_response_and_call_layouts_endpoint_using_the_layout_id_property() throws Exception {
		chipSteps.getJsonPathValue("id", "createlayout.id");
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayout.id");
		chipSteps.crudOperation("GET");	
    }

    @Then("^the response should have the correct layout type in the response body$")
    public void the_response_should_have_the_correct_layout_type_in_the_response_body() throws Exception {
    		chipSteps.validateRandomJsonPathValue("createlayouttype.name", "layoutType");
    }

    @When("^I call the layouttypes endpoint using the PUT operation with an updated payload$")
    public void i_call_the_layouttypes_endpoint_using_the_PUT_operation_with_an_updated_payload() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayouttype.id");
		chipSteps.setLayoutTypePayload();
		chipSteps.crudOperation("PUT");	
		chipSteps.getJsonPathValue("id", "createlayouttype.id");
    }

    @When("^I call the layouttypes endpoint using the GET operation using the id for the layouttype created earlier$")
    public void i_call_the_layouttypes_endpoint_using_the_GET_operation_using_the_id_for_the_layouttype_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayouttype.id");
		chipSteps.crudOperation("GET");	
    }

    @Then("^the layouttype response should have the updated layouttype in the response body$")
    public void the_layouttype_response_should_have_the_updated_layouttype_in_the_response_body() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayouttype.name", "name");
    }

    @When("^I call the layout created earlier using the GET operation$")
    public void i_call_the_layout_created_earlier_using_the_GET_operation() throws Exception {
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayout.id");
		chipSteps.crudOperation("GET");	
    }

    @Then("^the layout response should have the updated layouttype in the response body$")
    public void the_layout_response_should_have_the_updated_layouttype_in_the_response_body() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayouttype.name", "layoutType");
    }

    @When("^I call the layouttype endpoint using the DELETE operation using the id for the layouttype created earlier$")
    public void i_call_the_layouttype_endpoint_using_the_DELETE_operation_using_the_id_for_the_layouttype_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayouttype.id");
		chipSteps.crudOperation("DELETE");	
    }

    @When("^I call the layouttype created earlier using the GET operation$")
    public void i_call_the_layouttype_created_earlier_using_the_GET_operation() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutTypes");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayouttype.id");
		chipSteps.crudOperation("GET");	
    }
    
    @When("^I call layout sites endpoint using natgeo base URL$")
    public void i_call_layout_sites_endpoint_using_natgeo_base_URL() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
    }
    
    @When("^I get one layout sites from the responses and call layout types endpoint using id parameter$")
    public void i_get_one_layout_sites_from_the_responses_and_call_layout_types_endpoint_using_id_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
		chipSteps.getRandomPropValueFromResponseArray("id", "layoutsite.id");
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("layoutsite.id");
		chipSteps.crudOperation("GET");
    }

    @When("^the id in get layout site by id response should match the id in the request parameter$")
    public void the_id_in_get_layout_site_by_id_response_should_match_the_id_in_the_request_parameter() throws Exception {
		chipSteps.validateRandomJsonPathValue("layoutsite.id", "id");
    }
    
    @When("^I call layout sites endpoint using POST operation with a valid payload$")
    public void i_call_layout_sites_endpoint_using_POST_operation_with_a_valid_payload() throws Exception {
	    	chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setLayoutSitesPayload();
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST");	
		chipSteps.getJsonPathValue("id", "createlayoutsite.id");
    }

    @Then("^I get the id from the response and call layout sites endpoint using the same id parameter$")
    public void i_get_the_id_from_the_response_and_call_layout_sites_endpoint_using_the_same_id_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutsite.id");
		chipSteps.crudOperation("GET");
    }

    @Then("^the get layout site by id response name property should match the name while creating the layout site$")
    public void the_get_layout_site_by_id_response_name_property_should_match_the_name_while_creating_the_layout_site() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayoutsite.domainName", "domain_name");
    }
    
    @When("^I call the layouts endpoint using the POST operation using the a valid payload with the layout site created in the previous scenario$")
    public void i_call_the_layouts_endpoint_using_the_POST_operation_using_the_a_valid_payload_with_the_layout_site_created_in_the_previous_scenario() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setLayoutPayloadUsingLayoutSite();
		chipSteps.crudOperation("POST");
    }

    @Then("^the response should have the correct layout site in the response body$")
    public void the_response_should_have_the_correct_layout_site_in_the_response_body() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayoutsite.domainName", "domainName");
    }
    
    @When("^I call the layout sites endpoint using the PUT operation with an updated payload$")
    public void i_call_the_layout_sites_endpoint_using_the_PUT_operation_with_an_updated_payload() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutsite.id");
		chipSteps.setLayoutSitesPayload();
		chipSteps.crudOperation("PUT");	
		chipSteps.getJsonPathValue("id", "createlayoutsite.id");
    }

    @Then("^I call the layout sites endpoint using the GET operation using the id for the layout site created earlier$")
    public void i_call_the_layout_sites_endpoint_using_the_GET_operation_using_the_id_for_the_layout_site_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutsite.id");
		chipSteps.crudOperation("GET");	
    }

    @Then("^the layout site response should have the updated layout site in the response body$")
    public void the_layout_site_response_should_have_the_updated_layout_site_in_the_response_body() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayoutsite.domainName", "domain_name");
    }
    
    @Then("^the layout response should have the updated layout site domain name in the response body$")
    public void the_layout_response_should_have_the_updated_layout_site_domain_name_in_the_response_body() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayoutsite.domainName", "domainName");
    }
    
    @When("^I call the layout sites endpoint using the DELETE operation using the id for the layout site created earlier$")
    public void i_call_the_layout_sites_endpoint_using_the_DELETE_operation_using_the_id_for_the_layout_site_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutsite.id");
		chipSteps.crudOperation("DELETE");
    }

    @When("^I call the layout site created earlier using the GET operation$")
    public void i_call_the_layout_site_created_earlier_using_the_GET_operation() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutSites");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutsite.id");
		chipSteps.crudOperation("GET");
    }
    
    @When("^I call layout regions endpoint using natgeo base URL$")
    public void i_call_layout_regions_endpoint_using_natgeo_base_URL() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
    }
    
    @When("^I get one layout region from the responses and call layout regions endpoint using id parameter$")
    public void i_get_one_layout_region_from_the_responses_and_call_layout_regions_endpoint_using_id_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
		chipSteps.getRandomPropValueFromResponseArray("id", "layoutregion.id");
		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("layoutregion.id");
		chipSteps.crudOperation("GET");
    }

    @Then("^the id in get layout region by id response should match the id in the request parameter$")
    public void the_id_in_get_layout_region_by_id_response_should_match_the_id_in_the_request_parameter() throws Exception {
		chipSteps.validateRandomJsonPathValue("layoutregion.id", "id");
    }
    
    @When("^I call layout region endpoint using POST operation with a valid payload$")
    public void i_call_layout_region_endpoint_using_POST_operation_with_a_valid_payload() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setLayoutRegionsPayload();
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST");	
		chipSteps.getJsonPathValue("id", "createlayoutregion.id");
    }


    @Then("^I get the id from the response and call layout regions endpoint using the same id parameter$")
    public void i_get_the_id_from_the_response_and_call_layout_regions_endpoint_using_the_same_id_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutregion.id");
		chipSteps.crudOperation("GET");
    }

    @Then("^the get layout region by id response name property should match the name while creating the layout region$")
    public void the_get_layout_region_by_id_response_name_property_should_match_the_name_while_creating_the_layout_region() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayoutregion.regionName", "name");
    }
    
    @When("^I call the layouts endpoint using the POST operation using the a valid payload with the layout region created in the previous scenario$")
    public void i_call_the_layouts_endpoint_using_the_POST_operation_using_the_a_valid_payload_with_the_layout_region_created_in_the_previous_scenario() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setLayoutPayloadUsingLayoutRegion();
		chipSteps.crudOperation("POST");
    }

    @Then("^the response should have the correct layout region in the response body$")
    public void the_response_should_have_the_correct_layout_region_in_the_response_body() throws Exception {
		chipSteps.layoutContainsSpecificRegionFirstValue();
    }
    
    @When("^I call the layout regions endpoint using the PUT operation with an updated payload$")
    public void i_call_the_layout_regions_endpoint_using_the_PUT_operation_with_an_updated_payload() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutregion.id");
		chipSteps.setLayoutRegionsPayload();
		chipSteps.crudOperation("PUT");	
		chipSteps.getJsonPathValue("id", "createlayoutregion.id");
    }

    @Given("^I call the layout regions endpoint using the GET operation using the id for the layout region created earlier$")
    public void i_call_the_layout_regions_endpoint_using_the_GET_operation_using_the_id_for_the_layout_region_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutregion.id");
		chipSteps.crudOperation("GET");
    }

    @Then("^the layout regions response should have the updated layout region in the response body$")
    public void the_layout_regions_response_should_have_the_updated_layout_region_in_the_response_body() throws Exception {
		chipSteps.validateRandomJsonPathValue("createlayoutregion.regionName", "name");
	}
    
    @Then("^the layout response should have the updated layout region name in the response body$")
    public void the_layout_response_should_have_the_updated_layout_region_name_in_the_response_body() throws Exception {
		chipSteps.layoutContainsSpecificRegionFirstValue();
    }
    
    @When("^I call the layout regions endpoint using the DELETE operation using the id for the layout region created earlier$")
    public void i_call_the_layout_regions_endpoint_using_the_DELETE_operation_using_the_id_for_the_layout_region_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutregion.id");
		chipSteps.crudOperation("DELETE");
    }


    @When("^I call the layout region created earlier using the GET operation$")
    public void i_call_the_layout_region_created_earlier_using_the_GET_operation() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutRegions");
		chipSteps.setHTTPHeader("apikey2", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayoutregion.id");
		chipSteps.crudOperation("GET");
    }
    
    @Then("^I call the layout endpoint using the DELETE operation using the id for layout created earlier$")
    public void i_call_the_layout_endpoint_using_the_DELETE_operation_using_the_id_for_layout_created_earlier() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("layoutLayouts");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.addParameterValToUrlFromScenarioContext("createlayout.id");
		chipSteps.crudOperation("DELETE");
    }
    
    @When("^I call aggregation endpoint using natgeo base URL using an invalid url as the parameter value$")
    public void i_call_aggregation_endpoint_using_natgeo_base_URL_using_an_invalid_url_as_the_parameter_value() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
    		chipSteps.setEndPoint("webAggregationPages");
		chipSteps.addParameterToUrl("url", "passed", "https://www.nationalgeographic.co.uk/invalid-test");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.crudOperation("GET");
    }

    @Then("^the response should be, CustomError: fetch error$")
    public void the_response_should_be_CustomError_fetch_error() throws Exception {
		chipSteps.validateResponseString("\"CustomError: fetch error\"");
    }
    
    @When("^I call Components API using POST operation with a valid payload with no version property to create component (\\d+)$")
    public void i_call_Components_API_using_POST_operation_with_a_valid_payload_with_no_version_property_to_create_component(int junk) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setComponentPayloadWithoutVersions();
		chipSteps.crudOperation("POST"); 
		chipSteps.getJsonPathValue("id", "component1.id");
    }
    
    @Given("^the response should have the version property of \"([^\"]*)\"$")
    public void the_response_should_have_the_version_property_of(String componentVersion) throws Exception {
		chipSteps.validateJsonPathValue(componentVersion, "version");
    }

    @When("^I call Components API using POST operation with a valid payload with version \"([^\"]*)\" property to create component (\\d+)$")
    public void i_call_Components_API_using_POST_operation_with_a_valid_payload_with_version_property_to_create_component(String componentVersion, int junk) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setComponentPayloadWithVersionsForExistingComponent(componentVersion);
		chipSteps.crudOperation("POST");
		chipSteps.getJsonPathValue("id", "component2.id");
    }

    @When("^I call Components API using GET operation and pass the component (\\d+) name$")
    public void i_call_Components_API_using_GET_operation_and_pass_the_component_name(int junk) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("payloadComponentName");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
    }

    @Then("^the comonent name should match as well as the version should be \"([^\"]*)\"$")
    public void the_comonent_name_should_match_as_well_as_the_version_should_be(String componentVersion) throws Exception {
    		chipSteps.validateRandomJsonPathValue("payloadComponentName", "name");
    		chipSteps.validateJsonPathValue(componentVersion, "version");
    }

    @When("^I call Components API using GET operation and pass the component (\\d+) name and component version \"([^\"]*)\"$")
    public void i_call_Components_API_using_GET_operation_and_pass_the_component_name_and_component_version(int junk, String componentVersion) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("payloadComponentName");
		chipSteps.addParameterToUrl("componentVersion", "passed", componentVersion);
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
    }
    
    @Given("^the the property value for automation-version is set to the payload property \"([^\"]*)\"$")
    public void the_the_property_value_for_automation_version_is_set_to_the_payload_property(String payloadValue) throws Exception {
		chipSteps.validateRandomJsonPathValue(payloadValue, "schema.automation-version");
    }

    @When("^I call the the Component API using the GET operation and pass any random Component name in the parameter$")
    public void i_call_the_the_Component_API_using_the_GET_operation_and_pass_any_random_Component_name_in_the_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
		chipSteps.getRandomComponentNameAndVersion();
		chipSteps.addParameterValToUrlFromScenarioContext("randomComponent.name");
		chipSteps.crudOperation("GET");
    }

    @Then("^the value of version_number in the response should be set to CURRENT$")
    public void the_value_of_version_number_in_the_response_should_be_set_to_CURRENT() throws Exception {
    		chipSteps.validateJsonPathValue("CURRENT", "version_number");
    }
    
    @When("^I call the the Component API using the GET operation and pass the above Component name and respective valid component version in the parameter$")
    public void i_call_the_the_Component_API_using_the_GET_operation_and_pass_the_above_Component_name_and_respective_valid_component_version_in_the_parameter() throws Exception {
		chipSteps.addRandomParameterToUrl("componentVersion", "passed", "randomComponent.componentVersion11");
		chipSteps.crudOperation("GET");
    }

    @Given("^the value for verison_number should be set to (\\d+)$")
    public void the_value_for_verison_number_should_be_set_to(String version_number) throws Exception {
		chipSteps.validateJsonPathValue(version_number, "[0].version_number");
    }
    
    @When("^I call Components API using GET operation and pass the component (\\d+) name, component version \"([^\"]*)\" and the versions set to true$")
    public void i_call_Components_API_using_GET_operation_and_pass_the_component_name_component_version_and_the_versions_set_to_true(int junk, String componentVersion) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("payloadComponentName");
		chipSteps.addParameterToUrl("componentVersion", "passed", componentVersion);
		chipSteps.addParameterToUrl("versions", "added", "true");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");    
	} 
    
    @When("^I call Components API using a PUT operation for an existing component, component-(\\d+), with version \"([^\"]*)\" with an updated payload$")
    public void i_call_Components_API_using_a_PUT_operation_for_an_existing_component_component_with_version_with_an_updated_payload(int junk, String componentVersion) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("payloadComponentName");
		chipSteps.addParameterToUrl("componentVersion", "passed", componentVersion);
		chipSteps.setComponentUpdatePayloadWithVersions(componentVersion);
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("PUT"); 
    }
    
    @Given("^the name and component version, \"([^\"]*)\" and the id in the response should stay unchanged$")
    public void the_name_and_component_version_and_the_id_in_the_response_should_stay_unchanged(String componentVersion) throws Exception {
    		chipSteps.validateRandomJsonPathValue("component2.id", "id");
		chipSteps.validateRandomJsonPathValue("payloadComponentName", "name");
		chipSteps.validateJsonPathValue(componentVersion, "version");
    }

    @Then("^the response should have the updated changes in the response$")
    public void the_response_should_have_the_updated_changes_in_the_response() throws Exception {
    		chipSteps.validateRandomJsonPathValue("payloadComponentVersion2-updated", "schema.automation-version");
    }
    
    @Then("^the response should have an array of (\\d+) objects, one for each create/update operation of the component(\\d+)$")
    public void the_response_should_have_an_array_of_objects_one_for_each_create_update_operation_of_the_component(int arraySize, int junk) throws Exception {
    		chipSteps.validateResponseArraySize(".", arraySize);
    }


    @Then("^the component with version_number (\\d+) is the most up to date component$")
    public void the_component_with_version_number_is_the_most_up_to_date_component(int finalVersion) throws Exception {
    		chipSteps.validateMostUpdatedVersionComponent(finalVersion);
    }
    
    @When("^I call Components API instance using POST operation using the component-one with version-one\\.one\\.one from the previous scenario$")
    public void i_call_Components_API_instance_using_POST_operation_using_the_component_one_with_version_one_one_one_from_the_previous_scenario() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.setComponentInstancePayloadBasic("componentInstanceRequestBasic", "component1.id", "original instance associated with component 1, version 1.0.0");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST"); 
		chipSteps.getJsonPathValue("key", "component1.componentInstance1.key");
    }

    @When("^I call Components API instance using GET operation using the component instance key in the request$")
    public void i_call_Components_API_instance_using_GET_operation_using_the_component_instance_key_in_the_request() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addRandomParameterToUrl("key", "passed", "component1.componentInstance1.key");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
    }

    @When("^the correct component name, id, verion, and status should be in associated to the component instance$")
    public void the_correct_component_name_id_verion_and_status_should_be_in_associated_to_the_component_instance() throws Exception {
    		chipSteps.validateRandomJsonPathValue("component1.id", "[0].component_id");
    		chipSteps.validateJsonPathValue("1.0.0", "[0].version");
    		chipSteps.validateRandomJsonPathValue("payloadComponentName", "[0].name");
    }
    
    @When("^I call Components API instance using POST operation using the component-one with version-two from the previous scenario$")
    public void i_call_Components_API_instance_using_POST_operation_using_the_component_one_with_version_two_from_the_previous_scenario() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.setComponentInstancePayloadBasic("componentInstanceRequestBasic", "component2.id", "original instance associated with component 1, version 2.0.0");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST"); 
		chipSteps.getJsonPathValue("key", "component1.componentInstance2.key");
    }

    @When("^I call Components API instance using GET operation using the component name in the query$")
    public void i_call_Components_API_instance_using_GET_operation_using_the_component_name_in_the_query() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("payloadComponentName");
		chipSteps.addParameterValToUrl("/instances");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET");
    }

    @Then("^I should get the correct number \\((\\d+)\\), for the component instance in the response$")
    public void i_should_get_the_correct_number_for_the_component_instance_in_the_response(int responseArraySize) throws Exception {
		chipSteps.validateResponseArraySize(".", responseArraySize);
    }
    
    @When("^I call Component API instance GET operation using the key for the \"([^\"]*)\" in the url and passing versions parameter set to true$")
    public void i_call_Component_API_instance_GET_operation_using_the_key_for_the_in_the_url_and_passing_versions_parameter_set_to_true(String componentInstanceKey) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addParameterValToUrlFromScenarioContext(componentInstanceKey);
		chipSteps.addParameterToUrl("versions", "passed", "true");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET"); 
    }

    @Then("^the version number in the component instance response should be set to (\\d+)$")
    public void the_version_number_in_the_component_instance_response_should_be_set_to(String propertyValue) throws Exception {
    		chipSteps.validateJsonPathValue(propertyValue, "[0].version_number");
    }
    
    @When("^I call the Components API using the POST operation to create a component$")
    public void i_call_the_Components_API_using_the_POST_operation_to_create_a_component() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setComponentPayloadWithMessageInContentMapper("test-component-comp32112", "comp32112-component", "first time the component got created");
		chipSteps.crudOperation("POST");
		chipSteps.getJsonPathValue("id", "comp32112.compoent.id");
    }

    @When("^I call the Comoonents API instances using the POST operation to create a component instance for the Component created in the previous step$")
    public void i_call_the_Comoonents_API_instances_using_the_POST_operation_to_create_a_component_instance_for_the_Component_created_in_the_previous_step() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.setComponentInstancePayloadBasic("componentInstanceRequestBasic", "comp32112.compoent.id", "first time the component got created");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST"); 
		chipSteps.getJsonPathValue("key", "comp32112.componentInstance.key");
    }

    @When("^I call the Components API using the PUT operation to update the component in the first step$")
    public void i_call_the_Components_API_using_the_PUT_operation_to_update_the_component_in_the_first_step() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("comp32112-component");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setComponentPayloadWithMessageInContentMapper("test-component-comp32112", "comp32112-component", "first update to the component");
		chipSteps.crudOperation("PUT");
    }

    @Then("^I the update to the Component should also update the Component if the Component instance is called using the GET operation$")
    public void i_the_update_to_the_Component_should_also_update_the_Component_if_the_Component_instance_is_called_using_the_GET_operation() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addRandomParameterToUrl("key", "passed", "comp32112.componentInstance.key");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET"); 
    		chipSteps.validateJsonPathValue("first update to the component", "[0].content_mapper.content-mapper-message");
    }
    
    @When("^I call the Components API instances using the PUT operation to update the component instance created in the previous scenario with an updated property$")
    public void i_call_the_Components_API_instances_using_the_PUT_operation_to_update_the_component_instance_created_in_the_previous_scenario_with_an_updated_property() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addParameterValToUrlFromScenarioContext("comp32112.componentInstance.key");
		chipSteps.setComponentInstancePayloadUpdate("componentInstanceBasicUpdateRequest", "first update to the component instance");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("PUT"); 
    }

    @Then("^the Component Instance should return the updated component instance when the component instance GET method is called using the key$")
    public void the_Component_Instance_should_return_the_updated_component_instance_when_the_component_instance_GET_method_is_called_using_the_key() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addRandomParameterToUrl("key", "passed", "comp32112.componentInstance.key");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET"); 
		chipSteps.validateJsonPathValue("first update to the component instance", "[0].data.status");
    }

    @Then("^I call the Component API instanes using the GET method using the Component instane key in the parameter and versions equals true$")
    public void i_call_the_Component_API_instanes_using_the_GET_method_using_the_Component_instane_key_in_the_parameter_and_versions_equals_true() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addParameterValToUrlFromScenarioContext("comp32112.componentInstance.key");
		chipSteps.addParameterToUrl("versions", "passed", "true");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET"); 
    }

    @Then("^the response from Component Instances should have the respective \\((\\d+)\\) numbers of instances$")
    public void the_response_from_Component_Instances_should_have_the_respective_numbers_of_instances(int responseArraySize) throws Exception {
		chipSteps.validateResponseArraySize(".", responseArraySize);
    }
    
    @Given("^I call Components API to create a component to use its id later to create component instances$")
    public void i_call_Components_API_to_create_a_component_to_use_its_id_later_to_create_component_instances() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.setComponentPayloadWithoutVersions();
		chipSteps.crudOperation("POST"); 
		chipSteps.getJsonPathValue("id", "comp99856.component.id");
    }

    @Given("^I call component instances enpoint to create \"([^\"]*)\" component instances using the component id$")
    public void i_call_component_instances_enpoint_to_create_component_instances_using_the_component_id(String componentInstance) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.setComponentInstancePayloadBasic("componentInstanceRequestBasic", "comp99856.component.id", "instance for comp99856");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("POST"); 
		chipSteps.getJsonPathValue("key", componentInstance);
    }
    @When("^I call Components API and pass the component name from the above scenario and pass the instances parameter$")
    public void i_call_Components_API_and_pass_the_component_name_from_the_above_scenario_and_pass_the_instances_parameter() throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("components");
		chipSteps.addParameterValToUrlFromScenarioContext("payloadComponentName");
		chipSteps.addParameterValToUrl("/instances");
		chipSteps.setHTTPHeader("apikey", "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET"); 
    }

    @Then("^I call Components API get instances and pass the (\\d+) keys for the instances created in the scenario above$")
    public void i_call_Components_API_get_instances_and_pass_the_keys_for_the_instances_created_in_the_scenario_above(int arg1) throws Exception {
    		chipSteps.restGiven(jobName, "natgeo BaseURL");
		chipSteps.setEndPoint("componentInstances");
		chipSteps.addRandomParameterToUrl("key", "passed", "comp99856.componentInstance1.key");
		chipSteps.addParameterValToUrl(",");
		chipSteps.addParameterValToUrlFromScenarioContext("comp99856.componentInstance2.key");
		chipSteps.setHTTPHeader("apikey",  "valid");
		chipSteps.setHTTPHeader("bypass-cache", "true");
		chipSteps.setHTTPHeader("Content-Type", "application/json");
		chipSteps.crudOperation("GET"); 
    }    
    
    
    
    
    
    
    
    
}