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

import cn.cjy.excel.entity.Enterprise;
import cn.cjy.excel.service.IEnterpriseService;
import cn.cjy.excel.tools.Upload;

public class EnterpriseAction extends ActionSupport implements ModelDriven<Enterprise> {
	public File excel;
	public Upload upload;
	public String excelFileName;
	public IEnterpriseService enterpriseService;
	private Enterprise form = new Enterprise();
	@Override
	public Enterprise getModel() {
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

	public IEnterpriseService getEnterpriseService() {
		return enterpriseService;
	}
	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
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
		Workbook work = upload.uploadFile(uploadFile);
		Sheet sheet =  work.getSheetAt(0);
		List<Enterprise> list ;
		list = getEt(sheet);
		System.out.println(list.size());
		for(Enterprise e:list){
			enterpriseService.save(e);
		}
		return "success";	
	}
	public List<Enterprise> getEt(Sheet sheet){
		List<Enterprise> listEnterprise = new ArrayList<Enterprise>();
		Row row = null;
		Cell cell,cell2,cell3,cell4,cell5,cell6,cell7= null;
		for(int i=1;i<=sheet.getLastRowNum();i++){
			row = sheet.getRow(i);
			cell = row.getCell(0);
			if(upload.getValue(cell).equals("NULL")){
				break;
			}
			cell2 = row.getCell(1);
			cell3 = row.getCell(2);
			cell4 = row.getCell(3);
			cell5 = row.getCell(4);
			cell6 = row.getCell(5);
			cell7 = row.getCell(6);
			Enterprise enterprise = new Enterprise();
			enterprise.setName(upload.getValue(cell));
			enterprise.setDn(Double.valueOf(upload.getValue(cell2)));
			enterprise.setYm(Double.valueOf(upload.getValue(cell3)));
			enterprise.setCy(Double.valueOf(upload.getValue(cell4)));
			enterprise.setTr(Double.valueOf(upload.getValue(cell5)));
			enterprise.setZq(Double.valueOf(upload.getValue(cell6)));
			enterprise.setDate(upload.getValue(cell7));
			System.out.println(enterprise.toString());
			listEnterprise.add(enterprise);
		}
		System.out.println(listEnterprise.size());
		return listEnterprise;
	}
}
