package com.selenium.files;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static void main(String[] args)throws Exception {
		ReadExcelData rd=new ReadExcelData();
		rd.readData();
	}
	public Object[][] readData() throws Exception {
		File xml=new File("C:\\Users\\2440637\\OneDrive - Cognizant\\Documents\\Excel sheets\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(xml);
		Workbook book=new XSSFWorkbook(fis);
		Sheet s=book.getSheetAt(0);
		Object[][] data=new Object[s.getPhysicalNumberOfRows()-1][];
		for(int i=1;i<s.getPhysicalNumberOfRows();i++) {
			Row row = s.getRow(i);
			data[i-1]=new Object[row.getPhysicalNumberOfCells()-1];
			for(int j=0;j<row.getLastCellNum()-1;j++) {
				System.out.println(row.getCell(j).getCellType());
				data[i-1][j]=row.getCell(j).toString();
				System.out.println(row.getCell(j).getCellType().toString());
				
			}
		}
		book.close();
		System.out.print(Arrays.deepToString(data));
		return data;
	}
}
