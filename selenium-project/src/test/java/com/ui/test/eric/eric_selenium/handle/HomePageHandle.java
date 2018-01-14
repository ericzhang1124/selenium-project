package com.ui.test.eric.eric_selenium.handle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ui.test.eric.eric_selenium.driver.DriverBase;
import com.ui.test.eric.eric_selenium.page.HomePage;

public class HomePageHandle {

	private HomePage hp;
	private WebDriver driver;
	
	public HomePageHandle() {
		// TODO Auto-generated constructor stub
		hp = new HomePage();
		driver = DriverBase.getDriver();
	}
	
	public void clickLoginBtn() {
		hp.click(hp.getLoginBtn());
	}
	
	/**
	 * 关闭城市选择对话框
	 */
	public void closeSwitchCityDiaBox() {
		hp.click(hp.getSwitchCityCloseBtn());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 判断是否展示了城市选择对话框
	 */
	public boolean isSwitchCityDiaBoxDisplayed() {
		return hp.verify_displayed(hp.getSwitchCityDivContainer());
	}
	
	/**
	 * 判断当前是否在未登录的homepage
	 */
	public boolean isInHomePage() {
		return (hp.verify_displayed(hp.getLoginBtn()) ||
				hp.verify_displayed(hp.getSwitchCityCloseBtn()));
	}
	
	/**
	 * 判断当前是否登录成功
	 */
	public boolean isLoginSuccess() {
		try {
			return hp.verify_displayed(hp.getDeliveryBtn());
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/**
	 * 点击退出登录
	 */
	public void clickLogoutBtn() {
		
		Actions actions = new Actions(driver);
		actions.moveToElement(hp.getDropBookBtn()).perform();
		hp.click(hp.getLogoutBtn());
	}
	
	/**
	 * 点击 我的简历 按钮
	 */
	public void clickMyCVBtn() {
		hp.click(hp.getMyCVBtn());
	}
}
