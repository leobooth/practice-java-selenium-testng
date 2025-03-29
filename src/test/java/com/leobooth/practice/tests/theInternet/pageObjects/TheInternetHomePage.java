package com.leobooth.practice.tests.theInternet.pageObjects;

import com.leobooth.practice.tests.bases.BasePage;
import org.openqa.selenium.WebDriver;

public class TheInternetHomePage extends BasePage {

  final String pageUrl = "https://the-internet.herokuapp.com/";

  final String pageName = "'The Internet' home page";

  public TheInternetHomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }
}
