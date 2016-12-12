package com.jfn.common.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.alibaba.fastjson.JSONObject;
import com.jfn.entity.Attachfile;


public class FileUtil {
	
	
	/*
     *采用spring提供的上传文件的方法
     */
	public static Attachfile  uploadFile(HttpServletRequest request,Attachfile file) throws IllegalStateException, IOException
    {
		//获取项目的跟路径
        String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator<String> iter=multiRequest.getFileNames();
             
            if(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile files=multiRequest.getFile(iter.next().toString());
                if(files!=null)
                {   long time = System.currentTimeMillis();
                    String realPath=path+time+files.getOriginalFilename();
                    File saveFile = new File(realPath);
                    if(!saveFile.getParentFile().exists()){
                    	saveFile.getParentFile().mkdirs();
                    }
                    //上传
                    files.transferTo(saveFile);
                    file.setFile_name(time+files.getOriginalFilename());
                    file.setFile_path(path);
                }
                 
            }
           
        }
        return file;
    }
	
	/**
	 * download文件
	 * @throws IOException 
	 */
	public static void downloadFile(HttpServletResponse response,Attachfile f) throws IOException {


		File file = new File(f.getFile_path()+f.getFile_name());
		if (file.exists()) {
			String mimetype = "";
			javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
			mimetype = mtMap.getContentType(file);
			int bytes = 0;
			ServletOutputStream op = response.getOutputStream();
			response.setContentType(mimetype);
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "attachment; filename=\"" + f.getFile_name() + "\"");
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
	
	@SuppressWarnings("unchecked")
	public static Attachfile saveRequestFiles(HttpServletRequest request) throws Exception {
		//获取项目的跟路径
		String directory = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
		DiskFileItemFactory fac = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(fac);
        upload.setHeaderEncoding("utf-8");
        List<FileItem> fileList = null;
        try {
            fileList = upload.parseRequest(request);
        } catch (FileUploadException ex) {
            throw ex;
        }
        
        Iterator<FileItem> it = fileList.iterator();
        String clientName = "";
        String serverName = "";
        String extName = "";
        Attachfile file = null;
        
        while (it.hasNext()) {
            FileItem item = it.next();
            if (!item.isFormField()) {
                clientName = item.getName();
                long size = item.getSize();
                String type = item.getContentType();
                if (clientName == null || clientName.trim().equals("")) {
                    continue;
                }
                //扩展名格式：  
                if (clientName.lastIndexOf(".") >= 0) {
                    extName = clientName.substring(clientName.lastIndexOf("."));
                }
                
                serverName = UUID.randomUUID().toString();
                
                File saveFile = new File(directory + serverName + extName);
                try {
                	if(!saveFile.getParentFile().exists()){
                		saveFile.getParentFile().mkdirs();
                	}
                    item.write(saveFile);
                    file = new Attachfile();
                    file.setFile_name(clientName);
                    file.setFile_size(size);
                    file.setFile_path(directory);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        
        return file;
	}


}
