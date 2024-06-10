package com.natgeo.chip_reference.api_components;

import java.util.*;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;

import com.natgeo.utilities.LoaderUtil;

public class ApiValidationCommonMethods {

	public String header;
	public String headerValue;
	public String contentTypes = "image,video,gallery,text";
	public String hasText_regEx = ".{3,}";
	public String version_regEx = "[0-9]+\\.[0-9]+\\.[0-9]+";
	public String booleanValues = "true,false";
	public String aspectRatio_regEx = "[0-9]+\\:[0-9]+";
	public String urlValue = "https://";
	public String double_regEx = "[0-9]+\\.[0-9]+";
	
	public ApiValidationCommonMethods() {
		LoaderUtil.getInstance().intilizeValues();
		header = LoaderUtil.getInstance().chipReferenceStagingHeaderKey;
		headerValue = LoaderUtil.getInstance().chipReferenceStagingHeaderValue;
	}
	
	public boolean listValuesMatchMultipleRegEx(List<String> list, String[] regExArray) {
		int counter = 0;
		int evaluatedItems = 0;
		if (list.size() > 0) {
			for (String item : list) {
				item = cleanString(item);
				String [] itemSubList = item.split(",");
				for (String subItem : itemSubList) {
					evaluatedItems++;
					subItem = cleanString(subItem);
					for (int i=0; i < regExArray.length; i++) {	
						if (subItem.matches(regExArray[i])) {
							counter++;
						}
					}
				}
			} 
			if (counter == evaluatedItems)
				return true;
		}
		return false;
	}
	
	public List<String> convertListValuesToString(List<?> list){
		List<String> resList = new ArrayList<String>();
		for(int i=0; i<list.size(); i++) {
			resList.add(list.get(i).toString());
		}
		return resList;
	}
	
	public String cleanString(String itemToClean) {
		return itemToClean.replace("[", "").replace("]", "").trim();
	}
	
	public void assertListValuesFromJsonPathAreDigits(JsonPath jsonPathEvaluator, String jsonPath) {
		List<String> valueList = getValueListFromJsonPath(jsonPathEvaluator, jsonPath);
		assertListValuesAreDigits(valueList);
	}
	
	public void assertListValuesAreDigits(List<String> valueList) {
		long matchCount = valueList.stream().filter(p -> p.matches("[0-9]+")).count();
		Assert.assertTrue(">>>> " + matchCount  + " out of " + valueList.size() + " values are digits in " + valueList, matchCount == valueList.size());
	}
	
	public void assertListValuesFromJsonPathMatchWithRegEx(JsonPath jsonPathEvaluator, String jsonPath, String regEx) {
		List<String> valueList = getValueListFromJsonPath(jsonPathEvaluator, jsonPath);
		assertListValuesMatchWithRegEx(valueList, regEx);
	}
	
	public void assertListValuesMatchWithRegEx(List<String> valueList, String regEx) {
		long matchCount = valueList.stream().filter(p -> p.matches(regEx)).count();
		Assert.assertTrue(">>>> " + matchCount  + " out of " + valueList.size() + " values matched regular expresion \"" + regEx + "\" in " + valueList, matchCount == valueList.size());
	}
	
	public void assertListValuesContainSubstring(List<String> valueList, String searchedSubstrings) {
		long matchCount = 0;
		String[] searchedSubstringArray = searchedSubstrings.split(",");
		for (String searchedSubstring : searchedSubstringArray) {
			matchCount += valueList.stream().filter(p -> p.contains(searchedSubstring)).count();
		}
		Assert.assertTrue(">>>> " + matchCount  + " out of " + valueList.size() + " values contains \"" + searchedSubstrings + "\" in " + valueList, matchCount == valueList.size());
	}
	
	public void assertListValuesFromJsonPathContainSubstring(JsonPath jsonPathEvaluator, String jsonPath, String searchedSubstrings) {
		List<String> valueList = getValueListFromJsonPath(jsonPathEvaluator, jsonPath);
		assertListValuesContainSubstring(valueList, searchedSubstrings);
	}

	public void assertListContainsValuesThatMatchesWithMultipleRegExFormat(JsonPath jsonPathEvaluator, String jsonPath, String[] regExArray){
		List<String> valueList = convertListValuesToString(jsonPathEvaluator.get(jsonPath));
		Assert.assertTrue(jsonPath + " contains values with Invalid format:\n" + valueList, listValuesMatchMultipleRegEx(valueList, regExArray));
	}

	public List<String> getValueListFromJsonPath(JsonPath jsonPathEvaluator, String jsonPath){
		String matchResultString = jsonPathEvaluator.get(jsonPath).toString();
		matchResultString = cleanString(matchResultString);
		String[] matchResultsArray = matchResultString.split(",");
		List<String> resList = new ArrayList<String>();
		for (String value : matchResultsArray)
			resList.add(value.trim());
		return resList;
	}
	
	public long getValueOcurrencesFromList(List<String> valueList, String searchedValue) {
		return valueList.stream().filter(p->p.equals(searchedValue)).count();
	}
	
}
