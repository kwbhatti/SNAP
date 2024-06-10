package com.natgeo.globalsites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"junit:target/test-report/cucumber.xml","pretty"},
        features = "src/test/resources/com/natgeo/globalsites/"
)


public class GlobalSitesTestSuite {

}
