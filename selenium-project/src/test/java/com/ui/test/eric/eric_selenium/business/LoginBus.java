package com.ui.test.eric.eric_selenium.business;

import org.testng.Assert;

import com.ui.test.eric.eric_selenium.handle.HomePageHandle;
import com.ui.test.eric.eric_selenium.handle.LoginPageHandle;

public class LoginBus {

	private LoginPageHandle lph;
	private HomePageHandle hph;
	
	public LoginBus() {
		// TODO Auto-generated constructor stub
		lph = new LoginPageHandle();
		hph = new HomePageHandle();
	}
	
	public void login(String username, String password) {
		lph.inputUserName(username);
		lph.inputPassword(password);
		lph.clickLoginBtn();
	}
	
	public void logout() {
		hph.clickLogoutBtn();
	}
	
	public void loginSuc(String username, String password) {
		Assert.assertEquals(lph.isInLoginPage(), true, "当前页面不是登录页面");
		// 若在登录页面，输入用户名，密码
		lph.inputUserName(username);
		lph.inputPassword(password);
		// 点击登录按钮
		lph.clickLoginBtn();
		// 断言当前页面是否为登录后的首页
		Assert.assertEquals(hph.isLoginSuccess(), true, "登录失败了，当前页面不是登录后的home页面");
	}
}
