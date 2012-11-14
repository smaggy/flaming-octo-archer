package com.company.apache.poi.unit.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Before;
import org.junit.Test;

import com.company.java.odbc.excel.Excel2003Spreadsheet;

public class TestExcel2003Spreadsheet {
	
	@Before
	public void before() {
		System.out.println("##### NEW TEST #####");
	}
	
	@Test
	public void test01() throws FileNotFoundException, IOException, InvalidFormatException {
		Excel2003Spreadsheet excelSpreadsheet = new Excel2003Spreadsheet();
		excelSpreadsheet.read();
	}
	
	@Test
	public void test02() throws FileNotFoundException, IOException, InvalidFormatException, SQLException, ClassNotFoundException {
		Excel2003Spreadsheet excelSpreadsheet = new Excel2003Spreadsheet();
		excelSpreadsheet.readViaOdbc();
	}
	
	@Test
	public void test05() throws FileNotFoundException, IOException, InvalidFormatException, SQLException, ClassNotFoundException {
		Excel2003Spreadsheet excelSpreadsheet = new Excel2003Spreadsheet();
		excelSpreadsheet.readViaOdbcWithWhere();
	}
	
	@Test
	public void test03() throws ClassNotFoundException, SQLException {
		Excel2003Spreadsheet excelSpreadsheet = new Excel2003Spreadsheet();
		excelSpreadsheet.readViaSqlSheet();
	}
	
	@Test
	public void test04() throws ClassNotFoundException, SQLException {
		Excel2003Spreadsheet excelSpreadsheet = new Excel2003Spreadsheet();
		excelSpreadsheet.readViaSqlSheetWithWhere();
	}
	
}
