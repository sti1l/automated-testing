package com.realz.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

public class EmailUtil {

	private static String defaultSenderName = "";// 默认的发件人用户名，defaultEntity用得到  
	private static String defaultSenderPass = "";// 默认的发件人密码，defaultEntity用得到  
	private static String defaultSmtpHost = "";// 默认的邮件服务器地址，defaultEntity用得到

	private String smtpHost; // 邮件服务器地址  
	private String sendUserName; // 发件人的用户名  
	private String sendUserPass; // 发件人密码  

	private MimeMessage mimeMsg; // 邮件对象  
	private Session session;
	private Properties props;
	private Multipart mp;// 附件添加的组件  
	private List<FileDataSource> files = new LinkedList<FileDataSource>();// 存放附件文件  

	public static void sendEmail() {

		String userName = ""; // 发件人邮箱  
		String password = ""; // 发件人密码  
		String smtpHost = ""; // 邮件服务器    
		String to = ""; // 收件人，多个收件人以半角逗号分隔  
		String cc = ""; // 抄送，多个抄送以半角逗号分隔  
		String subject = ""; // 主题
		String body = "";// GenerateReport.returnResult(); // 正文，可以用html格式的哟  
		// 附件的路径，多个附件也不怕  
		List<String> ReportPath = null;// Arrays.asList(GenerateReport.returnReportPath());	// 附件路径
		List<String> screenshotPath = null;// GenerateReport.returnScreenshotPath(); // 截屏
		List<String> attachments = new ArrayList<String>();
		attachments.addAll(ReportPath);
		attachments.addAll(screenshotPath);
		EmailUtil email = EmailUtil.entity(smtpHost, userName, password, to, cc, subject, body, attachments);
		try {
			email.send();// 发送
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送邮件
	 * @return
	 * @throws MessagingException
	 */
	private boolean send() throws MessagingException {
		mimeMsg.setContent(mp);  
        mimeMsg.saveChanges();  
        System.out.println("正在发送邮件....");  
        Transport transport = session.getTransport("smtp");  
        // 连接邮件服务器并进行身份验证
        transport.connect(smtpHost, sendUserName, sendUserPass);  
        // 发送邮件
        transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));  
        System.out.println("发送邮件成功！");
        transport.close();  
        return true;
	}
	
	// 构造方式私有
	private EmailUtil(String smtpHost2, String sendUserName2, String sendUserPass2, String to, String cc,
			String mailSubject, String mailBody, List<String> attachments) {
		this.smtpHost = smtpHost;
		this.sendUserName = sendUserName;
		this.sendUserPass = sendUserPass;
		init();
		setFrom(sendUserName);
		setTo(to);
		setCC(cc);
		setBody(mailBody);
		setSubject(mailSubject);
		if (attachments != null) {
			for (String attachment : attachments) {
				addFileAffix(attachment);
			}
		}
	}

	private void init() {
		if (props == null) {
			props = System.getProperties();
		}
		props.put("mail.smtp.host", smtpHost);
		props.put("mail.smtp.auth", "true"); // 需要身份验证  
		session = Session.getDefaultInstance(props, null);
		// 置true可以在控制台（console)上看到发送邮件的过程
		session.setDebug(true);
		// 用session对象来创建并初始化邮件对象
		mimeMsg = new MimeMessage(session);
		// 生成附件组件的实例
		mp = new MimeMultipart();
	}
	
	/**
	 * 初始化参数
	 * @param smtpHost
	 * @param sendUserName
	 * @param sendUserPass
	 * @param to
	 * @param cc
	 * @param mailSubject
	 * @param mailBody
	 * @param attachments
	 * @return
	 */
	public static EmailUtil entity(String smtpHost, String sendUserName, String sendUserPass, String to, String cc,
			String mailSubject, String mailBody, List<String> attachments) {
		return new EmailUtil(smtpHost, sendUserName, sendUserPass, to, cc, mailSubject, mailBody, attachments);
	}
	
	
	/**
	 * 添加附件
	 * @param filename 附件的路径
	 * @return
	 */
	private boolean addFileAffix(String filename) {
		try {
			if (filename != null && filename.length() > 0) {
				BodyPart bp = new MimeBodyPart();
				FileDataSource fileds = new FileDataSource(filename);
				bp.setDataHandler(new DataHandler(fileds));
				bp.setFileName(MimeUtility.encodeText(fileds.getName(), "utf-8", null)); // 解决附件名称乱码  
				mp.addBodyPart(bp);// 添加附件  
				files.add(fileds);
			}
		} catch (Exception e) {
			System.err.println("增加邮件附件：" + filename + "发生错误！" + e);
			return false;
		}
		return true;
	}
	
	/**
	 * 设置邮件主题
	 * @param mailSubject
	 * @return
	 */
	private boolean setSubject(String mailSubject) {
		try {
			mimeMsg.setSubject(mailSubject);
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * 设置邮件内容,并设置其为文本格式或HTML文件格式，编码方式为UTF-8 
	 * @param mailBody
	 * @return
	 */
	private boolean setBody(String mailBody) {
		try {
			BodyPart bp = new MimeBodyPart();
			bp.setContent("<meta http-equiv=Content-Type content=text/html; charset=UTF-8>" + mailBody,
					"text/html;charset=UTF-8");
			// 在组件上添加邮件文本
			mp.addBodyPart(bp);
		} catch (MessagingException e) {
			System.err.println("设置邮件正文时发生错误！" + e);
			return false;
		}
		return true;
	}
	
	/**
	 * 设置抄送 
	 * @param cc
	 * @return
	 */
	private boolean setCC(String cc) {
		if (cc == null)
			return false;
		try {
			mimeMsg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	
	/**
	 * 设置收件人地址
	 * @param to
	 * @return
	 */
	private boolean setTo(String to) {
		if (to == null)
			return false;

		try {
			mimeMsg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		} catch (MessagingException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	
	/**
	 * 设置发件人地址
	 * @param from
	 * @return
	 */
	private boolean setFrom(String from) {
		try {
			mimeMsg.setFrom(new InternetAddress(from));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
