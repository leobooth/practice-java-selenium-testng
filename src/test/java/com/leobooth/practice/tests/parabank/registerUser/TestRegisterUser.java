package com.leobooth.practice.tests.parabank.registerUser;

import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.pageObjects.parabank.AccountsOverviewPage;
import com.leobooth.practice.pageObjects.parabank.HomePage;
import com.leobooth.practice.pageObjects.parabank.ParabankUser;
import com.leobooth.practice.pageObjects.parabank.RegisterUserPage;
import com.leobooth.practice.tests.parabank.homePage.TestHomePageContents;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestRegisterUser extends BaseTest {
    WebDriver driver;
    ParabankUser parabankUser;
    RegisterUserPage registerUserPage;

    @BeforeClass
    public void setup() {
        driver = setupTestDriver();
        driver.manage().window().maximize();
        TestHomePageContents.setupHomePage(new HomePage(driver));
        parabankUser = new ParabankUser(ENV_VARS);
        registerUserPage = new RegisterUserPage(driver);
        setupRegisterUser(driver, registerUserPage);
    }

    public static void setupRegisterUser(WebDriver webDriver, RegisterUserPage registerUserPage) {
        WaitFluent.untilElementIsDisplayed(webDriver, HomePage.REGISTER);
        Element.action.click(webDriver, HomePage.REGISTER);
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
            Assert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_NEW_ACCOUNT_LABEL).isDisplayed());
            Assert.assertTrue(driver.findElement(AccountsOverviewPage.WELCOME_NEW_ACCOUNT_MESSAGE).isDisplayed());
            System.out.println("User is registered.");
        }
    }

    @Test(groups="registerUser")
    public void testRegisterUser() {
        registerUser(registerUserPage);
    }
}
