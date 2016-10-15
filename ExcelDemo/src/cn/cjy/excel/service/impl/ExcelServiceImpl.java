package cn.cjy.excel.service.impl;

import cn.cjy.excel.dao.IExcelDao;
import cn.cjy.excel.service.IExcelService;

public class ExcelServiceImpl implements IExcelService {
	public IExcelDao excelDao;

	public IExcelDao getExcelDao() {
		return excelDao;
	}

	public void setExcelDao(IExcelDao excelDao) {
		this.excelDao = excelDao;
	}


	
}
