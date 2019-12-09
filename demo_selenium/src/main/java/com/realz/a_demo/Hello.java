package com.realz.a_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		// 那你演示，拿到百度的这个框 很好
		// 那我让你看一下这样的
		// 我们猜测肯定是一个的不用看
		// 看到没 
		// 如果你不喜欢花里胡哨的 你一顿 xpath定位就可以拉 谷歌浏览器现在很智能很好
		String title = driver.getTitle();
		System.out.printf(title);
		WebElement e_u = driver.findElement(By.xpath("//*[@id=\"kw\"]"));
		e_u.sendKeys("realz");
		WebElement e_button = driver.findElement(By.id("su"));
		e_button.click();
		try {
			Thread.sleep(20000000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
}
