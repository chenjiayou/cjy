package cn.cjy.excel.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
}
