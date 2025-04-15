package com.leobooth.practice.framework.baseObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

public class BasePage {

  protected WebDriver driver = null;
  private String pageUrl = null;
  private String pageName = null;

  public BasePage(WebDriver driver) {
    this.driver = driver;
  }

  public BasePage(WebDriver driver, String pageUrl, String pageName) {
    this.driver = driver;
    this.pageUrl = pageUrl;
    this.pageName = pageName;
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  public String getUrl() {
    return driver.getCurrentUrl();
  }

  protected void setPageUrl(String pageUrl) {
    this.pageUrl = pageUrl;
  }

  public String getPageName() {
    return this.pageName;
  }

  protected void setPageName(String pageName) {
    this.pageName = pageName;
  }

  public void navToPage() {
    driver.navigate().to(pageUrl);
    System.out.println("navigated to " + pageName);  }

  public boolean isBrowserOnPage() {
    try {
      String currentUrl = driver.getCurrentUrl();
      if (currentUrl != null) {
        return currentUrl.contains(pageUrl);
      } else {
        return false;
      }
    } catch (WebDriverException we) {
      return false;
    }
  }

  public String getPageTitle() {
    return driver.getTitle();
  }

}
