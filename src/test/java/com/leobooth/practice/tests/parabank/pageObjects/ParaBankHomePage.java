package com.leobooth.practice.tests.parabank.pageObjects;

import com.leobooth.practice.tests.bases.BasePage;
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
}
