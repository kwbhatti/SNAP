package com.natgeo.chip_cms.steps;

import com.natgeo.chip_cms.scenarioSteps.ConfigureContentSettingsSteps;
import com.natgeo.chip_cms.scenarioSteps.ContentMediaSteps;
import com.natgeo.chip_cms.scenarioSteps.CreateContentSteps;
import com.natgeo.chip_cms.scenarioSteps.CreateContentTypeSteps;
import com.natgeo.chip_cms.scenarioSteps.EditContentSteps;
import com.natgeo.chip_cms.scenarioSteps.LoginSteps;
import com.natgeo.chip_cms.scenarioSteps.NavigationSteps;
import com.natgeo.chip_cms.scenarioSteps.PageLayoutSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import net.thucydides.core.annotations.Steps;

public class ChipCmsLayoutStepDefinitions {

	private WebDriver currentPageDriver;

	@Steps
	LoginSteps loginSteps;

	@Steps
	EditContentSteps editContentSteps;

	@Steps
	NavigationSteps navigationSteps;

	@Steps
	PageLayoutSteps layoutSteps;

	@Steps
	CreateContentSteps createContentSteps;

	@Steps
	ConfigureContentSettingsSteps configureContentSettingsSteps;

	@Steps
	CreateContentTypeSteps createContentTypeSteps;

	@Steps
	ContentMediaSteps mediaSteps;


	@Given ("^\"([^\"]*)\" logs into application$")
	public void user_logs_into_application(String user) {
		currentPageDriver = loginSteps.loginWith(user);
	}

	@When("^lands on content page$")
	public void lands_on_content_page() throws Exception {
		content_page_is_displayed();
	}

	@Given ("^\"([^\"]*)\" is at content page$")
	public void user_is_at_content_page(String user) {
		user_logs_into_application(user);
		content_page_is_displayed();
	}

	@Given("^\"([^\"]*)\" is at the edit page of a story node that has a taxonomy API field$")
	public void a_user_is_at_the_edit_page_of_a_story_node_that_has_taxonomy_field(String user) {
		user_logs_into_application(user);
		createContentTypeSteps.setDriver(currentPageDriver);
		createContentTypeSteps.createTestContentType();
		navigationSteps.setDriver(currentPageDriver);
		currentPageDriver = navigationSteps.goToEditTestContentItemPage();
	}

	@Given("^\"([^\"]*)\" has suggested a candidate term in a taxonomy field")
	public void a_user_has_suggested_a_candidate_term_in_a_taxonomy_field (String user) {
		a_user_is_at_the_edit_page_of_a_story_node_that_has_taxonomy_field(user);
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.addSuggestionTermValueInTaxonomyField();
	}

	@Given("^\"([^\"]*)\" enters a text that is not found in a taxonomy field that accepts suggestions")
	public void a_user_enters_a_text_that_is_not_found_in_a_taxonomy_field_that_accepts_suggestions (String user) {
		a_user_is_at_the_edit_page_of_a_story_node_that_has_taxonomy_field(user);
		types_a_term_that_doesnt_exist_in_taxonomy_api_that_accepts_suggestions();
	}

	@When("types 3 letters in taxonomy field")
	public void types_3_letters_in_taxonomy_field() {
		types_text_in_taxonomy_field("car");
	}

	@Then("taxonomy field displays a list of matching terms")
	public void taxonomy_field_displays_a_list_of_matching_terms() {
		editContentSteps.resultsDropDownIsDisplayedAtTaxonomyField();
	}

	@When("types a term in taxonomy field that matches multiple results")
	public void types_a_term_that_matches_multiple_results() {
		types_text_in_taxonomy_field("River");
	}

	public void types_text_in_taxonomy_field(String text) {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.typesTextInTaxonomyField(text);
	}

	@Then("taxonomy field displays a list with of the matched terms with additional context data")
	public void taxonomy_field_displays_a_list_with_of_the_matched_terms_with_additional_context_data() {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.doApiTaxonomyResultsContainMatchingWord("River");
	}

	@When("types a term that doesnt exist in taxonomy api that accepts suggestions")
	public void types_a_term_that_doesnt_exist_in_taxonomy_api_that_accepts_suggestions() {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.typesTextInTaxonomyFieldThatAcceptsSuggestions("4141414");
	}

	@Then("suggest term button is displayed")
	public void suggest_term_button_is_displayed() {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.shouldAllowSuggestNewTerm();
	}

	@When("clicks in suggest term button")
	public void clicks_in_suggest_term_button(){
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.clickSuggestTermButton();
	}

	@When("clicks remove button on the suggested term")
	public void clicks_remove_button_on_the_suggested_term() {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.removeSuggestedTermInTaxonomyField();
	}

	@Then("suggested term is removed")
	public void suggested_term_is_removed () {
		editContentSteps.suggestedTermIsRemoved();
	}

	@Then("suggested term has a different background color")
	public void suggested_term_has_a_different_background_color() {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.suggestedTermHasDifferentBackgroundColor();
	}

