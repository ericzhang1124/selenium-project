package com.ui.test.eric.eric_selenium.testcase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.ui.test.eric.eric_selenium.business.LoginBus;
import com.ui.test.eric.eric_selenium.handle.HomePageHandle;
import com.ui.test.eric.eric_selenium.handle.LoginPageHandle;
import com.ui.test.eric.eric_selenium.page.HomePage;
import com.ui.test.eric.eric_selenium.utils.JsonUtil;

public class LoginModel extends BaseCase {

	private HomePageHandle homePageHandle;
	private LoginPageHandle loginPageHandle;
	private LoginBus lBus;
	private HomePage hp;
	private WebDriver driver;
	
	public LoginModel() {
	}

	@BeforeClass
	public void bClass() {
		System.out.println("执行 登录 测试类的beforeCalss 方法");
		driver = initDriver();
		hp = new HomePage();
		homePageHandle = new HomePageHandle();
		loginPageHandle = new LoginPageHandle();
		lBus = new LoginBus();
	}

	@BeforeMethod
	public void bMethod() {
		hp.goToHomePage();
		Assert.assertEquals(homePageHandle.isInHomePage(), true, "进入首页失败了!");
	}
	
	@Test(dataProvider="my1")
	public void testLoginSuccess(String username, String password) {
		if (homePageHandle.isSwitchCityDiaBoxDisplayed()) {
			homePageHandle.closeSwitchCityDiaBox();
		}
		homePageHandle.clickLoginBtn();
		Assert.assertEquals(loginPageHandle.isInLoginPage(), true, "进入登录页面失败了!");
		lBus.login(username, password);
		Assert.assertEquals(homePageHandle.isLoginSuccess(), true, "登录不成功！");
		
		lBus.logout();

	}
	
	@DataProvider(name="wrongPwd")
	public static Object[][] data(){
		Object[][] dataArr =  
				new Object[][] {{"pro_tes@126.com", "123123"}, {"pro_tes@126.com", "111111"}, {"pro_tes@126.com", "123123"}};
		return dataArr;
	}
	
	@DataProvider(name="my")
	public static Object[][] data1(){
		JsonUtil jsonUtil = new JsonUtil();
		List<HashMap<String, String>> dataList = 
				jsonUtil.getDataList("testdata/testdata.json", "testLoginFailWithWrongPwd");
		
		int outLen = dataList.size();
		int inLen = dataList.get(0).size();
		
		Object[][] resData = new Object[outLen][inLen];
		
		for(int i = 0 ; i < outLen ; i++) {
			HashMap<String, String> data = dataList.get(i);
			String username = data.get("username");
			String password = data.get("password");
			resData[i][0] = username;
			resData[i][1] = password;
		}
		return resData;
	}
	
	@DataProvider(name="my1")
	public static Object[][] data2(){
		JsonUtil jsonUtil = new JsonUtil();
		List<HashMap<String, String>> dataList = 
				jsonUtil.getDataList("testdata/testdata.json", "testLoginSuccess");
		
		int outLen = dataList.size();
		int inLen = dataList.get(0).size();
		
		Object[][] resData = new Object[outLen][inLen];
		
		for(int i = 0 ; i < outLen ; i++) {
			HashMap<String, String> data = dataList.get(i);
			String username = data.get("username");
			String password = data.get("password");
			resData[i][0] = username;
			resData[i][1] = password;
		}
		return resData;
	}
	
	
	@Test(dataProvider="my")
	public void testLoginFailWithWrongPwd(String username, String password) {
		if (homePageHandle.isSwitchCityDiaBoxDisplayed()) {
			homePageHandle.closeSwitchCityDiaBox();
		}
		homePageHandle.clickLoginBtn();
		Assert.assertEquals(loginPageHandle.isInLoginPage(), true, "进入登录页面失败了!");
		lBus.login(username, password);
		
		// 判断当前页面还是不是登录页面，若不是则测试失败
		Assert.assertEquals(loginPageHandle.isInLoginPage(), true, "测试失败，当前已经不是登录页面了！");
		Assert.assertEquals(loginPageHandle.getWrongPwdTipText(), "帐号和密码不匹配", "密码错误但是提示信息有误");
	}
	
	
	@AfterMethod
	public void aMethod() {
		hp.goToHomePage();
		if (homePageHandle.isLoginSuccess()) {
			lBus.logout();
		}
	}
	
	@AfterClass
	public void aClass() {
		
	}

}
