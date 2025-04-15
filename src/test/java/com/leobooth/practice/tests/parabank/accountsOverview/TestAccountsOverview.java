package com.leobooth.practice.tests.parabank.accountsOverview;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.pageObjects.parabank.AccountsOverviewPage;
import com.leobooth.practice.pageObjects.parabank.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
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
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.PARABANK_LOGO);
    }

    @Test(dependsOnGroups = {"login"})
    public void testWelcomeMessageCustomerName() {
        String expectedCustomerName = ENV_VARS.get("PARABANK_CUSTOMER_NAME").trim();
        String actualCustomerName = accountsOverviewPage.getCustomerNameFromWelcome().trim();
        Assert.assertEquals(expectedCustomerName, actualCustomerName, "When logged in, " +
                "the expected customer name '" + expectedCustomerName + "' did not match " +
                "the actual customer name '" + actualCustomerName + "'");
    }

    @Test(dependsOnGroups = {"login"})
    public void testLogout() {

    }

    @AfterClass()
    public void logout() {
        if (driver.getCurrentUrl().equals(AccountsOverviewPage.pageUrl)) {
            accountsOverviewPage.logout();
        }
    }
}
