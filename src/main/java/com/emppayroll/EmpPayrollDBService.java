package com.emppayroll;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class EmpPayrollDBService {

	//method to get the connection
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
			System.out.println("Driver  Name :" + driver);
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

	//to get the data from DB
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

	//method to update salary
	public void updateSalary() throws Exception
	{
		Connection connection =getConnection();
		String sql="update employee_payroll_table set salary=600000 where name='Dibyesh'";
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
			connection.close();
		}

		catch (SQLException e)
		{
			e.printStackTrace();
		}

	}
	// method to retrieve salary
	public double retrieveSalary() throws Exception {
		Connection connection =getConnection();
		Statement st = connection.createStatement();
		ResultSet rs  = st.executeQuery("select salary from employee_payroll_table where name = 'Dibyesh' ");
		double salary = 0 ;
		while(rs.next()) {


			salary  = rs.getInt("salary");

		}
		System.out.println(salary);

		return salary;

	}

	// prepared statement query
	public void preparedStatementForEmployeeData() throws Exception{
		try {
			Connection connection = this.getConnection();
			String sql = "update employee_payroll_table set salary=3000000 where name = ?";
			PreparedStatement psmt = connection.prepareStatement(sql);
			psmt.setString(1, "Dibyesh");
			int i = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// method to retrieve data in between a range

	public List<EmployeeInfo> retrieveData_inBetween_Range() throws Exception
	{
		String sql = "select * from employee_payroll_table where start between cast('2018-03-12' as Date ) AND DATE(NOW())";
		List< EmployeeInfo> list=new ArrayList();
		try {
			Connection connection =getConnection();
			Statement statement=connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while( result.next())
			{
				int id=result.getInt("id");
				String name=result.getString("name");
				String gender=result.getString("gender");
				double salary=result.getDouble("salary");
				LocalDate start=result.getDate("start").toLocalDate();
				list.add(new EmployeeInfo(id,name,salary,start));
			}
			System.out.println("\n Retrieved Data In Range Is:");
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	// method to find the sum of salary for group of female employees

	public double sumOf_Salary_Based_on_gender() throws Exception {

		Connection connection =getConnection();
		Statement st = connection.createStatement();
		ResultSet rs  = st.executeQuery("select sum(Salary) from employee_payroll_table where Gender = 'F' group by Gender; ");
		double sum = 0;
		while( rs.next())
		{
			sum =rs.getDouble("sum(Salary)");
		}

		System.out.println(sum);
		return sum;

	}
	// method to find the average of salary for group of female employees
	public double avgOf_Salary_Based_on_gender() throws Exception {

		Connection connection =getConnection();
		Statement st = connection.createStatement();
		ResultSet rs  = st.executeQuery("select avg(Salary) from employee_payroll_table where Gender = 'F' group by Gender; ");
		double avg = 0;
		while( rs.next())
		{
			avg =rs.getDouble("avg(Salary)");
		}

		System.out.println(avg);
		return avg;

	}
	
	//adding new employee into the database
	public void add_new_employee_to_the_Database() throws Exception {
		Connection connection =getConnection();
		String sql="insert into employee_payroll_table (name,salary,gender, start ) VALUES ('Elon', 1888888,'M', '2020-11-12')";
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate(sql);
			connection.close();
		}

		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
}


