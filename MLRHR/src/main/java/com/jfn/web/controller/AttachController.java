package com.jfn.web.controller;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.google.gson.JsonObject;
import com.jfn.entity.Attachfile;
import com.jfn.entity.User;
import com.jfn.service.AccountManager;
import com.jfn.service.FileService;
import com.jfn.service.NewsService;

@Controller
@RequestMapping("/")
public class AttachController {
	private static final Logger log = LoggerFactory.getLogger(AttachController.class);

	@Autowired
	private FileService service;
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private FileService fileservice;
	@Autowired
	private NewsService newsservice;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@ResponseBody
	@RequestMapping(value = "follow", method = RequestMethod.POST)
	public String follow(HttpServletRequest request) {
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		String follow_type = request.getParameter("ft");
		String follow_value = request.getParameter("fv");
		JsonObject jsonResponse = new JsonObject();
		String message = "";
		int status = 1;
		if ((user != null) && (follow_type != null) && (follow_value != null)) {
			// if( service.checkFollow( user.getId(),
			// Integer.valueOf( follow_type ), follow_value ) )
			// {
			// status = 2;
			// message = "You have been following this file list.";
			// }
			// else
			// {
			// if( service.follow( user.getId(),
			// Integer.valueOf( follow_type ), follow_value ) )
			// {
			// status = 1;
			// message = "You have successfully FOLLOWED this file list.";
			// }
			// }
		} else {
			status = 0;
			message = "FAILED to follow this file list! \n\nPlease contact Administrator or try again later.";
			log.error(message);
		}
		jsonResponse.addProperty("message", message);
		jsonResponse.addProperty("status", status);
		return jsonResponse.toString();
	}

	@ResponseBody
	@RequestMapping(value = "unfollow", method = RequestMethod.POST)
	public String unfollow(HttpServletRequest request) {
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		String follow_type = request.getParameter("ft");
		String follow_value = request.getParameter("fv");
		JsonObject jsonResponse = new JsonObject();
		String message = "FAILED to unfollow this file list! \n\nPlease contact Administrator or try again later.";
		int status = 2;
		if ((user != null) && (follow_type != null) && (follow_value != null)) {
			// if( service.unfollow( user.getId(), Integer.valueOf( follow_type
			// ),
			// follow_value ) )
			// {
			// message = "You have successfully UNFOLLOWED this file list.";
			// status = 1;
			// }
		}
		jsonResponse.addProperty("message", message);
		jsonResponse.addProperty("status", status);
		return jsonResponse.toString();
	}

	@RequestMapping(value = "files", method = RequestMethod.GET)
	public String showMenufiles(HttpServletRequest request, Model model) {
		int follow_type = 3;// 3: sub menu
		String follow_value = "";
		if (request.getParameter("fv") != null) {
			follow_value = request.getParameter("fv");
		}
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());
		// model.addAttribute( "isfollowed", service.checkFollow( user.getId(),
		// follow_type, follow_value ) ? 1 : 0 );
		// model.addAttribute( "fv", follow_value );
		// // get sub menu files
		// model.addAttribute( "files",
		// service.getFilesByTypeAndValue( follow_type, follow_value ) );
		return "files";
	}

	@RequestMapping(value = "filelist", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model) {
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());

		// get top 3 news
		model.addAttribute("topnews", newsservice.getAllTop());

		return "filelist";
	}

	@RequestMapping(value = "uploadfile", method = RequestMethod.GET)
	public String uploadwindow(Model model, HttpServletRequest request) {
		int fileType = 0;
		int fileTypeNum = 0;
		int userId;
		if (request.getParameter("ft") != null) {
			fileType = Integer.valueOf(request.getParameter("ft"));
			fileTypeNum = Integer.valueOf(request.getParameter("num"));
			userId = Integer.valueOf(request.getParameter("userId"));
			request.getSession().setAttribute("fileType", fileType);
			request.getSession().setAttribute("fileTypeNum", fileTypeNum);
			request.getSession().setAttribute("userId", userId);
			return "fileManager/uploadfile";
		} else
			return "404";

	}

	@Secured({ "ROLE_DELFILE" })
	@RequestMapping(value = "delfile", method = RequestMethod.POST)
	@ResponseBody
	public String deleteFile(HttpServletRequest request) {
		int id = Integer.valueOf(request.getParameter("id"));
		JsonObject jsonResponse = new JsonObject();
		String message = "FAILED to delete this file! \n\nPlease contact Administrator or try again later.";
		int status = 2;

		Attachfile af = service.getFileByID(id);
		if (service.deleteFile(af.getId())) {
			status = 1;
			message = "Selected file has been deleted.";
		}
		jsonResponse.addProperty("message", message);
		jsonResponse.addProperty("status", status);
		return jsonResponse.toString();
	}

	@RequestMapping(value = "downloadfile", method = RequestMethod.GET)
	public String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Attachfile f = service.getFileByID(id);
		File file = new File(f.getFile_path());
		if (file.exists()) {
			int bytes = 0;
			ServletOutputStream op = response.getOutputStream();
			response.setContentType(getMimeType(file));
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "inline; filename=\"" + f.getFile_name() + "\"");
			byte[] bbuf = new byte[1024];
			DataInputStream in = new DataInputStream(new FileInputStream(file));

			while ((in != null) && ((bytes = in.read(bbuf)) != -1)) {
				op.write(bbuf, 0, bytes);
			}
			in.close();
			op.flush();
			op.close();
		}
		return null;
	}

	private String getMimeType(File file) {
		String mimetype = "";
		if (file.exists()) {
			javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
			mimetype = mtMap.getContentType(file);
		}
		return mimetype;
	}

	// 人事处管理员审核页面_附件2
	@RequestMapping(value = "checkFile", method = RequestMethod.GET)
	public String checkFile(HttpServletRequest request, Model model) {
		return "fileManager/checkFile";
	}

	// 人事处管理员审核页面_附件3
	@RequestMapping(value = "checkFilePDF", method = RequestMethod.GET)
	public String checkFilePDF(HttpServletRequest request, Model model) {
		return "fileManager/checkFilePDF";
	}

	// 人事处管理员审核页面
	@RequestMapping(value = "fileListAll", method = RequestMethod.GET)
	@ResponseBody
	public String filelist(HttpServletRequest request, Model model) {
		String user_id = request.getParameter("user_id");
		String file_type = request.getParameter("file_type");
		if (user_id != null) {

			List<Attachfile> attachfile = fileservice.getFilesByUploaderAndType(Integer.parseInt(user_id), Integer.parseInt(file_type));
			JSONArray jsonArray = JSONArray.fromObject(attachfile);
			return jsonArray.toString();
		} else {
			return "404";
		}
	}
}
