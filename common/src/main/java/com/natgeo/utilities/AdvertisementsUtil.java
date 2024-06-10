package com.natgeo.utilities;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


public class AdvertisementsUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdvertisementsUtil.class);
	

	public static void verify_advertisement_present(PageObject pageObj) {
    		List<WebElement> ads = pageObj.getDriver().findElements( By.cssSelector(".ad-holder") );
        
    		if( ads.size() > 0 ) {
    			for(WebElement ad: ads) {

    				// Retry to fine element if you get a stale element (up to 3 times)
    				int attempts = 0;
			    while(attempts < 2) {
			    	  try {
			    		  WebElement frameElement = ad.findElement(By.xpath("//*[@title=\"3rd party ad content\"]"));
			    		  pageObj.getDriver().switchTo().frame(frameElement);
			    	  } catch(StaleElementReferenceException e) {
			    	  }
			    	  attempts++;
			    }
	        
    				LOGGER.info("Found ads--> " + ads.size());
    				
    			
    				if( pageObj.getDriver().findElements(By.cssSelector("[id*=google_]")).size() > 0) {
    					WebElement googleAd = pageObj.getDriver().findElement(By.cssSelector("[id*=google_]"));
    					assertThat("Advertisement is not visible as expected", googleAd.isDisplayed(), equalTo(true));
    				} else {
    					assertThat("(not found) Advertisement is not visible as expected", 0, equalTo(1));
    				}
    			}
    		} else {
    			assertThat("Advertisement is not visible as expected",true, equalTo(true));
    		}
    		
    		pageObj.getDriver().switchTo().defaultContent();	
	}


    public static void verify_advertisement_count(PageObject pageObj, Integer count) {
    		List<WebElementFacade> ads = pageObj.findAll(".ad-holder");
    		
        assertThat("Did not find expected number of ads on the page", ads.size(), equalTo(count) );
    }
}