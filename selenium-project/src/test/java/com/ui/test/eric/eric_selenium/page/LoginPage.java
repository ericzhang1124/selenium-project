package com.ui.test.eric.eric_selenium.page;

import org.openqa.selenium.WebElement;

import com.ui.test.eric.eric_selenium.utils.GetBy;

public class LoginPage extends BasePage{

	String login_page_file = "pages/login.properties";
	
	public LoginPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WebElement getUserNameInput() {
		return find_element(GetBy.getBy(login_page_file, "login.username.input"));
	}
	
	public WebElement getPasswordInput() {
		return find_element(GetBy.getBy(login_page_file, "login.password.input"));
	}
	
	public WebElement getLoginBtn() {
		return find_element(GetBy.getBy(login_page_file, "login.login.btn"));
	}

	public WebElement getPartnerLoginText() {
		return find_element(GetBy.getBy(login_page_file, "login.partner.login.text"));
	}
	
	public WebElement getForgotPwdBtn() {
		return find_element(GetBy.getBy(login_page_file, "login.forgot.pwd.btn"));
	}
	
	public WebElement getWrongPwdTip() {
		return find_element(GetBy.getBy(login_page_file, "login.wrong.password.tip"));
	}
	 
}
