package com.jfn.common.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonTool
{
	/**
	 * 将包含简单属性的json对象封装成java对象
	 * 
	 * @param json
	 * @param clazz
	 *            要封装的java对象的类型
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws JSONException
	 */
	public static Object simpleJsonToJavaObj( JSONObject json, Class clazz )
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, JSONException
	{
		String[] names = JSONObject.getNames( json );
		Object paramValue = null;
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		Class paramClazz;

		for( String paramName : names )
		{
			for( Field field : fields )
			{
				// 判断json中的键是不是类的属性名
				if( field.getName().equals( paramName )
						&& json.get( paramName ) != null )
				{
					// 将json的变量以正确的类型取出。
					paramClazz = field.getType();
					paramValue = getValueFromJson( json, paramName, paramClazz );
					// 调用get方法
					clazz.getDeclaredMethod(
							getSetterFuncNameByFieldName( paramName ),
							paramClazz ).invoke( obj, paramValue );
				}
			}
		}

		return obj;
	}

	public static Object simpleJsonToJavaObj( String json, Class clazz )
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, JSONException
	{
		return simpleJsonToJavaObj( new JSONObject( json ), clazz );
	}

	private static Object getValueFromJson( JSONObject json, String fieldName,
			Class fieldClass ) throws JSONException
	{
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss" );
		SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

		Object obj = null;
		if( json.get( fieldName ) == null )
		{
			return null;
		}
		try
		{
			if( fieldClass == String.class )
			{
				obj = json.getString( fieldName );
			}
			else if( fieldClass == Integer.class || fieldClass == int.class )
			{
				obj = json.getInt( fieldName );
			}
			else if( fieldClass == Long.class || fieldClass == long.class )
			{
				obj = json.getLong( fieldName );
			}
			else if( fieldClass == Double.class || fieldClass == double.class )
			{
				obj = json.getDouble( fieldName );
			}
			else if( fieldClass == Date.class )
			{
				// 有可能是日期，也有可能是时间
				try
				{
					obj = dateTimeFormat.parseObject( json
							.getString( fieldName ) );
				}
				catch( ParseException e )
				{
					try
					{
						obj = dateFormat.parseObject( json
								.getString( fieldName ) );
					}
					catch( ParseException e1 )
					{
						e1.printStackTrace();
					}
				}
			}
		}
		catch( Exception e )
		{
			obj = null;
			e.printStackTrace();
		}
		return obj;
	}

	private static String getSetterFuncNameByFieldName( String fieldName )
	{
		StringBuilder functionName = new StringBuilder();
		functionName.append( "set" );
		functionName.append( fieldName.substring( 0, 1 ).toUpperCase() );
		functionName.append( fieldName.substring( 1 ) );
		return functionName.toString();
	}

	/**
	 * 将包含简单属性的json对象封装成java对象
	 * 
	 * @param json
	 * @param clazz
	 *            要封装的java对象的类型
	 * @return
	 * @throws IllegalArgumentException
	 * @throws SecurityException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 * @throws JSONException
	 */
	public static Object simpleJsonToJavaStringObj( JSONObject json, Class clazz )
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, JSONException
	{
		String[] names = JSONObject.getNames( json );
		Object paramValue = null;
		Object obj = clazz.newInstance();
		Field[] fields = clazz.getDeclaredFields();
		Class paramClazz;

		for( String paramName : names )
		{
			for( Field field : fields )
			{
				// 判断json中的键是不是类的属性名
				if( field.getName().equals( paramName ) )
				{
					// 将json的变量以正确的类型取出。
					paramClazz = field.getType();
					paramValue = getValueFromJson( json, paramName, paramClazz );
					if( ( json.getString( paramName ) == null )
							|| ( json.getString( paramName ).length() == 0 )
							|| ( json.getString( paramName )
									.equalsIgnoreCase( "null" ) ) )
					{
						paramValue = "";
					}
					// 调用get方法
					clazz.getDeclaredMethod(
							getSetterFuncNameByFieldName( paramName ),
							paramClazz ).invoke( obj, paramValue );
				}
			}
		}

		return obj;
	}
}
