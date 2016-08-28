package com.jfn.service;

import java.io.File;

import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.transaction.annotation.Transactional;

import com.jfn.common.util.ContextUtil;
import com.jfn.entity.Attachfile;
import com.jfn.entity.MailItem;
import com.jfn.entity.MailItem2;

public class MailManager
{
	private static JavaMailSender sender;
	private static SimpleMailMessage smm;
	static
	{
		sender = ( JavaMailSender ) ContextUtil.getInst()
				.getBean( "mailSender" );
		smm = ( SimpleMailMessage ) ContextUtil.getInst()
				.getBean( "preConfiguredMessage" );
	}

	public static boolean sendMime( final MailItem mi )
	{
		try
		{
			sender.send( new MimeMessagePreparator()
			{
				@Override
				public void prepare( MimeMessage mimeMessage ) throws Exception
				{
					MimeMessageHelper mmh = new MimeMessageHelper( mimeMessage,
							true );
					mmh.setFrom( smm.getFrom() );
					mmh.setTo( mi.getTo() );
					mmh.setSubject( MimeUtility.encodeWord( mi.getSubject() ) );
					mmh.setText( mi.getBody(), true );
					if( mi.getFiles() != null )
					{
						for( Attachfile f : mi.getFiles() )
						{
							mmh.addAttachment(
									MimeUtility.encodeWord( f.getFile_name() ),
									new File( f.getFile_path() ) );
						}
					}
				}
			} );
			return true;
		}
		catch( MailException me )
		{
			System.out.println( "Error sending email: " + me.getMessage() );
			return false;
		}
	}
	
	public static boolean sendMime2( final MailItem2 mi )
	{
		try
		{
			sender.send( new MimeMessagePreparator()
			{
				@Override
				public void prepare( MimeMessage mimeMessage ) throws Exception
				{
					MimeMessageHelper mmh = new MimeMessageHelper( mimeMessage,
							true );
					mmh.setFrom( smm.getFrom() );
					mmh.setTo( mi.getTo() );
					mmh.setSubject( MimeUtility.encodeWord( mi.getSubject() ) );
					mmh.setText( mi.getBody(), true );
					if( mi.getFiles() != null )
					{
						for( Attachfile f : mi.getFiles() )
						{
							mmh.addAttachment(
									MimeUtility.encodeWord( f.getFile_name() ),
									new File( f.getFile_path() ) );
						}
					}
				}
			} );
			return true;
		}
		catch( MailException me )
		{
			System.out.println( "Error sending email: " + me.getMessage() );
			return false;
		}
	}
}
