package com.leobooth.practice.tests.sauceLabs.homePage;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.sauceLabs.pageObjects.ProductsPage;
import com.leobooth.practice.sauceLabs.pageObjects.SauceLabsHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestSauceLabsLogout extends BaseTest {
    WebDriver driver;
    SauceLabsHomePage homePage;

    @BeforeClass()
    public void setup() {
        // run these tests in Edge until you can figure out how to avoid
        // password 'breach' popup in Chrome for Swag Labs login
        driver = setupTestDriver("EDGE");
        driver.manage().window().maximize();
        homePage = new SauceLabsHomePage(driver);
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), SauceLabsHomePage.SWAG_LABS_LOGO);
    }

    @Test
    public void testLogout() {
        String username = ENV_VARS.get("SAUCELABS_STANDARD_USER");
        String password = ENV_VARS.get("SAUCELABS_PASSWORD");
        homePage.login(username, password);

        ProductsPage productsPage = new ProductsPage(driver);
        WaitFluent.untilElementIsDisplayed(driver, ProductsPage.SHOPPING_CART_BUTTON);
        productsPage.openMenu();
        productsPage.logout();

        Assert.assertTrue(Element.info.isDisplayed(driver, SauceLabsHomePage.LOGIN_BUTTON));
    }
}
