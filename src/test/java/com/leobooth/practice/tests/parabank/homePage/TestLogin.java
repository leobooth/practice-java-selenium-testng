package com.leobooth.practice.tests.parabank.homePage;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.pageObjects.parabank.AccountsOverviewPage;
import com.leobooth.practice.pageObjects.parabank.HomePage;
import com.leobooth.practice.pageObjects.parabank.RegisterUserPage;
import com.leobooth.practice.tests.parabank.registerUser.TestRegisterUser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {
    WebDriver driver;
    AccountsOverviewPage accountsOverviewPage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        HomePage homePage = new HomePage(driver);
        TestHomePageContents.setupHomePage(homePage);

        // the Parabank website erases registered users often
        // re-register before running login test to ensure user exists
        RegisterUserPage registerUserPage = new RegisterUserPage(driver);
        TestRegisterUser.setupRegisterUser(driver, registerUserPage);
        TestRegisterUser.registerUser(new RegisterUserPage(driver));

        homePage.navToPage();
        setupLogin(new HomePage(driver));

        accountsOverviewPage = new AccountsOverviewPage(driver);
    }

    public static void setupLogin(HomePage homePage) {
        String username = ENV_VARS.get("PARABANK_USERNAME");
        String password = ENV_VARS.get("PARABANK_PASSWORD");
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), HomePage.USERNAME_INPUT);
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), HomePage.PASSWORD_INPUT);
        homePage.login(username, password);
        WaitFluent.untilElementIsDisplayed(homePage.getDriver(), AccountsOverviewPage.WELCOME_MESSAGE);
    }

    @Test(groups = "login")
    public void testLogin() {
        Assert.assertTrue(accountsOverviewPage.isBrowserOnPage(), "After login, the browser did not navigate to Accounts Overview page.");
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_MESSAGE).isDisplayed(), "After login, the welcome message did not appear.");
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.ACCOUNTS_OVERVIEW_LABEL).isDisplayed(), "After login, the Accounts Overview page section did not appear.");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout() {
        accountsOverviewPage.logout();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.CUSTOMER_LOGIN_LABEL);
        Assert.assertTrue(new HomePage(driver).isBrowserOnPage());
    }
}
