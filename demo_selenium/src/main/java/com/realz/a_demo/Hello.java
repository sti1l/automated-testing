package com.realz.a_demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 测试驱动和浏览器版本
 * @author sti1l
 *
 */
public class Hello {
	public static void main(String[] args) {
		// 如果配置环境变量运行异常，则用这种策略加载驱动
		// System.setProperty("webdriver.chrome.driver", "Z:/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://www.baidu.com");

		String title = driver.getTitle();
		System.out.printf(title);

		driver.close();
	}
}
