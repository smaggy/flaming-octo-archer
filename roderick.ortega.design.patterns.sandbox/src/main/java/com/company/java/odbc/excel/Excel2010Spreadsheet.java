package com.company.java.odbc.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Excel2010Spreadsheet {
	
	public void read() throws FileNotFoundException, IOException, InvalidFormatException {
		File file = new File("./Resources/Excel2010/TestSampleData.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheetAt(0);
		Row row = sheet.getRow(0);
		
		System.out.println("ActiveSheetIndex: " + workbook.getActiveSheetIndex());
		System.out.println("Number of Sheets: " + workbook.getNumberOfSheets());
		System.out.println("Sheetname at position 1: " + workbook.getSheetName(0));
		System.out.println("Sheetname at position 2: " + workbook.getSheetName(1));
		System.out.println("Sheetname at position 3: " + workbook.getSheetName(2));
		System.out.println("Sheetname at position 4: " + workbook.getSheetName(3));
		System.out.println("Sheetname at position 5: " + workbook.getSheetName(4));
		
//		System.out.println("Is Write Protected? " + workbook.isWriteProtected());
//		System.out.println("Summary Information - Application Name: " + workbook.getSummaryInformation().getApplicationName());
//		System.out.println("Summary Information - Author: " + workbook.getSummaryInformation().getAuthor());
//		System.out.println("Summary Information - Page Count: " + workbook.getSummaryInformation().getPageCount());
//		System.out.println("Summary Information - Last Saved: " + workbook.getSummaryInformation().getLastSaveDateTime());
//		System.out.println("Summary Information - Title: " + workbook.getSummaryInformation().getTitle());
		
		System.out.println("Beginning Sheet Reads ...");
		System.out.println("Physical Number of Rows: " + sheet.getPhysicalNumberOfRows());
		System.out.println("Get First Row Num: " + sheet.getFirstRowNum());
		System.out.println("Get Last Row Num: " + sheet.getLastRowNum());
		// System.out.println("Get Top Row: " + sheet.getTopRow());
		
		System.out.println("Beginning Row Reads ...");
		System.out.println("Get First Cell Num: " + row.getFirstCellNum());
		System.out.println("Get Last Cell Num: " + row.getLastCellNum());
		System.out.println("Get Physical Number of Cells: " + row.getPhysicalNumberOfCells());
		System.out.println("Get Row Num: " + row.getRowNum());
		// System.out.println("toString: " + row.toString());
		System.out.println("cellIterator: " + row.cellIterator());
		
	}
	
}
