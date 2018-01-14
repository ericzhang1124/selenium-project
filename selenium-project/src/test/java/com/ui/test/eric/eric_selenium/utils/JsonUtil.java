package com.ui.test.eric.eric_selenium.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange.Map;


public class JsonUtil {

	/**
	 * 根据读取json文件路径，获取json字符串
	 * @param filePath
	 * @return
	 */
	private String getJsonStringFromFile(String filePath) {
		File file = new File(filePath);
		FileInputStream fis = null;
		BufferedReader br = null;
		StringBuilder sb = null;
		String resJson = "";
		try {
			fis = new FileInputStream(file);
			br = new BufferedReader(new InputStreamReader(fis));
			sb = new StringBuilder();
			String line;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			resJson = sb.toString();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resJson;
		
	}
	
	/**
	 * 根据文件路径和测试方法名，返回测试数据
	 * @param filePath
	 * @param methodName
	 * @return
	 */
	public List<HashMap<String, String>> getDataList(String filePath, String methodName){
		// 获取JSON字符串
		String jsonStr = new JsonUtil().getJsonStringFromFile(filePath);
		
		// JSON字符串转换为JSON对象
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);
		
		// 根据测试方法名称获取对应的测试数据JSON对象
		JSONObject jsonObject2 = jsonObject.getJSONObject(methodName);
		
		// 获取测试数据的外部 key值
		Set<String> items = jsonObject2.keySet();
		
		// 用来存放最终的返回值
		List<HashMap<String, String>> resList = new ArrayList<HashMap<String,String>>();
		
		// 遍历外部key值，获取单个测试数据对象， 把每个测试数据对象保存到一个临时Map然后添加到 List 容器中
		for (String item : items) {
			// 获取一条测试数据JSON对象， 内包含多个键值对
			JSONObject tempjson = jsonObject2.getJSONObject(item);
			HashMap<String, String> tempTestDataMap = new HashMap<String, String>();
			for(String key: tempjson.keySet()) {
				String value = tempjson.getString(key);
				tempTestDataMap.put(key, value);
			}
			resList.add(tempTestDataMap);
		}
		return resList;
	}
	
	
	
	
//	public static void main(String[] args) {
//		JsonUtil jsonUtil = new JsonUtil();
//		List<HashMap<String, String>> resList = 
//				jsonUtil.getDataList("testdata/testdata.json", "testLoginFailWithWrongPwd");
//		System.out.println(resList);
//		
//		
//		
//	}

}
