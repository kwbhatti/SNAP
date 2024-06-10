package com.natgeo.aemcore.pages;

import org.junit.Assert;

import java.util.concurrent.TimeUnit;
import java.lang.Thread;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.utilities.TableUtil;
import com.natgeo.utilities.WaitForUtils;
import com.natgeo.utilities.WindowsHandlerUtil;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade; 

public class AuthHomePage extends BasePage {
	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);

	public AuthHomePage(WebDriver driver) {
		super(driver);
	}

	private final static String VIEWPORT_CSS = "div[class$='viewport']";
	private final static String NODE_SELECTOR_XPATH = "//div[contains(@class,'x-tree-node')][descendant::span[text()='$$$']]";
	private final static String GRID_FIRST_ROW_CSS = "div[class*='-row-first']";
	private final static String GRID_LAST_ROW_CSS = "div[class*='-row-last']";
	private final static String LOADING_BLOCK_CSS = ".ext-el-mask"; 

	@FindBy(xpath = "//span[contains(text(),'core')]/..")
	public WebElementFacade corefolder;

	@FindBy(xpath = "//span[contains(text(),'News')]/..")
	public WebElementFacade newsfolder;

	@FindBy(xpath = "//span[contains(text(),'Landing')]/..")
	public WebElementFacade landingpage;

	@FindBy(css = "button[class*='x-btn-text'][class*='cq-siteadmin-create-page-icon']")
	public WebElementFacade newpageBtn;

	@FindBy(xpath = "//div[contains(@class,'x-tree-node')][descendant::span[text()='automation']]")
	public WebElementFacade autofolder;

	@FindBy(className = "x-window x-window-plain x-resizable-pinned")
	public WebElementFacade newcreatewindow;

	@FindBy(xpath = "//div[@id='cq-siteadmin-grid']//div[contains(text(),'Modified')]")
	public WebElementFacade modifieddrop;

	@FindBy(xpath = "//div[contains(@class,'x-grid3-row-last')] and not(contains(@class,'selected'))]/descendant::div[contains(@class,'col-title') and (text()='{0}')]")
	public WebElementFacade gridtitle;
	
	@FindBy(css = "div[class*='-row-first'] table td div[class*='-col-template']")
	public WebElementFacade firsttemplatetype;

	public void verifytitle(String title) {
		if (findAll("//div[@id='cq-siteadmin-grid']//div[contains(text(), '$$$')]".replace("$$$", title)).size() > 0) {
			LOGGER.info("Title Found");
		} else {
			try {
				throw new Exception("Title Not Found");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void sortmodifiedheader(String sortdir) {

		while (!findBy("//div[@id='cq-siteadmin-grid']//div[contains(text(),'Modified')]/..").getAttribute("class")
				.contains("sort-desc")) {
			WaitForUtils.waitForAllAjaxCalls(this, 30);
			waitForLoadingFacadesToDisappear();
			findBy("//div[@id='cq-siteadmin-grid']//div[contains(text(),'Modified')]").click();
			WaitForUtils.waitForAllAjaxCalls(this, 30);
			
		}

	}
	
	public void checktemplateexists(String templatetype) {
      
	  sortmodifiedheader("");
	  firsttemplatetype.waitUntilVisible();	
	  
	  String templatetext = firsttemplatetype.getText();
	  Assert.assertEquals(templatetext, templatetype);
	   		 
	}
	
	 
	public void clickNewPageBtn() {
		newpageBtn.click();
		waitFor(500).milliseconds();
		WaitForUtils.waitForAllAjaxCalls(this, 60);
	}

	/**
	 * Awaits for a list of loading blocks to disappear in order to perform actions
	 * on web page elements
	 */
	public void waitForLoadingFacadesToDisappear() {
		this.waitForCondition().until(ExpectedConditions
				.invisibilityOfAllElements(getDriver().findElements(By.cssSelector(LOADING_BLOCK_CSS))));
	}

	public void openNewTab() {
		WebElement element2 = getDriver().findElement(By.cssSelector("[id='ext-comp-1069'] a"));
		WindowsHandlerUtil.openInNewTab(getDriver(), element2);
	}

	public void selectTreePath(String path) {
		String seperator = "@";

		String[] nodes = path.split(seperator);
		String scrollTxtJS = "var elem = $(\"#XXX\"); elem[0].scrollIntoView(true);";

		for (String node : nodes) {
			// Since the last thing to load on the page is the viewport
			// verify that it is present and enabled.
			findBy(VIEWPORT_CSS).waitUntilPresent().waitUntilEnabled();

			LOGGER.info("xpath-->" + NODE_SELECTOR_XPATH.replace("$$$", node.trim()));
			WebElementFacade nodeElement = findBy(NODE_SELECTOR_XPATH.replace("$$$", node.trim()));

			// Click on the node if it is not expanded
			if (!nodeElement.getAttribute("class").contains("x-tree-node-expanded")) {
				WaitForUtils.waitForAllAjaxCalls(this, 60);

				// Javascript to move element into view
				waitFor(100).milliseconds();
				LOGGER.info(scrollTxtJS.replace("XXX", nodeElement.getAttribute("id")));

				evaluateJavascript(scrollTxtJS.replace("XXX", nodeElement.getAttribute("id")));
				nodeElement.withTimeoutOf(30, TimeUnit.SECONDS).waitUntilPresent().waitUntilClickable();
				waitForLoadingFacadesToDisappear();
				nodeElement.click();
				// Needed to give a little buffer time to make it more reliable

				WaitForUtils.waitForAllAjaxCalls(this, 60);
			}
		}
		// Wait for the final click
		findBy(VIEWPORT_CSS).waitUntilPresent().waitUntilEnabled();
	}

	public void doubleClickFirstrow() {

		doubleClick((WebElement) findBy(GRID_FIRST_ROW_CSS));

	}

	public void doubleClickLastrow() {

		doubleClick((WebElement) findBy(GRID_LAST_ROW_CSS));

	}

}