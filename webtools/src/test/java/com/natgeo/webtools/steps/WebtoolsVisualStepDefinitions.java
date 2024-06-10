package com.natgeo.webtools.steps;


import com.natgeo.webtools.scenarioSteps.VisualScenarioSteps;
import com.natgeo.utilities.LoaderUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class WebtoolsVisualStepDefinitions {
	String jobName;

	@Steps
	VisualScenarioSteps visualSteps;

	@Before
	public void setUp(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().intilizeValues();
		LoaderUtil.getInstance().startSaucelabs( visualSteps.getDriver(), scenario);
		jobName=scenario.getName();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().stopSauceLabs(scenario);
		visualSteps.abortApplitoolTest();
	}

    
	@Given("^a video player user navigates to the ([^\"]*) page$")
	public void a_user_navigates_to_a_page(String namedPage) throws Exception {
    		visualSteps.openPage(namedPage);
	}

	@Given("^a webtools user navigates to the ([^\"]*) page$")
	public void a_webtools_user_navigates_to_a_page(String namedPage) throws Exception {
		visualSteps.openPage(namedPage);
}

	@When("^a webtools screen capture is taken of the video player at ([^\\\"]*) seconds$")
	public void a_screen_capture_is_taken_of_the_videoplayer(Integer setTime) throws Exception {
		visualSteps.setVideoIndex(setTime);
		visualSteps.captureScreen(jobName);
}
	
	@When("^a webtools screen capture is taken of the website$")
	public void a_screen_capture_is_taken_of_the_website() throws Exception {
    		visualSteps.captureScreen(jobName);
	}
	
	@Then("^the video player capture is compared to the baseline image$")
	public void capture_compaired_to_baseline() {
		visualSteps.getResultsOfScreenCompair();
	}
	
	@Then("^the webtools capture is compared to the baseline image$")
	public void webtools_capture_compaired_to_baseline() {
		visualSteps.getResultsOfScreenCompair();
	}

	@Then("^the captured page is compared to a baseline$")
	public void capture_and_compaire_to_baseline() {
		visualSteps.getResultsOfScreenCompair();
	}
	

	@Then("^scroll to the next video on the page and take a screen capture of the page$")
	public void scroll_and_capture() {
		visualSteps.getResultsOfScreenCompair();
	}
	
}
