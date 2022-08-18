package com.mindgate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);
	
		System.out.println("*****delete****");
		Employee employee = new Employee(1, "kapil", 288);
		boolean result=employeeService.deleteEmployee(5);
		if (result) 
			System.out.println("deleted succesfully");
		else
			System.out.println("failed to delete");

		System.out.println("******update*****");
//		Employee employee = new Employee(1, "kapil", 288);
//		boolean result=employeeService.updateEmployee(employee);
//		if (result) 
//			System.out.println("updated succesfully");
//		else
//			System.out.println("failed to update");
		System.out.println("******insert*****");
//		Employee employee = new Employee(1, "kapil", 288);
//		boolean result=employeeService.addNewEmployee(employee);
//		if (result) 
//			System.out.println(" inserted succesfully");
//		else
//			System.out.println("failed to insert");
		System.err.println("*****get one******");
//		Employee employee = employeeService.getNewEmployee(3);
//		System.out.println(employee);
		System.out.println("******get all*****");
		List<Employee> allEmployees = employeeService.getAllEmployees();
		for (Employee employee2 : allEmployees) {
			System.out.println(employee2);
		}

	}

}
