package com.realz.util;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

public class SendReportToEmailUtil {

	private final static String reportpath = "Z:/test git/automated-testing/demo_selenium/target";

	public static void main(String[] args) {
		System.err.println("Realz：发送邮件方法执行了");
		sendReport();
	}

	/**
	 * 发送邮件
	 */
	public static void sendReport() {
		// 压缩测试报告
		ZipUtil.delete(reportpath + "/" + "surefire-reports.zip");
		ZipUtil.zipFile(reportpath + "/surefire-reports/", reportpath + "/" + "surefire-reports.zip");
		ZipUtil.delete(reportpath + "/" + "surefire-reports");
		// 压缩错误截图
		ZipUtil.delete(reportpath + "/" + "screen-shot.zip");
		ZipUtil.zipFile(reportpath + "/screen-shot/", reportpath + "/" + "screen-shot.zip");
		ZipUtil.delete(reportpath + "/" + "screen-shot");
		
		// 发送邮件
		String userName = ConfigUtil.getString("USERNAME"); // 发件人邮箱  
		String password = ConfigUtil.getString("PASSWORD"); // 发件人密码  
		String smtpHost = ConfigUtil.getString("SMTPHOST"); // 邮件服务器    
		String to = ConfigUtil.getString("TO"); // 收件人，多个收件人以半角逗号分隔  
		String cc = ConfigUtil.getString("CC"); // 抄送，多个抄送以半角逗号分隔  
		String subject = "测试报告"; // 主题
		String body = "测试报告在附件中，请查收"; // 正文，可以用html格式的哟  
		
		List<String> attachments = new ArrayList<String>();// 附件的路径，多个附件也不怕  
		String reportPath = reportpath + "/" + "surefire-reports.zip";
		String screenShortPath = reportpath + "/" + "screen-shot.zip";
		attachments.add(reportPath);
		attachments.add(screenShortPath);

		EmailUtil email = EmailUtil.entity(smtpHost, userName, password, to, cc, subject, body, attachments);
		
		try {
			email.send();// 发送
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
