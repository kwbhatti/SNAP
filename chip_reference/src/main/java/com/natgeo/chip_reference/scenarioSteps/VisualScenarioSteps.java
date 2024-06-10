package com.natgeo.chip_reference.scenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.chip_reference.scenarioSteps.VisualScenarioSteps;

import com.natgeo.chip_reference.pages.VisualBasePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class VisualScenarioSteps extends ScenarioSteps{
	

	private static final long serialVersionUID = -7962223796324571198L;
	private static final Logger LOGGER = LoggerFactory.getLogger(VisualScenarioSteps.class);
	VisualBasePage vPage;
   
	public VisualScenarioSteps(Pages pages) {
		super(pages);
	}
	
	@Step("Open Page")
	public void openPage(String namedURL) {
		String[] parms = {"1","2"};

		vPage.open(namedURL, parms);  
		vPage.slowScrollToBottom();
	}
	
	@Step("Capture the screen")
	public void captureScreen(String testName) {
		vPage.checkWindowApplitools("CHIP Referene", testName); 
	}
	
	//@Step("Get screen compair results")
	public void getResultsOfScreenCompair() {
		//Serenity.takeScreenshot();
		vPage.checkWindowResults();
	}
		
	
	public void abortApplitoolTest() {
		vPage.abortApplitoolsTest();
	}

}
