package com.realz.test.mars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.realz.base.BaseTestNG;
import com.realz.page.mars.CreateActivityPage;
import com.realz.page.mars.LoginPage;
import com.realz.util.WebDriverFactory;
import com.realz.test.mars.LoginTestNG;

/**
 * 创建活动用例
 * 
 * @author realz
 *
 */
public class CreateActivity extends BaseTestNG {
	private static String URL = "http://192.168.1.37:6610/Login.html"; // 网址
	private static String USERNAME = "jenny.tang"; // 用户名
	private static String PWD = "Mars123"; // 密码

	/**
	 * 创建活动
	 * 
	 * @throws Exception
	 */
	@Test(priority = 1)
	public void createActivityTest() throws Exception {
		
		driver = WebDriverFactory.getDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		
		// 登录
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		LoginTestNG.loginMuain(driver, loginPage, USERNAME, PWD);
		
		CreateActivityPage myPage = PageFactory.initElements(driver, CreateActivityPage.class);
		Thread.sleep(500);
		// 点击活动计划
		myPage.activity_plan_click();
		Thread.sleep(500);
		// 点击活动计划列表
		myPage.activity_plan_list_click();

		Thread.sleep(1000);
        
		//点击创建按钮
		myPage.add_activity_click();
		Thread.sleep(1000);
		
		// 跳转iframe
		driver.switchTo().frame("layui-layer-iframe12");
		
		// 加流水填充
		myPage.inputActivityName_sendkeys("xfTest112206");
		
		Thread.sleep(1000);
		
		myPage.segment_click();
		
		//输入活动目的
		myPage.inputActivityObjective("活动目的");
		
		//输入活动机制
		myPage.inputActivityMechanisam("活动机制");
		
		//选择活动开始时间
		myPage.inputActivityStartDate("2019-11-14 00:00:00.000");
		
		//选择活动结束时间
		myPage.inputActivityEndDate("2019-11-14 00:00:00.000");
		
		//
		
		// 点击保存草稿
		myPage.draft_click();

		Thread.sleep(2000);
	}



}