	@When("clicks on content tab from toolbar")
	public void clicks_content_tab_from_toolbar() {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.goToContentPage();
	}

	@Then("content page is displayed")
	public void content_page_is_displayed() {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isContentPageDisplayed();
	}

	@When("exceeds the number of values in a limited value taxonomy field")
	public void exceeds_the_number_of_values_in_a_limited_value_taxonomy_field() {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.addMultipleValuesInLimitedValueTaxonomyField();
	}

	@Then("exceeding value limit error message is displayed")
	public void exceeding_value_limit_error_message_is_displayed () {
		editContentSteps.setDriver(currentPageDriver);
		editContentSteps.exceedingValueLimitErrorMessageIsDisplayed();
	}

	@Then ("New content button is displayed at content page")
	public void new_content_button_is_displayed_at_content_page () {
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.isNewContentButtonDisplayedAtContentPage();
	}

	@When ("clicks on new content button at content page")
	public void clicks_on_new_content_button_at_content_page () {
		createContentSteps.setDriver(currentPageDriver);
		currentPageDriver = createContentSteps.clickOnNewContentButton();
	}

	@Then("redirects to create story page")
	public void redirects_to_create_story_page () {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isAtCreateStoryPage();
	}

	@Given("^\"([^\"]*)\" is at content settings page of a created story$")
	public void user_is_at_content_settings_page_of_a_created_story(String user) {
		user_logs_into_application(user);
		navigationSteps.setDriver(currentPageDriver);
		currentPageDriver = navigationSteps.goToContentSettingsPageOfCreatedStory();
	}

	@When("clicks on primary tab")
	public void clicks_on_primary_tab () {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnPrimaryTab();
	}

	@Then("redirects to primary settings page")
	public void redirects_to_primary_settings_page() {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isAtContentPrimarySettingsPage();
	}

	@When("clicks on secondary tab")
	public void clicks_on_secondary_tab () {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnSecondaryTab();
	}

	@Then("redirects to secondary settings page")
	public void redirects_to_secondary_settings_page () {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isAtContentSecondarySettingsPage();
	}

	@When("clicks on advertising tab")
	public void clicks_on_advertising_tab() {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnAdvertisingTab();
	}

	@Then("redirects to advertising settings page")
	public void redirects_to_advertising_settings_page () {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isAtContentAdvertisingSettingsPage();
	}

	@When("clicks on technical tab")
	public void clicks_on_technical_tab() {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnTechnicalTab();
	}

	@Then("redirects to technical settings page")
	public void redirects_to_technical_settings_page () {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isAtContentTechnicalSettingsPage();
	}

	@Then("displays Continue button at create story page")
	public void displays_continue_button_at_create_story_page () {
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.isContinueButtonDisplayedAtCreateStoryPage();
	}

	@Given("^\"([^\"]*)\" is at create story page of a new story$")
	public void user_is_at_create_story_page_of_a_new_story (String user) {
		user_is_at_content_page(user);
		navigationSteps.setDriver(currentPageDriver);
		currentPageDriver = navigationSteps.goToCreateNewStoryPage();
	}

	@When("selects layout type image, enters story title and clicks on continue button")
	public void enters_story_title_and_clicks_on_continue_button () {
		createContentSteps.setDriver(currentPageDriver);
		createContentSteps.selectStoryLayoutImageEnterTitleAndContinueToTextView();
	}

	@Then("redirects to text view page of new story")
	public void redirects_to_text_view_page_of_new_story () {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.isAtStoryTextViewPage();
	}

	@Then("displays a save button at content primary settings page")
	public void displays_a_save_button_at_content_primary_settings_page() {
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.isSaveButtonDisplayedAtContentPrimaryPage();
	}

	@Given("^\"([^\"]*)\" is at primary settings page of a created story$")
	public void user_is_at_primary_settings_page_of_a_created_story (String user) {
		user_logs_into_application(user);
		navigationSteps.setDriver(currentPageDriver);
		currentPageDriver = navigationSteps.goToContentPrimarySettingsPage();
	}

	@When("clicks on save button")
	public void clicks_on_save_button() {
		editContentSteps.setDriver(currentPageDriver);
		currentPageDriver = editContentSteps.clickOnSaveButtonAtContentPrimarySettingsPage();
	}

	@When("clicks text view page save button")
	public void clicks_on_save_button_at_text_view_page() {
		createContentSteps.setDriver(currentPageDriver);
		currentPageDriver = createContentSteps.clickOnSaveButtonAtStoryTextViewPage();
	}

	/*Layout Manager Flow*/

	@Given("^\"([^\"]*)\" is at text view of a new created story$")
	public void is_at_text_view_of_a_new_created_story(String user) {
		user_logs_into_application(user);
		createContentSteps.setDriver(currentPageDriver);
		currentPageDriver=createContentSteps.createNewStoryLayoutImageAndContinueToTextView();
	}

	@Then("^should see layout manager page displayed$")
	public void should_see_layout_manager_page_displayed() {
	    navigationSteps.setDriver(currentPageDriver);
	    navigationSteps.isAtLayoutManagerPage();
	}


