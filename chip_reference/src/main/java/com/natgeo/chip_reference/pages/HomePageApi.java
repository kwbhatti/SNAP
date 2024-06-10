package com.natgeo.chip_reference.pages;

import org.junit.Assert;

import com.natgeo.chip_reference.api_components.ApiValidationCommonMethods;
import com.natgeo.utilities.LoaderUtil;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("/aggregation/v1/pages?url=https://www.nationalgeographic.co.uk/")
public class HomePageApi extends PageObject {
	
	private ApiValidationCommonMethods apiMethods = new ApiValidationCommonMethods();
	public Response response;
	public JsonPath jsonPathEvaluator;
	
	public HomePageApi() {
		RequestSpecification requestSpecification = new RequestSpecBuilder().addHeader(apiMethods.header,apiMethods.headerValue).build();
		RestAssured.requestSpecification = requestSpecification;
		response =  RestAssured.get(LoaderUtil.getInstance().baseUrl + getClass().getAnnotation(DefaultUrl.class).value());
		jsonPathEvaluator = response.jsonPath();
	}

	public void requestCallSuccessfull() {
		boolean res;
		try {
			res =  jsonPathEvaluator.get("domainName").toString().contains("national");
		}
		catch (Exception e){
			res = false;
		}
		Assert.assertTrue("Home Page Aggregation API is not returning the expected response:\n" + response.asString() , res);
	}
}
