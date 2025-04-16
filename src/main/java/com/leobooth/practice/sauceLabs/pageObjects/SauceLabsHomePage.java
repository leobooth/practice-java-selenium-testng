package com.leobooth.practice.sauceLabs.pageObjects;

import com.leobooth.practice.framework.baseObjects.BasePage;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SauceLabsHomePage extends BasePage {

    public static String pageUrl = "https://www.saucedemo.com/";
    public static String pageName = "Sauce Labs home page";

    public SauceLabsHomePage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    public static By SWAG_LABS_LOGO = By.cssSelector("div.login_logo");
    public static By USERNAME_INPUT = By.cssSelector("input#user-name");
    public static By PASSWORD_INPUT = By.cssSelector("input#password");
    public static By ERROR_MESSAGE = By.cssSelector("div.error-message-container");
    public static By ERROR_MESSAGE_CLOSE_BUTTON = By.cssSelector("button.error-button");
    public static By LOGIN_BUTTON = By.cssSelector("input#login-button");

    public void login(String username, String password) {
        WaitFluent.untilElementIsDisplayed(driver, USERNAME_INPUT);
        WaitFluent.untilElementIsDisplayed(driver, PASSWORD_INPUT);
        clearUsername();
        clearPassword();
        Element.action.sendKeys(driver, USERNAME_INPUT, username);
        Element.action.sendKeys(driver, PASSWORD_INPUT, password);
        WaitFluent.untilElementIsDisplayed(driver, LOGIN_BUTTON);
        Element.action.click(driver, LOGIN_BUTTON);
    }

    public void clearUsername() {
        WaitFluent.untilElementIsDisplayed(driver, USERNAME_INPUT);
        Element.action.clear(driver, USERNAME_INPUT);
        Assert.assertTrue(Element.info.getText(driver, USERNAME_INPUT).isBlank());
    }

    public void clearPassword() {
        WaitFluent.untilElementIsDisplayed(driver, PASSWORD_INPUT);
        Element.action.clear(driver, PASSWORD_INPUT);
        Assert.assertTrue(Element.info.getText(driver, PASSWORD_INPUT).isBlank());
    }

    public String getErrorMessage() {
        WaitFluent.untilElementIsDisplayed(driver, ERROR_MESSAGE);
        return Element.info.getText(driver, ERROR_MESSAGE);
    }

    public void closeErrorMessage() {
        Element.action.click(driver, ERROR_MESSAGE_CLOSE_BUTTON);
    }

}
