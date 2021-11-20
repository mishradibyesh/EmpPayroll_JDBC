package com.emppayroll;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class EmployeePayrollTest {
	EmpPayrollDBService service = new EmpPayrollDBService();

	@Test
	public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() throws Exception {



		List<EmployeeInfo> list = EmpPayrollDBService.getDataFromDB();

		int actual_size = 6;
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
}
