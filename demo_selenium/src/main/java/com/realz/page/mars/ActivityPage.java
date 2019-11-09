package com.realz.page.mars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.realz.base.BasePage;

public class ActivityPage extends BasePage {

	public ActivityPage(WebDriver driver) {
		super(driver);
	}

	// 用户名输入框
	@FindBy(id = "UserAccount")
	private WebElement userAccount_Element;

	// 密码输入框
	@FindBy(id = "UserPassword")
	private WebElement userPassword_Element;

	// 登陆按钮
	@FindBy(id = "login_btn")
	private WebElement login_btn_Element;

	// 语言切换下拉, 中文项
	@FindBy(xpath = ".//*[@id='Login_Language']/option[2]")
	private WebElement login_Language_cn_Element;

	// 登录后右上角展示的用户名
	@FindBy(className = "LoginName")
	private WebElement loginName_Element;

	// 输入用户名
	public void userAccount_sendkes(String userAccount) {
		this.sendkeys(userAccount_Element, userAccount);
	}

	// 输入用密码
	public void userPassword_sendkes(String userPassword) {
		this.sendkeys(userPassword_Element, userPassword);
	}

	// 获取右上角已登录用户名
	public String get_LoginName() {
		return this.getText(loginName_Element);
	}

	// 点击中文下拉选项
	public void login_Language_cn_click() {
		this.click(login_Language_cn_Element);
	}

	// 点击登录按钮
	public void login_btn_click() {
		this.click(login_btn_Element);
	}

	// 活动计划
	@FindBy(xpath = "//*[@id=\"LAY-system-side-menu\"]/li[2]/a")
	private WebElement activity_plan_element;

	// 活动计划列表
	@FindBy(xpath = "//*[@id=\"LAY-system-side-menu\"]/li[2]/dl/dd[2]/a")
	private WebElement activity_plan_list_element;

	// 审批中
	@FindBy(xpath = "//*[@id=\"tabUL\"]/li[2]")
	private WebElement spz_element;

	// 复制
	@FindBy(xpath = "//*[@id=\"LAY_app_body\"]/div/div/div[2]/div[2]/div/div/div[2]/div/div[1]/div[4]/div[2]/table/tbody/tr[2]/td/div/a[3]")
	private WebElement copy_element;

	// 活动名称输入框
	@FindBy(id = "inputActivityName")
	private WebElement inputActivityName_element;

	// 点击活动计划列表连接
	public void activity_plan_list_click() {
		this.click(activity_plan_list_element);
	}

	// 点击活动计划连接
	public void activity_plan_click() {
		this.click(activity_plan_element);
	}

	// 点击审批中
	public void spz_click() {
		this.click(spz_element);
	}

	// 点击复制活动
	public void copy_activity_click() {
		this.click(copy_element);
	}

	// 活动名称输入框内容填充
	public void inputActivityName_sendkeys(String s) {
		this.sendkeys(inputActivityName_element, s);
	}

	// 活动名称输入框内容获取
	public String get_inputActivityName() {
		return this.getText(inputActivityName_element);
	}

	public String get_activity_plan_list() {
		return this.getText(activity_plan_list_element);
	}

}
