package com.realz.analyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * 设置testng用例失败重试次数
 *@author realz 
 */
public class MyRetryAnalyzer implements IRetryAnalyzer {

    private int retryCount = 0;
    private final int MAX_RETRY_COUNT = 0;	// 重试次数

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            return true;
        }
        return false;
    }
}
