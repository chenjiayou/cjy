package cn.cjy.excel.action;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cn.cjy.excel.entity.Excel;
import cn.cjy.excel.service.IExcelService;
import cn.cjy.excel.tools.Upload;

public class ExcelAction extends ActionSupport implements ModelDriven<Excel>{
	public File excel;
	public String excelFileName;
	public IExcelService excelService;
	private Excel form = new Excel();
	public File getExcel() {
		return excel;
	}
	public void setExcel(File excel) {
		this.excel = excel;
	}
	public String getExcelFileName() {
		return excelFileName;
	}
	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}
	public IExcelService getExcelService() {
		return excelService;
	}
	public void setExcelService(IExcelService excelService) {
		this.excelService = excelService;
	}
	public String upload() throws Exception{
		ActionContext act = ActionContext.getContext();
		String realPath = ServletActionContext.getServletContext().getRealPath("/uploadfile/excel");
		File uploadFile = new File(realPath,excelFileName);
		if(!uploadFile.getParentFile().exists()){
			uploadFile.getParentFile().mkdirs();
		}
		FileCopyUtils.copy(excel, uploadFile);
		System.out.println(realPath+""+excelFileName);
		System.out.println(form.toString());
		Workbook work = Upload.uploadFile(uploadFile);
		Sheet sheet =  work.getSheetAt(0);
		for(int i=0;i<sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				Cell cell = row.getCell(j);
				System.out.print(getValue(cell)+",");
			}
			System.out.println();
		}
		return "success";	
	}
	@Override
	public Excel getModel() {
		return form;
	}
	 private String getValue(Cell cell) {
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
