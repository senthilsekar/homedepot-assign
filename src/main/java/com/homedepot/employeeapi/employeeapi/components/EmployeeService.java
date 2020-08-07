package com.homedepot.employeeapi.employeeapi.components;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
	
	
	RestTemplate restTemplate = new RestTemplate();
	
	

	
	public Employee[] getEmployees(){
		ResponseEntity<Employee[]> resp = restTemplate.getForEntity("https://hdinterview.herokuapp.com/employees", Employee[].class);
		return resp.getBody();
	}
	
	public Map<String, List<Employee>> getEmployeesGroupedByDepartment() {
		
		ResponseEntity<Employee[]> resp = restTemplate.getForEntity("https://hdinterview.herokuapp.com/employees", Employee[].class);
		 List<Employee> empLst = Arrays.asList(resp.getBody());
		Map<String, List<Employee>> groupedEmployeeMap =  empLst.stream().collect(Collectors.groupingBy(Employee::getDepartment));
		 
		 return groupedEmployeeMap;
	}
	
	public List<Employee> getEmployeesWithEmail() {
		
		ResponseEntity<Employee[]> resp = restTemplate.getForEntity("https://hdinterview.herokuapp.com/employees", Employee[].class);
		
		
		 List<Employee> empLst = Arrays.asList(resp.getBody());
		empLst.stream().forEach(employee -> employee.setEmail(employee.getName().replace(" ", ".")+"@domain.com"));
		 
		 return empLst;
	}

}
