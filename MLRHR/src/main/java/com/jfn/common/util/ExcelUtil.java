package com.jfn.common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.alibaba.fastjson.JSONObject;
import com.jfn.vo.ExcelBase;
import com.jfn.vo.PersonFirstGroup;
import com.jfn.vo.PersonFirstTrial;
import com.jfn.vo.PersonSecondGroup;
import com.jfn.vo.PersonSecondTrial;
import com.jfn.vo.TeamFirstGroup;
import com.jfn.vo.TeamFirstTrial;
import com.jfn.vo.TeamSecondGroup;
import com.jfn.vo.TeamSecondTrial;

/**
 * Created by xubin on 2017/5/14
 */
public class ExcelUtil{
    /**
     * 组装excel文件
     */
    public static String writeExcel(ExcelBase excelBase, String path){

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        wb.setSheetName(0, "杰出青年");

        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("编号");
        headList.add("姓名");
        headList.add("性别");
        headList.add("出生日期");
        headList.add("技术职称");
        headList.add("研究方向");
        headList.add("单位名称");
        headList.add("推荐单位");
        headList.add("平均分(降序)");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            //headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));
        }

        /**
         * 设置数据行
         */
        int a = 0 ;
        int b = 1 ;
        for(int i = 0; i < excelBase.getJcqnList().size(); i++){
//        	String groupName = excelBase.getJcqnList().get(i).getGroupName();
        	Row rowdata = sheet.createRow(i+1+a);// 创建数据行
        	if (excelBase.getJcqnList().get(i).getGroupName().equals("汇总")) {
        		a--;
				continue;
			}
        	PersonFirstGroup vo = excelBase.getJcqnList().get(i);
                if (vo.getPersonFirstTrials().size() == 0) {
//                	a++;
                	Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getJcqnList().get(i).getGroupName()+"   "+ vo.getPersonFirstTrials().size()+"(人)");				             	
				}else {
					
					Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getJcqnList().get(i).getGroupName()+"   "+ vo.getPersonFirstTrials().size()+"(人)");				             	
                	
//                 for (PersonFirstTrial pTrial : vo.getPersonFirstTrials()) {
                	 for (int j = 0; j < vo.getPersonFirstTrials().size(); j++) {
                		 PersonFirstTrial pTrial = vo.getPersonFirstTrials().get(j);
                		
                	 Row rowdata2 = sheet.createRow(i + 1+j+1+a);// 创建数据行
                     Cell bianho = rowdata2.createCell(0);
                     Cell name = rowdata2.createCell(1);
                     Cell sex = rowdata2.createCell(2);
                     Cell birthday = rowdata2.createCell(3);
                     Cell technicalTitle = rowdata2.createCell(4);
                     Cell researchDirection = rowdata2.createCell(5);
                     Cell institution = rowdata2.createCell(6);
                     Cell recommandInstitution = rowdata2.createCell(7);
                     Cell score = rowdata2.createCell(8);
                     bianho.setCellValue(b);
                  	 b++;
                 	name.setCellValue(pTrial.getName());
                 	sex.setCellValue(pTrial.getSex());
                        if(pTrial.getBirthday() == null){
                     	   birthday.setCellValue(" ");
                        }
                        else{
                     	   birthday.setCellValue(pTrial.getBirthday());
                        }
                        technicalTitle.setCellValue(pTrial.getTechnicalTitle());
                      

                        researchDirection.setCellValue(pTrial.getResearchDirection());
                        institution.setCellValue(pTrial.getInstitution());
                    
                        recommandInstitution.setCellValue(pTrial.getRecommandInstitution());
                        BigDecimal bigDecimal = new BigDecimal(pTrial.getScore());  
                        double f1 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
                        score.setCellValue(f1);
                        a++;
     			}
           	}
          
        
        }
        writeExcelKjlj(excelBase,path,wb);
        writeExcelCxtd(excelBase,path,wb);
        String fileName = "chushen.xls";
        try{
        	File fileDir = new File(path);
        	if(!fileDir.exists()){
        		fileDir.mkdirs();
        	}
            FileOutputStream file = new FileOutputStream(path + fileName);
            wb.write(file);
            file.close();
        }catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		return fileName;


    }
    public static void writeExcelKjlj(ExcelBase excelBase,String path,Workbook wb){

        Sheet sheet = wb.createSheet();
        wb.setSheetName(1, "科技领军");
        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("编号");
        headList.add("姓名");
        headList.add("性别");
        headList.add("出生日期");
        headList.add("技术职称");
        headList.add("研究方向");
        headList.add("单位名称");
        headList.add("推荐单位");
        headList.add("平均分(降序)");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            //headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));
        }

        /**
         * 设置数据行
         */
        int a = 0 ;
        int b = 1;
        for(int i = 0; i < excelBase.getKjljList().size(); i++){
//        	String groupName = excelBase.getJcqnList().get(i).getGroupName();
        	Row rowdata = sheet.createRow(i+1+a);// 创建数据行
        	if (excelBase.getKjljList().get(i).getGroupName().equals("汇总")) {
        		a--;
				continue;
			}
        	PersonFirstGroup vo = excelBase.getKjljList().get(i);
                if (vo.getPersonFirstTrials().size() == 0) {
//                	a++;
                	Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getKjljList().get(i).getGroupName()+"   "+ vo.getPersonFirstTrials().size()+"(人)");				             	
				}else {
					
					Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getKjljList().get(i).getGroupName()+"   "+ vo.getPersonFirstTrials().size()+"(人)");				             	
