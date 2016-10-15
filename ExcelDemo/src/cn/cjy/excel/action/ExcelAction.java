package cn.cjy.excel.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


import cn.cjy.excel.entity.Excel;
import cn.cjy.excel.service.IExcelService;

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
		System.out.println(excelFileName);
		return "success";	
	}
	@Override
	public Excel getModel() {
		return form;
	}
}
