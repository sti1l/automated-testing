package com.realz.util;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件读取工具类
 * 
 * @author realz
 *
 */
public class ConfigUtil {

	private static Properties p = new Properties();
	static {
		try {
			// 加载配置文件
			p.load(ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据key获取int类型的值
	 * 
	 * @param key
	 * @return
	 */
	public static int getInt(String key) {
		return Integer.parseInt(p.getProperty(key));
	}

	/**
	 * 根据key获取String类型的值
	 * 
	 * @param key
	 * @return
	 */
	public static String getString(String key) {
		return p.getProperty(key);
	}

	/**
	 * 根据key获取double类型的值
	 * 
	 * @param key
	 * @return
	 */
	public static double getDouble(String key) {
		return Double.parseDouble(p.getProperty(key));
	}

}
