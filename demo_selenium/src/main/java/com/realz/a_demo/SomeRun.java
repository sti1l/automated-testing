package com.realz.a_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.mail.MessagingException;

import com.realz.util.EmailUtil;

public class SomeRun {

	public static void main(String[] args) {
		// ZipUtil.delete("target/surefire-reports/surefire-reports.zip");
		// ZipUtil.zipFile("target/surefire-reports",
		// "target/surefire-reports/surefire-reports.zip");
		/*
		 * EmailUtil.entity(smtpHost, sendUserName, sendUserPass, to, cc, mailSubject,
		 * mailBody, attachments); EmailUtil.sendEmail();
		 */

		sendEmail();
	}

	public static void sendEmail() {

		String userName = "386654748@qq.com"; // 发件人邮箱  
		String password = "wwlsyhemdaozbjdg"; // 发件人密码  
		String smtpHost = "smtp.qq.com"; // 邮件服务器    
		String to = "1047307211@qq.com"; // 收件人，多个收件人以半角逗号分隔  
		String cc = ""; // 抄送，多个抄送以半角逗号分隔  
		String subject = "测试"; // 主题
		String body = "ceshiyouxiang";// GenerateReport.returnResult(); // 正文，可以用html格式的哟  
		// 附件的路径，多个附件也不怕  
		String ReportPath = "Z:/test git/automated-testing/demo_selenium/target/surefire-reports/surefire-reports.zip";
		List<String> attachments = new ArrayList<String>();
		
		attachments.add(ReportPath); 
		
		//attachments.add(screenshotPath);
		 

		EmailUtil email = EmailUtil.entity(smtpHost, userName, password, to, cc, subject, body, attachments);
		try {
			email.send();// 发送
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
