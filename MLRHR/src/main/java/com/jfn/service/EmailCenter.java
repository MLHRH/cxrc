package com.jfn.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Send Mail 
 * 
 * @author stanley_hwang
 *
 */
@Service
public class EmailCenter {

	private final static String MAIL_AUTH = "true";
	
	private final static String MAIL_HOST = "smtp.sina.com";
	
	private final static String MAIL_PORT = "25";
	
	private final static String MAIL_USERNAME = "antosendmail@sina.com";
	
	private final static String MAIL_PASSWORD = "auto123456";
	
	public static void send(String sendTo, String subject, String body)
	   {    
	      // Recipient's email ID needs to be mentioned.
	      String to = "1015757334@qq.com";

	      // Sender's email ID needs to be mentioned
	      String from = "antosendmail@sina.com";

	      // Get system properties
	      Properties properties = System.getProperties();
	      // Setup mail server
	      properties.put("mail.smtp.auth", MAIL_AUTH);
	      properties.put("mail.smtp.host", MAIL_HOST);
	      properties.put("mail.smtp.port", MAIL_PORT); 
	    //  properties.put("mail.user", "autosendmail2014@gmail.com");
	    //  properties.put("mail.password", "auto123456");

	      // Get the default Session object.
	      Session session = Session.getDefaultInstance(properties
	              //以匿名内部类的形式创建登录服务器的认证对象
	              , new Authenticator()
	              {
	                  public PasswordAuthentication getPasswordAuthentication()
	                  {
	                      return new PasswordAuthentication(MAIL_USERNAME, MAIL_PASSWORD); 
	                  }
	              });
	      try{
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);

	         // Set From: header field of the header.
	         message.setFrom(new InternetAddress(from));

	         // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,
	                                  new InternetAddress(sendTo));

	         // Set Subject: header field
	         message.setSubject(subject);

	         // Now set the actual message
	         message.setText(body);

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	      }catch (MessagingException mex) {
	         mex.printStackTrace();
	      }
	   }
	
}
