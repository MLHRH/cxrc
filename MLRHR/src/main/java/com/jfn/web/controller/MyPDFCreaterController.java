package com.jfn.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jfn.common.util.FileUtil;
import com.jfn.entity.Attachfile;
import com.jfn.entity.ZhichengApply;
import com.jfn.service.AccountManager;
import com.jfn.service.ExportService;
import com.jfn.service.ZhichengApplyService;
import com.sun.javafx.logging.Logger;

/**
 * @create-time 2014-8-31 下午10:18:06
 * @author 佟德慧
 * @remarks 无
 */
@Controller
@RequestMapping("/")
public class MyPDFCreaterController {
	@Autowired
	private AccountManager accountManager;


	@Autowired
	private ZhichengApplyService zhichengapplyservice;
	
	@Autowired
	private ExportService ExportService ;




	@RequestMapping(value = "exportDoc07", method = RequestMethod.GET)
	@ResponseBody
	public void exportDoc07(HttpServletRequest request,HttpServletResponse response) throws ParseException {
		JSONObject result = new JSONObject();
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String apply_date = request.getParameter("apply_date");
        String applayStype = request.getParameter("zhichengapply_status_new");
		ZhichengApply zhichengapply = new ZhichengApply();
		zhichengapply.setStatus(request.getParameter("status"));
		zhichengapply.setApply_type(request.getParameter("apply_type"));
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		java.util.Date start_date=sdf.parse(startDate);
		java.util.Date end_date=sdf.parse(endDate);
		try {
			
				String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
//				filename = PDFservice.createDoc07_hr(startDate, endDate, body_id, zhichengapply, apply_userRank, apply_body, apply_userName, apply_userMobile, apply_date);
				ExportService.CreateExcelFile(apply_date, Integer.valueOf(applayStype), start_date, end_date,path);
				String fileName="";
				if (applayStype.equals("1")) {					
					 fileName = "chushen.xls";
				}else {
					fileName = "fushen.xls";
				}
				Attachfile f = new Attachfile();
				f.setNewfilename(fileName);
				f.setFile_path(path);
				f.setOldfilename(fileName);
				result.put("filename", fileName);
				result.put("path", path);
				System.err.println(result.toJSONString());
				FileUtil.downloadExcelFile(response, f);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
