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
import org.eclipse.jdt.internal.compiler.ast.SynchronizedStatement;
import org.springframework.util.FileCopyUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cn.cjy.excel.entity.Excel;
import cn.cjy.excel.service.IExcelService;
import cn.cjy.excel.tools.Upload;

public class ExcelAction extends ActionSupport implements ModelDriven<Excel>{
	public File excel;
	public Upload upload;
	public String excelFileName;
	public IExcelService excelService;
	private Excel form = new Excel();
	@Override
	public Excel getModel() {
		return form;
	}
	public Upload getUpload() {
		return upload;
	}
	public void setUpload(Upload upload) {
		this.upload = upload;
	}
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
		Workbook work = upload.uploadFile(uploadFile);
		Sheet sheet =  work.getSheetAt(0);
		for(int i=0;i<sheet.getLastRowNum();i++){
			Row row = sheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				Cell cell = row.getCell(j);
				if(i==0){
					System.out.println(upload.getValue(cell));
					break;
				}else if(i==(sheet.getLastRowNum()-1)){
					System.out.println(upload.getValue(cell));
					break;
				}else{
					System.out.print(upload.getValue(cell)+",");
				}
			}
			System.out.println();
		}
		return "success";	
	}
}
