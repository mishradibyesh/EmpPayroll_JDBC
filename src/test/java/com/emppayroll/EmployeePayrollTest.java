package com.emppayroll;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class EmployeePayrollTest {
	EmpPayrollDBService service = new EmpPayrollDBService();

	@Test
	public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() throws Exception {



		List<EmployeeInfo> list = EmpPayrollDBService.getDataFromDB();

		int actual_size = 7;
		Assert.assertEquals(actual_size , list.size());
	}
	@Test

	public void matchUpdatedDataToDB() throws Exception {
		int updated_salary =(int) service.retrieveSalary();
		int actual_salary = 600000;
		Assert.assertEquals(updated_salary , actual_salary);

	}

	@Test
	public void matchPreParedUpdatedSalaryDataToDB() throws Exception {
		int updated_salary =(int) service.retrieveSalary();
		int actual_salary = 3000000;
		Assert.assertEquals(updated_salary , actual_salary);
	}

	@Test
	public void retrieveData_betweenRange() throws Exception {
		List<EmployeeInfo> list=  service.retrieveData_inBetween_Range();
		int actual_size = 3;
		Assert.assertEquals(actual_size , list.size());
	}

	@Test
	public void SumOfSalaryTest() throws Exception {
		int updated_salary =(int) service.sumOf_Salary_Based_on_gender();
		int actual_salary = (int) 1.543E8;
		Assert.assertEquals(updated_salary , actual_salary);
	}

	@Test
	public void avgOfSalaryTest() throws Exception {
		int updated_salary =(int) service.avgOf_Salary_Based_on_gender();
		int actual_salary = (int)5.1433333333333336E7;
		Assert.assertEquals(updated_salary , actual_salary);
	}
	
	@Test
	public void AddNewEmployyee() throws Exception {
	service.add_new_employee_to_the_Database();	
	}

}
