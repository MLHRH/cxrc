package com.jfn.common.util;

import java.io.BufferedInputStream;
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
	public static Object uploadFile(HttpServletRequest request) throws IllegalStateException, IOException
    {
		JSONObject result = new JSONObject();
		String serverName = "";
		String clientName = "";
		String extName = "";
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
                {   clientName = files.getOriginalFilename();
                	serverName = UUID.randomUUID().toString();
                	 //扩展名格式：  
                    if (clientName.lastIndexOf(".") >= 0) {
                        extName = clientName.substring(clientName.lastIndexOf("."));
                    }
                    String realPath=path+serverName+extName;
                    File saveFile = new File(realPath);
                    if(!saveFile.getParentFile().exists()){
                    	saveFile.getParentFile().mkdirs();
                    }
                    //上传
                    files.transferTo(saveFile);
                    result.put("OLD", clientName);
                    result.put("NEW", saveFile.getName());
                    result.put("PATH", path);
                }
                 
            }
           
        }
        return result;
    }
	
	/**
	 * download文件
	 * @throws IOException 
	 */
	public static void downloadFile(HttpServletResponse response,Attachfile f) throws IOException {

		File file = new File(f.getFile_path()+f.getNewfilename());
		if (file.exists()) {
			String mimetype = "";
			javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
			mimetype = mtMap.getContentType(file);
			int bytes = 0;
			ServletOutputStream op = response.getOutputStream();
			response.setContentType(mimetype);
			response.setContentLength((int) file.length());
			response.setHeader("Content-Disposition", "attachment; filename=\"" + f.getOldfilename() + "\"");
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
	public static void downloadExcelFile(HttpServletResponse response,Attachfile f) throws IOException {

		File file = new File(f.getFile_path()+f.getNewfilename());
		if (file.exists()) {
			/*String mimetype = "";*/
			javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
			/*mimetype = mtMap.getContentType(file);*/
			int bytes = 0;
			ServletOutputStream op = response.getOutputStream();
			response.setContentLength((int) file.length());
			response.setHeader("Content-disposition",
					"attachment; filename="+f.getNewfilename());// 设定输出文件头
			response.setContentType("application/msexcel");//EXCEL格式  Microsoft excel
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
		String directory = request.getSession().getServletContext().getRealPath("/")+"fileUpload\\";
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
                    file.setOldfilename(clientName);
                    file.setFile_size(size);
                    file.setFile_path(directory);
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        
        return file;
	}

	public static void downloadPdfFile(HttpServletResponse response,Attachfile f) throws IOException {

//		String _file = f.getFile_path()+f.getNewfilename();
		 //设置发送到客户端响应的内容类型，浏览器会根据不同的MIME，调用不同的模块处理  
        response.setContentType("application/pdf");   
        ServletOutputStream out = response.getOutputStream();  
        File pdf = null;  
        BufferedInputStream buf = null;  
          
        try {  
            //调用初始化在web.xml中存放的参量  
//            String path ="D:\\MyData\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\MLRHR\\fileUpload\\jcqn.pdf"; 
//            String path = "C:\\Users\\bm\\Desktop\\T3.pdf";
            String path = (f.getFile_path()+f.getNewfilename()).replace("/", "\\");
            System.err.println(path);
            pdf = new File(path);  
            response.setContentLength((int) pdf.length());  //设置文件长度  
            FileInputStream input = new FileInputStream(pdf);  
            //带缓冲区的输入流  dd
            //ileInputStream是字节流，BufferedInputStream是字节缓冲流，使用BufferedInputStream读资源比FileInputStream读取资源的效率高  
            buf = new BufferedInputStream(input);  
            int readBytes = 0;  
              
            while ((readBytes = buf.read()) != -1) {  
                out.write(readBytes);  
            }  
        } catch (Exception e) {  
            System.out.println("文件没有找到");  
        }finally {  
            if (out != null) {  
                out.close();  
            }  
            if (buf != null) {  
                buf.close();  
            }  
        }  
		/*if (file.exists()) {
			String mimetype = "";
//			javax.activation.MimetypesFileTypeMap mtMap = new javax.activation.MimetypesFileTypeMap();
			mimetype = mtMap.getContentType(file);
			int bytes = -1;
			ServletOutputStream op = response.getOutputStream();
			response.setContentLength((int) file.length());
//			response.setHeader("Content-disposition", "attachment; filename="+f.getNewfilename());// 设定输出文件头
//			response.setContentType("text/html;charset=UTF-8");			
			response.setHeader("Content-type", "application/force-download");
			response.setHeader("Content-type", "application/pdf");
			response.setHeader("Content-disposition", "attachment; filename="+f.getNewfilename());  
//			response.setCharacterEncoding("UTF-8"); 
			 response.setContentType("application/pdf");//PDF格式 
			byte[] bbuf = new byte[1024*1024];
			DataInputStream in = new DataInputStream(new FileInputStream(file));
//			FileInputStream in = new FileInputStream(file);
			while ((in != null) && ((bytes = in.read(bbuf)) != -1)) {
				op.write(bbuf, 0, bytes);
			}
//			while((bytes = in.read(bbuf, 0, 1024*1024)) != -1){  
//				op.write(bbuf, 0, 1024*1024);  
//	        } 
			in.close();
			op.flush();
			op.close();*/
//		}
	     
	}

}
