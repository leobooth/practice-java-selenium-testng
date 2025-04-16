package com.leobooth.practice.framework.baseObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import com.leobooth.practice.framework.waits.WaitFluent;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    public static Dotenv ENV_VARS = Dotenv.configure().load();
    private ArrayList<WebDriver> testDrivers = new ArrayList<>();

    // TODO: fix Chrome blocking Sauce Labs tests with popup due to 'breached' demo password
    public WebDriver setupTestDriverChrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs",
                Map.of(
                    "profile.password_manager_enabled", false,
                    "credentials_enable_service", false
                )
        );

//        chromeOptions.setExperimentalOption("excludeSwitches",
//                Arrays.asList(
//                    "disable-popup-blocking",
//                    "password-manager-reauthentication"
//                )
//        );

        WebDriver driver = new ChromeDriver(chromeOptions);
        testDrivers.add(driver);
        return driver;
    }

    public WebDriver setupTestDriverEdge() {
        WebDriver driver = new EdgeDriver();
        testDrivers.add(driver);
        return driver;
    }

    public WebDriver setupTestDriver(String testBrowserRequest) {
        String testBrowser = "";

        if (testBrowserRequest.isBlank()) {
            testBrowser = System.getProperty("testBrowser").toUpperCase().trim();
        } else {
            testBrowser = testBrowserRequest.toUpperCase().trim();
        }

        WebDriver driver = switch(testBrowser) {
            case "CHROME" -> setupTestDriverChrome();
            case "EDGE" -> setupTestDriverEdge();
            default -> throw new InvalidArgumentException(
                    "Invalid test browser requested: " + testBrowser);
        };

        return driver;
    }

    public WebDriver setupTestDriver() {
        return setupTestDriver("");
    }

    // TODO: use this later as part of a crawler / graph-walking test?
    public SoftAssert testExpectedLinksPresent(WebDriver driver, LinkedHashMap<String, By> links) {
        SoftAssert softAssert = new SoftAssert();
        for (Map.Entry<String, By> link : links.entrySet()) {
            boolean linkFound = false;
            try {
                WaitFluent.untilElementsAreDisplayed(driver, link.getValue());
                ArrayList<WebElement> elements = new ArrayList<>(driver.findElements(link.getValue()));
                if (elements.isEmpty()) {
                    linkFound = false;
                } else {
                    for (WebElement element : elements) {
                        if (!element.isDisplayed()) {
                            linkFound = false;
                            System.out.println("Did not find link: " + link.getKey());
                        }
                    }
                }
                linkFound = true;
                System.out.println("Found link: " + link.getKey());
            } catch (TimeoutException e) {
                linkFound = false;
                System.out.println("Did not find link: " + link.getKey());
            } finally {
                softAssert.assertTrue(linkFound);
            }
        }

        return softAssert;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (!testDrivers.isEmpty()) {
            for(WebDriver driver : testDrivers) {
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }

}
