package com.jfn.service.impl;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

import com.jfn.common.util.ContextUtil;
import com.jfn.service.IMailService;

public class MailServiceImpl implements IMailService
{
	@Override
	public void send( SimpleMailMessage smm )
	{
		MailSender sender = ( MailSender ) ContextUtil.getInst().getBean(
				"mailSender" );
		sender.send( smm );
	}

	public void sendMime()
	{
		JavaMailSender  sender = ( JavaMailSender )ContextUtil.getInst().getBean( "mailSender" );
		sender.send( new MimeMessagePreparator()
		{
			@Override
			public void prepare( MimeMessage mimeMessage ) throws Exception
			{
				MimeMessageHelper mmh = new MimeMessageHelper( mimeMessage,
						true );
				mmh.setFrom( "daybug@163.com" );
				mmh.setTo( "daybug@gmail.com" );
				mmh.setSubject( "带附件的邮件测试" );
				mmh.setText( "查看附件" );
				mmh.addAttachment( "2013-04-15.jpg", new File( "C:/2013-04-15.jpg" ) ); 
			}
		} );
	}
}