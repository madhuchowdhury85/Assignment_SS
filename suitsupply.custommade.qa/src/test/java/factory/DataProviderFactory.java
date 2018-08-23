package factory;

import dataProvider.ExcelDataProvider;

public class DataProviderFactory 
{
	// Method to create object of ExcelDataProvider class and will return excel
	public static ExcelDataProvider getexcel() 
	{
		// Create an object of ExcelDataProvider class
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;
	}
}
