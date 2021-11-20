package com.emppayroll;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class EmployeePayrollTest {

	@Test
	  public void EmployeePayrollDataRetrievedDFromDB_MatchEmployeeCount() throws Exception {
		EmpPayrollDBService addressbookservice = new EmpPayrollDBService();
			
			
		List<EmployeeInfo> list = EmpPayrollDBService.getDataFromDB();
			
			int actual_size = 6;
	        Assert.assertEquals(actual_size , list.size());
	  }
}
