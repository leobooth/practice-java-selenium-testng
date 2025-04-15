package com.leobooth.practice.tests.parabank.homePage;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.parabank.pageObjects.AccountsOverviewPage;
import com.leobooth.practice.parabank.pageObjects.ParabankHomePage;
import com.leobooth.practice.parabank.pageObjects.RegisterUserPage;
import com.leobooth.practice.tests.parabank.registerUser.TestRegisterUser;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestParabankLogin extends BaseTest {
    WebDriver driver;
    ParabankHomePage homePage;
    AccountsOverviewPage accountsOverviewPage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new ParabankHomePage(driver);
        TestParabankHomePage.setupHomePage(homePage);

        // the Parabank website erases registered users often
        // re-register before running login test to ensure user exists
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);
        TestRegisterUser.setupRegisterUser(driver, registerUserPage);
        TestRegisterUser.registerUser(new RegisterUserPage(driver));

        homePage.navToPage();
    }

    public static void performParabankLogin(ParabankHomePage homePage) {
        String username = ENV_VARS.get("PARABANK_USERNAME");
        String password = ENV_VARS.get("PARABANK_PASSWORD");
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), ParabankHomePage.USERNAME_INPUT);
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), ParabankHomePage.PASSWORD_INPUT);
        homePage.login(username, password);

        try {
            WaitFluent.untilElementIsDisplayed(homePage.getDriver(), AccountsOverviewPage.WELCOME_MESSAGE);
        } catch (TimeoutException te) {
            throw new TimeoutException("The Accounts Overview customer welcome message did not appear.");
        }
    }

    @Test(groups = "login")
    public void testLogin() {
        performParabankLogin(homePage);
        accountsOverviewPage = new AccountsOverviewPage(driver);
        Assert.assertTrue(accountsOverviewPage.isBrowserOnPage(), "After login, the browser did not navigate to Accounts Overview page.");
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_MESSAGE).isDisplayed(), "After login, the welcome message did not appear.");
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.ACCOUNTS_OVERVIEW_LABEL).isDisplayed(), "After login, the Accounts Overview page section did not appear.");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout() {
        accountsOverviewPage.logout();
        WaitFluent.untilElementIsDisplayed(driver, ParabankHomePage.CUSTOMER_LOGIN_LABEL);
        Assert.assertTrue(new ParabankHomePage(driver).isBrowserOnPage());
    }
}
