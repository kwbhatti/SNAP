package com.natgeo.applitools;

import java.awt.Rectangle;
import java.net.URI;
import java.util.Calendar;
import java.util.EmptyStackException;

import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.StdoutLogHandler;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.selenium.StitchMode;
import com.natgeo.constants.ScreenSize;
import com.natgeo.utilities.LoaderUtil;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.WebDriverFacade;

public class NatGeoApplitools {
	private static final Logger LOGGER = LoggerFactory.getLogger(NatGeoApplitools.class);
	private Eyes eyes;

	public void checkWindow(WebDriverFacade driver, String applicationName, String testName) {
		String errMsg = "";
		Dimension computerScreenSize = driver.manage().window().getSize();
		Rectangle screenRec = ScreenSize.getRec(LoaderUtil.getInstance().applitoolsScreenSize);

		// Check Screen Sizes
		if (screenRec.width > computerScreenSize.width) {
			errMsg = errMsg + "# Request browser width is greater that current screen width\n";
		}
		if (screenRec.height > computerScreenSize.height) {
			errMsg = errMsg + "# Request browser height is greater that current screen height\n";
		}
		if (LoaderUtil.getInstance().driverType.contains("CHROME") && screenRec.width < 400) {
			errMsg = errMsg + "# The requested Chrome width must be 400 or greater\n";
		}
		if (LoaderUtil.getInstance().driverType.contains("CHROME") && screenRec.height < 198) {
			errMsg = errMsg + "# The requested Chrome height must be 198 or greater\n";
		}

		// Check applitools properties
		if (LoaderUtil.getInstance().applitoolsKey.length() == 0) {
			errMsg = errMsg + "# snap.applitools.key(" + LoaderUtil.getInstance().applitoolsKey
					+ ") property was not found\n";
		}
		if (LoaderUtil.getInstance().applitoolsURL.length() == 0) {
			errMsg = errMsg + "# snap.applitools.url(" + LoaderUtil.getInstance().applitoolsURL
					+ ") property was not found\n";
		}

		if (errMsg.length() > 0) {
			LOGGER.error("##############################################################");
			LOGGER.error("# Applitools Proplem(s)");
			LOGGER.error(errMsg);
			LOGGER.error("##############################################################");
			LOGGER.error("#   Host Screen Width        -->" + computerScreenSize.width);
			LOGGER.error("#   Host Screen Height       -->" + computerScreenSize.height);
			LOGGER.error("#   Requested Browser Width  -->" + screenRec.width);
			LOGGER.error("#   Requested Browser Height -->" + screenRec.height);
			LOGGER.error("##############################################################");
			throw new EmptyStackException();
		}

		try {
			eyes = new Eyes(new URI(LoaderUtil.getInstance().applitoolsURL));
			eyes.setApiKey(LoaderUtil.getInstance().applitoolsKey);

			Calendar currentDate = Calendar.getInstance();
			BatchInfo batch = new BatchInfo(LoaderUtil.getInstance().batchId, currentDate);
			batch.setId(LoaderUtil.getInstance().batchId);

			eyes.setBatch(batch);

			// Full page Screenshot Setting
			eyes.setForceFullPageScreenshot(true);
			eyes.setStitchMode(StitchMode.CSS);

			// Hide Scroll bars
			eyes.setHideScrollbars(true);

			// Set different Match Levels
			switch(LoaderUtil.getInstance().applitoolsMatchLevel) {
				case "CONTENT":
					eyes.setMatchLevel(MatchLevel.CONTENT);
					break;
				case "LAYOUT":
					eyes.setMatchLevel(MatchLevel.LAYOUT);
					break;
				case "EXACT":
					eyes.setMatchLevel(MatchLevel.EXACT);
					break;
				case "STRICT":
					eyes.setMatchLevel(MatchLevel.STRICT);
					break;
			}


			// Set Match TimeOut at the test level - TODO Add Link to article
			// eyes.setMatchTimeout(3000); // The default value is 2000 ms

			// Disabling eyes
			// eyes.setIsDisabled(false);

			// eyes.setSaveFailedTests(true);

			// Add Custom Properties
			// eyes.addProperty("MyProperty", testName.getMethodName());
			// eyes.clearProperties();

			// How to ignore cursor diff
			// eyes.setIgnoreCaret(true);

			// Enabling logs to console
			eyes.setLogHandler(new StdoutLogHandler(true));
			// eyes.setLogHandler(new FileLogger("applitools/file.log", true, true));

			// Enabling logs to File
			// eyes.setLogHandler(new FileLogger("path/to/file.log", true, true));

			// Save Debug Screenshots - available in latest versions
			// eyes.setDebugScreenshotsPath("applitools");
			eyes.setSaveDebugScreenshots(false);

			// eyes.setDebugScreenshotsPath(); // By Default the path is the working
			// directory

			LOGGER.info("Width-->" + screenRec.width + "      height-->" + screenRec.height);
			eyes.open(driver.getProxiedDriver(), applicationName, testName,
					new RectangleSize(screenRec.width, screenRec.height));
			// eyes.open(driver.getProxiedDriver(), applicationName, testName, new
			// RectangleSize(400, 200));
			eyes.checkWindow(testName);
		} catch (Exception e) {
			LOGGER.error(e.toString());
		}
	}

	public String stopCheckWindow() {
		String rtnVal = "FAILED";

		try {
			TestResults result = eyes.close(false);

			if (result.isPassed()) {
				rtnVal = "PASSED";
				LOGGER.info("Visual test PASSED");
			} else if (result.isNew()) {
				rtnVal = "NEW";
				LOGGER.info("Visual Test is New!");
			} else {
				rtnVal = "FAILED";
				LOGGER.info("To review and refine the results goto: " + result.getUrl());
			}
		} catch (Exception e) {
			LOGGER.error(e.toString());
		} finally {
			try {
				eyes.abortIfNotClosed();
			} catch (NullPointerException e) {
				LOGGER.warn("Looks like the applitools connection was already closed");
			}
		}
		return rtnVal;
	}

	public void abortTest() {
		try {
			if (eyes != null && eyes.getIsOpen()) {
				eyes.close(false);
			}
		} finally {
			if (eyes != null && eyes.getIsOpen()) {
				eyes.abortIfNotClosed();
			}
		}
	}
}