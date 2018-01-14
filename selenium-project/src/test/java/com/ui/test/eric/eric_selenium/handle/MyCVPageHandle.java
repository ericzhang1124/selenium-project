package com.ui.test.eric.eric_selenium.handle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.ui.test.eric.eric_selenium.driver.DriverBase;
import com.ui.test.eric.eric_selenium.page.MyCVPage;

public class MyCVPageHandle {

	private MyCVPage myCVPage;
	private WebDriver driver;
	
	public MyCVPageHandle() {
		myCVPage = new MyCVPage();
		driver = DriverBase.getDriver();
	}
	
	/**
	 * 判断当前是否在个人简历页面
	 */
	public boolean isInMyCVPage() {
		try {
			return myCVPage.verify_displayed(myCVPage.getUserAvator());
			
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 点击个人信息编辑按钮
	 */
	public void clickUserInfoEditBtn() {
		Actions actions = new Actions(driver);
		actions.moveToElement(myCVPage.getUserInfoDivContainer()).perform();
		myCVPage.click(myCVPage.getUserInfoEditBtn());
	}
	
	/**
	 * 输入手机号码
	 */
	public void inputPhone(String phone) {
		myCVPage.getPhoneInput().clear();
		myCVPage.getPhoneInput().sendKeys(phone);
	}
	
	/**
	 * 点击个人信息保存按钮
	 */
	public void clickUserInfoSaveBtn() {
		myCVPage.click(myCVPage.getUserInfoSaveBtn());
	}
	
	/**
	 * 获取个人信息显示的手机号码
	 */
	public String getUserPhone() {
		return myCVPage.getUserInfoPhone().getText();
	}
}
