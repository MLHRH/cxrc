package com.jfn.common.pager;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * { "sEcho":1, "iColumns":7, "sColumns":"", "iDisplayStart":0,
 * "iDisplayLength":10, "amDataProp":[0,1,2,3,4,5,6], "sSearch":"",
 * "bRegex":false, "asSearch":["","","","","","",""],
 * "abRegex":[false,false,false,false,false,false,false],
 * "abSearchable":[true,true,true,true,true,true,true], "iSortingCols":1,
 * "aiSortCol":[0], "asSortDir":["asc"],
 * "abSortable":[true,true,true,true,true,true,true] }
 * 
 * @author inder
 */
public class DataTablesRequest implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "sEcho")
	public String echo;

	@JsonProperty(value = "iColumns")
	public int numColumns;

	@JsonProperty(value = "sColumns")
	public String columns;

	@JsonProperty(value = "iDisplayStart")
	public int displayStart;

	@JsonProperty(value = "iDisplayLength")
	public int displayLength;

	// has to be revisited for Object type dataProps.
	@JsonProperty(value = "amDataProp")
	public List<Integer> dataProp;

	@JsonProperty(value = "sSearch")
	public String searchQuery;

	@JsonProperty(value = "asSearch")
	public List<String> columnSearches;

	@JsonProperty(value = "bRegex")
	public boolean hasRegex;

	@JsonProperty(value = "abRegex")
	public List<Boolean> regexColumns;

	@JsonProperty(value = "abSearchable")
	public List<Boolean> searchColumns;

	@JsonProperty(value = "iSortingCols")
	public int sortingCols;

	@JsonProperty(value = "aiSortCol")
	public List<Integer> sortedColumns;

	@JsonProperty(value = "asSortDir")
	public List<String> sortDirections;

	@JsonProperty(value = "abSortable")
	public List<Boolean> sortableColumns;

	public DataTablesRequest()
	{
	}
	
	@Override
	public String toString()
	{
		String s = "sEcho="+echo+",iDisplayStart="+displayStart+",iDisplayLength="+displayLength+",sColumns="+columns;
		return s;
	}
}
