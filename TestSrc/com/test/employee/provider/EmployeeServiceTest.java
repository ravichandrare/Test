package com.test.employee.provider;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.employee.provider.Employee;
import com.employee.provider.EmployeeService;

public class EmployeeServiceTest {
	EmployeeService emp;
	@Test
	public void findEmployeeTest() {
		emp = new EmployeeService();
		assertTrue(emp.findEmployee(3));
		assertFalse(emp.findEmployee(4));
	}
	
	@Test
	public void addEmployeeTest() {
		emp = new EmployeeService();
		Employee emp1 = new Employee(4,"Ravi","Houston");
		Employee emp2 = new Employee(2,"Ravi","Houston");
		assertTrue(emp.addEmployee(emp1));
		assertTrue(emp.findEmployee(4));
		assertFalse(emp.addEmployee(emp2));
		assertFalse(emp.addEmployee(null));
	}
	@Test
	public void findbyNameTest() {
		emp = new EmployeeService();
		Employee emp1 = new Employee(4,"Ravi","Houston");
		emp.addEmployee(emp1);
		ArrayList<Employee> empl = emp.findByName("Ravi");
		assertEquals(1,empl.size());
		ArrayList<Employee> empl1 = emp.findByName("Ravi1");
		assertEquals(1,empl1.size());
	}
	
	@Test
	public void updateEmployeeTest() {
		emp = new EmployeeService();
		assertTrue(emp.updateEmployee(2));
		assertFalse(emp.updateEmployee(0));
		assertFalse(emp.updateEmployee(5));
		
	}
}
