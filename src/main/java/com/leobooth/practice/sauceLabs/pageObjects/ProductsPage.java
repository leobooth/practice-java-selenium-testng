package com.leobooth.practice.sauceLabs.pageObjects;

import com.leobooth.practice.framework.baseObjects.BasePage;
import com.leobooth.practice.framework.elementWrapper.Element;
import com.leobooth.practice.framework.waits.WaitFluent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static String pageUrl = "https://www.saucedemo.com/inventory.html";
    public static String pageName = "Sauce Labs Products page";

    public ProductsPage(WebDriver driver) {
        super(driver);
        this.setPageUrl(pageUrl);
        this.setPageName(pageName);
    }

    public static By LOGO = By.cssSelector("div.app_logo");
    public static By MENU_BUTTON = By.cssSelector("button#react-burger-menu-btn");
    public static By SHOPPING_CART_BUTTON = By.cssSelector("a.shopping_cart_link");

    public static By MENU_ITEM_LIST = By.cssSelector("nav.bm-item-list");
    public static By MENU_ALL_ITEMS_OPTION = By.cssSelector("a#inventory_sidebar_link");
    public static By MENU_ABOUT_OPTION = By.cssSelector("a#about_sidebar_link");
    public static By MENU_LOGOUT = By.cssSelector("a#logout_sidebar_link");
    public static By MENU_RESET_APP_STATE = By.cssSelector("a#reset_sidebar_link");

    public void openMenu() {
        Element.action.click(getDriver(), MENU_BUTTON);
        WaitFluent.untilElementIsDisplayed(getDriver(), MENU_ITEM_LIST);
    }

    public void logout() {
        Element.action.click(getDriver(), MENU_LOGOUT);
    }
}
