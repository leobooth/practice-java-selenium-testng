package com.leobooth.practice.tests.parabank.homePage;

import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.parabank.pageObjects.ParabankHomePage;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestParabankHomePage extends BaseTest {
    WebDriver driver;
    ParabankHomePage parabankHomePage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        parabankHomePage = new ParabankHomePage(driver);
        setupHomePage(parabankHomePage);
    }

    public static void setupHomePage(ParabankHomePage homePage) {
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), ParabankHomePage.PARABANK_LOGO);
    }

    @Test(groups = {"smoke"})
    public void testPageUrl() {
        Assert.assertTrue(parabankHomePage.isBrowserOnPage());
    }

    @Test(groups = {"smoke"})
    public void testPageTitle() {
        String expectedTitle = "ParaBank";
        String actualTitle = parabankHomePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not contain " + expectedTitle);
    }

    @Test(groups = {"links"})
    public void testHomePageLinks() {
        SoftAssert softAssert = testExpectedLinksPresent(driver, ParabankHomePage.links);
        softAssert.assertAll();
    }
}
