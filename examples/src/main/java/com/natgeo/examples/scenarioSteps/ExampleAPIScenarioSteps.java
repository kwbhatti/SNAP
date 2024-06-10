package com.natgeo.examples.scenarioSteps;

import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;


public class ExampleAPIScenarioSteps extends ScenarioSteps{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1170419959766794237L;
	private HashMap< String,String> namedURLS = new HashMap< String,String>();

	
	public ExampleAPIScenarioSteps() {
		EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
		String baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
		namedURLS.put("country", baseUrl + "/country/get/iso2code/");
		
	}
	
   private Response response;

   @Step
   public void searchCountryByCode(String urlName, String code){
       response = SerenityRest.when().get(namedURLS.get(urlName) + code);
   }

   @Step
   public void searchIsExecutedSuccesfully(){
       response.then().statusCode(200);
   }

   @Step
   public void iShouldFindCountry(String country){
       response.then().body("RestResponse.result.name", equalTo(country));
   }
}