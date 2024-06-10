package com.natgeo.auth0.api_components;

import java.io.IOException;
import java.util.HashMap;

import org.junit.Assert;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.natgeo.utilities.LoaderUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.DefaultUrl;

public class Auth0CommonApiMethods extends PageObject {
	
	public static RequestSpecification httpRequest;
	
	public static Response response;
	public JsonPath jsonPathEvaluator;

	
	/**
	 * Executes a Rest service trhought RestAssure, makes a get call by default
	 * @param restUrl Endpoint to call (GET, POST)
	 * @param operationType Rest service type to execute
	 * @param data Body data for POST services
	 * @return the response object from the service call
	 */
	public static Response ExecuteService(String restUrl, String operationType, String data) {
		if (operationType.toLowerCase().equals("get")){
			return response =  RestAssured.get(restUrl);
		}
		else if(operationType.toLowerCase().equals("post")) {
			return response = RestAssured.given().headers("Content-Type", "application/json").body(data).post(restUrl);
		}
		return response =  RestAssured.get(restUrl); 
	}
}
