package com.realz.test.mars;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.realz.base.BaseTestNG;
import com.realz.page.mars.LoginPage;
import com.realz.util.WebDriverFactory;

/**
 * 登录用例
 * 
 * @author realz
 *
 */
public class LoginTestNG extends BaseTestNG {
	
	private static String URL = "http://192.168.1.37:6610/Login.html";	// 网址
	private static String USERNAME = "jenny.tang";	// 用户名
	private static String PWD = "Mars123";	// 密码

	@Test(priority = 1) // priority 指定方法的执行顺序，数值越小，越靠前执行
	public void qq_email_login() {
		
		LoginPage myPage = PageFactory.initElements(driver, LoginPage.class);
		driver = WebDriverFactory.getDriver();

		String loginName = loginMuain(driver, myPage,USERNAME,PWD);
		System.err.println(loginName);
		
		// 结果断言
		// 假如这里的用户名不一致我会给你截图，并且重试三次
		// 防治是网络原因
		// 带你看报告
		assertEquals(USERNAME, 1);
		
		
	}
	
	/**
	 *  登录主逻辑
	 * @param driver 浏览器驱动
	 * @param myPage 元素页
	 * @param u	用户名
	 * @param p	密码
	 * @return
	 */
	public static String loginMuain(WebDriver driver, LoginPage myPage, String u, String p) {
		
		driver.get(URL);
		
		// 窗口最大化
		driver.manage().window().maximize();

		// 切换语言
		myPage.login_Language_cn_click();

		// 账户
		myPage.userAccount_sendkes(u);
		// 密码
		myPage.userPassword_sendkes(p);
		
		// 点击登录
		myPage.login_btn_click();
		
		// 获取右上角已登录用户名
		String loginName = myPage.get_LoginName();
		
		return loginName;
	}

}
