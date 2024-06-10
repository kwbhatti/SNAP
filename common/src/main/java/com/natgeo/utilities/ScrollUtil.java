package com.natgeo.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollUtil {
	
  /**
   * Generates a javascriptExecutor object
   * @param driver
   */
	public static JavascriptExecutor generateJavascriptExecutor(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
	
  /**
   * Scrolls given x and y axis
   * @param driver
   */
  public static void scrollToEndPage(WebDriver driver) {
    generateJavascriptExecutor(driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
  }

  /**
   * Scrolls given x and y axis
   * @param driver
   * @param x_axis
   * @param y_axis
   */
  public static void scrollByAxis(WebDriver driver, int x_axis, int y_axis) {
    generateJavascriptExecutor(driver).executeScript(String.format("window.scrollBy(%d, %d);", x_axis, y_axis));
  }
  

  /**
   * Scrolls up to the top of an element
   * @param driver
   * @param element
   */
  public static void scrollToElement(WebDriver driver, WebElement element) {
    generateJavascriptExecutor(driver).executeScript("$(document).ready()");
    generateJavascriptExecutor(driver).executeScript("return arguments[0].scrollIntoView();", element);
  }

  /**
   * Scrolls up to the top of an element
   * @param driver
   * @param element
   */
  public static void scrollToTopOfElement(WebDriver driver, WebElement element) {
    generateJavascriptExecutor(driver).executeScript("arguments[0].scrollTop = 0;", element);
  }
  
  /**
   * Scrolls down to the end of an element
   * @param driver
   * @param element
   */
  public static void scrollToEndOfElement(WebDriver driver, WebElement element) {
	  generateJavascriptExecutor(driver).executeScript("arguments[0].scrollTop = 1;", element);
	  generateJavascriptExecutor(driver).executeScript("arguments[0].scrollTop = arguments[0].scrollHeight;", element);
  }

  /**
   * Scrolls to a specific element on page given index from element
   * @param driver
   * @param element
   * @param y_scroll_difference
   */
  public static void scroll_page_to_element_with_diff(WebDriver driver, WebElement element, int y_scroll_difference) { 
    scrollToElement(driver, element);
    generateJavascriptExecutor(driver).executeScript("$(document).ready()");
    generateJavascriptExecutor(driver).executeScript("return arguments[0].scrollBy(0, arguments[1]);", element, y_scroll_difference);
  }
  
  /**
   * Scroll to a given element for a given scroll webelement, in cases were there are multiple scroll bars and the focus is missing
   * @param driver
   * @param element
   * @param scroll_element
   * @param y_scroll_difference
   */
  public static void scroll_with_diff_with_multiples_scrollbar(WebDriver driver, WebElement element,WebElement scroll_element, int y_scroll_difference) { 
		    scrollToElement(driver, element);
		    generateJavascriptExecutor(driver).executeScript("$(document).ready()");
		    generateJavascriptExecutor(driver).executeScript("return arguments[0].scrollBy(0, arguments[1]);", scroll_element, y_scroll_difference);
  }

}