//                 for (PersonFirstTrial pTrial : vo.getPersonFirstTrials()) {
                	 for (int j = 0; j < vo.getPersonFirstTrials().size(); j++) {
                		 PersonFirstTrial pTrial = vo.getPersonFirstTrials().get(j);
                		
                	 Row rowdata2 = sheet.createRow(i + 1+1+a);// 创建数据行
                     Cell bianho = rowdata2.createCell(0);
                     Cell name = rowdata2.createCell(1);
                     Cell sex = rowdata2.createCell(2);
                     Cell birthday = rowdata2.createCell(3);
                     Cell technicalTitle = rowdata2.createCell(4);
                     Cell researchDirection = rowdata2.createCell(5);
                     Cell institution = rowdata2.createCell(6);
                     Cell recommandInstitution = rowdata2.createCell(7);
                     Cell score = rowdata2.createCell(8);
                 	bianho.setCellValue(b);
                 	b++;
                 	name.setCellValue(pTrial.getName());
                 	sex.setCellValue(pTrial.getSex());
                        if(pTrial.getBirthday() == null){
                     	   birthday.setCellValue(" ");
                        }
                        else{
                     	   birthday.setCellValue(pTrial.getBirthday());
                        }
                        technicalTitle.setCellValue(pTrial.getTechnicalTitle());
                      

                        researchDirection.setCellValue(pTrial.getResearchDirection());
                        institution.setCellValue(pTrial.getInstitution());
                    
                        recommandInstitution.setCellValue(pTrial.getRecommandInstitution());
                        BigDecimal bigDecimal = new BigDecimal(pTrial.getScore());  
                        double f1 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
                        score.setCellValue(f1);
                        a++;
     			}
           	}
          
        
        }
       
        }
    
    
    public static void writeExcelCxtd(ExcelBase excelBase,String path,Workbook wb){

        Sheet sheet = wb.createSheet();
        wb.setSheetName(2, "创新团队");
        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("编号");
        headList.add("团队名称");
        headList.add("研究方向");
        headList.add("依托项目名称");
        headList.add("依托项目类别");
        headList.add("单位名称");
        headList.add("团队负责人");
        headList.add("平均分(降序)");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            //headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));
        }

        /**
         * 设置数据行
         */
        int a = 0 ;
        int b = 1;
        for(int i = 0; i < excelBase.getTeamFirstGroups().size(); i++){
//        	String groupName = excelBase.getJcqnList().get(i).getGroupName();
        	Row rowdata = sheet.createRow(i+1+a);// 创建数据行
        	if (excelBase.getTeamFirstGroups().get(i).getGroupName().equals("汇总")) {
        		a--;
				continue;
			}
        	TeamFirstGroup vo = excelBase.getTeamFirstGroups().get(i);
                if (vo.getTeamFirstTrials().size() == 0 || vo.getTeamFirstTrials().get(0).getTeamId() == null ) {
//                	a++;
                	Cell group = rowdata.createCell(0);
                	if (vo.getTeamFirstTrials().get(0).getTeamId() == null) {
                		group.setCellValue("小组："+excelBase.getTeamFirstGroups().get(i).getGroupName()+"  "+0+"(人)");
					}else {
						group.setCellValue("小组："+excelBase.getTeamFirstGroups().get(i).getGroupName()+"  "+ vo.getTeamFirstTrials().size()+"(人)");				
					}
				}else {
					
					Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getTeamFirstGroups().get(i).getGroupName()+"  "+ vo.getTeamFirstTrials().size()+"(人)");           	
//                 for (PersonFirstTrial pTrial : vo.getPersonFirstTrials()) {
                	 for (int j = 0; j < vo.getTeamFirstTrials().size(); j++) {
                		 TeamFirstTrial pTrial = vo.getTeamFirstTrials().get(j);
                		
                	 Row rowdata2 = sheet.createRow(i + 1+1+a);// 创建数据行
                     Cell bianho = rowdata2.createCell(0);
                     Cell teamName = rowdata2.createCell(1);
                     Cell fangxiang = rowdata2.createCell(2);
                     Cell projectName = rowdata2.createCell(3);
                     Cell projectType = rowdata2.createCell(4);
//                    所在单位
                     Cell researchDirection = rowdata2.createCell(5);
//                     推荐单位
//                     Cell institution = rowdata2.createCell(6);
//                     团队负责人
                     Cell teamLeader = rowdata2.createCell(6);
                     Cell score = rowdata2.createCell(7);
                 	bianho.setCellValue(b);
                 	b++;
                 	teamName.setCellValue(pTrial.getTeamName());
                 	fangxiang.setCellValue(pTrial.getSearchDirection());
                 	projectName.setCellValue(pTrial.getRelateProjectName());
                 	String type = pTrial.getRelateProjectCategory();
                 	char[] tpArray = type.toCharArray();
                 	String t = "";
                 	String x = "";
                 	String z = "";
                 	for (int k = 0; k < tpArray.length; k++) {
						String tString = String.valueOf(tpArray[k]);
						if (tString.equals("0") ) {
							t = "重大科研项目";
						}
						if (tString.equals("1")) {
							x = "重点工程项目";
						}
						if (tString.equals("2")) {
							z = pTrial.getOrther();
						}
					}
                 	projectType.setCellValue(t+","+x+","+z);
                 	researchDirection.setCellValue(pTrial.getInstitution());
//                 	institution.setCellValue(pTrial.getRecommandInstitution());
                 	teamLeader.setCellValue(pTrial.getTeamLeader());                      
                     BigDecimal bigDecimal = new BigDecimal(pTrial.getScore());  
                       double f1 = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();  
                       score.setCellValue(f1);
                        a++;
     			}
           	}
          
        
        }
       
        }
    
    
    public static void writeExcelSec(ExcelBase excelBase, String path){

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();
        wb.setSheetName(0, "杰出青年");

        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("编号");
        headList.add("姓名");
        headList.add("性别");
        headList.add("出生日期");
        headList.add("技术职称");
        headList.add("研究方向");
        headList.add("单位名称");
        headList.add("推荐单位");
        headList.add("得票率");
        headList.add("同意");
        headList.add("不同意");
        headList.add("弃权");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            //headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));
        }

        /**
         * 设置数据行
         */
        int a = 0 ;
        int b = 1 ;
        for(int i = 0; i < excelBase.getJcqnListSecondGroups().size(); i++){
//        	String groupName = excelBase.getJcqnList().get(i).getGroupName();
        	Row rowdata = sheet.createRow(i+1+a);// 创建数据行
        	if (excelBase.getJcqnListSecondGroups().get(i).getGroupName().equals("汇总")) {
        		a--;
				continue;
			}
        	PersonSecondGroup vo = excelBase.getJcqnListSecondGroups().get(i);
                if (vo.getPersonSecondTrials().size() == 0) {
//                	a++;
                	Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getJcqnListSecondGroups().get(i).getGroupName()+"   "+ vo.getPersonSecondTrials().size()+"(人)");				             	
				}else {
					
					Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getJcqnListSecondGroups().get(i).getGroupName()+"   "+ vo.getPersonSecondTrials().size()+"(人)");				             	
                	
