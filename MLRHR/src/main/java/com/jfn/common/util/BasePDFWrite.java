package com.jfn.common.util;


import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfn.entity.JcqnDoc01;
import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.JcqnDoc05;
import com.jfn.entity.JcqnDocPatent;
import com.jfn.entity.JcqnDocPrize;
import com.jfn.entity.JcqnDocProject;
import com.jfn.entity.JcqnDocReport;
import com.jfn.entity.JcqnDocThesis;
import com.jfn.entity.JcqnDocTreatise;
import com.jfn.entity.UesrZuzhi;
import com.jfn.entity.UserPeixun;
import com.jfn.entity.UserWork;


public class BasePDFWrite {

    Document document = null;// 建立一个Document对象      
    private static Font headFont ;
    private static Font keyFont ;
    private static Font textfont_H ;
    private static Font textfont_B ;
    int maxWidth = 520;

    static{    
        BaseFont bfChinese_H;
        try {    
            /** 
             * 新建一个字体,iText的方法 STSongStd-Light 是字体，在iTextAsian.jar 中以property为后缀 
             * UniGB-UCS2-H 是编码，在iTextAsian.jar 中以cmap为后缀 H 代表文字版式是 横版， 相应的 V 代表竖版  
             */
            bfChinese_H = BaseFont.createFont("STSong-Light","UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);    

            headFont = new Font(bfChinese_H, 10, Font.NORMAL);   
            keyFont = new Font(bfChinese_H, 18, Font.BOLD); 
            textfont_H = new Font(bfChinese_H, 10, Font.NORMAL); 
            textfont_B = new Font(bfChinese_H, 12, Font.NORMAL); 

        } catch (Exception e) {             
            e.printStackTrace();    
        }     
    }

    /**
     * 设置页面属性
     * @param file
     */
    public BasePDFWrite(File file,HttpServletResponse response) {

        //自定义纸张
//        Rectangle rectPageSize = new Rectangle(350, 620);
    	response.setContentType("application/x-msdownload");
        response.setHeader("Content-Disposition","attachment;filename=a.pdf");
        // 定义A4页面大小
        Rectangle rectPageSize = new Rectangle(PageSize.A4);  
        rectPageSize = rectPageSize.rotate();// 加上这句可以实现页面的横置
        document = new Document(rectPageSize,10, 150, 10, 40);

        try {
            PdfWriter.getInstance(document,new FileOutputStream(file));    
            document.open();
        } catch (Exception e) {
            e.printStackTrace();    
        }
    }

    /**
     * 建表格(以列的数量建)
     * @param colNumber
     * @return
     */
    public PdfPTable createTable(int colNumber){    
        PdfPTable table = new PdfPTable(colNumber);    
        try{    
            //table.setTotalWidth(maxWidth);    
            //table.setLockedWidth(true);    
            table.setHorizontalAlignment(Element.ALIGN_CENTER);         
            table.getDefaultCell().setBorder(1); 
            table.setSpacingBefore(10);
            table.setWidthPercentage(100);
        }catch(Exception e){    
            e.printStackTrace();    
        }    
        return table;
    }

    /**
     * 建表格(以列的宽度比建)
     * @param widths
     * @return
     */
    public PdfPTable createTable(float[] widths){    
        PdfPTable table = new PdfPTable(widths);    
        try{    
            //table.setTotalWidth(maxWidth);    
            //table.setLockedWidth(true);    
            table.setHorizontalAlignment(Element.ALIGN_CENTER);         
            table.getDefaultCell().setBorder(1); 
            table.setSpacingBefore(10);
            table.setWidthPercentage(100);
        }catch(Exception e){    
            e.printStackTrace();    
        }    
        return table;    
    }


    /**
     * 表格中单元格
     * @param value
     * @param font
     * @param align
     * @return
     */
    public PdfPCell createCell(String value,Font font,int align){    
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);            
        cell.setHorizontalAlignment(align);        
        cell.setPhrase(new Phrase(value,font));    
        return cell;    
    }

