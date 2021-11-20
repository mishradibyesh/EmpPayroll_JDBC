package com.emppayroll;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class EmpPayrollDBService {

	public static Connection getConnection() throws Exception  {

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
		return connection; 

	}

	public static List<EmployeeInfo> getDataFromDB() throws Exception {

		Connection connection =getConnection();
		Statement st = connection.createStatement();
		ResultSet rs  = st.executeQuery("select * from employee_payroll_table ");
		List <EmployeeInfo> list = new ArrayList();
		while(rs.next()) {

			int id  =rs.getInt("id");
			String name = rs.getString("name");
			double salary = rs.getDouble("salary");
			LocalDate start=rs.getDate("start").toLocalDate();
			
			EmployeeInfo info = new EmployeeInfo(id, name,salary,start);
			list.add(info);
		}
		System.out.println(list);
		connection.close();
		return list;
	}
}


