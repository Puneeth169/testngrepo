package com.selenium.files;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {
	public static void main(String[] args) throws Exception {
		String[][] data= {{"Id","Name"},{"1","Puneeth"},{"2","Me"}};
		FileOutputStream fos=new FileOutputStream("C:\\Users\\2440637\\OneDrive - Cognizant\\Documents\\Excel sheets\\WriteData.xlsx");
		XSSFWorkbook book=new XSSFWorkbook();
		XSSFSheet sheet = book.createSheet("MySheet");
		for(int i=0;i<data.length;i++) {
			XSSFRow row = sheet.createRow(i);
			for(int j=0;j<data[i].length;j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellValue(data[i][j]);
			}
		}
		book.write(fos);
		book.close();
		fos.close();
	}
}
