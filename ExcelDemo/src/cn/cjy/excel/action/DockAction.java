package cn.cjy.excel.action;

import java.io.File;
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

import cn.cjy.excel.entity.DockExcel;
import cn.cjy.excel.service.IDockService;
import cn.cjy.excel.tools.Upload;

public class DockAction extends ActionSupport implements ModelDriven<DockExcel> {
	public File excel;
	public Upload upload;
	public String excelFileName;
	public IDockService dockService;
	private DockExcel form = new DockExcel();
	@Override
	public DockExcel getModel() {
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

	public IDockService getDockService() {
		return dockService;
	}
	public void setDockService(IDockService dockService) {
		this.dockService = dockService;
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
		form = getDock(sheet);
		System.out.println(form.toString());
		dockService.save(form);
		return "success";	
	}
	public String showAllDock() {
		ActionContext act = ActionContext.getContext();
		List<DockExcel> list = dockService.findAll();
		act.put("listDock", list);
		return "show";
	}
	public DockExcel getDock(Sheet sheet){
		DockExcel dock = new DockExcel();
		Row row = null;
		Cell cell = null;
		Cell cell2 = null;
		Cell cell3 = null;
		Cell cell4 = null;
		Cell cell5 = null;
		for(int i=1;i<sheet.getLastRowNum();i++){
			row = sheet.getRow(i);
			if(i==1){
				cell = row.getCell(1);
				dock.setEname(upload.getValue(cell));
			}else if(i==2){
				cell = row.getCell(1);
				dock.setEadderss(upload.getValue(cell));
			}else if(i==3){
				cell = row.getCell(1);
				cell4 = row.getCell(4);
				dock.setBelongTown(upload.getValue(cell));
				dock.setIndustry(upload.getValue(cell4));
			}else if(i==4){
				cell = row.getCell(1);
				cell3 = row.getCell(3);
				cell5 = row.getCell(5);
				dock.setEmanagePeople(upload.getValue(cell));
				dock.setEmanagePhone(upload.getValue(cell3));
				dock.setEmanageMail(upload.getValue(cell5));
			}else if(i==5){
				cell = row.getCell(1);
				cell3 = row.getCell(3);
				cell5 = row.getCell(5);
				dock.setEcontactPeople(upload.getValue(cell));
				dock.setEcontactPhone(upload.getValue(cell3));
				dock.setEcontactMail(upload.getValue(cell5));
			}else if(i==6){
				cell = row.getCell(1);
				cell3 = row.getCell(3);
				cell5 = row.getCell(5);
				dock.setServiceEnterprise(upload.getValue(cell));
				dock.setServiceContact(upload.getValue(cell3));
				dock.setServiceContactMail(upload.getValue(cell5));	
			}else if(i==7){
				cell3 = row.getCell(3);
				dock.setServiceContactPhone(upload.getValue(cell3));
			}else if(i==9){
				cell = row.getCell(1);
				dock.setProjectStartAndStopTime(upload.getValue(cell));
			}else if(i==10){
				cell = row.getCell(1);
				cell4 = row.getCell(4);
				dock.setProjectInvestmentTotal(Double.valueOf(upload.getValue(cell)));
				dock.setSystemAmount(Double.valueOf(upload.getValue(cell4)));
			}else if(i==11){
				cell4 = row.getCell(4);
				dock.setEquipmentAmount(Double.valueOf(upload.getValue(cell4)));
			}else if(i==12){
				cell4 = row.getCell(4);
				dock.setFixAmount(Double.valueOf(upload.getValue(cell4)));
			}else if(i==13){
				cell4 = row.getCell(4);
				dock.setOtherAmount(Double.valueOf(upload.getValue(cell4)));
			}else if(i==14){
				cell = row.getCell(1);
				cell3 = row.getCell(3);
				cell5 = row.getCell(5);
				dock.setFirstPoint(Integer.valueOf(upload.getValue(cell)));
				dock.setSecondPoint(Integer.valueOf(upload.getValue(cell3)));
				dock.setEquipmentPoint(Integer.valueOf(upload.getValue(cell5)));
			}else if(i==15){
				cell = row.getCell(1);
				dock.setDockMode(Integer.valueOf(upload.getValue(cell)));
			}else if(i==17){
				cell2 = row.getCell(2);
				dock.setDockAccount(upload.getValue(cell2));
			}else if(i==18){
				cell2 = row.getCell(2);
				dock.setDockPassword(upload.getValue(cell2));
			}else{
				continue;
			}
		}
		return dock;
	}
}
