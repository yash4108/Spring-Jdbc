package com.mindgate.repository;

import java.util.List;

import org.apache.logging.log4j.message.ObjectArrayMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.Employee;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private static final String SELECT_ALL = "Select * from employee_details";
	private static final String SELECT_ONE = "select * from employee_details where employee_id=?";
	private static final String INSERT_NEW = "insert into employee_details values (?,?,?)";
	private static final String DElETE_ONE = "delete from employee_details where employee_id=? ";
	private static final String UPDATE_ONE = "update employee_details  set name=?,salary=? where employee_id=? ";

	@Override
	public boolean addNewEmployee(Employee employee) {
		Object[] params= {employee.getEmployeeId(),employee.getName(),employee.getSalary()};
	int count=	jdbcTemplate.update(INSERT_NEW, params);
	if (count>0) 
		return true;
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Object[] params= {employee.getName(),employee.getSalary(),employee.getEmployeeId()};
		int count=	jdbcTemplate.update(UPDATE_ONE, params);
		if (count>0) 
			return true;
			return false;
		
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		int count=	jdbcTemplate.update(DElETE_ONE, employeeId);
		if (count>0) 
			return true;
			return false;
		
	}

	@Override
	public Employee getNewEmployee(int employeeId) {
		Employee employee = jdbcTemplate.queryForObject(SELECT_ONE, new EmployeeRowMapper(), employeeId);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
		List<Employee> allEmployees = jdbcTemplate.query(SELECT_ALL, employeeRowMapper);
		return allEmployees;
	}

}
