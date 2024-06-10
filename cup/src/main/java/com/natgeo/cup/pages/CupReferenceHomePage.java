package com.natgeo.cup.pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferenceHomePage extends CupBasePage {

	CupReferenceViewAllTipsPage allTips;

	public CupReferenceHomePage(WebDriver driver) {
		super(driver);
	}
	
	HomePageStoryCard storyCard = new HomePageStoryCard(getDriver(), 1);
	HomePagePhotoCard photoCard = new HomePagePhotoCard(getDriver(), 1);
	HomePageTipCard tipCard = new HomePageTipCard(getDriver(), 1);

	@FindBy(css = ".item:nth-of-type(1)")
	private WebElementFacade homeTab;

	@FindBy(css = ".item:nth-of-type(2)")
	private WebElementFacade followingTab;

	@FindBy(css = ".item:nth-of-type(3)")
	private WebElementFacade myContentTab;

	@FindBy(id = "global-navbar")
	private WebElementFacade navBar;
	
	@FindBy(css = ".ui.active .home-container:nth-of-type(1) > .content-header")
	private WebElementFacade trendingContentTitle;

	@FindBy(css = "a[href*='tip']")
	private WebElementFacade uploadTip;

	@FindBy(css = "a[href*='story']")
	private WebElementFacade uploadStory;

	@FindBy(css = "a[href*='photo']")
	private WebElementFacade uploadPhoto;

	@FindBy(css = ".ui.active .home-container:nth-of-type(1) .content-subheader")
	private WebElementFacade viewAllTrends;

	@FindBy(css = ".ui.active .secondary-container .content-subheader")
	private WebElementFacade viewGallery;

	@FindBy(css = ".ui.active .home-container:nth-of-type(3) .content-subheader")
	private WebElementFacade viewAllTips;

	@FindBy(css = ".portrait")
	private List<WebElementFacade> allUgcCards;
	
	@FindBy(css = ".story-card:nth-of-type(1) .read-more > i")
	private WebElementFacade storyRead;
	
	WebElementFacade userNameIdentifier;
	WebElementFacade followBtn;
	
	public String userName;
	private boolean flag = false;

	public void clickOnReadDetails() {
		try {
			Thread.sleep(8000);
//			storyCard.clickReadButton();
			waitForVisibleAndClick(storyRead);
			Thread.sleep(3000);
		} catch (Exception e) {		
			Assert.assertTrue("Unable to click on the READ button: ", false);
		}
	}
	
	public boolean returnToHomePage() {
		try {
			Thread.sleep(8000);
			trendingContentTitle.waitUntilVisible();
			if (trendingContentTitle.isCurrentlyVisible()) {				
				flag = true;				
			}			
			return flag;
			
		} catch (Exception e) {			
			Assert.assertTrue("Unable to see the Home Page: ", false);
			return flag;
		}
	}
	
	public void clickOnMyContent() {
		try {			
			waitForVisibleAndClick(myContentTab);
			Thread.sleep(5000);
		} catch (Exception e) {			
			Assert.assertTrue("Unable to click on My Content: ", false);
		}
	}
	
	public void findFollowButtonAndClick() {
		try {
			storyCard.waitUntilEnabled();
			
			for(WebElementFacade element : allUgcCards) {
				followBtn = element.findElement(By.cssSelector(".follow-btn"));
				userNameIdentifier = element.findElement(By.cssSelector("a"));
				
				if (followBtn.isVisible()) {
					userName = userNameIdentifier.getText();
					waitForVisibleAndClick(followBtn);
					break;
				}
			}
		} catch (Exception e) {
			Assert.assertTrue("Unable to find any FOLLOW button: ", false);
		}
	}

	public void navBarReady() {
		try {
			navBar.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to see the Nav Bar: ", false);
		}
	}

	public void clickOnViewAllTips() {
		try {
			storyCard.waitUntilEnabled();
			waitForVisibleAndClick(viewAllTips);
			allTips.firstTip.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on View All Tips: ", false);
		}
	}

	public void navigateToReferenceHomePage() {
		try {
			openUrl("https://community-dev.nationalgeographic.com/");
			Thread.sleep(8000);
			navBar.waitUntilVisible();
		} catch (Exception e) {
			Assert.assertTrue("Unable to open the Reference Site Home Page: ", false);
		}	
	}

	public void uploadTip() {
		try {
			waitForVisibleAndClick(uploadTip);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Upload a Tip: ", false);
		}
	}

	public void uploadPhoto() {
		try {
			waitForVisibleAndClick(uploadPhoto);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Upload a Photo: ", false);
		}
	}

	public void uploadStory() {
		try {
			waitForVisibleAndClick(uploadStory);
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Upload a Story: ", false);
		}
	}

}