	@When("^clicks on layout paragraph$")
	public void clicks_on_layout_paragraph() {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnLayoutParagraph();
	}

	@Then("^add button is displayed$")
	public void add_button_is_displayed() {
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.addButtonIsDisplayed();
	}

	@When("^clicks on add button$")
	public void clicks_on_add_button()  {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnAddButton();

	}

	@Then("^dialog box is displayed$")
	public void dialog_box_is_displayed()  {
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.dialogBoxIsDisplayed();
		layoutSteps.componentsListsIsDisplayed();
	}
	@When("^clicks on image box$")
	public void clicks_on_image_box() {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnImageBox();
	}

	@Then("^image is added$")
	public void image_is_added(){
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.imageAdded();
	}
	
	@When("^user clicks on chiptoolbar$")
	public void user_clicks_on_chiptoolbar() {
		configureContentSettingsSteps.setDriver(currentPageDriver);
		configureContentSettingsSteps.clicksOnLayoutToolBar();
	}

	@Then("^display save button on layoutmanager page$")
	public void display_save_button_on_layoutmanager_page() throws Exception {
		layoutSteps.setDriver(currentPageDriver);
		layoutSteps.isSaveButtonDisplayedAtLayoutManagerPage();
	}

  /*Create Stories with Layout Type Image*/
	@When("^selects layout type image, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button$")
	public void selects_layout_type_image_enters_story_title_seo_title_social_title_promo_title_dek_social_dek_promo_dek_and_clicks_on_continue_button() {
		createContentSteps.setDriver(currentPageDriver);
	    createContentSteps.selectStoryLayoutImageEnterTitleAndContinueToTextView();
	}

	/*Create Stories with Layout Type Video*/
	@When("^selects layout type video, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button$")
	public void selects_layout_type_video_enters_story_title_seo_title_social_title_promo_title_dek_social_dek_promo_dek_and_clicks_on_continue_button() {
		createContentSteps.setDriver(currentPageDriver);
	    createContentSteps.selectStoryLayoutVideoEnterTitleAndContinueToTextView();
	}

	/*Create Stories with Layout Type Gallery*/
	@When("^selects layout type gallery, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button$")
	public void selects_layout_type_gallery_enters_story_title_seo_title_social_title_promo_title_dek_social_dek_promo_dek_and_clicks_on_continue_button() {
		createContentSteps.setDriver(currentPageDriver);
	    createContentSteps.selectStoryLayoutGalleryEnterTitleAndContinueToTextView();
	}

	/*Create Stories with Layout Type Hub*/
	@When("^selects layout type hub, enters story title, seo title, social title, promo title, dek, social dek, promo dek and clicks on continue button$")
	public void selects_layout_type_hub_enters_story_title_seo_title_social_title_promo_title_dek_social_dek_promo_dek_and_clicks_on_continue_button() {
		createContentSteps.setDriver(currentPageDriver);
	    createContentSteps.selectStoryLayoutHubEnterTitleAndContinueToTextView();
	}


	@Given ("^navigates to admin content tree page$")
	public void navigates_to_admin_content_tree_page () {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.goToAdminContentTreePage();
	}

	@Then("^admin content tree is displayed$")
	public void admin_content_tree_is_displayed() {
		navigationSteps.setDriver(currentPageDriver);
		navigationSteps.adminContentTreeIsDisplayed();
	}

	@Given("^\"([^\"]*)\" is at admin content tree page$")
	public void user_is_at_admin_content_tree_page(String user) {
		user_logs_into_application(user);
		navigates_to_admin_content_tree_page();
	}

	@When("clicks expand button of a category")
	public void clicks_expand_button_of_a_category() {
		mediaSteps.setDriver(currentPageDriver);
		mediaSteps.clickExpandButtonAdminContentTree();
	}

	@Then("^tree displays children elements from a category$")
	public void tree_displays_children_elements_from_a_category() {
		mediaSteps.setDriver(currentPageDriver);
		mediaSteps.treeDisplaysChildrenElementsOfACategory();
	}

	@Given("^\"([^\"]*)\" has expanded a category at admin content tree$")
	public void user_is_at_admin_content_tree_pages(String user) {
		user_is_at_admin_content_tree_page(user);
		clicks_expand_button_of_a_category();
	}

	@When("^clicks collapse button of a category$")
	public void clicks_collapse_button_of_a_category() {
		mediaSteps.setDriver(currentPageDriver);
		mediaSteps.clickCollapseButtonAdminContentTree();
	}

	@Then("^tree hides children elements$")
	public void tree_hides_children_elements() {
		mediaSteps.setDriver(currentPageDriver);
		mediaSteps.treeHidesChildrenElementsOfACategory();
	}

	@Then("^access denied message is displayed$")
	public void access_denied_message_is_displayed() {
		mediaSteps.setDriver(currentPageDriver);
		mediaSteps.contentTreePageDisplaysAccessDeniedMessage();
	}

}
