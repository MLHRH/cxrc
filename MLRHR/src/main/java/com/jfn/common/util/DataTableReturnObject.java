package com.jfn.common.util;
/**
 * 返回前台Data Tables列表对象
 * @author figo1117
 *
 */

public class DataTableReturnObject {
	//总记录数
	 private long iTotalRecords;
	 //过滤后总记录数
	 private long iTotalDisplayRecords;
	 //来自客户端 sEcho 的没有变化的复制品
	 private String sEcho;
	 private String[][] aaData;

	 public DataTableReturnObject()
	 {
		 
	 }
	 
	 public DataTableReturnObject(long totalRecords, long totalDisplayRecords,
	   String echo, String[][] d) {
	  this.iTotalRecords = totalRecords;
	  this.iTotalDisplayRecords = totalDisplayRecords;
	  this.sEcho = echo;
	  this.aaData = d;
	 }

	 public long getiTotalRecords() {
	  return iTotalRecords;
	 }

	 public void setiTotalRecords(long iTotalRecords) {
	  this.iTotalRecords = iTotalRecords;
	 }

	 public long getiTotalDisplayRecords() {
	  return iTotalDisplayRecords;
	 }

	 public void setiTotalDisplayRecords(long iTotalDisplayRecords) {
	  this.iTotalDisplayRecords = iTotalDisplayRecords;
	 }

	 public String getsEcho() {
	  return sEcho;
	 }

	 public void setsEcho(String sEcho) {
	  this.sEcho = sEcho;
	 }

	 public String[][] getAaData() {
	  return aaData;
	 }

	 public void setAaData(String[][] aaData) {
	  this.aaData = aaData;
	 }

	
}
