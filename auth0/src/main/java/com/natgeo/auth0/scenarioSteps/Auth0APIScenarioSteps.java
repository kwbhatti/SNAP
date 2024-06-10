package com.natgeo.auth0.scenarioSteps;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.HashMap;

import org.glassfish.hk2.utilities.reflection.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.natgeo.auth0.api_components.Auth0CommonApiMethods;
import com.natgeo.utilities.WindowsHandlerUtil;

import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;


public class Auth0APIScenarioSteps extends ScenarioSteps{
	/**
	 * 
	 */
	private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Auth0APIScenarioSteps.class);
	private static final long serialVersionUID = -1170419959766794237L;
	private HashMap< String,String> namedURLS = new HashMap< String,String>();

	
	public Auth0APIScenarioSteps() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		namedURLS.put("country", baseUrl + "/country/get/iso2code/");
		
	}
	
   public static Response response;
   
   @Step
   public void SendServiceRequest(String restUrl, String operationType, String data) {
	   response = Auth0CommonApiMethods.ExecuteService(restUrl, operationType, data);
   }

   @Step
   public void iShouldFindCountry(String country){
       response.then().body("RestResponse.result.name", equalTo(country));
   }
}