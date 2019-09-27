package com.realz.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * 截屏工具类
 * 
 * @author realz
 *
 */
public class ScreenShotUtil {

	WebDriver driver;

	public ScreenShotUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static final String SCREEN_SHOT_PATH = "screen-shot"; // 截图目录

	/**
	 * 截图
	 * 
	 * @param driver
	 * @throws IOException
	 */
	public void takeScreenShot() throws IOException {
		File screenshotDir = new File(SCREEN_SHOT_PATH);
		if (!screenshotDir.exists()) {
			screenshotDir.mkdirs();
		}
		SimpleDateFormat smf = new SimpleDateFormat("yyyyMMddHHmmss");
		String SCREEN_SHOT_NAME = String.valueOf(smf.format(new Date())) + ".jpg";
		FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE),
				new File(SCREEN_SHOT_PATH + "/" + SCREEN_SHOT_NAME));
	}
}
