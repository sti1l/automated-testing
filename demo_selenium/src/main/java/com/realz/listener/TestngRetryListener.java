package com.realz.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.realz.base.BaseTestNG;
import com.realz.util.ScreenShotUtil;
import com.realz.util.ZipUtil;

public class TestngRetryListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

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
			ssu.takeScreenShot();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

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
		ZipUtil.delete("D:\\JHT\\工作空间\\new jht ws\\demo_selenium\\target\\surefire-reports/surefire-reports.zip");
		ZipUtil.zipFile("D:\\JHT\\工作空间\\new jht ws\\demo_selenium\\target\\surefire-reports", "D:\\JHT\\工作空间\\new jht ws\\demo_selenium\\target\\surefire-reports/surefire-reports.zip");
	}

}
