package com.emppayroll;

import java.time.LocalDate;
import java.util.Objects;

public class EmployeeInfo {

	public int id;
	public String name;
	public double salary;
	public LocalDate start;

	public EmployeeInfo(int id, String name, double salary, LocalDate start) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.start = start;
	}
	
	public EmployeeInfo() {
	}
	

	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", name=" + name + ", salary=" + salary + ", start=" + start + "]";
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInfo that = (EmployeeInfo) o;
        return id == that.id &&
                Double.compare(that.salary, salary) == 0 &&
                Objects.equals(name, that.name);
    }
}
