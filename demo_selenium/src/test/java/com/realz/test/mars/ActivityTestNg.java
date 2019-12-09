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
	
	private final static String URL = "http://192.168.1.37:6610/Login.html"; // 网址
	private final static String USERNAME = "jenny.tang"; // 用户名
	private final static String USERNAME_SP1 = "sissy.zeng"; // 用户名
	private final static String USERNAME_SP2 = "sandy.liu"; // 用户名
	private final static String USERNAME_SP3_1 = "ling.wu"; // 用户名
	private final static String USERNAME_SP3_2 = "karol.zhang"; // 用户名
	private final static String PWD = "Mars123"; // 密码
	private final static int SIZE = 200; // 复制 审批条数(自行修改)
	
	/**
	 * 复制活动
	 */
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
			
			Thread.sleep(500);
			// 点击活动计划
			myPage.activity_plan_click();
			Thread.sleep(500);
			// 点击活动计划列表
			myPage.activity_plan_list_click();
			
			Thread.sleep(1000);
			
			// 点击审批中
			myPage.spz_click();
			
			int j = 0;
			
			// 活动名称
			String inputActivityName = null;
			
			// 多少条数据就循环多少次
			for (int i = 1; i <= SIZE; i++) {
				
				Thread.sleep(1000);
			
				// 点击复制活动
				myPage.copy_activity_click();
				
				Thread.sleep(1000);
				
				// iframe 动态id构造
				j = 11 + i;
				
				// 跳转拷贝活动frame
				driver.switchTo().frame("layui-layer-iframe" + j);
				
				// 获取活动名称中文本内容
				if (inputActivityName == null) {
					inputActivityName = myPage.get_inputActivityName();
					System.err.println("realz: 活动名称-》" + inputActivityName);
				}
				
				// 加流水填充
				myPage.inputActivityName_sendkeys(inputActivityName + "-" + i);
				
				Thread.sleep(2000);
				
				// 点击提交
				myPage.btnSubmit_click();
				
				Thread.sleep(2000);
				
				// 点击关闭
				// myPage.btnClose_click();
				
				// 点击确定
				myPage.qd_click();
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 审批1
	 */
	@Test(priority = 2)
	public void sp1() {
		try {

			driver = WebDriverFactory.getDriver();

			ActivityPage myPage = PageFactory.initElements(driver, ActivityPage.class);
			
			driver.get(URL);

			// 窗口最大化
			driver.manage().window().maximize();
			// 切换语言
			myPage.login_Language_cn_click();
			// 账户
			myPage.userAccount_sendkes(USERNAME_SP1);
			// 密码
			myPage.userPassword_sendkes(PWD);
			// 点击登录
			myPage.login_btn_click();
			
			Thread.sleep(500);
			
			int j = 0;
			
			// 多少条数据就循环多少次
			for (int i = 1; i <= SIZE; i++) {
				
				Thread.sleep(1000);
			
				// 点击操作-审批
				myPage.sp_click();
				
				Thread.sleep(1000);
				
				// iframe 动态id构造
				j = 8 + i;
				
				// 跳转拷贝活动frame
				driver.switchTo().frame("layui-layer-iframe" + j);
				
				// 点击同意
				myPage.btnApprove_click();
				
				Thread.sleep(2000);
				
				// 点击confirm
				myPage.confirm_click();
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * 审批2
	 */
	@Test(priority = 3)
	public void sp2() {
		try {

			driver = WebDriverFactory.getDriver();

			ActivityPage myPage = PageFactory.initElements(driver, ActivityPage.class);
			
			driver.get(URL);

			// 窗口最大化
			driver.manage().window().maximize();
			// 切换语言
			myPage.login_Language_cn_click();
			// 账户
			myPage.userAccount_sendkes(USERNAME_SP2);
			// 密码
			myPage.userPassword_sendkes(PWD);
			// 点击登录
			myPage.login_btn_click();
			
			Thread.sleep(500);
			
			int j = 0;
			
			// 多少条数据就循环多少次
			for (int i = 1; i <= SIZE; i++) {
				
				Thread.sleep(1000);
			
				// 点击操作-审批
				myPage.sp_click();
				
				Thread.sleep(1000);
				
				// iframe 动态id构造
				j = 8 + i;
				
				// 跳转拷贝活动frame
				driver.switchTo().frame("layui-layer-iframe" + j);
				
				// 点击同意
				myPage.btnApprove_click();
				
				Thread.sleep(2000);
				
				// 点击confirm
				myPage.confirm_click();
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	@Test(priority = 4)
	public void sp3_1() {
		try {

			driver = WebDriverFactory.getDriver();

			ActivityPage myPage = PageFactory.initElements(driver, ActivityPage.class);
			
			driver.get(URL);

			// 窗口最大化
			driver.manage().window().maximize();
			// 切换语言
			myPage.login_Language_cn_click();
			// 账户
			myPage.userAccount_sendkes(USERNAME_SP3_1);
			// 密码
			myPage.userPassword_sendkes(PWD);
			// 点击登录
			myPage.login_btn_click();
			
			Thread.sleep(500);
			
			int j = 0;
			
			// 多少条数据就循环多少次
			for (int i = 0; i <= SIZE; i++) {
				
				Thread.sleep(1000);
			
				// 点击操作-审批
				myPage.sp_click();
				
				Thread.sleep(1000);
				
				// iframe 动态id构造
				j = 9 + i;
				
				// 跳转拷贝活动frame
				driver.switchTo().frame("layui-layer-iframe" + j);
				
				// 点击同意
				myPage.btnApprove_click();
				
				Thread.sleep(2000);
				
				// 点击confirm
				myPage.confirm_click();
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test(priority = 5)
	public void sp3_2() {
		try {

			driver = WebDriverFactory.getDriver();

			ActivityPage myPage = PageFactory.initElements(driver, ActivityPage.class);
			
			driver.get(URL);

			// 窗口最大化
			driver.manage().window().maximize();
			// 切换语言
			myPage.login_Language_cn_click();
			// 账户
			myPage.userAccount_sendkes(USERNAME_SP3_2);
			// 密码
			myPage.userPassword_sendkes(PWD);
			// 点击登录
			myPage.login_btn_click();
			
			Thread.sleep(500);
			
			int j = 0;
			
			// 多少条数据就循环多少次
			for (int i = 1; i <= SIZE; i++) {
				
				Thread.sleep(1000);
			
				// 点击操作-审批
				myPage.sp_click();
				
				Thread.sleep(1000);
				
				// iframe 动态id构造
				j = 8 + i;
				
				// 跳转拷贝活动frame
				driver.switchTo().frame("layui-layer-iframe" + j);
				
				// 点击同意
				myPage.btnApprove_click();
				
				Thread.sleep(2000);
				
				// 点击confirm
				myPage.confirm_click();
			}
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
