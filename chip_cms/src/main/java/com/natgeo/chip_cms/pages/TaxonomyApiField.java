package com.natgeo.chip_cms.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import com.natgeo.utilities.ScrollUtil;
import org.junit.Assert;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class TaxonomyApiField extends PageObject {

	private WebElementFacade field;
	private WebElementFacade resultsDropDown;
	private List<WebElementFacade> resultsDropDownOptions;
	private WebElementFacade suggestTermDropDownOption;
	private WebElementFacade suggestedTermItem;
	private WebElementFacade suggestedTermItemRemoveButton;
	private WebElementFacade termRemoveButton;
	private List<WebElementFacade> termRemoveButtonList;
	private String fieldName;
	
	@FindBy(xpath="//*[@class[contains(.,'new-term')]]")
	private WebElementFacade suggestTermButton;
	
	@FindBy(className="select2-selection__choice__remove")
	private WebElementFacade suggestTermRemoveButton;
	
	@FindBy(className="new-term")
	private WebElementFacade suggestTermColorClass;
	
	public TaxonomyApiField(WebDriver driver, String fieldName) {
		super(driver);
		this.fieldName = fieldName;
		initializeElements();
	}

	private void initializeElements() {
		field = find(By.xpath("//*[@id='" + fieldName + "-wrapper']//input[@type='search']"));
		resultsDropDown = find(By.id("select2-" + fieldName + "-results"));
		suggestTermDropDownOption = find(By.xpath("//*[@id='select2-" + fieldName + "-results']/li[@class[contains(.,'new-term')]]"));
		suggestedTermItem = find(By.xpath("//*[@id='" + fieldName + "-wrapper']//li[@class[contains(.,'new-term')]]"));
		suggestedTermItemRemoveButton = find(By.xpath("//*[@id='" + fieldName + "-wrapper']//li[@class[contains(.,'new-term')]]/span[@class='select2-selection__choice__remove']"));
		termRemoveButton = find(By.xpath("//*[@id='" + fieldName + "-wrapper']//span[@class='select2-selection__choice__remove']"));
	}

	public boolean sendKeysAndVerifyDropDownIsDisplayed(String text) {
		try {
			field.sendKeys(text);
			return resultsDropDown.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public boolean sendKeysAndVerifyDropDownOptionsContainText(String text) {
		boolean res = true;
		for (WebElementFacade item : resultsDropDownOptions) {
			System.out.println(item.getText().toLowerCase());
		    if (!item.getText().toLowerCase().contains(text.toLowerCase())) {
		    		res = false;
		    		break;
		    }
		}
		return res;
	}
	
	public boolean sendKeysAndVerifySuggestTermButtonIsDisplayed(String text) {
		field.sendKeys(text);
		return suggestTermDropDownOption.isDisplayed();
	}
	
	public boolean addSuggestedTermAndVerifyIsAdded(String text) {
		field.sendKeys(text);
		suggestTermDropDownOption.click();
		boolean res = suggestedTermItem.isDisplayed();
		removeSuggestedTermAndVerifyIsRemoved();
		return res;
	}
		
	public boolean removeSuggestedTermAndVerifyIsRemoved() {
		suggestedTermItemRemoveButton.click();
		return !suggestedTermItem.isDisplayed();
	}

	public void type(String text) {
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), field);
			field.type(text);
		} catch (Exception e) {
			Assert.assertTrue("Not able to type keys on element: " + fieldName, false);
		}
	}

	public void  resultsDropDownIsDisplayed() {
		Assert.assertTrue("Taxonomy results drop down is not displayed. Element: " + fieldName, resultsDropDown.isDisplayed());
	}

	public List<String> getDropDownOptionsList() {
		resultsDropDownOptions = findAll(By.xpath("//*[@id='select2-" + fieldName + "-results']/li"));
		List<String> optionsList = new ArrayList<>();
		for (int i=0; i < resultsDropDownOptions.size(); i++) {
			optionsList.add(resultsDropDownOptions.get(i).getText());
		}
		Assert.assertTrue("No results from Taxonomy API were retrieved", optionsList.size() > 0);
		return optionsList;
	}

	public void addValue(String text) {
		field.sendKeys(text);
		waitForResultsDropDownVisible();
		field.sendKeys(Keys.ENTER);
	}
	
	public void waitForResultsDropDownVisible() {
		resultsDropDown = find(By.xpath("//*[@id='select2-" + fieldName + "-results']/li[2]"));
		resultsDropDown.waitUntilClickable();
	}

	public void clear() {
		termRemoveButtonList = findAll(By.xpath("//*[@id='" + fieldName + "-wrapper']//span[@class='select2-selection__choice__remove']"));
		for (int i = 0; i< termRemoveButtonList.size(); i++){
			termRemoveButton.click();
		}
	}

	public void isResultsDropDownDisplayed() {
		try {
			resultsDropDown = find(By.xpath("//*[@id='select2-" + fieldName + "-results']/li[2]"));
			resultsDropDown.isDisplayed();
		} catch (Exception e) {
			Assert.assertTrue("Results Dropdown is not displayed", false);
		}
	}

	public void doTaxonomyResultsContainMatchingWord(String text) {
		boolean res = true;
		waitForResultsDropDownVisible();
		resultsDropDownOptions = findAll(By.xpath("//*[@id='select2-" + fieldName + "-results']/li"));
		List<String> fieldDropDownOptions = getDropDownOptionsList();
		for (String option : fieldDropDownOptions) {
		    if (!option.toLowerCase().contains(text.toLowerCase())) {
		    		res = false;
		    		break;
		    }
		}
		Assert.assertTrue("Drop down options don't contain matching term: " + text, res);		
	}
	
	public void IsSuggestTermButtonDisplayed() {
		try {
			suggestTermButton.isDisplayed();
		}
		catch(Exception e){
			Assert.assertTrue("Suggest term button is not displayed", false);
		}
	}

	public void removeSuggestedTerm() {
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), suggestTermRemoveButton);
			suggestTermRemoveButton.click();
		}
		catch(Exception e){
			Assert.assertTrue("Not able to remove suggest term", false);
		}
	}
	
	public boolean suggestedTermIsNotDisplayed() {
		try {
			suggestTermRemoveButton.isDisplayed();
			Assert.assertTrue("Drop down options don't contain matching term: ", false);
			return false;
		}
		catch(Exception e){
			return true;
		}
	}

	public void addSuggestedTerm(String text) {
		field.sendKeys(text);
		suggestTermButton.waitUntilClickable();
		suggestTermButton.click();
	}

	public void clickSuggestTermButton() {
		try {
			ScrollUtil.scrollToEndOfElement(getDriver(), suggestTermButton);
			suggestTermButton.click();
		}
		catch(Exception e){
			Assert.assertTrue("Not able to click on suggest term button", false);
		}
	}
	
	public void suggestedTermHasBackgroundColorClass() {
		try {
			suggestTermColorClass.isDisplayed();
		}
		catch(Exception e){
			Assert.assertTrue("Suggest term does not reflect a different style class", false);
		}
	}
	
}
