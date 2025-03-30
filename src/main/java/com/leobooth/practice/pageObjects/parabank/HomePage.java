package com.leobooth.practice.pageObjects.parabank;

import com.leobooth.practice.framework.baseObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class HomePage extends BasePage {

  public static String pageUrl = "https://parabank.parasoft.com/parabank/index.htm";
  public static String pageName = "ParaBank home page";

  public HomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }

  public static By PARABANK_ADMIN_BUTTON = By.cssSelector("a img.admin");
  public static By PARABANK_LOGO = By.cssSelector("img.logo");
  public static By PARABANK_SLOGAN = By.cssSelector("p.caption");

  public static By LEFT_MENU_SOLUTIONS = By.xpath("//ul[@class='leftmenu']/descendant::li[text()='Solutions']");
  public static By LEFT_MENU_ABOUT_US = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='About Us']");
  public static By LEFT_MENU_SERVICES = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Services']");
  public static By LEFT_MENU_PRODUCTS = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Products']");
  public static By LEFT_MENU_LOCATIONS = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Locations']");
  public static By LEFT_MENU_ADMIN_PAGE = By.xpath("//ul[@class='leftmenu']/descendant::a[text()='Admin Page']");

  public static By HEADER_HOME_BUTTON = By.cssSelector("ul.button li.home");
  public static By HEADER_ABOUT_US_BUTTON = By.cssSelector("ul.button li.aboutus");
  public static By HEADER_CONTACT_BUTTON = By.cssSelector("ul.button li.contact");

  public static By CUSTOMER_LOGIN_LABEL = By.xpath("//h2[text()='Customer Login']");
  public static By USERNAME_INPUT = By.xpath("//input[@name='username']");
  public static By PASSWORD_INPUT = By.xpath("//input[@name='password']");
  public static By LOGIN_BUTTON = By.xpath("//input[@value='Log In']");
  public static By FORGOT_LOGIN_INFO = By.xpath("//a[text()='Forgot login info?']");
  public static By REGISTER = By.xpath("//a[text()='Register']");

  public static By ATM_SERVICES_LABEL = By.xpath("//li[text()='ATM Services']");
  public static By WITHDRAW_FUNDS = By.xpath("//a[text()='Withdraw Funds']");
  public static By TRANSFER_FUNDS_ATM = By.xpath("//li[text()='ATM Services']/following-sibling::li/a[text()='Transfer Funds']");
  public static By CHECK_BALANCES = By.xpath("//a[text()='Check Balances']");
  public static By MAKE_DEPOSITS = By.xpath("//a[text()='Make Deposits']");

  public static By ONLINE_SERVICES_LABEL = By.xpath("//li[text()='Online Services']");
  public static By BILL_PAY = By.xpath("//a[text()='Bill Pay']");
  public static By ACCOUNT_HISTORY = By.xpath("//a[text()='Account History']");
  public static By TRANSFER_FUNDS_ONLINE = By.xpath("//li[text()='Online Services']/following-sibling::li/a[text()='Transfer Funds']");

  public static By LATEST_NEWS_LABEL = By.xpath("//h4[text()='Latest News']");
  public static By LATEST_NEWS_DATE_LABEL = By.xpath("//h4[text()='Latest News']/following-sibling::ul/li[@class='captionthree']");
  public static By LATEST_NEWS_LINKS = By.xpath("//h4[text()='Latest News']/following-sibling::ul/li/a");

  public static final HashMap<String, By> links;
  static {
    links = new HashMap<>();
    links.put("PARABANK_ADMIN_BUTTON", PARABANK_ADMIN_BUTTON);
    links.put("LEFT_MENU_SOLUTIONS", LEFT_MENU_SOLUTIONS);
    links.put("LEFT_MENU_ABOUT_US", LEFT_MENU_ABOUT_US);
    links.put("LEFT_MENU_SERVICES", LEFT_MENU_SERVICES);
    links.put("LEFT_MENU_PRODUCTS", LEFT_MENU_PRODUCTS);
    links.put("LEFT_MENU_LOCATIONS", LEFT_MENU_LOCATIONS);
    links.put("LEFT_MENU_ADMIN_PAGE", LEFT_MENU_ADMIN_PAGE);
    links.put("HEADER_HOME_BUTTON", HEADER_HOME_BUTTON);
    links.put("HEADER_ABOUT_US_BUTTON", HEADER_ABOUT_US_BUTTON);
    links.put("HEADER_CONTACT_BUTTON", HEADER_CONTACT_BUTTON);
    links.put("FORGOT_LOGIN_INFO", FORGOT_LOGIN_INFO);
    links.put("REGISTER", REGISTER);
    links.put("WITHDRAW_FUNDS", WITHDRAW_FUNDS);
    links.put("TRANSFER_FUNDS_ATM", TRANSFER_FUNDS_ATM);
    links.put("CHECK_BALANCES", CHECK_BALANCES);
    links.put("MAKE_DEPOSITS", MAKE_DEPOSITS);
    links.put("BILL_PAY", BILL_PAY);
    links.put("ACCOUNT_HISTORY", ACCOUNT_HISTORY);
    links.put("TRANSFER_FUNDS_ONLINE", TRANSFER_FUNDS_ONLINE);
    links.put("LATEST_NEWS_LINKS", LATEST_NEWS_LINKS);
  }

  public static final HashMap<String, By> inputs;
  static {
    inputs = new HashMap<>();
    inputs.put("USERNAME_INPUT", USERNAME_INPUT);
    inputs.put("PASSWORD_INPUT", PASSWORD_INPUT);
  }
}
