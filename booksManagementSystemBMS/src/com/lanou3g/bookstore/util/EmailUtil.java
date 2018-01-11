package com.lanou3g.bookstore.util;

import com.lanou3g.bookstore.user.bean.User;
import org.junit.Test;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by zyf on 2017/6/28.
 */
public class EmailUtil {

//	private String sendAddr = "1353251258@qq.com";//这是发送方的邮箱
//	private String receiveAddr = "zll103489252@qq.com";//接收方的邮箱
//
//	//这个不是密码,是开启163邮箱第三方登录时候设置的授权码
//	//如果不开启,那么是无法第三方登录163邮箱账号的
//	private String pass = "gumgyprazctpgfad";

	@Test
	public String  t1(String string) throws MessagingException {
		String sendAddr = "1060048901@qq.com";
		String pass = "zbfqjiajffoqbeda";

//		Properties prop = new Properties();
		Properties prop = System.getProperties();
		//设置服务器主机名
		prop.setProperty("mail.smtp.host","smtp.qq.com");
		prop.setProperty("mail.smtp.auth","true");
		prop.setProperty("mail.smtp.port","587");
//		prop.put("mail.transport.protocol", "smtp");

		//我们要登录一个账号,来给别人发邮件
		//现在先构建一个邮件账号，需要用邮件地址和密码
		Authenticator auth = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendAddr,pass);
			}
		};

		Session session = Session.getInstance(prop,auth);

		//创建一个邮件对象
		//这就是登录了邮箱之后,点击了发邮件,进入编辑邮件的窗口
		MimeMessage msg = new MimeMessage(session);

		//设置发件人
		msg.setFrom(new InternetAddress(sendAddr));

		//设置收件人
		msg.setRecipients(Message.RecipientType.TO,string);

		//添加主题
		msg.setSubject("这是来自李先生的邮件");

		String eid = UUID.randomUUID().toString().replaceAll("-", "");

		//添加内容,第二个参数表示这是html的内容
		msg.setContent("激活码 : "+eid,"text/html;charset=utf-8");

//		System.out.println();
		Transport.send(msg);

		return eid;

	}

//	@Test
//	public void t2() throws Exception{
//
//		Properties props = new Properties();
//		props.setProperty("mail.host", "smtp.qq.com");
//		props.setProperty("mail.smtp.auth", "true");
//		Authenticator auth = new Authenticator() {
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(sendAddr,pass);
//			}
//		};
//		Session session = Session.getDefaultInstance(props, auth);
//
//		MimeMessage msg = new MimeMessage(session);
//		// 设置发件人
//		msg.setFrom(new InternetAddress(sendAddr));
//		// 设置收件人
//		msg.setRecipients(Message.RecipientType.TO, "zll103489252@qq.com");
//		msg.setSubject("带有附件的邮件");
//
//    	/*当发送包含附件的邮件时, 邮件体就为多部件
//    		1. 创建一个多部件的部件内容, MimeMultipart
//			2. 我们需要创建两个主体部件, 一个是文本内容, 一个是附件的. 主体部件叫MimeBodyPart
//			3. 把 MimeMultipart设置给MimeMessage
//    	*/
//		// 创建多部分内容
//		MimeMultipart list = new MimeMultipart();
//		// 创建MimeBodyPart 主体部件
//		MimeBodyPart part1 = new MimeBodyPart();
//		part1.setContent("这是一封包含附件的邮件", "text/html;charset=utf-8");
//		list.addBodyPart(part1); // 把主体部件添加到多部件主体
//
//		MimeBodyPart part2 = new MimeBodyPart();
//		//使用File只能找到本机的内容
//		//若想使用工程里的，需要使用getServletContext().get.....自己想
//		part2.attachFile(new File("/Users/zyf/Desktop/图片/搞怪图片/girl.jpg")); // 设置附件内容
//		// 显示在附件上的名称 . 会乱码.需要处理,使用 MimeUtility.encodeText处理
//		part2.setFileName(MimeUtility.encodeText("女生.jpg"));
//		list.addBodyPart(part2);
//
//		msg.setContent(list); // 把多部件设置给邮件内容
//
//		Transport.send(msg);
//	}

}
