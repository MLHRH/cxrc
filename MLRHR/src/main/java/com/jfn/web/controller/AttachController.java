package com.jfn.web.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import com.jfn.entity.ZhichengApply;
import com.jfn.service.FileService;
import com.jfn.service.ZhichengApplyService;
import com.sun.corba.se.impl.ior.GenericIdentifiable;

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
    public Object  uploadFile(HttpServletRequest request,String applyId,String applyType){
    	JSONObject result = new JSONObject();
    	User user = (User) request.getSession().getAttribute("loginuser");
    		//上传文件到服务器
    	try {
			result = (JSONObject) FileUtil.uploadFile(request);
			Attachfile file  = new Attachfile();
			if (applyId != null && !applyId.equals("")) {
				file.setApplyid(Integer.valueOf(applyId));				
			}
			file.setFile_path((String)result.get("PATH"));
			file.setOldfilename((String)result.get("OLD"));
			file.setNewfilename((String)result.get("NEW"));
			file.setApplyType(applyType);
			if(null!=applyId && !"".equals(applyId)){
				file.setApplyStep(1);
			}else{
				file.setApplyStep(0);
			}
			result = fileService.insetFileLog(file,user);
		} catch (IllegalStateException e) {
			result.put(Constant.MSG,"系统异常");
		} catch (IOException e) {
			result.put(Constant.MSG,"系统异常");
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
	 * @throws UnsupportedEncodingException 
	 */
	
	@ResponseBody
	@RequestMapping(value = "showUpLoadFile", method = RequestMethod.GET)
	public Object showUpLoadFile(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		Set<Attachfile> files = new HashSet<Attachfile>();
		String apply_id = request.getParameter("applyid");
		String user_id = request.getParameter("userid"); 
		String apply_type = request.getParameter("applytype"); 
		if (!apply_type.equals("杰出青年") && !apply_type.equals("科技领军") && !apply_type.equals("创新团队")) {
			apply_type = new String(apply_type.getBytes("ISO8859-1"), "UTF-8");					
		}
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
			Attachfile	file = fileService.getFileByTypeAndStep(Integer.valueOf(user_id), apply_type, 0);
			files.add(file);
			jsonArray.add(files);
			jsonArray.add(jo3);
			return jsonArray.toString();
		}else{
			Integer applyid =Integer.valueOf(apply_id);
			ZhichengApply apply = zhichengApplyService.getById(apply_id);
//			if(Integer.valueOf(apply.getStatus()) < 3){
//				Attachfile file = fileService.getFileByTypeAndStep(Integer.valueOf(user_id), apply_type, 0);
//				files.add(file);
//			}else{
			    Attachfile file = fileService.getFileByTypeAndStep(Integer.valueOf(user_id), apply_type, 0);
			   if (file != null) {
				   files.add(file);				
			      }
				Attachfile  file1= fileService.getFileByApplyId(applyid);
				if (file1 != null) {
					files.add(file1);				
				}
//			}
			jsonArray.add(files);
			jsonArray.add(jo3);
			return jsonArray.toString();
		}
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
	
	
	
	
	@ResponseBody
    @RequestMapping(value = "newuploadFile",method = RequestMethod.POST)
    public Object  newuploadFile(HttpServletRequest request,String newId){
    	JSONObject result = new JSONObject();
    	User user = (User) request.getSession().getAttribute("loginuser");
    		//上传文件到服务器
    	try {
			result = (JSONObject) FileUtil.uploadFile(request);
			Attachfile file  = new Attachfile();
			if (newId != null && !newId.equals("")) {
				file.setApplyid(Integer.valueOf(newId));				
			}
			file.setFile_path((String)result.get("PATH"));
			file.setOldfilename((String)result.get("OLD"));
			file.setNewfilename((String)result.get("NEW"));
			file.setApplyType("news");
//			if(null!=newId && !"".equals(newId)){
//				file.setApplyStep(1);
//			}else{
//				file.setApplyStep(0);
//			}
			result = fileService.insetFileLog(file,user);
		} catch (IllegalStateException e) {
			result.put(Constant.MSG,"系统异常");
		} catch (IOException e) {
			result.put(Constant.MSG,"系统异常");
		}
    	return result;
    }
	@ResponseBody
    @RequestMapping(value = "newimportFile",method = RequestMethod.POST)
    public Object  newimportFile(HttpServletRequest request){
		User user = (User) request.getSession().getAttribute("loginuser");
		String newfilename = request.getParameter("filename");
		String oldfilename = request.getParameter("oldfilename");
		String path = request.getParameter("path");
		String applyid = request.getParameter("newId");
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
    
	@RequestMapping(value = "newdownloadfile", method = RequestMethod.GET)
	public void newdownload(HttpServletRequest request, HttpServletResponse response) {
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
	 * @throws UnsupportedEncodingException 
	 */
	
	@ResponseBody
	@RequestMapping(value = "newshowUpLoadFile", method = RequestMethod.GET)
	public Object newshowUpLoadFile(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
		String apply_id = request.getParameter("newId");
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
		Integer applyid =Integer.valueOf(apply_id);
	    List<Attachfile>  files= fileService.getAllFileByApplyId(applyid);
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
	@RequestMapping(value = "newdelFile", method = RequestMethod.GET)
	public Object newdelFile(HttpServletRequest request, Model model) {
		String fileid = request.getParameter("fileId");
		JSONObject result = fileService.delFile(Integer.valueOf(fileid));
		return result;
		}

}
