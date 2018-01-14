package com.ui.test.eric.eric_selenium.page;

import org.openqa.selenium.WebElement;

import com.ui.test.eric.eric_selenium.utils.GetBy;

public class MyCVPage extends BasePage{

	String myCV_file_path = "pages/myCV.properties";
	
	public WebElement getUserInfoDivContainer() {
		return find_element(GetBy.getBy(myCV_file_path, "myCV.user.info.div.container"));
	}
	
	public WebElement getUserInfoEditBtn() {
		return find_element(GetBy.getBy(myCV_file_path, "myCV.user.info.edit.btn"));
	}
	
	public WebElement getPhoneInput() {
		return find_element(GetBy.getBy(myCV_file_path, "myCV.user.info.phone.input"));
	}
	
	public WebElement getUserInfoSaveBtn() {
		return find_element(GetBy.getBy(myCV_file_path, "myCV.user.info.save.btn"));
	}
	
	public WebElement getUserInfoPhone() {
		return find_element(GetBy.getBy(myCV_file_path, "myCV.user.info.communication.phone"));
	}
	
	public WebElement getUserAvator() {
		return find_element(GetBy.getBy(myCV_file_path, "myCV.user.head.avatar"));
	}
}
