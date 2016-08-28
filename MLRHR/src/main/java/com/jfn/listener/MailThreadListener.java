package com.jfn.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.jfn.servlet.MailThread;

public class MailThreadListener implements ServletContextListener
{
	private MailThread mailThread;

	@Override
	public void contextDestroyed( ServletContextEvent e )
	{
		if( mailThread != null && mailThread.isInterrupted() )
		{
			mailThread.interrupt();
		}
	}

	@Override
	public void contextInitialized( ServletContextEvent e )
	{
		if( mailThread == null )
		{
			mailThread = new MailThread();
		}
		mailThread.start();
	}
}
