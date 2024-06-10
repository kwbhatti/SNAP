package com.natgeo.examples;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"junit:target/test-report/cucumber.xml","pretty"},
        features = "src/test/resources/com/natgeo/examples/"
)


public class ExamplesTestSuite {

}
