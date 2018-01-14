package com.ui.test.eric.eric_selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ui.test.eric.eric_selenium.driver.DriverBase;
import com.ui.test.eric.eric_selenium.utils.PropUtils;

public class BasePage {

	private WebDriver driver;
	
	private PropUtils propUtils = new PropUtils("conf/url.properties");
	
	public BasePage() {
		driver = DriverBase.getDriver();
	}
	
	// 访问测试站点首页
	public void goToHomePage() {
		driver.get(propUtils.getProp("url.home"));
	}
	
	// 查找单个元素
	public WebElement find_element(By by) {
		return driver.findElement(by);
	}
	
	// 查找多个元素
	public List<WebElement> find_elements(By by){
		return driver.findElements(by);
	}
	
	// 根据父节点查找子元素
	public WebElement find_element_dependent_parent(WebElement parent, By by) {
		return parent.findElement(by);
	}
	
	// 元素点击
	public void click(WebElement element) {
		element.click();
	}
	
	
	// 文本录入
	public void sendKeys(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}
	
	// 验证元素是否存在
	public boolean verify_displayed(WebElement element) {
		return element.isDisplayed();
	}
	
	// 获取元素文本节点内容
	public String get_text(WebElement element) {
		return element.getText();
	}
}