//                 for (PersonFirstTrial pTrial : vo.getPersonFirstTrials()) {
                	 for (int j = 0; j < vo.getPersonSecondTrials().size(); j++) {
                		 PersonSecondTrial pTrial = vo.getPersonSecondTrials().get(j);
                		
                	 Row rowdata2 = sheet.createRow(i + 1+j+1+a);// 创建数据行
                     Cell bianho = rowdata2.createCell(0);
                     Cell name = rowdata2.createCell(1);
                     Cell sex = rowdata2.createCell(2);
                     Cell birthday = rowdata2.createCell(3);
                     Cell technicalTitle = rowdata2.createCell(4);
                     Cell researchDirection = rowdata2.createCell(5);
                     Cell institution = rowdata2.createCell(6);
                     Cell recommandInstitution = rowdata2.createCell(7);
                     Cell depiaolu = rowdata2.createCell(8);
                     Cell tongyi = rowdata2.createCell(9);
                     Cell butongyi = rowdata2.createCell(10);
                     Cell qiquan = rowdata2.createCell(11);
                     bianho.setCellValue(b);
                  	 b++;
                 	name.setCellValue(pTrial.getName());
                 	sex.setCellValue(pTrial.getSex());
                        if(pTrial.getBirthday() == null){
                     	   birthday.setCellValue(" ");
                        }
                        else{
                     	   birthday.setCellValue(pTrial.getBirthday());
                        }
                        technicalTitle.setCellValue(pTrial.getTechnicalTitle());
                      

                        researchDirection.setCellValue(pTrial.getResearchDirection());
                        institution.setCellValue(pTrial.getInstitution());
                    
                        recommandInstitution.setCellValue(pTrial.getRecommandInstitution());
                        depiaolu.setCellValue(pTrial.getVoteRate());
                        tongyi.setCellValue(pTrial.getAgreeNum());
                        butongyi.setCellValue(pTrial.getDisagreeNum());
                        qiquan.setCellValue(pTrial.getWaiverNum());
                        a++;
     			}
           	}
          
        
        }
        writeExcelKjljSec(excelBase,path,wb);
        writeExcelCxtdSec(excelBase,path,wb);
        String fileName = "fushen.xls";
        try{
            FileOutputStream file = new FileOutputStream(path + fileName);
            wb.write(file);
            file.close();
        }catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
    
    
    
    public static void writeExcelKjljSec(ExcelBase excelBase,String path,Workbook wb){

        Sheet sheet = wb.createSheet();
        wb.setSheetName(1, "科技领军");
        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("编号");
        headList.add("姓名");
        headList.add("性别");
        headList.add("出生日期");
        headList.add("技术职称");
        headList.add("研究方向");
        headList.add("单位名称");
        headList.add("推荐单位");
        headList.add("得票率");
        headList.add("同意");
        headList.add("不同意");
        headList.add("弃权");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            //headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));
        }

        /**
         * 设置数据行
         */
        int a = 0 ;
        int b = 1;
        for(int i = 0; i < excelBase.getKjljListSecondGroups().size(); i++){
//        	String groupName = excelBase.getJcqnList().get(i).getGroupName();
        	Row rowdata = sheet.createRow(i+1+a);// 创建数据行
        	if (excelBase.getKjljListSecondGroups().get(i).getGroupName().equals("汇总")) {
        		a--;
				continue;
			}
        	PersonSecondGroup vo = excelBase.getKjljListSecondGroups().get(i);
                if (vo.getPersonSecondTrials().size() == 0) {
//                	a++;
                	Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getKjljListSecondGroups().get(i).getGroupName()+"   "+ vo.getPersonSecondTrials().size()+"(人)");				             	
				}else {
					
					Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getKjljListSecondGroups().get(i).getGroupName()+"   "+ vo.getPersonSecondTrials().size()+"(人)");				             	
