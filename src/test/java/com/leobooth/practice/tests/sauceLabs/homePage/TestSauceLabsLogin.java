package com.leobooth.practice.tests.sauceLabs.homePage;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.sauceLabs.pageObjects.ProductsPage;
import com.leobooth.practice.sauceLabs.pageObjects.SauceLabsHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestSauceLabsLogin extends BaseTest {
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

    public static void performSauceLabsLogin(SauceLabsHomePage homePage, String username) {
        String password = ENV_VARS.get("SAUCELABS_PASSWORD");
        homePage.login(username, password);
        ProductsPage productsPage = new ProductsPage(homePage.getDriver());
        WaitFluent.untilElementIsDisplayed(productsPage.getDriver(), ProductsPage.LOGO);
    }

    @Test
    public void testLoginAccepted() {
        String username = ENV_VARS.get("SAUCELABS_STANDARD_USER");
        String password = ENV_VARS.get("SAUCELABS_PASSWORD");
        homePage.login(username, password);
        ProductsPage productsPage = new ProductsPage(driver);
        WaitFluent.untilElementIsDisplayed(driver, ProductsPage.LOGO);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Element.info.isDisplayed(driver, ProductsPage.SHOPPING_CART_BUTTON));

        productsPage.openMenu();
        productsPage.logout();

        softAssert.assertAll();
    }

    @Test
    public void testLoginDenied() {
        String username = ENV_VARS.get("SAUCELABS_STANDARD_USER");
        String password = "wrong_password";
        homePage.login(username, password);
        String errorMessage = homePage.getErrorMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errorMessage.contains("Username and password do not match any user"),
                "Unexpected error message displayed: " + errorMessage);

        homePage.closeErrorMessage();

        softAssert.assertAll();
    }

    // TODO: test post-login conditions
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

//    @Test(dataProvider = "usernames")
//    public void testLogin(String username) {
//        String password = ENV_VARS.get("SAUCELABS_PASSWORD");
//        homePage.login(username, password);
//
//        switch (username) {
//            case "standard_user" -> performStandardUserChecks();
//            case "locked_out_user" -> performLockedOutUserChecks();
//            case "problem_user" -> performProblemUserChecks();
//            case "performance_glitch_user" -> performPerformanceGlitchUserChecks();
//            case "error_user" -> performErrorUserChecks();
//            case "visual_user" -> performVisualUserChecks();
//            default -> throw new InvalidArgumentException("Unrecognized Sauce Labs username: " + username);
//        }
//    }

}
