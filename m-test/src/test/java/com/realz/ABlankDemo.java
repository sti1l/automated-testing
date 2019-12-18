package com.realz;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 点击跳转新页面 ------ 京东商城为例, 添加秒杀第一个商品, 到购物车
 * 
 * @author sti1l
 *
 */
public class ABlankDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		// 打开京东商城首页
		driver.get("https://www.jd.com/");

		// 获取秒杀列表的第一个商品并点击
		WebElement J_seckill_a_element = driver
				.findElement(By.xpath("//*[@id=\"J_seckill\"]/div/div/div[1]/div/div/div/a[1]"));
		J_seckill_a_element.click();
		
		// 获取第一个商品的名称

		Thread.sleep(1000);

		Set<String> windowHandles = null;
		// 判断当前窗口是否是第一个, 如果不是, 切换
		windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(windowHandle);
			}
		}
		
		// 校验商品名称
		
		// 点击立即抢购
		driver.findElement(By.xpath("//*[@id=\"super_seckill\"]/div/ul/li[1]/div/a")).click();

		Thread.sleep(1000);

		// 判断当前窗口是否是第一个, 如果不是, 切换
		windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(driver.getWindowHandle())) {
				driver.switchTo().window(windowHandle);
			}
		}
		
		// 校验商品名称
		
		// 点击加入购物车
		driver.findElement(By.id("InitCartUrl")).click();
	}
}
