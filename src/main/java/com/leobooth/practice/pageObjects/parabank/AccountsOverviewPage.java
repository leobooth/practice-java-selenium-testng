package com.leobooth.practice.pageObjects.parabank;

import com.leobooth.practice.framework.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsOverviewPage extends BasePage {

    public static String pageUrl = "https://parabank.parasoft.com/parabank/overview.htm";
    public static String pageName = "Parabank Accounts Overview page";

    public AccountsOverviewPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    public static By WELCOME_MESSAGE = By.xpath("//p[b[contains(text(),'Welcome')]]");
    public static By ACCOUNT_SERVICES_LABEL;
    public static By TRANSFER_FUNDS_LABEL;
    public static By BILL_PAY;
    public static By FIND_TRANSACTIONS;
    public static By UPDATE_CONTACT_INFO;
    public static By REQUEST_LOAN;
    public static By LOG_OUT = By.xpath("//li/a[text()='Log Out']");

    public static By ACCOUNTS_OVERVIEW_LABEL = By.xpath("//div[@id='overviewAccountsApp']/descendant::h1[contains(text(),'Accounts Overview')]");
    public static By WELCOME_NEW_ACCOUNT_LABEL = By.xpath("//div[@id='rightPanel']/h1[contains(text(),'Welcome')]");
    public static By WELCOME_NEW_ACCOUNT_MESSAGE = By.xpath("//div[@id='rightPanel']/p[contains(text(),'Your account was created successfully.')]");


    public void logout() {
        getDriver().findElement(LOG_OUT).click();
    }

    public String getCustomerNameFromWelcome() {
        WebElement WELCOME_CUSTOMER = getDriver().findElement(WELCOME_MESSAGE);
        String welcomeMessage = WELCOME_CUSTOMER.getText();
        String customerName = welcomeMessage.substring("Welcome ".length()).trim();
        return customerName;
    }

}
