package com.leobooth.practice.tests.parabank;

import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.framework.baseObjects.BaseTest;
import com.leobooth.practice.pageObjects.parabank.ParaBankHomePage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageTitle extends BaseTest {

  @Test
  public void testPageTitle() {
    WebDriver driver = setupTestDriverChrome();
    driver.manage().window().maximize();

    ParaBankHomePage homePage = new ParaBankHomePage(driver);
    homePage.navToPage();
    String expectedTitle = "ParaBank";
    String actualTitle = homePage.getPageTitle();
    WaitFluent.untilElementVisible(driver, homePage.LOGO_IMAGE);
    Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not contain " + expectedTitle);
  }
}
