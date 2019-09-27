package com.realz.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static ChromeDriver cdriver;

	private static FirefoxDriver fdriver;

	public static WebDriver getDriver() {

		String driverType = ConfigUtil.getString("DriverType");

		switch (driverType) {
		case "chrome":
			cdriver = new ChromeDriver();
			return cdriver;
		case "firefox":
			fdriver = new FirefoxDriver();
			return fdriver;

		default:
			break;
		}

		return null;
	}

}
