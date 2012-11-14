package com.company.java.odbc.excel;

import java.io.File;
//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.hssf.usermodel.HSSFRow;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel2003Spreadsheet {
	
	public void read() throws FileNotFoundException, IOException, InvalidFormatException {
		
		File file = new File("./Resources/Excel2003/TestSampleData.xls");
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
		
//		HSSFSheet sheet = workbook.getSheetAt(0);
		
		System.out.println("Beginning Sheet Reads ...");
		System.out.println("Physical Number of Rows: " + sheet.getPhysicalNumberOfRows());
		System.out.println("Get First Row Num: " + sheet.getFirstRowNum());
		System.out.println("Get Last Row Num: " + sheet.getLastRowNum());
		System.out.println("Get Top Row: " + sheet.getTopRow());
		
//		HSSFRow row = sheet.getRow(0);
		System.out.println("Beginning Row Reads ...");
		System.out.println("Get First Cell Num: " + row.getFirstCellNum());
		System.out.println("Get Last Cell Num: " + row.getLastCellNum());
		System.out.println("Get Physical Number of Cells: " + row.getPhysicalNumberOfCells());
		System.out.println("Get Row Num: " + row.getRowNum());
		System.out.println("toString: " + row.toString());
		System.out.println("cellIterator: " + row.cellIterator());
		
	}
	
	public void readViaOdbc() throws SQLException, ClassNotFoundException {
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String excelFile = "./Resources/Excel2003/TestSampleData.xls";
	    String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + excelFile + ";DriverID=22;READONLY=false;";
	    //String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + excelFile + ";DriverID=790;READONLY=false;";
		//String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + excelFile + ";DriverID=22;Extended Properties='Excel 8.0;HDR=YES;IMEX=1';READONLY=false;";
	    Connection con = DriverManager.getConnection(myDB, "", "");
		
	    Statement stmt = con.createStatement();
	    String excelQuery = "SELECT * FROM [MasterTestScript$]";
	    ResultSet rs = stmt.executeQuery(excelQuery);
	    
	    List<List<String>> table = new ArrayList<List<String>>();
	    
	    ResultSetMetaData rsmd = rs.getMetaData();
	    System.out.println("The Number of Columns From Result Set: " + rsmd.getColumnCount());
	    System.out.println("Result Set was null? " + rs.wasNull());
	    System.out.println("ColumnName for position 0: " + rsmd.getColumnName(1));
	    
	    List<String> header = new ArrayList<String>();
	    for (int j = 0; j < rsmd.getColumnCount() ; j++) {
	    	header.add(rsmd.getColumnName(j+1));
	    }
	    table.add(header);
	    
	    int counter = 0;
	    while (rs.next()) {
	    	List<String> row = new ArrayList<String>();
	    	for (int i = 0; i < rsmd.getColumnCount(); i++) {
	    		row.add(rs.getString(i+1));
	    	}
	    	table.add(row);
	    	counter = counter + 1;
	    }
	    
	    System.out.println("Number of rows: " + counter);
	    System.out.println("Number of rows from table size: " + table.size());
	    System.out.println(table);
	    
	    
	    rs.close();
	    stmt.close();
	    con.close();
	}
	
	public void readViaOdbcWithWhere() throws SQLException, ClassNotFoundException {
		
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		String excelFile = "./Resources/Excel2003/TestSampleData.xls";
	    String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + excelFile + ";DriverID=22;READONLY=false;";
	    //String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + excelFile + ";DriverID=790;READONLY=false;";
		//String myDB = "jdbc:odbc:Driver={Microsoft Excel Driver (*.xls)};DBQ=" + excelFile + ";DriverID=22;Extended Properties='Excel 8.0;HDR=YES;IMEX=1';READONLY=false;";
	    Connection con = DriverManager.getConnection(myDB, "", "");
		
	    Statement stmt = con.createStatement();
	    // String excelQuery = "SELECT * FROM [MasterTestScript$]";
	    String excelQuery = "SELECT * FROM [MasterTestScript$] WHERE DataKey='SampleData03'";
	    ResultSet rs = stmt.executeQuery(excelQuery);
	    
	    List<List<String>> table = new ArrayList<List<String>>();
	    
	    ResultSetMetaData rsmd = rs.getMetaData();
	    System.out.println("The Number of Columns From Result Set: " + rsmd.getColumnCount());
	    System.out.println("Result Set was null? " + rs.wasNull());
	    System.out.println("ColumnName for position 0: " + rsmd.getColumnName(1));
	    
	    List<String> header = new ArrayList<String>();
	    for (int j = 0; j < rsmd.getColumnCount() ; j++) {
	    	header.add(rsmd.getColumnName(j+1));
	    }
	    table.add(header);
	    
	    int counter = 0;
	    while (rs.next()) {
	    	List<String> row = new ArrayList<String>();
	    	for (int i = 0; i < rsmd.getColumnCount(); i++) {
	    		row.add(rs.getString(i+1));
	    	}
	    	table.add(row);
	    	counter = counter + 1;
	    }
	    
	    System.out.println("Number of rows: " + counter);
	    System.out.println("Number of rows from table size: " + table.size());
	    System.out.println(table);
	    
	    
	    rs.close();
	    stmt.close();
	    con.close();
	}
	
	public void readViaSqlSheet() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.googlecode.sqlsheet.Driver");

		Connection writeConnection = DriverManager.getConnection("jdbc:xls:file:./Resources/Excel2003/TestSampleData.xls");

		Statement writeStatement = writeConnection.createStatement();

		ResultSet rs = writeStatement.executeQuery("SELECT * FROM MasterTestScript");
		
	    List<List<String>> table = new ArrayList<List<String>>();
	    
	    ResultSetMetaData rsmd = rs.getMetaData();
	    System.out.println("The Number of Columns From Result Set: " + rsmd.getColumnCount());
	    // System.out.println("Result Set was null? " + rs.wasNull());
	    System.out.println("ColumnName for position 0: " + rsmd.getColumnName(1));
	    
	    List<String> header = new ArrayList<String>();
	    for (int j = 0; j < rsmd.getColumnCount() ; j++) {
	    	header.add(rsmd.getColumnName(j+1));
	    }
	    table.add(header);
	    
	    int counter = 0;
	    while (rs.next()) {
	    	List<String> row = new ArrayList<String>();
	    	for (int i = 0; i < rsmd.getColumnCount(); i++) {
	    		row.add(rs.getString(i+1));
	    	}
	    	table.add(row);
	    	counter = counter + 1;
	    }
	    
	    System.out.println("Number of rows: " + counter);
	    System.out.println("Number of rows from table size: " + table.size());
	    System.out.println(table);

	    rs.close();
		writeStatement.close();
		writeConnection.close();
	}
	
	public void readViaSqlSheetWithWhere() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.googlecode.sqlsheet.Driver");

		Connection writeConnection = DriverManager.getConnection("jdbc:xls:file:./Resources/Excel2003/TestSampleData.xls");

		Statement writeStatement = writeConnection.createStatement();
		
		/**
		 * The following statement does not seem to work.  Execute the test and you will find that it always returns the full table.
		 */
		ResultSet rs = writeStatement.executeQuery("SELECT * FROM MasterTestScript WHERE DataKey=SampleData03");
		
	    List<List<String>> table = new ArrayList<List<String>>();
	    
	    ResultSetMetaData rsmd = rs.getMetaData();
	    System.out.println("The Number of Columns From Result Set: " + rsmd.getColumnCount());
	    // System.out.println("Result Set was null? " + rs.wasNull());
	    System.out.println("ColumnName for position 0: " + rsmd.getColumnName(1));
	    
	    List<String> header = new ArrayList<String>();
	    for (int j = 0; j < rsmd.getColumnCount() ; j++) {
	    	header.add(rsmd.getColumnName(j+1));
	    }
	    table.add(header);
	    
	    int counter = 0;
	    while (rs.next()) {
	    	List<String> row = new ArrayList<String>();
	    	for (int i = 0; i < rsmd.getColumnCount(); i++) {
	    		row.add(rs.getString(i+1));
	    	}
	    	table.add(row);
	    	counter = counter + 1;
	    }
	    
	    System.out.println("Number of rows: " + counter);
	    System.out.println("Number of rows from table size: " + table.size());
	    System.out.println(table);

	    rs.close();
		writeStatement.close();
		writeConnection.close();
	}

}
