package com.leobooth.practice.tests.parabank.registerUser;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.parabank.pageObjects.AccountsOverviewPage;
import com.leobooth.practice.parabank.pageObjects.ParabankHomePage;
import com.leobooth.practice.parabank.utilities.ParabankUser;
import com.leobooth.practice.parabank.pageObjects.RegisterUserPage;
import com.leobooth.practice.tests.parabank.homePage.TestParabankHomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestRegisterUser extends BaseTest {
    WebDriver driver;
    ParabankUser parabankUser;
    RegisterUserPage registerUserPage;

    @BeforeClass
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        TestParabankHomePage.setupHomePage(new ParabankHomePage(driver));
        parabankUser = new ParabankUser(ENV_VARS);
        registerUserPage = new RegisterUserPage(driver);
        setupRegisterUser(driver, registerUserPage);
    }

    public static void setupRegisterUser(WebDriver webDriver, RegisterUserPage registerUserPage) {
        WaitFluent.untilElementIsDisplayed(webDriver, ParabankHomePage.REGISTER);
        Element.action.click(webDriver, ParabankHomePage.REGISTER);
        WaitFluent.untilElementIsDisplayed(webDriver, RegisterUserPage.REGISTER_SECTION_LABEL);
        Assert.assertTrue(registerUserPage.isBrowserOnPage());
    }

    private static void completeRegisterUserForm(RegisterUserPage registerUserPage, ParabankUser parabankUser) {
        registerUserPage.enterFirstName(parabankUser.firstName);
        registerUserPage.enterLastName(parabankUser.lastName);
        registerUserPage.enterAddress(parabankUser.address);
        registerUserPage.enterCity(parabankUser.city);
        registerUserPage.enterState(parabankUser.state);
        registerUserPage.enterZipCode(parabankUser.zipCode);
        registerUserPage.enterPhoneNumber(parabankUser.phoneNumber);
        registerUserPage.enterSSN(parabankUser.SSN);
        registerUserPage.enterUsername(parabankUser.username);
        registerUserPage.enterPassword(parabankUser.password);
        registerUserPage.enterConfirmPassword(parabankUser.password);
    }

    public static void registerUser(RegisterUserPage registerUserPage) {
        ParabankUser parabankUser = new ParabankUser(ENV_VARS);
        WebDriver driver = registerUserPage.getDriver();

        completeRegisterUserForm(registerUserPage, parabankUser);
        registerUserPage.clickRegisterButton();
        boolean isUserAlreadyRegistered = Element.info.isDisplayed(driver, RegisterUserPage.USERNAME_ERRORS);

        if (isUserAlreadyRegistered) {
            System.out.println("User is already registered.");
            Assert.assertTrue(true);
        } else {
            WaitFluent.untilElementIsDisplayed(driver, AccountsOverviewPage.WELCOME_NEW_ACCOUNT_LABEL);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_NEW_ACCOUNT_LABEL).isDisplayed());
            softAssert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_NEW_ACCOUNT_MESSAGE).isDisplayed());
            softAssert.assertAll();
        }
    }

    @Test(groups="registerUser")
    public void testRegisterUser() {
        registerUser(registerUserPage);
    }
}
