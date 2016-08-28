package com.jfn.common.pager;

import javax.servlet.http.HttpServletRequest;

public class DataTablesParamUtility {
	
	public static JQueryDataTableParamModel getParam(HttpServletRequest request)
	{
		if(request.getParameter("sEcho")!=null && request.getParameter("sEcho")!= "")
		{
			JQueryDataTableParamModel param = new JQueryDataTableParamModel();
			param.sEcho = request.getParameter("sEcho");
			param.sSearch = request.getParameter("sSearch");
			param.sColumns = request.getParameter("sColumns");
			param.iDisplayStart = Integer.parseInt( request.getParameter("iDisplayStart") );
			param.iDisplayLength = Integer.parseInt( request.getParameter("iDisplayLength") );
			param.iColumns = Integer.parseInt( request.getParameter("iColumns") );
			param.iSortingCols = Integer.parseInt( request.getParameter("iSortingCols") );
			param.iSortColumnIndex = Integer.parseInt(request.getParameter("iSortCol_0"));
			param.sSortDirection = request.getParameter("sSortDir_0");
			
			param.sCountry = request.getParameter("country");
			param.iBody = Integer.parseInt( request.getParameter("body"));
			param.sPosition = request.getParameter("position");
			param.sPersonName=request.getParameter("personname");
			
			return param;
		}else
			return null;
	}
}
