package com.realz.a_demo;

import com.realz.util.ZipUtil;

public class SomeRun {
	
	public static void main(String[] args) {
		// ZipUtil.delete("target/surefire-reports/surefire-reports.zip");
		ZipUtil.zipFile("target/surefire-reports", "target/surefire-reports/surefire-reports.zip");
	}

}
