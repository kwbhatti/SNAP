package com.natgeo.examples.steps;

import com.natgeo.examples.scenarioSteps.ExampleAPIScenarioSteps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;


public class ExampleApiCountriesSearch {
	
   @Steps
   ExampleAPIScenarioSteps countriesSearchSteps;

   @Given("^the REST endpoint named \"([^\"]*)\" is used with the \"([^\"]*)\" arguments$")
   public void verifyThatWeCanFindUnitedStatesOfAmericaCountryUsingTheCodeUS(String urlStr, String args) {
       countriesSearchSteps.searchCountryByCode(urlStr,args);
   }

   @When("^the REST endpoint is succesfully excuted$")
   public void checkForSuccesfulReturnCode() {
       countriesSearchSteps.searchIsExecutedSuccesfully();   
   }
   
   @Then("^the returned JSON should contain the country \"([^\"]*)\"$")
   public void theReturnCountryShouldContain(String country) {
       countriesSearchSteps.iShouldFindCountry(country);
   }
}