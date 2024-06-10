//COMMON STEPS
package com.natgeo.chip_services.scenarioSteps;

import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.junit.Assert;

import com.fasterxml.jackson.core.JsonEncoding;
import com.google.gson.JsonObject;
import com.ibm.icu.text.SimpleDateFormat;
import com.natgeo.common.CommonApiSteps;
import com.natgeo.utilities.LoaderUtil;
//import static com.jayway.restassured.path.json.JsonPath.from;
import com.natgeo.utilities.TextFileUtil;

import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Step;

public class ChipApiScenarioSteps extends CommonApiSteps{

	private static final long serialVersionUID = 1573274339110691211L;
	private HashMap< String,String> namedURLS = new HashMap< String,String>();
	private String apiInvalidKey;
	private String apiValidKey;
	private String apiValidKey2;
	private String endPoint;
	public ArrayList<String> urls = new ArrayList<>();
	JsonPath jsonPathEvaluator;

	
	public ChipApiScenarioSteps() {
		
		namedURLS.put("layoutLayouts", "/layout/v1/layouts/");
		namedURLS.put("configs", "/config/v1/configs/");
		namedURLS.put("webAggregationPages",  "/aggregation/v1/pages/");
		namedURLS.put("components", "/component/v1/components/");
		namedURLS.put("componentInstances", "/component/v1/components/instances/");
		namedURLS.put("layoutTypes", "/layout/v1/layouttypes/");
		namedURLS.put("layoutSites", "/layout/v1/sites/");
		namedURLS.put("layoutRegions", "/layout/v1/regions/");
		LoaderUtil.getInstance().intilizeValues();
		apiInvalidKey = LoaderUtil.getInstance().apiKeyInvalid;
		apiValidKey= LoaderUtil.getInstance().apiKeyValid;
		apiValidKey2= LoaderUtil.getInstance().apiKeyValid2;

	}
	
	@Step
	public void setHTTPHeader(String headerName, String headerValue) {
		if (headerName.equalsIgnoreCase("apikey")) {
			headerValue = apikeyValue(headerValue);
		} else if (headerName.equalsIgnoreCase("apikey2")) {
			headerName = "apikey";
			headerValue = apikey2Value(headerValue);
		}
		httpRequest.headers(headerName, headerValue);
	}

	public void setEndPoint(String endPointKey) {
		endPoint = namedURLS.get(endPointKey);
	}
	
	public void createbocy() throws ParseException {
		String sPayload = "{\"name\":\"automation payload test\",\n"
				+ "{\"value\":\"this is the laod}";
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(sPayload);
		httpRequest.body(json);	



	}
	
/*
 * 	setPayload(String body): add payload to a post or put request
 * 		and calls createPayload method to create payload
 * 		add payload to switch case
 */
	public void setPayload(String body) throws IOException, JSONException {
		String payload = null;
		switch (body) {
		case "randomBody":
			payload = createRandomPayload();
			break;
		case "componentBody":
			payload = createComponentPayload();
			break;
		case "componentBodyWithoutSchemaProperty":
			payload = createComponentPayloadNoSchemaProperty();
			break;
		case "componentBodyStringSchemaProperty":
			payload = createComponentBodyStringSchemaProperty();
			break;
		case "componentBodyIntSchemaProperty":
			payload = createComponentBodyIntSchemaProperty();
			break;
		case "componentInstanceBody":
			payload = createComponentInstancePayload();
			break;
		}
		httpRequest.body(payload);	
	}
	
