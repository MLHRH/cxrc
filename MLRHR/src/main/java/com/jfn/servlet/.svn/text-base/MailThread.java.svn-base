package com.jfn.servlet;

import java.util.concurrent.LinkedBlockingQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfn.entity.MailItem;
import com.jfn.service.MailManager;

public class MailThread extends Thread
{
	private static final Logger log = LoggerFactory
			.getLogger(MailThread.class);
	public static int mailsPerMinute = 30;
	public static LinkedBlockingQueue<MailItem> mailQueue = new LinkedBlockingQueue<MailItem>();
	
	@Override
	public void run()
	{
		while( true )
		{
			while( !MailThread.mailQueue.isEmpty() )
			{
				int maxMailAmmount = mailsPerMinute;
				long timeStart = System.currentTimeMillis();
				while( maxMailAmmount > 0 )
				{
					if( !MailThread.mailQueue.isEmpty() )
					{
						MailItem mailEntity = MailThread.mailQueue.poll();
						MailManager.sendMime( mailEntity );
						maxMailAmmount-- ;
					}
				}
				long now = System.currentTimeMillis();
				if( ( now - timeStart ) < 1000 * 60 )
				{
					try
					{
						Thread.sleep( 1000 * 60 + timeStart - now );
					}
					catch( InterruptedException e )
					{
						e.printStackTrace();
						log.error( e.getMessage() );
					}
				}
				else
				{
					maxMailAmmount = mailsPerMinute;
				}
			}
		}
	}
}
