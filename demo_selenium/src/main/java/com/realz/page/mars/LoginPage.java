package com.realz.page.mars;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.realz.base.BasePage;

/**
 * 登录
 * 
 * @author realz
 *
 */
public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
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
}
