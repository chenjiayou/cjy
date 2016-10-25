package cn.cjy.excel.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;
import org.springframework.util.FileCopyUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import cn.cjy.excel.entity.Company;
import cn.cjy.excel.service.ICompanyService;
import cn.cjy.excel.tools.Upload;

public class CompanyAction extends ActionSupport implements ModelDriven<Company> {
	public File excel;
	public Upload upload;
	public String excelFileName;
	public ICompanyService companyService;
	private Company form = new Company();
	@Override
	public Company getModel() {
		return form;
	}
	public File getExcel() {
		return excel;
	}
	public void setExcel(File excel) {
		this.excel = excel;
	}
	public Upload getUpload() {
		return upload;
	}
	public void setUpload(Upload upload) {
		this.upload = upload;
	}
	public String getExcelFileName() {
		return excelFileName;
	}
	public void setExcelFileName(String excelFileName) {
		this.excelFileName = excelFileName;
	}
	public ICompanyService getCompanyService() {
		return companyService;
	}
	public void setCompanyService(ICompanyService companyService) {
		this.companyService = companyService;
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
		List<Company> list ;
		list = getCompany(sheet);
		System.out.println(list.size());
		for(Company c:list){
			companyService.save(c);
		}
		return "success";	
	}
	public List<Company> getCompany(Sheet sheet){
		List<Company> listCompany = new ArrayList<Company>();
		Row row = null;
		Cell cell = null;
		for(int i=1;i<sheet.getLastRowNum();i++){
			row = sheet.getRow(i);
			Company company = new Company();
			cell = row.getCell(1);
			company.setName(upload.getValue(cell));
			listCompany.add(company);
		}
		return listCompany;
	}
}
