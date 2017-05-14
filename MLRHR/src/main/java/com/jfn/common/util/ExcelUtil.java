package com.jfn.common.util;

import com.jfn.vo.ExcelBase;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xubin on 2017/5/14
 */
public class ExcelUtil{
    /**
     * 组装excel文件
     */
    public static void writeExcel(ExcelBase excelBase, String path){

        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet();

        /**
         * 设置Excel表的第一行即表头
         */
        Row row = sheet.createRow(0);

        List<String> headList = new ArrayList<String>();// 表头数据
        headList.add("出发地");
        headList.add("出发地币种");
        headList.add("IPCC");
        headList.add("IPCC币种");
        headList.add("GDS汇率");
        headList.add("GDS汇率变更时间");
        headList.add("投放汇率");
        headList.add("投放汇率变更时间");
        headList.add("汇率优势占比");
        headList.add("上次汇率优势占比");
        headList.add("较上次变动");

        for(int i = 0; i < headList.size(); i++){
            Cell headCell = row.createCell(i);
            headCell.setCellType(Cell.CELL_TYPE_STRING);
           /* headCell.setCellStyle(style);// 设置表头样式
            headCell.setCellValue(String.valueOf(headList.get(i)));*/
        }

        /**
         * 设置数据行
         */
        for(int i = 0; i < excelBase.getJcqnList().size(); i++){
            /*Row rowdata = sheet.createRow(i + 1);// 创建数据行
            RateShowVO vo = dataList.get(i);

            Cell fromcountry = rowdata.createCell(0);
            Cell currencyOrigin = rowdata.createCell(1);
            Cell ipcc = rowdata.createCell(2);
            Cell currencyIpcc = rowdata.createCell(3);
            Cell gdsRate = rowdata.createCell(4);
            Cell gdsdate = rowdata.createCell(5);
            Cell amount = rowdata.createCell(6);
            Cell amountdate = rowdata.createCell(7);
            Cell advantageRate = rowdata.createCell(8);
            Cell oldadvantageRate = rowdata.createCell(9);
            Cell diff = rowdata.createCell(10);

            fromcountry.setCellValue(vo.getFromcountry());
            currencyOrigin.setCellValue(vo.getCurrencyOrigin());
            ipcc.setCellValue(vo.getIpcc());
            currencyIpcc.setCellValue(vo.getCurrencyIpcc());
            gdsRate.setCellValue(vo.getGdsRate().doubleValue());
            if(vo.getGdsdate() == null){
                gdsdate.setCellValue(" ");
            }
            else{
                gdsdate.setCellValue(vo.getGdsdate());
            }

            amount.setCellValue(vo.getAmount().doubleValue());

            if(vo.getAmountdate() == null){
                amountdate.setCellValue(" ");
            }
            else{
                amountdate.setCellValue(vo.getAmountdate());
            }
            if(vo.getMin() != null){
                advantageRate.setCellStyle(styleDanger);
                oldadvantageRate.setCellStyle(styleDanger);
                diff.setCellStyle(styleDanger);
            }
            advantageRate.setCellValue(vo.getAdvantageRate().doubleValue());
            oldadvantageRate.setCellValue(vo.getOldadvantageRate().doubleValue());
            diff.setCellValue(vo.getDiff().doubleValue());*/
        }

        String fileName = "RateShow.xlsx";
        try{
            FileOutputStream file = new FileOutputStream(path + fileName);
            wb.write(file);
            file.close();
        }catch(Exception e){
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}