    /**
     * 表格中单元格
     * @param value
     * @param font
     * @param align
     * @param colspan
     * @param rowspan
     * @return
     */
    public PdfPCell createCell(String value,Font font,int align_v,int align_h,int colspan,int rowspan){
        PdfPCell cell = new PdfPCell();    
        cell.setVerticalAlignment(align_v);    
        cell.setHorizontalAlignment(align_h);        
        cell.setColspan(colspan); 
        cell.setRowspan(rowspan); 
        cell.setPhrase(new Phrase(value,font));  
        return cell;
    }

    /**
     * 建短语
     * @param value
     * @param font
     * @return
     */
    public Phrase createPhrase(String value,Font font){ 
        Phrase phrase = new Phrase();
        phrase.add(value);
        phrase.setFont(font);
        return phrase;
    }  

    /**
     * 建段落
     * @param value
     * @param font
     * @param align
     * @return
     */
    public Paragraph createParagraph(String value,Font font,int align){ 
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Phrase(value,font));
        paragraph.setAlignment(align);
        return paragraph;
    }


    public void generateJcqnPDF(JcqnDoc01 jcqn,List<UserPeixun> userPeixuns,List<UserWork> work,List<UesrZuzhi> uesrZuzhis,List<JcqnDocProject> jcqnDocProjects,List<JcqnDocPrize> jcqnDocPrizes,List<JcqnDocThesis> jcqnDocThesis,
    		List<JcqnDocPatent>  jcqnDocPatents,List<JcqnDocReport> jcqnDocReports,List<JcqnDocTreatise> jcqnDocTreatises,JcqnDoc03 jcqn03,JcqnDoc04 jcqn04,JcqnDoc05 jcqn05) throws Exception{     

        //页头信息
//        document.add(createParagraph("【XXXX有限公司】",headFont,Element.ALIGN_LEFT));
        document.add(createParagraph("基本情况",keyFont,Element.ALIGN_CENTER));
//        document.add(createParagraph("编号：XD201602000003",headFont,Element.ALIGN_RIGHT));

        //表格信息
        float[] widths = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table = createTable(widths);   

//        table.addCell(createCell("顾客信息", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,4)); 

        table.addCell(createCell("姓名：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));    
        table.addCell(createCell(jcqn.getName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("性别：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));    
        table.addCell(createCell(jcqn.getSex(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("民族：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));    
        table.addCell(createCell(jcqn.getMinzu(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
       
        table.addCell(createCell("出生日期：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getBirthday(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("技术职称：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getTitle(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("证件类型：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getDocument_type(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("证件号码：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getDocument_number(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));

        table.addCell(createCell("研究方向：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getDirection(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("申报领域：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getDeclaration_area(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("办公室电话：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getTelephone(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("传真：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getFax(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("手机：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getMobile_phone(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("Email：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getEmail(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("邮编：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getZip_code(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("通讯地址：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getAddresses(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
//      设置抬头   条数为list.size 不写死
        if (userPeixuns == null) {
        	table.addCell(createCell("学习经历", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));	
        	table.addCell(createCell("国家", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
	        table.addCell(createCell("院校", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
	        table.addCell(createCell("专业", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
	        table.addCell(createCell("学历/学位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
	        table.addCell(createCell("开始时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
	        table.addCell(createCell("结束时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
		}else {
			table.addCell(createCell("学习经历", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,userPeixuns.size()+1));
			table.addCell(createCell("国家", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
			table.addCell(createCell("院校", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
			table.addCell(createCell("专业", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
			table.addCell(createCell("学历/学位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
			table.addCell(createCell("开始时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
			table.addCell(createCell("结束时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
			for (UserPeixun peixun : userPeixuns) {
				table.addCell(createCell(peixun.getCountry(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
		        table.addCell(createCell(peixun.getAcademy(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
		        table.addCell(createCell(peixun.getMajor(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
		        table.addCell(createCell(peixun.getXueli(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
		        table.addCell(createCell(peixun.getStart_date(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
		        table.addCell(createCell(peixun.getEnd_date(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
			}
		}
   
        if(work == null){
        	 table.addCell(createCell("工作经历", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
        	 table.addCell(createCell("国家", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table.addCell(createCell("单位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
             table.addCell(createCell("职务", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table.addCell(createCell("开始时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table.addCell(createCell("结束时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        }else {
        	table.addCell(createCell("工作经历", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,work.size()+1)); 
       	    table.addCell(createCell("国家", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table.addCell(createCell("单位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
            table.addCell(createCell("职务", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table.addCell(createCell("开始时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table.addCell(createCell("结束时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
            for (UserWork userWork : work) {
            	table.addCell(createCell(userWork.getCountry(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
                table.addCell(createCell(userWork.getWork_content(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
                table.addCell(createCell(userWork.getZhiwu(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
                table.addCell(createCell(userWork.getStart_date(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
                table.addCell(createCell(userWork.getEnd_date(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
			}
		}

        
//      设置抬头   条数为list.size 不写死 6List<UesrZuzhi> uesrZuzhis
        if (uesrZuzhis == null) {
        	table.addCell(createCell("国内外学术组织及重要学术期刊任职情况", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));   
        	table.addCell(createCell("组织或期刊名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,4,1)); 
            table.addCell(createCell("职位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,4,1)); 
            table.addCell(createCell("任期", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
		}else {
			table.addCell(createCell("国内外学术组织及重要学术期刊任职情况", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,uesrZuzhis.size()+1));   
        	table.addCell(createCell("组织或期刊名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,4,1)); 
            table.addCell(createCell("职位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,4,1)); 
            table.addCell(createCell("任期", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
            for (UesrZuzhi uesrZuzhi : uesrZuzhis) {
            	 table.addCell(createCell(uesrZuzhi.getZuzhi_name(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,4,1)); 
                 table.addCell(createCell(uesrZuzhi.getZuzhi_job(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,4,1)); 
                 table.addCell(createCell(uesrZuzhi.getZuzhi_renqi(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
			}
		}
        
        table.addCell(createCell("单位名称：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getUnit_name(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("组织机构代码：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getOrganization_code(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("法定代表人：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getLegal_representative(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("上级主管单位：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getSupervisor_unit(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("单位地址：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getUnit_address(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        table.addCell(createCell("邮编：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));    
        table.addCell(createCell(jcqn.getPostcode(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
        
        table.addCell(createCell("单位联系人：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));    
        table.addCell(createCell(jcqn.getUnit_contact(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("电话：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));    
        table.addCell(createCell(jcqn.getWork_telephone(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        table.addCell(createCell("传真：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table.addCell(createCell(jcqn.getWork_fax(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        document.add(table);
        document.add(createParagraph("近五年科研情况",keyFont,Element.ALIGN_CENTER));
        float[] width2 = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table2 = createTable(width2); 
        document.add(createParagraph("承担主要科研任务情况",textfont_H,Element.ALIGN_CENTER));
        table2.addCell(createCell("项目名称家", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
        table2.addCell(createCell("立项编号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table2.addCell(createCell("经费(万元)", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table2.addCell(createCell("起止年月", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table2.addCell(createCell("项目性质及来源", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table2.addCell(createCell("担任角色", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        if(jcqnDocProjects != null){
        	for (JcqnDocProject project : jcqnDocProjects) {
        		table2.addCell(createCell(project.getEntryName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
        		table2.addCell(createCell(project.getProjectNumber(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        		table2.addCell(createCell(project.getFunds(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        		table2.addCell(createCell(project.getStartStopTime(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        		table2.addCell(createCell(project.getProjectNature(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        		table2.addCell(createCell(project.getRole(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));				
			}
		}
        document.add(table2);
        float[] width3 = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table3 = createTable(width3); 
        document.add(createParagraph("获得主要科研学术奖励情况",textfont_H,Element.ALIGN_CENTER));
        table3.addCell(createCell("获奖项目名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
        table3.addCell(createCell("奖励名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table3.addCell(createCell("等级", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table3.addCell(createCell("排序", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table3.addCell(createCell("获奖时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table3.addCell(createCell("授予机构", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        for (JcqnDocPrize prize : jcqnDocPrizes) {
        	table3.addCell(createCell(prize.getAwardItemName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
            table3.addCell(createCell(prize.getPrizeName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table3.addCell(createCell(prize.getGrade(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table3.addCell(createCell(prize.getSort(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table3.addCell(createCell(prize.getRewardTime(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table3.addCell(createCell(prize.getGrantInstitution(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
		}
        document.add(table3);
        float[] width4 = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table4 = createTable(width4); 
        document.add(createParagraph("代表性论文",textfont_H,Element.ALIGN_CENTER));
        table4.addCell(createCell("论文题目", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
        table4.addCell(createCell("作者排序（通讯作者请标注*）", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table4.addCell(createCell("期刊名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table4.addCell(createCell("年份、卷期及页码", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table4.addCell(createCell("影响因子", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table4.addCell(createCell("SCI他引次数", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        table4.addCell(createCell("他引总次数", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
        for (JcqnDocThesis thesis : jcqnDocThesis) {
        	 table4.addCell(createCell(thesis.getThesisTopic(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
             table4.addCell(createCell(thesis.getAuthorSort(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table4.addCell(createCell(thesis.getJournalTitle(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table4.addCell(createCell(thesis.getYearVolumePagenumber(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table4.addCell(createCell(thesis.getInfluenceFactor(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
             table4.addCell(createCell(thesis.getSciTimes(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
             table4.addCell(createCell(thesis.getNumberTotal(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
		}
        document.add(table4);
        float[] width5 = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table5 = createTable(width5); 
        document.add(createParagraph("获得授权专利情况",textfont_H,Element.ALIGN_CENTER));
        table5.addCell(createCell("专利名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
        table5.addCell(createCell("授权号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table5.addCell(createCell("类别", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table5.addCell(createCell("发明人或设计人排序", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table5.addCell(createCell("授权时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table5.addCell(createCell("授权国别或组织", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        for (JcqnDocPatent patent : jcqnDocPatents) {
        	table5.addCell(createCell(patent.getPatentName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
            table5.addCell(createCell(patent.getGrantNumber(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table5.addCell(createCell(patent.getType(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table5.addCell(createCell(patent.getInventorSort(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table5.addCell(createCell(patent.getAuthorizedTime(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table5.addCell(createCell(patent.getAuthorizedNational(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
		}
        document.add(table5);
        float[] width6 = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table6 = createTable(width6); 
        document.add(createParagraph("在重要国际学术会议报告情况",textfont_H,Element.ALIGN_CENTER));
        table6.addCell(createCell("报告名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
        table6.addCell(createCell("会议名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table6.addCell(createCell("主办方", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table6.addCell(createCell("时间", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table6.addCell(createCell("地点", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
        table6.addCell(createCell("报告类别", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
        for (JcqnDocReport report : jcqnDocReports) {
        	table6.addCell(createCell(report.getReportName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));  
            table6.addCell(createCell(report.getMeetingName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table6.addCell(createCell(report.getOrganizers(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table6.addCell(createCell(report.getMeetingTime(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table6.addCell(createCell(report.getMeetingPlace(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
            table6.addCell(createCell(report.getReportType(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
		}
        document.add(table6);
        float[] width7 = {8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f,8f};
        PdfPTable table7 = createTable(width7); 
        document.add(createParagraph("重要专著情况（不超过5项）",textfont_H,Element.ALIGN_CENTER));
        table7.addCell(createCell("专著名称", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));  
        table7.addCell(createCell("出版社", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
        table7.addCell(createCell("发行国家和地区", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
        table7.addCell(createCell("年份", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
        for (JcqnDocTreatise treatise : jcqnDocTreatises) {
        	table7.addCell(createCell(treatise.getTreatiseName(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));  
            table7.addCell(createCell(treatise.getPress(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
            table7.addCell(createCell(treatise.getIssuingCountry(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
            table7.addCell(createCell(treatise.getYear(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1)); 
		}
        document.add(table7);
        document.add(createParagraph("推荐人自我评价",keyFont,Element.ALIGN_CENTER));
        //表格信息
        float[] width8 = {12f};
        PdfPTable table8 = createTable(width8); 
        table8.setSplitRows(false);
        table8.addCell(createCell(jcqn03.getSelfAssessment(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        document.add(table8);
        
        document.add(createParagraph("未来研究计划及当前研究基础",keyFont,Element.ALIGN_CENTER));
        //表格信息
        float[] width9 = {12f};
        PdfPTable table9 = createTable(width9); 
        table9.setSplitRows(false);
        table9.addCell(createCell(this.tagToLowerCaseAndComplete(this.reEscapeHtml(jcqn04.getFuturePlans())), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        document.add(table9);
        document.add(createParagraph("工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施",keyFont,Element.ALIGN_CENTER));
        //表格信息
        float[] width10 = {12f};
        PdfPTable table10 = createTable(width10); 
        table10.setSplitRows(false);
        table10.addCell(createCell(jcqn05.getNeedsRelevanceSupport(), textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
        document.add(table10);
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,6,1)); 
//
//        table.addCell(createCell("联系地址", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,6,1)); 
//
//        table.addCell(createCell("采购经办人", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1));
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("经办人电话", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
//        table.addCell(createCell("经办人手机", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//
//
////        table.addCell(createCell("产品订购清单", textfont_H, Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,8));
//
//        table.addCell(createCell("序号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
//        table.addCell(createCell("产品信息", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,2,1)); 
//        table.addCell(createCell("规格型号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
//        table.addCell(createCell("单位", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
//        table.addCell(createCell("单价", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1)); 
//        table.addCell(createCell("数量", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
//        table.addCell(createCell("小计", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,1));
//
//        table.addCell(createCell("1", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("塑料纸", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1)); 
//        table.addCell(createCell("小号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("个", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("400", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//
//        table.addCell(createCell("2", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("塑料纸", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1)); 
//        table.addCell(createCell("小号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("个", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("400", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//
//        table.addCell(createCell("3", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("塑料纸", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1)); 
//        table.addCell(createCell("小号", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("个", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("400", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//
//
//
//        table.addCell(createCell("4", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("合计", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1)); 
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("20", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1)); 
//        table.addCell(createCell("60", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//        table.addCell(createCell("1200", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,1,1));
//
//
//        table.addCell(createCell("合计金额（元）", textfont_B,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,3,1));
//        table.addCell(createCell("壹仟俩佰元", textfont_B,Element.ALIGN_MIDDLE, Element.ALIGN_RIGHT,6,1));
//
//
//        table.addCell(createCell("顾客确认", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_CENTER,1,3));
//
//        table.addCell(createCell("注：本人已充分了解订购产品的功能用途，是根据实际需要自愿购买的。", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,8,1));
//
//        table.addCell(createCell("采购经办人签字：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,6,1));
//        table.addCell(createCell("盖章：", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,2,1));
//
//        table.addCell(createCell("签字日期", textfont_H,Element.ALIGN_MIDDLE, Element.ALIGN_LEFT,8,1));
           
        document.close();    
    }

    /** 
     * 基本过滤，主要过滤特殊字符与下载时不规则字符，过滤table样式 
     * @param result 
     * @return 
     */  
    public static String reEscapeHtml(String result) {  
        String temp = result;  
      //匹配script整个标签的正则  
        final String scriptRegx = "(?i)(<SCRIPT)[\\s\\S]*?((</SCRIPT>)|(/>))";  
        //匹配换行的正则    
        final String brRegx = "(?i)(</*br.*?>)";  
        //空格  
        final String nbspRegx = "(&|&amp;)nbsp;";  
        //table  
        final String tableRegx = "(?i)(<table (?!ignore=\"true\").*?>)";  
        //img  
        final String imgRegx = "(?i)(<img\\s.*?>)";  
        temp = temp.replaceAll(scriptRegx, "")  
                .replaceAll("\r|\n|\\r|\\n|\r\n|\\r\\n|\t|\\t", "")  
                .replaceAll(imgRegx, "")  
                .replaceAll(brRegx, "<br />")  
                .replaceAll(nbspRegx, " ")  
                .replaceAll(" ", " ")  
                .replaceAll(tableRegx, "<table class=\"cm_tb\" style=\"width:100%;table-layout:fixed; word-break:break-strict;\">")  
                ;  
          
        return temp;  
    }
    /**  
     * 标签转小写，转完小写，顺便补全引号  
     * @param temp  
     * @return  
     */  
    public static String tagToLowerCaseAndComplete(String temp) {  
        //标签开始的匹配  
        final String tagRegx = "<[A-Za-z].*?>";  
        Pattern p = null;  
        Matcher matcher = null;  
        p = Pattern.compile(tagRegx);  
        matcher = p.matcher(temp);  
        while (matcher.find()) {  
            String value = matcher.group(0);  
            if (null == value || "".equals(value))  
                continue;  
            String tmpValue = value.toLowerCase();  
          //自动补全引号，加这里而不加外面  
            tmpValue = reCompletionQuoat(tmpValue);  
            //tmpValue = removeWidthAndHeightInTag(tmpValue);  
            temp = replaceStr(temp, value, tmpValue);  
              
        }  
        //结束标签的匹配  
        final String tagEndRegx = "</[A-Za-z]+>";  
        p = Pattern.compile(tagEndRegx);  
        matcher = p.matcher(temp);  
        while (matcher.find()) {  
            String value = matcher.group(0);  
            if (null == value || "".equals(value))  
                continue;  
            temp = replaceStr(temp, value, value.toLowerCase());  
        }  
        return temp;  
    }  
      
    /** 
     * 自动补全引号（接上一步的标签转小写） 
     * @param str 
     * @return 
     */  
    public static String reCompletionQuoat(String tag) {  
        final String tagRegx = "([A-Za-z]+)=([^\"|\']*?)(>|\\s)";  
        Pattern p = Pattern.compile(tagRegx);  
        Matcher m = p.matcher(tag);  
        while (m.find()) {  
            String tmp = m.group(0);  
            String key = m.group(1);  
            if (null == key || "".equals(key.trim()))  
                continue;  
            String value = "\"" + m.group(2) + "\"";  
            String end = m.group(3);  
            tag = replaceStr(tag, tmp, (key + "=" + value + end));  
        }  
        return tag;  
    }  
      
      
    /** 
     * width="1024px"|width='1024px'|width:1024px|width:1024px; 
     * 对于width，上面的example都可以过滤，height与width同样规则 
     * 对于width="50%"这样的，是不过滤的 
     * @param tag 
     * @return 
     */  
    public static String removeTableWidthAndHeight(String result) {  
        String widthAndHeightRegx = "(width|height)(=|:|\\s*?:\\s*?)(\"|\')*\\d+px(\"|\'|;)*";  
        //String tableRegx = "(?i)(<table (?!ignore=\"true\").*?>.*?</table>)";  
        return result.replaceAll(widthAndHeightRegx, "");  
    }  
      
    public static String replaceStr(String sourceStr, String targetStr, String insertStr) {  
        int index = sourceStr.indexOf(targetStr);  
        if (index == -1)  
            return sourceStr;  
        String preStr = sourceStr.substring(0, index);  
        String afterStr = sourceStr.substring(index + targetStr.length());  
          
        return preStr + insertStr + afterStr;  
    }  
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\bm\\Desktop\\T3.pdf");

        file.createNewFile();
//        new BasePDFWrite(file).generateJcqnPDF(); 
    }
}