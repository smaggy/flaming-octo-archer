package com.company.apache.poi.unit.test;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.company.java.odbc.excel.Excel2010Spreadsheet;

public class TestExcel2010Spreadsheet {

	@Test
	public void test01() throws FileNotFoundException, IOException, InvalidFormatException {
		Excel2010Spreadsheet excelSpreadsheet = new Excel2010Spreadsheet();
		excelSpreadsheet.read();
	}
	
}
