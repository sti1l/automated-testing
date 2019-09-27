package com.realz.base;

import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.openqa.selenium.WebDriver;

import com.realz.util.EmailUtil;
import com.realz.util.ZipUtil;

public class BaseTestNG {

	public WebDriver driver;

	public static void sendReport() {
		// 删除已存在的报告
		ZipUtil.delete("Z:/test git/automated-testing/demo_selenium/target/surefire-reports/surefire-reports.zip");
		// 压缩报告
		ZipUtil.zipFile("Z:/test git/automated-testing/demo_selenium/target/surefire-reports",
				"Z:/test git/automated-testing/demo_selenium/target/surefire-reports/surefire-reports.zip");
		// 发送邮件
		String userName = "386654748@qq.com"; // 发件人邮箱  
		String password = "wwlsyhemdaozbjdg"; // 发件人密码  
		String smtpHost = "smtp.qq.com"; // 邮件服务器    
		String to = "1047307211@qq.com"; // 收件人，多个收件人以半角逗号分隔  
		String cc = "386654748@qq.com"; // 抄送，多个抄送以半角逗号分隔  
		String subject = "测试报告"; // 主题
		String body = "测试报告在附件中，请注意查收";// GenerateReport.returnResult(); // 正文，可以用html格式的哟  
		// 附件的路径，多个附件也不怕  
		String ReportPath = "Z:/test git/automated-testing/demo_selenium/target/surefire-reports/surefire-reports.zip";
		List<String> attachments = new ArrayList<String>();
		attachments.add(ReportPath);

		// attachments.add(screenshotPath);

		EmailUtil email = EmailUtil.entity(smtpHost, userName, password, to, cc, subject, body, attachments);
		try {
			email.send();// 发送
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
