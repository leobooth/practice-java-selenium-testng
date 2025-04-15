package com.leobooth.practice.framework.elementWrapper.information;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

/**
 This class provides information about elements, while converting errors (such as NoSuchElementException)
 into information matching the expected return type of each method.
 <p>
 see: <a href="https://www.selenium.dev/documentation/webdriver/elements/information/">docs: Selenium / WebDriver / Elements / Information</a>
 </p>
 */
public class ElementInfo {

    public boolean isDisplayed(WebDriver driver, By locator) {
        boolean isDisplayed;
        try {
            isDisplayed = driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException nsee) {
            isDisplayed = false;
        }

        return isDisplayed;
    }
}
