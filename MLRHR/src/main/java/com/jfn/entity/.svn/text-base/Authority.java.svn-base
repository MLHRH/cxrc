package com.jfn.entity;



import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 权限.
 * 
 * 注释见{@link User}.
 * 
 * @author calvin
 */
public class Authority implements Comparable<Authority>
{

	/**
	 * SpringSecurity中默认的角色/授权名前缀.
	 */

	public static final String AUTHORITY_PREFIX = "ROLE_";

	private int id;

	private String name;

	// 菜单地址
	private String url;

	// 是否拥有该功能（树型菜单中展示时使用）
	private String checked;

	public Authority()
	{
	}

	public Authority( int id, String name )
	{
		this.id = id;
		this.name = name;
	}

	public int getId()
	{
		return id;
	}

	public void setId( int id )
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	@JsonIgnore
	public String getPrefixedName()
	{
		return AUTHORITY_PREFIX + name;
	}

	@JsonProperty("href")
	public String getUrl()
	{
		return url;
	}

	public void setUrl( String url )
	{
		this.url = url;
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString( this );
	}
	
	public String getChecked()
	{
		return checked;
	}

	public void setChecked( String checked )
	{
		this.checked = checked;
	}

	@Override
	public int compareTo( Authority arg0 )
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
