package com.natgeo.openexplorer.pages;

import static com.natgeo.utilities.WaitForUtils.waitForAllAjaxCalls;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;


@NamedUrls({			
	@NamedUrl(name = "Homepage", url = "/home")	,
	@NamedUrl(name = "Startpage", url = "/start")	,
	@NamedUrl(name = "Aboutpage", url = "/about")		
})
public class VisualBasePage extends OpenExplorerBasePage{
	
	public VisualBasePage(WebDriver driver) {
		super(driver);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(VisualBasePage.class);
	private static final String SURVEY_DIALOG_CLOSE_CSS = "div[class*='smcx-modal-survey']>div[class*='smcx-modal-header']>div[class*='smcx-modal-close']"; 
	private static final String TRIP_DIALOG_CLOSE_CSS = "div[id^='monetate_selectorHTML']>div[class*='toaster-wrap clearfix']>div[class*='header-wrap clearfix']>a>img"; 

	
	@FindBy(css = SURVEY_DIALOG_CLOSE_CSS)
	public WebElementFacade survey;

	@FindBy(css = TRIP_DIALOG_CLOSE_CSS)
	public WebElementFacade trip;
	

	public void close_pops() {
		Boolean bFound = false;
		Integer x = 0;
		
		do {			
			if( survey.isCurrentlyVisible() ) {
				LOGGER.info("Removing survey popup");
				survey.click();
				bFound = true;
			} else if( trip.isCurrentlyVisible() ) {
				LOGGER.info("Removing trip popup");
				trip.click();
				bFound = true;
			}
			
			waitFor(100).milliseconds();
			x++;
		} while(x<51 && !bFound);
	}
	
	
	public void remove_sticky_header_ad_element() {
		try {
			//Remove Ads
			evaluateJavascript("var ads = document.getElementsByClassName('adunit'); for(var i=0; i<ads.length; i++){ads[i].style.display='none'}");
			
			// Remove Travel Promo
			evaluateJavascript("var ads = document.getElementsByClassName('travelCtaPromo'); for(var i=0; i<ads.length; i++){ads[i].style.display='none'}");
			
			LOGGER.info("Removed the sticky header ad element and travel promo from the page");
		} catch (Exception e) {
			//Do Nothing
		}
	}
	
	
	public void remove_jump_menu() {
		try {
			evaluateJavascript("return document.getElementsByClassName('ngs-jummp-menu-close-btn')[0].click();");
			LOGGER.info("Removed the jump menu from the page");
		} catch (Exception e) {
			//Do nothing
		}
	}
	
	public void slowScrollToBottom() {
		evaluateJavascript("window.scrollTo(0, 0)");
		
		Long scrHeight = (Long) evaluateJavascript("return document.body.scrollHeight");
		//Integer scrHeight = getDriver().manage().window().getSize().getHeight();
		Long screenNudge = Long.valueOf(scrHeight/200);
		Long screenPosition = screenNudge;
		
		
		while( screenPosition < scrHeight) {
			evaluateJavascript("window.scrollBy(0, " + screenNudge + ")");
			waitFor(30).milliseconds();
			screenPosition = screenPosition + screenNudge;
			waitForAllAjaxCalls(this,30);
		}
		
	}
	
}
