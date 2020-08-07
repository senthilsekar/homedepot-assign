package com.homedepot.employeeapi.employeeapi.components;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/Employees")
	public Employee[] getEmployees(){
		//return employeeService.getEmployees();
		
		return employeeService.getEmployees();
		
	}
	
	@RequestMapping("/EmployeesByDepartment")
	public Map<String, List<Employee>> getEmployeesGroupByDepartment(){
		//return employeeService.getEmployees();
		
		return employeeService.getEmployeesGroupedByDepartment();
		
	}

	
	@RequestMapping("/EmployeesWithEmail")
	public List<Employee> getEmployeesWithEmail(){
		//return employeeService.getEmployees();
		
		return employeeService.getEmployeesWithEmail();
		
	}
}
