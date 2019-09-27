package com.realz.util;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常信息处理工具类
 * @author realz
 *
 */
public class ExceptionOutUtil {

	/**
	 * 获取堆栈中的异常信息
	 * 
	 * @param t
	 * @return
	 */
	public static String getTrace(Throwable t) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		t.printStackTrace(writer);
		StringBuffer buffer = stringWriter.getBuffer();
		return buffer.toString();
	}
}
