package com.emppayroll;
import java.sql.*;
import java.util.Enumeration;

public class EmpPayrollDBService {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/payroll_service?useSSL=false";
		String uname = "root";
		String pwd ="Dibyesh@3";

		try {
			//mysql driver 
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver is loaded........");		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//getting all drivers in driver manager
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		while(drivers.hasMoreElements()) {
			Driver driver = drivers.nextElement();
			System.out.println("Driver  Name is :" + driver);
		}

		//making connection
		java.sql.Connection connection = null ;
		try {
			connection =DriverManager.getConnection(url, uname, pwd);
			System.out.println("Connection to the DB succsessful............! " + connection);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		} 

		connection.close();
	}

}


