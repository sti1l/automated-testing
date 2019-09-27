package com.realz.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.realz.base.BaseTestNG;
import com.realz.util.ScreenShotUtil;

/**
 * TestNG用例监听
 * @author realz
 *
 */
public class MyTestListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			
			BaseTestNG instance = (BaseTestNG) result.getInstance();
			ScreenShotUtil ssu = new ScreenShotUtil(instance.driver);
			// 截图
			ssu.takeScreenShot();
			// 关闭浏览器
			instance.driver.quit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// 重试自动退出浏览器
		BaseTestNG instance = (BaseTestNG) result.getInstance();
		instance.driver.close();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}
	
}
