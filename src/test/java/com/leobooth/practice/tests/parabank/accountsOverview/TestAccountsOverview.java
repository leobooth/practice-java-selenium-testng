package com.leobooth.practice.tests.parabank.accountsOverview;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.parabank.pageObjects.AccountsOverviewPage;
import com.leobooth.practice.parabank.pageObjects.ParabankHomePage;
import com.leobooth.practice.tests.parabank.homePage.TestParabankHomePage;
import com.leobooth.practice.tests.parabank.homePage.TestParabankLogin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAccountsOverview extends BaseTest {
    WebDriver driver;
    ParabankHomePage homePage;
    AccountsOverviewPage accountsOverviewPage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new ParabankHomePage(driver);
        TestParabankHomePage.setupHomePage(homePage);
        TestParabankLogin.performParabankLogin(homePage);
        accountsOverviewPage = new AccountsOverviewPage(driver);
    }

    @Test
    public void testWelcomeMessageCustomerName() {
        String expectedCustomerName = ENV_VARS.get("PARABANK_CUSTOMER_FULL_NAME").trim();
        String actualCustomerName = accountsOverviewPage.getCustomerNameFromWelcome().trim();
        Assert.assertEquals(expectedCustomerName, actualCustomerName, "When logged in, " +
                "the expected customer name '" + expectedCustomerName + "' did not match " +
                "the actual customer name '" + actualCustomerName + "'");
    }
}
