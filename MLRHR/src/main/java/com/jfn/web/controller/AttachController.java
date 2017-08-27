package com.jfn.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jfn.common.util.Constant;
import com.jfn.common.util.FileUtil;
import com.jfn.entity.Attachfile;
import com.jfn.entity.User;
import com.jfn.service.FileService;
import com.jfn.service.ZhichengApplyService;

@Controller
@RequestMapping("/")
public class AttachController {
	private static final Logger log = LoggerFactory.getLogger(AttachController.class);

	@Autowired
	private FileService fileService;
	@Autowired
	private ZhichengApplyService zhichengApplyService;
	
	@ResponseBody
    @RequestMapping(value = "uploadFile",method = RequestMethod.POST)
    public Object  uploadFile(HttpServletRequest request){
    	JSONObject result = new JSONObject();
    	
    		//上传文件到服务器
    	try {
			result = (JSONObject) FileUtil.uploadFile(request);
			result.put(Constant.MSG, Constant.STATUS_SUCCESS);
		} catch (IllegalStateException e) {
			result.put(Constant.MSG, Constant.STAUS_FAIL);
		} catch (IOException e) {
			result.put(Constant.MSG, Constant.STAUS_FAIL);
		}
    		
    	return result;
    }
	@ResponseBody
    @RequestMapping(value = "importFile",method = RequestMethod.POST)
    public Object  importFile(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("loginuser");
		String newfilename = request.getParameter("filename");
		String oldfilename = request.getParameter("oldfilename");
		String path = request.getParameter("path");
		String applyid = request.getParameter("applyid");
		Attachfile file  = new Attachfile();
		file.setApplyid(Integer.valueOf(applyid));
		file.setFile_path(path);
		file.setOldfilename(oldfilename);
		file.setNewfilename(newfilename);
    	JSONObject result = new JSONObject();
    			//插入上传文件记录
    	result = fileService.insetFileLog(file,user);
    	return result;
    }
    
	@RequestMapping(value = "downloadfile", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response) {
		String fileid = request.getParameter("fileid");
		Attachfile file = fileService.getFileById(Integer.valueOf(fileid));
		if(file != null){
			try {
				FileUtil.downloadFile(response, file);
			} catch (IOException e) {
				log.info("下载文件失败");
				e.printStackTrace();
			}
		}
	}
	/**
	 * 显示文件信息
	 * @param request
	 * @param model
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value = "showUpLoadFile", method = RequestMethod.GET)
	public Object showUpLoadFile(HttpServletRequest request, Model model) {
		List<Attachfile> files = new ArrayList<Attachfile>();
		String apply_id = request.getParameter("applyid");
		String authority = "";

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication().getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}

		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);
		JSONArray jsonArray = new JSONArray();
		if (apply_id == null || apply_id.equals("")) {
			jsonArray.add(files);
			jsonArray.add(jo3);
			return jsonArray.toString();
		}
		Integer applyid =Integer.valueOf(apply_id);
		Attachfile file = fileService.getFileByApplyId(applyid);
		files.add(file);
		jsonArray.add(files);
		jsonArray.add(jo3);
		return jsonArray.toString();
		}
	
	/**
	 * 删除文件
	 * @param request
	 * @param model
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delFile", method = RequestMethod.GET)
	public Object delFile(HttpServletRequest request, Model model) {
		String fileid = request.getParameter("fileId");
		JSONObject result = fileService.delFile(Integer.valueOf(fileid));
		return result;
		}

}
