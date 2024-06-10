package com.natgeo.chip_reference.scenarioSteps;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.everyItem;
import com.natgeo.chip_reference.api_components.AdManagerJsonPathMap;
import com.natgeo.chip_reference.api_components.ApiValidationCommonMethods;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class AdManagerApiValidationSteps {

	private JsonPath jsonPathEvaluator;
	private Response response;
	private ApiValidationCommonMethods validationUtils = new ApiValidationCommonMethods();
	private AdManagerJsonPathMap adManager = new AdManagerJsonPathMap();
	
	
	public AdManagerApiValidationSteps(Response apiResponse) {
		response = apiResponse;
		jsonPathEvaluator = response.jsonPath();
	}
	
	@Step("Ad Manager id contains data")
	public void ad_manager_id_contains_data() {
		validationUtils.assertListValuesFromJsonPathAreDigits(jsonPathEvaluator, adManager.id);
	}
	
	@Step("AdManager key contains data")
	public void adManager_key_contains_data() {
		String searchedText = "AdManager";
		response.then().assertThat().body(adManager.key, everyItem(containsString(searchedText)));
	}
	
	@Step("AdManager data > config > provider is set to FREEWHEEL")
	public void adManager_data_provider_is_set_to_freewheel() {
		String searchedText = "FREEWHEEL";
		response.then().assertThat().body(adManager.provider, everyItem(equalTo(searchedText)));
	}
	
	@Step("AdManager data > config > boxStyle is set to BANNER")
	public void adManager_data_config_boxStyle_is_set_to_banner() {
		String searchedText = "BANNER";
		response.then().assertThat().body(adManager.boxStyle, everyItem(equalTo(searchedText)));
	}
	
	@Step("AdManager data > config > adProviderConfig > dimensions contains data")
	public void adManager_data_config_adProviderConfig_dimensions() {
		String searchedText = "banner";
		response.then().assertThat().body(adManager.adProviderDimensions, everyItem(equalTo(searchedText)));
	}
	 
	@Step("AdManager data > timestamp contains data")
	public void adManager_data_timestamp_contains_data() {
		validationUtils.assertListValuesFromJsonPathAreDigits(jsonPathEvaluator, adManager.timestamp);
	}
	
	@Step ("AdManager component_id contains data")
	public void adManager_component_id_contains_data() {
		validationUtils.assertListValuesFromJsonPathAreDigits(jsonPathEvaluator, adManager.componentId);
	}

	@Step ("AdManager version contains data")
	public void adManager_version_contains_data() {
		validationUtils.assertListValuesFromJsonPathMatchWithRegEx(jsonPathEvaluator, adManager.version, validationUtils.version_regEx);
	}
}
