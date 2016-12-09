package com.jfn.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jfn.common.util.Constant;
import com.jfn.common.util.FileUtil;
import com.jfn.entity.Attachfile;
import com.jfn.service.FileService;

@Controller
@RequestMapping("/")
public class AttachController {
	private static final Logger log = LoggerFactory.getLogger(AttachController.class);

	@Autowired
	private FileService fileService;
	
	/*
     *采用spring提供的上传文件的方法
     */
	@ResponseBody
    @RequestMapping(value = "UploadFile",method = RequestMethod.POST)
    public Object  uploadFile(HttpServletRequest request){
    	int userid =(Integer)request.getSession().getAttribute("user_id");
    	int applyid =(Integer)request.getSession().getAttribute("applyid");
    	JSONObject result = new JSONObject();
    	Attachfile file = null;
    	try {
    		//上传文件到服务器
			file = FileUtil.uploadFile(request, file);
			file.setUserid(userid);
			file.setApplyid(applyid);
			//插入上传文件记录
			result = fileService.insetFile(file);
		} catch (IllegalStateException e) {
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "上传文件失败，请重新上传！");
		} catch (IOException e) {
			result.put(Constant.STATUS, Constant.STAUS_FAIL);
			result.put(Constant.MSG, "上传文件失败，请重新上传！");
		}
    	return result;
    }
    
	@RequestMapping(value = "downloadfile", method = RequestMethod.GET)
	public void download(HttpServletRequest request, HttpServletResponse response) {
		int id =(Integer)request.getSession().getAttribute("id");
		Attachfile file = fileService.getFileById(id);
		if(file != null){
			try {
				FileUtil.downloadFile(response, file);
			} catch (IOException e) {
				log.info("下载文件失败");
				e.printStackTrace();
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "showUpLoadFile", method = RequestMethod.GET)
	public Object showUpLoadFile(HttpServletRequest request, Model model) {
		int applyid =(Integer)request.getSession().getAttribute("applyid");
		Attachfile file = fileService.getFileByApplyId(applyid);
		List<Attachfile> files = new ArrayList<Attachfile>();
		files.add(file);
		return files;
		}

}
