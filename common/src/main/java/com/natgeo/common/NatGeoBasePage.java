package com.natgeo.common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.Point;

import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;

import org.hamcrest.core.AnyOf;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.applitools.NatGeoApplitools;
import com.natgeo.constants.ScreenSize;
import com.natgeo.utilities.LoaderUtil;
import com.natgeo.utilities.NotificationsUtil;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class NatGeoBasePage extends PageObject {
	private static final Logger LOGGER = LoggerFactory.getLogger(NatGeoBasePage.class);

	protected NatGeoApplitools applitools;
	public NotificationsUtil notifications;

	public NatGeoBasePage(WebDriver driver) {
		super(driver);
	}

	public void maximizeBrowser() {
		if (LoaderUtil.getInstance().driverType.equals("CHROME")) {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			Dimension screenResolution = new Dimension((int) toolkit.getScreenSize().getWidth(),
					(int) toolkit.getScreenSize().getHeight());

			Point startingpoint = new Point(0, 0);
			getDriver().manage().window().setPosition(startingpoint);

			getDriver().manage().window().setSize(screenResolution);
		} else {
			getDriver().manage().window().maximize();
		}
	}

	public void resizeBrowser(String screenName) {
		Rectangle screenRec = ScreenSize.getRec(screenName);

		LOGGER.info("width-->" + screenRec.width + "        height-->" + screenRec.height);
		resizeBrowser(screenRec.width, screenRec.height);
	}

	public void resizeBrowser(int x, int d) {
		Dimension screenResolution = new Dimension(x, d);

		Point startingpoint = new Point(0, 0);
		getDriver().manage().window().setPosition(startingpoint);

		getDriver().manage().window().setSize(screenResolution);
	}

	/*
	 ************************************************************************************
	 ************************* Applitools Functions ***********************************
	 ************************************************************************************
	 */

	public void screenCaptureAndCompair(String appName, String testName) {
		NatGeoApplitools applitools = new NatGeoApplitools();
		applitools.checkWindow((WebDriverFacade) this.getDriver(), appName, testName);
	}

	// Takes a snapshot for applitools
	public void checkWindowApplitools(String appName, String testName) {
		applitools = new NatGeoApplitools();
		applitools.checkWindow((WebDriverFacade) this.getDriver(), appName, testName);
	}

	public void checkWindowResults() {
		LoaderUtil.getInstance().setSauceLabsStatus("FAILED");
		String result = applitools.stopCheckWindow();
		LoaderUtil.getInstance().setSauceLabsStatus(result);
		assertThat("Applitools Visual test", result, AnyOf.anyOf(equalTo("PASSED"), equalTo("NEW")));
	}

	public void abortApplitoolsTest() {
		if (applitools != null) {
			try {
				applitools.abortTest();
			} catch (Exception e) {
				// Do Nothing
			}
		}
	}
	/*
	 ************************************************************************************
	 ************************* Screen Message Functions ********************************
	 ************************************************************************************
	 */

	// Notification Function Displays growl like messages on the screen
	public void msgSuccess(String msg) {
		NotificationsUtil.successMsg(this, msg);
	}

	public void msgError(String msg) {
		NotificationsUtil.errorMsg(this, msg);
	}

	public void msgWarning(String msg) {
		NotificationsUtil.warningMsg(this, msg);
	}

	public void msgInfo(String msg) {
		NotificationsUtil.infoMsg(this, msg);
	}

	public void switch_to_next_tab(Integer def_wait) {

		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());

		// Switch to new window
		getDriver().switchTo().window(tabs.get(1));

		waitFor(def_wait).seconds();

		// getDriver().close();//do some action in new window(2nd tab)
		// Switch to main/parent window
		// getDriver().switchTo().window(tabs.get(0));

	}

	public void doubleClick(WebElement element) {

		Actions action = new Actions(getDriver());
	
		// Double click
		action.doubleClick(element).perform();

	}

}