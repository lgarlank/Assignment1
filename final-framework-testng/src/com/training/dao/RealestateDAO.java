package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.training.bean.RETC067;
import com.training.connection.GetConnection;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;
import com.training.utility.LoadDBDetails;

public class RealestateDAO {

	Properties properties; 
	
	public RealestateDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<RETC067> getquery(){
		String sql = properties.getProperty("get.TC1"); 
		
		GetConnection gc  = new GetConnection(); 
		List<RETC067> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<RETC067>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				RETC067 temp = new RETC067(); 
				temp.setname(gc.rs1.getString(1));
				temp.setemail(gc.rs1.getString(2));
				temp.setsubject(gc.rs1.getString(3));
				temp.setmessage(gc.rs1.getString(4));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RealestateDAO().getquery().forEach(System.out :: println);
	}
}
