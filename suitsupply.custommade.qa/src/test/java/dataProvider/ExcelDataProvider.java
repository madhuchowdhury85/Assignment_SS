package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider 
{

	XSSFWorkbook wb;

	// Constructor to load test data file
	public ExcelDataProvider() 
	{
		try 
		{
			// Load workbook with the file in the given location
			wb = new XSSFWorkbook(new FileInputStream(new File("./TestData/SuitSupplyCustomMadeTestData.xlsx")));
		} 
		catch (Exception e) 
		{
			System.out.println("File not found " + e.getMessage());
		}

	}

	// Method to get string data from excel
	public String getstringvalue(String sheet, int row, int column) 
	{
		// Return string value from a specific sheet, row and column in an excel
		return wb.getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
	}

	// Method to get numeric data from excel
	public int getnumericvalue(String sheet, int row, int column) 
	{
		// Return numeric value from a specific sheet, row and column in an excel
		return (int) wb.getSheet(sheet).getRow(row).getCell(column).getNumericCellValue();
	}
}
