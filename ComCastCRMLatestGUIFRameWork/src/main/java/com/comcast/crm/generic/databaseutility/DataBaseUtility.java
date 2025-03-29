package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.comcast.crm.generic.fileutility.IPathConstatnt;
import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	public Connection conn;
	ResultSet result;

	public void getDBConnection(String url, String userName, String passWord) throws SQLException {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(url, userName, passWord);
		}catch (Exception e) {
		}
	}
	public void getDBConnection() {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(IPathConstatnt.DB_URL,IPathConstatnt.DB_UN,IPathConstatnt.DB_PWD );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void getDBConnectionWIthNinzaHrm() {
		try {
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection(IPathConstatnt.DB_URL,IPathConstatnt.DB_UN,IPathConstatnt.DB_PWD );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeDBconn() {
		try {
			conn.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public ResultSet executeConnSelectQuery(String query) throws SQLException {
		
		try {
			Statement state = conn.createStatement();
			result = state.executeQuery(query);
		}catch (Exception e) {
			// TODO: handle exception
		} 
		return result;
	}
	public int executeConnNonSelectQuery(String query) {
		int result=0;
		try {
			Statement state = conn.createStatement();
			result = state.executeUpdate(query);
		}catch (Exception e) {
			// TODO: handle exception
		} 
		return result;
		
		
	}
}


