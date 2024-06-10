package com.natgeo.browsermob;

import java.io.UnsupportedEncodingException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicHeaderValueParser;
import org.apache.http.message.ParserCursor;
import org.apache.http.util.CharArrayBuffer;
import org.junit.Assert;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.CaptureType;

public class GetHeaderRequest {
	private static final char[] DELIM = new char[]{'&'};

	
	public static List<String> getResponseUrls(String url, String filter) throws Exception {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/henryfl/Downloads/chromedriver");
		// DesiredCapabilities capabilities = new DesiredCapabilities();
		BrowserMobProxy proxy = new BrowserMobProxyServer();
		proxy.setTrustAllServers(true);

		proxy.setHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
		//proxy.enableHarCaptureTypes(CaptureType.RESPONSE_HEADERS);
		proxy.start();

		Proxy seleniumProxy = getSeleniumProxy(proxy);

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--ignore-certificate-errors");
		options.setCapability(CapabilityType.PROXY, seleniumProxy);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		WebDriver driver = new ChromeDriver(options);

		proxy.newHar(); // creating new HAR

		driver.get(url);


		List<String> foundURLS = new ArrayList<String>();
		List<HarEntry> entries = proxy.getHar().getLog().getEntries();
		for (HarEntry entry : entries) {
			if(entry.getRequest().getUrl().contains(filter)) {
				foundURLS.add(entry.getRequest().getUrl());
			}
		}
		
		proxy.stop();
		driver.quit();
		
		return foundURLS;
	}

	private static Proxy getSeleniumProxy(BrowserMobProxy proxyServer) {
		Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxyServer);
		try {

			String hostIp = Inet4Address.getLocalHost().getHostAddress();
			seleniumProxy.setHttpProxy("localhost:" + proxyServer.getPort());
			seleniumProxy.setSslProxy("localhost:" + proxyServer.getPort());

		} catch (UnknownHostException e) {
			e.printStackTrace();
			Assert.fail("invalid Host Address");
		}
		return seleniumProxy;
	}
	
	
	public static Map<String,String> parseHeader(final String s) throws UnsupportedEncodingException {
		Map<String,String> list1 = new HashMap<String,String>();
	    if (s == null) {
	        return list1;
	    }
	    BasicHeaderValueParser parser = BasicHeaderValueParser.DEFAULT;
	    CharArrayBuffer buffer = new CharArrayBuffer(s.length());
	    buffer.append(s);
	    ParserCursor cursor = new ParserCursor(0, buffer.length());
	    
	    while (!cursor.atEnd()) {
	        NameValuePair nvp = parser.parseNameValuePair(buffer, cursor, DELIM);
	        if (nvp.getName().length() > 0) {
	        	if(nvp.getValue() != null) {
	        		list1.put(nvp.getName(), java.net.URLDecoder.decode(nvp.getValue(), "UTF-8"));
	        	} else {
	        		list1.put(nvp.getName(), null);
	        	}
	        			
	        }
	    }
	    return list1;
	}
}
