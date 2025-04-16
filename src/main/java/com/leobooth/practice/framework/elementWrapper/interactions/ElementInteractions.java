package com.leobooth.practice.framework.elementWrapper.interactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 In Selenium, there are only 5 basic actions
 that can be performed on a WebElement: <br>
 click, sendKeys, clear, submit, and select
 <p>
 see: <a href="https://www.selenium.dev/documentation/webdriver/elements/interactions/">docs: Selenium / WebDriver / Elements / Interactions</a>
 </p>
 */
public class ElementInteractions {

    public void click(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void sendKeys(WebDriver driver, By locator, String textInput) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(textInput);
    }

    public void clear(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        element.clear();
    }

}
