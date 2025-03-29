package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IPathConstatnt.testDataPath);
		Workbook wb = WorkbookFactory.create(file);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		return data;	
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IPathConstatnt.testDataPath);
		Workbook wb = WorkbookFactory.create(file);
		int rowCount =wb.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IPathConstatnt.testDataPath);
		Workbook wb = WorkbookFactory.create(file);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
	}

}