	public void setLayoutPayloadWithConfigs(String jsonFile) throws IOException, JSONException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/"+jsonFile+".json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		String uri = "/my-test-uri-"+randomNum;
		String configDynamicProperty = "config-dynamic-value-"+randomNum;
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("uri", uri);
		payloadObj.getJSONObject("config").put("configDynamicProperty", configDynamicProperty);
		payloadString = payloadObj.toString();
		setContext("payloadUri", uri);
		setContext("configDynamicProperty", configDynamicProperty);
		httpRequest.log().all();
		httpRequest.body(payloadString);	
	}
	
	public void setLayoutTypePayload() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/layouttypeRequest.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		String name = "test-automation-layouttype-"+randomNum;
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", name);
		payloadString = payloadObj.toString();
		setContext("createlayouttype.name", name);
		httpRequest.body(payloadString);	 
	}
	
	public void setLayoutSitesPayload() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/layoutSiteRequest.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		String domain_name = "www.test-automation-layoutsite-"+randomNum+".kw";
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("domain_name", domain_name);
		payloadString = payloadObj.toString();
		setContext("createlayoutsite.domainName", domain_name);
		httpRequest.body(payloadString);	 
	}

	public void setLayoutRegionsPayload() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/layoutRegionRequest.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		String region_name = "test-automation-region-"+randomNum;
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", region_name);
		payloadString = payloadObj.toString();
		setContext("createlayoutregion.regionName", region_name);
		httpRequest.body(payloadString);	 
	}
	
	public void setLayoutPayloadUsingLayoutType() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/layoutRequest.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		String uri = "/test-automation-uri-"+randomNum;
		String layoutType = getContext("createlayouttype.name");
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("uri", uri);
		payloadObj.put("layoutType", layoutType);
		payloadString = payloadObj.toString();
		setContext("createlayout.uri", uri);
		httpRequest.body(payloadString);	 
	}
	
	public void setLayoutPayloadUsingLayoutSite() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/layoutRequest.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		String uri = "/test-automation-uri-"+randomNum;
		String layoutDomainName = getContext("createlayoutsite.domainName");
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("uri", uri);
		payloadObj.put("domainName", layoutDomainName);
		payloadString = payloadObj.toString();
		setContext("createlayout.uri", uri);
		httpRequest.body(payloadString);	 
	}
	
	public void setLayoutPayloadUsingLayoutRegion() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/layoutRequest.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);
		Collection<String> region = null;
		String uri = "/test-automation-uri-"+randomNum;
		String layoutRegion = getContext("createlayoutregion.regionName");
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("uri", uri);
		payloadObj.getJSONObject("regions").put(layoutRegion, region);
		payloadString = payloadObj.toString();
		setContext("createlayout.uri", uri);
		httpRequest.body(payloadString);	 
		httpRequest.log().all();
	}
	
	public void setComponentPayloadWithoutVersions() throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/componentRequestWithoutVersion.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);	
		String componentName = "test-component-"+randomNum;
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", componentName);
		payloadObj.getJSONObject("schema").put("automation-version", "I am associated with 1.0.0");
		payloadString = payloadObj.toString();
		setContext("payloadComponentName", componentName);
		setContext("payloadComponentVersion1", "I am associated with 1.0.0");
		System.out.println(payloadString);
		httpRequest.log().all();
		httpRequest.body(payloadString);
	}
	
	public void setComponentPayloadWithMessageInContentMapper(String componentBaseName, String saveComponentNameAs, String message) throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/componentRequestWithoutVersion.json";
		String randomNum = randomNumber(9, 8);	
		String componentName = componentBaseName+randomNum;
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", componentName);
		payloadObj.getJSONObject("schema").getJSONObject("content_mapper").put("content-mapper-message", message);
		payloadString = payloadObj.toString();
		setContext(saveComponentNameAs, componentName);
		setContext("payloadComponentVersion1", "I am associated with 1.0.0");
		System.out.println(payloadString);
		httpRequest.log().all();
		httpRequest.body(payloadString);
	}
	//second comp
	public void setComponentPayloadWithVersionsForExistingComponent(String componentVersion) throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/componentRequestWithoutVersion.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String componentName = getContext("payloadComponentName");
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", componentName);
		payloadObj.getJSONObject("schema").put("version", componentVersion);
		payloadObj.getJSONObject("schema").put("automation-version", "I am associated with 2.0.0");
		payloadString = payloadObj.toString();
		setContext("payloadComponentVersion2", "I am associated with 2.0.0");
		System.out.println(payloadString);
		httpRequest.body(payloadString);
		httpRequest.log().all();
	}
	
	public void setComponentUpdatePayloadWithVersions(String componentVersion) throws IOException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/componentRequestWithoutVersion.json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String componentName = getContext("payloadComponentName");
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", componentName);
		payloadObj.getJSONObject("schema").put("version", componentVersion);
		payloadObj.getJSONObject("schema").put("automation-version", "I am associated with 2.0.0-updated");
		payloadString = payloadObj.toString();
		setContext("payloadComponentVersion2-updated", "I am associated with 2.0.0-updated");
		System.out.println(payloadString);
		httpRequest.body(payloadString);
		httpRequest.log().all();
	}
	
	public void setComponentPayloadWithStringContentMapper(String jsonFile) throws IOException, JSONException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/"+jsonFile+".json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);	
		String componentName = "test-component-"+randomNum;
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", componentName);
		payloadString = payloadObj.toString();
		setContext("payloadComponentName", componentName);
		setContext("payloadContentMapper", "{this is a test component mapper}");
		System.out.println(payloadString);
		httpRequest.log().all();
		httpRequest.body(payloadString);	
	}

	public void setComponentInstancePayloadBasic(String jsonFile, String componentIdContext, String statusMessage) throws IOException, JSONException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/"+jsonFile+".json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String randomNum = randomNumber(9, 8);	
		String componentInstanceName = "test-component-instance-"+randomNum;
		System.out.println("the componentIdContext parameter is : "+componentIdContext);
		System.out.println("the component id is : "+getContext(componentIdContext));
		String componentId = getContext(componentIdContext);
		System.out.println("the component id is: " +componentId);
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("component_id", componentId);
		payloadObj.getJSONObject("data").put("name", componentInstanceName);
		payloadObj.getJSONObject("data").put("created_by", "automation script");
		payloadObj.getJSONObject("data").put("status", statusMessage);
		payloadString = payloadObj.toString();
		setContext("payloadComponentInstanceName", componentInstanceName);
		System.out.println(payloadString);
		httpRequest.log().all();
		httpRequest.body(payloadString);	
	}
	
	public void setComponentInstancePayloadUpdate(String jsonFile, String statusMessage) throws IOException, JSONException {
		String payloadFilePath = "./src/test/resources/com/natgeo/chip_services/json/"+jsonFile+".json";
		String payloadString = TextFileUtil.textFileToString(payloadFilePath);
		String componentInstanceName = getContext("payloadComponentInstanceName");
		JSONObject payloadObj = new JSONObject(payloadString);
		payloadObj.put("name", componentInstanceName);
		payloadObj.put("created_by", "automation script");
		payloadObj.put("status", statusMessage);
		payloadString = payloadObj.toString();
		System.out.println(payloadString);
		httpRequest.log().all();
		httpRequest.body(payloadString);	
	}
	
	private String createComponentInstancePayload() throws JSONException {
		String payload = null;
		String componentId = getContext("component.random.id");
		String timeStamp = timeStampGenerator();
		String random1 = "random-number"+randomNumber(9, 8);
		setContext("payload.component.random1", random1);
		payload = new JSONObject()
			.put("component_id", componentId)
			.put("timeStamp", timeStamp)
			.put("createdBy", "automation")
			.put("data", new JSONObject()
				.put("random1", random1)).toString();
		return payload;
	}
	
	private String createComponentBodyStringSchemaProperty() throws JSONException {
		String payload = null;
		String compnentName = componentNameGenerator();
		String timeStamp = timeStampGenerator();
		payload = new JSONObject()
			.put("name", compnentName)
			.put("timeStamp", timeStamp)
			.put("createdBy", "automation")
			.put("schema", "test-string-input").toString();
		return payload;
	}
	
	private String createComponentBodyIntSchemaProperty() throws JSONException {
		String payload = null;
		String compnentName = componentNameGenerator();
		String timeStamp = timeStampGenerator();
		payload = new JSONObject()
			.put("name", compnentName)
			.put("timeStamp", timeStamp)
			.put("createdBy", "automation")
			.put("schema", 999).toString();
		return payload;
	}
	
	private String createComponentPayloadNoSchemaProperty() throws JSONException {
		String payload = null;
		String compnentName = componentNameGenerator();
		setContext("payload.component.name", compnentName);
		String timeStamp = timeStampGenerator();
		payload = new JSONObject()
			.put("name", compnentName)
			.put("timeStamp", timeStamp)
			.put("createdBy", "automation")
			.put("schema", JSONObject.NULL).toString();
		return payload;
	}
	/*
	 * createComponentPayload: creates payload for component, also saving necessary values for user later
	 */
	private String createComponentPayload() throws JSONException {
		String payload = null;
		String compnentName = componentNameGenerator();
		setContext("payload.component.name", compnentName);
		String mapperVal1 = "mapperVal1"+randomNumber(9, 4);
		setContext("payload.component.mapper1", mapperVal1);
		String mapperVal2 = "mapperVal2"+randomNumber(9, 4);
		setContext("payload.component.mapper2", mapperVal2);
		String timeStamp = timeStampGenerator();
		payload = new JSONObject()
			.put("name", compnentName)
			.put("timeStamp", timeStamp)
			.put("createdBy", "automation")
			.put("schema", new JSONObject()
				.put("content_mapper", new JSONObject()
					.put("mapper1", mapperVal1)
					.put("mapper2", mapperVal2))).toString();
		return payload;
	}
	
	/*
	 * createRandomPayload: creates random payload and saves the values for later
	 */
	private String createRandomPayload() throws JSONException {
		String payload = null;
		String timeStamp = timeStampGenerator();
		payload = new JSONObject()
			.put("name", "automation-test")
			.put("timeStamp", timeStamp).toString();
		return payload;
	}
	
	@Step
	public void crudOperation(String crudOperation) {
		switch (crudOperation) {
		case "GET":
			httpRequest.log().all();
			getCRUDOperation(endPoint);
			System.out.println(response.getStatusCode());
			System.out.println(response.asString());
			break;
		case "POST":
			postCRUDOperation(endPoint);
			System.out.println(response.asString());
			System.out.println(response.getStatusCode());
			break;
		case "PUT":
			putCRUDOperation(endPoint);
			System.out.println(response.asString());
			System.out.println(response.getStatusCode());
			break;
		case "DELETE":
			deleteCRUDOperation(endPoint);
			System.out.println(response.asString());
			System.out.println(response.getStatusCode());
			break;
		default: 
			throw new NullPointerException("The crudOperation does not exist");
		}
	}
	
	//Passing parameter to url
	public void addParameterValToUrl(String parameterVal) {
		endPoint = endPoint+parameterVal;
	}
	
	//Passing saved parameter to url
	public void addParameterValToUrlFromScenarioContext(String contextKey) {
		String parameterVal = getContext(contextKey);
		endPoint = endPoint+parameterVal;
		httpRequest.log().all();
	}
	
	//Passing parameter to url using ? or &
	public void addParameterToUrl(String parameter, String action, String parameterVal) {
		if (action.equalsIgnoreCase("passed")) {
			endPoint = endPoint+"?"+parameter+"="+parameterVal;
		} else if (action.equalsIgnoreCase("added")) {
			endPoint = endPoint+"&"+parameter+"="+parameterVal;
		} else if (action.equalsIgnoreCase("commaSeperated")) {
			endPoint = endPoint+","+parameterVal;
		}
	}
	
	//Passing saved parameter to url using ? or &
	public void addRandomParameterToUrl(String parameter, String action, String contextKey) {
		String parameterVal = getContext(contextKey);
		if (action.equalsIgnoreCase("passed")) {
			endPoint = endPoint+"?"+parameter+"="+parameterVal;
		} else if (action.equalsIgnoreCase("added")) {
			endPoint = endPoint+"&"+parameter+"="+parameterVal;
		} else if (action.equalsIgnoreCase("commaSeperated")) {
			endPoint = endPoint+","+parameterVal;
		}
	}

	private String apikeyValue(String apikeyValue) {
		switch (apikeyValue) {
		case "valid":
			apikeyValue = apiValidKey;
			break;
		case "invalid":
			apikeyValue = apiInvalidKey;
			break;
		default:
			apikeyValue = "";
		}
		return apikeyValue;
	}
	
	private String apikey2Value(String apikeyValue) {
		switch (apikeyValue) {
		case "valid":
			apikeyValue = apiValidKey2;
			break;
		case "invalid":
			apikeyValue = apiInvalidKey;
			break;
		default:
			apikeyValue = "";
		}
		return apikeyValue;
	}
	
	public void getRandomPropValuesFromLayouts(String property, String contextKey) {
		List<Objects> layoutObjects = null; 
		String propValue;
		int randomNumber;
		layoutObjects = response.jsonPath().getList(".");
		int numberOfLayouts = layoutObjects.size();
		randomNumber = randomNumber(numberOfLayouts);
		propValue = getPropValueFromJsonArray("", randomNumber, property);
		setContext(contextKey, propValue);
	}
	
	public void getRandomPropValueFromResponseArray(String property, String contextKey) {
		List<Object> responseArrayObjects; 
		String propValue;
		int randomNumber;
		responseArrayObjects = response.jsonPath().getList(".");
		int responseSize = responseArrayObjects.size();
		randomNumber = randomNumber(responseSize);
			propValue = getPropValueFromJsonArray("", randomNumber, property);
			setContext(contextKey, propValue);
			System.out.println("property "+contextKey+" has been set to: "+propValue);
	}
	
	public void getRandomPropsValuesFromResponseArray(ArrayList<String> property, ArrayList<String> contextKey) {
		List<Object> responseArrayObjects; 
		String propValue;
		int randomNumber;
		responseArrayObjects = response.jsonPath().getList(".");
		int responseSize = responseArrayObjects.size();
		randomNumber = randomNumber(responseSize);
		
		for (int i = 0; i<property.size(); i++) {
			propValue = getPropValueFromJsonArray("", randomNumber, property.get(i));
			setContext(contextKey.get(i), propValue);
			System.out.println("property "+contextKey.get(i)+" has been set to: "+propValue);
		}	
	}
	
	public int getRandomIndexFromResponseArrayObject(String jsonPath) {
		List<Object> responseArrayObjects; 
		int randomNumber;
		responseArrayObjects = response.jsonPath().getList(jsonPath);
		int responseSize = responseArrayObjects.size();
		randomNumber = randomNumber(responseSize);
		return randomNumber;
	}
	
	public void getRandomComponentNameAndVersion() {
		int randomIndex = getRandomIndexFromResponseArrayObject(".");
		String nameJsonPath = "["+randomIndex+"].name";
		String versionJsonPath = "["+randomIndex+"].version";
		getJsonPathValue(nameJsonPath, "randomComponent.name"); 
		getJsonPathValue(versionJsonPath, "randomComponent.componentVersion11"); 
	}
	
	public int getRandomIndexFromConfigsBasedOnNamespace(String expectedNamespace) {
		int totalConfigs = response.jsonPath().getList(".").size();
		int randomNumber = randomNumber(totalConfigs);
		String nameSpace = getPropValueFromJsonArray("", randomNumber, "config.tags.namespace");
		System.out.println("first : "+nameSpace);
		int index = 0;
		if (nameSpace.equalsIgnoreCase(expectedNamespace)) {
			index = randomNumber;
		}else {
			while (!nameSpace.equalsIgnoreCase(expectedNamespace)) {
				randomNumber = randomNumber(totalConfigs);
				nameSpace = getPropValueFromJsonArray("", randomNumber, "config.tags.namespace");
				index = randomNumber;
			}
		}
		return index;
	}
	
	public void getRandomSitesDomainFromConfigs() {
		int index = getRandomIndexFromConfigsBasedOnNamespace("sites");
		String nameSpace = getPropValueFromJsonArray("", index, "config.tags.namespace");
		String domain = getPropValueFromJsonArray("", index, "config.tags.domain");
		String data = getPropValueFromJsonArray("", index, "config.data");
		String id = getPropValueFromJsonArray("", index, "id");
		setContext("configNamespace", nameSpace);
		setContext("configDomain", domain);
		setContext("configData", data);
		setContext("configId", id);
	}
	
	public void getRandomCustomPagesPageAndDomainFromConfigs() {
		int index = getRandomIndexFromConfigsBasedOnNamespace("custom_pages");
		String nameSpace = getPropValueFromJsonArray("", index, "config.tags.namespace");
		String domain = getPropValueFromJsonArray("", index, "config.tags.domain");
		String data = getPropValueFromJsonArray("", index, "config.data");
		String id = getPropValueFromJsonArray("", index, "id");
		String page = getPropValueFromJsonArray("", index, "config.tags.page");
		setContext("configNamespace", nameSpace);
		setContext("configDomain", domain);
		setContext("configData", data);
		setContext("configId", id);
		setContext("configPage", page);
	}
	
	public void 	addSiteParametersToConfig(String propertyValue) {
		if (propertyValue.equalsIgnoreCase("useContext")) {
			propertyValue = getContext("configDomain");
		}
		addParameterToUrl("domain", "passed", propertyValue);
	}
	
	public void addCustomPageParametersToConfig(String domainValue, String pageValue) {
		if (domainValue.equalsIgnoreCase("useContext")) {
			domainValue = getContext("configDomain");
		}
		if (pageValue.equalsIgnoreCase("useContext")) {
			pageValue = getContext("configPage");
		}
		addParameterToUrl("domain", "passed", domainValue);
		addParameterToUrl("page", "added", pageValue);
		
		
	}
	
	public void validateConfigDataProperty() {
		String dataProperty = getContext("configData");
		jsonPathEvaluator = response.jsonPath();
		String responseValue = jsonPathEvaluator.getString("config").toString();
		Assert.assertTrue(responseValue.endsWith(dataProperty));
	}
	
	public void validateConfigId() {
		String idProperty = getContext("configId");
		jsonPathEvaluator = response.jsonPath();
		String responseValue = jsonPathEvaluator.getString("id").toString();
		Assert.assertTrue(responseValue.endsWith(idProperty));
	}
	
	public String getPropValueFromJsonArray(String parentJsonPath, int arrayIndex, String property) {
		String propValue = null;
		jsonPathEvaluator = response.jsonPath();
		String jsonPath = parentJsonPath+"["+arrayIndex+"]."+property;
		propValue = jsonPathEvaluator.getString(jsonPath).toString();
		return propValue;
	}
	
	private String componentNameGenerator() {
		String componentName;
		String firstFour = ""+randomNumber(9, 4)+"";
		String secondFour = ""+randomNumber(9, 4)+"";
		String componentId = firstFour+"-"+secondFour;
		componentName = "automation-test-component-"+componentId;
		return componentName;
	}
	
	private String timeStampGenerator() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		String timeStamp  = dateFormat.format(new Date());
		return timeStamp.toString();
	}
	
	/*
	 * validateResponseWithRequestPayload will validate the values passed in the request
	 * takes arguments for when the payload was created
	 */
	public void validateResponseWithRequestPayload(String responseApi, String requestPayload) {
		switch (requestPayload) {
		case "component":
			validateComponentResponseWithRequestPayload(responseApi);
			break;
		case "componentInstance":
			validateCompInstanceResponseWithRequestPayload(responseApi);
			break;
		}
	}
	
	private void validateCompInstanceResponseWithRequestPayload(String responseApi) {
		String componentId = getContext("component.random.id");
		String random1 = getContext("payload.component.random1");
		String key = getContext("componentInstance.create.key");
		switch(responseApi) {
		case "componentInstance":
			validateJsonPathValue(key, "[0].key");
			validateJsonPathValue(componentId, "[0].component_id");
			validateJsonPathValue(random1, "[0].data.random1");
		}
	}
	
	/*
	 * validateComponentResponseWithRequestPayload: if component is created in the script
	 * this method would validate the response weather the component is being called using component or layout
	 */
	private void validateComponentResponseWithRequestPayload(String responseApi) {
		String name = getContext("payload.component.name");
		String mapper1 = getContext("payload.component.mapper1");
		String mapper2 = getContext("payload.component.mapper2"); 
		switch (responseApi) {
		case "component":
			validateJsonPathValue(name, "name");
			validateJsonPathValue(mapper1, "schema.content_mapper.mapper1");
			validateJsonPathValue(mapper2, "schema.content_mapper.mapper2");
			break;
		case "layout":
			System.out.println("TODO: add validation if the component is created from layout");
		}
	}
	
	/*
	 * validateResponseArraySize(parent, arraySize): validate the size of the reponse array
	 * where parent is where the array is located and it should be a json path
	 * arraySize is the expected size of the array
	 */
	public void validateResponseArraySize(String parent, int arraySize) {
		int actualArraySize;
		int expectedArraySize = arraySize;
		if (parent.contains("Root")) {
			parent = ".";
		}
		actualArraySize = response.jsonPath().getList(parent).size();
		System.out.println("actual : "+actualArraySize+" expected : "+expectedArraySize);
		Assert.assertTrue(actualArraySize == expectedArraySize);
	}
	
	public void getJsonPathValue(String jsonPath, String contextKey) {
		String value;
		JsonPath jsonPathEvaluator = response.jsonPath();
		value = jsonPathEvaluator.getString(jsonPath).toString();
		setContext(contextKey, value);
	}
	
	public void getConvertAllLayoutUriAndDomainToUrls() {
		JsonPath jsonPathEvaluator = response.jsonPath();
		int numberOfLayouts = response.jsonPath().getList(".").size();
		String jsonPathUri;
		String jsonPathDomain;
		String url;
		String uri;
		String domainName;
		urls = new ArrayList<>();
		for (int i = 0; i < numberOfLayouts; i++) {
			jsonPathUri = "["+i+"].uri";
			jsonPathDomain = "["+i+"].domainName";
			uri = jsonPathEvaluator.getString(jsonPathUri).toString();
			domainName = jsonPathEvaluator.getString(jsonPathDomain).toString();
			url = "https://"+domainName+uri;
			urls.add(url);
		}
	}
	
	public void convertLayoutUriAndDomainToAggregationUrl() {
		JsonPath jsonPathEvaluator = response.jsonPath();
		int numberOfLayouts = response.jsonPath().getList(".").size();
		String jsonPathUri;
		String jsonPathDomain;
		String uri;
		String domainName;
		int randomNumber = randomNumber(numberOfLayouts);
		jsonPathUri = "["+randomNumber+"].uri";
		jsonPathDomain = "["+randomNumber+"].domainName";
		uri = jsonPathEvaluator.getString(jsonPathUri).toString();
		domainName = jsonPathEvaluator.getString(jsonPathDomain).toString();
		String url = "https://"+domainName+uri;
		setContext("aggregationUrl", url);
	}
	
	public int responseCode() {
		int responseCode = response.getStatusCode();
		return responseCode;
	}
	
	public void faliureAssertion(int faliures) {
		if (faliures == 0) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	}
	
	public void findSubStringFromResponse(String subString) {
		String responeAsString = response.asString();
		if (responeAsString.contains(subString)) {
			System.out.println("found the substring in the response");
		}
	}
	
	public void setAggregationParametersUsingContext() {
		String url = "https://www.nationalgeographic.co.uk"+getContext("payloadUri");
		endPoint = endPoint+"?url="+url;
	}
	
	public void aggregationDoesNotContainsContentMappers() throws JSONException {
		JsonPath jsonPathEvaluator = response.jsonPath();
		int totalMainTag = response.jsonPath().getList("regions.main").size();
		String jsonPathForContentMapper;
		HashMap<String, Object> mainObjectMap;
		for (int i = 0; i < totalMainTag; i++) {
			jsonPathForContentMapper = "regions.main["+i+"]";
			mainObjectMap = jsonPathEvaluator.getJsonObject(jsonPathForContentMapper);
			boolean ifContentMapperExists = mainObjectMap.containsKey("content_mapper");
			Assert.assertTrue(!ifContentMapperExists);
		}
	}
	
	public void layoutContainsSpecificRegionFirstValue() {
		String region = getContext("createlayoutregion.regionName");
		boolean regionValue = reponseContainsProperty("regions", region);
		Assert.assertTrue(regionValue);
	}

	public void validateMostUpdatedVersionComponent(int finalVersion) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		int totalHistoryVersion = response.jsonPath().getList(".").size();
		int arrayPlacement = 0;
		for (int i = 0; i < totalHistoryVersion; i++) {
			String jsonPathForVersionNumber = "["+i+"]"+".version_number";
			int versionNumber = jsonPathEvaluator.getJsonObject(jsonPathForVersionNumber);
			System.out.println("version number for this iteration is: "+versionNumber);
			if (versionNumber == finalVersion) {
				arrayPlacement = i;
			}
		}
		String finalJsonPathToValidate = "["+arrayPlacement+"].schema.automation-version";
		validateRandomJsonPathValue("payloadComponentVersion2-updated", finalJsonPathToValidate);
	}
	

}