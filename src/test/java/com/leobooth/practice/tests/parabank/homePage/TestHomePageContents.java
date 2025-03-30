package com.leobooth.practice.tests.parabank.homePage;

import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.pageObjects.parabank.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Map;

public class TestHomePageContents extends BaseTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void setup() {
        driver = setupTestDriverChrome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.PARABANK_LOGO);
    }

    @Test
    public void testPageUrl() {
        Assert.assertTrue(homePage.isBrowserOnPage());
    }

    @Test
    public void testPageTitle() {
        String expectedTitle = "ParaBank";
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not contain " + expectedTitle);
    }

    @Test
    public void testExpectedLinksPresent() {
        SoftAssert softAssert = new SoftAssert();
        for (Map.Entry<String, By> link : HomePage.links.entrySet()) {
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
        softAssert.assertAll();
    }
}
