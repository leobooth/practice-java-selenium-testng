package com.leobooth.practice.parabank.pageObjects;

import com.leobooth.practice.framework.baseObjects.BasePage;
import com.leobooth.practice.framework.elementWrapper.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserPage extends BasePage {

    public static String pageUrl = "https://parabank.parasoft.com/parabank/register.htm";
    public static String pageName = "Parabank Register Account page";

    public RegisterUserPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    public static By REGISTER_SECTION_LABEL = By.xpath("//div[@id='rightPanel']/descendant::h1[contains(text(),'Signing up is easy!')]");
    public static By FIRST_NAME_INPUT = By.name("customer.firstName");
    public static By LAST_NAME_INPUT = By.name("customer.lastName");
    public static By ADDRESS = By.name("customer.address.street");
    public static By CITY = By.name("customer.address.city");
    public static By STATE = By.name("customer.address.state");
    public static By ZIP_CODE = By.name("customer.address.zipCode");
    public static By PHONE_NUMBER = By.name("customer.phoneNumber");
    public static By SSN = By.name("customer.ssn");
    public static By USERNAME = By.name("customer.username");
    public static By PASSWORD = By.name("customer.password");
    public static By CONFIRM_PASSWORD = By.name("repeatedPassword");
    public static By REGISTER_BUTTON = By.xpath("//input[@class='button' and @value='Register']");

    public static By USERNAME_ERRORS = By.id("customer.username.errors");

    public void enterFirstName(String firstName) {
        Element.action.sendKeys(driver, FIRST_NAME_INPUT, firstName);
    }

    public void enterLastName(String lastName) {
        Element.action.sendKeys(driver, LAST_NAME_INPUT, lastName);
    }

    public void enterAddress(String address) {
        Element.action.sendKeys(driver, ADDRESS, address);
    }

    public void enterCity(String city) {
        Element.action.sendKeys(driver, CITY, city);
    }

    public void enterState(String state) {
        Element.action.sendKeys(driver, STATE, state);
    }

    public void enterZipCode(String zipCode) {
        Element.action.sendKeys(driver, ZIP_CODE, zipCode);
    }

    public void enterPhoneNumber(String phoneNumber) {
        Element.action.sendKeys(driver, PHONE_NUMBER, phoneNumber);
    }

    public void enterSSN(String ssn) {
        Element.action.sendKeys(driver, SSN, ssn);
    }

    public void enterUsername(String username) {
        Element.action.sendKeys(driver, USERNAME, username);
    }

    public void enterPassword(String password) {
        Element.action.sendKeys(driver, PASSWORD, password);
    }

    public void enterConfirmPassword(String password) {
        Element.action.sendKeys(driver, CONFIRM_PASSWORD, password);
    }

    public void clickRegisterButton() {
        Element.action.click(driver, REGISTER_BUTTON);
    }


}
