package com.natgeo.aemcore.steps;

import com.natgeo.aemcore.scenarioSteps.AEMCoreAuthoringScenarioSteps;
import com.natgeo.aemcore.scenarioSteps.AEMCoreScenarioSteps;
import com.natgeo.utilities.LoaderUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class AEMCoreStepDefinitions {
	String jobName;
	
	@Steps
	AEMCoreScenarioSteps coreSteps;
	Object managed_component = null;

	@Before
	public void setUp(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().intilizeValues();
		LoaderUtil.getInstance().startSaucelabs(coreSteps.getDriver(), scenario);
		jobName = scenario.getName();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().stopSauceLabs(scenario);
	}

	@Given("^I am on the page \"([^\"]*)\" with ads enabled$")
	public void i_am_on_the_page_with_ads_enabled(String page) {
		coreSteps.homePage().open_with_ads(page);
		// coreSteps.homePage().checkWindowApplitools(jobName);
	}
	
	@Given("^I am on the page \"([^\"]*)\"$")
	public void i_am_on_the_page(String page) throws Exception {
    		coreSteps.homePage().open_with_no_ads(page);
	}

	@Then("^I should be able to see all advertisements on the page$")
	public void i_should_be_able_to_see_all_advertisements_on_the_page() {
		coreSteps.homePage().verify_that_ads_are_present();
	}

	@Then("^I should see a total of \"([^\"]*)\" advertisements on the page$")
	public void i_should_see_a_total_of_advertisements_on_the_page(String arg1) {
		coreSteps.homePage().verify_the_number_of_ads_on_the_page(Integer.valueOf(arg1));
	}

	@Given("^I paginate through the photo presentation gallery and verify advertisements load$")
	public void i_paginate_through_the_photo_presentation_gallery_and_verify_advertisements_load() {
		// Write code here that turns the phrase above into concrete actions
		// throw new PendingException();
	}
	
	@Then("^I should see the component \"([^\"]*)\"$")
	public void i_see_the_component(String component) {
		coreSteps.homePage().verify_component(component);
	}
	
	@Then("^I should see count \"([0-9])\" in the pagination$")
	public void check_count(int count) {
		coreSteps.homePage().verify_pagination(count);
	}
	
	@Then("^I should see the did you know fact$")
	public void verify_did_you_know_fact() {
		coreSteps.homePage().verify_dyk_fact();
	}
	
	@Then("^I should see the twitter button$")
	public void verify_twitter_button() {
		coreSteps.homePage().verify_twitter_icon();
	}
	
	@When("^I scroll the pagination$")
	public void verify_pagination() {
		coreSteps.homePage().scroll_pagination();
	}
}
