package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseUtility 
{
	Connection con;
public void getDbConnection(String url,String username,String password) throws SQLException
{
	try
	{
Driver driver= new Driver();	
DriverManager.registerDriver(driver);

con=DriverManager.getConnection(url,username,password);
	}
	catch(Exception e) {
		
	}
	
}
public void getDbConnection() throws SQLException
{
	try
	{
Driver driver= new Driver();	
DriverManager.registerDriver(driver);

// there is one Database that is the reason we add hardcoded
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
	}
	catch(Exception e) {
		
	}
	
}
public void closeDbConnection() throws SQLException
{
	try
	{
con.close();
	}
	catch(Exception e)
	{
		// Handle Exception
	}
}

public ResultSet executeConSelectQuery(String query) throws SQLException
{
	ResultSet result=null;
	try
	{
Statement stat=con.createStatement();	

 result =stat.executeQuery(query);
	}
	catch(Exception e)
	{}
return result;
}
public int executeNonselectQuery(String query)
{
	int result=0;
	try {
		Statement stat =con.createStatement();
		result =stat.executeUpdate(query);
	}
	catch(Exception e)
	{
		
	}
	return result;
	}
	


}
