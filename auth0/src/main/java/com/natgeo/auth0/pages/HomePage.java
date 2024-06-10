package com.natgeo.auth0.pages;

import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;

@NamedUrls({
		// Profiles service admin pages
		@NamedUrl(name = "profiles.services.home.page", url = "/admin/{1}"), 
		@NamedUrl(name = "profiles.services.login.page", url = "/admin/login/{1}"),

		// Profiles service - Profile module pages
		@NamedUrl(name = "profiles.module", url = "/admin/profiles/{1}"),
		@NamedUrl(name = "profiles.list", url = "/admin/profiles/profile/{1}"),
		@NamedUrl(name = "profiles.profile.change", url = "/admin/profiles/profile/<id>/change/{1}"),

		// Profiles service - Subscriptions module pages
		@NamedUrl(name = "subscriptions.module", url = "/admin/subscriptions/{1}"),
		@NamedUrl(name = "subscriptions.list", url = "/admin/subscriptions/subscription/{1}"),
		@NamedUrl(name = "subscriptions.subscription.change", url = "/admin/subscriptions/subscription/<id>/change/{1}")

})
public class HomePage extends ProfilesServiceBasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	public void openPage(String url) {
		String namedUrl = url.trim().replace(" ", ".");
		open(namedUrl, withParameters(""));
	}
	
	

}
