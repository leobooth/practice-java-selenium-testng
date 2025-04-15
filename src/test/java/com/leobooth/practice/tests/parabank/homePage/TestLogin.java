package com.leobooth.practice.tests.parabank.homePage;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.pageObjects.parabank.AccountsOverviewPage;
import com.leobooth.practice.pageObjects.parabank.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    AccountsOverviewPage accountsOverviewPage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.PARABANK_LOGO);
    }

    // the Parabank website erases registered users often; re-register before running login test
    @Test(groups = "login")
    public void testLogin() {
        String username = ENV_VARS.get("PARABANK_USERNAME");
        String password = ENV_VARS.get("PARABANK_PASSWORD");
        homePage.login(username, password);
        accountsOverviewPage = new AccountsOverviewPage(driver);
        WaitFluent.untilElementIsDisplayed(driver, AccountsOverviewPage.WELCOME_MESSAGE);
        Assert.assertTrue(accountsOverviewPage.isBrowserOnPage(), "After login, the browser did not navigate to Accounts Overview page.");
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_MESSAGE).isDisplayed(), "After login, the welcome message did not appear.");
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.ACCOUNTS_OVERVIEW_LABEL).isDisplayed(), "After login, the Accounts Overview page section did not appear.");
    }

    @Test(dependsOnMethods = {"testLogin"})
    public void testLogout() {
        accountsOverviewPage.logout();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.CUSTOMER_LOGIN_LABEL);
        String currentUrl = driver.getCurrentUrl();
        String homePageUrl = HomePage.pageUrl;
        Assert.assertTrue(currentUrl.contains(homePageUrl));
    }
}
