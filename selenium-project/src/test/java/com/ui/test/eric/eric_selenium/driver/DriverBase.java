package com.ui.test.eric.eric_selenium.driver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import com.ui.test.eric.eric_selenium.utils.PropUtils;

public class DriverBase {
	
	private static WebDriver driver;
	
	private DriverBase() {
		// 从配置文件读取浏览器名称
		PropUtils propUtils = new PropUtils("conf/common.properties");
		String browserName = propUtils.getProp("browser.name");
		driver = SelectDriver.getDriverByName(browserName);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	public static WebDriver getDriver() {
		System.out.println("获取Driver");
		System.out.println(driver);
		if (driver == null) {
			System.out.println("Driver 为 null, 创建新的Driver");
			new DriverBase();
		}
		return driver;
	}	
}