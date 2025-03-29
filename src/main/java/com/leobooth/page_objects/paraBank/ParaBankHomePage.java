package com.leobooth.page_objects.paraBank;

import com.leobooth.page_objects.BasePage;
import org.openqa.selenium.WebDriver;

public class ParaBankHomePage extends BasePage {

  final String pageUrl = "https://parabank.parasoft.com/parabank/index.htm";

  final String pageName = "ParaBank home page";

  public ParaBankHomePage(WebDriver driver) {
    super(driver);
    this.setPageUrl(pageUrl);
    this.setPageName(pageName);
  }
}
