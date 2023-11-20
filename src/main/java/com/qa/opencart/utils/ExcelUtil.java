package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	private static Workbook book;
	private static Sheet sheet;
	
	
	public static final String TEST_DATA_SHEET= "C:/Users/Admin/Desktop/openCart.xlsx";
	
	public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		Object data[][]=null;
		
		try {
			FileInputStream ip=new FileInputStream(TEST_DATA_SHEET);
			book=WorkbookFactory.create(ip);
			sheet=book.getSheet(sheetName);
			
			/*data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i=0;i<sheet.getLastRowNum()+1;i++) {
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)	{
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			}*/
			
			data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

			for (int i = 0; i <sheet.getLastRowNum(); i++) {
			    for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
			        data[i][j] = sheet.getRow(i+1).getCell(j).toString();//whatever data getting into excel convert into java string i.e to string
			    }
			}
			
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
	}


}
