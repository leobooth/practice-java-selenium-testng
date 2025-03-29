package com.leobooth.practice.tests.theInternet.tests;

import com.leobooth.practice.framework.waits.WaitFluent;
import com.leobooth.practice.tests.theInternet.pageObjects.TheInternetHomePage;
import com.leobooth.practice.tests.bases.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestPageTitle extends BaseTest {

  @Test
  public void testPageTitle() {
    WebDriver driver = setupTestDriverChrome();
    driver.manage().window().maximize();

    TheInternetHomePage homePage = new TheInternetHomePage(driver);
    homePage.navToPage();
    String expectedTitle = "The Internet";
    String actualTitle = homePage.getPageTitle();
    WaitFluent.untilElementVisible(driver, homePage.PAGE_TITLE);

    Assert.assertEquals(actualTitle, expectedTitle, "Page title did not equal " + expectedTitle);
  }
}
