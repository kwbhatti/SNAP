package com.natgeo.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.serenitybdd.core.pages.PageObject;

public class VideoPlayerUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(VideoPlayerUtils.class);
	
	public static void setPlayerTimeFirstInstance(PageObject pgObj, String id, Integer startTime) {
		pgObj.findBy("//video[contains(@id,'" + id + "')]/..").click();
		
		String jsTxt =  "var vid=document.getElementById('" + id + "');" +
		                 "vid.pause();" + 
						 "vid.currentTime = " + +  startTime + ";" + 
						 "vid.play();vid.pause()";
		pgObj.evaluateJavascript(jsTxt);
	}
}
