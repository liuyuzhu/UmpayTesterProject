package com.umpaytester.spayrest.util;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 * JavaMail 版本: 1.6.0 JDK 版本: JDK 1.7 以上（必须）
 */

public class SendMail {

	public static void sendMail(String result,String title) throws MessagingException, IOException {
//		 	String result="ceshi ";
//		static String path1 = BaseTest.class.getResource("/").getPath();
//		static String path = path1.substring(0, path1.indexOf("WEB-INF"));
		String properties = "mail.properties";
		
		//收件人邮箱
		String receiveMailAccount=GetProperties.getParameters(properties, "receiveMailAccount");
		
		
		// 发件人邮箱的 SMTP 服务器地址, 必须准确, 不同邮件服务器地址不同, 一般(只是一般, 绝非绝对)格式为: smtp.xxx.com
		// 网易163邮箱的 SMTP 服务器地址为: smtp.163.com
		
		String myEmailSmtpHost=GetProperties.getParameters(properties, "myEmailSmtpHost");
		
		//发件人邮箱密码
		
		String myEmailPassword=GetProperties.getParameters(properties, "myEmailPassword");
		
		//发件人邮箱账户
		String myEmailAccount=GetProperties.getParameters(properties, "myEmailAccount");
		
		 // 使用的协议（JavaMail规范要求）
		String mailTransportProtocol=GetProperties.getParameters(properties, "mailTransportProtocol");
		//设置超时时间
		String mailTimeout=GetProperties.getParameters(properties, "mailTimeout");
		
		//是否需要认证
		String mailSmtpAuth=GetProperties.getParameters(properties, "mailSmtpAuth");
		
		//邮件姓名
		String mailName=GetProperties.getParameters(properties, "mailName");



		// 1. 创建参数配置, 用于连接邮件服务器的参数配置
		Properties props = new Properties(); // 参数配置
		props.setProperty("mail.transport.protocol", mailTransportProtocol); // 使用的协议（JavaMail规范要求）
		props.setProperty("mail.smtp.host", myEmailSmtpHost); // 发件人的邮箱的 SMTP
																// 服务器地址
		props.setProperty("mail.smtp.auth", mailSmtpAuth); // 需要请求认证

		// 2. 根据配置创建会话对象, 用于和邮件服务器交互
		Session session = Session.getDefaultInstance(props);
		session.setDebug(true); // 设置为debug模式, 可以查看详细的发送 log

		// 3. 创建一封邮件
		MimeMessage message = null;
		try {
			message = createMimeMessage(session, myEmailAccount,
					receiveMailAccount, result,title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 4. 根据 Session 获取邮件传输对象
		Transport transport = null;
		try {
			transport = session.getTransport();
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
		//
		// PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
		// 仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
		// 类型到对应邮件服务器的帮助网站上查看具体失败原因。
		//
		// PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
		// (1) 邮箱没有开启 SMTP 服务;
		// (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
		// (3) 邮箱服务器要求必须要使用 SSL 安全连接;
		// (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
		// (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
		//
		// PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
		try {
			transport.connect(myEmailAccount, myEmailPassword);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人,
		// 抄送人, 密送人
		try {
			transport.sendMessage(message, message.getAllRecipients());
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 7. 关闭连接
		transport.close();
	}
	 
	/**
	 * 创建一封只包含文本的简单邮件
	 *
	 * @param session
	 *            和服务器交互的会话
	 * @param sendMail
	 *            发件人邮箱
	 * @param receiveMail
	 *            收件人邮箱
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMimeMessage(Session session,
			String sendMail, String receiveMail, String result,String title)
			throws Exception {
		// 1. 创建一封邮件
		MimeMessage message = new MimeMessage(session);

		// 2. From: 发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
		message.setFrom(new InternetAddress(sendMail, "跨境测试服务", "UTF-8"));

		// 3. To: 收件人（可以增加多个收件人、抄送、密送）
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(
				receiveMail, "跨境技术团队", "UTF-8"));
		message.setSubject(title, "UTF-8");

		// 5. Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
		message.setContent(result, "text/html;charset=UTF-8");

		// 6. 设置发件时间
		message.setSentDate(new Date());

		// 7. 保存设置
		message.saveChanges();

		return message;
	}


}