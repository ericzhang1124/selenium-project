package com.ui.test.eric.eric_selenium.testcase;

import org.openqa.selenium.WebDriver;

import com.ui.test.eric.eric_selenium.driver.DriverBase;

public class BaseCase {
	
	public WebDriver initDriver() {
		return DriverBase.getDriver();
	}
	
}
