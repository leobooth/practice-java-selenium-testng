package com.leobooth.practice.pageObjects.parabank;

import com.leobooth.practice.framework.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    public static String pageUrl = "https://parabank.parasoft.com/parabank/register.htm";
    public static String pageName = "Parabank Register Account page";

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    public static By REGISTER_SECTION_LABEL = By.xpath("//div[@id='rightPanel']/descendant::h1[contains(text(),'Signing up is easy!')]");
    public static By FIRST_NAME = By.name("customer.firstName");
    public static By LAST_NAME = By.name("customer.lastName");
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

    public void enterFirstName(String firstName) {
        WebElement element = getDriver().findElement(FIRST_NAME);
        element.sendKeys();
    }

    public void enterLastName(String firstName) {
        WebElement element = getDriver().findElement(LAST_NAME);
        element.sendKeys();
    }

    public void enterAddress(String address) {
        WebElement element = getDriver().findElement(ADDRESS);
        element.sendKeys();
    }
}
