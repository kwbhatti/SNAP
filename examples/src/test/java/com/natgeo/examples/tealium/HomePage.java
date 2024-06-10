package com.natgeo.examples.tealium;


import static com.natgeo.browsermob.GetHeaderRequest.getResponseUrls;
import static com.natgeo.browsermob.GetHeaderRequest.parseHeader;
import  com.natgeo.browsermob.LoadTestFile;
import static com.natgeo.browsermob.CheckValues.checkValuesByVariableNames;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.natgeo.browsermob.data.TestData;;

public class HomePage {
	
	@Test
	public void checkHomePage() throws Exception {
		List<String> requests = getResponseUrls("https://www.nationalgeographic.com","b/ss");
		Map<String,String> foundValues = parseHeader(requests.get(0));
		Map<String,TestData>  expectedValues = LoadTestFile.getFile("HomePage.property");
		checkValuesByVariableNames("Home Page Default Values", expectedValues, foundValues);
		
		expectedValues.clear();
		expectedValues = LoadTestFile.getFile("HomePageAdditional.property");
		checkValuesByVariableNames("Home Page Additional Values", expectedValues, foundValues);
	}
}
