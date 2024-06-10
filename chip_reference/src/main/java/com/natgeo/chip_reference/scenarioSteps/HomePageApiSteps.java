package com.natgeo.chip_reference.scenarioSteps;

import com.natgeo.chip_reference.pages.HomePageApi;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;

@DefaultUrl("/aggregation/v1/pages?url=https://www.nationalgeographic.co.uk/")
public class HomePageApiSteps{

	HomePageApi	homePageApi =  new HomePageApi();
	
	private AdManagerApiValidationSteps adManagerValidationSteps = new AdManagerApiValidationSteps(homePageApi.response);

	@Step("Get aggregation response from Home Page")
	public void getAggregationResponse() {
		homePageApi.requestCallSuccessfull();
	}
	
	@Step("Ad Manager id contains data")
	public void ad_manager_id_contains_data() {
		adManagerValidationSteps.ad_manager_id_contains_data();
	}
	
	@Step("AdManager key contains data")
	public void adManager_key_contains_data() {
		adManagerValidationSteps.adManager_key_contains_data();
	}
	
	@Step("AdManager data > config > provider is set to FREEWHEEL")
	public void adManager_data_provider_is_set_to_freewheel() {
		adManagerValidationSteps.adManager_data_provider_is_set_to_freewheel();
	}
	
	@Step("AdManager data > config > boxStyle is set to BANNER")
	public void adManager_data_config_boxStyle_is_set_to_banner() {
		adManagerValidationSteps.adManager_data_config_boxStyle_is_set_to_banner();
	}
	
	@Step("AdManager data > config > adProviderConfig > dimensions contains data")
	public void adManager_data_config_adProviderConfig_dimensions() {
		adManagerValidationSteps.adManager_data_config_adProviderConfig_dimensions();
	}
	 
	@Step("AdManager data > timestamp contains data")
	public void adManager_data_timestamp_contains_data() {
		adManagerValidationSteps.adManager_data_timestamp_contains_data();
	}
	
	@Step ("AdManager component_id contains data")
	public void adManager_component_id_contains_data() {
		adManagerValidationSteps.adManager_component_id_contains_data();
	}

	@Step ("AdManager version contains data")
	public void adManager_version_contains_data() {
		adManagerValidationSteps.adManager_version_contains_data();
	}
}
