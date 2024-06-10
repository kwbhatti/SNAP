package com.natgeo.webtools.scenarioSteps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.webtools.pages.VisualBasePage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;


public class VisualScenarioSteps extends ScenarioSteps {

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
		//vPage.remove_jump_menu();
		//vPage.remove_sticky_header_ad_element();
		//vPage.close_pops();
		//vPage.slowScrollToBottom();
	}
	
	@Step("Capture the screen")
	public void captureScreen(String testName) {
		vPage.checkWindowApplitools("AEMCORE", testName); 
	}
	
	//@Step("Get screen compair results")
	public void getResultsOfScreenCompair() {
		//Serenity.takeScreenshot();
		vPage.checkWindowResults();
	}
		
	
	public void abortApplitoolTest() {
		vPage.abortApplitoolsTest();
	}
	
	
	public void setVideoIndex(Integer timeInSeconds) {
		vPage.setVideoTimeIndex(timeInSeconds);
	}
}


