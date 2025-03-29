package com.leobooth.page_objects.theInternet;

import com.leobooth.page_objects.BasePage;
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
