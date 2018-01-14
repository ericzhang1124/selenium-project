package com.ui.test.eric.eric_selenium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class PropUtils {

	private Properties properties = new Properties();
	
	public PropUtils(String filePath) {
		loadFile(filePath);
	}
	
	public String getProp(String key) {
		return properties.getProperty(key);
	}
	
	private void loadFile(String filePath) {
		File file = new File(filePath);
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader bReader = null;
		
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			bReader = new BufferedReader(isr);
			
			properties.load(bReader);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (bReader != null) {
				try {
					bReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
