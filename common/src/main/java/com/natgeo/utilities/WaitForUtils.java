package com.natgeo.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

/**
 * These functions are used to wait for objects to appear or disappear without
 * causing the test to fail
 * 
 */
public final class WaitForUtils {
   private static final Logger LOGGER = LoggerFactory.getLogger(WaitForUtils.class);
   //private static final int DEFAULT_WAIT_BEFORE_CHECKING = 2;

   /*
    * Use waitForElementToBePresent when the selector must appear, and remain,
    * before your work can continue
    */
   public static void waitForAllAjaxCalls(final PageObject pageObj, int maxWaitInSeconds) {
	//LOGGER.info("waitForAllAjaxCalls: CallingClass(" + pageObj.getClass().getSimpleName() + ") MaxWaitTime(" + maxWaitInSeconds + ")");
	
	try {	  
	  //pageObj.waitFor(500).milliseconds();
	  
	  pageObj.getDriver().manage().timeouts().setScriptTimeout(maxWaitInSeconds, TimeUnit.SECONDS);
	  //WebDriverWait wait = new WebDriverWait(pageObj.getDriver(), maxWaitInSeconds);

	  // Wait for the DOM to finish loading the page
	  //pageObj.waitFor(500).milliseconds();
	  
	  ExpectedCondition<Boolean> pageLoadDone = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
		  return Boolean.valueOf(pageObj.evaluateJavascript(
				  "return ( function () { " + 
			        "	var rtnVal = true; " + 
			        "	function getAllFrames(frame, allFrameArray) { " + 
			        "	 allFrameArray.push(frame.frames); " + 
			        "	 for(var i = 0; i < frame.frames.length; i++){ " + 
			        "	   getAllFrames(frame.frames[i], allFrameArray); " + 
			        "	 } " + 
			        "	 return allFrameArray; " + 
			        "	} " + 
			        "	function checkExt(frameExt) { " + 
			        "	  var rtnVal1=true; " + 
			        "	  if(frameExt.Ext !== undefined){ " + 
			        "	     rtnVal1 = (frameExt.Ext.Ajax.isLoading() === false) && "
			        + "               ($(\"div[class*='x-mask-loading']\").is(':visible') === false); " + 
			        "	  } " + 
			        "	  return rtnVal1; " + 
			        "	} " + 
			        "	function checkAEM(frameExt) { " + 
			        "	  var rtnVal1=true; " + 
			        "	  if(frameExt.CQ !== undefined){ " + 
			        "	     rtnVal1 = (frameExt.CQ_isContentWindowLoading === false);" + 
			        "	  } " + 
			        "	  return rtnVal1; " + 
			        "	} " + 
			        " function checkAngular(frameAng) { " + 
			        "	 var rtnVal2=true; " + 
			        "	 if(frameAng.angular !== undefined){ " + 
			        "	    (frameAng.angular.element(document).injector() !== undefined) && " + 
			        "       (frameAng.angular.element(document).injector().get('$http').pendingRequests.length === 0) && " +
			        "       (frameAng.angular.element('fa-spinner').is(':visible') === false)" + 
			        "	 } " + 
			        "	 return rtnVal2; " + 
			        "	} " + 
			        "	function checkDoneLoading(frameElm, index) { " + 
			        "	  rtnVal = rtnVal &&  " + 
			        "	          (frameElm.document.readyState === 'complete') && " + 
			        "	          checkAEM(frameElm) && " + 
			        "	          checkExt(frameElm) && " + 
			        "	          checkAngular(frameElm) " + 
			        "	} " + 
			        " var allFramesArray = getAllFrames(window.top, new Array()); " + 
			        " allFramesArray.forEach(checkDoneLoading); " + 
			        " return rtnVal; " + 
			        " })(); ").toString());
		}
	  };
	  pageObj.waitFor(pageLoadDone).withTimeoutOf(maxWaitInSeconds, TimeUnit.SECONDS);
	  
	  // Put in to wait for the DOM to update
	  pageObj.waitForAngularRequestsToFinish();
	  
	 //pageObj.waitFor(1000).milliseconds();
	} catch (Exception e) {
	  //LOGGER.warn("Unable to load the page correctly, angular can do this, ext js cannot");
	}

   }

}