package com.natgeo.chip_reference.steps;

import org.junit.BeforeClass;
import com.natgeo.chip_reference.scenarioSteps.HomePageApiSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class HomePageApiValidationStepsDefinitions {

	@Steps
	HomePageApiSteps homePageApiSteps;
	
	@BeforeClass
	public void setupRestAssured() {
	}

	@Given("aggregation API is called from Home Page")
	public void aggregation_API_is_called_from_Home_Page() {
		homePageApiSteps.getAggregationResponse();
	}
	
	@Then("Ad Manager information is received as expected")
	public void ad_manager_information_is_received_as_expected() {
		homePageApiSteps.ad_manager_id_contains_data();
		homePageApiSteps.adManager_key_contains_data();
		homePageApiSteps.adManager_data_provider_is_set_to_freewheel();
		homePageApiSteps.adManager_data_config_boxStyle_is_set_to_banner();
		homePageApiSteps.adManager_data_config_adProviderConfig_dimensions();
		homePageApiSteps.adManager_data_timestamp_contains_data();
		homePageApiSteps.adManager_component_id_contains_data();
		homePageApiSteps.adManager_version_contains_data();
	}
	
	@And("Content Package information is received as expected")
	public void content_package_information_is_received_as_expected() {}
	
	@And("Photo Of The Day information is received as expected")
	public void photo_of_the_day_information_is_received_as_expected() {}
	
	@And("Dynamic Package information is received as expected")
	public void dynamic_package_information_is_received_as_expected() {}
	
	@And("TV Guide Preview information is received as expected")
	public void tv_guide_preview_information_is_received_as_expected() {}
	
	@And("Video Playlist information is received as expected")
	public void video_playlist_information_is_received_as_expected() {}
	
	@And("Left And Right Package information is received as expected")
	public void left_and_right_package_information_is_received_as_expected() {}
	
	@And("Broadsheet information is received as expected")
	public void broadsheet_information_is_received_as_expected() {}

}
