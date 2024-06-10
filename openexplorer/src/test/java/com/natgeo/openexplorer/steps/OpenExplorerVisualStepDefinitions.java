package com.natgeo.openexplorer.steps;


import com.natgeo.openexplorer.scenarioSteps.VisualScenarioSteps;
import com.natgeo.utilities.LoaderUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OpenExplorerVisualStepDefinitions {
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

    
	@Given("^an openexplorer user navigates to the ([^\"]*) page$")
	public void a_user_navigates_to_a_page(String namedPage) throws Exception {
    		visualSteps.openPage(namedPage);
	}

	@When("^an openexplorer screen capture is taken of the website$")
	public void a_screen_capture_is_taken_of_the_website() throws Exception {
    		visualSteps.captureScreen(jobName);
	}
	
	@Then("^the openexplorer capture is compared to the baseline image$")
	public void capture_compaired_to_baseline() {
		visualSteps.getResultsOfScreenCompair();
	}

	@Then("^an openexplorer screen capture is taken of the website and the results compaired to a baseline$")
	public void capture_and_compaire_to_baseline() {
		visualSteps.getResultsOfScreenCompair();
	}
}
