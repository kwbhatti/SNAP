package com.natgeo.aemcore.pages.dialogs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.natgeo.aemcore.pages.BasePage;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.WhenPageOpens;

import static com.natgeo.utilities.WindowsHandlerUtil.switchToWindowsOpenByIndex;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.hamcrest.MatcherAssert.assertThat;

public class CreatePageDlg extends BasePage {

	private final static String DIALOGCSS = "div[id^='cq-createdialog'][style*='visibility: visible'] ";
	private final static String TITLEINPUT = DIALOGCSS + "input[name='title']";
	private final static String NAMEINPUT = DIALOGCSS + "input[name='label']";
	private final static String CREATEBUTTON = DIALOGCSS
			+ "td[class='x-toolbar-cell'] table:not([class*='cq-btn-cancel'])";
	private final static String COREMODULELIST = "div[class*='cq-cmpts-Core'] button";
	private final static String FINALTEMPLATELIST = "//div[contains(@class,'template-title')][last()]"; 

	@FindBy(css = CREATEBUTTON)
	public WebElementFacade createBtn;

	@FindBy(css = TITLEINPUT)
	public WebElementFacade titleTxtBox;

	public CreatePageDlg(WebDriver driver) {
		super(driver);
	}

	@WhenPageOpens
	public void waitUntilTitleAppears() {
		createBtn.waitUntilVisible().waitUntilClickable();
		titleTxtBox.waitUntilEnabled();
	}

	public WebElementFacade titleinput() {
		return findBy(TITLEINPUT);
	}

	public WebElementFacade nameinput() {
		return findBy(NAMEINPUT);
	}

	public WebElementFacade createbutton() {
		return findBy(CREATEBUTTON);
	}
	
	public void choosetemplate(String templatename) {
		
		List<WebElementFacade> templateList = findAll(FINALTEMPLATELIST);	
		
		WebElementFacade foundOne = null;
		
		for (WebElementFacade s : templateList) {
			if(s.getText().contentEquals(templatename)) {
				 foundOne = s;
			}
	    	//System.out.println(s.getText() + '\n');
	    }
		
		//System.out.println("FoundOne" + foundOne);
		foundOne.click();
		
	}

	public void componentcheck() {

		// com.natgeo.utilities.WindowsHandlerUtil.switchToWindowsOpenByIndex(getDriver(),
		// 1);

		switchToWindowsOpenByIndex(getDriver(), 1);
		// switchToNextTab(getDriver(),"AEM Content Finder");

		List<String> expectedmodulenamesImmersiveLead = Arrays.asList("Audio Player", "Call To Action Button",
				"Did You Know", "Image", "Image Group", "Immersive Lead", "Interactive", "Listicle Card",
				"Photo Gallery", "Photo Gallery: Your Shot", "Poll", "Pull Quote", "Quiz",
				"Smart Body: Truncated", "Title & Dek",
				"Taxonomy Card", "Video Playlist (Inline)", "Video: Background Video", "Video: Universal Video Player",
				"YouTube Embed");
	

		findBy(COREMODULELIST).waitUntilVisible();

		// to catch all web elements into list

		List<WebElementFacade> actualList = findAll(COREMODULELIST);
		
		
		//Need to convert list element facade to list String 
		
		List<String> textlist = new ArrayList<String>();
		
	    for (WebElementFacade s : actualList) {
			textlist.add(s.getText());
	    	//System.out.println(s.getText());
	    }
	  
	   //Added for debugging  
	   //System.out.println("Actual List" + textlist);
	   //System.out.println("Expected List" + expectedmodulenames);
	    
		assertThat("Expected Modules Compare", textlist, containsInAnyOrder(expectedmodulenamesImmersiveLead.toArray())); 
		
		
	}

}
