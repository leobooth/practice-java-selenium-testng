package com.leobooth.practice.tests.parabank.tests;

import com.leobooth.practice.framework.waits.WaitUtils;
import com.leobooth.practice.tests.bases.BaseTest;
import com.leobooth.practice.tests.parabank.pageObjects.ParaBankHomePage;

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
    // TODO: replace with wait for ExpectedCondition
    WaitUtils.hardWaitForSeconds(2);

    Assert.assertTrue(actualTitle.contains(expectedTitle), "Page title did not contain " + expectedTitle);
  }
}
