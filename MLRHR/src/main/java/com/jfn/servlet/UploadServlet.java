package com.jfn.servlet;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jfn.common.util.ContextUtil;
import com.jfn.entity.Attachfile;
import com.jfn.service.FileService;

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 9196723809206800320L;

	private static final Logger log = LoggerFactory.getLogger(UploadServlet.class);

	// private final static String filedir = getFileDao().getFiledir();
	private String filedir = getExportFilePath();

	// 存放上传附件路径
	public String getExportFilePath() {
		String path = String.valueOf(this.getClass().getClassLoader().getResource("/").getPath());
		path = path.substring(1, path.lastIndexOf("MLRHR"));
		path = path.replaceAll("%20", " ");
		path = path + "attach/";
		return path;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("getfile") != null && !request.getParameter("getfile").isEmpty()) {
			//Attachfile f = getFileDao().getFileByID(Integer.valueOf(request.getParameter("getfile")));
			Attachfile f = new Attachfile();
			File file = new File(f.getFile_path());
			if (file.exists()) {
				int bytes = 0;
				ServletOutputStream op = response.getOutputStream();
				response.setContentType(getMimeType(file));
				response.setContentLength((int) file.length());
				response.setHeader("Content-disposition", "inline;filename=\"" + new String(f.getFile_name().getBytes("GBK"), "ISO8859-1") + "\"");
				byte[] bbuf = new byte[1024];
				DataInputStream in = new DataInputStream(new FileInputStream(file));

				while ((in != null) && ((bytes = in.read(bbuf)) != -1)) {
					op.write(bbuf, 0, bytes);
				}
				in.close();
				op.flush();
				op.close();
			}
		}

		/*if (request.getParameter("delfile") != null && !request.getParameter("delfile").isEmpty()) {
			//Attachfile af = getFileDao().getFileByID(Integer.valueOf(request.getParameter("delfile")));
			Attachfile af = new Attachfile();
			if (getFileDao().deleteFile(af.getId())) {
				File file = new File(af.getFile_path());
				if (file.exists()) {
					file.delete();
				}
			}
		}*/
		if (request.getParameter("delfile") == null && request.getParameter("getfile") == null) {
			int fileType = 0;
			int fileTypeNum = 0;
			int userId = 0;
			if (request.getSession().getAttribute("fileTypeNum") != null) {
				fileType = (Integer) request.getSession().getAttribute("fileType");
			}
			if (request.getSession().getAttribute("fileTypeNum") != null) {
				fileTypeNum = (Integer) request.getSession().getAttribute("fileTypeNum");
			}
			if (request.getSession().getAttribute("userId") != null) {
				userId = (Integer) request.getSession().getAttribute("userId");
			}
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter writer = response.getWriter();
			JSONArray json = new JSONArray();
			try {
				FileService fileservice = (FileService) ContextUtil.getInst().getBean("fileService");

				//List<Attachfile> attachfile = fileservice.getFilesByUploaderAndTypeAndNum(userId, fileType, fileTypeNum);
				List<Attachfile> attachfile = new ArrayList<Attachfile>();
				for (Attachfile fileobj : attachfile) {
					JSONObject jsono = new JSONObject();
					jsono.put("name", fileobj.getFile_name());
					jsono.put("size", fileobj.getFile_size());
					int attach_id = fileobj.getId();
					jsono.put("url", "UploadServlet?getfile=" + attach_id);
					jsono.put("delete_url", "UploadServlet?delfile=" + attach_id);
					jsono.put("delete_type", "GET");
					json.put(jsono);
					log.info(json.toString());
				}
			} catch (Exception e) {
				log.error("RuntimeException: " + e.getMessage());
				throw new RuntimeException(e);
			} finally {
				writer.write(json.toString());
				writer.close();
			}

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fileType = 0;
		int fileTypeNum = 0;
		int userId = 0;
		if (request.getSession().getAttribute("fileTypeNum") != null) {
			fileType = (Integer) request.getSession().getAttribute("fileType");
		}
		if (request.getSession().getAttribute("fileTypeNum") != null) {
			fileTypeNum = (Integer) request.getSession().getAttribute("fileTypeNum");
		}
		if (request.getSession().getAttribute("userId") != null) {
			userId = (Integer) request.getSession().getAttribute("userId");
		}
		if (!ServletFileUpload.isMultipartContent(request)) {
			throw new IllegalArgumentException("Request is not multipart, please 'multipart/form-data' enctype for your form.");
		}
		ServletFileUpload uploadHandler = new ServletFileUpload(new DiskFileItemFactory());
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter writer = response.getWriter();
		JSONArray json = new JSONArray();
		try {
			List<FileItem> items = uploadHandler.parseRequest(request);
			for (FileItem item : items) {
				if (!item.isFormField()) {
					File dir = new File(filedir);
					if (!dir.exists()) {
						if (!dir.mkdir()) {
							log.error("Failed to create a dir for uploading files.\nPlease check the upload directory of the server.( About line 45 of applicationContext.xml)");
							throw new Exception("Failed to create a dir for uploading files");
						}
					}
					File file = new File(filedir + Long.toString(System.currentTimeMillis()) + getSuffix(item.getName()));
					item.write(file); // save to server
					String savepath = filedir + file.getName();
					Attachfile f = new Attachfile();
					f.setFile_name(item.getName());
					f.setFile_path(savepath);
					f.setFile_size(item.getSize());
					f.setUploader_id(userId);
					f.setFile_type(fileType);
					f.setFile_type_num(fileTypeNum);

					SimpleDateFormat ft = null;
					Date date = null;
					Calendar cl = Calendar.getInstance();
					cl.setTime(new java.util.Date());
					date = cl.getTime();
					ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateTime = ft.format(date);
					f.setUpload_time(dateTime);

					/*int attach_id = getFileDao().newFile(f);*/
					int attach_id = 1;
					JSONObject jsono = new JSONObject();
					jsono.put("name", item.getName());
					jsono.put("size", item.getSize());
					jsono.put("url", "UploadServlet?getfile=" + attach_id);
					jsono.put("delete_url", "UploadServlet?delfile=" + attach_id);
					jsono.put("delete_type", "GET");
					json.put(jsono);
					log.info(json.toString());

				}
			}
		} catch (FileUploadException e) {
			log.error("File upload error: " + e.getMessage());
			throw new RuntimeException(e);
		} catch (Exception e) {
			log.error("RuntimeException: " + e.getMessage());
			throw new RuntimeException(e);
		} finally {
			writer.write(json.toString());
			writer.close();
		}
	}

	private String getMimeType(File file) {
		String mimetype = "";
		if (file.exists()) {
			javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
			mimetype = mtMap.getContentType(file);
		}
		return mimetype;
	}

	private String getSuffix(String filename) {
		String suffix = "";
		int pos = filename.lastIndexOf('.');
		if (pos > 0 && pos < filename.length() - 1) {
			suffix = filename.substring(pos);
		}
		return suffix;
	}

	/*private static FileDao getFileDao() {
		return (FileDao) ContextUtil.getInst().getBean("fileDao");
	}*/
}