package com.crm.qa.testdata;

import com.crm.qa.util.Xls_Reader;

public class DataFile 
{
	public  Object[][] TestFileData()
	{
		Xls_Reader xl= new Xls_Reader("D:\\Selenium_Class\\testing\\FreeCRMTestData.xlsx");
		int rownumber = xl.getRowCount("contacts");
		int clmnumber = xl.getColumnCount("contacts");
		Object[][] data = new Object[rownumber-1][clmnumber];

		for(int i=2 ; i<=rownumber;i++)
		{
			for(int j=0;j<clmnumber;j++) 
			{
				data[i-2][j] = xl.getCellData("contacts", j, i);
			}
		}
		return data;
			
		}
}