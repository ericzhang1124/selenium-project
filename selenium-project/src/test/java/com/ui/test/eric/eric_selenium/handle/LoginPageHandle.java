package com.ui.test.eric.eric_selenium.handle;

import com.ui.test.eric.eric_selenium.page.LoginPage;

public class LoginPageHandle {

	private LoginPage lp;
	
	public LoginPageHandle() {
		// TODO Auto-generated constructor stub
		lp = new LoginPage();
	}
	
	public void inputUserName(String username) {
		lp.sendKeys(lp.getUserNameInput(), username);
	}
	
	public void inputPassword(String password) {
		lp.sendKeys(lp.getPasswordInput(), password);
	}
	
	public void clickLoginBtn() {
		lp.click(lp.getLoginBtn());
	}
	
	public boolean isInLoginPage() {
		try {
			return lp.verify_displayed(lp.getForgotPwdBtn());
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 获取密码错误的提示文本
	 */
	public String getWrongPwdTipText() {
		return lp.get_text(lp.getWrongPwdTip());
	}
}
