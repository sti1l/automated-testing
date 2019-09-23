package com.realz.test;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.realz.base.BaseTestNG;
import com.realz.page.BaiduPage;

/**
 * 百度搜索测试用例
 * 
 * @author realz
 *
 */
public class BaiduTestNg extends BaseTestNG {

	@BeforeClass // @BeforeSuite->@BeforeTest->@BeforeClass->{@BeforeMethod->@Test->@AfterMethod}->@AfterClass->@AfterTest->@AfterSuite
					// 其中{}内的与多少个@Test，就循环执行多少次。
	public void open() {
		driver = new ChromeDriver();
	}

	@Test(priority = 1) // priority 指定方法的执行顺序，数值越小，越靠前执行
	public void baidu_search() {
		BaiduPage myPage = PageFactory.initElements(driver, BaiduPage.class);
		driver.get("https://www.baidu.com");
		driver.manage().window().maximize();// 窗口最大化
		myPage.kw_sendkes("sti1l");
	}

	/*
	 * @Test(priority = 0) public void f2() { Assert.assertEquals("b", "b"); }
	 */

	@Test(priority = 2)
	public void f3() {
		BaiduPage myPage = PageFactory.initElements(driver, BaiduPage.class);
		myPage.kw_sendkes("");
		myPage.kw_sendkes("sti1l2");
		myPage.su_click();
	}

	@AfterClass
	public void close() {
		// driver.close();
	}
}
