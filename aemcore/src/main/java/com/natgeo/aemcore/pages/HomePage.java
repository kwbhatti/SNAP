package com.natgeo.aemcore.pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;


@NamedUrls({
	// Adventure pages
	@NamedUrl(name = "adventure.homepage", url = "{/adventure/{1}"),
	@NamedUrl(name = "adventure", url = "/adventure/index/{1}"),
	@NamedUrl(name = "adventure.page", url = "/adventure/activities/hiking-and-backpacking/grand-canyon-thru-hike/{1}"),
	@NamedUrl(name = "adventure.photo.gallery.template.page", url = "/adventure/features/everest/1924-everest-gear/{1}"),
	
	// Animal pages
	@NamedUrl(name = "arctic fox profile", url = "/animals/mammals/a/arctic-fox/"),

	// Magazine pages
	@NamedUrl(name = "magazine.home.page", url = "/magazine/{1}"),
	@NamedUrl(name = "interactive.page.with.sticky.nav", url = "/magazine/2016/06/shark-species-family-tree-ocean-ecosystem-predator/islands-nature-reserve-national-parks/{1}"),
	@NamedUrl(name = "magazine.food.waste", url = "/magazine/2016/03/global-food-waste-statistics/{1}"),
	@NamedUrl(name = "image.components.page", url = "/magazine/automation/image-component/image-all-fields-original/{1}"),
	@NamedUrl(name = "image.components.override.page", url = "/magazine/automation/image-component/mage-all-fields-override/{1}"),
	@NamedUrl(name = "image.group.all.fields.page", url = "/magazine/automation/image-group-component/image-group-all-fields/{1}"),
	@NamedUrl(name = "image.group.with.group.fields.page", url = "/magazine/automation/image-group-component/image-group-with-group-fields/{1}"),
	@NamedUrl(name = "magazine.article.with.photo.gallery.page", url = "/magazine/2015/01/bald-eagles/{1}"),
	@NamedUrl(name = "power.of.parks", url = "/power-of-parks/{1}"),

	// Travel pages
	@NamedUrl(name = "travel.page", url = "/travel/{1}"),
	@NamedUrl(name = "travel.components.page", url = "/travel/road-trips/united-states/washington-national-parks/{1}"),
	@NamedUrl(name = "travel.top.ten", url = "/travel/destinations/europe/ireland/top-ten/things-to-do-in-ireland-and-northern-ireland/{1}"),
	@NamedUrl(name = "travel.multi-page.story", url = "/travel/best-trips/best-spring-trips-2016/{1}"),
	@NamedUrl(name = "travel.sibling.carousel", url = "/travel/best-trips/best-spring-trips-2016/sicily-italy/{1}"),
	@NamedUrl(name = "want.power", url = "/people-and-culture/food/the-plate/2016/06/turning-wasted-tomatoes-and-potatoes-into-fuel/{1}"),
	@NamedUrl(name = "the.plate", url = "/people-and-culture/food/the-plate/"),

	// Photography pages
	@NamedUrl(name = "photography.home.page", url = "/photography/{1}"),
	@NamedUrl(name = "yourshot.gallery.page", url = "/photography/photos-your-shot-daily-dozen/{1}"),
	@NamedUrl(name = "photo.of.the.day", url = "/photography/photo-of-the-day/{1}"),
	@NamedUrl(name = "photography.image.groups", url = "/photography/proof/2016/06/magda-biernat-adrift/{1}"),
	@NamedUrl(name = "extreme.photo.of.the.week", url = ""),

	// Misc pages
	@NamedUrl(name = "latest.stories.page", url = "/latest-stories/{1}"),
	@NamedUrl(name = "animals.page", url = "/animals/{1}"),
	@NamedUrl(name = "arctic.fox.profile", url = "/animals/mammals/a/arctic-fox/{1}"),
	@NamedUrl(name = "narwhal.profile", url = "/animals/mammals/n/narwhal/{1}"),
	@NamedUrl(name = "african.elephant.profile", url = "/animals/mammals/a/african-elephant/{1}"),
	@NamedUrl(name = "environment.page", url = "/environment/{1}"), 
	@NamedUrl(name = "home.page", url = "/{1}"),
	@NamedUrl(name = "science.page", url = "/science/{1}"),
	@NamedUrl(name = "culturepage", url = "/people-and-culture/{1}")
})
public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
        super(driver);
    }
	
	public void verify_component(String component) {
		
		HashMap<String, String> component_map = new HashMap<String, String>();
		component_map.put("did you know", ".did-you-know");
		
		assertThat("The component was not visible", getDriver().findElement(By.cssSelector(component_map.get(component))).isDisplayed(), equalTo(true));
	}
	
	public void verify_dyk_fact() {
		WebElement fact = getDriver().findElement(By.cssSelector(".swiper-slide-active > .fact-container"));
		
		assertThat("No DYK fact text found.", fact.getText().length(), greaterThan(0));
	}

	public void verify_pagination(int count) {
		WebElement pagination = getDriver().findElement(By.cssSelector(".mt_pagination__list-item--active"));
		
		assertThat("Pagination count was not correct.", pagination.getAttribute("data-index"), equalTo(Integer.toString(count - 1)));
	}
	
	public void scroll_pagination() {
		WebElement next_button = getDriver().findElement(By.cssSelector(".did-you-know__container > div:nth-child(4) > .nav-btns.next"));
		
		new Actions(getDriver()).moveToElement(next_button).click().perform();
	}
	
	public void verify_twitter_icon() {
		WebElement twitter = getDriver().findElement(By.cssSelector(".swiper-slide-active > .social > .sharebutton__modal--button-container"));
		
		assertThat("Twitter icon was not displayed", twitter.isDisplayed(), equalTo(true));
	}
}
