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

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        setupHomePage(driver, homePage);
    }

    public static void setupHomePage(WebDriver driver, HomePage homePage) {
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.PARABANK_LOGO);
    }

    @Test(groups = {"smoke"})
    public void testPageUrl() {
        Assert.assertTrue(homePage.isBrowserOnPage());
    }

    @Test(groups = {"smoke"})
    public void testPageTitle() {
        String expectedTitle = "ParaBank";
        String actualTitle = homePage.getPageTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not contain " + expectedTitle);
    }

    @Test(groups = {"links"})
    public void testHomePageLinks() {
        SoftAssert softAssert = testExpectedLinksPresent(driver, HomePage.links);
        softAssert.assertAll();
    }
}
