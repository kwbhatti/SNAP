package com.natgeo.chip_cms.scenarioSteps;

import org.openqa.selenium.WebDriver;
import com.natgeo.chip_cms.pages.ChipCmsContentPrimarySettingsPage;
import com.natgeo.chip_cms.pages.ChipCmsTestContentEditPage;
import net.thucydides.core.annotations.Step;

public class EditContentSteps {

	private ChipCmsTestContentEditPage testContentEditPage;
	private ChipCmsContentPrimarySettingsPage contentPrimarySettingsPage;
	private WebDriver currentDriver;

	public void setDriver(WebDriver driver) {
		currentDriver = driver;
	}
	
	@Step("Types text in Subjects taxonomy field")
	public void typesTextInTaxonomyField(String text){
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.subjectsLimited.type(text);
	}

	@Step("Verify results dropdown is displayed")
	public void resultsDropDownIsDisplayedAtTaxonomyField() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.subjectsLimited.isResultsDropDownDisplayed();
	}

	public void doApiTaxonomyResultsContainMatchingWord(String text) {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.subjectsLimited.doTaxonomyResultsContainMatchingWord(text);
	}

	public WebDriver clickOnSaveButtonAtContentPrimarySettingsPage() {
		contentPrimarySettingsPage = new ChipCmsContentPrimarySettingsPage(currentDriver);
		contentPrimarySettingsPage.clickSaveButton();
		return null;
	}

	public void shouldAllowSuggestNewTerm() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.IsSuggestTermButtonDisplayed();
	}
	
	public void addSuggestionTermValueInTaxonomyField() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.addSuggestedTerm("14141414");
	}

	public void removeSuggestedTermInTaxonomyField() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.removeSuggestedTerm();
	}

	public void suggestedTermIsRemoved() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.suggestedTermIsNotDisplayed();
	}

	public void suggestedTermHasDifferentBackgroundColor() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.suggestedTermHasBackgroundColorClass();
	}

	public void addMultipleValuesInLimitedValueTaxonomyField() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.subjectsLimited.clear();
		testContentEditPage.subjectsLimited.addValue("Astronomy");
		testContentEditPage.subjectsLimited.addValue("Geology");
		testContentEditPage.subjectsLimited.addValue("Weather");
		testContentEditPage.clickSaveButton();
	}

	public void exceedingValueLimitErrorMessageIsDisplayed() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.verifyExceedingLimitedValuesMessage();
	}

	public void typesTextInTaxonomyFieldThatAcceptsSuggestions(String text) {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.type(text);
	}

	public void clickSuggestTermButton() {
		testContentEditPage = new ChipCmsTestContentEditPage(currentDriver);
		testContentEditPage.personsAllowNewTerms.clickSuggestTermButton();
	}

}
