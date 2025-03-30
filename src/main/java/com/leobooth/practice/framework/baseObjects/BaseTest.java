package com.leobooth.practice.framework.baseObjects;

import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;

public class BaseTest {

  private ArrayList<WebDriver> testDrivers = new ArrayList<>();

  public WebDriver setupTestDriverChrome() {
    WebDriver driver = new ChromeDriver();
    testDrivers.add(driver);
    return driver;
  }

  public WebDriver setupTestDriverEdge() {
    WebDriver driver = new EdgeDriver();
    testDrivers.add(driver);
    return driver;
  }

  @AfterClass
  public void tearDown() {
    if (!testDrivers.isEmpty()) {
      for(WebDriver driver : testDrivers) {
        if (driver != null) {
          driver.quit();
        }
      }
    }
  }
}
