package com.natgeo.cup.pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CupReferenceContentDetails extends CupBasePage {

	public CupReferenceContentDetails(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a[href='/']")
	private WebElementFacade homeButton;

	@FindBy(tagName = "img")
	private WebElementFacade editorsChoiceImage;

	@FindBy(className = "tip-detail-title")
	private WebElementFacade tipTitle;
	
	@FindBy(css = "div[class$='detail-title']")
	private WebElementFacade generalTitle;

	@FindBy(className = "tip-detail-category")
	private WebElementFacade tipCategory;

	@FindBy(className = "tip-detail-body")
	private WebElementFacade tipDescription;

	@FindBy(className = "story-detail-title")
	private WebElementFacade storyTitle;

	@FindBy(className = "story-detail-category")
	private WebElementFacade storyCategory;

	@FindBy(className = "story-detail-body")
	private WebElementFacade storyDescription;

	@FindBy(className = "photo-detail-title")
	private WebElementFacade photoTitle;

	@FindBy(className = "photo-detail-category")
	private WebElementFacade photoCategory;

	@FindBy(className = "photo-detail-caption")
	private WebElementFacade photoCaption;

	@FindBy(css = "img[src*='heart']")
	private WebElementFacade likeIcon;
	
	@FindBy(css = "img[src$='heart-border.svg']")
	private WebElementFacade unlikedHeartIcon;
	
	@FindBy(css = "img[src$='heart.svg']")
	private WebElementFacade likedHeartIcon;

	@FindBy(css = "img[src*='heart'] + span")
	private WebElementFacade likeCounter;

	@FindBy(className = "author-name")
	private WebElementFacade contentUserName;

	@FindBy(css = ".follow-btn")
	private WebElementFacade followButton;

	@FindBy(css = ".flag.icon")
	private WebElementFacade flagContent;

	@FindBy(css = ".pencil.icon")
	private WebElementFacade editContent;

	@FindBy(css = ".trash.icon")
	private WebElementFacade deleteContent;

	@FindBy(css = ".actions button:nth-child(2)")
	private WebElementFacade confirmDelete_cancel;
	
	@FindBy(className = "comments-detail-count-number")
	private WebElementFacade commentsCounter;

	@FindBy(css = ".actions button:nth-child(1)")
	private WebElementFacade confirmDelete_yes;

	@FindBy(css = "textarea")
	private WebElementFacade commentTextArea;

	@FindBy(css = ".yellow")
	private WebElementFacade shareComment_button;

	@FindBy(css = ".comment")
	private List<WebElementFacade> allCommentsList;

	private boolean flag = false;

	String titleText;
	String categoryText;
	String descriptionText;

	int commentAdded;
	int commentsSize;
	
	public boolean validateCommentCreated(String comment) {
		try {
			Thread.sleep(2000);
			String actualComment;
			
			for (WebElementFacade commentElement : allCommentsList) {
				actualComment = commentElement.getText();
				
				if (comment.equals(actualComment)) {
					flag = true;
				}
			}
			
			return flag;
		} catch (Exception e) {
			Assert.assertTrue("Unable find the Comment in the list of Comments: ", false);
			return flag;
		}
	}
	
	public void likedIcon() {
		try {
			waitForVisibleAndClick(likedHeartIcon);
			waitForVisibleAndClick(unlikedHeartIcon);
			likedHeartIcon.waitUntilPresent();
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Unlike and Like again: ", false);
		}
	}
	
	public boolean clickOnLike() {
		try {
			likeIcon.waitUntilClickable();
			if (likedHeartIcon.isPresent()) {
				likedIcon();
				flag = true;
			} else {
				waitForVisibleAndClick(unlikedHeartIcon);
				likedHeartIcon.waitUntilPresent();
				flag = true;
			}
			return flag;
		} catch (Exception e) {
			Assert.assertTrue("Unable to click on Like: ", false);
			return flag;
		}
	}
	
	public boolean checkForTipDetailsToMatch(String title, String category, String description) {
		try {

			tipTitle.waitUntilVisible();
			titleText = tipTitle.getText();
			categoryText = tipCategory.getText();
			descriptionText = tipDescription.getText();

			if (title.equals(titleText) && category.equalsIgnoreCase(categoryText)
					&& description.equals(descriptionText)) {
				flag = true;
			}

			return flag;
		} catch (Exception e) {
			Assert.assertTrue("Some Fields does not match with the information you provided: ", false);
			return flag;
		}
	}
	
	public boolean checkForStoryDetailsToMatch(String title, String category, String description) {
		try {

			storyTitle.waitUntilVisible();
			titleText = storyTitle.getText();
			categoryText = storyCategory.getText();
			descriptionText = storyDescription.getText();

			if (title.equals(titleText) && category.equalsIgnoreCase(categoryText)
					&& description.equals(descriptionText)) {
				flag = true;
			}

			return flag;
		} catch (Exception e) {
			Assert.assertTrue("Some Fields does not match with the information you provided: ", false);
			return flag;
		}
	}
	
	public boolean checkForPhotoDetailsToMatch(String title, String category, String caption) {
		try {

			photoTitle.waitUntilVisible();
			titleText = photoTitle.getText();
			categoryText = photoCategory.getText();
			descriptionText = photoCaption.getText();

			if (title.equals(titleText) && category.equalsIgnoreCase(categoryText)
					&& caption.equals(descriptionText)) {
				flag = true;
			}

			return flag;
		} catch (Exception e) {
			Assert.assertTrue("Some Fields does not match with the information you provided: ", false);
			return flag;
		}
	}

	public boolean validateContentUpdates(String title, String category, String description) {
		try {
			editorsChoiceImage.waitUntilVisible();

			if (storyTitle.isPresent()) {
				titleText = storyTitle.getText();
				categoryText = storyCategory.getText();
				descriptionText = storyDescription.getText();

				if (title.equals(titleText) && category.equalsIgnoreCase(categoryText)
						&& description.equals(descriptionText)) {
					flag = true;
				}

			} else if (photoTitle.isPresent()) {
				titleText = photoTitle.getText();
				categoryText = photoCategory.getText();
				descriptionText = photoCaption.getText();

				if (title.equalsIgnoreCase(titleText) && category.equalsIgnoreCase(categoryText)
						&& description.equalsIgnoreCase(descriptionText)) {
					flag = true;
				}

			} else if (tipTitle.isPresent()) {
				titleText = tipTitle.getText();
				categoryText = tipCategory.getText();
				descriptionText = tipDescription.getText();

				if (title.equalsIgnoreCase(titleText) && category.equalsIgnoreCase(categoryText)
						&& description.equalsIgnoreCase(descriptionText)) {
					flag = true;
				}
			}
			return flag;

		} catch (Exception e) {
			Assert.assertTrue("One or more fields doesn't match with the changes you made: ", false);
			return flag;
		}
	}

	public void clickOnDeleteContent() {
		try {
			waitForVisibleAndClick(deleteContent);
			waitForVisibleAndClick(confirmDelete_yes);
		} catch (Exception e) {
			Assert.assertTrue("Unable to Delete the Content: ", false);
		}
	}

	public void clickOnUpdateContent() {
		try {
			waitForVisibleAndClick(editContent);
		} catch (Exception e) {
			Assert.assertTrue("Unable to Update the Content: ", false);
		}
	}

	public void typeComment(String comment) {
		try {
			typeInElement(commentTextArea, comment);
			waitForVisibleAndClick(shareComment_button);
		} catch (Exception e) {
			Assert.assertTrue("Unable to write a Comment: ", false);
		}
	}

	public boolean commentAdded() {
		try {
			commentAdded = allCommentsList.size();

			if (commentAdded == commentsSize + 1) {
				flag = true;
			}
			return flag;

		} catch (Exception e) {
			Assert.assertTrue("The Comment was Not Added: ", false);
			return flag;
		}
	}

}
