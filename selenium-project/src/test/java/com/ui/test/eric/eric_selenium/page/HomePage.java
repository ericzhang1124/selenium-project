package com.ui.test.eric.eric_selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.ui.test.eric.eric_selenium.utils.GetBy;

public class HomePage extends BasePage{
	
	String home_page_file = "pages/home.properties";
	
	public HomePage() {
		super();
		
	}
	
	public WebElement getLoginBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.login.btn"));
	}
	
	public WebElement getRegisterBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.register.btn"));
	}
	
	public WebElement getSwitchCityCloseBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.switchcity.dlogbox.close.btn"));
	}
	
	public WebElement getSwitchCityDivContainer() {
		return find_element(GetBy.getBy(home_page_file, "home.switchcity.dlogbox.div.container"));
	}
	
	public WebElement getDeliveryBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.logined.delivery.btn"));
	}
	
	public WebElement getLogoutBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.logined.logout.btn"));
	}
	
	public WebElement getUserNameBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.logined.user.name.btn"));
	}
	
	/**
	 * 获取用户名旁边的下拉箭头
	 * @return
	 */
	public WebElement getDropBookBtn() {
		By by = GetBy.getBy(home_page_file, "home.logined.drop.arrow");
		return find_element_dependent_parent(getUserNameBtn(), by);
	}
	
	/**
	 * 我的简历按钮
	 */
	public WebElement getMyCVBtn() {
		return find_element(GetBy.getBy(home_page_file, "home.logined.myCV.btn"));
	}
	

}
