package com.realz.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

import com.realz.analyzer.MyRetryAnalyzer;

public class RetryListener implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer iRetryAnalyzer = annotation.getRetryAnalyzer();
		System.out.println("transform(),iRetryAnalyzer:" + iRetryAnalyzer);
		if (iRetryAnalyzer == null) {
			annotation.setRetryAnalyzer(MyRetryAnalyzer.class);
		}
	}

}
