package com.natgeo.aemcore.pages;

import static com.natgeo.utilities.AdvertisementsUtil.verify_advertisement_count;
import static com.natgeo.utilities.AdvertisementsUtil.verify_advertisement_present;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.natgeo.common.NatGeoBasePage;

import net.serenitybdd.core.pages.WebElementFacade;


public class BasePage extends NatGeoBasePage {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	public void open_with_ads(String url) {	
		String namedUrl = url.trim().replace(" ", ".");
		open(namedUrl, withParameters("?monetate_off&dev&siteSection=video.nationalgeographic.com/module"));
	}
	
	public void open_with_no_ads(String namedUrl) {
		open(namedUrl, withParameters("?disableAds=true"));
		waitFor(2).seconds();
	}
	
	public Boolean checkVisible(WebElementFacade obj){
		return obj.isCurrentlyVisible();
	}

	public void setfocus(WebElementFacade obj){
		obj.sendKeys("");
	}

	public void verify_the_number_of_ads_on_the_page(Integer adCount) {
		verify_advertisement_count(this, adCount);
	}
	
	public void verify_that_ads_are_present() {
		verify_advertisement_present(this);
	}
	
	public void scroll_down(int repeat) {
		JavascriptExecutor jse = (JavascriptExecutor)getDriver();
		jse.executeScript("window.scrollBy(0, " + repeat * 500 + ")", "");
	}
}
