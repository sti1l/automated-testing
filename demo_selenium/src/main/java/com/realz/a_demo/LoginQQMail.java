package com.realz.a_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.realz.util.ConfigUtil;

/**
 * 登陆qq邮箱
 * @author sti1l
 *
 */
public class LoginQQMail {
	
	// 邮箱地址
	private final static String QQ_MAIL_URL = "https://mail.qq.com/";
	// 账号
	public static String ACCOUNT = ConfigUtil.getString("ACCOUNT"); 
	// 密码
	public static String PASSWORD = ConfigUtil.getString("PASSWORD");; 
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get(QQ_MAIL_URL);
		
		// 跳转登录frame
		driver.switchTo().frame("login_frame");
		
		// 获取账号输入框，填账号
		WebElement e_u = driver.findElement(By.name("u"));
		e_u.sendKeys(ACCOUNT);
		
		// 等待时间，单位ms
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// 获取密码输入框，填密码
		WebElement e_p = driver.findElement(By.name("p"));
		e_p.sendKeys(PASSWORD);
		
		// 获取登录按钮，点击
		WebElement e_login_button = driver.findElement(By.id("login_button"));
		e_login_button.click();
		
		// 关闭浏览器
		// driver.close();
		
	}

}
