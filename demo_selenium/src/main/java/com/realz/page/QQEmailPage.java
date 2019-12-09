package com.realz.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.realz.base.BasePage;

/**
 * QQ邮箱登录
 * @author realz
 *
 */
public class QQEmailPage extends BasePage {

	public QQEmailPage(WebDriver driver) {
		super(driver);
	}

	// 账号输入框
	@FindBy(id = "u")
	private WebElement u_Element;

	// 密码输入框
	@FindBy(id = "p")
	private WebElement p_Element;

	// “登录”按钮
	@FindBy(id = "login_button")
	private WebElement su_Element;

	// 输入账号
	public void u_send_username(String u) {
		this.sendkeys(u_Element, u);
	}

	// 输入密码
	public void p_send_pwd(String p) {
		this.sendkeys(p_Element, p);
	}
	
	// 点击“登录”按钮
	public void login_button_click() {
		this.click(su_Element);
	}

}
