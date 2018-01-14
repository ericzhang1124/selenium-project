package com.ui.test.eric.eric_selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDriver {
	
	public static WebDriver getDriverByName(String driverName) {
		if (driverName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", 
					"/Users/ex-zhangchen003/App/webdriver/chrome/2.3.4/chromedriver");
			return new ChromeDriver();
		}else {
			return new ChromeDriver();
		}
	}
	
}
