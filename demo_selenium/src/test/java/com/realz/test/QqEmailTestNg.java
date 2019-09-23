package com.realz.test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.realz.base.BaseTestNG;
import com.realz.listener.RetryListener;
import com.realz.page.QQEmailPage;

/**
 * QQ邮箱测试用例
 * 
 * @author realz
 *
 */
public class QqEmailTestNg extends BaseTestNG {

	@Test(priority = 1) // priority 指定方法的执行顺序，数值越小，越靠前执行
	public void qq_email_login() {
		driver = new ChromeDriver();

		QQEmailPage myPage = PageFactory.initElements(driver, QQEmailPage.class);
		driver.get("https://mail.qq.com/");

		// 窗口最大化
		driver.manage().window().maximize();

		// 跳转登录frame
		driver.switchTo().frame("login_frame");

		// [0,2]随机数
		int computer = (int) (Math.random() * 3);

		assertEquals("1", String.valueOf(computer));

		// 账户
		myPage.u_send_username("386654748@qq.com");
		// 密码
		myPage.p_send_pwd("fsj,404");
		// 点击登录
		myPage.login_button_click();

	}

}
