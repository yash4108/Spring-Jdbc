package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.Employee;

public interface EmployeeServiceInterface {
	boolean addNewEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	boolean deleteEmployee(int employeeId);

	Employee getNewEmployee(int employeeId);

	List<Employee> getAllEmployees();

}
