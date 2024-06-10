package com.natgeo.applitools;

import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.RectangleSize;
import com.natgeo.utilities.LoaderUtil;

import net.serenitybdd.core.Serenity;
import net.thucydides.core.webdriver.WebDriverFacade;

/**
 * This class is for configuring the Applitools for visual test.
 * 
 * @author Administrator
 */
public class Config {
	/**
	 * Object of ApplitoolsStepsListener
	 */
	static StepsListener applitools = null;

	/**
	 * Logger for this class
	 */
	private static final Logger LOG = LoggerFactory.getLogger(Config.class);

	/**
	 * Data Loader Status (ON or OFF)
	 */
	// final String applitoolsStatus = PropertyUtil.getProperty("applitools",
	// RestConstants.APPLITOOLS_CONFIG_PATH);

	/**
	 * This method is used to configure and start the visual validation.
	 * 
	 * @param browser
	 * @param testName
	 * @throws URISyntaxException
	 */
	public static void start(WebDriverFacade browser, String testName) throws URISyntaxException {

		// if (PropertyUtil.getProperty("applitools",
		// RestConstants.APPLITOOLS_CONFIG_PATH).equalsIgnoreCase("on")) {
		if (applitools == null) {
			applitools = StepsListener.instance(LoaderUtil.getInstance().applitoolsKey,
					new URI(LoaderUtil.getInstance().applitoolsURL));
		}

		// Setting full page screenshoting
		applitools.forceFullPageScreenshot(true);

		// Setting alternative scroll/stitch mode to CSS
		// applitools.setStitchMethod(StitchMode.CSS);

		// Setting better error prints when turning off Exceptions on close
		applitools.setThrowExeptionOnClose(false);

		// Set Batch
		BatchInfo b = new BatchInfo((String) Serenity.sessionVariableCalled("env"));
		b.setId((String) Serenity.sessionVariableCalled("batchID"));
		applitools.setBatch(b);

		// Set Window size
		applitools.startVisualTest(browser.getProxiedDriver(), testName, testName, new RectangleSize(800, 600));
	}

	/**
	 * This method is used to stop the visual validation.
	 * 
	 * @throws URISyntaxException
	 */
	public static String stopApplitools() {
		return applitools.stopCheckWindow();
	}

	public static void checkWindow(String testname) throws URISyntaxException {
		if (applitools == null) {
			applitools = StepsListener.instance(LoaderUtil.getInstance().applitoolsKey,
					new URI(LoaderUtil.getInstance().applitoolsURL));
		}
		applitools.checkWindow(testname);
	}

}
