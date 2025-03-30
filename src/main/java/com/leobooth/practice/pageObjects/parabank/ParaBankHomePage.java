package com.leobooth.practice.pageObjects.parabank;

import com.leobooth.practice.framework.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ParaBankHomePage extends BasePage {

  final String pageUrl = "https://parabank.parasoft.com/parabank/index.htm";
  final String pageName = "ParaBank home page";

  public ParaBankHomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }

  public By LOGO_IMAGE = By.cssSelector("img.logo");

  public By LEFT_MENU_SOLUTIONS = By.xpath("//ul[@class='leftmenu']/descendant::li[text()='Solutions']");
  public By LEFT_MENU_ABOUT_US = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='About Us']");
  public By LEFT_MENU_SERVICES = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Services']");
  public By LEFT_MENU_PRODUCTS = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Products']");
  public By LEFT_MENU_LOCATIONS = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Locations']");
  public By LEFT_MENU_ADMIN_PAGE = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Admin Page']");

  public By USERNAME_INPUT = By.xpath("//input[@name='username']");
  public By PASSWORD_INPUT = By.xpath("//input[@name='password']");
  public By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");

}
