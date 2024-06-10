package com.natgeo.chip_reference.pages;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import static com.natgeo.utilities.WaitForUtils.waitForAllAjaxCalls;

@NamedUrls({			
	@NamedUrl(name = "403", url = "/403"),
	@NamedUrl(name = "404", url = "/404"),
	@NamedUrl(name = "AroundTheWorld", url = "/around-the-world"),
	@NamedUrl(name = "Article", url = "/archaeology-and-history/magazine/2018/01-02/silk-road-history"),
	@NamedUrl(name = "BigCatMonth", url = "/big-cat-month"),
	@NamedUrl(name = "ExploreTheOcean", url = "/explore-the-ocean"),
	@NamedUrl(name = "Home", url = "/"),
	@NamedUrl(name = "Hub", url = "/animals"),
	@NamedUrl(name = "Hummingbird", url = "/hummingbird"),
	@NamedUrl(name = "PathOfPersecution", url = "/path-of-persecution"),
	@NamedUrl(name = "PhotoOfTheDay", url ="/photography/photo-of-the-day"),
	@NamedUrl(name = "PrivacyPolicy", url = "/privacy-policy"),
	@NamedUrl(name = "Search", url = "/search"),
	@NamedUrl(name = "SearchNoResults", url = "/no-results"),
	@NamedUrl(name = "Series", url = "/series"),
	@NamedUrl(name = "Subaru", url = "/subaru"),
	@NamedUrl(name = "Subscribe", url = "/subscribe"),
	@NamedUrl(name = "TelevisionSchedule", url = "/television-schedule"),
	@NamedUrl(name = "TermsOfService", url = "/terms-of-service"),
	@NamedUrl(name = "WhereToWatch", url = "/where-to-watch"),

})


public class VisualBasePage extends NatGeoBasePage{
	
	public VisualBasePage(WebDriver driver) {
		super(driver);
	}
	
	private static final Logger LOGGER = LoggerFactory.getLogger(VisualBasePage.class);
	
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
