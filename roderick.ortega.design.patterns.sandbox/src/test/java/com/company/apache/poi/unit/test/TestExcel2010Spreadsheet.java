package com.company.apache.poi.unit.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;

import com.company.java.odbc.excel.Excel2010Spreadsheet;

public class TestExcel2010Spreadsheet {

	@Before
	public void before() {
		System.out.println("###### NEW TEST ######");
	}
	
	@Test
	public void test01() throws FileNotFoundException, IOException, InvalidFormatException {
		Excel2010Spreadsheet excelSpreadsheet = new Excel2010Spreadsheet();
		excelSpreadsheet.read();
	}
	
	@Test
	public void test02() throws FileNotFoundException, InvalidFormatException, IOException, ClassNotFoundException, SQLException {
		Excel2010Spreadsheet excelSpreadsheet = new Excel2010Spreadsheet();
		excelSpreadsheet.readViaSqlSheet();
	}
	
	@Test
	public void test03() throws FileNotFoundException, InvalidFormatException, IOException, ClassNotFoundException, SQLException {
		Excel2010Spreadsheet excelSpreadsheet = new Excel2010Spreadsheet();
		excelSpreadsheet.readViaSqlSheetWithWhere();
	}
	
}
