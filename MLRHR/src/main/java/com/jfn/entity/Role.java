package com.jfn.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springside.modules.utils.reflection.ConvertUtils;


/**
 * 角色.
 * 
 * 注释见{@link User}.
 * 
 * @author calvin
 */

public class Role
{
	private int id;
	private String name;
	private List<Authority> authorityList = new ArrayList<Authority>();// 有序的关联对象集合
	public Role()
	{

	}

	public Role( int id, String name )
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

	public List<Authority> getAuthorityList()
	{
		return authorityList;
	}

	public void setAuthorityList( List<Authority> authorityList )
	{
		this.authorityList = authorityList;
	}

	public String getAuthNames()
	{
		return ConvertUtils.convertElementPropertyToString( authorityList,"name", ", " );
	}

	@SuppressWarnings("unchecked")
	public List<Long> getAuthIds()
	{
		return ConvertUtils.convertElementPropertyToList( authorityList, "id" );
	}

	@Override
	public String toString()
	{
		return ToStringBuilder.reflectionToString( this );
	}
}
