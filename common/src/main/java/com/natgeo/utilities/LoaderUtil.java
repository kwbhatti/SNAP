package com.natgeo.utilities;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natgeo.constants.SNAP;
import com.saucelabs.saucerest.SauceREST;

import cucumber.api.Scenario;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;

public class LoaderUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoaderUtil.class);
	private static volatile LoaderUtil instance = null;
	public String sessionId;
	public String env;
	public String baseUrl;
	public String cmsauthlogin;
	public String cmsauthpassword;
	public String saucelabsUrl;
	public String sauceUserName;
	public String sauceAccessKey;
	public String applitoolsKey;
	public String applitoolsURL;
	public String applitoolsScreenSize;
	public String driverType;
	public String screensize;
	public String apiKeyValid;
	public String apiKeyValid2;
	public String apiKeyInvalid;
	public String batchId;
	public String applitoolsMatchLevel;
	public String chipCmsAdminUser;
	public String chipCmsAdminPass;
	public String chipCmsAdminToken;
	public String chipCmsAuthUser;
	public String chipCmsAuthPass;
	public String chipCmsAuthToken;
	public String chipReferenceStagingHeaderKey;
	public String chipReferenceStagingHeaderValue;
	public String profilesServiceAdminUser;
	public String profilesServiceAdminPass;
	public String playgroundUrl;
	private EnvironmentVariables variables;
	

	private LoaderUtil() {
		sessionId = "";
		env = "";
		baseUrl = "";
		cmsauthlogin = "";
		cmsauthpassword = "";
		saucelabsUrl = "";
		sauceUserName = "";
		sauceAccessKey = "";
		applitoolsKey = "";
		applitoolsURL = "";
		applitoolsScreenSize="";
		driverType = "";
		screensize="";
		apiKeyValid="";
		apiKeyValid2="";
		apiKeyInvalid="";
		batchId="";
		applitoolsMatchLevel="";
		chipCmsAdminUser="";
		chipCmsAdminPass="";
		chipCmsAdminToken="";
		chipCmsAuthUser="";
		chipCmsAuthPass="";
		chipCmsAuthToken="";
		profilesServiceAdminUser = "";
		profilesServiceAdminPass = "";
		playgroundUrl = "";
	}

	public static LoaderUtil getInstance() {
		// Lazy and thread-safe
		if (instance == null) {
			synchronized (LoaderUtil.class) {
				if (instance == null) {
					instance = new LoaderUtil();
				}
			}
		}

		return instance;
	}

	public void intilizeValues() {
		// This check could be extended to handle token expiration
		if (env == "") {
			variables = SystemEnvironmentVariables.createEnvironmentVariables();
			saucelabsUrl = variables.getProperty(ThucydidesSystemProperty.SAUCELABS_URL);
			baseUrl = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_BASE_URL);
			cmsauthlogin = variables.getProperty("CORE_ADMIN_USER");
			cmsauthpassword = variables.getProperty("CORE_ADMIN_PWD");
			if(variables.aValueIsDefinedFor(ThucydidesSystemProperty.WEBDRIVER_DRIVER) ) {
				driverType = variables.getProperty(ThucydidesSystemProperty.WEBDRIVER_DRIVER).trim().toUpperCase();
			}
			apiKeyValid = variables.getProperty(SNAP.API_KEY_VALID);
			apiKeyValid2 = variables.getProperty(SNAP.API_KEY_VALID2);
			apiKeyInvalid = variables.getProperty(SNAP.API_KEY_INVALID);

			if(variables.aValueIsDefinedFor(SNAP.SCREENSIZE) ) {
				screensize=variables.getProperty(SNAP.SCREENSIZE);
				LOGGER.info("---FOUND SCREENSIZE(" + screensize + ")---");
			} else {
				screensize="DESKTOP800X600";
				LOGGER.info("---DEFAULT SCREENSIZE---");
			}

			
			if(variables.aValueIsDefinedFor(SNAP.APPLITOOLS_SCREENSIZE) ) {
				applitoolsScreenSize=variables.getProperty(SNAP.APPLITOOLS_SCREENSIZE);
				LOGGER.info("---FOUND APPLITOOLS SCREENSIZE(" + applitoolsScreenSize + ")---");
			} else {
				applitoolsScreenSize="DESKTOP800X600";
				LOGGER.info("---DEFAULT APPLITOOLS SCREENSIZE---");
			}
			
			if(variables.aValueIsDefinedFor(SNAP.APPLITOOLS_MATCHLEVEL) ) {
				String tmpStr = variables.getProperty(SNAP.APPLITOOLS_MATCHLEVEL).trim().toUpperCase();
				switch(tmpStr) {
					case "CONTENT":
						tmpStr = "CONTENT";
						break;
					case "LAYOUT":
						tmpStr = "LAYOUT";
						break;
					case "EXACT":
						tmpStr = "EXACT";
						break;
					default: 
						tmpStr = "STRICT";
						if(!tmpStr.contains("STRICT")) {
							LOGGER.error("MatchLevel found -->" + variables.getProperty(SNAP.APPLITOOLS_MATCHLEVEL) + 
									     "\n This is not CONTENT,LAYOUT,EXACT, or STRICT");
							throw new EmptyStackException(); 
						}
		                break;
				}
				applitoolsMatchLevel = tmpStr;
			} 
			
			
			if(variables.aValueIsDefinedFor(SNAP.SCREENSIZE) ) {
				screensize=variables.getProperty(SNAP.SCREENSIZE);
				LOGGER.info("---FOUND SCREENSIZE(" + screensize + ")---");
			} else {
				screensize="DESKTOP800X600";
				LOGGER.info("---DEFAULT SCREENSIZE---");
			}

			String tmpStr = variables.getProperty(ThucydidesSystemProperty.PROPERTIES);
			env = tmpStr.substring(tmpStr.lastIndexOf("/") + 1, tmpStr.lastIndexOf("."));

			LOGGER.info("Get SauceLabs Info");
			if(variables.aValueIsDefinedFor(ThucydidesSystemProperty.SAUCELABS_USER_ID) ) sauceUserName = variables.getProperty(ThucydidesSystemProperty.SAUCELABS_USER_ID);
			if(variables.aValueIsDefinedFor(ThucydidesSystemProperty.SAUCELABS_ACCESS_KEY) ) sauceAccessKey = variables.getProperty(ThucydidesSystemProperty.SAUCELABS_ACCESS_KEY);
		
			LOGGER.info("Get Applitools Info");
			if(variables.aValueIsDefinedFor(SNAP.APPLITOOLS_KEY) )  applitoolsKey = variables.getProperty(SNAP.APPLITOOLS_KEY);
			if(variables.aValueIsDefinedFor(SNAP.APPLITOOLS_URL) ) applitoolsURL = variables.getProperty(SNAP.APPLITOOLS_URL);
				
			batchId=variables.getProperty("BATCHID");
			Serenity.setSessionVariable("env").to(env.trim().toUpperCase());
			Serenity.setSessionVariable("batchID").to(variables.getProperty("BATCHID"));
			//Serenity.setSessionVariable("batchID").to(variables.getProperty("batchID"));
			
			chipCmsAdminUser = variables.getProperty("CHIP_CMS_ADMIN_USER");
			chipCmsAdminPass = variables.getProperty("CHIP_CMS_ADMIN_PASS");
			chipCmsAdminToken = variables.getProperty("CHIP_CMS_ADMIN_TOKEN");
			chipCmsAuthUser = variables.getProperty("CHIP_CMS_AUTH_USER");
			chipCmsAuthPass = variables.getProperty("CHIP_CMS_AUTH_PASS");
			chipCmsAuthToken = variables.getProperty("CHIP_CMS_AUTH_TOKEN");
			chipReferenceStagingHeaderKey = variables.getProperty("chip.reference.staging.header.key");
			chipReferenceStagingHeaderValue = variables.getProperty("chip.reference.staging.header.value");
			
		}
		if (env.equals("profiles_service.staging")) {
			profilesServiceAdminUser = variables.getProperty("snap.profile.service.admin.user");
			profilesServiceAdminPass = variables.getProperty("snap.profile.service.admin.password");
			playgroundUrl = variables.getProperty("snap.playground.url");
		}
	}

	public void startSaucelabs(WebDriver driver, Scenario scenario) {
		String jobName = scenario.getName();
		Serenity.setSessionVariable("scenarioName").to(jobName);


		
		
		if (saucelabsUrl != null  && sessionId.trim().length()==0) {			
			RemoteWebDriver remoteDriver = (RemoteWebDriver) ((WebDriverFacade) driver).getProxiedDriver();

			sessionId = remoteDriver.getSessionId().toString();
			String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s", sessionId, jobName);
			LOGGER.info(message);
/*
			LOGGER.debug("!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#");
			LOGGER.debug("env-->" + env);
			LOGGER.debug("saucelabsUrl-->" + saucelabsUrl);
			LOGGER.debug("userName-->" + sauceUserName);
			LOGGER.debug("accessKey-->" + sauceAccessKey);
			LOGGER.debug("!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#!@#");
*/
			SauceREST r = new SauceREST(sauceUserName, sauceAccessKey);
			HashMap<String, Object> updates = new HashMap<String, Object>();
			updates.put("name", scenario.getName());
			r.updateJobInfo(sessionId, updates);
			
			
			List<String> listTags = new ArrayList<String>(scenario.getSourceTagNames());
			ListUtils.replaceStringInList(listTags, "@", "");
			ListUtils.capitalizeTrimStringsInList(listTags);
			updates.put("tags", listTags);
			r.updateJobInfo(sessionId, updates);
		}
	}

	public void setSauceLabsStatus(String status) {
		if (saucelabsUrl != null) {

			SauceREST r = new SauceREST(sauceUserName, sauceAccessKey);

			if (status.toUpperCase().contains("PASS")) {
				r.jobPassed(sessionId);
			} else {
				r.jobFailed(sessionId);
			}
		}
	}
	
	public void stopSauceLabs(Scenario scenario) {
		if (saucelabsUrl != null) {

			SauceREST r = new SauceREST(sauceUserName, sauceAccessKey);

			if (scenario.getStatus().toString().toUpperCase().contains("PASS")) {
				r.jobPassed(sessionId);
			} else {
				r.jobFailed(sessionId);
			}
		}
	}

}
