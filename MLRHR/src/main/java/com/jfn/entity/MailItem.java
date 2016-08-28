package com.jfn.entity;

import java.util.List;

import javax.mail.internet.InternetAddress;

public class MailItem
{
	private InternetAddress[] to;
	private String ccs;
	private String subject;
	private String body;
	private List<Attachfile> files;


	public InternetAddress[] getTo()
	{
		return to;
	}

	public void setTo( InternetAddress[] to )
	{
		this.to = to;
	}

	public String getCcs()
	{
		return ccs;
	}

	public void setCcs( String ccs )
	{
		this.ccs = ccs;
	}

	public String getSubject()
	{
		return subject;
	}

	public void setSubject( String subject )
	{
		this.subject = subject;
	}

	public String getBody()
	{
		return body;
	}

	public void setBody( String body )
	{
		this.body = body;
	}

	public List<Attachfile> getFiles()
	{
		return files;
	}

	public void setFiles( List<Attachfile> files )
	{
		this.files = files;
	}

}
