package com.leobooth.practice.framework.waits;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;

public class WaitFluent {

    private static int defaultMaxWaitTimeInSeconds = 5;
    private static int defaultMillisBeforeRetry = 500;

    private static Wait<WebDriver> fluentWait(WebDriver driver, Duration timeout, Duration polling) {
        return new FluentWait<>(driver)
                .withTimeout(timeout)
                .pollingEvery(polling)
                .ignoring(ElementNotInteractableException.class);
    }

    private static Wait<WebDriver> forSeconds(WebDriver driver, int maxWaitTimeInSeconds) {
        Duration timeout = Duration.ofSeconds(maxWaitTimeInSeconds);
        Duration polling = Duration.ofMillis(defaultMillisBeforeRetry);
        return fluentWait(driver, timeout, polling);
    }

    private static Wait<WebDriver> customWait(WebDriver driver, int maxWaitTimeInSeconds, int millisBeforeRetry) {
        Duration timeout = Duration.ofSeconds(maxWaitTimeInSeconds);
        Duration polling = Duration.ofMillis(millisBeforeRetry);
        return fluentWait(driver, timeout, polling);
    }

    public static void untilElementIsDisplayed(WebDriver driver, By byLocator)
            throws TimeoutException {
        untilElementIsDisplayed(driver, defaultMaxWaitTimeInSeconds, defaultMillisBeforeRetry, byLocator);
    }

    public static void untilElementIsDisplayed(
            WebDriver driver, int maxWaitTimeInSeconds, By byLocator
            ) throws TimeoutException {
        untilElementIsDisplayed(driver, maxWaitTimeInSeconds, defaultMillisBeforeRetry, byLocator);
    }

    public static void untilElementIsDisplayed(
            WebDriver driver, int maxWaitTimeInSeconds, int millisBeforeRetry, By byLocator)
            throws TimeoutException {
        try {
            Wait<WebDriver> wait = customWait(driver, maxWaitTimeInSeconds, millisBeforeRetry);
            wait.until( d -> {
                try {
                    driver.findElement(byLocator).isDisplayed();
                    return true;
                } catch (NoSuchElementException e) {
                    return false;
                }
            });
        } catch (TimeoutException te) {
            throw new TimeoutException("Element did not appear before maximum wait time of "
                    + maxWaitTimeInSeconds + " seconds was exceeded.", te);
        }
    }

    public static void untilElementsAreDisplayed(WebDriver driver, By byLocator)
            throws TimeoutException {
        untilElementsAreDisplayed(driver, defaultMaxWaitTimeInSeconds, defaultMillisBeforeRetry, byLocator);
    }

    public static void untilElementsAreDisplayed(
            WebDriver driver, int maxWaitTimeInSeconds, By byLocator
    ) throws TimeoutException {
        untilElementsAreDisplayed(driver, maxWaitTimeInSeconds, defaultMillisBeforeRetry, byLocator);
    }

    public static void untilElementsAreDisplayed(
            WebDriver driver, int maxWaitTimeInSeconds, int millisBeforeRetry, By byLocator)
            throws TimeoutException {
        try {
            Wait<WebDriver> wait = customWait(driver, maxWaitTimeInSeconds, millisBeforeRetry);
            wait.until( d -> {
                ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(byLocator));
                if (elements.isEmpty()) {
                    throw new NoSuchElementException("No elements were found matching the locator provided.");
                }
                for (WebElement element : elements) {
                    if (!element.isDisplayed()){
                        return false;
                    };
                }

                return true;
            });
        } catch (TimeoutException te) {
            throw new TimeoutException("Elements did not appear before maximum wait time of "
                    + maxWaitTimeInSeconds + " seconds was exceeded.", te);
        }
    }
}
