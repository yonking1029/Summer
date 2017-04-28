package com.oil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.ui.velocity.VelocityEngineUtils;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class MailTests {

	@Autowired
	private JavaMailSender mailSender;
	@Autowired
	private VelocityEngine velocityEngine;

	@Test
	public void sendSimpleMail() throws Exception {

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("872468551@qq.com");
			message.setTo("ilove_cp3@163.com");
			message.setSubject("主题：简单邮件");
			message.setText("测试邮件内容");
			mailSender.send(message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void sendAttachmentsMail() throws Exception {

		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("872468551@qq.com");
			helper.setTo("ilove_cp3@163.com");
			helper.setSubject("主题：有附件");
			helper.setText("有附件的邮件");

			FileSystemResource file = new FileSystemResource(new File("E:/我的工作/图片/易理坚.png"));
			helper.addAttachment("附件-1.jpg", file);
			helper.addAttachment("附件-2.jpg", file);

			mailSender.send(mimeMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Test
	public void sendInlineMail() throws Exception {

		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("872468551@qq.com");
			helper.setTo("ilove_cp3@163.com");
			helper.setSubject("主题：嵌入静态资源");
			helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

			FileSystemResource file = new FileSystemResource(new File("E:/我的工作/图片/易理坚.png"));
			helper.addInline("weixin", file);

			mailSender.send(mimeMessage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	@Test
	public void sendTemplateMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		helper.setFrom("872468551@qq.com");
		helper.setTo("ilove_cp3@163.com");
		helper.setSubject("主题：模板邮件");

		Map<String, Object> model = new HashMap();
		model.put("username", "易理坚");
		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, "template.vm", "UTF-8", model);
		helper.setText(text, true);

		mailSender.send(mimeMessage);
	}

}
