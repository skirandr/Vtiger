package com.vtigercrm.genericutils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author shashi
 *
 */
public class Excel_lib {

	/**
	 * Used to fetch the data from excel workbook based on sheet
	 * @param sheet
	 * @param row
	 * @param col
	 * @return
	 * @throws Throwable
	 */
	
	public String fetch_excel_data(String sheet_name , int row , int col) throws Throwable
	{
		FileInputStream fis = new FileInputStream("./test_data/testscript_data.xlsx");
		Workbook wb =WorkbookFactory.create(fis);
		  Sheet sh = wb.getSheet(sheet_name);
		  Row Row = sh.getRow(row);
		  //wb.close();
		  return Row.getCell(col).getStringCellValue();
	}
}



		