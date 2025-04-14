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

    @BeforeClass(alwaysRun = true)
    public void setup() {
        driver = setupTestDriverChrome();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.PARABANK_LOGO);
    }

    @Test(groups = "login")
    public void testLogin() {
        String username = ENV_VARS.get("PARABANK_USERNAME");
        String password = ENV_VARS.get("PARABANK_PASSWORD");
        homePage.login(username, password);
        AccountsOverviewPage accountsOverviewPage = new AccountsOverviewPage(driver);
        Assert.assertTrue(accountsOverviewPage.isBrowserOnPage());
        WaitFluent.untilElementIsDisplayed(driver, AccountsOverviewPage.ACCOUNTS_OVERVIEW_LABEL);
        Assert.assertTrue(driver.findElement(AccountsOverviewPage.ACCOUNTS_OVERVIEW_LABEL).isDisplayed());
    }
}
