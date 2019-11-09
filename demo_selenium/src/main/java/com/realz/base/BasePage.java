package com.realz.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 根据以往经验，UI自动化测试很容易出现找到不对象的情况，所以在操作之前必须判断对象是否存在， java 和
 * python一样有隐式等待和显式等待，我们选择使用更加稳妥的显式等待。Java显式等待使用的是
 * new WebDriverWait(driver,10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("css locator"))); 
 * 也就是说要在定位元素的时候加入这两个类作为等待条件，直到目标元素出现为止。 但是如果每一个元素都这么写的话就有很多冗余代码了，
 * 所以我们写了个公共类BasePage.java，重写了click事件和sendkeys事件
 * 
 * @author realz
 *
 */
public class BasePage {

	WebDriver driver;
	private final int timeOut = 10;	// 等待时间

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	

	/**
	 * 重写senkeys方法
	 * 
	 * @param element
	 * @param s
	 */
	public void sendkeys(WebElement element, String s) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element)); // 加入显式等待
		element.clear(); // 先清空输入框
		element.sendKeys(s);// 输入数据
	}

	/**
	 * 重写click方法
	 * 
	 * @param element
	 */
	public void click(WebElement element) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element)); // 加入显式等待
		element.click();
	}
	
	/**
	 * 重写getText方法
	 * @param element
	 */
	public String getText(WebElement element) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element)); // 加入显式等待
		return element.getText();
	}
	
	/**
	 * 重写getAttribute方法
	 * @param element
	 */
	public String getAttribute(WebElement element) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element)); // 加入显式等待
		return element.getAttribute("value");
	}

}
