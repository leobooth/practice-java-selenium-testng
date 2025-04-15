package com.leobooth.practice.tests.parabank.register;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.pageObjects.parabank.AccountsOverviewPage;
import com.leobooth.practice.pageObjects.parabank.HomePage;
import com.leobooth.practice.pageObjects.parabank.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRegister extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    RegisterPage accountsOverviewPage;

    @BeforeClass()
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        homePage.navToPage();
        WaitFluent.untilElementIsDisplayed(driver, HomePage.PARABANK_LOGO);
    }


}
