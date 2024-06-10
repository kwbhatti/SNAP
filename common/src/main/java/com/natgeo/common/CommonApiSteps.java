package com.natgeo.common;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.utilities.LoaderUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import io.vavr.collection.HashMap;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CommonApiSteps extends ScenarioSteps {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonApiSteps.class);
	private static final long serialVersionUID = -941013085714960493L;
	protected Response response;
	protected RequestSpecification httpRequest;
	private static HashMap< String,String> scenarioContext = new HashMap< String,String>();


	// new
	public static void passParameters(RequestSpecification httpRequest, ArrayList<String> parameters,
			ArrayList<String> values) {
		for (int i = 0; i < parameters.size(); i++) {
			if (parameters.get(i).equalsIgnoreCase("NA") || parameters.get(i).equalsIgnoreCase("")) {
				System.out.println("step not required for the data condition");
			} else {
				System.out.println(httpRequest);
				// newmethod(httpRequest, parameters.get(i), values.get(i));
			}
		}
	}

	
	@Step
	public void restGiven(String jobeName, String baseUrl) {
		if (baseUrl.equalsIgnoreCase("natgeo BaseURL")) {
			SerenityRest.setDefaultBasePath(LoaderUtil.getInstance().baseUrl);
		}
		LOGGER.info(jobeName);
		httpRequest = SerenityRest.given();
	}
	
	@Step
	public void setHeader(String name, String value) {
		httpRequest.headers(name,value);
	}
	
	
	/******************************************************************
	 *************   CRUD Operations   
	 * @return ********************************
	 ******************************************************************/

	@Step
	public void getCRUDOperation(String endPoint) {
		if (httpRequest != null) {
			LOGGER.info("GET: Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = httpRequest.when().get(LoaderUtil.getInstance().baseUrl + endPoint);
		} else {
			LOGGER.info("GET: Not Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = SerenityRest.when().get(LoaderUtil.getInstance().baseUrl + endPoint);
		}
	}

	@Step
	public void postCRUDOperation(String endPoint) {
		if (httpRequest != null) {
			LOGGER.info("POST: Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = httpRequest.when().post(LoaderUtil.getInstance().baseUrl + endPoint);
		} else {
			LOGGER.info("POST: Not Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = SerenityRest.when().post(LoaderUtil.getInstance().baseUrl + endPoint);
		}
	}

	@Step
	public void putCRUDOperation(String endPoint) {
		if (httpRequest != null) {
			LOGGER.info("PUT: Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = httpRequest.when().put(LoaderUtil.getInstance().baseUrl + endPoint);
		} else {
			LOGGER.info("PUT: Not Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = SerenityRest.when().put(LoaderUtil.getInstance().baseUrl + endPoint);
		}
	}

	@Step
	public void deleteCRUDOperation(String endPoint) {
		if (httpRequest != null) {
			LOGGER.info("DELETE: Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = httpRequest.when().delete(LoaderUtil.getInstance().baseUrl + endPoint);
		} else {
			LOGGER.info("DELETE: Not Found httpRequest - " + LoaderUtil.getInstance().baseUrl + endPoint);
			response = SerenityRest.when().delete(LoaderUtil.getInstance().baseUrl + endPoint);
		}
	}
	
	/******************************************************************
	 *************   Validate response codes   ************************
	 ******************************************************************/
	@Step
	public void validateReturnCode(int returnCode) {
		response.then().statusCode(returnCode);
		System.out.println("**************************************************************");
		
		System.out.println(response.getStatusCode());
		System.out.println("**************************************************************");

	}
	
	@Step
	public void iShouldFindCountry(String country) {
		response.then().body("RestResponse.result.name", is(country));
	}
	
	
	/******************************************************************
	 *********************   Validate schema   ************************
	 ******************************************************************/
	@Step
	public void validateSchema(String jsonFile) {
		LOGGER.info("validateSchema - Before");
		response.then().body(matchesJsonSchemaInClasspath("com/natgeo/sites/chip/services/json/"+jsonFile));
		LOGGER.info("validateSchema - After");
	}
	
	public int randomNumber(int max) {
		int randomNumber;
		Random rand = new Random();
		randomNumber = rand.nextInt(max);
		return randomNumber;
	}
	
	public static void setContext(String key, String value) {
		scenarioContext.put(key, value);
	}
	
	public static String getContext(String key) {
		String value = null;
		if (scenarioContext.containsKey(key)) {
			value = scenarioContext.get(key);
		}
		return value;
	}
	
	/*
	 * creates a string on random numbers
	 * the argument max is for each digit
	 */
	public String randomNumber(int max, int digits) {
		String randomNumber = null;
		Random rand = new Random();
		digits = digits-1;
		for (int i = 0; i <=	 digits; i++) {
			String randomNumbertemp = Integer.toString(rand.nextInt(max));
			if (randomNumber == null) {
				randomNumber = randomNumbertemp;
			}else {
				randomNumber = ""+randomNumber+randomNumbertemp+"";
			}
		}
		return randomNumber;
	} 
	
	public void validateJsonPathValue(String value, String jsonPath) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String actualVal;
		System.out.println(value);
		System.out.println(jsonPath);
		actualVal = jsonPathEvaluator.getString(jsonPath).toString();
		System.out.println(actualVal);
		Assert.assertTrue(value.equalsIgnoreCase(actualVal));
	}
	
	public void validateResponseString(String expectedValue) {
		String responseString = response.asString();
		System.out.println(expectedValue);
		Assert.assertTrue(responseString.equalsIgnoreCase(expectedValue));
	}
	
	public void validateRandomJsonPathValue(String contextKey, String jsonPath) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String expectedVal = "";
		expectedVal = getContext(contextKey);
		String actualVal;	
		actualVal = jsonPathEvaluator.getString(jsonPath).toString();
		Assert.assertTrue(expectedVal.equalsIgnoreCase(actualVal));
	}
	
	public boolean reponseContainsProperty(String parentJsonPath, String property) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		HashMap<String, Object> mainObjectMap;
		mainObjectMap = jsonPathEvaluator.getJsonObject(parentJsonPath);
		boolean ifProprtyExists = mainObjectMap.containsKey(property);
		return ifProprtyExists;
	}
}