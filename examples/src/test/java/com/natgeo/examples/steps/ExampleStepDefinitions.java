package com.natgeo.examples.steps;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import com.natgeo.examples.scenarioSteps.ExampleScenarioSteps;
import com.natgeo.utilities.LoaderUtil;
import com.natgeo.utilities.ScrollUtil;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class ExampleStepDefinitions {
	String jobName;


	@Steps
	ExampleScenarioSteps exSteps;


	@Before
	public void setUp(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().intilizeValues();
		LoaderUtil.getInstance().startSaucelabs(exSteps.getDriver(), scenario);
		jobName=scenario.getName();
	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		LoaderUtil.getInstance().stopSauceLabs(scenario);
	}

	@Given("^I open a browser to ([^\"]*)$")
	public void open_browser_to(String pageName) {
		if(pageName.toUpperCase().contains("GOOGLE")) {
			exSteps.ExampleBasePage().openGoogle();
		}
		else if(pageName.toUpperCase().contains("WIDE")) {
			exSteps.ExampleBasePage().openWidePage();
		}
	}

	@Then("^notification messages are displayed on the website$")
	public void messages_are_displayed() {
		exSteps.ExampleBasePage().msgSuccess("A successful message");
		exSteps.ExampleBasePage().msgWarning("A warning message");
		exSteps.ExampleBasePage().msgError("A error message");
		exSteps.ExampleBasePage().msgInfo("A info message");
	}

	@Then("^type ([^\"]*)$")
	public void typeSomething(String phrase) {
		exSteps.ExampleBasePage().getDriver().findElement(By.tagName("body")).sendKeys(phrase);
		exSteps.ExampleBasePage().getDriver().findElement(By.tagName("body")).sendKeys(Keys.ENTER);
	}

	@Given("^I scroll to the bottom$")
	public void scrollDownToEnd() {
		WebDriver wd = exSteps.ExampleBasePage().getDriver();
		exSteps.ExampleBasePage().sleep(1);
		ScrollUtil.scrollToEndPage(wd);
		// exSteps.ExampleBasePage().getDriver().findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		// exSteps.ExampleBasePage().getDriver().findElement(By.tagName("body")).sendKeys(Keys.END);
		exSteps.ExampleBasePage().sleep(2);
	}

	@Given("^I scroll by amount 100,100$")
	public void scrollBy() {
		WebDriver wd = exSteps.ExampleBasePage().getDriver();
		exSteps.ExampleBasePage().sleep(1);
		ScrollUtil.scrollByAxis(wd,100,100);
		exSteps.ExampleBasePage().sleep(2);
	}

}