//                 for (PersonFirstTrial pTrial : vo.getPersonFirstTrials()) {
                	 for (int j = 0; j < vo.getPersonSecondTrials().size(); j++) {
                		 PersonSecondTrial pTrial = vo.getPersonSecondTrials().get(j);
                		
                	 Row rowdata2 = sheet.createRow(i + 1+1+a);// 创建数据行
                     Cell bianho = rowdata2.createCell(0);
                     Cell name = rowdata2.createCell(1);
                     Cell sex = rowdata2.createCell(2);
                     Cell birthday = rowdata2.createCell(3);
                     Cell technicalTitle = rowdata2.createCell(4);
                     Cell researchDirection = rowdata2.createCell(5);
                     Cell institution = rowdata2.createCell(6);
                     Cell recommandInstitution = rowdata2.createCell(7);
                     Cell depiaolu = rowdata2.createCell(8);
                     Cell tongyi = rowdata2.createCell(9);
                     Cell butongyi = rowdata2.createCell(10);
                     Cell qiquan = rowdata2.createCell(11);
                 	bianho.setCellValue(b);
                 	b++;
                 	name.setCellValue(pTrial.getName());
                 	sex.setCellValue(pTrial.getSex());
                        if(pTrial.getBirthday() == null){
                     	   birthday.setCellValue(" ");
                        }
                        else{
                     	   birthday.setCellValue(pTrial.getBirthday());
                        }
                        technicalTitle.setCellValue(pTrial.getTechnicalTitle());
                      

                        researchDirection.setCellValue(pTrial.getResearchDirection());
                        institution.setCellValue(pTrial.getInstitution());
                    
                        recommandInstitution.setCellValue(pTrial.getRecommandInstitution());
                        depiaolu.setCellValue(pTrial.getVoteRate());
                        tongyi.setCellValue(pTrial.getAgreeNum());
                        butongyi.setCellValue(pTrial.getDisagreeNum());
                        qiquan.setCellValue(pTrial.getWaiverNum());
                        a++;
     			}
           	}
          
        
        }
       
        }
    
    
    public static void writeExcelCxtdSec(ExcelBase excelBase,String path,Workbook wb){

        Sheet sheet = wb.createSheet();
        wb.setSheetName(2, "创新团队");
        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("编号");
        headList.add("团队名称");
        headList.add("研究方向");
        headList.add("依托项目名称");
        headList.add("依托项目类别");
        headList.add("单位名称");
        headList.add("团队负责人");
        headList.add("得票率");
        headList.add("同意");
        headList.add("不同意");
        headList.add("弃权");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
            //headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));
        }

        /**
         * 设置数据行
         */
        int a = 0 ;
        int b = 1;
        for(int i = 0; i < excelBase.getTeamSecondGroups().size(); i++){
//        	String groupName = excelBase.getJcqnList().get(i).getGroupName();
        	Row rowdata = sheet.createRow(i+1+a);// 创建数据行
        	if (excelBase.getTeamSecondGroups().get(i).getGroupName().equals("汇总")) {
        		a--;
				continue;
			}
        	TeamSecondGroup vo = excelBase.getTeamSecondGroups().get(i);
                if (vo.getTeamSecondTrials().size() == 0 || vo.getTeamSecondTrials().get(0).getTeamId() == null ) {
//                	a++;
                	Cell group = rowdata.createCell(0);
                	if (vo.getTeamSecondTrials().get(0).getTeamId() == null) {
                		group.setCellValue("小组："+excelBase.getTeamSecondGroups().get(i).getGroupName()+"  "+0+"(人)");
					}else {
						group.setCellValue("小组："+excelBase.getTeamSecondGroups().get(i).getGroupName()+"  "+ vo.getTeamSecondTrials().size()+"(人)");				
					}
				}else {
					
					Cell group = rowdata.createCell(0);
					group.setCellValue("小组："+excelBase.getTeamSecondGroups().get(i).getGroupName()+"  "+ vo.getTeamSecondTrials().size()+"(人)");           	
//                 for (PersonFirstTrial pTrial : vo.getPersonFirstTrials()) {
                	 for (int j = 0; j < vo.getTeamSecondTrials().size(); j++) {
                		 TeamSecondTrial pTrial = vo.getTeamSecondTrials().get(j);
                		
                	 Row rowdata2 = sheet.createRow(i + 1+1+a);// 创建数据行
                     Cell bianho = rowdata2.createCell(0);
                     Cell teamName = rowdata2.createCell(1);
                     Cell fangxiang = rowdata2.createCell(2);
                     Cell projectName = rowdata2.createCell(3);
                     Cell projectType = rowdata2.createCell(4);
//                    所在单位
                     Cell researchDirection = rowdata2.createCell(5);
//                     推荐单位
//                     Cell institution = rowdata2.createCell(6);
//                     团队负责人
                     Cell teamLeader = rowdata2.createCell(6);
                     Cell depiaolu = rowdata2.createCell(7);
                     Cell tongyi = rowdata2.createCell(8);
                     Cell butongyi = rowdata2.createCell(9);
                     Cell qiquan = rowdata2.createCell(10);
                 	bianho.setCellValue(b);
                 	b++;
                 	teamName.setCellValue(pTrial.getTeamName());
                 	fangxiang.setCellValue(pTrial.getSearchDirection());
                 	projectName.setCellValue(pTrial.getRelateProjectName());
                 	String type = pTrial.getRelateProjectCategory();
                 	char[] tpArray = type.toCharArray();
                 	String t = "";
                 	String x = "";
                 	String z = "";
                 	for (int k = 0; k < tpArray.length; k++) {
						String tString = String.valueOf(tpArray[k]);
						if (tString.equals("0") ) {
							t = "重大科研项目";
						}
						if (tString.equals("1")) {
							x = "重点工程项目";
						}
						if (tString.equals("2")) {
							z = pTrial.getOrther();
						}
					}
                 	projectType.setCellValue(t+","+x+","+z);
                 	researchDirection.setCellValue(pTrial.getInstitution());
//                 	institution.setCellValue(pTrial.getRecommandInstitution());
                 	teamLeader.setCellValue(pTrial.getTeamLeader());                      
                       depiaolu.setCellValue(pTrial.getVoteRate());
                       tongyi.setCellValue(pTrial.getAgreeNum());
                       butongyi.setCellValue(pTrial.getDisagreeNum());
                       qiquan.setCellValue(pTrial.getWaiverNum());
                        a++;
     			}
           	}
          
        
        }
       
        }
    
}
