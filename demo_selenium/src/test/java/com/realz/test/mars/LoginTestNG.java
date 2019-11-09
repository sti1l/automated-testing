package com.realz.test.mars;

import static org.junit.Assert.assertEquals;

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
	
	private static String URL = "http://uat.ewit.com.cn:8000/Login.html";	// 网址
	private static String USERNAME = "jenny.tang";	// 用户名
	private static String PWD = "Mars123";	// 密码

	@Test(priority = 1) // priority 指定方法的执行顺序，数值越小，越靠前执行
	public void qq_email_login() {

		driver = WebDriverFactory.getDriver();

		LoginPage myPage = PageFactory.initElements(driver, LoginPage.class);
		driver.get(URL);

		// 窗口最大化
		driver.manage().window().maximize();

		// 切换语言
		myPage.login_Language_cn_click();

		// 账户
		myPage.userAccount_sendkes(USERNAME);
		// 密码
		myPage.userPassword_sendkes(PWD);
		
		// 点击登录
		myPage.login_btn_click();
		
		// 获取右上角已登录用户名
		String loginName = myPage.get_LoginName();
		System.err.println(loginName);
		
		// 结果断言
		//assertEquals(USERNAME, loginName);
	}

}
