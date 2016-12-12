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
		User user = (User) request.getSession().getAttribute("loginuser");
    	JSONObject result = new JSONObject();
    	try {
    		//上传文件到服务器
    		Attachfile file = FileUtil.saveRequestFiles(request);
    		if(file != null){
    			//插入上传文件记录
    			result = fileService.insetFileLog(file,user);
    		}
    		else{
    			result.put(Constant.STATUS, Constant.STAUS_FAIL);
    			result.put(Constant.MSG, "上传文件失败，请重新上传！");
    		}
		} catch (Exception e) {
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
	/**
	 * 显示文件信息
	 * @param request
	 * @param model
	 * @return
	 */
	
	@ResponseBody
	@RequestMapping(value = "showUpLoadFile", method = RequestMethod.GET)
	public Object showUpLoadFile(HttpServletRequest request, Model model) {
		int applyid =(Integer)request.getSession().getAttribute("applyid");
		Attachfile file = fileService.getFileByApplyId(applyid);
		List<Attachfile> files = new ArrayList<Attachfile>();
		files.add(file);
		return files;
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
