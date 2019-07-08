package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.RETC067;
import com.training.dao.RealestateDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class RealestateDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<RETC067> list = new RealestateDAO().getquery(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(RETC067 temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getname(); 
			obj[1] = temp.getemail(); 
			obj[2]=temp.getsubject();
			obj[3]=temp.getmessage();
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\Selenium_new_Fresh\\TestDate.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
