package com.leobooth.practice.tests.parabank.accountsOverview;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.pageObjects.parabank.AccountsOverviewPage;
import com.leobooth.practice.pageObjects.parabank.HomePage;
import com.leobooth.practice.tests.parabank.homePage.TestHomePageContents;
import com.leobooth.practice.tests.parabank.homePage.TestLogin;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAccountsOverview extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    AccountsOverviewPage accountsOverviewPage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        TestHomePageContents.setupHomePage(homePage);
        TestLogin.setupLogin(homePage);
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
