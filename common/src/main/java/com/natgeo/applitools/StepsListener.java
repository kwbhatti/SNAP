package com.natgeo.applitools;

import java.net.URI;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.exceptions.TestFailedException;
import com.applitools.eyes.selenium.Eyes;

import net.thucydides.core.model.DataTable;
import net.thucydides.core.model.Story;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.steps.ExecutedStepDescription;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.steps.StepFailure;
import net.thucydides.core.steps.StepListener;

/**
 * Utility class for working with Applitools
 * 
 * 
 */
public final class StepsListener implements StepListener {
	private static final Logger LOGGER = LoggerFactory.getLogger(StepsListener.class);
	
	
	private static ThreadLocal<StepsListener> listener = new ThreadLocal<>();

	private Eyes eyes;
	private ExecutedStepDescription currStepDesc = null;
	private boolean throwEx;
	

	/// Get instance without APIkey, if already initialized with APIKey
	public static StepsListener instance() {
		return instance(null, null);
	}

	/// Get instance with APIKey init
	public static StepsListener instance(String apiKey, URI serverUrl) {
		if (listener.get() == null) {
			listener.set(new StepsListener());
		}

		listener.get().eyes = serverUrl != null ? new Eyes(serverUrl) : new Eyes();

		if (apiKey != null) {
			listener.get().eyes.setApiKey(apiKey);
		}
		return listener.get();
	}

	public StepsListener forceFullPageScreenshot(boolean isSet) {
		// eyes.setProxy(new ProxySettings("http://3.20.109.242:9400"));
		this.eyes.setForceFullPageScreenshot(isSet);
		return this;
	}

	public StepsListener setMatchLevel(MatchLevel matchLevel) {
		this.eyes.setMatchLevel(matchLevel);
		return this;
	}

	public StepsListener setThrowExeptionOnClose(boolean throwEx) {
		this.throwEx = throwEx;
		return this;
	}

	/// Start test - Once started every step will be visually checked
	public void startVisualTest(WebDriver driver, String app, String test, RectangleSize viewportSize) {
		StepEventBus.getEventBus().registerListener(listener.get());
		this.eyes.open(driver, app, test, viewportSize);
	}

	/// Stop visual test - Stop test monitor and print the result
	/// In case of visual difference or new baseline, the test will be failed with
	/// notification.
	public void stopVisualTest() {
		StepEventBus.getEventBus().dropListener(listener.get());
		TestResults result = this.eyes.close(this.throwEx);
		if (!result.isPassed()) {
			StringBuilder failure = new StringBuilder();
			failure.append(String.format("Visual Test %s !\n", result.isNew() ? "is New!" : "was Failed"));
			failure.append("<br>");
			if (result.isNew()) {
				failure.append("This test used to save the baseline, please run again to see the results");
			} else {
				failure.append("To review and refine the results click ");
				failure.append(String.format("<a href=\"%s\" target=\"_blank\">Here.</a> \n", result.getUrl()));
			}
			failure.append("<br>");
			StepEventBus.getEventBus().testFailed(new TestFailedException(result, failure.toString()));
		}

	}

	public String stopCheckWindow() {
		String rtnVal = "PASSED";
		TestResults result = this.eyes.close(this.throwEx);
		if (!result.isPassed()) {
			LOGGER.info(String.format("Visual Test %s !\n", result.isNew() ? "is New!" : "was Failed"));
			if (result.isNew()) {
				rtnVal = "NEW";
				LOGGER.info("This test used to save the baseline, please run again to see the results");
			} else {
				rtnVal = "FAILED";
				LOGGER.info("To review and refine the results goto: " + result.getUrl());
			}
		}
		return rtnVal;
	}
	
	public void checkWindow(String tag) {
		if (this.eyes.getIsOpen()) {
			this.eyes.checkWindow(tag);
		}
	}

	public void setBatch(BatchInfo batchInfo) {
		eyes.setBatch(batchInfo);
	}
	
	// Blocking public c'tor
	private StepsListener() {
	}

	@Override
	public void testSuiteStarted(Class<?> storyClass) {

	}

	@Override
	public void testSuiteStarted(Story story) {

	}

	@Override
	public void testSuiteFinished() {

	}

	@Override
	public void testStarted(String description) {

	}

	@Override
	public void testFinished(TestOutcome result) {

	}

	@Override
	public void testRetried() {

	}

	@Override
	public void stepStarted(ExecutedStepDescription description) {
		this.currStepDesc = description;
	}

	@Override
	public void skippedStepStarted(ExecutedStepDescription description) {

	}

	@Override
	public void stepFailed(StepFailure failure) {

	}

	@Override
	public void lastStepFailed(StepFailure failure) {

	}

	@Override
	public void stepIgnored() {

	}

	@Override
	public void stepPending() {

	}

	@Override
	public void stepPending(String message) {
	}

	@Override
	public void stepFinished() {
		if (this.currStepDesc != null) {
			this.eyes.checkWindow(this.currStepDesc.getName());
		}
		this.currStepDesc = null;
	}

	@Override
	public void testFailed(TestOutcome testOutcome, Throwable cause) {
		this.eyes.abortIfNotClosed();
	}

	@Override
	public void testIgnored() {

	}

	@Override
	public void testSkipped() {

	}

	@Override
	public void testPending() {

	}

	@Override
	public void notifyScreenChange() {

	}

	@Override
	public void useExamplesFrom(DataTable table) {

	}

	@Override
	public void addNewExamplesFrom(DataTable table) {

	}

	@Override
	public void exampleStarted(Map<String, String> data) {

	}

	@Override
	public void exampleFinished() {
	}

	@Override
	public void assumptionViolated(String message) {

	}

	@Override
	public void testIsManual() {

	}	

	
	@Override
	public void testRunFinished() {
		// TODO Auto-generated method stub

	}

	@Override
	public void testStarted(String arg0, String arg1) {
		// TODO Auto-generated method stub

	}

}
