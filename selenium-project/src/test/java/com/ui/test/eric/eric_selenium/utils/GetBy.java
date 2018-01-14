package com.ui.test.eric.eric_selenium.utils;

import org.openqa.selenium.By;

public class GetBy {

	public static By getBy(String filePath, String key) {
		PropUtils propUtils = new PropUtils(filePath);
		String locatorInfo = propUtils.getProp(key);
		
		String[] infos = locatorInfo.split(">");
		String locatorType = infos[0];
		String locatorValue = infos[1];
		
		if (locatorType.equals("id")) {
			return By.id(locatorValue);
		}else if (locatorType.equals("name")) {
			return By.name(locatorValue);
		}else if (locatorType.equals("className")) {
			return By.className(locatorValue);
		}else if(locatorType.equals("xpath")){
			return By.xpath(locatorValue);
		}else if (locatorType.equals("tagName")) {
			return By.tagName(locatorValue);
		}else if (locatorType.equals("linkText")) {
			return By.linkText(locatorValue);
		}else if (locatorType.equals("partialLinkText")) {
			return By.partialLinkText(locatorValue);
		}
		return null;
		
	}
}
