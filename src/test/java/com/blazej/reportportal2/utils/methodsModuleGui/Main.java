package com.blazej.reportportal2.utils.methodsModuleGui;

import org.openqa.selenium.WebDriver;

public abstract class Main {
   public static WebDriver driver;


   public static WebDriver getDriver() {
      return driver;
   }
}
