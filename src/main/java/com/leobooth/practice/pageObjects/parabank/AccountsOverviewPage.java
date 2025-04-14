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

    public static By ACCOUNTS_OVERVIEW_LABEL = By.xpath("//div[@id='overviewAccountsApp']/descendant::h1[contains(text(),'Accounts Overview')]");
}
