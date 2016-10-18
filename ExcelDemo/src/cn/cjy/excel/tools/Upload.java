package cn.cjy.excel.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Upload {
	public static Workbook uploadFile(File file) throws Exception{
		Workbook work = null;
		InputStream inputFile = new FileInputStream(file);
		String fileName = file.getName();
		boolean suffix = fileName.endsWith(".xlsx");
		if(suffix){
			work = new XSSFWorkbook(inputFile);
		}else{
			work = new HSSFWorkbook(inputFile);
		}
		return work;
	}
	 public String getValue(Cell cell) {
		 String temp;
		 if (cell == null) {  
             System.out.println("该列为空，赋值双引号");  
             temp = "NULL";  
         } else {  
             int cellType = cell.getCellType();  
             switch (cellType) {  
             case Cell.CELL_TYPE_STRING:  
                 temp = cell.getStringCellValue().trim();   
                 break;  
             case Cell.CELL_TYPE_BOOLEAN:  
                 temp = String.valueOf(cell.getBooleanCellValue());  
                 break;  
             case Cell.CELL_TYPE_FORMULA:  
            	 cell.setCellType(cell.CELL_TYPE_NUMERIC);      
                 temp = String.valueOf(cell.getNumericCellValue());  
                 break;  
             case Cell.CELL_TYPE_NUMERIC:  
            	 if (HSSFDateUtil.isCellDateFormatted(cell)) {
            		 SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                     temp = df.format(cell.getDateCellValue()) ; 
                 } else {  
                     temp = new DecimalFormat("#.######").format(cell.getNumericCellValue());  
                 } 
                 break;  
             case Cell.CELL_TYPE_BLANK:  
                 temp = "NULL";  
                 break;  
             case Cell.CELL_TYPE_ERROR:  
                 temp = "ERROR";  
                 break;  
             default:  
                 temp = cell.toString().trim();  
                 break;  
             }  
         }
		return temp;
	 }	
}
