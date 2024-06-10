package com.natgeo.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class WindowsHandlerUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(WindowsHandlerUtil.class);

	/**
	 * left click on element so it opens in a new tab/windows Requires an string only for windows user
	 * with the css selector or name of an attribute on the class that stores it
	 * 
	 * @param driver
	 * @param element
	 */
	public static void leftClick(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.keyDown(Keys.LEFT_CONTROL).click(element).keyUp(Keys.LEFT_CONTROL).build().perform();
	}
	
	/**
	 * Open in a new Tab the href(url) value of a given element
	 * Consider that the new url to open will be "http://www.domain.com" + href.value
	 * @param driver
	 * @param element
	 */
	public static void openInNewTab(WebDriver driver, WebElement element) {
		String url = element.getAttribute("href");
		  ((JavascriptExecutor) driver).executeScript(
			       "window.open('" + url + "', '_blank');");
	}

	/**
	 * Returns the current window handler as a binary string
	 * 
	 * @param driver
	 * @return
	 */
	public static String getCurrentWindowHandle(WebDriver driver) {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	/**
	 * Returns the List of windows as a list of strings
	 * 
	 * @param driver
	 * @return
	 */
	public static ArrayList<String> getWindowHandlerList(WebDriver driver) {

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		return tabs;
	}

	/**
	 * Switch to the windows with the given title
	 * 
	 * @param driver
	 * @param windowTitle
	 */
	public static void switchToWindowsByTitle(WebDriver driver, String windowTitle) {

		String originalWindow = getCurrentWindowHandle(driver);
		for (String Handle : driver.getWindowHandles()) {
			if (driver.switchTo().window(Handle).getTitle().equals(windowTitle)) {
				driver.switchTo().window(Handle);
				break;
			} else {
				driver.switchTo().window(originalWindow);
			}
		}
	}

	/**
	 * Switch to the second tab currently open
	 * 
	 * @param driver
	 */
	public static void switchToSecondWindowsOpen(WebDriver driver) {

		driver.switchTo().window(getWindowHandlerList(driver).get(getWindowHandlerList(driver).size() - 1));
	}

	/**
	 * Get the total of windows currently open and returns the integer
	 * 
	 * @param driver
	 * @return
	 */
	public static int getTotalNumberOfWindowsOpen(WebDriver driver) {

		return getWindowHandlerList(driver).size();
	}

	/**
	 * Switch to a given windows by the position it has on the list of windows
	 * currently open Remember 0 position is for the first windows, 1 is for the
	 * last windows 2 for second-to-last windows, 3 for third-to-last windows and so
	 * forth
	 */
	public static void switchToWindowsOpenByIndex(WebDriver driver, int Index) {

		driver.switchTo().window(getWindowHandlerList(driver).get(Index));
	}

	/**
	 * Switch to the next tab/windows from the current one
	 * 
	 * @param driver
	 */
	public static void switchToNextTab(WebDriver driver) {

		if (getWindowHandlerList(driver).indexOf(getCurrentWindowHandle(driver)) == 0) {
			switchToSecondWindowsOpen(driver);
		} else if (getWindowHandlerList(driver).indexOf(getCurrentWindowHandle(driver)) == 1) {
			LOGGER.info("THE CURRENT WINDOWS IS THE LAST ONE!");
		} else {
			driver.switchTo().window(getWindowHandlerList(driver)
					.get(getWindowHandlerList(driver).indexOf(getCurrentWindowHandle(driver)) - 1));
		}
	}

}
