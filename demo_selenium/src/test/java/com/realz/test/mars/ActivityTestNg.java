package com.realz.test.mars;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.realz.base.BaseTestNG;
import com.realz.page.mars.ActivityPage;
import com.realz.util.WebDriverFactory;

/**
 * 活动用例
 * 
 * @author realz
 *
 */
public class ActivityTestNg extends BaseTestNG {

	private static String URL = "http://uat.ewit.com.cn:8000/Login.html"; // 网址
	private static String USERNAME = "jenny.tang"; // 用户名
	private static String PWD = "Mars123"; // 密码

	@Test(priority = 1)
	public void copyActivity() {
		try {

			driver = WebDriverFactory.getDriver();

			ActivityPage myPage = PageFactory.initElements(driver, ActivityPage.class);
			
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
			
			// 点击活动计划
			myPage.activity_plan_click();
			// 点击活动计划列表
			myPage.activity_plan_list_click();
			// 点击审批中
			myPage.spz_click();
			// 点击复制活动
			myPage.copy_activity_click();
				
			// 跳转拷贝活动frame
			driver.switchTo().frame("layui-layer-iframe12");
			
			// 获取活动名称中文本内容
			myPage.inputActivityName_sendkeys("1111");
			//System.err.println("活动名称: " + activityName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}