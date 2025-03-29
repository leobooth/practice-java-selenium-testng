package com.leobooth.practice.framework.waits;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

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

    public static void untilElementVisible(WebDriver driver, By byPageObjectLocator) {
        try {
            Wait<WebDriver> wait = forSeconds(driver, defaultMaxWaitTimeInSeconds);
            wait.until( d -> driver.findElement(byPageObjectLocator).isDisplayed());
        } catch (TimeoutException te) {
            throw new TimeoutException("Element did not appear before maximum wait time of "
                                        + defaultMaxWaitTimeInSeconds + " seconds was exceeded.", te);
        }
    }

    public static void untilElementVisible(WebDriver driver, int maxWaitTimeInSeconds, By byPageObjectLocator) {
        try {
            Wait<WebDriver> wait = forSeconds(driver, maxWaitTimeInSeconds);
            wait.until( d -> driver.findElement(byPageObjectLocator).isDisplayed());
        } catch (TimeoutException te) {
            throw new TimeoutException("Element did not appear before maximum wait time of "
                    + maxWaitTimeInSeconds + " seconds was exceeded.", te);
        }
    }

    public static void untilElementVisible(WebDriver driver, int maxWaitTimeInSeconds, int millisBeforeRetry, By byPageObjectLocator) {
        try {
            Wait<WebDriver> wait = customWait(driver, maxWaitTimeInSeconds, millisBeforeRetry);
            wait.until( d -> driver.findElement(byPageObjectLocator).isDisplayed());
        } catch (TimeoutException te) {
            throw new TimeoutException("Element did not appear before maximum wait time of "
                    + maxWaitTimeInSeconds + " seconds was exceeded.", te);
        }
    }
}
