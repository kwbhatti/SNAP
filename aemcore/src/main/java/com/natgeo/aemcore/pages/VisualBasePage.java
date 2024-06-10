package com.natgeo.aemcore.pages;

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
	@NamedUrl(name = "AdventureArticleImageLead", url = "/adventure/features/environment/wild-horses-part-three/?disableAds=true"),
	@NamedUrl(name = "AdventureBackgroundImage", url = "/adventure/index/?disableAds=true&monetate_off"),
	@NamedUrl(name = "AdventureGlobalFooter", url = "/adventure/activities/hiking-and-backpacking/grand-canyon-thru-hike/?disableAds=true&monetate_off"),
	@NamedUrl(name = "AdventureTitleDeck", url = "/adventure/adventurers-of-the-year/?disableAds=true&monetate_off"),
	@NamedUrl(name = "AnimalProfile", url = "/animals/mammals/g/gray-wolf/?disableAds=true"),
	@NamedUrl(name = "ArticFoxAnimalProfile", url = "/animals/mammals/a/arctic-fox/?disableAds=true&monetate_off"),
	@NamedUrl(name = "NarwhalAnimalProfile", url = "/animals/mammals/n/narwhal/?disableAds=true&monetate_off"),
	@NamedUrl(name = "AfricanElephantAnimalProfile", url = "/animals/mammals/a/african-elephant/?disableAds=true&monetate_off"),
	@NamedUrl(name = "AnimalHub", url = "/animals/summer-of-sharks/?disableAds=true"),
	@NamedUrl(name = "ArchAndHistoryArticleImageLead", url = "/archaeology-and-history/magazine/2016/07-08/profile-adam-weishaupt-illuminati-secret-society/?disableAds=true"),
	@NamedUrl(name = "BooksArticleImageLead", url = "/books/features/show-dates-for-nat-geo-books/?disableAds=true"),
	@NamedUrl(name = "ContributorDetailPage", url = "/contributors/p/laura-parker/?disableAds=true"),
	@NamedUrl(name = "DotComBasePage", url = "/?disableAds=true"),
	@NamedUrl(name = "DotComPromoFeed", url = "/latest-stories/?disableAds=true&monetate_off"),
	@NamedUrl(name = "DotComScience", url = "/science/?monetate_off&dev&siteSection=video.nationalgeographic.com/module"),
	@NamedUrl(name = "DotComTravel", url = "/travel/?monetate_off&dev&siteSection=video.nationalgeographic.com/module"),
	@NamedUrl(name = "DotComEnvironment", url = "/environment/?monetate_off&dev&siteSection=video.nationalgeographic.com/module"),
	@NamedUrl(name = "DotComCulture", url = "/people-and-culture/?monetate_off&dev&siteSection=video.nationalgeographic.com/module"),
	@NamedUrl(name = "EnvAndEnergyArticleImageLead", url = "/environment/urban-expeditions/austin/austin-green-buildings-fight-urban-sprawl/?disableAds=true"),
	@NamedUrl(name = "MagazineArticleImageLead", url = "/magazine/2016/12/orangutans-behaviors-borneo-sumatra/?disableAds=true"),
	@NamedUrl(name = "MagazineMultipleComponents", url = "/magazine/2016/03/seychelles-islands-nature-reserve-national-parks/?disableAds=true&monetate_off"),
	@NamedUrl(name = "MagazineImmersiveLead", url = "/magazine/2018/01/kabul-afghanistan-suburb-modern/?disableAds=true&monetate_off"),
	@NamedUrl(name = "MagazineInteractiveComponent", url = "/magazine/2016/03/global-food-waste-statistics/?disableAds=true&monetate_off"),
	@NamedUrl(name = "PeopleAndCultureArticleVideoLead", url = "/people-and-culture/food/the-plate/2016/08/imagining-the-banana-of-the-future/?disableAds=true"),
	@NamedUrl(name = "PeopleAndCultureContributorCard", url = "/people-and-culture/food/the-plate/2016/06/turning-wasted-tomatoes-and-potatoes-into-fuel/?disableAds=true&monetate_off"),
	@NamedUrl(name = "PhotographyArticleImageLead", url = "/photography/proof/2016/05/omar-diop-refugee-mbororo-portraits/?disableAds=true"),
	@NamedUrl(name = "PhotographyInfiniteGalleryItem", url = "/photography/photo-of-the-day/2017/01/leopard-eye-quebec/?disableAds=true"),
	@NamedUrl(name = "PhotographyHomepageHub", url = "/photography/?google_nofetch&disableAds=true"),
	@NamedUrl(name = "PhotographyImageGroup", url = "/magazine/automation/image-group-component/image-group-all-fields/?disableAds=true&monetate_off"),
	@NamedUrl(name = "ScienceAndSpacePhotoGallery", url = "/science/photos/climate/?disableAds=true"),
	@NamedUrl(name = "ScienceAndSpacePresentationMode", url = "/science/photos/climate/#/833.jpg?disableAds=true"),
	@NamedUrl(name = "TravelMultiPageStory", url = "/travel/travel-interests/active-and-adventure/pictures-national-parks-road-trip/?disableAds=true"),
	@NamedUrl(name = "TravelArticleImageLead1", url = "/travel/best-maya-books/?disableAds=true"),
	@NamedUrl(name = "TravelArticleImageLead2", url = "/travel/destinations/asia/jordan/historic-sites-archaeology-jordan/?disableAds=true"),
	@NamedUrl(name = "TravelDestinationHub", url = "/travel/destinations/north-america/united-states/new-hampshire/?google_nofetch&disableAds=true"),
	@NamedUrl(name = "TravelAddThisListicle", url = "/travel/destinations/europe/ireland/top-ten/things-to-do-in-ireland-and-northern-ireland/?disableAds=true&monetate_off"),
	@NamedUrl(name = "TravelMultipleComponents", url = "/travel/road-trips/united-states/washington-national-parks/?disableAds=true&monetate_off"),
	@NamedUrl(name = "NewsArticle", url = "/2015/05/150501-how-old-microsoft-face-aging-software-science/"),
	@NamedUrl(name = "NewsHome", url = "/"),
	@NamedUrl(name = "NewsLegacyArticle", url = "/news/2015/01/140122-human-tools-hands-ancient-science/"),
	@NamedUrl(name = "NewsLegacyGallery", url = "/news/2015/01/pictures/150102-saturn-sun-aurora-science-galaxies-space/"),
	@NamedUrl(name = "NewsGallery", url = "/2015/05/150501-calbuco-solar-flare-volcano-best-space-pictures-science/")
})
public class VisualBasePage extends NatGeoBasePage{
	
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
