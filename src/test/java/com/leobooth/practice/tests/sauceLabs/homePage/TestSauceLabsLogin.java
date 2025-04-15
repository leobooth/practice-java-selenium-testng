package com.leobooth.practice.tests.sauceLabs.homePage;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.sauceLabs.pageObjects.ProductsPage;
import com.leobooth.practice.sauceLabs.pageObjects.SauceLabsHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestSauceLabsLogin extends BaseTest {
    WebDriver driver;
    SauceLabsHomePage homePage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new SauceLabsHomePage(driver);
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), SauceLabsHomePage.SWAG_LABS_LOGO);
    }

    @DataProvider(name="usernames")
    public Object[][] UsernamesFeed() {
        Object[][] usernames = new Object[6][1];
        usernames[0][0] = ENV_VARS.get("SAUCELABS_STANDARD_USER");
        usernames[1][0] = ENV_VARS.get("SAUCELABS_LOCKED_OUT_USER");
        usernames[2][0] = ENV_VARS.get("SAUCELABS_PROBLEM_USER");
        usernames[3][0] = ENV_VARS.get("SAUCELABS_PERFORMANCE_GLITCH_USER");
        usernames[4][0] = ENV_VARS.get("SAUCELABS_ERROR_USER");
        usernames[5][0] = ENV_VARS.get("SAUCELABS_VISUAL_USER");

        return usernames;
    }

    public static void performSauceLabsLogin(SauceLabsHomePage homePage, String username) {
        String password = ENV_VARS.get("SAUCELABS_PASSWORD");
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), SauceLabsHomePage.USERNAME_INPUT);
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), SauceLabsHomePage.PASSWORD_INPUT);
        homePage.login(username, password);
        ProductsPage productsPage = new ProductsPage(homePage.getDriver());
        WaitFluent.untilElementIsDisplayed(productsPage.getDriver(), ProductsPage.LOGO);
    }

    @Test(dataProvider = "usernames")
    public void testLogin(String username) {
        String password = ENV_VARS.get("SAUCELABS_PASSWORD");
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), SauceLabsHomePage.USERNAME_INPUT);
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), SauceLabsHomePage.PASSWORD_INPUT);
        homePage.login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);

        if (username.contains("STANDARD_USER")) {
            WaitFluent.untilElementIsDisplayed(productsPage.getDriver(), ProductsPage.LOGO);
            Assert.assertTrue(Element.info.isDisplayed(productsPage.getDriver(), ProductsPage.SHOPPING_CART_BUTTON));
            productsPage.openMenu();
            productsPage.logout();
            Assert.assertTrue(Element.info.isDisplayed(homePage.getDriver(), SauceLabsHomePage.LOGIN_BUTTON));
        }
    }

    @Test
    public void testLogout() {
        String username = ENV_VARS.get("SAUCELABS_STANDARD_USER");
        performSauceLabsLogin(homePage, username);
        ProductsPage productsPage = new ProductsPage(homePage.getDriver());
        WaitFluent.untilElementIsDisplayed(productsPage.getDriver(), ProductsPage.LOGO);
        Assert.assertTrue(Element.info.isDisplayed(productsPage.getDriver(), ProductsPage.SHOPPING_CART_BUTTON));
        productsPage.openMenu();
        productsPage.logout();
        Assert.assertTrue(Element.info.isDisplayed(homePage.getDriver(), SauceLabsHomePage.LOGIN_BUTTON));
    }


}
