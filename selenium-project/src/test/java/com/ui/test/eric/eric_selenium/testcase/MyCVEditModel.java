package com.ui.test.eric.eric_selenium.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.test.eric.eric_selenium.business.LoginBus;
import com.ui.test.eric.eric_selenium.driver.DriverBase;
import com.ui.test.eric.eric_selenium.handle.HomePageHandle;
import com.ui.test.eric.eric_selenium.handle.LoginPageHandle;
import com.ui.test.eric.eric_selenium.handle.MyCVPageHandle;
import com.ui.test.eric.eric_selenium.page.HomePage;

public class MyCVEditModel extends BaseCase{

	private MyCVPageHandle myCVPageHandle;
	private HomePageHandle homePageHandle;
	private LoginPageHandle loginPageHandle;
	private HomePage homePage;
	private LoginBus lbus;
	
	public MyCVEditModel() {
		System.out.println("执行了MyCVEditModel 的构造方法！");
	}
	
	@BeforeClass
	public void bClass() {
		System.out.println("执行 修改用户信息 测试类的beforeCalss 方法");
		initDriver();
		System.out.println(DriverBase.getDriver().toString());
		myCVPageHandle = new MyCVPageHandle();
		homePageHandle = new HomePageHandle();
		loginPageHandle = new LoginPageHandle();
		homePage = new HomePage();
		lbus = new LoginBus();
	}
	
	@BeforeMethod
	public void bMethod() {
		homePage.goToHomePage();
		Assert.assertEquals(homePageHandle.isInHomePage(), true, "当前不是首页");
		if (homePageHandle.isSwitchCityDiaBoxDisplayed()) {
			homePageHandle.closeSwitchCityDiaBox();
		}
		homePageHandle.clickLoginBtn();
		lbus.loginSuc("pro_tes@126.com", "******");
	}
	
	@Test
	public void testUpdateUserPhone() {
		homePageHandle.clickMyCVBtn();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(myCVPageHandle.isInMyCVPage(), true, "进入个人简历页面失败");
		myCVPageHandle.clickUserInfoEditBtn();
		myCVPageHandle.inputPhone("18628460871");
		myCVPageHandle.clickUserInfoSaveBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String userphone = myCVPageHandle.getUserPhone();
		Assert.assertEquals(userphone, "18628460871", "修改的号码不一致，修改失败");
	}
	
	@AfterMethod
	public void aMethod() {
		homePage.goToHomePage();
		if (homePageHandle.isLoginSuccess()) {
			lbus.logout();
		}
	}
	
	@AfterClass
	public void aClass() {
		
	}
}
