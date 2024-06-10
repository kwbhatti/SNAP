package com.natgeo.utilities;

import org.openqa.selenium.*;

public class FormUtil {
  public static String getText(WebDriver driver, By by) {
    return driver.findElement(by).getText();
  }

  public static String getTextFromBodyInFrame(WebDriver driver, By by) {
    driver.switchTo().frame((WebElement) driver.findElement(by));
    String text = driver.findElement(By.cssSelector("body")).getText();
    driver.switchTo().defaultContent();
    return text;
  }

}
