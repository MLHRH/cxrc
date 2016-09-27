package com.jfn.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * �����࣬��ȡApplicationContext�����bean
 * 
 * @author minwh
 * @see MpContextLoaderListener
 */
public class ContextUtil {
	
	private ApplicationContext context = null;
	
	private static ContextUtil inst = new ContextUtil();
	
	private ContextUtil(){
		
	}
	
	public static ContextUtil getInst()
	{
		return inst;
	}

	/**
	 * ����applicationContext
	 * 
	 * @param context Ψһ����applicationContext
	 */
	public synchronized void setContext(ApplicationContext context) {
		this.context = context;
	}
	
	/**
	 * ��ȡapplicationContext
	 * 
	 * @return applicationContext
	 */
	public synchronized ApplicationContext getContext() {
		if (context == null) {
			buildContext();
		}
		return context;
	}
	
	/**
	 * ��ȡbeanʵ��
	 * 
	 * @param sId bean�������ļ��е�id
	 * 
	 * @return beanʵ��
	 */
	public synchronized Object getBean(String sId) {
		if (context == null) {
			buildContext();
		}
		return context.getBean(sId);
	}
	
	/**
	 * ������web����ʱֱ�����������ļ�����ApplicationContext
	 */
	private synchronized void buildContext() {
//		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		String path = String.valueOf(this.getClass().getClassLoader()
				.getResource("/").getPath());
		path = path.substring(1, path.lastIndexOf("WEB-INF"));
		path = path.replaceAll("%20", " ");
		path = path + "WEB-INF/applicationContext.xml";
		context = new FileSystemXmlApplicationContext(path);
	}
}
