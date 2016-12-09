package com.jfn.common.util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

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


}
