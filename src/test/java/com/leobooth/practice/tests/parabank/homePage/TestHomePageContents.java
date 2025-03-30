package com.leobooth.practice.tests.parabank.homePage;

import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.pageObjects.parabank.HomePage;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
    public void testHomePageLinks() {
        SoftAssert softAssert = testExpectedLinksPresent(driver, HomePage.links);
        softAssert.assertAll();
    }
}
