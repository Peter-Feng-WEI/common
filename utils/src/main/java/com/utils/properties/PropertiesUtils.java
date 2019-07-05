package com.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 获取属性的工具类
 * 
 * Created by feng.wei on 20170101.
 */
public class PropertiesUtils {
	private final static Log logger = LogFactory.getLog(PropertiesUtils.class);
	private final static Properties properties = new Properties();

	public static String getProperty(String key, String fileName) {

		InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			logger.info("解析  " + fileName);
		}
		return properties.getProperty(key);
	}
}
